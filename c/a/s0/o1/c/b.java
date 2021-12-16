package c.a.s0.o1.c;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f20631b;

    /* renamed from: c  reason: collision with root package name */
    public View f20632c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f20633d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f20634e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f20635f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f20636g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f20637h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f20638i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.s.i0.n.c f20639j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.s.i0.n.c f20640k;
    public boolean l;
    public PopupWindow m;
    public float n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20641e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20641e = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.f20641e.m != null && this.f20641e.m.isShowing()) {
                this.f20641e.m.dismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.f20641e.m != null && this.f20641e.m.isShowing()) {
                this.f20641e.m.dismiss();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
            }
        }
    }

    /* renamed from: c.a.s0.o1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1246b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20642e;

        public View$OnClickListenerC1246b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20642e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20642e.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20643e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20643e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20643e.i();
                if (!this.f20643e.l) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 0));
                    this.f20643e.l = true;
                    this.f20643e.q();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                this.f20643e.p(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20644e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20644e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20644e.i();
                if (this.f20644e.l) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921502, 1));
                    this.f20644e.l = false;
                    this.f20644e.q();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                this.f20644e.p(2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20645e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20645e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return false;
                }
                this.f20645e.i();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20646e;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20646e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20646e.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20647e;

        public i(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20647e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f20647e.f20636g.setAlpha(floatValue);
                if (this.f20647e.f20636g.getMeasuredHeight() > 0) {
                    this.f20647e.f20636g.setTranslationY(this.f20647e.f20636g.getMeasuredHeight() * (floatValue - 1.0f));
                }
                this.f20647e.f20632c.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20648e;

        public j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20648e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f20648e.f20636g.setAlpha(floatValue);
                if (this.f20648e.f20636g.getMeasuredHeight() > 0) {
                    this.f20648e.f20636g.setTranslationY(this.f20648e.f20636g.getMeasuredHeight() * (floatValue - 1.0f));
                }
                this.f20648e.f20632c.setAlpha(floatValue);
            }
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.n = 1.0f;
        this.o = new View$OnClickListenerC1246b(this);
        this.p = new c(this);
        this.q = new d(this);
        this.a = context;
        j();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || q.a()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new j(this));
        ofFloat.addListener(new a(this));
        ofFloat.start();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.home_page_concern_dialog_thread, (ViewGroup) null);
            this.f20631b = inflate;
            this.f20633d = (LinearLayout) inflate.findViewById(R.id.root_main);
            this.f20635f = (FrameLayout) this.f20631b.findViewById(R.id.type_container);
            this.f20634e = (LinearLayout) this.f20631b.findViewById(R.id.ll_btn);
            this.f20632c = this.f20631b.findViewById(R.id.mask_view);
            this.f20636g = (FrameLayout) this.f20631b.findViewById(R.id.bottom_background_view);
            this.f20637h = (TBSpecificationBtn) this.f20631b.findViewById(R.id.btn_all_concern);
            this.f20638i = (TBSpecificationBtn) this.f20631b.findViewById(R.id.btn_person_concern);
            this.f20637h.setTextSize(R.dimen.tbds34);
            this.f20637h.setText(TbadkCoreApplication.getInst().getString(R.string.attention_all));
            this.f20638i.setTextSize(R.dimen.tbds34);
            this.f20638i.setText(TbadkCoreApplication.getInst().getString(R.string.attention_person));
            this.f20638i.setOnClickListener(this.q);
            this.f20637h.setOnClickListener(this.p);
            this.f20635f.setOnClickListener(this.o);
            c.a.r0.s.i0.n.c cVar = new c.a.r0.s.i0.n.c();
            this.f20639j = cVar;
            cVar.p(R.color.CAM_X0304);
            c.a.r0.s.i0.n.c cVar2 = new c.a.r0.s.i0.n.c();
            this.f20640k = cVar2;
            cVar2.r(R.color.CAM_X0108);
            this.l = c.a.r0.s.g0.b.j().k("key_home_concern_all_status", 0) != 1;
            q();
            k(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f20631b == null) {
            return;
        }
        this.f20637h.changeSkinType(i2);
        this.f20638i.changeSkinType(i2);
        SkinManager.setBackgroundColorWithAlpha(this.f20634e, R.color.CAM_X0208, this.n, i2);
        SkinManager.setBackgroundColor(this.f20636g, R.color.CAM_X0202);
        SkinManager.setBackgroundColor(this.f20632c, R.color.CAM_X0605);
    }

    public void l(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.n = f2;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new i(this));
            ofFloat.start();
        }
    }

    public void n(StickyAppBarLayout stickyAppBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, stickyAppBarLayout) == null) {
            o(stickyAppBarLayout);
        }
    }

    public final void o(StickyAppBarLayout stickyAppBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, stickyAppBarLayout) == null) {
            if (this.m == null) {
                PopupWindow popupWindow = new PopupWindow(this.f20631b, -1, -1, true);
                this.m = popupWindow;
                popupWindow.setContentView(this.f20631b);
                this.m.setOutsideTouchable(true);
                this.m.setBackgroundDrawable(new ColorDrawable(0));
                this.m.setFocusable(true);
                this.m.setTouchInterceptor(new e(this));
                this.m.setOnDismissListener(new f(this));
                this.m.setAnimationStyle(0);
            }
            int[] iArr = new int[2];
            stickyAppBarLayout.getLocationInWindow(iArr);
            int height = (iArr[1] + stickyAppBarLayout.getHeight()) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            int dimensionPixelOffset = iArr[0] - this.a.getResources().getDimensionPixelOffset(R.dimen.tbds44);
            if (UtilHelper.canUseStyleImmersiveSticky() && (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24)) {
                height -= UtilHelper.getStatusBarHeight();
            }
            this.f20633d.setOnClickListener(new g(this));
            this.f20634e.setOnClickListener(new h(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20635f.getLayoutParams();
            if (!"Meizu".equalsIgnoreCase(Build.BRAND) || Build.VERSION.SDK_INT > 24) {
                layoutParams.topMargin = height;
            }
            this.f20635f.setLayoutParams(layoutParams);
            if (c.a.d.f.m.g.m(this.m, stickyAppBarLayout, 0, dimensionPixelOffset, height)) {
                m();
            }
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_SWITCH);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void q() {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tBSpecificationBtn = this.f20637h) == null || this.f20638i == null) {
            return;
        }
        if (this.l) {
            tBSpecificationBtn.setConfig(this.f20639j);
            this.f20638i.setConfig(this.f20640k);
            return;
        }
        tBSpecificationBtn.setConfig(this.f20640k);
        this.f20638i.setConfig(this.f20639j);
    }
}
