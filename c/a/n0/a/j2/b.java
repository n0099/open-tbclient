package c.a.n0.a.j2;

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
    public int f4932b;

    /* renamed from: c  reason: collision with root package name */
    public View f4933c;

    /* renamed from: d  reason: collision with root package name */
    public int f4934d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.j2.a f4935e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f4936b;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4936b = bVar;
            this.a = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4936b.f4935e != null) {
                    this.f4936b.f4935e.c(this.a);
                }
                Rect rect = new Rect();
                this.f4936b.f4933c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f4936b.f4934d == this.f4936b.a) {
                    this.f4936b.f4934d = height;
                } else if (this.f4936b.f4934d == height) {
                } else {
                    if (this.f4936b.f4934d - height > this.f4936b.f4932b) {
                        if (this.f4936b.f4935e != null) {
                            this.f4936b.f4935e.b(this.a, this.f4936b.f4934d - height);
                        }
                        this.f4936b.f4934d = height;
                    } else if (height - this.f4936b.f4934d > this.f4936b.f4932b) {
                        if (this.f4936b.f4935e != null) {
                            this.f4936b.f4935e.a(this.a, height - this.f4936b.f4934d);
                        }
                        this.f4936b.f4934d = height;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f4932b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f4933c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, c.a.n0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(c.a.n0.a.j2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f4935e = aVar;
        }
    }
}
