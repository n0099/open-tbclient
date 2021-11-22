package b.a.p0.a.t2;

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
    public int f8461a;

    /* renamed from: b  reason: collision with root package name */
    public int f8462b;

    /* renamed from: c  reason: collision with root package name */
    public View f8463c;

    /* renamed from: d  reason: collision with root package name */
    public int f8464d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.t2.a f8465e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8467f;

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
            this.f8467f = bVar;
            this.f8466e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8467f.f8465e != null) {
                    this.f8467f.f8465e.c(this.f8466e);
                }
                Rect rect = new Rect();
                this.f8467f.f8463c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8467f.f8464d == this.f8467f.f8461a) {
                    this.f8467f.f8464d = height;
                } else if (this.f8467f.f8464d == height) {
                } else {
                    if (this.f8467f.f8464d - height > this.f8467f.f8462b) {
                        if (this.f8467f.f8465e != null) {
                            this.f8467f.f8465e.b(this.f8466e, this.f8467f.f8464d - height);
                        }
                        this.f8467f.f8464d = height;
                    } else if (height - this.f8467f.f8464d > this.f8467f.f8462b) {
                        if (this.f8467f.f8465e != null) {
                            this.f8467f.f8465e.a(this.f8466e, height - this.f8467f.f8464d);
                        }
                        this.f8467f.f8464d = height;
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
        this.f8461a = 0;
        this.f8462b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f8463c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, b.a.p0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(b.a.p0.a.t2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f8465e = aVar;
        }
    }
}
