package c.a.n0.a.p2;

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

    /* renamed from: a  reason: collision with root package name */
    public int f7731a;

    /* renamed from: b  reason: collision with root package name */
    public int f7732b;

    /* renamed from: c  reason: collision with root package name */
    public View f7733c;

    /* renamed from: d  reason: collision with root package name */
    public int f7734d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.p2.a f7735e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7737f;

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
            this.f7737f = bVar;
            this.f7736e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7737f.f7735e != null) {
                    this.f7737f.f7735e.c(this.f7736e);
                }
                Rect rect = new Rect();
                this.f7737f.f7733c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7737f.f7734d == this.f7737f.f7731a) {
                    this.f7737f.f7734d = height;
                } else if (this.f7737f.f7734d == height) {
                } else {
                    if (this.f7737f.f7734d - height > this.f7737f.f7732b) {
                        if (this.f7737f.f7735e != null) {
                            this.f7737f.f7735e.b(this.f7736e, this.f7737f.f7734d - height);
                        }
                        this.f7737f.f7734d = height;
                    } else if (height - this.f7737f.f7734d > this.f7737f.f7732b) {
                        if (this.f7737f.f7735e != null) {
                            this.f7737f.f7735e.a(this.f7736e, height - this.f7737f.f7734d);
                        }
                        this.f7737f.f7734d = height;
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
        this.f7731a = 0;
        this.f7732b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f7733c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f7735e = aVar;
        }
    }
}
