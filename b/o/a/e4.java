package b.o.a;

import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import java.io.File;
/* loaded from: classes6.dex */
public class e4 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f34133a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b1 f34135c;

    public e4(b1 b1Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34135c = b1Var;
        this.f34133a = j;
        this.f34134b = str;
    }

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            String str = ((String[]) objArr)[0];
            if (str != null) {
                try {
                    return r0.F(str);
                } catch (OutOfMemoryError unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                b1 b1Var = this.f34135c;
                c1 c1Var = b1Var.f34086c;
                if (c1Var != null && !b1Var.f34088e) {
                    c1Var.onFail(PBError.NO_RESUOURCE);
                    this.f34135c.f34087d = true;
                }
            } else {
                b1 b1Var2 = this.f34135c;
                if (b1Var2.f34086c != null && !b1Var2.f34088e) {
                    file = b1Var2.f34090g;
                    r0.t(bArr, file.getPath(), new a4(this));
                }
            }
            if (bArr != null) {
                b1 b1Var3 = this.f34135c;
                if (b1Var3.f34088e) {
                    b1Var3.f34090g = new File(r0.e(this.f34135c.f34084a) + File.separator + "win" + File.separator + r0.D(this.f34134b) + ".mp4");
                    file2 = this.f34135c.f34090g;
                    r0.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
