package b.q.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s0 f33432a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(s0 s0Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s0Var, looper};
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
        this.f33432a = s0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1101) {
                return;
            }
            this.f33432a.f33468e.removeMessages(1101);
            s0 s0Var = this.f33432a;
            if (!s0Var.f33465b && s0Var.b(s0Var.f33464a)) {
                p0 p0Var = this.f33432a.f33466c;
                if (p0Var != null) {
                    p0Var.a();
                }
                this.f33432a.f33465b = true;
                return;
            }
            this.f33432a.f33468e.sendEmptyMessageDelayed(1101, 300L);
        }
    }
}
