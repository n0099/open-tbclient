package c.a.t0.s2.s;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f23107e;

    /* renamed from: f  reason: collision with root package name */
    public long f23108f;

    /* renamed from: g  reason: collision with root package name */
    public long f23109g;

    /* renamed from: h  reason: collision with root package name */
    public b f23110h;

    /* renamed from: i  reason: collision with root package name */
    public long f23111i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f23112j;

    /* renamed from: c.a.t0.s2.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1374a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC1374a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.a.f23107e = 0;
                    this.a.f23108f = 0L;
                    this.a.f23109g = 0L;
                } else if (i2 == 1 && this.a.f23107e == 1) {
                    if (this.a.f23110h != null) {
                        this.a.f23110h.a();
                    }
                    this.a.f23107e = 0;
                    this.a.f23108f = 0L;
                    this.a.f23109g = 0L;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23107e = 0;
        this.f23108f = 0L;
        this.f23109g = 0L;
        this.f23111i = 500L;
        this.f23112j = new HandlerC1374a(this);
        this.f23110h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f23110h == null) {
                    return false;
                }
                int i2 = this.f23107e + 1;
                this.f23107e = i2;
                if (i2 == 1) {
                    this.f23108f = System.currentTimeMillis();
                    this.f23112j.sendEmptyMessageDelayed(1, this.f23111i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f23109g = currentTimeMillis;
                    if (currentTimeMillis - this.f23108f < this.f23111i) {
                        this.f23110h.b();
                    }
                    this.f23112j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
