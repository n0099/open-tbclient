package b.q.a;

import android.content.Context;
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
public class n5 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f33417a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f33418b;

    public n5(d1 d1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33418b = d1Var;
        this.f33417a = str;
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
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                d1 d1Var = this.f33418b;
                e1 e1Var = d1Var.f33284e;
                if (e1Var != null && !d1Var.j) {
                    e1Var.onFail(PBError.NO_RESUOURCE);
                    this.f33418b.f33288i = true;
                }
            } else {
                d1 d1Var2 = this.f33418b;
                e1 e1Var2 = d1Var2.f33284e;
                if (e1Var2 != null && !d1Var2.j) {
                    d1Var2.m = bArr;
                    e1Var2.onLoaded();
                    this.f33418b.f33288i = true;
                }
            }
            if (bArr != null) {
                d1 d1Var3 = this.f33418b;
                if (d1Var3.j) {
                    StringBuilder sb = new StringBuilder();
                    context = this.f33418b.f33280a;
                    sb.append(r0.e(context));
                    sb.append(File.separator);
                    sb.append("win");
                    sb.append(File.separator);
                    sb.append(r0.D(this.f33417a));
                    sb.append(".gif");
                    d1Var3.p = new File(sb.toString());
                    new Thread(new y(bArr, this.f33418b.p.getPath())).start();
                }
            }
        }
    }
}
