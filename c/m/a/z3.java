package c.m.a;

import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.win.opensdk.PBError;
import java.io.File;
/* loaded from: classes3.dex */
public class z3 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23613b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b1 f23614c;

    public z3(b1 b1Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23614c = b1Var;
        this.a = j;
        this.f23613b = str;
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
                b1 b1Var = this.f23614c;
                c1 c1Var = b1Var.f23404c;
                if (c1Var != null && !b1Var.f23406e) {
                    c1Var.onFail(PBError.NO_RESUOURCE);
                    this.f23614c.f23405d = true;
                }
            } else {
                b1 b1Var2 = this.f23614c;
                if (b1Var2.f23404c != null && !b1Var2.f23406e) {
                    file = b1Var2.f23408g;
                    r0.t(bArr, file.getPath(), new v3(this));
                }
            }
            if (bArr != null) {
                b1 b1Var3 = this.f23614c;
                if (b1Var3.f23406e) {
                    b1Var3.f23408g = new File(r0.e(this.f23614c.a) + File.separator + "win" + File.separator + r0.D(this.f23613b) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
                    file2 = this.f23614c.f23408g;
                    r0.t(bArr, file2.getPath(), null);
                }
            }
        }
    }
}
