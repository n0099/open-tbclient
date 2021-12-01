package c.a.r0.a0.f.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.x2.f;
import c.a.r0.x2.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.toplivecard.AlaSquareLiveVideoMask;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f13905b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f13906c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f13907d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.x2.f f13908e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a0.f.b.b.c f13909f;

    /* renamed from: g  reason: collision with root package name */
    public int f13910g;

    /* renamed from: h  reason: collision with root package name */
    public int f13911h;

    /* renamed from: i  reason: collision with root package name */
    public int f13912i;

    /* renamed from: j  reason: collision with root package name */
    public int f13913j;

    /* renamed from: k  reason: collision with root package name */
    public int f13914k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.h p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes5.dex */
    public class a implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13915e;

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
            this.f13915e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13915e.r();
            }
        }
    }

    /* renamed from: c.a.r0.a0.f.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0844b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13916e;

        public C0844b(b bVar) {
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
            this.f13916e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f13916e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13917e;

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
            this.f13917e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13917e.f13907d == null) {
                return;
            }
            this.f13917e.f13907d.setLooping(false);
            this.f13917e.f13907d.setVolume(0.0f, 0.0f);
            if (this.f13917e.f13909f != null && this.f13917e.f13909f.a != null) {
                if (this.f13917e.m) {
                    if (this.f13917e.n != null) {
                        this.f13917e.n.b(this.f13917e.f13909f.a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f13917e.f13909f.f13883b != 0) {
                        if (this.f13917e.f13909f.f13883b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f13917e.f13909f.a.v1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f13917e.f13907d.getCyberPlayer() != null) {
                b bVar = this.f13917e;
                bVar.v(bVar.f13907d.getCyberPlayer().getVideoHeight(), this.f13917e.f13907d.getCyberPlayer().getVideoWidth());
            }
            if (this.f13917e.f13906c != null) {
                this.f13917e.f13906c.startFadeAnim();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.r0.x2.f.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13918e;

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
            this.f13918e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13918e.f13909f == null || this.f13918e.f13909f.a == null) {
                return;
            }
            if (this.f13918e.n != null) {
                this.f13918e.n.a(this.f13918e.f13909f.a);
            }
            if (this.f13918e.f13909f.a != null && this.f13918e.f13909f.a.o1() != null && this.f13918e.f13909f.a.o1().isLegalYYLiveData()) {
                AlaInfoData o1 = this.f13918e.f13909f.a.o1();
                TbPageContext tbPageContext = this.f13918e.a;
                YyExtData yyExtData = o1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + o1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f13918e;
            bVar.l(bVar.a, this.f13918e.f13909f.a);
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(d2 d2Var);

        void b(d2 d2Var);
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C0844b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.r0.a0.f.b.b.c cVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f13909f) == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f13907d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f13908e = new c.a.r0.x2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.a.getPageActivity());
        this.f13907d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f13907d.setOnErrorListener(this.q);
        this.f13907d.setOnSurfaceDestroyedListener(this.p);
        this.f13907d.setVolume(0.0f, 0.0f);
        this.f13907d.setStageType(null);
        this.f13908e.l(this.f13907d);
        this.f13908e.k(new d(this));
        if (this.f13907d.getParent() == null) {
            this.f13905b.addView(this.f13907d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f13909f.a.o1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13905b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        this.f13905b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f13911h = l.k(this.a.getPageActivity());
        int i2 = l.i(this.a.getPageActivity());
        this.f13912i = i2;
        int i3 = this.f13911h;
        this.f13913j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.f13914k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f13906c = (AlaSquareLiveVideoMask) this.f13905b.findViewById(R.id.video_mask);
        this.f13905b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.o1() == null) {
            return;
        }
        c.a.r0.a0.f.b.b.c cVar = this.f13909f;
        if (cVar != null && cVar.a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f13909f.f13883b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f13909f.a.v1());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.m ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
        alaLiveInfoCoreData.userName = d2Var.o1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13911h = l.k(this.a.getPageActivity());
            int i2 = l.i(this.a.getPageActivity());
            this.f13912i = i2;
            int i3 = this.f13911h;
            this.f13913j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.f13914k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f13909f != null) {
                TbCyberVideoView tbCyberVideoView = this.f13907d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f13909f.a.o1().screen_direction);
                u(this.f13909f.a.o1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(c.a.r0.a0.f.b.b.c cVar) {
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        c.a.r0.a0.f.b.b.c cVar2 = this.f13909f;
        if (cVar2 == null || ((d2Var2 = cVar2.a) != null && !d2Var2.v1().equals(cVar.a.v1()))) {
            t(cVar.a.o1().screen_direction);
        }
        this.f13909f = cVar;
        this.f13910g = cVar.a.o1().screen_direction;
        this.f13906c.setData(this.f13909f.a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f13906c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f13907d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f13906c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.x2.f fVar = this.f13908e;
            if (fVar != null) {
                fVar.l(null);
                this.f13908e.n();
                this.f13908e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f13907d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f13907d.clearCallbackAndRemoveFromWindow();
                if (this.f13907d.getMediaProgressObserver() != null) {
                    this.f13907d.getMediaProgressObserver().l(null);
                    this.f13907d.getMediaProgressObserver().n();
                }
                this.f13907d = null;
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            s(true);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                q();
            }
            TbCyberVideoView tbCyberVideoView = this.f13907d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f13906c.stopFadeAnim();
            this.f13906c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f13905b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13905b.getLayoutParams();
                        layoutParams.width = this.f13911h;
                        layoutParams.height = this.f13914k;
                        this.f13905b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f13905b.setLayoutParams(new FrameLayout.LayoutParams(this.f13911h, this.f13914k));
                    return;
                } else if (this.f13905b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f13905b.getLayoutParams();
                    int i3 = this.f13911h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f13905b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f13905b;
                    int i4 = this.f13911h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f13910g = 2;
            if (this.m) {
                if (this.f13905b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f13905b.getLayoutParams();
                    layoutParams3.width = this.f13911h;
                    layoutParams3.height = this.f13913j;
                    this.f13905b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f13905b.setLayoutParams(new AbsListView.LayoutParams(this.f13911h, this.f13913j));
            } else if (this.f13905b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f13905b.getLayoutParams();
                layoutParams4.width = this.f13911h;
                layoutParams4.height = this.f13913j;
                this.f13905b.setLayoutParams(layoutParams4);
            } else {
                this.f13905b.setLayoutParams(new AbsListView.LayoutParams(this.f13911h, this.f13913j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f13907d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13907d.getLayoutParams();
                layoutParams.width = this.f13911h;
                layoutParams.height = this.f13912i;
                layoutParams.topMargin = -this.o;
                this.f13907d.setLayoutParams(layoutParams);
                return;
            }
            this.f13907d.setLayoutParams(new FrameLayout.LayoutParams(this.f13911h, this.f13912i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f13907d.getLayoutParams();
            layoutParams2.width = this.f13911h;
            layoutParams2.height = this.f13913j;
            this.f13907d.setLayoutParams(layoutParams2);
        } else {
            this.f13907d.setLayoutParams(new FrameLayout.LayoutParams(this.f13911h, this.f13913j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f13910g != 1 || (tbCyberVideoView = this.f13907d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f13911h;
        float f5 = i4 * f2;
        int i5 = this.f13912i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f13907d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13907d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f13907d.setLayoutParams(layoutParams);
            return;
        }
        this.f13907d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        c.a.r0.a0.f.b.b.c cVar;
        d2 d2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f13909f) == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f13907d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f13907d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f13907d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        p pVar = new p();
        pVar.a = "9";
        pVar.f25427d = String.valueOf(this.f13909f.a.U());
        pVar.f25426c = this.f13909f.a.v1();
        this.f13907d.setVideoStatData(pVar);
        TbCyberVideoView tbCyberVideoView3 = this.f13907d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f13909f.a.o1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f13907d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        c.a.r0.x2.f fVar = this.f13908e;
        if (fVar != null) {
            fVar.m();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = z;
        this.f13906c.setFromSpecialForum(z);
    }
}
