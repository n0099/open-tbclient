package c.a.r0.w3;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f28209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28210f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f28211g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f28212h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f28213i;

        public a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28209e = view;
            this.f28210f = i2;
            this.f28211g = i3;
            this.f28212h = i4;
            this.f28213i = i5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                ViewGroup.LayoutParams layoutParams = this.f28209e.getLayoutParams();
                int i2 = this.f28210f;
                layoutParams.width = i2 - ((int) ((i2 - this.f28211g) * animatedFraction));
                int i3 = this.f28212h;
                layoutParams.height = i3 - ((int) ((i3 - this.f28213i) * animatedFraction));
                this.f28209e.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f28214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28215f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f28216g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f28217h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f28218i;

        public b(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28214e = view;
            this.f28215f = i2;
            this.f28216g = i3;
            this.f28217h = i4;
            this.f28218i = i5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                ViewGroup.LayoutParams layoutParams = this.f28214e.getLayoutParams();
                int i2 = this.f28215f;
                layoutParams.width = i2 - ((int) ((i2 - this.f28216g) * animatedFraction));
                int i3 = this.f28217h;
                layoutParams.height = i3 - ((int) ((i3 - this.f28218i) * animatedFraction));
                this.f28214e.requestLayout();
            }
        }
    }

    public static Bundle a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) {
            Bundle bundle = new Bundle();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            bundle.putInt("enter_anim_values_top", iArr[1]);
            bundle.putInt("enter_anim_values_width", view.getWidth());
            bundle.putInt("enter_anim_values_height", view.getHeight());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static float b(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, bundle2)) == null) ? e(bundle) - e(bundle2) : invokeLL.floatValue;
    }

    public static void c(Intent intent, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, intent, view) == null) {
            Bundle d2 = d(intent);
            Bundle a2 = a(view);
            int g2 = g(d2);
            int g3 = g(a2);
            int e2 = e(d2);
            int e3 = e(a2);
            view.setTranslationY(b(d2, a2) - UtilHelper.getStatusBarHeight());
            view.animate().setDuration(300L).translationY(f(a2)).setUpdateListener(new b(view, g2, g3, e2, e3)).start();
        }
    }

    public static Bundle d(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, intent)) == null) {
            if (intent == null) {
                return null;
            }
            return intent.getBundleExtra("enter_anim_values");
        }
        return (Bundle) invokeL.objValue;
    }

    public static int e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_height");
        }
        return invokeL.intValue;
    }

    public static int f(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_top");
        }
        return invokeL.intValue;
    }

    public static int g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_width");
        }
        return invokeL.intValue;
    }

    public static void h(Intent intent, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, intent, view) == null) {
            view.setVisibility(4);
            Bundle d2 = d(intent);
            Bundle a2 = a(view);
            int g2 = g(d2);
            int g3 = g(a2);
            int e2 = e(d2);
            int e3 = e(a2);
            view.setTranslationY(b(d2, a2) - UtilHelper.getStatusBarHeight());
            view.setVisibility(0);
            view.animate().setDuration(350L).translationY(f(a2)).setUpdateListener(new a(view, g2, g3, e2, e3)).start();
        }
    }
}
