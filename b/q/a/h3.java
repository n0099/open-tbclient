package b.q.a;

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
/* loaded from: classes6.dex */
public class h3 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o3 f33335a;

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
        this.f33335a = o3Var;
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
                        context = this.f33335a.f33427a;
                    }
                }
                str = (String) message.obj;
                y2 a2 = c3.a(this.f33335a.f33427a);
                try {
                    a2.f33579b = c3.d("ps", new g3(this.f33335a.f33428b));
                    a2.k("co", 2002);
                    a2.l("msg", str);
                } catch (JSONException unused) {
                }
                a2.m();
                context = this.f33335a.f33427a;
                d3.a(context, Uri.parse(str));
            } catch (Exception unused2) {
            }
        }
    }
}
