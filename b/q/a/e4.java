package b.q.a;

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
    public final /* synthetic */ long f33299a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f33300b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b1 f33301c;

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
        this.f33301c = b1Var;
        this.f33299a = j;
        this.f33300b = str;
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
                b1 b1Var = this.f33301c;
                c1 c1Var = b1Var.f33252c;
                if (c1Var != null && !b1Var.f33254e) {
                    c1Var.onFail(PBError.NO_RESUOURCE);
                    this.f33301c.f33253d = true;
                }
            } else {
                b1 b1Var2 = this.f33301c;
                if (b1Var2.f33252c != null && !b1Var2.f33254e) {
                    file = b1Var2.f33256g;
                    r0.t(bArr, file.getPath(), new a4(this));
                }
            }
            if (bArr != null) {
                b1 b1Var3 = this.f33301c;
                if (b1Var3.f33254e) {
                    b1Var3.f33256g = new File(r0.e(this.f33301c.f33250a) + File.separator + "win" + File.separator + r0.D(this.f33300b) + ".mp4");
                    file2 = this.f33301c.f33256g;
                    r0.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
