package b.a.r0.w.f.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.q.d2;
import b.a.r0.q2.f;
import b.a.r0.q2.p;
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

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f26080a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f26081b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f26082c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f26083d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.q2.f f26084e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.w.f.b.b.c f26085f;

    /* renamed from: g  reason: collision with root package name */
    public int f26086g;

    /* renamed from: h  reason: collision with root package name */
    public int f26087h;

    /* renamed from: i  reason: collision with root package name */
    public int f26088i;
    public int j;
    public int k;
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
        public final /* synthetic */ b f26089e;

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
            this.f26089e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26089e.r();
            }
        }
    }

    /* renamed from: b.a.r0.w.f.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1268b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26090e;

        public C1268b(b bVar) {
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
            this.f26090e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f26090e.s(false);
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
        public final /* synthetic */ b f26091e;

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
            this.f26091e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26091e.f26083d == null) {
                return;
            }
            this.f26091e.f26083d.setLooping(false);
            this.f26091e.f26083d.setVolume(0.0f, 0.0f);
            if (this.f26091e.f26085f != null && this.f26091e.f26085f.f26056a != null) {
                if (this.f26091e.m) {
                    if (this.f26091e.n != null) {
                        this.f26091e.n.b(this.f26091e.f26085f.f26056a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f26091e.f26085f.f26057b != 0) {
                        if (this.f26091e.f26085f.f26057b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f26091e.f26085f.f26056a.t1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f26091e.f26083d.getCyberPlayer() != null) {
                b bVar = this.f26091e;
                bVar.v(bVar.f26083d.getCyberPlayer().getVideoHeight(), this.f26091e.f26083d.getCyberPlayer().getVideoWidth());
            }
            if (this.f26091e.f26082c != null) {
                this.f26091e.f26082c.startFadeAnim();
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

        @Override // b.a.r0.q2.f.d
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
        public final /* synthetic */ b f26092e;

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
            this.f26092e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26092e.f26085f == null || this.f26092e.f26085f.f26056a == null) {
                return;
            }
            if (this.f26092e.n != null) {
                this.f26092e.n.a(this.f26092e.f26085f.f26056a);
            }
            if (this.f26092e.f26085f.f26056a != null && this.f26092e.f26085f.f26056a.m1() != null && this.f26092e.f26085f.f26056a.m1().isLegalYYLiveData()) {
                AlaInfoData m1 = this.f26092e.f26085f.f26056a.m1();
                TbPageContext tbPageContext = this.f26092e.f26080a;
                YyExtData yyExtData = m1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + m1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f26092e;
            bVar.l(bVar.f26080a, this.f26092e.f26085f.f26056a);
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
        this.f26080a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1268b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f26080a = tbPageContext;
        k();
    }

    public final void i() {
        b.a.r0.w.f.b.b.c cVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f26085f) == null || (d2Var = cVar.f26056a) == null || d2Var.m1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f26083d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f26084e = new b.a.r0.q2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f26080a.getPageActivity());
        this.f26083d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f26083d.setOnErrorListener(this.q);
        this.f26083d.setOnSurfaceDestroyedListener(this.p);
        this.f26083d.setVolume(0.0f, 0.0f);
        this.f26083d.setStageType(null);
        this.f26084e.l(this.f26083d);
        this.f26084e.k(new d(this));
        if (this.f26083d.getParent() == null) {
            this.f26081b.addView(this.f26083d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f26085f.f26056a.m1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26081b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f26080a) == null) {
            return;
        }
        this.f26081b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f26087h = l.k(this.f26080a.getPageActivity());
        int i2 = l.i(this.f26080a.getPageActivity());
        this.f26088i = i2;
        int i3 = this.f26087h;
        this.j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f26082c = (AlaSquareLiveVideoMask) this.f26081b.findViewById(R.id.video_mask);
        this.f26081b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.m1() == null) {
            return;
        }
        b.a.r0.w.f.b.b.c cVar = this.f26085f;
        if (cVar != null && cVar.f26056a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f26085f.f26057b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f26085f.f26056a.t1());
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
        alaLiveInfoCoreData.fillWithInfoData(d2Var.m1());
        alaLiveInfoCoreData.userName = d2Var.m1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26087h = l.k(this.f26080a.getPageActivity());
            int i2 = l.i(this.f26080a.getPageActivity());
            this.f26088i = i2;
            int i3 = this.f26087h;
            this.j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f26085f != null) {
                TbCyberVideoView tbCyberVideoView = this.f26083d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f26085f.f26056a.m1().screen_direction);
                u(this.f26085f.f26056a.m1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(b.a.r0.w.f.b.b.c cVar) {
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (d2Var = cVar.f26056a) == null || d2Var.m1() == null) {
            return;
        }
        b.a.r0.w.f.b.b.c cVar2 = this.f26085f;
        if (cVar2 == null || ((d2Var2 = cVar2.f26056a) != null && !d2Var2.t1().equals(cVar.f26056a.t1()))) {
            t(cVar.f26056a.m1().screen_direction);
        }
        this.f26085f = cVar;
        this.f26086g = cVar.f26056a.m1().screen_direction;
        this.f26082c.setData(this.f26085f.f26056a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f26082c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f26083d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f26082c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.r0.q2.f fVar = this.f26084e;
            if (fVar != null) {
                fVar.l(null);
                this.f26084e.n();
                this.f26084e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f26083d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f26083d.clearCallbackAndRemoveFromWindow();
                if (this.f26083d.getMediaProgressObserver() != null) {
                    this.f26083d.getMediaProgressObserver().l(null);
                    this.f26083d.getMediaProgressObserver().n();
                }
                this.f26083d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f26083d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f26082c.stopFadeAnim();
            this.f26082c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f26081b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26081b.getLayoutParams();
                        layoutParams.width = this.f26087h;
                        layoutParams.height = this.k;
                        this.f26081b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f26081b.setLayoutParams(new FrameLayout.LayoutParams(this.f26087h, this.k));
                    return;
                } else if (this.f26081b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f26081b.getLayoutParams();
                    int i3 = this.f26087h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f26081b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f26081b;
                    int i4 = this.f26087h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f26086g = 2;
            if (this.m) {
                if (this.f26081b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f26081b.getLayoutParams();
                    layoutParams3.width = this.f26087h;
                    layoutParams3.height = this.j;
                    this.f26081b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f26081b.setLayoutParams(new AbsListView.LayoutParams(this.f26087h, this.j));
            } else if (this.f26081b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f26081b.getLayoutParams();
                layoutParams4.width = this.f26087h;
                layoutParams4.height = this.j;
                this.f26081b.setLayoutParams(layoutParams4);
            } else {
                this.f26081b.setLayoutParams(new AbsListView.LayoutParams(this.f26087h, this.j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f26083d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26083d.getLayoutParams();
                layoutParams.width = this.f26087h;
                layoutParams.height = this.f26088i;
                layoutParams.topMargin = -this.o;
                this.f26083d.setLayoutParams(layoutParams);
                return;
            }
            this.f26083d.setLayoutParams(new FrameLayout.LayoutParams(this.f26087h, this.f26088i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f26083d.getLayoutParams();
            layoutParams2.width = this.f26087h;
            layoutParams2.height = this.j;
            this.f26083d.setLayoutParams(layoutParams2);
        } else {
            this.f26083d.setLayoutParams(new FrameLayout.LayoutParams(this.f26087h, this.j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f26086g != 1 || (tbCyberVideoView = this.f26083d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f26087h;
        float f5 = i4 * f2;
        int i5 = this.f26088i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f26083d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26083d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f26083d.setLayoutParams(layoutParams);
            return;
        }
        this.f26083d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        b.a.r0.w.f.b.b.c cVar;
        d2 d2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f26085f) == null || (d2Var = cVar.f26056a) == null || d2Var.m1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f26083d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f26083d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f26083d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        p pVar = new p();
        pVar.f24403a = "9";
        pVar.f24406d = String.valueOf(this.f26085f.f26056a.T());
        pVar.f24405c = this.f26085f.f26056a.t1();
        this.f26083d.setVideoStatData(pVar);
        TbCyberVideoView tbCyberVideoView3 = this.f26083d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f26085f.f26056a.m1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f26083d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        b.a.r0.q2.f fVar = this.f26084e;
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
        this.f26082c.setFromSpecialForum(z);
    }
}
