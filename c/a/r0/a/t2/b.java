package c.a.r0.a.t2;

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
    public int f9078b;

    /* renamed from: c  reason: collision with root package name */
    public View f9079c;

    /* renamed from: d  reason: collision with root package name */
    public int f9080d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.t2.a f9081e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9082e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9083f;

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
            this.f9083f = bVar;
            this.f9082e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9083f.f9081e != null) {
                    this.f9083f.f9081e.c(this.f9082e);
                }
                Rect rect = new Rect();
                this.f9083f.f9079c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f9083f.f9080d == this.f9083f.a) {
                    this.f9083f.f9080d = height;
                } else if (this.f9083f.f9080d == height) {
                } else {
                    if (this.f9083f.f9080d - height > this.f9083f.f9078b) {
                        if (this.f9083f.f9081e != null) {
                            this.f9083f.f9081e.b(this.f9082e, this.f9083f.f9080d - height);
                        }
                        this.f9083f.f9080d = height;
                    } else if (height - this.f9083f.f9080d > this.f9083f.f9078b) {
                        if (this.f9083f.f9081e != null) {
                            this.f9083f.f9081e.a(this.f9082e, height - this.f9083f.f9080d);
                        }
                        this.f9083f.f9080d = height;
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
        this.f9078b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f9079c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.r0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.r0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f9081e = aVar;
        }
    }
}
