package c.a.o0.a.p2;

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
    public int f7977a;

    /* renamed from: b  reason: collision with root package name */
    public int f7978b;

    /* renamed from: c  reason: collision with root package name */
    public View f7979c;

    /* renamed from: d  reason: collision with root package name */
    public int f7980d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.p2.a f7981e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7983f;

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
            this.f7983f = bVar;
            this.f7982e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7983f.f7981e != null) {
                    this.f7983f.f7981e.c(this.f7982e);
                }
                Rect rect = new Rect();
                this.f7983f.f7979c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f7983f.f7980d == this.f7983f.f7977a) {
                    this.f7983f.f7980d = height;
                } else if (this.f7983f.f7980d == height) {
                } else {
                    if (this.f7983f.f7980d - height > this.f7983f.f7978b) {
                        if (this.f7983f.f7981e != null) {
                            this.f7983f.f7981e.b(this.f7982e, this.f7983f.f7980d - height);
                        }
                        this.f7983f.f7980d = height;
                    } else if (height - this.f7983f.f7980d > this.f7983f.f7978b) {
                        if (this.f7983f.f7981e != null) {
                            this.f7983f.f7981e.a(this.f7982e, height - this.f7983f.f7980d);
                        }
                        this.f7983f.f7980d = height;
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
        this.f7977a = 0;
        this.f7978b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f7979c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f7981e = aVar;
        }
    }
}
