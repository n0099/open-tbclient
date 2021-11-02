package b.a.r0.k0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f18596a;

    /* renamed from: b  reason: collision with root package name */
    public float f18597b;

    /* renamed from: c  reason: collision with root package name */
    public float f18598c;

    /* renamed from: d  reason: collision with root package name */
    public float f18599d;

    /* renamed from: e  reason: collision with root package name */
    public b f18600e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f18601f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f18602g;

    /* renamed from: b.a.r0.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0941a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18603e;

        public C0941a(a aVar) {
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
            this.f18603e = aVar;
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
                    this.f18603e.f18600e.a(i2, i3);
                    return true;
                } else if (i4 == 1) {
                    this.f18603e.f18600e.b(i2, i3);
                    return true;
                } else if (i4 == 2) {
                    this.f18603e.f18600e.d(i2, i3);
                    return true;
                } else if (i4 != 3) {
                    return false;
                } else {
                    this.f18603e.f18600e.c(i2, i3);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
        this.f18601f = new C0941a(this);
        this.f18602g = new Handler(this.f18601f);
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.f18602g.removeMessages(2);
            if (this.f18602g.hasMessages(2)) {
                return;
            }
            Message message = new Message();
            message.what = 2;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f18602g.sendMessageDelayed(message, 60L);
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
                        if (this.f18598c == 0.0f || this.f18599d == 0.0f) {
                            this.f18598c = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            this.f18599d = rawY2;
                            this.f18596a = this.f18598c;
                            this.f18597b = rawY2;
                        }
                        int i2 = (int) (rawY - this.f18597b);
                        int i3 = (int) (rawY - this.f18599d);
                        if (this.f18600e != null) {
                            if (i2 > 0) {
                                e(i3, i2);
                            } else {
                                g(i3, i2);
                            }
                        }
                        this.f18596a = rawX;
                        this.f18597b = rawY;
                    }
                }
                if (this.f18600e != null) {
                    int i4 = (int) (this.f18596a - this.f18598c);
                    int i5 = (int) (this.f18597b - this.f18599d);
                    if (Math.abs(i4) >= Math.abs(i5)) {
                        f(i4, (int) this.f18598c);
                    } else {
                        b(i4, i5);
                    }
                }
                this.f18598c = 0.0f;
                this.f18599d = 0.0f;
            } else {
                this.f18598c = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                this.f18599d = rawY3;
                this.f18596a = this.f18598c;
                this.f18597b = rawY3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f18600e = bVar;
        }
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f18602g.removeMessages(0);
            if (this.f18602g.hasMessages(1)) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f18602g.sendMessageDelayed(message, 60L);
        }
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.f18602g.removeMessages(3);
            if (this.f18602g.hasMessages(3)) {
                return;
            }
            Message message = new Message();
            message.what = 3;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f18602g.sendMessageDelayed(message, 60L);
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f18602g.removeMessages(1);
            if (this.f18602g.hasMessages(0)) {
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f18602g.sendMessageDelayed(message, 60L);
        }
    }
}
