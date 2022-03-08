package c.a.p0.a.j2;

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
    public int f5850b;

    /* renamed from: c  reason: collision with root package name */
    public View f5851c;

    /* renamed from: d  reason: collision with root package name */
    public int f5852d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.j2.a f5853e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5855f;

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
            this.f5855f = bVar;
            this.f5854e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5855f.f5853e != null) {
                    this.f5855f.f5853e.c(this.f5854e);
                }
                Rect rect = new Rect();
                this.f5855f.f5851c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f5855f.f5852d == this.f5855f.a) {
                    this.f5855f.f5852d = height;
                } else if (this.f5855f.f5852d == height) {
                } else {
                    if (this.f5855f.f5852d - height > this.f5855f.f5850b) {
                        if (this.f5855f.f5853e != null) {
                            this.f5855f.f5853e.b(this.f5854e, this.f5855f.f5852d - height);
                        }
                        this.f5855f.f5852d = height;
                    } else if (height - this.f5855f.f5852d > this.f5855f.f5850b) {
                        if (this.f5855f.f5853e != null) {
                            this.f5855f.f5853e.a(this.f5854e, height - this.f5855f.f5852d);
                        }
                        this.f5855f.f5852d = height;
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
        this.f5850b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f5851c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.p0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.p0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f5853e = aVar;
        }
    }
}
