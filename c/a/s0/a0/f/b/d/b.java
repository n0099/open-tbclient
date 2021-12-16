package c.a.s0.a0.f.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.s0.z2.f;
import c.a.s0.z2.p;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f14245b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f14246c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f14247d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.z2.f f14248e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.a0.f.b.b.c f14249f;

    /* renamed from: g  reason: collision with root package name */
    public int f14250g;

    /* renamed from: h  reason: collision with root package name */
    public int f14251h;

    /* renamed from: i  reason: collision with root package name */
    public int f14252i;

    /* renamed from: j  reason: collision with root package name */
    public int f14253j;

    /* renamed from: k  reason: collision with root package name */
    public int f14254k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.h p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14255e;

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
            this.f14255e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14255e.r();
            }
        }
    }

    /* renamed from: c.a.s0.a0.f.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0880b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14256e;

        public C0880b(b bVar) {
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
            this.f14256e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f14256e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14257e;

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
            this.f14257e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14257e.f14247d == null) {
                return;
            }
            this.f14257e.f14247d.setLooping(false);
            this.f14257e.f14247d.setVolume(0.0f, 0.0f);
            if (this.f14257e.f14249f != null && this.f14257e.f14249f.a != null) {
                if (this.f14257e.m) {
                    if (this.f14257e.n != null) {
                        this.f14257e.n.b(this.f14257e.f14249f.a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f14257e.f14249f.f14223b != 0) {
                        if (this.f14257e.f14249f.f14223b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f14257e.f14249f.a.v1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f14257e.f14247d.getCyberPlayer() != null) {
                b bVar = this.f14257e;
                bVar.v(bVar.f14247d.getCyberPlayer().getVideoHeight(), this.f14257e.f14247d.getCyberPlayer().getVideoWidth());
            }
            if (this.f14257e.f14246c != null) {
                this.f14257e.f14246c.startFadeAnim();
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.s0.z2.f.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14258e;

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
            this.f14258e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14258e.f14249f == null || this.f14258e.f14249f.a == null) {
                return;
            }
            if (this.f14258e.n != null) {
                this.f14258e.n.a(this.f14258e.f14249f.a);
            }
            if (this.f14258e.f14249f.a != null && this.f14258e.f14249f.a.o1() != null && this.f14258e.f14249f.a.o1().isLegalYYLiveData()) {
                AlaInfoData o1 = this.f14258e.f14249f.a.o1();
                TbPageContext tbPageContext = this.f14258e.a;
                YyExtData yyExtData = o1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + o1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f14258e;
            bVar.l(bVar.a, this.f14258e.f14249f.a);
        }
    }

    /* loaded from: classes6.dex */
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
        this.q = new C0880b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.s0.a0.f.b.b.c cVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f14249f) == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f14247d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f14248e = new c.a.s0.z2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.a.getPageActivity());
        this.f14247d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f14247d.setOnErrorListener(this.q);
        this.f14247d.setOnSurfaceDestroyedListener(this.p);
        this.f14247d.setVolume(0.0f, 0.0f);
        this.f14247d.setStageType(null);
        this.f14248e.l(this.f14247d);
        this.f14248e.k(new d(this));
        if (this.f14247d.getParent() == null) {
            this.f14245b.addView(this.f14247d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f14249f.a.o1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14245b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        this.f14245b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f14251h = m.k(this.a.getPageActivity());
        int i2 = m.i(this.a.getPageActivity());
        this.f14252i = i2;
        int i3 = this.f14251h;
        this.f14253j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.f14254k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f14246c = (AlaSquareLiveVideoMask) this.f14245b.findViewById(R.id.video_mask);
        this.f14245b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.o1() == null) {
            return;
        }
        c.a.s0.a0.f.b.b.c cVar = this.f14249f;
        if (cVar != null && cVar.a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f14249f.f14223b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f14249f.a.v1());
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
            this.f14251h = m.k(this.a.getPageActivity());
            int i2 = m.i(this.a.getPageActivity());
            this.f14252i = i2;
            int i3 = this.f14251h;
            this.f14253j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.f14254k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f14249f != null) {
                TbCyberVideoView tbCyberVideoView = this.f14247d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f14249f.a.o1().screen_direction);
                u(this.f14249f.a.o1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(c.a.s0.a0.f.b.b.c cVar) {
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        c.a.s0.a0.f.b.b.c cVar2 = this.f14249f;
        if (cVar2 == null || ((d2Var2 = cVar2.a) != null && !d2Var2.v1().equals(cVar.a.v1()))) {
            t(cVar.a.o1().screen_direction);
        }
        this.f14249f = cVar;
        this.f14250g = cVar.a.o1().screen_direction;
        this.f14246c.setData(this.f14249f.a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f14246c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f14247d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f14246c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.s0.z2.f fVar = this.f14248e;
            if (fVar != null) {
                fVar.l(null);
                this.f14248e.n();
                this.f14248e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f14247d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f14247d.clearCallbackAndRemoveFromWindow();
                if (this.f14247d.getMediaProgressObserver() != null) {
                    this.f14247d.getMediaProgressObserver().l(null);
                    this.f14247d.getMediaProgressObserver().n();
                }
                this.f14247d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f14247d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f14246c.stopFadeAnim();
            this.f14246c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f14245b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14245b.getLayoutParams();
                        layoutParams.width = this.f14251h;
                        layoutParams.height = this.f14254k;
                        this.f14245b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f14245b.setLayoutParams(new FrameLayout.LayoutParams(this.f14251h, this.f14254k));
                    return;
                } else if (this.f14245b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f14245b.getLayoutParams();
                    int i3 = this.f14251h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f14245b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f14245b;
                    int i4 = this.f14251h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f14250g = 2;
            if (this.m) {
                if (this.f14245b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f14245b.getLayoutParams();
                    layoutParams3.width = this.f14251h;
                    layoutParams3.height = this.f14253j;
                    this.f14245b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f14245b.setLayoutParams(new AbsListView.LayoutParams(this.f14251h, this.f14253j));
            } else if (this.f14245b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f14245b.getLayoutParams();
                layoutParams4.width = this.f14251h;
                layoutParams4.height = this.f14253j;
                this.f14245b.setLayoutParams(layoutParams4);
            } else {
                this.f14245b.setLayoutParams(new AbsListView.LayoutParams(this.f14251h, this.f14253j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f14247d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14247d.getLayoutParams();
                layoutParams.width = this.f14251h;
                layoutParams.height = this.f14252i;
                layoutParams.topMargin = -this.o;
                this.f14247d.setLayoutParams(layoutParams);
                return;
            }
            this.f14247d.setLayoutParams(new FrameLayout.LayoutParams(this.f14251h, this.f14252i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f14247d.getLayoutParams();
            layoutParams2.width = this.f14251h;
            layoutParams2.height = this.f14253j;
            this.f14247d.setLayoutParams(layoutParams2);
        } else {
            this.f14247d.setLayoutParams(new FrameLayout.LayoutParams(this.f14251h, this.f14253j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f14250g != 1 || (tbCyberVideoView = this.f14247d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f14251h;
        float f5 = i4 * f2;
        int i5 = this.f14252i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f14247d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14247d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f14247d.setLayoutParams(layoutParams);
            return;
        }
        this.f14247d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        c.a.s0.a0.f.b.b.c cVar;
        d2 d2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f14249f) == null || (d2Var = cVar.a) == null || d2Var.o1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f14247d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f14247d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f14247d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        p pVar = new p();
        pVar.a = "9";
        pVar.f26407d = String.valueOf(this.f14249f.a.U());
        pVar.f26406c = this.f14249f.a.v1();
        this.f14247d.setVideoStatData(pVar);
        TbCyberVideoView tbCyberVideoView3 = this.f14247d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f14249f.a.o1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f14247d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        c.a.s0.z2.f fVar = this.f14248e;
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
        this.f14246c.setFromSpecialForum(z);
    }
}
