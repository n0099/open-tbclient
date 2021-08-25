package c.a.o0.a.z1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.i;
import c.a.o0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10017a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10018b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f10019c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f10020d;

    /* renamed from: e  reason: collision with root package name */
    public View f10021e;

    /* renamed from: f  reason: collision with root package name */
    public View f10022f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f10023g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f10024h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f10025i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f10026j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10027e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10027e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10027e.f10021e != null) {
                    if (this.f10027e.f10021e.getParent() != null) {
                        this.f10027e.f10019c.removeView(this.f10027e.f10021e);
                        if (this.f10027e.k != null) {
                            this.f10027e.k.onDismiss();
                            this.f10027e.k = null;
                        }
                    }
                    this.f10027e.f10021e = null;
                }
                if (this.f10027e.m != null) {
                    if (this.f10027e.m.getParent() != null) {
                        this.f10027e.f10019c.removeView(this.f10027e.m);
                    }
                    this.f10027e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10028e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10028e = cVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, RETURN, IF] complete} */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f10028e.l) {
                    if (this.f10028e.m != null && (this.f10028e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f10028e.m.getParent()).removeView(this.f10028e.m);
                    }
                    WindowManager.LayoutParams t = this.f10028e.t();
                    this.f10028e.n = new FrameLayout(this.f10028e.f10018b);
                    this.f10028e.n.setClickable(true);
                    this.f10028e.f10019c.addView(this.f10028e.n, t);
                    this.f10028e.m = this.f10028e.n;
                }
                if (this.f10028e.f10022f != null && (this.f10028e.f10022f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f10028e.f10022f.getParent()).removeView(this.f10028e.f10022f);
                }
                this.f10028e.f10019c.addView(this.f10028e.f10022f, this.f10028e.f10023g);
                this.f10028e.f10021e = this.f10028e.f10022f;
                this.f10028e.f10024h.postDelayed(this.f10028e.f10026j, this.f10028e.f10020d * 1000);
                boolean unused = this.f10028e.f10017a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0484c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10029e;

        public RunnableC0484c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10029e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f10029e.f10021e != null) {
                    if (this.f10029e.f10021e.getParent() != null) {
                        this.f10029e.f10019c.removeViewImmediate(this.f10029e.f10021e);
                    }
                    if (this.f10029e.k != null) {
                        this.f10029e.k.onDismiss();
                        this.f10029e.k = null;
                    }
                    boolean unused = this.f10029e.f10017a;
                    this.f10029e.f10021e = null;
                }
                if (this.f10029e.m != null) {
                    if (this.f10029e.m.getParent() != null) {
                        this.f10029e.f10019c.removeViewImmediate(this.f10029e.m);
                    }
                    boolean unused2 = this.f10029e.f10017a;
                    this.f10029e.m = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10018b = context;
        this.f10019c = (WindowManager) context.getSystemService("window");
        this.f10024h = new Handler(Looper.getMainLooper());
        this.f10026j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f10023g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f10023g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f10020d = 2;
        this.f10017a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f10023g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f10025i;
            if (runnable != null) {
                this.f10024h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f10025i = bVar;
            this.f10024h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f10024h) == null) {
            return;
        }
        handler.post(new RunnableC0484c(this));
        this.f10024h.removeCallbacks(this.f10026j);
        boolean z = this.f10017a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f10018b);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view = this.f10021e;
            return (view == null || view.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f10020d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f10023g) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void y(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void z(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f10022f = view;
            view.setClickable(true);
        }
    }
}
