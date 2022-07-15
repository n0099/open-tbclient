package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rb;
import com.repackage.rr4;
import com.repackage.ub;
import java.io.File;
/* loaded from: classes3.dex */
public class ImagesInvalidService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELAY_TIMES = 10000;
    public static final long FILE_VALID_TIME = 259200000;
    public static final int START_SERVICE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public DiskFileOperate mDiskFileOperate;

    /* loaded from: classes3.dex */
    public static class a extends DiskFileOperate implements rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                rr4.stopService();
                ImagesInvalidReceiver.broadcast(z);
            }
        }

        @Override // com.repackage.rb
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file != null && file.lastModified() + ImagesInvalidService.FILE_VALID_TIME < System.currentTimeMillis() : invokeL.booleanValue;
        }
    }

    public ImagesInvalidService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDiskFileOperate = null;
    }

    public static void setSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            rr4.e(z);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mDiskFileOperate = new a("images", null, DiskFileOperate.Action.DELETE_FILES);
            ub.f().a(this.mDiskFileOperate);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            ub.f().d(this.mDiskFileOperate);
            this.mDiskFileOperate = null;
        }
    }
}
