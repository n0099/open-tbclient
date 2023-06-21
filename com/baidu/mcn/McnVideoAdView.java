package com.baidu.mcn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.co9;
import com.baidu.tieba.of0;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class McnVideoAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public Animation e;
    public Animation f;
    public float g;
    public float h;
    public boolean i;
    public of0 j;
    public c k;
    public final Handler l;
    public ViewParent m;

    /* loaded from: classes3.dex */
    public interface c {
        void a(of0 of0Var);

        void b(of0 of0Var);

        void c(of0 of0Var);
    }

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ McnVideoAdView a;

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

        public a(McnVideoAdView mcnVideoAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mcnVideoAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mcnVideoAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ McnVideoAdView a;

        public b(McnVideoAdView mcnVideoAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mcnVideoAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mcnVideoAdView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m != null) {
                this.a.m.requestDisallowInterceptTouchEvent(false);
                this.a.m = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249764821, "Lcom/baidu/mcn/McnVideoAdView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-249764821, "Lcom/baidu/mcn/McnVideoAdView;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McnVideoAdView(Context context) {
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
        this.i = false;
        this.l = new Handler();
        this.a = context;
        g();
    }

    private void setData(of0 of0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, this, of0Var) != null) || of0Var == null) {
            return;
        }
        this.j = of0Var;
        this.b.N(of0Var.a, 10, false);
        if (!StringUtils.isNull(of0Var.b)) {
            this.c.setText(of0Var.b);
        }
        if (!StringUtils.isNull(of0Var.c)) {
            this.d.setText(of0Var.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = false;
        this.l = new Handler();
        this.a = context;
        g();
    }

    public void l(of0 of0Var, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, of0Var, viewGroup) == null) {
            this.i = true;
            setData(of0Var);
            viewGroup.removeView(this);
            viewGroup.addView(this);
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n, o);
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = p;
                setLayoutParams(layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(n, o);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.setMargins(0, 0, 0, p);
                setLayoutParams(layoutParams2);
            }
            c cVar = this.k;
            if (cVar != null) {
                cVar.c(of0Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = false;
        this.l = new Handler();
        this.a = context;
        g();
    }

    public void setIMcnStatListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void k(of0 of0Var, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, of0Var, viewGroup) == null) {
            l(of0Var, viewGroup);
            if (this.e != null) {
                clearAnimation();
                startAnimation(this.e);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.postDelayed(new b(this), 500L);
        }
    }

    public final void e() {
        Context context;
        of0 of0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (context = this.a) != null && (of0Var = this.j) != null && (str = of0Var.d) != null) {
            co9.a(context, str, null, null, null);
            c cVar = this.k;
            if (cVar != null) {
                cVar.b(this.j);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != null) {
            clearAnimation();
            startAnimation(this.f);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.i = false;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            this.i = false;
            this.j = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.mcn_video_ad_layout, this);
            this.b = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
            this.c = (TextView) findViewById(R.id.id_mcn_video_ad_title);
            this.d = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
            this.b.setConrers(5);
            this.b.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
            this.b.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
            this.b.setRadius(wi.g(this.a, R.dimen.tbds20));
            this.e = AnimationUtils.loadAnimation(this.a, R.anim.mcn_video_ad_open_anim);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.mcn_video_ad_close_anim);
            this.f = loadAnimation;
            loadAnimation.setAnimationListener(new a(this));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            d();
                        }
                    } else if (motionEvent.getX() - this.g > 10.0f && this.i) {
                        f();
                        c cVar = this.k;
                        if (cVar != null) {
                            cVar.a(this.j);
                        }
                    }
                } else {
                    d();
                    if (Math.abs(motionEvent.getX() - this.g) < 5.0f && Math.abs(motionEvent.getY() - this.h) < 5.0f) {
                        e();
                    }
                }
            } else {
                this.g = motionEvent.getX();
                this.h = motionEvent.getY();
                ViewParent parent = getParent();
                this.m = parent;
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
