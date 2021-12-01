package c.p.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class h3 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ o3 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(o3 o3Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o3Var, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = o3Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            int i2 = message.what;
            try {
                if (i2 != 11) {
                    if (i2 == 12) {
                        str = (String) message.obj;
                        context = this.a.a;
                    }
                }
                str = (String) message.obj;
                y2 a = c3.a(this.a.a);
                try {
                    a.f31007b = c3.d("ps", new g3(this.a.f30874b));
                    a.k("co", 2002);
                    a.l("msg", str);
                } catch (JSONException unused) {
                }
                a.m();
                context = this.a.a;
                d3.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
