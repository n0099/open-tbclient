package c.a.q0.v.d.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.q0.o2.f;
import c.a.q0.o2.o;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f25040a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f25041b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f25042c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f25043d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.o2.f f25044e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.v.d.b.b.c f25045f;

    /* renamed from: g  reason: collision with root package name */
    public int f25046g;

    /* renamed from: h  reason: collision with root package name */
    public int f25047h;

    /* renamed from: i  reason: collision with root package name */
    public int f25048i;

    /* renamed from: j  reason: collision with root package name */
    public int f25049j;
    public int k;
    public String l;
    public boolean m;
    public f n;
    public int o;
    public TbCyberVideoView.h p;
    public CyberPlayerManager.OnErrorListener q;
    public CyberPlayerManager.OnPreparedListener r;
    public View.OnClickListener s;

    /* loaded from: classes3.dex */
    public class a implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25050e;

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
            this.f25050e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25050e.r();
            }
        }
    }

    /* renamed from: c.a.q0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1168b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25051e;

        public C1168b(b bVar) {
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
            this.f25051e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f25051e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25052e;

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
            this.f25052e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25052e.f25043d == null) {
                return;
            }
            this.f25052e.f25043d.setLooping(false);
            this.f25052e.f25043d.setVolume(0.0f, 0.0f);
            if (this.f25052e.f25045f != null && this.f25052e.f25045f.f25015a != null) {
                if (this.f25052e.m) {
                    if (this.f25052e.n != null) {
                        this.f25052e.n.b(this.f25052e.f25045f.f25015a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f25052e.f25045f.f25016b != 0) {
                        if (this.f25052e.f25045f.f25016b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f25052e.f25045f.f25015a.q1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f25052e.f25043d.getCyberPlayer() != null) {
                b bVar = this.f25052e;
                bVar.v(bVar.f25043d.getCyberPlayer().getVideoHeight(), this.f25052e.f25043d.getCyberPlayer().getVideoWidth());
            }
            if (this.f25052e.f25042c != null) {
                this.f25052e.f25042c.startFadeAnim();
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // c.a.q0.o2.f.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25053e;

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
            this.f25053e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25053e.f25045f == null || this.f25053e.f25045f.f25015a == null) {
                return;
            }
            if (this.f25053e.n != null) {
                this.f25053e.n.a(this.f25053e.f25045f.f25015a);
            }
            if (this.f25053e.f25045f.f25015a != null && this.f25053e.f25045f.f25015a.j1() != null && this.f25053e.f25045f.f25015a.j1().isLegalYYLiveData()) {
                AlaInfoData j1 = this.f25053e.f25045f.f25015a.j1();
                TbPageContext tbPageContext = this.f25053e.f25040a;
                YyExtData yyExtData = j1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + j1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f25053e;
            bVar.l(bVar.f25040a, this.f25053e.f25045f.f25015a);
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(c2 c2Var);

        void b(c2 c2Var);
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
        this.f25040a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1168b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f25040a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.q0.v.d.b.b.c cVar;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f25045f) == null || (c2Var = cVar.f25015a) == null || c2Var.j1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f25043d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f25044e = new c.a.q0.o2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f25040a.getPageActivity());
        this.f25043d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f25043d.setOnErrorListener(this.q);
        this.f25043d.setOnSurfaceDestroyedListener(this.p);
        this.f25043d.setVolume(0.0f, 0.0f);
        this.f25043d.setStageType(null);
        this.f25044e.l(this.f25043d);
        this.f25044e.k(new d(this));
        if (this.f25043d.getParent() == null) {
            this.f25041b.addView(this.f25043d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f25045f.f25015a.j1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25041b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f25040a) == null) {
            return;
        }
        this.f25041b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f25047h = l.k(this.f25040a.getPageActivity());
        int i2 = l.i(this.f25040a.getPageActivity());
        this.f25048i = i2;
        int i3 = this.f25047h;
        this.f25049j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f25042c = (AlaSquareLiveVideoMask) this.f25041b.findViewById(R.id.video_mask);
        this.f25041b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, c2 c2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, c2Var) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        c.a.q0.v.d.b.b.c cVar = this.f25045f;
        if (cVar != null && cVar.f25015a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f25045f.f25016b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f25045f.f25015a.q1());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = c2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.m ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
        alaLiveInfoCoreData.userName = c2Var.j1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25047h = l.k(this.f25040a.getPageActivity());
            int i2 = l.i(this.f25040a.getPageActivity());
            this.f25048i = i2;
            int i3 = this.f25047h;
            this.f25049j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f25045f != null) {
                TbCyberVideoView tbCyberVideoView = this.f25043d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f25045f.f25015a.j1().screen_direction);
                u(this.f25045f.f25015a.j1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(c.a.q0.v.d.b.b.c cVar) {
        c2 c2Var;
        c2 c2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (c2Var = cVar.f25015a) == null || c2Var.j1() == null) {
            return;
        }
        c.a.q0.v.d.b.b.c cVar2 = this.f25045f;
        if (cVar2 == null || ((c2Var2 = cVar2.f25015a) != null && !c2Var2.q1().equals(cVar.f25015a.q1()))) {
            t(cVar.f25015a.j1().screen_direction);
        }
        this.f25045f = cVar;
        this.f25046g = cVar.f25015a.j1().screen_direction;
        this.f25042c.setData(this.f25045f.f25015a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f25042c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f25043d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f25042c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.o2.f fVar = this.f25044e;
            if (fVar != null) {
                fVar.l(null);
                this.f25044e.n();
                this.f25044e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f25043d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f25043d.clearCallbackAndRemoveFromWindow();
                if (this.f25043d.getMediaProgressObserver() != null) {
                    this.f25043d.getMediaProgressObserver().l(null);
                    this.f25043d.getMediaProgressObserver().n();
                }
                this.f25043d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f25043d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f25042c.stopFadeAnim();
            this.f25042c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f25041b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25041b.getLayoutParams();
                        layoutParams.width = this.f25047h;
                        layoutParams.height = this.k;
                        this.f25041b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f25041b.setLayoutParams(new FrameLayout.LayoutParams(this.f25047h, this.k));
                    return;
                } else if (this.f25041b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f25041b.getLayoutParams();
                    int i3 = this.f25047h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f25041b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f25041b;
                    int i4 = this.f25047h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f25046g = 2;
            if (this.m) {
                if (this.f25041b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f25041b.getLayoutParams();
                    layoutParams3.width = this.f25047h;
                    layoutParams3.height = this.f25049j;
                    this.f25041b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f25041b.setLayoutParams(new AbsListView.LayoutParams(this.f25047h, this.f25049j));
            } else if (this.f25041b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f25041b.getLayoutParams();
                layoutParams4.width = this.f25047h;
                layoutParams4.height = this.f25049j;
                this.f25041b.setLayoutParams(layoutParams4);
            } else {
                this.f25041b.setLayoutParams(new AbsListView.LayoutParams(this.f25047h, this.f25049j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f25043d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25043d.getLayoutParams();
                layoutParams.width = this.f25047h;
                layoutParams.height = this.f25048i;
                layoutParams.topMargin = -this.o;
                this.f25043d.setLayoutParams(layoutParams);
                return;
            }
            this.f25043d.setLayoutParams(new FrameLayout.LayoutParams(this.f25047h, this.f25048i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f25043d.getLayoutParams();
            layoutParams2.width = this.f25047h;
            layoutParams2.height = this.f25049j;
            this.f25043d.setLayoutParams(layoutParams2);
        } else {
            this.f25043d.setLayoutParams(new FrameLayout.LayoutParams(this.f25047h, this.f25049j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f25046g != 1 || (tbCyberVideoView = this.f25043d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f25047h;
        float f5 = i4 * f2;
        int i5 = this.f25048i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f25043d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25043d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f25043d.setLayoutParams(layoutParams);
            return;
        }
        this.f25043d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        c.a.q0.v.d.b.b.c cVar;
        c2 c2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f25045f) == null || (c2Var = cVar.f25015a) == null || c2Var.j1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f25043d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f25043d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f25043d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f23216a = "9";
        oVar.f23219d = String.valueOf(this.f25045f.f25015a.T());
        oVar.f23218c = this.f25045f.f25015a.q1();
        this.f25043d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f25043d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f25045f.f25015a.j1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f25043d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        c.a.q0.o2.f fVar = this.f25044e;
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
        this.f25042c.setFromSpecialForum(z);
    }
}
