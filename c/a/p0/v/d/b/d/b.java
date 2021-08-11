package c.a.p0.v.d.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import c.a.p0.o2.f;
import c.a.p0.o2.o;
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
    public TbPageContext<?> f24707a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f24708b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f24709c;

    /* renamed from: d  reason: collision with root package name */
    public TbCyberVideoView f24710d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.o2.f f24711e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.v.d.b.b.c f24712f;

    /* renamed from: g  reason: collision with root package name */
    public int f24713g;

    /* renamed from: h  reason: collision with root package name */
    public int f24714h;

    /* renamed from: i  reason: collision with root package name */
    public int f24715i;

    /* renamed from: j  reason: collision with root package name */
    public int f24716j;
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
        public final /* synthetic */ b f24717e;

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
            this.f24717e = bVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24717e.r();
            }
        }
    }

    /* renamed from: c.a.p0.v.d.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1157b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24718e;

        public C1157b(b bVar) {
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
            this.f24718e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f24718e.s(false);
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
        public final /* synthetic */ b f24719e;

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
            this.f24719e = bVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24719e.f24710d == null) {
                return;
            }
            this.f24719e.f24710d.setLooping(false);
            this.f24719e.f24710d.setVolume(0.0f, 0.0f);
            if (this.f24719e.f24712f != null && this.f24719e.f24712f.f24682a != null) {
                if (this.f24719e.m) {
                    if (this.f24719e.n != null) {
                        this.f24719e.n.b(this.f24719e.f24712f.f24682a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f24719e.f24712f.f24683b != 0) {
                        if (this.f24719e.f24712f.f24683b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f24719e.f24712f.f24682a.q1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f24719e.f24710d.getCyberPlayer() != null) {
                b bVar = this.f24719e;
                bVar.v(bVar.f24710d.getCyberPlayer().getVideoHeight(), this.f24719e.f24710d.getCyberPlayer().getVideoWidth());
            }
            if (this.f24719e.f24709c != null) {
                this.f24719e.f24709c.startFadeAnim();
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

        @Override // c.a.p0.o2.f.d
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
        public final /* synthetic */ b f24720e;

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
            this.f24720e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24720e.f24712f == null || this.f24720e.f24712f.f24682a == null) {
                return;
            }
            if (this.f24720e.n != null) {
                this.f24720e.n.a(this.f24720e.f24712f.f24682a);
            }
            if (this.f24720e.f24712f.f24682a != null && this.f24720e.f24712f.f24682a.j1() != null && this.f24720e.f24712f.f24682a.j1().isLegalYYLiveData()) {
                AlaInfoData j1 = this.f24720e.f24712f.f24682a.j1();
                TbPageContext tbPageContext = this.f24720e.f24707a;
                YyExtData yyExtData = j1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + j1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f24720e;
            bVar.l(bVar.f24707a, this.f24720e.f24712f.f24682a);
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
        this.f24707a = null;
        this.l = "";
        this.m = false;
        this.p = new a(this);
        this.q = new C1157b(this);
        this.r = new c(this);
        this.s = new e(this);
        this.f24707a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.p0.v.d.b.b.c cVar;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f24712f) == null || (c2Var = cVar.f24682a) == null || c2Var.j1() == null) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f24710d;
        if (tbCyberVideoView != null && tbCyberVideoView.getParent() != null) {
            q();
        }
        this.f24711e = new c.a.p0.o2.f();
        TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(this.f24707a.getPageActivity());
        this.f24710d = tbCyberVideoView2;
        tbCyberVideoView2.setOnPreparedListener(this.r);
        this.f24710d.setOnErrorListener(this.q);
        this.f24710d.setOnSurfaceDestroyedListener(this.p);
        this.f24710d.setVolume(0.0f, 0.0f);
        this.f24710d.setStageType(null);
        this.f24711e.l(this.f24710d);
        this.f24711e.k(new d(this));
        if (this.f24710d.getParent() == null) {
            this.f24708b.addView(this.f24710d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f24712f.f24682a.j1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24708b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.f24707a) == null) {
            return;
        }
        this.f24708b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f24714h = l.k(this.f24707a.getPageActivity());
        int i2 = l.i(this.f24707a.getPageActivity());
        this.f24715i = i2;
        int i3 = this.f24714h;
        this.f24716j = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.k = i4;
        this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f24709c = (AlaSquareLiveVideoMask) this.f24708b.findViewById(R.id.video_mask);
        this.f24708b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, c2 c2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, c2Var) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        c.a.p0.v.d.b.b.c cVar = this.f24712f;
        if (cVar != null && cVar.f24682a != null && !this.m) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f24712f.f24683b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f24712f.f24682a.q1());
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
            this.f24714h = l.k(this.f24707a.getPageActivity());
            int i2 = l.i(this.f24707a.getPageActivity());
            this.f24715i = i2;
            int i3 = this.f24714h;
            this.f24716j = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.k = i4;
            this.o = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f24712f != null) {
                TbCyberVideoView tbCyberVideoView = this.f24710d;
                boolean isPlaying = tbCyberVideoView == null ? false : tbCyberVideoView.isPlaying();
                t(this.f24712f.f24682a.j1().screen_direction);
                u(this.f24712f.f24682a.j1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.l);
                }
            }
        }
    }

    public void n(c.a.p0.v.d.b.b.c cVar) {
        c2 c2Var;
        c2 c2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (c2Var = cVar.f24682a) == null || c2Var.j1() == null) {
            return;
        }
        c.a.p0.v.d.b.b.c cVar2 = this.f24712f;
        if (cVar2 == null || ((c2Var2 = cVar2.f24682a) != null && !c2Var2.q1().equals(cVar.f24682a.q1()))) {
            t(cVar.f24682a.j1().screen_direction);
        }
        this.f24712f = cVar;
        this.f24713g = cVar.f24682a.j1().screen_direction;
        this.f24709c.setData(this.f24712f.f24682a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f24709c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f24710d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f24709c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.o2.f fVar = this.f24711e;
            if (fVar != null) {
                fVar.l(null);
                this.f24711e.n();
                this.f24711e = null;
            }
            TbCyberVideoView tbCyberVideoView = this.f24710d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                this.f24710d.clearCallbackAndRemoveFromWindow();
                if (this.f24710d.getMediaProgressObserver() != null) {
                    this.f24710d.getMediaProgressObserver().l(null);
                    this.f24710d.getMediaProgressObserver().n();
                }
                this.f24710d = null;
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
            TbCyberVideoView tbCyberVideoView = this.f24710d;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.f24709c.stopFadeAnim();
            this.f24709c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.m) {
                    if (this.f24708b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24708b.getLayoutParams();
                        layoutParams.width = this.f24714h;
                        layoutParams.height = this.k;
                        this.f24708b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f24708b.setLayoutParams(new FrameLayout.LayoutParams(this.f24714h, this.k));
                    return;
                } else if (this.f24708b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f24708b.getLayoutParams();
                    int i3 = this.f24714h;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f24708b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f24708b;
                    int i4 = this.f24714h;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f24713g = 2;
            if (this.m) {
                if (this.f24708b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f24708b.getLayoutParams();
                    layoutParams3.width = this.f24714h;
                    layoutParams3.height = this.f24716j;
                    this.f24708b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f24708b.setLayoutParams(new AbsListView.LayoutParams(this.f24714h, this.f24716j));
            } else if (this.f24708b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f24708b.getLayoutParams();
                layoutParams4.width = this.f24714h;
                layoutParams4.height = this.f24716j;
                this.f24708b.setLayoutParams(layoutParams4);
            } else {
                this.f24708b.setLayoutParams(new AbsListView.LayoutParams(this.f24714h, this.f24716j));
            }
        }
    }

    public final void u(int i2) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (tbCyberVideoView = this.f24710d) == null) {
            return;
        }
        if (i2 == 1) {
            if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24710d.getLayoutParams();
                layoutParams.width = this.f24714h;
                layoutParams.height = this.f24715i;
                layoutParams.topMargin = -this.o;
                this.f24710d.setLayoutParams(layoutParams);
                return;
            }
            this.f24710d.setLayoutParams(new FrameLayout.LayoutParams(this.f24714h, this.f24715i));
        } else if (tbCyberVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f24710d.getLayoutParams();
            layoutParams2.width = this.f24714h;
            layoutParams2.height = this.f24716j;
            this.f24710d.setLayoutParams(layoutParams2);
        } else {
            this.f24710d.setLayoutParams(new FrameLayout.LayoutParams(this.f24714h, this.f24716j));
        }
    }

    public final void v(int i2, int i3) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f24713g != 1 || (tbCyberVideoView = this.f24710d) == null || tbCyberVideoView.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f24714h;
        float f5 = i4 * f2;
        int i5 = this.f24715i;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f24710d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24710d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f24710d.setLayoutParams(layoutParams);
            return;
        }
        this.f24710d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void x(String str) {
        c.a.p0.v.d.b.b.c cVar;
        c2 c2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f24712f) == null || (c2Var = cVar.f24682a) == null || c2Var.j1() == null) {
            return;
        }
        if (!str.equals(this.l) || ((tbCyberVideoView = this.f24710d) != null && !tbCyberVideoView.isPlaying())) {
            this.l = str;
            r();
        }
        if (this.f24710d == null) {
            i();
        }
        TbCyberVideoView tbCyberVideoView2 = this.f24710d;
        if (tbCyberVideoView2 == null || tbCyberVideoView2.isPlaying()) {
            return;
        }
        o oVar = new o();
        oVar.f22884a = "9";
        oVar.f22887d = String.valueOf(this.f24712f.f24682a.T());
        oVar.f22886c = this.f24712f.f24682a.q1();
        this.f24710d.setVideoStatData(oVar);
        TbCyberVideoView tbCyberVideoView3 = this.f24710d;
        if (tbCyberVideoView3 != null) {
            tbCyberVideoView3.setVideoPath(this.f24712f.f24682a.j1().hls_url);
        }
        TbCyberVideoView tbCyberVideoView4 = this.f24710d;
        if (tbCyberVideoView4 != null) {
            tbCyberVideoView4.start();
        }
        c.a.p0.o2.f fVar = this.f24711e;
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
        this.f24709c.setFromSpecialForum(z);
    }
}
