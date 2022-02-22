package c.a.u0.u2.s;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f23247e;

    /* renamed from: f  reason: collision with root package name */
    public long f23248f;

    /* renamed from: g  reason: collision with root package name */
    public long f23249g;

    /* renamed from: h  reason: collision with root package name */
    public b f23250h;

    /* renamed from: i  reason: collision with root package name */
    public long f23251i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f23252j;

    /* renamed from: c.a.u0.u2.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1424a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC1424a(a aVar) {
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
                    this.a.f23247e = 0;
                    this.a.f23248f = 0L;
                    this.a.f23249g = 0L;
                } else if (i2 == 1 && this.a.f23247e == 1) {
                    if (this.a.f23250h != null) {
                        this.a.f23250h.a();
                    }
                    this.a.f23247e = 0;
                    this.a.f23248f = 0L;
                    this.a.f23249g = 0L;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f23247e = 0;
        this.f23248f = 0L;
        this.f23249g = 0L;
        this.f23251i = 500L;
        this.f23252j = new HandlerC1424a(this);
        this.f23250h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f23250h == null) {
                    return false;
                }
                int i2 = this.f23247e + 1;
                this.f23247e = i2;
                if (i2 == 1) {
                    this.f23248f = System.currentTimeMillis();
                    this.f23252j.sendEmptyMessageDelayed(1, this.f23251i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f23249g = currentTimeMillis;
                    if (currentTimeMillis - this.f23248f < this.f23251i) {
                        this.f23250h.b();
                    }
                    this.f23252j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
