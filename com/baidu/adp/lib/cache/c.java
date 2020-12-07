package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b Lw;
    protected e.b Lx;
    protected e.a Ly;
    protected int dirtyCount;
    protected LinkedList<String> idsToDelete = new LinkedList<>();
    private Object lockForIdsToDelete = new Object();
    protected String tableName;

    protected abstract ContentValues a(g<T> gVar);

    protected abstract g<T> a(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    protected abstract boolean clearData(String str);

    public abstract int getCacheVersion();

    public abstract void onNameSpaceUpgraded(String str, String str2, int i, int i2);

    public abstract String onNewNameSpaceCreated(String str);

    public abstract Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.b bVar) {
        this.Lw = bVar;
    }

    public void a(e eVar, String str) {
        this.tableName = str;
        if (eVar instanceof e.b) {
            this.Lx = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Ly = (e.a) eVar;
        }
    }

    public g<T> bB(String str) {
        try {
            return a(this.Lw.getOpenedDatabase(), str);
        } catch (Throwable th) {
            this.Lw.notifySQLException(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.lockForIdsToDelete) {
                this.idsToDelete.remove(gVar.uniqueKey);
            }
            ContentValues a2 = a(gVar);
            SQLiteDatabase openedDatabase = this.Lw.getOpenedDatabase();
            if (openedDatabase.update(this.tableName, a2, "m_key = ?", new String[]{gVar.uniqueKey}) == 0) {
                openedDatabase.insert(this.tableName, null, a2);
                if (this.Ly != null) {
                    notifyDirtyCountAdded();
                }
            }
            if (this.Lx != null && (e = this.Lx.e(gVar)) != null) {
                deleteCacheItem(e);
            }
        } catch (Throwable th) {
            this.Lw.notifySQLException(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void notifyDirtyCountAdded() {
        if (this.Ly != null) {
            this.dirtyCount++;
            if (this.dirtyCount >= ((int) Math.min(this.Ly.getMaxSize() * 0.2d, 5.0d))) {
                this.dirtyCount = 0;
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.performCleanup();
                    }
                });
            }
        }
    }

    public int deleteCacheItem(String str) {
        try {
            return this.Lw.getOpenedDatabase().delete(this.tableName, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.Lw.notifySQLException(th, "deleteCacheItem");
            return 0;
        }
    }

    public void clearAllForNameSpace(String str) {
        this.dirtyCount = 0;
        synchronized (this.lockForIdsToDelete) {
            this.idsToDelete.clear();
        }
        if (clearData(str)) {
            BdCacheService.lZ().ma().delete(str);
        }
    }

    public synchronized void addItemIdToDeleteList(String str, boolean z) {
        synchronized (this.lockForIdsToDelete) {
            if (!this.idsToDelete.contains(str)) {
                this.idsToDelete.addLast(str);
                if (z) {
                    notifyDirtyCountAdded();
                }
            }
        }
    }

    public void performEvict(String str) {
        if (this.Ly != null) {
            Cursor cursor = null;
            try {
                this.Ly.startEvict();
                cursor = queryAllForNameSpace(this.Lw.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Ly.d(gVar);
                    if (d != null) {
                        addItemIdToDeleteList(d, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.Lw.notifySQLException(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                    this.Ly.finishEvict();
                }
            }
        }
    }

    public void performPump(String str) {
        if (this.Lx != null) {
            Cursor cursor = null;
            try {
                this.Lx.startInit();
                cursor = queryAllForNameSpace(this.Lw.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Lx.f(gVar);
                    if (f != null) {
                        addItemIdToDeleteList(f, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.Lw.notifySQLException(th, "performPump");
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                    this.Lx.finishInit();
                }
            }
        }
    }

    protected void performCleanup() {
        String removeFirst;
        if (!this.idsToDelete.isEmpty()) {
            SQLiteDatabase openedDatabase = this.Lw.getOpenedDatabase();
            openedDatabase.beginTransaction();
            while (true) {
                try {
                    synchronized (this.lockForIdsToDelete) {
                        if (!this.idsToDelete.isEmpty()) {
                            removeFirst = this.idsToDelete.removeFirst();
                        } else {
                            openedDatabase.setTransactionSuccessful();
                            this.dirtyCount = 0;
                            return;
                        }
                    }
                    openedDatabase.delete(this.tableName, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.Lw.notifySQLException(th, "performCleanup");
                        return;
                    } finally {
                        openedDatabase.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b lV() {
        return this.Lw;
    }
}
