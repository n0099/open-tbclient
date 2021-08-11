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
import c.a.e.e.p.l;
import c.a.p0.x2.z;
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
/* loaded from: classes5.dex */
public class McnVideoAdView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f42354e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f42355f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42356g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42357h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f42358i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f42359j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    public c.a.x.a o;
    public c p;
    public final Handler q;
    public ViewParent r;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ McnVideoAdView f42360a;

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
            this.f42360a = mcnVideoAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f42360a.g();
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ McnVideoAdView f42361e;

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
            this.f42361e = mcnVideoAdView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42361e.r == null) {
                return;
            }
            this.f42361e.r.requestDisallowInterceptTouchEvent(false);
            this.f42361e.r = null;
        }
    }

    /* loaded from: classes5.dex */
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
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
        t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
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
        this.n = false;
        this.q = new Handler();
        this.f42354e = context;
        f();
    }

    private void setData(c.a.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, aVar) == null) || aVar == null) {
            return;
        }
        this.o = aVar;
        this.f42355f.startLoad(aVar.f30785a, 10, false);
        if (!StringUtils.isNull(aVar.f30786b)) {
            this.f42356g.setText(aVar.f30786b);
        }
        if (StringUtils.isNull(aVar.f30787c)) {
            return;
        }
        this.f42357h.setText(aVar.f30787c);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q.postDelayed(new b(this), 500L);
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f42359j == null) {
            return;
        }
        clearAnimation();
        startAnimation(this.f42359j);
    }

    public final void e() {
        Context context;
        c.a.x.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f42354e) == null || (aVar = this.o) == null || (str = aVar.f30788d) == null) {
            return;
        }
        z.d(context, str, null, null);
        c cVar = this.p;
        if (cVar != null) {
            cVar.b(this.o);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.f42354e).inflate(R.layout.mcn_video_ad_layout, this);
            this.f42355f = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
            this.f42356g = (TextView) findViewById(R.id.id_mcn_video_ad_title);
            this.f42357h = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
            this.f42355f.setConrers(5);
            this.f42355f.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
            this.f42355f.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
            this.f42355f.setRadius(l.g(this.f42354e, R.dimen.tbds20));
            this.f42358i = AnimationUtils.loadAnimation(this.f42354e, R.anim.mcn_video_ad_open_anim);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f42354e, R.anim.mcn_video_ad_close_anim);
            this.f42359j = loadAnimation;
            loadAnimation.setAnimationListener(new a(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.m = false;
        }
    }

    public void hideMcnVideoAdWithOutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
        }
    }

    public boolean isHasSwipeAdManual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.k = motionEvent.getX();
                this.l = motionEvent.getY();
                ViewParent parent = getParent();
                this.r = parent;
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
                this.n = true;
                dismiss();
                c cVar = this.p;
                if (cVar != null) {
                    cVar.a(this.o);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g();
            this.m = false;
            this.n = false;
            this.o = null;
        }
    }

    public void setIMcnStatListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void show(c.a.x.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, viewGroup) == null) {
            showMcnVideoAdWithOutAnim(aVar, viewGroup);
            if (this.f42358i != null) {
                clearAnimation();
                startAnimation(this.f42358i);
            }
        }
    }

    public void showMcnVideoAdWithOutAnim(c.a.x.a aVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, aVar, viewGroup) == null) {
            this.m = true;
            setData(aVar);
            viewGroup.removeView(this);
            viewGroup.addView(this);
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s, t);
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = u;
                setLayoutParams(layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(s, t);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.setMargins(0, 0, 0, u);
                setLayoutParams(layoutParams2);
            }
            c cVar = this.p;
            if (cVar != null) {
                cVar.c(aVar);
            }
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
        this.n = false;
        this.q = new Handler();
        this.f42354e = context;
        f();
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
        this.n = false;
        this.q = new Handler();
        this.f42354e = context;
        f();
    }
}
