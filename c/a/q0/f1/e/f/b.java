package c.a.q0.f1.e.f;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.l.v0.a;
import c.a.p0.s.f0.f;
import c.a.q0.i0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoTitleBar;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public c.a.q0.i0.a B;
    public NEGFeedBackView.b C;
    public f.h D;
    public f.InterfaceC0681f E;
    public CustomMessageListener F;
    public View.OnTouchListener G;
    public a.b H;
    public CustomMessageListener I;
    public RecyclerView.RecyclerListener J;
    public RecyclerView.OnScrollListener K;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17515a;

    /* renamed from: b  reason: collision with root package name */
    public View f17516b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f17517c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f17518d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.f1.h.i.a f17519e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f17520f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f0.g f17521g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17522h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17523i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.f1.e.a.a f17524j;
    public View k;
    public FrameLayout l;
    public c.a.p0.f0.h m;
    public GameVideoTitleBar n;
    public AlphaAnimation o;
    public AlphaAnimation p;
    public boolean q;
    public RotateAnimation r;
    public RotateAnimation s;
    public boolean t;
    public boolean u;
    public c.a.q0.o2.i v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17525a;

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
            this.f17525a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f17525a.f17522h == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17525a.f17522h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.f17525a.t = false;
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

    /* renamed from: c.a.q0.f1.e.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class animation.Animation$AnimationListenerC0849b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17526a;

        public animation.Animation$AnimationListenerC0849b(b bVar) {
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
            this.f17526a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f17526a.f17522h == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17526a.f17522h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.f17526a.t = false;
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

    /* loaded from: classes3.dex */
    public class c implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17527a;

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
            this.f17527a = bVar;
        }

        @Override // c.a.p0.s.f0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f17527a.m0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements f.InterfaceC0681f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17528a;

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
            this.f17528a = bVar;
        }

        @Override // c.a.p0.s.f0.f.InterfaceC0681f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f17528a.X(true);
                if (this.f17528a.v == null || this.f17528a.y || !this.f17528a.z) {
                    return;
                }
                this.f17528a.v.n(this.f17528a.w, this.f17528a.x, this.f17528a.u, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17529a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f17530e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17530e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17530e.f17529a.f17524j.c();
                    if (this.f17530e.f17529a.y || !this.f17530e.f17529a.z) {
                        return;
                    }
                    this.f17530e.f17529a.v.n(this.f17530e.f17529a.w, this.f17530e.f17529a.x, this.f17530e.f17529a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar, int i2) {
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
            this.f17529a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.e.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17531e;

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
            this.f17531e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f17531e.B != null) {
                    this.f17531e.B.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17532a;

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
            this.f17532a = bVar;
        }

        @Override // c.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f17532a.u = false;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f17532a.u = true;
            }
        }

        @Override // c.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17533a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b bVar, int i2) {
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
            this.f17533a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder v;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (v = this.f17533a.v()) == null || v.getCardView() == null) {
                    return;
                }
                v.getCardView().o(new a.C0096a(3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17534a;

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
            this.f17534a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f17534a.v != null) {
                this.f17534a.v.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17535a;

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
            this.f17535a = bVar;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f17535a.w = i2;
                this.f17535a.x = (i2 + i3) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (i2 == 1) {
                    this.f17535a.k0();
                    return;
                }
                b bVar = this.f17535a;
                if (bVar.M(bVar.f17517c)) {
                    this.f17535a.u();
                }
                if (i2 == 0 && this.f17535a.v != null && this.f17535a.z) {
                    this.f17535a.v.m(this.f17535a.w, this.f17535a.x, this.f17535a.u, 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                int i5 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i4 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i5 = bdRecyclerView.getFirstVisiblePosition();
                    i4 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i5, (i4 - i5) + 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17536a;

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
            this.f17536a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f17536a.k.setVisibility(8);
                this.f17536a.q = false;
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

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = true;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this, 2921420);
        this.G = new f(this);
        this.H = new g(this);
        this.I = new h(this, 2921381);
        this.J = new i(this);
        this.K = new j(this);
        this.f17515a = tbPageContext;
        this.A = bdUniqueId;
        this.C = bVar;
        D();
    }

    public void A() {
        c.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f17521g) == null) {
            return;
        }
        gVar.dettachView(this.f17516b);
    }

    public void B() {
        c.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this.l);
        this.m = null;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17517c.addOnScrollListener(this.K);
            this.f17517c.setOnTouchListener(this.G);
            this.f17517c.setRecyclerListener(this.J);
            this.B.d(this.H);
            this.f17519e.b(this.D);
            this.f17519e.h(this.E);
            this.f17519e.V(this.f17515a.getUniqueId());
            O();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f17515a.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
            this.f17516b = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.n = (GameVideoTitleBar) this.f17516b.findViewById(R.id.game_video_title_bar);
            this.l = (FrameLayout) this.f17516b.findViewById(R.id.game_video_framelayout);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f17516b.findViewById(R.id.game_video_recycle_view);
            this.f17517c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f17515a.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f17517c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.B = new c.a.q0.i0.a();
            c.a.q0.o2.i iVar = new c.a.q0.o2.i(this.f17515a, this.f17517c);
            this.v = iVar;
            iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.v.t(this.A);
            this.f17518d = (BigdaySwipeRefreshLayout) this.f17516b.findViewById(R.id.game_video_refresh_layout);
            c.a.q0.f1.h.i.a aVar = new c.a.q0.f1.h.i.a(this.f17515a);
            this.f17519e = aVar;
            this.f17518d.setProgressView(aVar);
            int i2 = (int) (this.f17515a.getResources().getDisplayMetrics().density * 86.0f);
            this.f17518d.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.f17515a.getPageActivity());
            this.f17520f = pbListView;
            pbListView.a();
            this.f17520f.o(R.color.transparent);
            this.f17520f.r(l.g(this.f17515a.getPageActivity(), R.dimen.tbds178));
            this.f17520f.v();
            this.f17520f.E(R.dimen.tbfontsize36);
            this.f17520f.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f17520f.y(R.color.CAM_X0110);
            this.f17520f.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c.a.q0.f1.e.a.a aVar2 = new c.a.q0.f1.e.a.a(this.f17515a, this.f17517c);
            this.f17524j = aVar2;
            aVar2.h(this.C);
            this.f17524j.i(this.A);
            this.k = this.f17516b.findViewById(R.id.game_video_divider_shadow);
            this.f17522h = (ImageView) this.f17516b.findViewById(R.id.game_video_select_icon);
            TextView textView = (TextView) this.f17516b.findViewById(R.id.game_video_game_title);
            this.f17523i = textView;
            textView.setText(c.a.p0.s.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""));
            r();
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.f0.g gVar = this.f17521g;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void G() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeRecyclerView = this.f17517c) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        u();
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.y = z;
            c.a.q0.o2.i iVar = this.v;
            if (iVar == null) {
                return;
            }
            iVar.q(!z);
            ThreadCardViewHolder v = v();
            boolean z2 = false;
            if (v != null && v.getCardView() != null) {
                z2 = v.getCardView().o(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.v.w();
            } else if (this.z) {
                this.v.n(this.w, this.x, this.u, true);
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.f0.g gVar = this.f17521g;
            if (gVar != null) {
                gVar.m();
            }
            AlphaAnimation alphaAnimation = this.o;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = this.p;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
            }
            n0(null);
            c.a.q0.f1.h.i.a aVar = this.f17519e;
            if (aVar != null) {
                aVar.T();
            }
            c.a.q0.f1.e.a.a aVar2 = this.f17524j;
            if (aVar2 != null) {
                aVar2.d();
            }
            RotateAnimation rotateAnimation = this.r;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
            }
            RotateAnimation rotateAnimation2 = this.s;
            if (rotateAnimation2 != null) {
                rotateAnimation2.cancel();
            }
            c.a.q0.o2.i iVar = this.v;
            if (iVar != null) {
                iVar.h();
            }
            t();
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.F);
        }
    }

    public void J() {
        c.a.q0.f1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f17524j) == null) {
            return;
        }
        aVar.e();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            H(true);
        }
    }

    public void L() {
        c.a.q0.o2.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (iVar = this.v) != null && this.z) {
            iVar.n(this.w, this.x, this.u, true);
        }
    }

    public final boolean M(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void N() {
        c.a.q0.f1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.f17524j) == null) {
            return;
        }
        aVar.c();
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.F.setTag(this.A);
            MessageManager.getInstance().registerListener(this.F);
            this.I.setTag(this.A);
            MessageManager.getInstance().registerListener(this.I);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            List<Integer> z = z(str, this.f17517c);
            int intValue = z.get(0).intValue();
            int intValue2 = z.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.f17517c.removeItemList(intValue, intValue2);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public void R(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (imageView = this.f17522h) == null) {
            return;
        }
        imageView.setVisibility(0);
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17522h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17522h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundResource(this.n, R.color.CAM_X0207);
    }

    public void S(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            c.a.q0.f1.e.a.a aVar = this.f17524j;
            if (aVar != null) {
                aVar.f(list);
            }
            L();
        }
    }

    public void T(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || StringUtils.isNull(str) || (textView = this.f17523i) == null) {
            return;
        }
        textView.setVisibility(0);
        this.f17523i.setText(str);
    }

    public void U(int i2) {
        c.a.q0.f1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (aVar = this.f17524j) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void V(f.g gVar) {
        c.a.q0.f1.h.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, gVar) == null) || (aVar = this.f17519e) == null) {
            return;
        }
        aVar.a(gVar);
    }

    public void W(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (imageView = this.f17522h) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.z = z;
        }
    }

    public void Y(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, pVar) == null) || (bdTypeRecyclerView = this.f17517c) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.y = z;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            H(false);
        }
    }

    public void b0(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) || (pbListView = this.f17520f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f17517c.setNextPage(this.f17520f);
        }
        this.f17520f.r(l.g(this.f17515a.getPageActivity(), R.dimen.tbds178));
        this.f17520f.A(this.f17515a.getResources().getString(R.string.game_video_click_load));
        this.f17520f.z(onClickListener);
        this.f17520f.f();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.s == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
                this.s = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.s.setInterpolator(new AccelerateInterpolator());
                this.s.setFillAfter(true);
                this.s.setAnimationListener(new animation.Animation$AnimationListenerC0849b(this));
            }
            this.f17522h.startAnimation(this.s);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.r == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
                this.r = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.r.setInterpolator(new AccelerateInterpolator());
                this.r.setFillAfter(true);
                this.r.setAnimationListener(new a(this));
            }
            this.f17522h.startAnimation(this.r);
        }
    }

    public void e0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (textView = this.f17523i) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void f0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (pbListView = this.f17520f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f17517c.setNextPage(this.f17520f);
        }
        this.f17520f.r(l.g(this.f17515a.getPageActivity(), R.dimen.tbds178));
        this.f17520f.A(this.f17515a.getResources().getString(R.string.loading));
        this.f17520f.z(null);
        this.f17520f.O();
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || F()) {
            return;
        }
        if (this.f17521g == null) {
            c.a.p0.f0.g gVar = new c.a.p0.f0.g(this.f17515a.getPageActivity());
            this.f17521g = gVar;
            gVar.h();
            this.f17521g.q((((this.f17516b.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(this.f17515a.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
            this.f17521g.onChangeSkinType();
        }
        this.f17521g.attachView(this.f17516b, false);
    }

    public void h0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            if (this.m == null) {
                this.m = new c.a.p0.f0.h(this.f17515a.getPageActivity(), onClickListener);
            }
            this.m.o();
            this.m.l(null);
            this.m.m(this.f17515a.getResources().getString(R.string.refresh_view_title_text));
            this.m.i(R.drawable.new_pic_emotion_08);
            this.m.k(0);
            this.m.attachView(this.l, false);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.m == null) {
                this.m = new c.a.p0.f0.h(this.f17515a.getPageActivity(), null);
            }
            this.m.e();
            this.m.i(R.drawable.new_pic_emotion_03);
            this.m.n(this.f17515a.getString(R.string.no_data_common_txt));
            this.m.attachView(this.l, false);
        }
    }

    public void j0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (pbListView = this.f17520f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f17517c.setNextPage(this.f17520f);
        }
        this.f17520f.r(l.g(this.f17515a.getPageActivity(), R.dimen.tbds178));
        this.f17520f.A(this.f17515a.getResources().getString(R.string.game_video_no_more));
        this.f17520f.z(null);
        this.f17520f.f();
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.q) {
            return;
        }
        this.q = true;
        this.k.setVisibility(0);
        if (this.o == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.o = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.o.setDuration(300L);
        }
        this.k.startAnimation(this.o);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f17518d.setRefreshing(true);
        }
    }

    public void m0() {
        c.a.q0.o2.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.w();
    }

    public void n0(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iVar) == null) {
            this.f17518d.refreshFinishWithMsgRemind(iVar);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f17522h != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17522h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            }
            c.a.p0.f0.g gVar = this.f17521g;
            if (gVar != null) {
                gVar.p(TbadkCoreApplication.getInst().getSkinType());
                this.f17521g.onChangeSkinType();
            }
            c.a.p0.f0.h hVar = this.m;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            TextView textView = this.f17523i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            c.a.q0.f1.h.i.a aVar = this.f17519e;
            if (aVar != null) {
                aVar.D(skinType);
            }
            c.a.q0.f1.e.a.a aVar2 = this.f17524j;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            S(new LinkedList());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f17517c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.K);
                this.f17517c.setOnTouchListener(null);
                this.f17517c.setRecyclerListener(null);
            }
            c.a.q0.i0.a aVar = this.B;
            if (aVar != null) {
                aVar.d(null);
            }
            c.a.q0.f1.h.i.a aVar2 = this.f17519e;
            if (aVar2 != null) {
                aVar2.b(null);
                this.f17519e.h(null);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.q) {
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
                this.p.setAnimationListener(new k(this));
            }
            this.k.startAnimation(this.p);
        }
    }

    public ThreadCardViewHolder v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            c.a.q0.o2.i iVar = this.v;
            if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.v.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<n> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            c.a.q0.f1.e.a.a aVar = this.f17524j;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f17516b.findViewById(R.id.game_video_title_bar) : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f17516b : (View) invokeV.objValue;
    }

    public final List<Integer> z(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c.a.q0.a0.d0.b) {
                    c.a.q0.a0.d0.b bVar = (c.a.q0.a0.d0.b) item;
                    if (bVar.getThreadData() != null && bVar.getThreadData().q1().equals(str)) {
                        if (!z) {
                            i2 = i4;
                        }
                        z = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
