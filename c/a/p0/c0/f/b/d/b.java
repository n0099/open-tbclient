package c.a.p0.c0.f.b.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.c3.g;
import c.a.p0.c3.h;
import c.a.p0.c3.u;
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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f12902b;

    /* renamed from: c  reason: collision with root package name */
    public AlaSquareLiveVideoMask f12903c;

    /* renamed from: d  reason: collision with root package name */
    public TbVideoViewContainer f12904d;

    /* renamed from: e  reason: collision with root package name */
    public g f12905e;

    /* renamed from: f  reason: collision with root package name */
    public h f12906f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.c0.f.b.b.c f12907g;

    /* renamed from: h  reason: collision with root package name */
    public int f12908h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public e o;
    public int p;
    public TbVideoViewContainer.a q;
    public c.a.p0.c3.w.a r;
    public View.OnClickListener s;

    /* loaded from: classes2.dex */
    public class a implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
            }
        }
    }

    /* renamed from: c.a.p0.c0.f.b.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0972b implements c.a.p0.c3.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0972b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.c3.w.a
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.p0.c3.w.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
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
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.s(false);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a.f12905e == null) {
                return;
            }
            this.a.f12905e.setLooping(false);
            this.a.f12905e.setVolume(0.0f, 0.0f);
            if (this.a.f12907g != null && this.a.f12907g.a != null) {
                if (this.a.n) {
                    if (this.a.o != null) {
                        this.a.o.b(this.a.f12907g.a);
                    }
                } else {
                    StatisticItem statisticItem = new StatisticItem("c12646");
                    if (this.a.f12907g.f12887b != 0) {
                        if (this.a.f12907g.f12887b == 1) {
                            statisticItem.param("obj_type", 2);
                        }
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    statisticItem.param("tid", this.a.f12907g.a.getTid());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (this.a.f12905e.getPlayerWidth() != 0) {
                b bVar = this.a;
                bVar.v(bVar.f12905e.getPlayerHeight(), this.a.f12905e.getPlayerWidth());
            }
            if (this.a.f12903c != null) {
                this.a.f12903c.d();
            }
        }

        @Override // c.a.p0.c3.w.a
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

        @Override // c.a.p0.c3.w.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStatistic(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, uVar) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.c3.h.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f12907g == null || this.a.f12907g.a == null) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.a(this.a.f12907g.a);
            }
            if (this.a.f12907g.a != null && this.a.f12907g.a.getThreadAlaInfo() != null && this.a.f12907g.a.getThreadAlaInfo().isLegalYYLiveData()) {
                AlaInfoData threadAlaInfo = this.a.f12907g.a.getThreadAlaInfo();
                TbPageContext tbPageContext = this.a.a;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + threadAlaInfo.roomId, YYLiveUtil.SOURCE_BAIDU_LIVE_TOP_PLAY);
                return;
            }
            b bVar = this.a;
            bVar.l(bVar.a, this.a.f12907g.a);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(ThreadData threadData);

        void b(ThreadData threadData);
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.m = "";
        this.n = false;
        this.q = new a(this);
        this.r = new C0972b(this);
        this.s = new d(this);
        this.a = tbPageContext;
        k();
    }

    public final void i() {
        c.a.p0.c0.f.b.b.c cVar;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f12907g) == null || (threadData = cVar.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.f12904d;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getParent() != null) {
            q();
        }
        this.f12906f = new h();
        TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(this.a.getPageActivity());
        this.f12904d = tbVideoViewContainer2;
        g control = tbVideoViewContainer2.getControl();
        this.f12905e = control;
        control.setOperableVideoContainer(this.r);
        this.f12905e.setOnSurfaceDestroyedListener(this.q);
        this.f12905e.setVolume(0.0f, 0.0f);
        this.f12905e.setStageType(null);
        this.f12906f.l(this.f12905e);
        this.f12906f.k(new c(this));
        if (this.f12904d.getParent() == null) {
            this.f12902b.addView(this.f12904d, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        u(this.f12907g.a.getThreadAlaInfo().screen_direction);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12902b : (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        this.f12902b = (FrameLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0603, (ViewGroup) null);
        this.i = n.k(this.a.getPageActivity());
        int i = n.i(this.a.getPageActivity());
        this.j = i;
        int i2 = this.i;
        this.k = (int) ((i2 / 16.0d) * 9.0d);
        int i3 = (int) ((i2 / 4.0d) * 3.0d);
        this.l = i3;
        this.p = (int) ((i / 3.0d) - (i3 / 2.0d));
        this.f12903c = (AlaSquareLiveVideoMask) this.f12902b.findViewById(R.id.obfuscated_res_0x7f092343);
        this.f12902b.setOnClickListener(this.s);
        o();
    }

    public final void l(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, threadData) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        c.a.p0.c0.f.b.b.c cVar = this.f12907g;
        if (cVar != null && cVar.a != null && !this.n) {
            StatisticItem statisticItem = new StatisticItem("c12645");
            int i = this.f12907g.f12887b;
            if (i == 0) {
                statisticItem.param("obj_type", 1);
            } else if (i == 1) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("tid", this.f12907g.a.getTid());
            TiebaStatic.log(statisticItem);
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        String str2 = this.n ? AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_TAB_TOP_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD;
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        alaLiveInfoCoreData.userName = threadData.getThreadAlaInfo().user_info.user_name;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str2, str, z, "")));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = n.k(this.a.getPageActivity());
            int i = n.i(this.a.getPageActivity());
            this.j = i;
            int i2 = this.i;
            this.k = (int) ((i2 / 16.0d) * 9.0d);
            int i3 = (int) ((i2 / 4.0d) * 3.0d);
            this.l = i3;
            this.p = (int) ((i / 3.0d) - (i3 / 2.0d));
            if (this.f12907g != null) {
                g gVar = this.f12905e;
                boolean isPlaying = gVar == null ? false : gVar.isPlaying();
                t(this.f12907g.a.getThreadAlaInfo().screen_direction);
                u(this.f12907g.a.getThreadAlaInfo().screen_direction);
                r();
                if (isPlaying) {
                    x(this.m);
                }
            }
        }
    }

    public void n(c.a.p0.c0.f.b.b.c cVar) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (threadData = cVar.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        c.a.p0.c0.f.b.b.c cVar2 = this.f12907g;
        if (cVar2 == null || ((threadData2 = cVar2.a) != null && !threadData2.getTid().equals(cVar.a.getTid()))) {
            t(cVar.a.getThreadAlaInfo().screen_direction);
        }
        this.f12907g = cVar;
        this.f12908h = cVar.a.getThreadAlaInfo().screen_direction;
        this.f12903c.setData(this.f12907g.a);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f12903c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.b();
            }
            SkinManager.setBackgroundColor(this.f12904d, R.color.black_alpha100);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q();
            AlaSquareLiveVideoMask alaSquareLiveVideoMask = this.f12903c;
            if (alaSquareLiveVideoMask != null) {
                alaSquareLiveVideoMask.c();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h hVar = this.f12906f;
            if (hVar != null) {
                hVar.l(null);
                this.f12906f.n();
                this.f12906f = null;
            }
            g gVar = this.f12905e;
            if (gVar != null) {
                gVar.stopPlayback();
                this.f12904d.a();
                if (this.f12905e.getMediaProgressObserver() != null) {
                    this.f12905e.getMediaProgressObserver().l(null);
                    this.f12905e.getMediaProgressObserver().n();
                }
                this.f12905e = null;
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
            g gVar = this.f12905e;
            if (gVar != null) {
                gVar.stopPlayback();
            }
            this.f12903c.f();
            this.f12903c.e();
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 1) {
                if (this.n) {
                    if (this.f12902b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12902b.getLayoutParams();
                        layoutParams.width = this.i;
                        layoutParams.height = this.l;
                        this.f12902b.setLayoutParams(layoutParams);
                        return;
                    }
                    this.f12902b.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.l));
                    return;
                } else if (this.f12902b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.f12902b.getLayoutParams();
                    int i2 = this.i;
                    layoutParams2.width = i2;
                    layoutParams2.height = i2;
                    this.f12902b.setLayoutParams(layoutParams2);
                    return;
                } else {
                    FrameLayout frameLayout = this.f12902b;
                    int i3 = this.i;
                    frameLayout.setLayoutParams(new AbsListView.LayoutParams(i3, i3));
                    return;
                }
            }
            this.f12908h = 2;
            if (this.n) {
                if (this.f12902b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f12902b.getLayoutParams();
                    layoutParams3.width = this.i;
                    layoutParams3.height = this.k;
                    this.f12902b.setLayoutParams(layoutParams3);
                    return;
                }
                this.f12902b.setLayoutParams(new AbsListView.LayoutParams(this.i, this.k));
            } else if (this.f12902b.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.f12902b.getLayoutParams();
                layoutParams4.width = this.i;
                layoutParams4.height = this.k;
                this.f12902b.setLayoutParams(layoutParams4);
            } else {
                this.f12902b.setLayoutParams(new AbsListView.LayoutParams(this.i, this.k));
            }
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || this.f12905e == null) {
            return;
        }
        if (i == 1) {
            if (this.f12904d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12904d.getLayoutParams();
                layoutParams.width = this.i;
                layoutParams.height = this.j;
                layoutParams.topMargin = -this.p;
                this.f12904d.setLayoutParams(layoutParams);
                return;
            }
            this.f12904d.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.j));
        } else if (this.f12904d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f12904d.getLayoutParams();
            layoutParams2.width = this.i;
            layoutParams2.height = this.k;
            this.f12904d.setLayoutParams(layoutParams2);
        } else {
            this.f12904d.setLayoutParams(new FrameLayout.LayoutParams(this.i, this.k));
        }
    }

    public final void v(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) || this.f12908h != 1 || this.f12905e == null || this.f12904d.getParent() == null) {
            return;
        }
        float f2 = i;
        float f3 = i2;
        float f4 = f2 / f3;
        int i3 = this.i;
        float f5 = i3 * f2;
        int i4 = this.j;
        float f6 = f5 / i4;
        if (f6 < f3) {
            i3 = (int) (i4 / f4);
        } else if (f6 > f3) {
            i4 = (int) (i3 * f4);
        }
        if (this.f12904d.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12904d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            this.f12904d.setLayoutParams(layoutParams);
            return;
        }
        this.f12904d.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
    }

    public void w(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void x(String str) {
        c.a.p0.c0.f.b.b.c cVar;
        ThreadData threadData;
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str) || (cVar = this.f12907g) == null || (threadData = cVar.a) == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (!str.equals(this.m) || ((gVar = this.f12905e) != null && !gVar.isPlaying())) {
            this.m = str;
            r();
        }
        if (this.f12905e == null) {
            i();
        }
        g gVar2 = this.f12905e;
        if (gVar2 == null || gVar2.isPlaying()) {
            return;
        }
        u uVar = new u();
        uVar.a = "9";
        uVar.f13505d = String.valueOf(this.f12907g.a.getFid());
        uVar.f13504c = this.f12907g.a.getTid();
        this.f12905e.setVideoStatData(uVar);
        g gVar3 = this.f12905e;
        if (gVar3 != null) {
            gVar3.setVideoPath(this.f12907g.a.getThreadAlaInfo().hls_url);
        }
        g gVar4 = this.f12905e;
        if (gVar4 != null) {
            gVar4.start();
        }
        h hVar = this.f12906f;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = z;
        this.f12903c.setFromSpecialForum(z);
    }
}
