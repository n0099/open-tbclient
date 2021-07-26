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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.w2.x;
/* loaded from: classes2.dex */
public class McnVideoAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f8070e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f8071f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f8072g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f8073h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f8074i;
    public Animation j;
    public float k;
    public float l;
    public boolean m;
    public d.a.y.a n;
    public c o;
    public final Handler p;
    public ViewParent q;

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ McnVideoAdView f8075a;

        public a(McnVideoAdView mcnVideoAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mcnVideoAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8075a = mcnVideoAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f8075a.j();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ McnVideoAdView f8076e;

        public b(McnVideoAdView mcnVideoAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mcnVideoAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8076e = mcnVideoAdView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8076e.q == null) {
                return;
            }
            this.f8076e.q.requestDisallowInterceptTouchEvent(false);
            this.f8076e.q = null;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(d.a.y.a aVar);

        void b(d.a.y.a aVar);

        void c(d.a.y.a aVar);
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
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
        t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = false;
        this.p = new Handler();
        this.f8070e = context;
        h();
    }

    private void setData(d.a.y.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, aVar) == null) || aVar == null) {
            return;
        }
        this.n = aVar;
        this.f8071f.M(aVar.f69125a, 10, false);
        if (!StringUtils.isNull(aVar.f69126b)) {
            this.f8072g.setText(aVar.f69126b);
        }
        if (StringUtils.isNull(aVar.f69127c)) {
            return;
        }
        this.f8073h.setText(aVar.f69127c);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p.postDelayed(new b(this), 500L);
        }
    }

    public final void e() {
        Context context;
        d.a.y.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (context = this.f8070e) == null || (aVar = this.n) == null || (str = aVar.f69128d) == null) {
            return;
        }
        x.d(context, str, null, null);
        c cVar = this.o;
        if (cVar != null) {
            cVar.b(this.n);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j == null) {
            return;
        }
        clearAnimation();
        startAnimation(this.j);
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
            LayoutInflater.from(this.f8070e).inflate(R.layout.mcn_video_ad_layout, this);
            this.f8071f = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
            this.f8072g = (TextView) findViewById(R.id.id_mcn_video_ad_title);
            this.f8073h = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
            this.f8071f.setConrers(5);
            this.f8071f.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
            this.f8071f.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
            this.f8071f.setRadius(l.g(this.f8070e, R.dimen.tbds20));
            this.f8074i = AnimationUtils.loadAnimation(this.f8070e, R.anim.mcn_video_ad_open_anim);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f8070e, R.anim.mcn_video_ad_close_anim);
            this.j = loadAnimation;
            loadAnimation.setAnimationListener(new a(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.m = false;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j();
            this.m = false;
            this.n = null;
        }
    }

    public void l(d.a.y.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, viewGroup) == null) {
            m(aVar, viewGroup);
            if (this.f8074i != null) {
                clearAnimation();
                startAnimation(this.f8074i);
            }
        }
    }

    public void m(d.a.y.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, aVar, viewGroup) == null) {
            this.m = true;
            setData(aVar);
            viewGroup.removeView(this);
            viewGroup.addView(this);
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r, s);
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = t;
                setLayoutParams(layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r, s);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.setMargins(0, 0, 0, t);
                setLayoutParams(layoutParams2);
            }
            c cVar = this.o;
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
                this.k = motionEvent.getX();
                this.l = motionEvent.getY();
                ViewParent parent = getParent();
                this.q = parent;
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (action == 1) {
                d();
                if (Math.abs(motionEvent.getX() - this.k) < 5.0f && Math.abs(motionEvent.getY() - this.l) < 5.0f) {
                    e();
                }
            } else if (action != 2) {
                if (action == 3) {
                    d();
                }
            } else if (motionEvent.getX() - this.k > 10.0f && this.m) {
                f();
                c cVar = this.o;
                if (cVar != null) {
                    cVar.a(this.n);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setIMcnStatListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.o = cVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = false;
        this.p = new Handler();
        this.f8070e = context;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McnVideoAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.m = false;
        this.p = new Handler();
        this.f8070e = context;
        h();
    }
}
