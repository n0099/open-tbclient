package c.p.a;

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
/* loaded from: classes9.dex */
public class v5 implements b4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Bitmap.CompressFormat a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f31350b;

    public v5(d1 d1Var, Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var, compressFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31350b = d1Var;
        this.a = compressFormat;
    }

    @Override // c.p.a.b4
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // c.p.a.b4
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            d1 d1Var = this.f31350b;
            if (!d1Var.f31143j) {
                e1 e1Var = d1Var.f31138e;
                if (e1Var != null) {
                    d1Var.f31136c = bitmap;
                    e1Var.onLoaded();
                    d1.i(this.f31350b, true);
                }
            } else if (d1Var.l.exists()) {
            } else {
                File file = this.f31350b.l;
                r5 r5Var = new r5(this);
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
                            new u3(file, bitmap, compressFormat, r5Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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

    @Override // c.p.a.b4
    public void a(com.win.opensdk.k0 k0Var) {
        d1 d1Var;
        e1 e1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k0Var) == null) || (e1Var = (d1Var = this.f31350b).f31138e) == null || d1Var.f31143j) {
            return;
        }
        e1Var.onFail(PBError.NO_RESUOURCE);
        d1.i(this.f31350b, true);
    }
}
