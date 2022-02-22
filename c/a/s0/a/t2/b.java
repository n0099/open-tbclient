package c.a.s0.a.t2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f9122b;

    /* renamed from: c  reason: collision with root package name */
    public View f9123c;

    /* renamed from: d  reason: collision with root package name */
    public int f9124d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.a.t2.a f9125e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9127f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9127f = bVar;
            this.f9126e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9127f.f9125e != null) {
                    this.f9127f.f9125e.c(this.f9126e);
                }
                Rect rect = new Rect();
                this.f9127f.f9123c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f9127f.f9124d == this.f9127f.a) {
                    this.f9127f.f9124d = height;
                } else if (this.f9127f.f9124d == height) {
                } else {
                    if (this.f9127f.f9124d - height > this.f9127f.f9122b) {
                        if (this.f9127f.f9125e != null) {
                            this.f9127f.f9125e.b(this.f9126e, this.f9127f.f9124d - height);
                        }
                        this.f9127f.f9124d = height;
                    } else if (height - this.f9127f.f9124d > this.f9127f.f9122b) {
                        if (this.f9127f.f9125e != null) {
                            this.f9127f.f9125e.a(this.f9126e, height - this.f9127f.f9124d);
                        }
                        this.f9127f.f9124d = height;
                    }
                }
            }
        }
    }

    public b(String str, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f9122b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f9123c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.s0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.s0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f9125e = aVar;
        }
    }
}
