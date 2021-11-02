package b.a.p0.a.w1.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8802e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f8803f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f8804g;

        public a(View view, View view2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, view2, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8802e = view;
            this.f8803f = view2;
            this.f8804g = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && b.a.p0.a.w1.h.b.c().e()) {
                boolean c2 = b.c(this.f8802e, this.f8803f);
                c cVar = this.f8804g;
                if (cVar != null) {
                    cVar.onClickSwitch(view, c2);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.w1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnTouchListenerC0441b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8805e;

        public View$OnTouchListenerC0441b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8805e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f8805e.setVisibility(4);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClickSwitch(View view, boolean z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public static void b(View view, View view2, View view3, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, view, view2, view3, cVar) == null) {
            if (view2 != null) {
                view2.setOnClickListener(new a(view, view3, cVar));
            }
            if (e(view.getContext())) {
                view3.setOnTouchListener(new View$OnTouchListenerC0441b(view));
            }
        }
    }

    public static boolean c(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view, view2)) == null) {
            boolean z = view.getVisibility() != 0;
            if (!z) {
                h(view, view2);
            } else {
                g(view, view2);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void d(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, view2) == null) {
            if (view2 != null) {
                e.k(view2);
                view2.clearFocus();
            }
            view.setVisibility(8);
        }
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof Activity) {
                boolean d2 = g.d((Activity) context);
                f(d2);
                return d2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z : invokeZ.booleanValue;
    }

    public static void g(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, view, view2) == null) {
            view.setVisibility(0);
            if (view2 != null) {
                e.k(view2);
            }
        }
    }

    public static void h(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, view, view2) == null) {
            e.m(view2);
            if (e(view.getContext())) {
                view.setVisibility(4);
            }
        }
    }
}
