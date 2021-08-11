package com.baidu.swan.apps.component.container.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import c.a.n0.a.c0.b.b;
import c.a.n0.a.c0.g.a;
import c.a.n0.a.e0.d;
import c.a.n0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f45621e;

    /* renamed from: f  reason: collision with root package name */
    public b f45622f;

    /* renamed from: g  reason: collision with root package name */
    public Path f45623g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f45624h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1069737441, "Lcom/baidu/swan/apps/component/container/view/SwanAppComponentContainerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1069737441, "Lcom/baidu/swan/apps/component/container/view/SwanAppComponentContainerView;");
                return;
            }
        }
        DEBUG = k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void a(Canvas canvas) {
        Path path;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || Build.VERSION.SDK_INT < 21 || (path = this.f45623g) == null || this.f45621e == null) {
            return;
        }
        b bVar = this.f45622f;
        if (bVar instanceof c.a.n0.a.c0.c.e.c.b) {
            c.a.n0.a.c0.c.e.c.b bVar2 = (c.a.n0.a.c0.c.e.c.b) bVar;
            if (bVar2.r > 0) {
                path.reset();
                Path path2 = this.f45623g;
                float left = this.f45621e.getLeft();
                float top = this.f45621e.getTop();
                float right = this.f45621e.getRight();
                float bottom = this.f45621e.getBottom();
                int i2 = bVar2.r;
                path2.addRoundRect(left, top, right, bottom, i2, i2, Path.Direction.CW);
                if (DEBUG) {
                    String str = "SwanAppComponentContainerView  model.borderRadius =" + bVar2.r;
                }
                canvas.save();
                canvas.clipPath(this.f45623g);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45624h : (ScrollView) invokeV.objValue;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            a(canvas);
        }
    }

    public void setHidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            View view = this.f45624h;
            if (view == null) {
                view = this;
            }
            view.setVisibility(z ? 8 : 0);
        }
    }

    public void setModel(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f45622f = bVar;
        }
    }

    public void setScrollView(ScrollView scrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollView) == null) {
            this.f45624h = scrollView;
        }
    }

    public void setTargetView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            setTargetView(view, -1);
        }
    }

    public void setTargetView(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
            if (this.f45621e == view) {
                d.l("Component-ContainerView", "repeat setTargetView with the same view");
                return;
            }
            if (this.f45623g == null) {
                this.f45623g = new Path();
            }
            if (this.f45621e != null) {
                a.a("Component-ContainerView", "repeat setTargetView with the different view");
                removeView(this.f45621e);
            }
            this.f45621e = view;
            addView(view, i2, generateDefaultLayoutParams());
        }
    }
}
