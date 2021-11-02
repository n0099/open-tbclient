package b.q.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class g4 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a5 f33326a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g4(a5 a5Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a5Var, looper};
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
        this.f33326a = a5Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            int i2 = message.what;
            a5.h();
            if (i2 == 100101) {
                this.f33326a.j.removeMessages(100101);
                y2 a2 = c3.a(this.f33326a.f33238a);
                g3 g3Var = new g3(null);
                g3Var.f33324a = this.f33326a.f33239b;
                a2.g(g3Var, m2.L(this.f33326a.f33238a) * 1000, 2002, 0);
                a2.m();
                this.f33326a.d(PBError.TIMEOUT);
            }
        }
    }
}
