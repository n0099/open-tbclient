package c.a.p0.a.p2;

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
    public int f8013a;

    /* renamed from: b  reason: collision with root package name */
    public int f8014b;

    /* renamed from: c  reason: collision with root package name */
    public View f8015c;

    /* renamed from: d  reason: collision with root package name */
    public int f8016d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.p2.a f8017e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8019f;

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
            this.f8019f = bVar;
            this.f8018e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8019f.f8017e != null) {
                    this.f8019f.f8017e.c(this.f8018e);
                }
                Rect rect = new Rect();
                this.f8019f.f8015c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8019f.f8016d == this.f8019f.f8013a) {
                    this.f8019f.f8016d = height;
                } else if (this.f8019f.f8016d == height) {
                } else {
                    if (this.f8019f.f8016d - height > this.f8019f.f8014b) {
                        if (this.f8019f.f8017e != null) {
                            this.f8019f.f8017e.b(this.f8018e, this.f8019f.f8016d - height);
                        }
                        this.f8019f.f8016d = height;
                    } else if (height - this.f8019f.f8016d > this.f8019f.f8014b) {
                        if (this.f8019f.f8017e != null) {
                            this.f8019f.f8017e.a(this.f8018e, height - this.f8019f.f8016d);
                        }
                        this.f8019f.f8016d = height;
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
        this.f8013a = 0;
        this.f8014b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f8015c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.p0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f8017e = aVar;
        }
    }
}
