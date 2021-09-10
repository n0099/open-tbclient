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
    public int f8005a;

    /* renamed from: b  reason: collision with root package name */
    public int f8006b;

    /* renamed from: c  reason: collision with root package name */
    public View f8007c;

    /* renamed from: d  reason: collision with root package name */
    public int f8008d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.p2.a f8009e;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8010e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8011f;

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
            this.f8011f = bVar;
            this.f8010e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8011f.f8009e != null) {
                    this.f8011f.f8009e.c(this.f8010e);
                }
                Rect rect = new Rect();
                this.f8011f.f8007c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f8011f.f8008d == this.f8011f.f8005a) {
                    this.f8011f.f8008d = height;
                } else if (this.f8011f.f8008d == height) {
                } else {
                    if (this.f8011f.f8008d - height > this.f8011f.f8006b) {
                        if (this.f8011f.f8009e != null) {
                            this.f8011f.f8009e.b(this.f8010e, this.f8011f.f8008d - height);
                        }
                        this.f8011f.f8008d = height;
                    } else if (height - this.f8011f.f8008d > this.f8011f.f8006b) {
                        if (this.f8011f.f8009e != null) {
                            this.f8011f.f8009e.a(this.f8010e, height - this.f8011f.f8008d);
                        }
                        this.f8011f.f8008d = height;
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
        this.f8005a = 0;
        this.f8006b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f8007c = decorView;
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
            this.f8009e = aVar;
        }
    }
}
