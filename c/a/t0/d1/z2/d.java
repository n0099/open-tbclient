package c.a.t0.d1.z2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.t0;
import c.a.s0.s.s.a;
import c.a.t0.d1.e1;
import c.a.t0.d1.i1;
import c.a.t0.d1.r2.a.c;
import c.a.t0.o4.p;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class d implements c.a.t0.d1.y1.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f17372b;

    /* renamed from: c  reason: collision with root package name */
    public l f17373c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.e4.d f17374d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.d1.r2.a.c f17375e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f17376f;

    /* renamed from: g  reason: collision with root package name */
    public p f17377g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f17378h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f17379i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.d.f.l.c<c.a.d.n.d.a> f17380j;

    /* loaded from: classes7.dex */
    public class a implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.a.B(1);
                } else if (z) {
                    this.a.B(0);
                } else if (i2 != 502) {
                    this.a.B(-1);
                } else {
                    this.a.n();
                }
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17381e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17381e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !DialogLoginHelper.checkUpIsLogin(new t0(this.f17381e.a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(this.f17381e.a.getPageContext().getPageActivity()) || this.f17381e.f17374d.c() || this.f17381e.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.f17381e.f17373c != null) {
                this.f17381e.f17373c.i();
            }
            if (this.f17381e.a.getTabController().I(502) == null || this.f17381e.a.getTabController().A() == null) {
                this.f17381e.B(-1);
            } else {
                this.f17381e.f17375e.h(this.f17381e.a.getForumId(), this.f17381e.a.getTabController().A().a);
            }
            this.f17381e.j();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.a.w();
                    return;
                }
                this.a.f17376f.setImageDrawable(null);
                aVar.h(this.a.f17376f);
            }
        }
    }

    /* renamed from: c.a.t0.d1.z2.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1063d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1063d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f17382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17383f;

        public e(d dVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17383f = dVar;
            this.f17382e = blockPopInfoData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f17383f.a.getPageContext(), new String[]{this.f17382e.ahead_url});
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17378h = new a(this);
        this.f17379i = new b(this);
        this.f17380j = new c(this);
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.a = frsFragment;
        this.f17372b = noPressedRelativeLayout;
        this.f17374d = new c.a.t0.e4.d(frsFragment.getPageContext());
        c.a.t0.d1.r2.a.c cVar = new c.a.t0.d1.r2.a.c(frsFragment.getPageContext());
        this.f17375e = cVar;
        cVar.i(this.f17378h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f17376f == null) {
            return;
        }
        l();
        this.f17376f.setVisibility(z ? 0 : 8);
        if (!z || !TbadkCoreApplication.isLogin() || (frsViewData = this.a.getFrsViewData()) == null || frsViewData.postTopic == null || frsViewData.getForum() == null || StringUtils.isNull(frsViewData.getForum().getId()) || StringUtils.isNull(frsViewData.postTopic.recom_title) || StringUtils.isNull(frsViewData.postTopic.recom_topic) || !c.a.t0.d1.o.a.d().c(frsViewData.getForum().getId(), frsViewData.postTopic.uniq_topicid.longValue())) {
            return;
        }
        z(this.f17376f, frsViewData);
    }

    public final void B(int i2) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f17377g == null) {
                FrsFragment frsFragment = this.a;
                p pVar = new p(this.a.getPageContext(), this.f17372b, "frs", (frsFragment == null || (frsViewData = frsFragment.getFrsViewData()) == null) ? null : frsViewData.getVoiceRoomConfig());
                this.f17377g = pVar;
                pVar.H("2");
                ItemInfo itemInfo = this.a.getFrsViewData().itemInfo;
                this.f17377g.G((itemInfo == null || itemInfo.id.intValue() <= 0 || c.a.d.f.p.m.isEmpty(itemInfo.name)) ? false : true);
            }
            this.f17377g.J(m());
            if (this.a.getFrsViewData().getAnti() != null) {
                this.f17377g.D(this.a.getFrsViewData().getAnti().getCanGoods());
            }
            ForumWriteData forumWriteData = this.a.getForumWriteData();
            forumWriteData.setDefaultZone(i2);
            this.f17377g.E(forumWriteData);
            this.f17377g.F(this.a.getFrsViewData().itemInfo);
            this.f17377g.I(i2 == 1 ? e1.btn_frs_professional_edit_n : 0);
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && frsFragment2.getFrsViewData() != null) {
                this.f17377g.F(this.a.getFrsViewData().itemInfo);
            }
            this.f17377g.L(false, null, this.f17376f);
            this.a.getmRefreshIcon().setAlpha(0);
            FrsFragment frsFragment3 = this.a;
            if (frsFragment3 == null || frsFragment3.getFrsViewData() == null || this.a.getFrsViewData().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.a.getForumId()).param("fname", this.a.getForumName()).param("obj_param1", this.a.getFrsViewData().itemInfo.name));
        }
    }

    public void C() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ovalActionButton = this.f17376f) == null) {
            return;
        }
        ovalActionButton.performClick();
    }

    @Override // c.a.t0.d1.y1.e.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f17374d.c() || k()) ? false : true : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                c.a.s0.p0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (frsViewData = frsFragment.getFrsViewData()) == null) {
                return false;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                AntiData anti = frsViewData.getAnti();
                return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && (frsViewData = frsFragment.getFrsViewData()) != null && (activityConfig = frsViewData.activityConfig) != null && activityConfig.type.intValue() == 2) {
                if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                    q(activityConfig.night_addthread_icon);
                    return true;
                } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                    q(activityConfig.addthread_icon);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String m() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsFragment frsFragment = this.a;
            return (frsFragment == null || (frsViewData = frsFragment.getFrsViewData()) == null || (activityConfig = frsViewData.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public final void n() {
        FrsFragment frsFragment;
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (frsFragment = this.a) == null || frsFragment.getFrsViewData() == null || (forum = this.a.getFrsViewData().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            p pVar = this.f17377g;
            if (pVar == null) {
                return false;
            }
            return pVar.n();
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            p pVar = this.f17377g;
            if (pVar == null) {
                return false;
            }
            return pVar.n();
        }
        return invokeV.booleanValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.d.f.l.d.h().m(str, 10, this.f17380j, this.a.getUniqueId());
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p pVar = this.f17377g;
            if (pVar != null) {
                pVar.v();
            }
            l lVar = this.f17373c;
            if (lVar != null) {
                lVar.i();
            }
        }
    }

    public void s() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (lVar = this.f17373c) == null) {
            return;
        }
        lVar.i();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void u(int i2) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (pVar = this.f17377g) == null) {
            return;
        }
        pVar.t(i2);
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            p pVar = this.f17377g;
            if (pVar == null || !pVar.n()) {
                return false;
            }
            this.f17377g.m(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f17376f.setImageResource(0);
        }
    }

    public void x(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        this.f17376f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.f17379i);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i2, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.a.getResources().getString(i1.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
            if (i2 == 1 || i2 == 2) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageContext().getPageActivity());
                aVar.setMessage(StringHelper.getFixedText(string, 50, true));
                aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.a.getResources().getString(i1.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1063d(this));
                if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                    aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
                }
                aVar.create(this.a.getPageContext()).show();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void z(View view, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, view, frsViewData) == null) || this.a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f17373c == null) {
            this.f17373c = new l(this.a.getActivity(), this);
        }
        this.f17373c.i();
        this.f17373c.j(view, frsViewData);
    }
}
