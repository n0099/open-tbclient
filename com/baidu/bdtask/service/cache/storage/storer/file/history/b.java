package com.baidu.bdtask.service.cache.storage.storer.file.history;

import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.xu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/storer/file/history/FileV1StorageUpgrade;", "Lkotlin/Any;", "Ljava/io/File;", "lastStorageFile", "", "onProcessV1StorageFile", "(Ljava/io/File;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface b {

    @Metadata(bv = {1, 0, 2}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(b bVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, bVar, file) == null) {
                try {
                    File a = com.baidu.bdtask.service.cache.storage.storer.file.history.a.a.a();
                    if (a == null || !a.exists()) {
                        return;
                    }
                    if (file.exists()) {
                        a.delete();
                        return;
                    }
                    FilesKt__UtilsKt.copyTo$default(a, file, false, 0, 6, null);
                    a.delete();
                    DebugTrace.a.c(FileV1StorageUpgrade$onProcessV1StorageFile$1.INSTANCE);
                    xu.c.a();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
