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
    public int f22470e;

    /* renamed from: f  reason: collision with root package name */
    public long f22471f;

    /* renamed from: g  reason: collision with root package name */
    public long f22472g;

    /* renamed from: h  reason: collision with root package name */
    public b f22473h;

    /* renamed from: i  reason: collision with root package name */
    public long f22474i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f22475j;

    /* renamed from: c.a.t0.s2.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1389a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC1389a(a aVar) {
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
                    this.a.f22470e = 0;
                    this.a.f22471f = 0L;
                    this.a.f22472g = 0L;
                } else if (i2 == 1 && this.a.f22470e == 1) {
                    if (this.a.f22473h != null) {
                        this.a.f22473h.a();
                    }
                    this.a.f22470e = 0;
                    this.a.f22471f = 0L;
                    this.a.f22472g = 0L;
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
        this.f22470e = 0;
        this.f22471f = 0L;
        this.f22472g = 0L;
        this.f22474i = 500L;
        this.f22475j = new HandlerC1389a(this);
        this.f22473h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f22473h == null) {
                    return false;
                }
                int i2 = this.f22470e + 1;
                this.f22470e = i2;
                if (i2 == 1) {
                    this.f22471f = System.currentTimeMillis();
                    this.f22475j.sendEmptyMessageDelayed(1, this.f22474i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f22472g = currentTimeMillis;
                    if (currentTimeMillis - this.f22471f < this.f22474i) {
                        this.f22473h.b();
                    }
                    this.f22475j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
