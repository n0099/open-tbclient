package c.a.r0.q2.s;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f21589e;

    /* renamed from: f  reason: collision with root package name */
    public long f21590f;

    /* renamed from: g  reason: collision with root package name */
    public long f21591g;

    /* renamed from: h  reason: collision with root package name */
    public b f21592h;

    /* renamed from: i  reason: collision with root package name */
    public long f21593i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f21594j;

    /* renamed from: c.a.r0.q2.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class HandlerC1265a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC1265a(a aVar) {
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
                    this.a.f21589e = 0;
                    this.a.f21590f = 0L;
                    this.a.f21591g = 0L;
                } else if (i2 == 1 && this.a.f21589e == 1) {
                    if (this.a.f21592h != null) {
                        this.a.f21592h.a();
                    }
                    this.a.f21589e = 0;
                    this.a.f21590f = 0L;
                    this.a.f21591g = 0L;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f21589e = 0;
        this.f21590f = 0L;
        this.f21591g = 0L;
        this.f21593i = 500L;
        this.f21594j = new HandlerC1265a(this);
        this.f21592h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f21592h == null) {
                    return false;
                }
                int i2 = this.f21589e + 1;
                this.f21589e = i2;
                if (i2 == 1) {
                    this.f21590f = System.currentTimeMillis();
                    this.f21594j.sendEmptyMessageDelayed(1, this.f21593i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f21591g = currentTimeMillis;
                    if (currentTimeMillis - this.f21590f < this.f21593i) {
                        this.f21592h.b();
                    }
                    this.f21594j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
