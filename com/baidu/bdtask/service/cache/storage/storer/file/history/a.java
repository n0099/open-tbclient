package com.baidu.bdtask.service.cache.storage.storer.file.history;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.ct;
import com.baidu.tieba.cv;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/storer/file/history/FileStorageHelper;", "", "getStorageDir", "()Ljava/lang/String;", "version", "Ljava/io/File;", "getStorageFile", "(Ljava/lang/String;)Ljava/io/File;", "getStorageFileName", "(Ljava/lang/String;)Ljava/lang/String;", "getStorageV1File", "()Ljava/io/File;", "VERSION_NAME_1", "Ljava/lang/String;", "VERSION_NAME_2", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109489345, "Lcom/baidu/bdtask/service/cache/storage/storer/file/history/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-109489345, "Lcom/baidu/bdtask/service/cache/storage/storer/file/history/a;");
                return;
            }
        }
        a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return c("v1");
        }
        return (File) invokeV.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return "info" + str + ".storage";
        }
        return (String) invokeL.objValue;
    }

    public final File c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return new File(d(), b(str));
            } catch (Throwable th) {
                DebugTrace.a.c(new Function0<String>(th) { // from class: com.baidu.bdtask.service.cache.storage.storer.file.history.FileStorageHelper$getStorageFile$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Throwable $throwAble;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {th};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$throwAble = th;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "FileStorageUpgradeHelper can not create storageFile  by " + this.$throwAble.getMessage();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        ct h;
        Context appContext;
        File filesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cv v = BDPTask.m.v();
            String str = (v == null || (h = v.h()) == null || (appContext = h.getAppContext()) == null || (filesDir = appContext.getFilesDir()) == null || (str = filesDir.getAbsolutePath()) == null) ? "" : "";
            return str + File.separator + "bdptask" + File.separator + "storage";
        }
        return (String) invokeV.objValue;
    }
}
