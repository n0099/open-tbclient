package c.a.d.f.g;

import android.app.Activity;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.g.d;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.adp.lib.guide.MaskView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements View.OnKeyListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Configuration f2386e;

    /* renamed from: f  reason: collision with root package name */
    public MaskView f2387f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.f.g.b[] f2388g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2389h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2390i;

    /* renamed from: j  reason: collision with root package name */
    public d.a f2391j;

    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f2391j == null) {
                return;
            }
            this.a.f2391j.onShown();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2392b;

        public b(c cVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2392b = cVar;
            this.a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.removeAllViews();
                if (this.f2392b.f2391j != null) {
                    this.f2392b.f2391j.onDismiss();
                }
                this.f2392b.j();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* renamed from: c.a.d.f.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class animation.Animation$AnimationListenerC0082c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public animation.Animation$AnimationListenerC0082c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f2391j == null) {
                return;
            }
            this.a.f2391j.onShown();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2393b;

        public d(c cVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2393b = cVar;
            this.a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.removeView(this.f2393b.f2387f);
                if (this.f2393b.f2391j != null) {
                    this.f2393b.f2391j.onDismiss();
                }
                this.f2393b.j();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502757286, "Lc/a/d/f/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502757286, "Lc/a/d/f/g/c;");
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2389h = true;
        this.f2390i = false;
    }

    public void e() {
        MaskView maskView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (maskView = this.f2387f) != null && (maskView.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.f2387f.getParent();
            if (this.f2386e.mExitAnimationId != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f2387f.getContext(), this.f2386e.mExitAnimationId);
                loadAnimation.setAnimationListener(new d(this, viewGroup));
                this.f2387f.startAnimation(loadAnimation);
                return;
            }
            viewGroup.removeView(this.f2387f);
            d.a aVar = this.f2391j;
            if (aVar != null) {
                aVar.onDismiss();
            }
            j();
        }
    }

    public void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        if (this.f2386e.mExitAnimationId != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.f2386e.mExitAnimationId);
            loadAnimation.setAnimationListener(new b(this, viewGroup));
            viewGroup.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeAllViews();
        d.a aVar = this.f2391j;
        if (aVar != null) {
            aVar.onDismiss();
        }
        j();
    }

    public final MaskView i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            MaskView maskView = new MaskView(activity);
            maskView.e(activity.getResources().getColor(this.f2386e.mFullingColorId));
            maskView.d(this.f2386e.mAlpha);
            maskView.g(this.f2386e.mOverlayTarget);
            maskView.setOnKeyListener(this);
            int[] iArr = new int[2];
            ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
            int i2 = iArr[1];
            if (this.f2389h && i2 == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    i2 = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                } catch (NoSuchFieldException e6) {
                    e6.printStackTrace();
                } catch (NumberFormatException e7) {
                    e7.printStackTrace();
                } catch (SecurityException e8) {
                    e8.printStackTrace();
                }
            }
            Configuration configuration = this.f2386e;
            View view = configuration.mTargetView;
            if (view != null) {
                maskView.h(c.a.d.f.g.a.b(view, 0, i2));
            } else {
                View findViewById = activity.findViewById(configuration.mTargetViewId);
                if (findViewById != null) {
                    maskView.h(c.a.d.f.g.a.b(findViewById, 0, i2));
                }
            }
            View findViewById2 = activity.findViewById(this.f2386e.mFullingViewId);
            if (findViewById2 != null) {
                maskView.f(c.a.d.f.g.a.b(findViewById2, 0, i2));
            }
            if (this.f2386e.mOutsideTouchable) {
                maskView.setClickable(false);
            } else {
                maskView.setOnClickListener(this);
            }
            for (c.a.d.f.g.b bVar : this.f2388g) {
                maskView.addView(c.a.d.f.g.a.a(activity.getLayoutInflater(), bVar));
            }
            return maskView;
        }
        return (MaskView) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2386e = null;
            this.f2388g = null;
            this.f2391j = null;
        }
    }

    public void k(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f2391j = aVar;
        }
    }

    public void l(c.a.d.f.g.b[] bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVarArr) == null) {
            this.f2388g = bVarArr;
        }
    }

    public void n(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            this.f2386e = configuration;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f2389h = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && (configuration = this.f2386e) != null && configuration.mAutoDismiss) {
            e();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Configuration configuration;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, view, i2, keyEvent)) == null) {
            if (i2 == 4 && keyEvent.getAction() == 1 && (configuration = this.f2386e) != null && configuration.mAutoDismiss) {
                e();
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f2390i = z;
        }
    }

    public void q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            r(activity, true);
        }
    }

    public void r(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, activity, z) == null) {
            s((ViewGroup) activity.findViewById(16908290), activity, z);
        }
    }

    public final void s(ViewGroup viewGroup, Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, viewGroup, activity, z) == null) {
            if (this.f2387f == null) {
                MaskView i2 = i(activity);
                this.f2387f = i2;
                i2.i(this.f2390i);
                if (!z) {
                    this.f2387f.setFocusable(false);
                    this.f2387f.setFocusableInTouchMode(false);
                    this.f2387f.clearFocus();
                }
            }
            if (this.f2387f.getParent() == null) {
                viewGroup.addView(this.f2387f);
                int i3 = this.f2386e.mEnterAnimationId;
                if (i3 != -1) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(activity, i3);
                    loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0082c(this));
                    this.f2387f.startAnimation(loadAnimation);
                    return;
                }
                d.a aVar = this.f2391j;
                if (aVar != null) {
                    aVar.onShown();
                }
            }
        }
    }

    public void t(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            s((ViewGroup) activity.getWindow().getDecorView(), activity, true);
        }
    }

    public void u(Activity activity, ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048591, this, activity, viewGroup, z) == null) || viewGroup == null) {
            return;
        }
        if (!z) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
        for (c.a.d.f.g.b bVar : this.f2388g) {
            View c2 = bVar.c(activity.getLayoutInflater());
            if (c2.getParent() == null) {
                viewGroup.addView(c2);
            }
        }
        int i2 = this.f2386e.mEnterAnimationId;
        if (i2 == -1) {
            d.a aVar = this.f2391j;
            if (aVar != null) {
                aVar.onShown();
                return;
            }
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(activity, i2);
        } catch (Resources.NotFoundException unused) {
        }
        if (animation == null) {
            d.a aVar2 = this.f2391j;
            if (aVar2 != null) {
                aVar2.onShown();
                return;
            }
            return;
        }
        animation.setAnimationListener(new a(this));
        viewGroup.startAnimation(animation);
    }
}
