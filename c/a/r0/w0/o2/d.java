package c.a.r0.w0.o2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.t0;
import c.a.q0.s.s.a;
import c.a.r0.w0.g2.a.c;
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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class d implements c.a.r0.w0.n1.e.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f27386a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f27387b;

    /* renamed from: c  reason: collision with root package name */
    public l f27388c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.r3.d f27389d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.w0.g2.a.c f27390e;

    /* renamed from: f  reason: collision with root package name */
    public OvalActionButton f27391f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.c4.f f27392g;

    /* renamed from: h  reason: collision with root package name */
    public c.d f27393h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f27394i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.e.e.l.c<c.a.e.l.d.a> f27395j;

    /* loaded from: classes4.dex */
    public class a implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27396a;

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
            this.f27396a = dVar;
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.f27396a.B(1);
                } else if (z) {
                    this.f27396a.B(0);
                } else if (i2 != 502) {
                    this.f27396a.B(-1);
                } else {
                    this.f27396a.n();
                }
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // c.a.r0.w0.g2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27397e;

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
            this.f27397e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !DialogLoginHelper.checkUpIsLogin(new t0(this.f27397e.f27386a.getPageContext().getPageActivity(), "frs_fabu")) || !ViewHelper.checkUpIsLogin(this.f27397e.f27386a.getPageContext().getPageActivity()) || this.f27397e.f27389d.c() || this.f27397e.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.f27397e.f27388c != null) {
                this.f27397e.f27388c.i();
            }
            if (this.f27397e.f27386a.getTabController().H(502) == null || this.f27397e.f27386a.getTabController().z() == null) {
                this.f27397e.B(-1);
            } else {
                this.f27397e.f27390e.h(this.f27397e.f27386a.getForumId(), this.f27397e.f27386a.getTabController().z().f51640a);
            }
            this.f27397e.j();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27398a;

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
            this.f27398a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    this.f27398a.w();
                    return;
                }
                this.f27398a.f27391f.setImageDrawable(null);
                aVar.h(this.f27398a.f27391f);
            }
        }
    }

    /* renamed from: c.a.r0.w0.o2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1290d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1290d(d dVar) {
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f27399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f27400f;

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
            this.f27400f = dVar;
            this.f27399e = blockPopInfoData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f27400f.f27386a.getPageContext(), new String[]{this.f27399e.ahead_url});
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
        this.f27393h = new a(this);
        this.f27394i = new b(this);
        this.f27395j = new c(this);
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.f27386a = frsFragment;
        this.f27387b = noPressedRelativeLayout;
        this.f27389d = new c.a.r0.r3.d(frsFragment.getPageContext());
        c.a.r0.w0.g2.a.c cVar = new c.a.r0.w0.g2.a.c(frsFragment.getPageContext());
        this.f27390e = cVar;
        cVar.i(this.f27393h);
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f27391f == null) {
            return;
        }
        l();
        this.f27391f.setVisibility(z ? 0 : 8);
        if (!z || !TbadkCoreApplication.isLogin() || (frsViewData = this.f27386a.getFrsViewData()) == null || frsViewData.postTopic == null || frsViewData.getForum() == null || StringUtils.isNull(frsViewData.getForum().getId()) || StringUtils.isNull(frsViewData.postTopic.recom_title) || StringUtils.isNull(frsViewData.postTopic.recom_topic) || !c.a.r0.w0.o.a.d().c(frsViewData.getForum().getId(), frsViewData.postTopic.uniq_topicid.longValue())) {
            return;
        }
        z(this.f27391f, frsViewData);
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f27392g == null) {
                c.a.r0.c4.f fVar = new c.a.r0.c4.f(this.f27386a.getPageContext(), this.f27387b, "frs");
                this.f27392g = fVar;
                fVar.E("2");
                ItemInfo itemInfo = this.f27386a.getFrsViewData().itemInfo;
                this.f27392g.D((itemInfo == null || itemInfo.id.intValue() <= 0 || c.a.e.e.p.k.isEmpty(itemInfo.name)) ? false : true);
            }
            this.f27392g.G(m());
            if (this.f27386a.getFrsViewData().getAnti() != null) {
                this.f27392g.A(this.f27386a.getFrsViewData().getAnti().getCanGoods());
            }
            ForumWriteData forumWriteData = this.f27386a.getForumWriteData();
            forumWriteData.setDefaultZone(i2);
            this.f27392g.B(forumWriteData);
            this.f27392g.C(this.f27386a.getFrsViewData().itemInfo);
            this.f27392g.F(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            FrsFragment frsFragment = this.f27386a;
            if (frsFragment != null && frsFragment.getFrsViewData() != null) {
                this.f27392g.C(this.f27386a.getFrsViewData().itemInfo);
            }
            this.f27392g.I(false, null, this.f27391f);
            this.f27386a.getmRefreshIcon().setAlpha(0);
            FrsFragment frsFragment2 = this.f27386a;
            if (frsFragment2 == null || frsFragment2.getFrsViewData() == null || this.f27386a.getFrsViewData().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f27386a.getForumId()).param("fname", this.f27386a.getForumName()).param("obj_param1", this.f27386a.getFrsViewData().itemInfo.name));
        }
    }

    public void C() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ovalActionButton = this.f27391f) == null) {
            return;
        }
        ovalActionButton.performClick();
    }

    @Override // c.a.r0.w0.n1.e.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f27389d.c() || k()) ? false : true : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.f27386a;
            if (frsFragment != null) {
                c.a.q0.n0.c.b(frsFragment.getContext(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.f27386a;
            if (frsFragment == null || (frsViewData = frsFragment.getFrsViewData()) == null) {
                return false;
            }
            if (ViewHelper.checkUpIsLogin(this.f27386a.getPageContext().getPageActivity())) {
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
            FrsFragment frsFragment = this.f27386a;
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
            FrsFragment frsFragment = this.f27386a;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (frsFragment = this.f27386a) == null || frsFragment.getFrsViewData() == null || (forum = this.f27386a.getFrsViewData().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f27386a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.r0.c4.f fVar = this.f27392g;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.r0.c4.f fVar = this.f27392g;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.e.e.l.d.h().m(str, 10, this.f27395j, this.f27386a.getUniqueId());
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.r0.c4.f fVar = this.f27392g;
            if (fVar != null) {
                fVar.t();
            }
            l lVar = this.f27388c;
            if (lVar != null) {
                lVar.i();
            }
        }
    }

    public void s() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (lVar = this.f27388c) == null) {
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
        c.a.r0.c4.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (fVar = this.f27392g) == null) {
            return;
        }
        fVar.r(i2);
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.r0.c4.f fVar = this.f27392g;
            if (fVar == null || !fVar.l()) {
                return false;
            }
            this.f27392g.k(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f27391f.setImageResource(0);
        }
    }

    public void x(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        this.f27391f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.f27394i);
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
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.f27386a.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
            if (i2 == 1 || i2 == 2) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f27386a.getPageContext().getPageActivity());
                aVar.setMessage(StringHelper.getFixedText(string, 50, true));
                aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.f27386a.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new C1290d(this));
                if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                    aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
                }
                aVar.create(this.f27386a.getPageContext()).show();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void z(View view, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, view, frsViewData) == null) || this.f27386a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.f27388c == null) {
            this.f27388c = new l(this.f27386a.getActivity(), this);
        }
        this.f27388c.i();
        this.f27388c.j(view, frsViewData);
    }
}
