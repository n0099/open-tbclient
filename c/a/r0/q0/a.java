package c.a.r0.q0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f21367b;

    /* renamed from: c  reason: collision with root package name */
    public float f21368c;

    /* renamed from: d  reason: collision with root package name */
    public float f21369d;

    /* renamed from: e  reason: collision with root package name */
    public b f21370e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f21371f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f21372g;

    /* renamed from: c.a.r0.q0.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1257a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21373e;

        public C1257a(a aVar) {
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
            this.f21373e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.arg1;
                int i3 = message.arg2;
                int i4 = message.what;
                if (i4 == 0) {
                    this.f21373e.f21370e.a(i2, i3);
                    return true;
                } else if (i4 == 1) {
                    this.f21373e.f21370e.b(i2, i3);
                    return true;
                } else if (i4 == 2) {
                    this.f21373e.f21370e.d(i2, i3);
                    return true;
                } else if (i4 != 3) {
                    return false;
                } else {
                    this.f21373e.f21370e.c(i2, i3);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i2, int i3);

        void b(int i2, int i3);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21371f = new C1257a(this);
        this.f21372g = new Handler(this.f21371f);
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.f21372g.removeMessages(2);
            if (this.f21372g.hasMessages(2)) {
                return;
            }
            Message message = new Message();
            message.what = 2;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f21372g.sendMessageDelayed(message, 60L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (this.f21368c == 0.0f || this.f21369d == 0.0f) {
                            this.f21368c = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            this.f21369d = rawY2;
                            this.a = this.f21368c;
                            this.f21367b = rawY2;
                        }
                        int i2 = (int) (rawY - this.f21367b);
                        int i3 = (int) (rawY - this.f21369d);
                        if (this.f21370e != null) {
                            if (i2 > 0) {
                                e(i3, i2);
                            } else {
                                g(i3, i2);
                            }
                        }
                        this.a = rawX;
                        this.f21367b = rawY;
                    }
                }
                if (this.f21370e != null) {
                    int i4 = (int) (this.a - this.f21368c);
                    int i5 = (int) (this.f21367b - this.f21369d);
                    if (Math.abs(i4) >= Math.abs(i5)) {
                        f(i4, (int) this.f21368c);
                    } else {
                        b(i4, i5);
                    }
                }
                this.f21368c = 0.0f;
                this.f21369d = 0.0f;
            } else {
                this.f21368c = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                this.f21369d = rawY3;
                this.a = this.f21368c;
                this.f21367b = rawY3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f21370e = bVar;
        }
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f21372g.removeMessages(0);
            if (this.f21372g.hasMessages(1)) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f21372g.sendMessageDelayed(message, 60L);
        }
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.f21372g.removeMessages(3);
            if (this.f21372g.hasMessages(3)) {
                return;
            }
            Message message = new Message();
            message.what = 3;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f21372g.sendMessageDelayed(message, 60L);
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f21372g.removeMessages(1);
            if (this.f21372g.hasMessages(0)) {
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f21372g.sendMessageDelayed(message, 60L);
        }
    }
}
