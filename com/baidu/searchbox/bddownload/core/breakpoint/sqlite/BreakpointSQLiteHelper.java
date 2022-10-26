package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.exception.SQLiteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BreakpointSQLiteHelper extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BLOCK_TABLE_NAME = "block";
    public static final String BREAKPOINT_TABLE_NAME = "breakpoint";
    public static final String NAME = "bddownload-breakpoint.db";
    public static final String RESPONSE_FILENAME_TABLE_NAME = "bddownloadResponseFilename";
    public static final String TASK_FILE_DIRTY_TABLE_NAME = "taskFileDirty";
    public static final int VERSION = 3;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, i, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreakpointSQLiteHelper(Context context) {
        super(context, NAME, (SQLiteDatabase.CursorFactory) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    public void updateInfo(BreakpointInfo breakpointInfo) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, breakpointInfo) == null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = writableDatabase.rawQuery("SELECT id FROM breakpoint WHERE id =" + breakpointInfo.getId() + " LIMIT 1", null);
                if (!cursor.moveToNext()) {
                    return;
                }
                removeInfo(writableDatabase, breakpointInfo.getId());
                insert(writableDatabase, breakpointInfo);
                writableDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
                writableDatabase.endTransaction();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                writableDatabase.endTransaction();
            }
        }
    }

    public static ContentValues toValues(int i, int i2, BlockInfo blockInfo) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, null, i, i2, blockInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BreakpointSQLiteKey.HOST_ID, Integer.valueOf(i));
            contentValues.put(BreakpointSQLiteKey.BLOCK_INDEX, Integer.valueOf(i2));
            contentValues.put(BreakpointSQLiteKey.START_OFFSET, Long.valueOf(blockInfo.getStartOffset()));
            contentValues.put(BreakpointSQLiteKey.CONTENT_LENGTH, Long.valueOf(blockInfo.getContentLength()));
            contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(blockInfo.getCurrentOffset()));
            return contentValues;
        }
        return (ContentValues) invokeIIL.objValue;
    }

    public void updateBlockIncrease(BreakpointInfo breakpointInfo, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{breakpointInfo, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(j));
            getWritableDatabase().update(BLOCK_TABLE_NAME, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(breakpointInfo.getId()), Integer.toString(i)});
        }
    }

    public static ContentValues toValues(BreakpointInfo breakpointInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, breakpointInfo)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(breakpointInfo.getId()));
            contentValues.put("url", breakpointInfo.getUrl());
            contentValues.put("etag", breakpointInfo.getEtag());
            contentValues.put(BreakpointSQLiteKey.MIME_TYPE, breakpointInfo.getMimeType());
            contentValues.put(BreakpointSQLiteKey.PARENT_PATH, breakpointInfo.getParentFile().getAbsolutePath());
            contentValues.put(BreakpointSQLiteKey.FILENAME, breakpointInfo.getFilename());
            contentValues.put(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH, Integer.valueOf(breakpointInfo.isTaskOnlyProvidedParentPath() ? 1 : 0));
            contentValues.put("chunked", Integer.valueOf(breakpointInfo.isChunked() ? 1 : 0));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public void insert(BreakpointInfo breakpointInfo) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, breakpointInfo) == null) {
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
    }

    public void insert(SQLiteDatabase sQLiteDatabase, BreakpointInfo breakpointInfo) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sQLiteDatabase, breakpointInfo) == null) {
            int blockCount = breakpointInfo.getBlockCount();
            for (int i = 0; i < blockCount; i++) {
                BlockInfo block = breakpointInfo.getBlock(i);
                if (sQLiteDatabase.insert(BLOCK_TABLE_NAME, null, toValues(breakpointInfo.getId(), i, block)) == -1) {
                    throw new SQLiteException("insert block " + block + " failed!");
                }
            }
            if (sQLiteDatabase.insert(BREAKPOINT_TABLE_NAME, null, toValues(breakpointInfo)) != -1) {
                return;
            }
            throw new SQLiteException("insert info " + breakpointInfo + " failed!");
        }
    }

    public synchronized void updateFilename(String str, String str2) {
        Cursor rawQuery;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            synchronized (this) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("url", str);
                contentValues.put(BreakpointSQLiteKey.FILENAME, str2);
                Cursor cursor = null;
                try {
                    rawQuery = writableDatabase.rawQuery("SELECT filename FROM bddownloadResponseFilename WHERE url = ?", new String[]{str});
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (rawQuery.moveToFirst()) {
                        if (!str2.equals(rawQuery.getString(rawQuery.getColumnIndex(BreakpointSQLiteKey.FILENAME)))) {
                            writableDatabase.replace(RESPONSE_FILENAME_TABLE_NAME, null, contentValues);
                        }
                    } else {
                        writableDatabase.insert(RESPONSE_FILENAME_TABLE_NAME, null, contentValues);
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    public List loadDirtyFileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    public HashMap loadResponseFilenameToMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                cursor = writableDatabase.rawQuery("SELECT * FROM bddownloadResponseFilename", null);
                while (cursor.moveToNext()) {
                    hashMap.put(cursor.getString(cursor.getColumnIndex("url")), cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
                }
                return hashMap;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return (HashMap) invokeV.objValue;
    }

    public SparseArray loadToCache() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                SparseArray sparseArray = new SparseArray();
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
        } else {
            return (SparseArray) invokeV.objValue;
        }
    }

    public void markFileClear(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            getWritableDatabase().delete(TASK_FILE_DIRTY_TABLE_NAME, "id = ?", new String[]{String.valueOf(i)});
        }
    }

    public void markFileDirty(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("id", Integer.valueOf(i));
            writableDatabase.insert(TASK_FILE_DIRTY_TABLE_NAME, null, contentValues);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, MIME_type VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
            super.onOpen(sQLiteDatabase);
            if (Build.VERSION.SDK_INT >= 16) {
                setWriteAheadLoggingEnabled(true);
            } else {
                sQLiteDatabase.enableWriteAheadLogging();
            }
        }
    }

    public void removeBlock(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            getWritableDatabase().delete(BLOCK_TABLE_NAME, "breakpoint_id = ?", new String[]{String.valueOf(i)});
        }
    }

    public void removeInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            getWritableDatabase().delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(i)});
            removeBlock(i);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, sQLiteDatabase, i, i2) == null) {
            if (i == 1 && i2 == 2) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bddownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
            }
            if (i <= 2) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
            }
        }
    }

    public void removeBlock(SQLiteDatabase sQLiteDatabase, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, sQLiteDatabase, i) == null) {
            sQLiteDatabase.delete(BLOCK_TABLE_NAME, "breakpoint_id = ?", new String[]{String.valueOf(i)});
        }
    }

    public void removeInfo(SQLiteDatabase sQLiteDatabase, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, sQLiteDatabase, i) == null) {
            sQLiteDatabase.delete(BREAKPOINT_TABLE_NAME, "id = ?", new String[]{String.valueOf(i)});
            removeBlock(sQLiteDatabase, i);
        }
    }
}
