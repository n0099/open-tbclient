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
import c.a.d.f.p.n;
import c.a.p0.l3.a0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class McnVideoAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f26935b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26936c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26937d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f26938e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f26939f;

    /* renamed from: g  reason: collision with root package name */
    public float f26940g;

    /* renamed from: h  reason: collision with root package name */
    public float f26941h;
    public boolean i;
    public c.a.x.a j;
    public c k;
    public final Handler l;
    public ViewParent m;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface c {
        void a(c.a.x.a aVar);

        void b(c.a.x.a aVar);

        void c(c.a.x.a aVar);
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

    private void setData(c.a.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, aVar) == null) || aVar == null) {
            return;
        }
        this.j = aVar;
        this.f26935b.J(aVar.a, 10, false);
        if (!StringUtils.isNull(aVar.f21975b)) {
            this.f26936c.setText(aVar.f21975b);
        }
        if (StringUtils.isNull(aVar.f21976c)) {
            return;
        }
        this.f26937d.setText(aVar.f21976c);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.postDelayed(new b(this), 500L);
        }
    }

    public final void e() {
        Context context;
        c.a.x.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (context = this.a) == null || (aVar = this.j) == null || (str = aVar.f21977d) == null) {
            return;
        }
        a0.d(context, str, null, null, null);
        c cVar = this.k;
        if (cVar != null) {
            cVar.b(this.j);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26939f == null) {
            return;
        }
        clearAnimation();
        startAnimation(this.f26939f);
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
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d053e, this);
            this.f26935b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090e32);
            this.f26936c = (TextView) findViewById(R.id.obfuscated_res_0x7f090e34);
            this.f26937d = (TextView) findViewById(R.id.obfuscated_res_0x7f090e33);
            this.f26935b.setConrers(5);
            this.f26935b.setDefaultResource(R.drawable.obfuscated_res_0x7f080d48);
            this.f26935b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080d48);
            this.f26935b.setRadius(n.f(this.a, R.dimen.tbds20));
            this.f26938e = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010093);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010092);
            this.f26939f = loadAnimation;
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

    public void l(c.a.x.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, viewGroup) == null) {
            m(aVar, viewGroup);
            if (this.f26938e != null) {
                clearAnimation();
                startAnimation(this.f26938e);
            }
        }
    }

    public void m(c.a.x.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, aVar, viewGroup) == null) {
            this.i = true;
            setData(aVar);
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
                cVar.c(aVar);
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
                this.f26940g = motionEvent.getX();
                this.f26941h = motionEvent.getY();
                ViewParent parent = getParent();
                this.m = parent;
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (action == 1) {
                d();
                if (Math.abs(motionEvent.getX() - this.f26940g) < 5.0f && Math.abs(motionEvent.getY() - this.f26941h) < 5.0f) {
                    e();
                }
            } else if (action != 2) {
                if (action == 3) {
                    d();
                }
            } else if (motionEvent.getX() - this.f26940g > 10.0f && this.i) {
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
