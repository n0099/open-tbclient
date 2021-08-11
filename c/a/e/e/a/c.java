package c.a.e.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f2045a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f2046b;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f2047c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, diskFileOperate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2045a = null;
        this.f2046b = null;
        this.f2047c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f2045a = bVar;
            this.f2047c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, diskFileOperateArr)) == null) {
            this.f2046b = new e(this.f2045a, this.f2047c);
            this.f2046b.b();
            return this.f2047c;
        }
        return (DiskFileOperate) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, diskFileOperate) == null) {
            super.onPostExecute(diskFileOperate);
            if (diskFileOperate != null) {
                this.f2047c.callback(diskFileOperate.isSuccess());
            } else {
                this.f2047c.callback(false);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancel();
            if (this.f2046b != null) {
                this.f2046b.c();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPreCancel();
            this.f2047c.callback(false);
        }
    }
}
