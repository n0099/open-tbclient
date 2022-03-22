package com.baidu.swan.apps.component.container.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import c.a.n0.a.a;
import c.a.n0.a.s.b.b;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f28805e;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public b f28806b;

    /* renamed from: c  reason: collision with root package name */
    public Path f28807c;

    /* renamed from: d  reason: collision with root package name */
    public ScrollView f28808d;

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
        f28805e = a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || Build.VERSION.SDK_INT < 21 || (path = this.f28807c) == null || this.a == null) {
            return;
        }
        b bVar = this.f28806b;
        if (bVar instanceof c.a.n0.a.s.c.e.c.b) {
            c.a.n0.a.s.c.e.c.b bVar2 = (c.a.n0.a.s.c.e.c.b) bVar;
            if (bVar2.n > 0) {
                path.reset();
                Path path2 = this.f28807c;
                float left = this.a.getLeft();
                float top = this.a.getTop();
                float right = this.a.getRight();
                float bottom = this.a.getBottom();
                int i = bVar2.n;
                path2.addRoundRect(left, top, right, bottom, i, i, Path.Direction.CW);
                if (f28805e) {
                    Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar2.n);
                }
                canvas.save();
                canvas.clipPath(this.f28807c);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28808d : (ScrollView) invokeV.objValue;
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
            View view = this.f28808d;
            if (view == null) {
                view = this;
            }
            view.setVisibility(z ? 8 : 0);
        }
    }

    public void setModel(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f28806b = bVar;
        }
    }

    public void setScrollView(ScrollView scrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollView) == null) {
            this.f28808d = scrollView;
        }
    }

    public void setTargetView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            setTargetView(view, -1);
        }
    }

    public void setTargetView(@NonNull View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i) == null) {
            if (this.a == view) {
                d.o("Component-ContainerView", "repeat setTargetView with the same view");
                return;
            }
            if (this.f28807c == null) {
                this.f28807c = new Path();
            }
            if (this.a != null) {
                c.a.n0.a.s.g.a.a("Component-ContainerView", "repeat setTargetView with the different view");
                removeView(this.a);
            }
            this.a = view;
            addView(view, i, generateDefaultLayoutParams());
        }
    }
}
