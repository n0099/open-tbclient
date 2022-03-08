package c.q.a;

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
/* loaded from: classes3.dex */
public class c3 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ j3 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c3(j3 j3Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j3Var, looper};
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
        this.a = j3Var;
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
                t2 a = x2.a(this.a.a);
                try {
                    a.f29126b = x2.d("ps", new b3(this.a.f29003b));
                    a.k("co", 2002);
                    a.l("msg", str);
                } catch (JSONException unused) {
                }
                a.m();
                context = this.a.a;
                y2.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
