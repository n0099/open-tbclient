package c.a.q0.m0.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.g.d;
import c.a.e.l.e.c;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.q1;
import c.a.p0.s.q.r1;
import c.a.p0.s.q.x;
import c.a.q0.m0.m.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements EnterForumAdView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public int B;
    public int C;
    public CustomMessageListener D;
    public boolean E;
    public boolean F;
    public Runnable G;
    public View H;
    public float I;
    public ImageView J;
    public boolean K;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public Context f22215a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f22216b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s.f0.g f22217c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f22218d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.m0.c.a f22219e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.q0.m0.d.f> f22220f;

    /* renamed from: g  reason: collision with root package name */
    public q1 f22221g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f22222h;

    /* renamed from: i  reason: collision with root package name */
    public CommonTipView f22223i;

    /* renamed from: j  reason: collision with root package name */
    public View f22224j;
    public c.a.p0.f0.h k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public c.a.e.e.g.c p;
    public int q;
    public c.a.q0.m0.m.d r;
    public c.a.q0.m0.d.c s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public f.g x;
    public f.g y;
    public AbsListView.OnScrollListener z;

    /* loaded from: classes3.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22225e;

        /* renamed from: c.a.q0.m0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1031a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f22226e;

            public RunnableC1031a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22226e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f22226e.f22225e.f22218d.setSelection(0);
                }
            }
        }

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
            this.f22225e = bVar;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f22225e.K) {
                return;
            }
            c.a.q0.h3.c.g().j(this.f22225e.f22216b.getUniqueId());
            if (this.f22225e.x != null) {
                this.f22225e.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = this.f22225e;
                if (bVar.E || bVar.s == null || !this.f22225e.s.f21916a) {
                    return;
                }
                if (this.f22225e.s.f21918c > 0) {
                    this.f22225e.f22218d.smoothScrollToPosition(0, 0, 0);
                    this.f22225e.j0();
                    return;
                }
                c.a.e.e.m.e.a().post(new RunnableC1031a(this));
            }
        }
    }

    /* renamed from: c.a.q0.m0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1032b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1032b(b bVar) {
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

        @Override // c.a.e.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.e.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22227e;

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
            this.f22227e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22227e.p == null) {
                return;
            }
            this.f22227e.p.d();
            this.f22227e.p = null;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22228e;

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
            this.f22228e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                EnterForumAdView.clickAd(this.f22228e.f22216b.getPageContext().getUniqueId(), this.f22228e.f22215a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f22229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22230f;

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
            this.f22230f = bVar;
            this.f22229e = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f22230f.I = motionEvent.getRawY();
                } else if (action == 1) {
                    if (this.f22230f.I <= (this.f22230f.f22215a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f22230f.I) {
                        this.f22230f.i0();
                        if (this.f22229e < 50.0f) {
                            this.f22230f.H.performClick();
                        }
                    } else {
                        this.f22230f.d0();
                    }
                    this.f22230f.I = 0.0f;
                    this.f22229e = 0.0f;
                } else if (action != 2) {
                    if (this.f22230f.I <= (this.f22230f.f22215a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.f22230f.I) {
                        this.f22230f.i0();
                    } else {
                        this.f22230f.d0();
                    }
                    this.f22230f.I = 0.0f;
                    this.f22229e = 0.0f;
                } else {
                    if (motionEvent.getRawY() < this.f22230f.I) {
                        this.f22230f.m0(motionEvent.getRawY() - this.f22230f.I);
                        if (this.f22230f.J != null) {
                            this.f22230f.J.setVisibility(8);
                        }
                    }
                    if (Math.abs(motionEvent.getRawY() - this.f22230f.I) > this.f22229e) {
                        this.f22229e = Math.abs(motionEvent.getRawY() - this.f22230f.I);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22231e;

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
                    return;
                }
            }
            this.f22231e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22231e.d0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22233f;

        public g(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22233f = bVar;
            this.f22232e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.f22233f.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f22233f.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.f22233f.I();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.f22233f.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.f22232e < 0.2d) {
                            if (this.f22233f.m.getParent() != this.f22233f.m.getRootView() && (viewGroup = (ViewGroup) this.f22233f.m.getRootView()) != null) {
                                ((ViewGroup) this.f22233f.m.getParent()).removeView(this.f22233f.m);
                                if (this.f22233f.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.f22233f.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.f22233f.H);
                                viewGroup.bringChildToFront(this.f22233f.J);
                            }
                        } else if (this.f22233f.m.getParent() == this.f22233f.m.getRootView()) {
                            if (this.f22233f.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.f22233f.m.getRootView();
                                ((ViewGroup) this.f22233f.m.getParent()).removeView(this.f22233f.m);
                            }
                            if (this.f22233f.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.f22233f.f22216b.getRootLayout().addView(this.f22233f.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.f22233f.K = false;
                this.f22233f.q0(((intValue - this.f22232e) * 2) + 0);
                this.f22233f.K = true;
                float abs = Math.abs(intValue / this.f22232e);
                this.f22233f.f22218d.setAlpha(abs);
                View u = this.f22233f.f22216b.getTabViewController().u();
                if (u != null) {
                    u.setAlpha(abs);
                }
                View findViewById = this.f22233f.f22216b.getRootLayout().getRootView().findViewById(R.id.tabcontainer_wrapper);
                if (findViewById != null) {
                    findViewById.setAlpha(abs);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f22235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f22236g;

        public h(b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22236g = bVar;
            this.f22234e = i2;
            this.f22235f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f22236g.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.f22236g.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.f22236g.I();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.f22236g.m.setLayoutParams(layoutParams2);
                    }
                }
                this.f22236g.f22217c.v();
                this.f22236g.f22218d.completePullRefresh();
                this.f22236g.f22217c.y(0, -this.f22236g.f22217c.l(), 0, 0);
                this.f22236g.K = false;
                this.f22236g.q0(0 - (this.f22234e * 2));
                this.f22236g.K = true;
                this.f22236g.f22218d.setVisibility(8);
                this.f22236g.H.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.f22235f;
                if (this.f22236g.H.getParent() == null) {
                    frameLayout.addView(this.f22236g.H, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.f22236g.J.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.f22236g.f22215a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.f22236g.J, layoutParams3);
                }
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
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22237e;

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
            this.f22237e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f22237e.m0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22238e;

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
            this.f22238e = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f22238e.m0(0.0f);
                this.f22238e.f22217c.v();
                this.f22238e.f22218d.completePullRefresh();
                this.f22238e.f22217c.y(0, -this.f22238e.f22217c.l(), 0, 0);
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
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22239e;

        public k(b bVar) {
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
            this.f22239e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f22239e.m0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22240e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f22241e;

            /* renamed from: c.a.q0.m0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC1033a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f22242e;

                public RunnableC1033a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f22242e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f22242e.f22241e.f22240e.K = false;
                    }
                }
            }

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22241e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.f22241e.f22240e.H.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f22241e.f22240e.H);
                        viewGroup.removeView(this.f22241e.f22240e.J);
                    }
                    this.f22241e.f22240e.J.setVisibility(0);
                    this.f22241e.f22240e.K = false;
                    this.f22241e.f22240e.l0();
                    this.f22241e.f22240e.C = 0;
                    this.f22241e.f22240e.q0(0);
                    this.f22241e.f22240e.K = true;
                    this.f22241e.f22240e.f22217c.v();
                    this.f22241e.f22240e.f22218d.completePullRefresh();
                    this.f22241e.f22240e.f22217c.y(0, -this.f22241e.f22240e.f22217c.l(), 0, 0);
                    c.a.e.e.m.e.a().postDelayed(new RunnableC1033a(this), 0L);
                    this.f22241e.f22240e.f22218d.setVisibility(0);
                }
            }
        }

        public l(b bVar) {
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
            this.f22240e = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                c.a.e.e.m.e.a().post(new a(this));
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
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f22243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22244f;

        public m(b bVar) {
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
            this.f22244f = bVar;
            this.f22243e = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f22244f.f22216b.isPrimary() && this.f22243e != 1 && i2 == 0) {
                    for (int i5 = i2; i5 < i2 + i3; i5++) {
                        Object itemAtPosition = this.f22244f.f22218d.getItemAtPosition(i5);
                        if (itemAtPosition != null && (itemAtPosition instanceof x)) {
                            x xVar = (x) itemAtPosition;
                            if (xVar.g() == 1 && this.f22244f.f22218d.getItemAtPosition(i5) == ListUtils.getItem(this.f22244f.f22220f, 0)) {
                                this.f22244f.w0(xVar, this.f22244f.f22218d.getChildAt(i5).findViewById(R.id.forum_intro));
                            }
                        }
                    }
                }
                this.f22244f.r.onScroll(absListView, i2, i3, i4);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                this.f22244f.r.onScrollStateChanged(absListView, i2);
                if (this.f22243e != i2) {
                    this.f22243e = i2;
                    if (i2 == 1) {
                        if (this.f22244f.s == null || !this.f22244f.s.f21916a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                        }
                        this.f22244f.N();
                        return;
                    }
                    this.f22244f.E();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22245e;

        public n(b bVar) {
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
            this.f22245e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f22245e.s != null && this.f22245e.s.f21916a) {
                b bVar = this.f22245e;
                if (bVar.E) {
                    EnterForumAdView unused = bVar.m;
                    EnterForumAdView.clickAd(this.f22245e.f22216b.getUniqueId(), this.f22245e.f22216b.getContext());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22246a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22246a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f22246a.v0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22247a;

        public p(b bVar) {
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
            this.f22247a = bVar;
        }

        @Override // c.a.q0.m0.m.d.c
        public void a(AbsListView absListView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, absListView, i2, i3) == null) || this.f22247a.K) {
                return;
            }
            this.f22247a.B = -i2;
            b bVar = this.f22247a;
            if (bVar.E) {
                bVar.e0();
            } else if (bVar.s == null || !this.f22247a.s.f21916a) {
            } else {
                this.f22247a.l0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22248a;

        public q(b bVar) {
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
            this.f22248a = bVar;
        }

        @Override // c.a.e.l.e.c.a
        public void a(c.a.e.l.e.c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.f22248a.C = i4;
                b bVar = this.f22248a;
                if (bVar.E || bVar.s == null || !this.f22248a.s.f21916a || this.f22248a.K) {
                    return;
                }
                this.f22248a.l0();
                if (i4 > this.f22248a.w) {
                    this.f22248a.C = 0;
                    b bVar2 = this.f22248a;
                    bVar2.u0(bVar2.f22216b.getTabViewController().s());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22249e;

        public r(b bVar) {
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
            this.f22249e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22249e.e0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22250e;

        public s(b bVar) {
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
            this.f22250e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22250e.O();
                this.f22250e.y0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22251a;

        public t(b bVar) {
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
            this.f22251a = bVar;
        }

        @Override // c.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(this.f22251a.q);
                this.f22251a.f22216b.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1634558499, "Lc/a/q0/m0/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1634558499, "Lc/a/q0/m0/m/b;");
        }
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment, view, viewEventCenter, recentlyVisitedForumModel, enterForumModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = true;
        this.y = new a(this);
        this.z = new m(this);
        this.A = new n(this);
        this.B = 0;
        this.C = 0;
        this.D = new o(this, 2921474);
        this.E = false;
        this.F = false;
        this.G = new r(this);
        this.K = false;
        this.f22216b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + c.a.e.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = c.a.e.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = c.a.e.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f22222h = viewEventCenter;
        R(view);
        c.a.q0.m0.c.a aVar = new c.a.q0.m0.c.a(this.f22216b.getPageContext(), this.f22222h, recentlyVisitedForumModel, enterForumModel, this);
        this.f22219e = aVar;
        this.f22218d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        g0();
        this.o = new GuidePopupWindow(this.f22216b.getFragmentActivity());
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (U()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            c.a.q0.m0.d.c cVar = this.s;
            if (cVar != null && cVar.f21916a) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
            }
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.m0.c.a aVar = this.f22219e;
            if (aVar == null) {
                return false;
            }
            return aVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.E) {
                this.F = true;
                return;
            }
            this.F = false;
            this.f22218d.completePullRefreshPostDelayed(0L);
        }
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.E ? -this.f22215a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
        }
        return invokeV.intValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22215a.getResources().getDimensionPixelOffset(R.dimen.tbds934) : invokeV.intValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdListView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22218d : (BdListView) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (this.u - this.v) - (EnterForumDelegateStatic.f50003c.B() != null ? this.f22215a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        }
        return invokeV.intValue;
    }

    public c.a.p0.f0.h M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (c.a.p0.f0.h) invokeV.objValue;
    }

    public void N() {
        c.a.e.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.d();
        this.p = null;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.p0.f0.h hVar = this.k;
            if (hVar != null) {
                hVar.dettachView(this.l);
                this.k = null;
                this.l = null;
            }
            this.f22218d.setVisibility(0);
            if (this.f22216b.getTabViewController() != null) {
                this.f22216b.getTabViewController().L();
                this.f22216b.getTabViewController().P();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.e.e.p.l.g(this.f22215a, R.dimen.tbds240);
            View view = new View(this.f22215a);
            this.H = view;
            view.setOnClickListener(new d(this));
            this.H.setOnTouchListener(new e(this));
            ImageView imageView = new ImageView(this.f22215a);
            this.J = imageView;
            imageView.setOnClickListener(new f(this));
        }
    }

    public void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            EnterForumAdView enterForumAdView = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
            this.m = enterForumAdView;
            if (enterForumAdView != null) {
                l0();
                this.m.setTag(this.f22216b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.f22222h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.f22215a = view.getContext();
            c.a.q0.m0.m.d dVar = new c.a.q0.m0.m.d();
            this.r = dVar;
            dVar.a(new p(this));
            this.f22218d = (BdListView) view.findViewById(R.id.listview);
            q0(0);
            this.f22218d.setBackgroundColor(0);
            this.f22218d.setVerticalScrollBarEnabled(false);
            this.f22218d.setOnScrollListener(this.z);
            this.f22218d.setFastScrollEnabled(false);
            this.f22218d.setMaxHeight(this.f22215a.getResources().getDisplayMetrics().heightPixels);
            BdListView.setPullRefreshRatio(1.0f);
            if (this.f22216b.getTabViewController() != null) {
                this.f22216b.getTabViewController().S(this);
            }
            c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f22216b.getPageContext());
            this.f22217c = gVar;
            gVar.x(new q(this));
            this.f22217c.U(true);
            this.f22217c.a(this.y);
            c.a.p0.s.f0.g gVar2 = this.f22217c;
            if (gVar2 != null) {
                gVar2.V(this.f22216b.getUniqueId());
            }
            this.f22218d.setPullRefresh(this.f22217c);
            FrameLayout frameLayout = new FrameLayout(this.f22216b.getPageContext().getPageActivity());
            View view2 = new View(this.f22216b.getPageContext().getPageActivity());
            this.n = view2;
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
            this.f22218d.getAdapter2().e(frameLayout, 0);
            this.f22224j = new View(this.f22216b.getActivity());
            this.f22224j.setLayoutParams(new AbsListView.LayoutParams(-1, c.a.e.e.p.l.g(this.f22216b.getActivity(), R.dimen.ds50)));
            this.f22224j.setBackgroundResource(R.color.CAM_X0201);
            this.f22217c.N(this.A);
            this.f22217c.getView().setOnClickListener(this.A);
            this.n.setOnClickListener(this.A);
            P();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ListUtils.isEmpty(this.f22220f) : invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.isLogin() && !c.a.p0.s.d0.b.j().g("has_guide_popup_window_been_shown", false) : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BdListView bdListView = this.f22218d;
            return bdListView == null || bdListView.getChildCount() == 0 || this.f22218d.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f22219e.notifyDataSetChanged();
            View view = this.f22224j;
            if (view == null || view.getLayoutParams() == null) {
                return;
            }
            if (z) {
                this.f22224j.getLayoutParams().height = c.a.e.e.p.l.g(this.f22215a, R.dimen.ds50);
                return;
            }
            this.f22224j.getLayoutParams().height = c.a.e.e.p.l.g(this.f22215a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.f22218d.removeFooterView(this.f22224j);
                this.f22218d.addFooterView(this.f22224j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f22218d.removeFooterView(this.f22224j);
            }
            c.a.p0.s.f0.g gVar = this.f22217c;
            if (gVar != null) {
                gVar.D(i2);
            }
            c.a.p0.f0.h hVar = this.k;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            GuidePopupWindow guidePopupWindow = this.o;
            if (guidePopupWindow != null) {
                guidePopupWindow.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.f22224j, R.color.CAM_X0201);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            CommonTipView commonTipView = this.f22223i;
            if (commonTipView != null) {
                commonTipView.onDestroy();
            }
            c.a.q0.m0.c.a aVar = this.f22219e;
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public void Y(View view, int i2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048596, this, view, i2) == null) || view == (bdListView = this.f22218d)) {
            return;
        }
        bdListView.smoothScrollBy(-i2, 100);
        c.a.e.e.p.l.g(this.f22215a, R.dimen.tbds240);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            N();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.f22216b.isAdded() && this.f22216b.isPrimary()) {
                M = false;
                c.a.q0.m0.c.a aVar = this.f22219e;
                if (aVar != null) {
                    aVar.h();
                    BdListView bdListView = this.f22218d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.f22218d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof x) && ((x) itemAtPosition).g() == 5) {
                            this.f22219e.m();
                        }
                    }
                }
                if (this.K) {
                    this.m.requestFocus();
                    this.m.requestFocusFromTouch();
                    return;
                }
                return;
            }
            N();
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f22219e.i(i2);
        }
    }

    public void c0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || TbadkCoreApplication.getCurrentAccount() != null || !c.a.p0.s.d0.b.j().g("enter_forum_login_tip", true) || (enterForumFragment = this.f22216b) == null || enterForumFragment.getActivity() == null || this.f22216b.getTabLayout() == null) {
            return;
        }
        if (this.f22223i == null) {
            this.f22223i = new CommonTipView(this.f22216b.getActivity());
        }
        this.f22223i.setText(R.string.enter_forum_login_tip);
        this.f22223i.show(this.f22216b.getTabLayout(), TbadkCoreApplication.getInst().getSkinType());
        c.a.p0.s.d0.b.j().t("enter_forum_login_tip", false);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.H.setEnabled(false);
            int H = H();
            Math.abs(H / (L() - H));
            this.J.setVisibility(8);
            int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), H);
            ofInt.addUpdateListener(new k(this));
            ofInt.addListener(new l(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.E = false;
            l0();
            q0(0);
            if (this.F) {
                this.f22218d.completePullRefreshPostDelayed(0L);
            }
            this.F = false;
        }
    }

    public void f0(List<c.a.q0.m0.d.f> list, q1 q1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, list, q1Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.f50003c.D(this.f22215a);
            this.f22220f = list;
            this.f22221g = q1Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            x xVar = new x();
            xVar.i(4);
            arrayList.add(xVar);
            if (z3) {
                arrayList.add(new c.a.q0.m0.d.a(true));
                arrayList.add(new c.a.q0.m0.d.e(this.f22215a.getResources().getString(R.string.my_attention_bar), z2));
                arrayList.addAll(list);
                arrayList.add(q1Var);
            } else {
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new c.a.q0.m0.d.e(this.f22215a.getResources().getString(R.string.my_attention_bar), z2));
                }
                if (TbadkCoreApplication.isLogin()) {
                    x xVar2 = new x();
                    xVar2.i(11);
                    arrayList.add(xVar2);
                } else {
                    x xVar3 = new x();
                    xVar3.i(3);
                    arrayList.add(xVar3);
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new r1(this.f22215a.getResources().getString(R.string.recommend_forum_title_vertical), true));
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.addAll(q1Var.k());
                }
                if (TbadkCoreApplication.isLogin()) {
                    arrayList.add(new c.a.q0.m0.d.a(false));
                }
            }
            if (z) {
                x xVar4 = new x();
                xVar4.i(5);
                arrayList.add(xVar4);
            }
            O();
            this.f22219e.k(arrayList, z);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f22216b.registerListener(this.D);
        }
    }

    public void h0(c.a.q0.m0.d.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048605, this, fVar, z) == null) {
            this.f22220f.remove(fVar);
            f0(this.f22220f, this.f22221g, z);
            V(z);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ImageView imageView = this.J;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(J(), 0);
            ofInt.addUpdateListener(new i(this));
            ofInt.addListener(new j(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public void j0() {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.K) {
            return;
        }
        this.E = true;
        l0();
        int dimensionPixelOffset = this.f22215a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f22217c.l();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.isRecentlyShow()) {
                dimensionPixelSize = this.f22215a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.f22215a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.isRecentlyExtend()) {
                dimensionPixelSize = this.f22215a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        q0(dimensionPixelOffset);
        c.a.e.e.m.e.a().removeCallbacks(this.G);
        c.a.e.e.m.e.a().postDelayed(this.G, 3000L);
    }

    public void k0(c.a.q0.m0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.s = cVar;
            c.a.q0.m0.c.a aVar = this.f22219e;
            if (aVar != null) {
                aVar.j(cVar);
            }
            if (cVar != null && cVar.f21916a) {
                if (this.f22217c.getView() != null) {
                    this.f22217c.getView().setScaleX(0.5f);
                    this.f22217c.getView().setScaleY(0.5f);
                }
                this.f22217c.L(R.raw.ad_refresh_load);
                return;
            }
            if (this.f22217c.getView() != null) {
                this.f22217c.getView().setScaleX(1.0f);
                this.f22217c.getView().setScaleY(1.0f);
            }
            this.f22217c.L(R.raw.lottie_common_pull_refresh);
        }
    }

    public final void l0() {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.K || (enterForumAdView = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int I = I();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.E ? -this.f22215a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
            this.m.setLayoutParams(layoutParams2);
            this.m.setAdViewHeight(layoutParams2.height - I);
        }
    }

    public final void m0(float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f2) == null) {
            int H = H();
            int L = L() - H;
            float f3 = H;
            float abs = Math.abs(f3 / L);
            int i2 = (int) f2;
            EnterForumAdView enterForumAdView = this.m;
            if (enterForumAdView != null) {
                ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    I();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, i2, 0, 0);
                    this.m.setLayoutParams(marginLayoutParams);
                    if (Math.abs(marginLayoutParams.topMargin) < marginLayoutParams.height * 0.2d) {
                        if (this.m.getParent() != this.m.getRootView() && (viewGroup = (ViewGroup) this.m.getRootView()) != null) {
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                            if (this.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                viewGroup.addView(this.m, marginLayoutParams2);
                            }
                            viewGroup.bringChildToFront(this.H);
                            viewGroup.bringChildToFront(this.J);
                        }
                    } else if (this.m.getParent() == this.m.getRootView()) {
                        if (this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                        }
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            this.f22216b.getRootLayout().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.f22218d.setVisibility(0);
            this.K = false;
            float f4 = i2;
            q0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.K = true;
            float abs2 = Math.abs(f4 / f3);
            this.f22218d.setAlpha(abs2);
            View u = this.f22216b.getTabViewController().u();
            if (u != null) {
                u.setAlpha(abs2);
            }
            View findViewById = this.f22216b.getRootLayout().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }

    public void n0(c.a.q0.m0.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) || aVar == null) {
            return;
        }
        if (StringUtils.isNull(aVar.d())) {
            this.L = false;
        } else {
            this.L = true;
        }
        this.o.setForumId(aVar.c());
        this.o.setNumber(aVar.b(), aVar.e());
        this.o.setBaName(aVar.a());
        this.o.setmForumName(aVar.d());
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || this.t == z) {
            return;
        }
        this.t = z;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22218d.getLayoutParams();
        if (!z) {
            marginLayoutParams.topMargin += this.f22218d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        } else {
            marginLayoutParams.topMargin -= this.f22218d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
        }
        this.f22218d.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.K) {
            d0();
        }
    }

    public void p0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, gVar) == null) {
            this.x = gVar;
        }
    }

    public final void q0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || this.K) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22218d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f50003c.B() != null ? this.f22215a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f22218d.setLayoutParams(marginLayoutParams);
    }

    public void r0(BdUniqueId bdUniqueId) {
        c.a.q0.m0.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, bdUniqueId) == null) || (aVar = this.f22219e) == null) {
            return;
        }
        aVar.l(bdUniqueId);
    }

    public void s0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsExtend(z);
    }

    public void t0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || (enterForumAdView = this.m) == null) {
            return;
        }
        enterForumAdView.setRecentlyIsShow(z);
    }

    public void u0(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, view) == null) && (view instanceof FrameLayout) && !this.K) {
            this.f22217c.r();
            this.K = true;
            this.m.getAdImageView().getLocationInWindow(new int[2]);
            SkinManager.setImageResource(this.J, R.drawable.icon_jinba_retract_n);
            int J = J();
            ValueAnimator ofInt = ValueAnimator.ofInt(J, 0);
            ofInt.addUpdateListener(new g(this, J));
            ofInt.addListener(new h(this, J, view));
            ofInt.setDuration(300L);
            ofInt.start();
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && T() && this.L) {
            this.o.setUserHeadImg();
            this.o.setUserNickName();
            this.o.setCancelable(false);
            c.a.p0.s.d0.b.j().t("has_guide_popup_window_been_shown", true);
            c.a.e.e.m.g.i(this.o, this.f22216b.getFragmentActivity());
        }
    }

    public void w0(x xVar, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, xVar, view) == null) || !TbadkCoreApplication.isLogin() || M || this.f22216b.getActivity() == null || this.f22216b.getPageContext() == null || !(xVar instanceof c.a.q0.m0.d.f)) {
            return;
        }
        c.a.q0.m0.d.f fVar = (c.a.q0.m0.d.f) xVar;
        if (fVar.F() != 0 && fVar.E() != 0 && !c.a.p0.s.d0.b.j().p("enter_forum_new_forum_long_press_guide", "").equals(fVar.p())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (c.a.p0.s.d0.b.j().l("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            c.a.e.e.g.d dVar = new c.a.e.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t(this));
            dVar.g(new C1032b(this));
            c.a.e.e.g.c b2 = dVar.b();
            this.p = b2;
            b2.k(false);
            this.p.l(true);
            this.p.m(this.f22216b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                c.a.p0.s.d0.b.j().x("enter_forum_new_forum_long_press_guide", fVar.p());
            } else if (i2 == R.string.forum_item_guide_tip) {
                c.a.p0.s.d0.b.j().w("enter_forum_long_press_guide", 1L);
            }
            c.a.e.e.m.e.a().postDelayed(new c(this), 5000L);
        }
    }

    public void x0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view) == null) {
            if (this.k == null) {
                this.k = new c.a.p0.f0.h(this.f22216b.getPageContext().getContext(), new s(this));
            }
            this.l = view;
            this.k.j(this.f22216b.getResources().getDimensionPixelSize(R.dimen.ds364));
            this.k.attachView(view, false);
            this.k.o();
            this.f22218d.setVisibility(8);
            if (this.f22216b.getTabViewController() != null) {
                this.f22216b.getTabViewController().L();
                this.f22216b.getTabViewController().P();
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f22218d.startPullRefresh();
        }
    }
}
