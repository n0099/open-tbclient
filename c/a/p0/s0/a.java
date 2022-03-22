package c.a.p0.s0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f18127b;

    /* renamed from: c  reason: collision with root package name */
    public float f18128c;

    /* renamed from: d  reason: collision with root package name */
    public float f18129d;

    /* renamed from: e  reason: collision with root package name */
    public b f18130e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f18131f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f18132g;

    /* renamed from: c.a.p0.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1369a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1369a(a aVar) {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.arg1;
                int i2 = message.arg2;
                int i3 = message.what;
                if (i3 == 0) {
                    this.a.f18130e.a(i, i2);
                    return true;
                } else if (i3 == 1) {
                    this.a.f18130e.b(i, i2);
                    return true;
                } else if (i3 == 2) {
                    this.a.f18130e.d(i, i2);
                    return true;
                } else if (i3 != 3) {
                    return false;
                } else {
                    this.a.f18130e.c(i, i2);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);

        void b(int i, int i2);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18131f = new C1369a(this);
        this.f18132g = new Handler(this.f18131f);
    }

    public final void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.f18132g.removeMessages(2);
            if (this.f18132g.hasMessages(2)) {
                return;
            }
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            message.arg2 = i2;
            this.f18132g.sendMessageDelayed(message, 60L);
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
                        if (this.f18128c == 0.0f || this.f18129d == 0.0f) {
                            this.f18128c = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            this.f18129d = rawY2;
                            this.a = this.f18128c;
                            this.f18127b = rawY2;
                        }
                        int i = (int) (rawY - this.f18127b);
                        int i2 = (int) (rawY - this.f18129d);
                        if (this.f18130e != null) {
                            if (i > 0) {
                                e(i2, i);
                            } else {
                                g(i2, i);
                            }
                        }
                        this.a = rawX;
                        this.f18127b = rawY;
                    }
                }
                if (this.f18130e != null) {
                    int i3 = (int) (this.a - this.f18128c);
                    int i4 = (int) (this.f18127b - this.f18129d);
                    if (Math.abs(i3) >= Math.abs(i4)) {
                        f(i3, (int) this.f18128c);
                    } else {
                        b(i3, i4);
                    }
                }
                this.f18128c = 0.0f;
                this.f18129d = 0.0f;
            } else {
                this.f18128c = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                this.f18129d = rawY3;
                this.a = this.f18128c;
                this.f18127b = rawY3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f18130e = bVar;
        }
    }

    public final void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.f18132g.removeMessages(0);
            if (this.f18132g.hasMessages(1)) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.f18132g.sendMessageDelayed(message, 60L);
        }
    }

    public final void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.f18132g.removeMessages(3);
            if (this.f18132g.hasMessages(3)) {
                return;
            }
            Message message = new Message();
            message.what = 3;
            message.arg1 = i;
            message.arg2 = i2;
            this.f18132g.sendMessageDelayed(message, 60L);
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.f18132g.removeMessages(1);
            if (this.f18132g.hasMessages(0)) {
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.f18132g.sendMessageDelayed(message, 60L);
        }
    }
}
