package c.m.a;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class q5 implements w3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f23549b;

    public q5(d1 d1Var, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23549b = d1Var;
        this.a = compressFormat;
    }

    @Override // c.m.a.w3
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // c.m.a.w3
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            d1 d1Var = this.f23549b;
            if (!d1Var.j) {
                e1 e1Var = d1Var.f23421e;
                if (e1Var != null) {
                    d1Var.f23419c = bitmap;
                    e1Var.onLoaded();
                    d1.i(this.f23549b, true);
                }
            } else if (d1Var.l.exists()) {
            } else {
                File file = this.f23549b.l;
                m5 m5Var = new m5(this);
                Bitmap.CompressFormat compressFormat = this.a;
                if (file.isDirectory()) {
                    new com.win.opensdk.k0("the specified path points to a directory, should be a file");
                } else if (file.exists()) {
                    new com.win.opensdk.k0("file already exists, write operation cancelled");
                } else {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists() && !parentFile.mkdirs()) {
                        new com.win.opensdk.k0("could not create parent directory");
                        return;
                    }
                    try {
                        if (file.createNewFile()) {
                            new p3(file, bitmap, compressFormat, m5Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        } else {
                            new com.win.opensdk.k0("could not create file");
                        }
                    } catch (IOException e2) {
                        new com.win.opensdk.k0(e2);
                    }
                }
            }
        }
    }

    @Override // c.m.a.w3
    public void a(com.win.opensdk.k0 k0Var) {
        d1 d1Var;
        e1 e1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) || (e1Var = (d1Var = this.f23549b).f23421e) == null || d1Var.j) {
            return;
        }
        e1Var.onFail(PBError.NO_RESUOURCE);
        d1.i(this.f23549b, true);
    }
}
