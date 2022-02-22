package c.a.u0.a0.f.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.r.e2;
import c.a.u0.b3.g;
import c.a.u0.b3.h;
import c.a.u0.b3.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.play.TbVideoViewContainer;
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
    public FrameLayout f14808b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f14809c;

    /* renamed from: d  reason: collision with root package name */
    public TbVideoViewContainer f14810d;

    /* renamed from: e  reason: collision with root package name */
    public g f14811e;

    /* renamed from: f  reason: collision with root package name */
    public h f14812f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.a0.f.b.b.c f14813g;

    /* renamed from: h  reason: collision with root package name */
    public int f14814h;

    /* renamed from: i  reason: collision with root package name */
    public int f14815i;

    /* renamed from: j  reason: collision with root package name */
    public int f14816j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public e o;
    public int p;
    public TbVideoViewContainer.a q;
    public c.a.u0.b3.v.a r;
    public View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14817e;

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
            this.f14817e = bVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14817e.r();
            }
        }
    }

    /* renamed from: c.a.u0.a0.f.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0938b implements c.a.u0.b3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14818e;

        public C0938b(b bVar) {
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
            this.f14818e = bVar;
        }

        @Override // c.a.u0.b3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.u0.b3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                this.f14818e.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f14818e.f14811e == null) {
                return;
            }
            this.f14818e.f14811e.setLooping(false);
            this.f14818e.f14811e.setVolume(0.0f, 0.0f);
            if (this.f14818e.f14813g != null && this.f14818e.f14813g.a != null) {
                if (this.f14818e.n) {
                    if (this.f14818e.o != null) {
                        this.f14818e.o.b(this.f14818e.f14813g.a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.f14818e.f14813g.f14787b != 0) {
                        if (this.f14818e.f14813g.f14787b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.f14818e.f14813g.a.w1());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.f14818e.f14811e.getPlayerWidth() != 0) {
                b bVar = this.f14818e;
                bVar.v(bVar.f14811e.getPlayerHeight(), this.f14818e.f14811e.getPlayerWidth());
            }
            if (this.f14818e.f14809c != null) {
                this.f14818e.f14809c.startFadeAnim();
            }
        }

        @Override // c.a.u0.b3.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.u0.b3.h.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14819e;

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
            this.f14819e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14819e.f14813g == null || this.f14819e.f14813g.a == null) {
                return;
            }
            if (this.f14819e.o != null) {
                this.f14819e.o.a(this.f14819e.f14813g.a);
            }
            if (this.f14819e.f14813g.a != null && this.f14819e.f14813g.a.p1() != null && this.f14819e.f14813g.a.p1().isLegalYYLiveData()) {
                AlaInfoData p1 = this.f14819e.f14813g.a.p1();
                TbPageContext tbPageContext = this.f14819e.a;
                YyExtData yyExtData = p1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + p1.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.f14819e;
            bVar.l(bVar.a, this.f14819e.f14813g.a);
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(e2 e2Var);

        void b(e2 e2Var);
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
        this.m = "";
        this.n = false;
        this.q = new a(this);
        this.r = new C0938b(this);
        this.s = new d(this);
        this.a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.u0.a0.f.b.b.c cVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f14813g) == null || (e2Var = cVar.a) == null || e2Var.p1() == null) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.f14810d;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getParent() != null) {
            q();
        }
        this.f14812f = new h();
        TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(this.a.getPageActivity());
        this.f14810d = tbVideoViewContainer2;
        g control = tbVideoViewContainer2.getControl();
        this.f14811e = control;
        control.setOperableVideoContainer(this.r);
        this.f14811e.setOnSurfaceDestroyedListener(this.q);
        this.f14811e.setVolume(0.0f, 0.0f);
        this.f14811e.setStageType(null);
        this.f14812f.l(this.f14811e);
        this.f14812f.k(new c(this));
        if (this.f14810d.getParent() == null) {
            this.f14808b.addView(this.f14810d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f14813g.a.p1().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14808b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        this.f14808b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
        this.f14815i = n.k(this.a.getPageActivity());
        int i2 = n.i(this.a.getPageActivity());
        this.f14816j = i2;
        int i3 = this.f14815i;
        this.k = (int) ((i3 / 16.0d) * 9.0d);
        int i4 = (int) ((i3 / 4.0d) * 3.0d);
        this.l = i4;
        this.p = (int) ((i2 / 3.0d) - (i4 / 2.0d));
        this.f14809c = (AlaSquareLiveVideoMask) this.f14808b.findViewById(R.id.video_mask);
        this.f14808b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, e2 e2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, e2Var) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        c.a.u0.a0.f.b.b.c cVar = this.f14813g;
        if (cVar != null && cVar.a != null && !this.n) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i2 = this.f14813g.f14787b;
            if (i2 == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f14813g.a.w1());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.n ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
        alaLiveInfoCoreData.userName = e2Var.p1().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14815i = n.k(this.a.getPageActivity());
            int i2 = n.i(this.a.getPageActivity());
            this.f14816j = i2;
            int i3 = this.f14815i;
            this.k = (int) ((i3 / 16.0d) * 9.0d);
            int i4 = (int) ((i3 / 4.0d) * 3.0d);
            this.l = i4;
            this.p = (int) ((i2 / 3.0d) - (i4 / 2.0d));
            if (this.f14813g != null) {
                g gVar = this.f14811e;
                boolean isPlaying = gVar == null ? false : gVar.isPlaying();
                t(this.f14813g.a.p1().screen_direction);
                u(this.f14813g.a.p1().screen_direction);
                r();
                if (isPlaying) {
                    x(this.m);
                }
            }
        }
    }

    public void n(c.a.u0.a0.f.b.b.c cVar) {
        e2 e2Var;
        e2 e2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (e2Var = cVar.a) == null || e2Var.p1() == null) {
            return;
        }
        c.a.u0.a0.f.b.b.c cVar2 = this.f14813g;
        if (cVar2 == null || ((e2Var2 = cVar2.a) != null && !e2Var2.w1().equals(cVar.a.w1()))) {
            t(cVar.a.p1().screen_direction);
        }
        this.f14813g = cVar;
        this.f14814h = cVar.a.p1().screen_direction;
        this.f14809c.setData(this.f14813g.a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f14809c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onChangeSkin();
            }
            SkinManager.setBackgroundColor(this.f14810d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f14809c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.onDestroy();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h hVar = this.f14812f;
            if (hVar != null) {
                hVar.l(null);
                this.f14812f.n();
                this.f14812f = null;
            }
            g gVar = this.f14811e;
            if (gVar != null) {
                gVar.stopPlayback();
                this.f14810d.clearCallbackAndRemoveFromWindow();
                if (this.f14811e.getMediaProgressObserver() != null) {
                    this.f14811e.getMediaProgressObserver().l(null);
                    this.f14811e.getMediaProgressObserver().n();
                }
                this.f14811e = null;
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
            g gVar = this.f14811e;
            if (gVar != null) {
                gVar.stopPlayback();
            }
            this.f14809c.stopFadeAnim();
            this.f14809c.startIconAnim();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 1) {
                if (this.n) {
                    if (this.f14808b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14808b.getLayoutParams();
                        layoutParams.width = this.f14815i;
                        layoutParams.height = this.l;
                        this.f14808b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f14808b.setLayoutParams(new FrameLayout.LayoutParams(this.f14815i, this.l));
                    return;
                } else if (this.f14808b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f14808b.getLayoutParams();
                    int i3 = this.f14815i;
                    layoutParams2.width = i3;
                    layoutParams2.height = i3;
                    this.f14808b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f14808b;
                    int i4 = this.f14815i;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i4, i4));
                    return;
                }
            }
            this.f14814h = 2;
            if (this.n) {
                if (this.f14808b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f14808b.getLayoutParams();
                    layoutParams3.width = this.f14815i;
                    layoutParams3.height = this.k;
                    this.f14808b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f14808b.setLayoutParams(new AbsListView.LayoutParams(this.f14815i, this.k));
            } else if (this.f14808b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f14808b.getLayoutParams();
                layoutParams4.width = this.f14815i;
                layoutParams4.height = this.k;
                this.f14808b.setLayoutParams(layoutParams4);
            } else {
                this.f14808b.setLayoutParams(new AbsListView.LayoutParams(this.f14815i, this.k));
            }
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.f14811e == null) {
            return;
        }
        if (i2 == 1) {
            if (this.f14810d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14810d.getLayoutParams();
                layoutParams.width = this.f14815i;
                layoutParams.height = this.f14816j;
                layoutParams.topMargin = -this.p;
                this.f14810d.setLayoutParams(layoutParams);
                return;
            }
            this.f14810d.setLayoutParams(new FrameLayout.LayoutParams(this.f14815i, this.f14816j));
        } else if (this.f14810d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f14810d.getLayoutParams();
            layoutParams2.width = this.f14815i;
            layoutParams2.height = this.k;
            this.f14810d.setLayoutParams(layoutParams2);
        } else {
            this.f14810d.setLayoutParams(new FrameLayout.LayoutParams(this.f14815i, this.k));
        }
    }

    public final void v(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || this.f14814h != 1 || this.f14811e == null || this.f14810d.getParent() == null) {
            return;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = f2 / f3;
        int i4 = this.f14815i;
        float f5 = i4 * f2;
        int i5 = this.f14816j;
        float f6 = f5 / i5;
        if (f6 < f3) {
            i4 = (int) (i5 / f4);
        } else if (f6 > f3) {
            i5 = (int) (i4 * f4);
        }
        if (this.f14810d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14810d.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f14810d.setLayoutParams(layoutParams);
            return;
        }
        this.f14810d.setLayoutParams(new FrameLayout.LayoutParams(i4, i5));
    }

    public void w(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void x(String str) {
        c.a.u0.a0.f.b.b.c cVar;
        e2 e2Var;
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f14813g) == null || (e2Var = cVar.a) == null || e2Var.p1() == null) {
            return;
        }
        if (!str.equals(this.m) || ((gVar = this.f14811e) != null && !gVar.isPlaying())) {
            this.m = str;
            r();
        }
        if (this.f14811e == null) {
            i();
        }
        g gVar2 = this.f14811e;
        if (gVar2 == null || gVar2.isPlaying()) {
            return;
        }
        t tVar = new t();
        tVar.a = "9";
        tVar.f15611d = String.valueOf(this.f14813g.a.U());
        tVar.f15610c = this.f14813g.a.w1();
        this.f14811e.setVideoStatData(tVar);
        g gVar3 = this.f14811e;
        if (gVar3 != null) {
            gVar3.setVideoPath(this.f14813g.a.p1().hls_url);
        }
        g gVar4 = this.f14811e;
        if (gVar4 != null) {
            gVar4.start();
        }
        h hVar = this.f14812f;
        if (hVar != null) {
            hVar.m();
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
        this.n = z;
        this.f14809c.setFromSpecialForum(z);
    }
}
