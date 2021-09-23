package c.a.r0.j2.i;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19702e;

    /* renamed from: f  reason: collision with root package name */
    public long f19703f;

    /* renamed from: g  reason: collision with root package name */
    public long f19704g;

    /* renamed from: h  reason: collision with root package name */
    public b f19705h;

    /* renamed from: i  reason: collision with root package name */
    public long f19706i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f19707j;

    /* renamed from: c.a.r0.j2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0943a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19708a;

        public HandlerC0943a(a aVar) {
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
            this.f19708a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.f19708a.f19702e = 0;
                    this.f19708a.f19703f = 0L;
                    this.f19708a.f19704g = 0L;
                } else if (i2 == 1 && this.f19708a.f19702e == 1) {
                    if (this.f19708a.f19705h != null) {
                        this.f19708a.f19705h.a();
                    }
                    this.f19708a.f19702e = 0;
                    this.f19708a.f19703f = 0L;
                    this.f19708a.f19704g = 0L;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f19702e = 0;
        this.f19703f = 0L;
        this.f19704g = 0L;
        this.f19706i = 500L;
        this.f19707j = new HandlerC0943a(this);
        this.f19705h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f19705h == null) {
                    return false;
                }
                int i2 = this.f19702e + 1;
                this.f19702e = i2;
                if (i2 == 1) {
                    this.f19703f = System.currentTimeMillis();
                    this.f19707j.sendEmptyMessageDelayed(1, this.f19706i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f19704g = currentTimeMillis;
                    if (currentTimeMillis - this.f19703f < this.f19706i) {
                        this.f19705h.b();
                    }
                    this.f19707j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
