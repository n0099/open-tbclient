package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.e;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<T> {
    protected int dirtyCount;
    protected LinkedList<String> idsToDelete = new LinkedList<>();
    private Object lockForIdsToDelete = new Object();
    protected final com.baidu.adp.base.a.b nn;
    protected e.b np;
    protected e.a nq;
    protected String tableName;

    protected abstract ContentValues a(g<T> gVar);

    protected abstract g<T> b(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    protected abstract boolean clearData(String str);

    public abstract int getCacheVersion();

    public abstract void onNameSpaceUpgraded(String str, String str2, int i, int i2);

    public abstract String onNewNameSpaceCreated(String str);

    public abstract Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str);

    public c(com.baidu.adp.base.a.b bVar) {
        this.nn = bVar;
    }

    public void a(e eVar, String str) {
        this.tableName = str;
        if (eVar instanceof e.b) {
            this.np = (e.b) eVar;
        }
        if (eVar instanceof e.a) {
            this.nq = (e.a) eVar;
        }
    }

    public g<T> V(String str) {
        try {
            return b(this.nn.getOpenedDatabase(), str);
        } catch (Throwable th) {
            this.nn.notifySQLException(th, "get");
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
            SQLiteDatabase openedDatabase = this.nn.getOpenedDatabase();
            if (openedDatabase.update(this.tableName, a, "m_key = ?", new String[]{gVar.uniqueKey}) == 0) {
                openedDatabase.insert(this.tableName, null, a);
                if (this.nq != null) {
                    notifyDirtyCountAdded();
                }
            }
            if (this.np != null && (e = this.np.e(gVar)) != null) {
                deleteCacheItem(e);
            }
        } catch (Throwable th) {
            this.nn.notifySQLException(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void notifyDirtyCountAdded() {
        if (this.nq != null) {
            this.dirtyCount++;
            if (this.dirtyCount >= ((int) Math.min(this.nq.getMaxSize() * 0.2d, 5.0d))) {
                this.dirtyCount = 0;
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.c.1
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
            return this.nn.getOpenedDatabase().delete(this.tableName, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.nn.notifySQLException(th, "deleteCacheItem");
            return 0;
        }
    }

    public void clearAllForNameSpace(String str) {
        this.dirtyCount = 0;
        synchronized (this.lockForIdsToDelete) {
            this.idsToDelete.clear();
        }
        if (clearData(str)) {
            BdCacheService.fe().ff().delete(str);
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
        if (this.nq != null) {
            Cursor cursor = null;
            try {
                this.nq.startEvict();
                cursor = queryAllForNameSpace(this.nn.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String d = this.nq.d(gVar);
                    if (d != null) {
                        addItemIdToDeleteList(d, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.nn.notifySQLException(th, "performEvict");
                } finally {
                    com.baidu.adp.lib.g.a.close(cursor);
                    this.nq.finishEvict();
                }
            }
        }
    }

    public void performPump(String str) {
        if (this.np != null) {
            Cursor cursor = null;
            try {
                this.np.startInit();
                cursor = queryAllForNameSpace(this.nn.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    g<?> gVar = new g<>();
                    gVar.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    gVar.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    gVar.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    gVar.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String f = this.np.f(gVar);
                    if (f != null) {
                        addItemIdToDeleteList(f, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.nn.notifySQLException(th, "performPump");
                } finally {
                    com.baidu.adp.lib.g.a.close(cursor);
                    this.np.finishInit();
                }
            }
        }
    }

    protected void performCleanup() {
        String removeFirst;
        if (!this.idsToDelete.isEmpty()) {
            SQLiteDatabase openedDatabase = this.nn.getOpenedDatabase();
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
                        this.nn.notifySQLException(th, "performCleanup");
                        return;
                    } finally {
                        openedDatabase.endTransaction();
                    }
                }
            }
        }
    }

    public com.baidu.adp.base.a.b fa() {
        return this.nn;
    }
}
