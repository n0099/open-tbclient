package c.a.p0.i2.i;

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
    public int f18805e;

    /* renamed from: f  reason: collision with root package name */
    public long f18806f;

    /* renamed from: g  reason: collision with root package name */
    public long f18807g;

    /* renamed from: h  reason: collision with root package name */
    public b f18808h;

    /* renamed from: i  reason: collision with root package name */
    public long f18809i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f18810j;

    /* renamed from: c.a.p0.i2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0902a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18811a;

        public HandlerC0902a(a aVar) {
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
            this.f18811a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 2) {
                    this.f18811a.f18805e = 0;
                    this.f18811a.f18806f = 0L;
                    this.f18811a.f18807g = 0L;
                } else if (i2 == 1 && this.f18811a.f18805e == 1) {
                    if (this.f18811a.f18808h != null) {
                        this.f18811a.f18808h.a();
                    }
                    this.f18811a.f18805e = 0;
                    this.f18811a.f18806f = 0L;
                    this.f18811a.f18807g = 0L;
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
        this.f18805e = 0;
        this.f18806f = 0L;
        this.f18807g = 0L;
        this.f18809i = 500L;
        this.f18810j = new HandlerC0902a(this);
        this.f18808h = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f18808h == null) {
                    return false;
                }
                int i2 = this.f18805e + 1;
                this.f18805e = i2;
                if (i2 == 1) {
                    this.f18806f = System.currentTimeMillis();
                    this.f18810j.sendEmptyMessageDelayed(1, this.f18809i);
                } else if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f18807g = currentTimeMillis;
                    if (currentTimeMillis - this.f18806f < this.f18809i) {
                        this.f18808h.b();
                    }
                    this.f18810j.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
