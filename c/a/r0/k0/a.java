package c.a.r0.k0;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f19639a;

    /* renamed from: b  reason: collision with root package name */
    public float f19640b;

    /* renamed from: c  reason: collision with root package name */
    public float f19641c;

    /* renamed from: d  reason: collision with root package name */
    public float f19642d;

    /* renamed from: e  reason: collision with root package name */
    public b f19643e;

    /* renamed from: f  reason: collision with root package name */
    public Handler.Callback f19644f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f19645g;

    /* renamed from: c.a.r0.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0944a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19646e;

        public C0944a(a aVar) {
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
            this.f19646e = aVar;
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
                    this.f19646e.f19643e.a(i2, i3);
                    return true;
                } else if (i4 == 1) {
                    this.f19646e.f19643e.b(i2, i3);
                    return true;
                } else if (i4 == 2) {
                    this.f19646e.f19643e.d(i2, i3);
                    return true;
                } else if (i4 != 3) {
                    return false;
                } else {
                    this.f19646e.f19643e.c(i2, i3);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
        this.f19644f = new C0944a(this);
        this.f19645g = new Handler(this.f19644f);
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.f19645g.removeMessages(2);
            if (this.f19645g.hasMessages(2)) {
                return;
            }
            Message message = new Message();
            message.what = 2;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f19645g.sendMessageDelayed(message, 60L);
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
                        if (this.f19641c == 0.0f || this.f19642d == 0.0f) {
                            this.f19641c = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            this.f19642d = rawY2;
                            this.f19639a = this.f19641c;
                            this.f19640b = rawY2;
                        }
                        int i2 = (int) (rawY - this.f19640b);
                        int i3 = (int) (rawY - this.f19642d);
                        if (this.f19643e != null) {
                            if (i2 > 0) {
                                e(i3, i2);
                            } else {
                                g(i3, i2);
                            }
                        }
                        this.f19639a = rawX;
                        this.f19640b = rawY;
                    }
                }
                if (this.f19643e != null) {
                    int i4 = (int) (this.f19639a - this.f19641c);
                    int i5 = (int) (this.f19640b - this.f19642d);
                    if (Math.abs(i4) >= Math.abs(i5)) {
                        f(i4, (int) this.f19641c);
                    } else {
                        b(i4, i5);
                    }
                }
                this.f19641c = 0.0f;
                this.f19642d = 0.0f;
            } else {
                this.f19641c = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                this.f19642d = rawY3;
                this.f19639a = this.f19641c;
                this.f19640b = rawY3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f19643e = bVar;
        }
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f19645g.removeMessages(0);
            if (this.f19645g.hasMessages(1)) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f19645g.sendMessageDelayed(message, 60L);
        }
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.f19645g.removeMessages(3);
            if (this.f19645g.hasMessages(3)) {
                return;
            }
            Message message = new Message();
            message.what = 3;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f19645g.sendMessageDelayed(message, 60L);
        }
    }

    public final void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f19645g.removeMessages(1);
            if (this.f19645g.hasMessages(0)) {
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.arg1 = i2;
            message.arg2 = i3;
            this.f19645g.sendMessageDelayed(message, 60L);
        }
    }
}
