package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected final com.baidu.adp.base.a.b Jc;
    protected e.b Jd;
    protected e.a Je;
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
        this.Jc = bVar;
    }

    public void a(e eVar, String str) {
        this.tableName = str;
        if (eVar instanceof e.b) {
            this.Jd = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.Je = (e.a) eVar;
        }
    }

    public g<T> bq(String str) {
        try {
            return a(this.Jc.getOpenedDatabase(), str);
        } catch (Throwable th) {
            this.Jc.notifySQLException(th, "get");
            return null;
        }
    }

    public void b(g<T> gVar) {
        String e;
        try {
            synchronized (this.lockForIdsToDelete) {
                this.idsToDelete.remove(gVar.uniqueKey);
            }
            ContentValues a = a(gVar);
            SQLiteDatabase openedDatabase = this.Jc.getOpenedDatabase();
            if (openedDatabase.update(this.tableName, a, "m_key = ?", new String[]{gVar.uniqueKey}) == 0) {
                openedDatabase.insert(this.tableName, null, a);
                if (this.Je != null) {
                    notifyDirtyCountAdded();
                }
            }
            if (this.Jd != null && (e = this.Jd.e(gVar)) != null) {
                deleteCacheItem(e);
            }
        } catch (Throwable th) {
            this.Jc.notifySQLException(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void notifyDirtyCountAdded() {
        if (this.Je != null) {
            this.dirtyCount++;
            if (this.dirtyCount >= ((int) Math.min(this.Je.getMaxSize() * 0.2d, 5.0d))) {
                this.dirtyCount = 0;
                com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
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
            return this.Jc.getOpenedDatabase().delete(this.tableName, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.Jc.notifySQLException(th, "deleteCacheItem");
            return 0;
        }
    }

    public void clearAllForNameSpace(String str) {
        this.dirtyCount = 0;
        synchronized (this.lockForIdsToDelete) {
            this.idsToDelete.clear();
        }
        if (clearData(str)) {
            BdCacheService.kf().kg().delete(str);
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
        if (this.Je != null) {
            Cursor cursor = null;
            try {
                this.Je.startEvict();
                cursor = queryAllForNameSpace(this.Jc.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.Je.d(gVar);
                    if (d != null) {
                        addItemIdToDeleteList(d, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.Jc.notifySQLException(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                    this.Je.finishEvict();
                }
            }
        }
    }

    public void performPump(String str) {
        if (this.Jd != null) {
            Cursor cursor = null;
            try {
                this.Jd.startInit();
                cursor = queryAllForNameSpace(this.Jc.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.Jd.f(gVar);
                    if (f != null) {
                        addItemIdToDeleteList(f, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.Jc.notifySQLException(th, "performPump");
                } finally {
                    com.baidu.adp.lib.f.a.close(cursor);
                    this.Jd.finishInit();
                }
            }
        }
    }

    protected void performCleanup() {
        String removeFirst;
        if (!this.idsToDelete.isEmpty()) {
            SQLiteDatabase openedDatabase = this.Jc.getOpenedDatabase();
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
                        this.Jc.notifySQLException(th, "performCleanup");
                        return;
                    } finally {
                        openedDatabase.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b kb() {
        return this.Jc;
    }
}
