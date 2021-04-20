package com.baidu.searchbox.bddownload.core.breakpoint.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.exception.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BreakpointSQLiteHelper extends SQLiteOpenHelper {
    public static final String BLOCK_TABLE_NAME = "block";
    public static final String BREAKPOINT_TABLE_NAME = "breakpoint";
    public static final String NAME = "bddownload-breakpoint.db";
    public static final String RESPONSE_FILENAME_TABLE_NAME = "bddownloadResponseFilename";
    public static final String TASK_FILE_DIRTY_TABLE_NAME = "taskFileDirty";
    public static final int VERSION = 3;

    public BreakpointSQLiteHelper(Context context) {
        super(context, NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public static ContentValues toValues(@NonNull BreakpointInfo breakpointInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(breakpointInfo.getId()));
        contentValues.put("url", breakpointInfo.getUrl());
        contentValues.put("etag", breakpointInfo.getEtag());
        contentValues.put(BreakpointSQLiteKey.PARENT_PATH, breakpointInfo.getParentFile().getAbsolutePath());
        contentValues.put("filename", breakpointInfo.getFilename());
        contentValues.put(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH, Integer.valueOf(breakpointInfo.isTaskOnlyProvidedParentPath() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(breakpointInfo.isChunked() ? 1 : 0));
        return contentValues;
    }

    public void insert(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        int blockCount = breakpointInfo.getBlockCount();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < blockCount; i++) {
            BlockInfo block = breakpointInfo.getBlock(i);
            if (writableDatabase.insert(BLOCK_TABLE_NAME, null, toValues(breakpointInfo.getId(), i, block)) == -1) {
                throw new SQLiteException("insert block " + block + " failed!");
            }
        }
        if (writableDatabase.insert(BREAKPOINT_TABLE_NAME, null, toValues(breakpointInfo)) != -1) {
            return;
        }
        throw new SQLiteException("insert info " + breakpointInfo + " failed!");
    }

    public List<Integer> loadDirtyFileList() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("SELECT * FROM taskFileDirty", null);
            while (cursor.moveToNext()) {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public HashMap<String, String> loadResponseFilenameToMap() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = writableDatabase.rawQuery("SELECT * FROM bddownloadResponseFilename", null);
            while (cursor.moveToNext()) {
                hashMap.put(cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex("filename")));
            }
            return hashMap;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public SparseArray<BreakpointInfo> loadToCache() {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList<BreakpointInfoRow> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM breakpoint", null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(new BreakpointInfoRow(rawQuery));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    cursor2 = rawQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursor2 = writableDatabase.rawQuery("SELECT * FROM block", null);
            while (cursor2.moveToNext()) {
                arrayList2.add(new BlockInfoRow(cursor2));
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            SparseArray<BreakpointInfo> sparseArray = new SparseArray<>();
            for (BreakpointInfoRow breakpointInfoRow : arrayList) {
                BreakpointInfo info = breakpointInfoRow.toInfo();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    BlockInfoRow blockInfoRow = (BlockInfoRow) it.next();
                    if (blockInfoRow.getBreakpointId() == info.getId()) {
                        info.addBlock(blockInfoRow.toInfo());
                        it.remove();
                    }
                }
                sparseArray.put(info.getId(), info);
            }
            return sparseArray;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void markFileClear(int i) {
        getWritableDatabase().delete(TASK_FILE_DIRTY_TABLE_NAME, "id = ?", new String[]{String.valueOf(i)});
    }

    public void markFileDirty(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(i));
        writableDatabase.insert(TASK_FILE_DIRTY_TABLE_NAME, null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            sQLiteDatabase.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    public void removeBlock(int i) {
        getWritableDatabase().delete(BLOCK_TABLE_NAME, "breakpoint_id = ?", new String[]{String.valueOf(i)});
    }

    public void removeInfo(int i) {
        getWritableDatabase().delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(i)});
        removeBlock(i);
    }

    public void updateBlockIncrease(@NonNull BreakpointInfo breakpointInfo, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(j));
        getWritableDatabase().update(BLOCK_TABLE_NAME, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(breakpointInfo.getId()), Integer.toString(i)});
    }

    public synchronized void updateFilename(@NonNull String str, @NonNull String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", str);
        contentValues.put("filename", str2);
        Cursor cursor = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery("SELECT filename FROM bddownloadResponseFilename WHERE url = ?", new String[]{str});
            try {
                if (rawQuery.moveToFirst()) {
                    if (!str2.equals(rawQuery.getString(rawQuery.getColumnIndex("filename")))) {
                        writableDatabase.replace(RESPONSE_FILENAME_TABLE_NAME, null, contentValues);
                    }
                } else {
                    writableDatabase.insert(RESPONSE_FILENAME_TABLE_NAME, null, contentValues);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    public void updateInfo(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            cursor = writableDatabase2.rawQuery("SELECT id FROM breakpoint WHERE id =" + breakpointInfo.getId() + " LIMIT 1", null);
            if (cursor.moveToNext()) {
                removeInfo(breakpointInfo.getId());
                insert(breakpointInfo);
                writableDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                writableDatabase.endTransaction();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
        }
    }

    public static ContentValues toValues(int i, int i2, @NonNull BlockInfo blockInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BreakpointSQLiteKey.HOST_ID, Integer.valueOf(i));
        contentValues.put(BreakpointSQLiteKey.BLOCK_INDEX, Integer.valueOf(i2));
        contentValues.put(BreakpointSQLiteKey.START_OFFSET, Long.valueOf(blockInfo.getStartOffset()));
        contentValues.put(BreakpointSQLiteKey.CONTENT_LENGTH, Long.valueOf(blockInfo.getContentLength()));
        contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(blockInfo.getCurrentOffset()));
        return contentValues;
    }
}
