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
import com.baidu.tieba.ej;
import com.baidu.tieba.nd8;
import com.baidu.tieba.sd0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
    public sd0 j;
    public c k;
    public final Handler l;
    public ViewParent m;

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ McnVideoAdView a;

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
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.j();
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

    /* loaded from: classes2.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m == null) {
                return;
            }
            this.a.m.requestDisallowInterceptTouchEvent(false);
            this.a.m = null;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(sd0 sd0Var);

        void b(sd0 sd0Var);

        void c(sd0 sd0Var);
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
        h();
    }

    private void setData(sd0 sd0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, sd0Var) == null) || sd0Var == null) {
            return;
        }
        this.j = sd0Var;
        this.b.K(sd0Var.a, 10, false);
        if (!StringUtils.isNull(sd0Var.b)) {
            this.c.setText(sd0Var.b);
        }
        if (StringUtils.isNull(sd0Var.c)) {
            return;
        }
        this.d.setText(sd0Var.c);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.postDelayed(new b(this), 500L);
        }
    }

    public final void e() {
        Context context;
        sd0 sd0Var;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (context = this.a) == null || (sd0Var = this.j) == null || (str = sd0Var.d) == null) {
            return;
        }
        nd8.a(context, str, null, null, null);
        c cVar = this.k;
        if (cVar != null) {
            cVar.b(this.j);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f == null) {
            return;
        }
        clearAnimation();
        startAnimation(this.f);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0578, this);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090e43);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090e45);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090e44);
            this.b.setConrers(5);
            this.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080d5b);
            this.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080d5b);
            this.b.setRadius(ej.f(this.a, R.dimen.tbds20));
            this.e = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01009e);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01009d);
            this.f = loadAnimation;
            loadAnimation.setAnimationListener(new a(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.i = false;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j();
            this.i = false;
            this.j = null;
        }
    }

    public void l(sd0 sd0Var, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sd0Var, viewGroup) == null) {
            m(sd0Var, viewGroup);
            if (this.e != null) {
                clearAnimation();
                startAnimation(this.e);
            }
        }
    }

    public void m(sd0 sd0Var, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sd0Var, viewGroup) == null) {
            this.i = true;
            setData(sd0Var);
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
                cVar.c(sd0Var);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.g = motionEvent.getX();
                this.h = motionEvent.getY();
                ViewParent parent = getParent();
                this.m = parent;
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (action == 1) {
                d();
                if (Math.abs(motionEvent.getX() - this.g) < 5.0f && Math.abs(motionEvent.getY() - this.h) < 5.0f) {
                    e();
                }
            } else if (action != 2) {
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
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setIMcnStatListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.k = cVar;
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
        h();
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
        h();
    }
}
