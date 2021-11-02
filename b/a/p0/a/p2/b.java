package b.a.p0.a.p2;

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
    public int f7305a;

    /* renamed from: b  reason: collision with root package name */
    public int f7306b;

    /* renamed from: c  reason: collision with root package name */
    public View f7307c;

    /* renamed from: d  reason: collision with root package name */
    public int f7308d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.p2.a f7309e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7310e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7311f;

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
            this.f7311f = bVar;
            this.f7310e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7311f.f7309e != null) {
                    this.f7311f.f7309e.c(this.f7310e);
                }
                Rect rect = new Rect();
                this.f7311f.f7307c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7311f.f7308d == this.f7311f.f7305a) {
                    this.f7311f.f7308d = height;
                } else if (this.f7311f.f7308d == height) {
                } else {
                    if (this.f7311f.f7308d - height > this.f7311f.f7306b) {
                        if (this.f7311f.f7309e != null) {
                            this.f7311f.f7309e.b(this.f7310e, this.f7311f.f7308d - height);
                        }
                        this.f7311f.f7308d = height;
                    } else if (height - this.f7311f.f7308d > this.f7311f.f7306b) {
                        if (this.f7311f.f7309e != null) {
                            this.f7311f.f7309e.a(this.f7310e, height - this.f7311f.f7308d);
                        }
                        this.f7311f.f7308d = height;
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
        this.f7305a = 0;
        this.f7306b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f7307c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, b.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(b.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f7309e = aVar;
        }
    }
}
