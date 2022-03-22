package c.a.p0.w2.j;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f19875b;

    /* renamed from: c  reason: collision with root package name */
    public long f19876c;

    /* renamed from: d  reason: collision with root package name */
    public b f19877d;

    /* renamed from: e  reason: collision with root package name */
    public long f19878e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f19879f;

    /* renamed from: c.a.p0.w2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1495a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC1495a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i == 2) {
                    this.a.a = 0;
                    this.a.f19875b = 0L;
                    this.a.f19876c = 0L;
                } else if (i == 1 && this.a.a == 1) {
                    if (this.a.f19877d != null) {
                        this.a.f19877d.a();
                    }
                    this.a.a = 0;
                    this.a.f19875b = 0L;
                    this.a.f19876c = 0L;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f19875b = 0L;
        this.f19876c = 0L;
        this.f19878e = 500L;
        this.f19879f = new HandlerC1495a(this);
        this.f19877d = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                if (this.f19877d == null) {
                    return false;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == 1) {
                    this.f19875b = System.currentTimeMillis();
                    this.f19879f.sendEmptyMessageDelayed(1, this.f19878e);
                } else if (i == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f19876c = currentTimeMillis;
                    if (currentTimeMillis - this.f19875b < this.f19878e) {
                        this.f19877d.b();
                    }
                    this.f19879f.sendEmptyMessage(2);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
