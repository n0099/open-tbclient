package c.a.p0.a.t2;

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
    public int f8034b;

    /* renamed from: c  reason: collision with root package name */
    public View f8035c;

    /* renamed from: d  reason: collision with root package name */
    public int f8036d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.t2.a f8037e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8039f;

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
            this.f8039f = bVar;
            this.f8038e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8039f.f8037e != null) {
                    this.f8039f.f8037e.c(this.f8038e);
                }
                Rect rect = new Rect();
                this.f8039f.f8035c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8039f.f8036d == this.f8039f.a) {
                    this.f8039f.f8036d = height;
                } else if (this.f8039f.f8036d == height) {
                } else {
                    if (this.f8039f.f8036d - height > this.f8039f.f8034b) {
                        if (this.f8039f.f8037e != null) {
                            this.f8039f.f8037e.b(this.f8038e, this.f8039f.f8036d - height);
                        }
                        this.f8039f.f8036d = height;
                    } else if (height - this.f8039f.f8036d > this.f8039f.f8034b) {
                        if (this.f8039f.f8037e != null) {
                            this.f8039f.f8037e.a(this.f8038e, height - this.f8039f.f8036d);
                        }
                        this.f8039f.f8036d = height;
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
        this.f8034b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f8035c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.p0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.p0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f8037e = aVar;
        }
    }
}
