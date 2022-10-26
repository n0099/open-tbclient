package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BreakpointStoreOnSQLite onSQLiteWrapper;
    public final RemitSyncToDBHelper remitHelper;
    public final BreakpointSQLiteHelper sqLiteHelper;
    public final DownloadStore sqliteCache;

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public BreakpointInfo getAfterCompleted(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return null;
        }
        return (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public RemitStoreOnSQLite(BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {breakpointStoreOnSQLite};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = breakpointStoreOnSQLite.onCache;
        this.sqLiteHelper = breakpointStoreOnSQLite.helper;
    }

    public static void setRemitToDBDelayMillis(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
            if (breakpointStore instanceof RemitStoreOnSQLite) {
                ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i);
                return;
            }
            throw new IllegalStateException("The current store is " + breakpointStore + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.sqLiteHelper.removeInfo(i);
            BreakpointInfo breakpointInfo = this.sqliteCache.get(i);
            if (breakpointInfo != null && breakpointInfo.getFilename() != null && breakpointInfo.getTotalOffset() > 0) {
                this.sqLiteHelper.insert(breakpointInfo);
            }
        }
    }

    public RemitStoreOnSQLite(RemitSyncToDBHelper remitSyncToDBHelper, BreakpointStoreOnSQLite breakpointStoreOnSQLite, DownloadStore downloadStore, BreakpointSQLiteHelper breakpointSQLiteHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitSyncToDBHelper, breakpointStoreOnSQLite, downloadStore, breakpointSQLiteHelper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.remitHelper = remitSyncToDBHelper;
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = downloadStore;
        this.sqLiteHelper = breakpointSQLiteHelper;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo createAndInsert(DownloadTask downloadTask) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadTask)) == null) {
            if (this.remitHelper.isNotFreeToDatabase(downloadTask.getId())) {
                return this.sqliteCache.createAndInsert(downloadTask);
            }
            return this.onSQLiteWrapper.createAndInsert(downloadTask);
        }
        return (BreakpointInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask)) == null) {
            return this.onSQLiteWrapper.findOrCreateId(downloadTask);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.onSQLiteWrapper.get(i);
        }
        return (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public String getResponseFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.onSQLiteWrapper.getResponseFilename(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.onSQLiteWrapper.isFileDirty(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.onSQLiteWrapper.markFileClear(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return this.onSQLiteWrapper.markFileDirty(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.onSQLiteWrapper.onTaskStart(i);
            this.remitHelper.onTaskStart(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.sqliteCache.remove(i);
            this.remitHelper.discard(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.sqLiteHelper.removeInfo(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(BreakpointInfo breakpointInfo) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, breakpointInfo)) == null) {
            if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
                return this.sqliteCache.update(breakpointInfo);
            }
            return this.onSQLiteWrapper.update(breakpointInfo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo)) == null) {
            return this.onSQLiteWrapper.findAnotherInfoFromCompare(downloadTask, breakpointInfo);
        }
        return (BreakpointInfo) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{breakpointInfo, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
                this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i, j);
            } else {
                this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i, j);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, EndCause endCause, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i, endCause, exc) == null) {
            this.sqliteCache.onTaskEnd(i, endCause, exc);
            if (endCause == EndCause.COMPLETED) {
                this.remitHelper.discard(i);
            } else {
                this.remitHelper.endAndEnsureToDB(i);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            SQLiteDatabase writableDatabase = this.sqLiteHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    syncCacheToDB(((Integer) it.next()).intValue());
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }
}
