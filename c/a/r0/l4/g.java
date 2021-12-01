package c.a.r0.l4;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f19450b;

    /* renamed from: c  reason: collision with root package name */
    public View f19451c;

    /* renamed from: d  reason: collision with root package name */
    public a f19452d;

    /* renamed from: e  reason: collision with root package name */
    public int f19453e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f19454f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f19455g;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2);
    }

    public g(Context context, c.a.r0.l4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19453e = 4;
        this.f19454f = new Rect();
        this.f19455g = new Rect();
        this.a = context;
    }

    public void a(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            this.f19450b = view;
            this.f19451c = view2;
            if (view2 != null) {
                view2.getGlobalVisibleRect(this.f19454f);
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                h();
            } else {
                c();
            }
        }
    }

    public abstract void c();

    public abstract void d();

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f19452d = aVar;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
        }
    }

    public abstract void g();

    public abstract void h();
}
