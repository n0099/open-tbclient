package c.a.s0.x2.i.d;

import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.j2;
import c.a.s0.y2.c;
import c.a.s0.y2.d;
import c.a.s0.y2.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.personPolymeric.tab.view.AlignTextView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public UserData B;
    public c.a.s0.x2.e.a C;
    public boolean D;
    public NoDataView E;
    public String F;
    public View.OnClickListener G;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f25803b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25804c;

    /* renamed from: d  reason: collision with root package name */
    public AlignTextView f25805d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25806e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25807f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25808g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25809h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f25810i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f25811j;

    /* renamed from: k  reason: collision with root package name */
    public AlignTextView f25812k;
    public AlignTextView l;
    public TextView m;
    public ImageView n;
    public RelativeLayout o;
    public RelativeLayout p;
    public TextView q;
    public ImageView r;
    public TextView s;
    public View t;
    public ImageView u;
    public TextView v;
    public RoundRelativeLayout w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25813e;

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
            this.f25813e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f25813e.m.getLayout()) == null) {
                return;
            }
            int lineCount = layout.getLineCount();
            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                this.f25813e.o.setOnClickListener(null);
                this.f25813e.n.setVisibility(8);
                return;
            }
            this.f25813e.o.setOnClickListener(this.f25813e.G);
            this.f25813e.n.setVisibility(0);
        }
    }

    /* renamed from: c.a.s0.x2.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1496b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25814e;

        public View$OnClickListenerC1496b(b bVar) {
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
            this.f25814e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f25814e.o || view == this.f25814e.n) {
                    if (this.f25814e.D) {
                        this.f25814e.q();
                    } else {
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f25814e.a.getPageActivity(), this.f25814e.B.getIntro());
                    }
                } else if (view == this.f25814e.q) {
                    this.f25814e.q();
                } else if (view == this.f25814e.r) {
                    this.f25814e.q();
                } else if (view == this.f25814e.w) {
                    if (StringUtils.isNull(this.f25814e.F)) {
                        BdToast.c(this.f25814e.a.getPageActivity(), this.f25814e.a.getPageActivity().getText(g.god_get_error)).q();
                    } else {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f25814e.a.getPageActivity());
                        hotUserRankActivityConfig.setCategory(this.f25814e.F);
                        hotUserRankActivityConfig.setIsGod(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    }
                    TiebaStatic.log(new StatisticItem("c13899").param("uid", this.f25814e.B.getUserId()));
                }
            }
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new View$OnClickListenerC1496b(this);
        this.a = tbPageContext;
        this.D = z;
        p();
    }

    public void m(c.a.s0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.C = aVar;
        this.B = aVar.j();
        this.f25803b.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f25803b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, -2);
        } else {
            layoutParams.width = -1;
        }
        this.f25803b.setLayoutParams(layoutParams);
        if (this.B.getAlaUserData() != null && this.B.getAlaUserData().ala_id > 0) {
            this.f25810i.setVisibility(0);
            this.f25809h.setVisibility(0);
            this.f25809h.setText(String.valueOf(this.B.getAlaUserData().ala_id));
        } else {
            this.f25810i.setVisibility(8);
            this.f25809h.setVisibility(8);
        }
        String tb_age = this.B.getTb_age();
        if (l.isEmpty(tb_age)) {
            tb_age = "0";
        }
        this.f25811j.setText(this.a.getResources().getString(g.person_forum_age_suffix, tb_age));
        j2 birthdayInfo = this.B.getBirthdayInfo();
        if (birthdayInfo != null && !l.isEmpty(birthdayInfo.f13378b)) {
            if (birthdayInfo.f13379c < 0) {
                birthdayInfo.f13379c = 0;
            }
            if (birthdayInfo.f13380d == 2) {
                this.f25806e.setVisibility(0);
                this.f25806e.setText(this.a.getResources().getString(g.person_information_header_age, Integer.valueOf(birthdayInfo.f13379c)));
            } else {
                this.f25806e.setVisibility(8);
            }
            this.f25804c.setVisibility(0);
            this.f25804c.setText(birthdayInfo.f13378b);
            this.f25807f.setVisibility(0);
        } else {
            this.f25807f.setVisibility(8);
            this.f25804c.setVisibility(8);
            this.f25806e.setVisibility(8);
        }
        if (this.D) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        String intro = this.B.getIntro();
        BaijiahaoInfo baijiahaoInfo = this.B.getBaijiahaoInfo();
        if (baijiahaoInfo != null && !l.isEmpty(baijiahaoInfo.auth_desc)) {
            if (!l.isEmpty(intro)) {
                SpannableString spannableString = new SpannableString(intro);
                spannableString.setSpan(new LeadingMarginSpan.Standard(this.f25811j.getLeft(), 0), 0, spannableString.length(), 18);
                this.m.setText(spannableString);
                e.a().post(new a(this));
                this.p.setVisibility(8);
                this.t.setVisibility(0);
            } else {
                this.o.setVisibility(8);
                if (this.D) {
                    this.p.setVisibility(0);
                    this.r.setVisibility(8);
                    this.t.setVisibility(8);
                } else {
                    this.p.setVisibility(8);
                    this.t.setVisibility(0);
                }
            }
        } else if (l.isEmpty(intro)) {
            this.o.setVisibility(8);
            if (this.D) {
                this.p.setVisibility(0);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
            } else {
                this.p.setVisibility(8);
                this.t.setVisibility(0);
            }
        } else {
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            this.t.setVisibility(0);
        }
        if (aVar.E != null) {
            this.w.setVisibility(0);
            String str = aVar.E.module_name;
            this.F = str;
            if (TextUtils.isEmpty(str)) {
                this.F = "";
            }
            this.x.setText(String.format(this.a.getString(g.god_entry_title), this.F));
            if (aVar.E.is_in_rank.booleanValue()) {
                Integer num = aVar.E.today_rank;
                if (num != null && num.intValue() > 0 && aVar.E.today_rank.intValue() <= 500) {
                    this.y.setText(String.format(this.a.getString(g.god_entry_rank), aVar.E.today_rank));
                } else {
                    this.y.setText(this.a.getString(g.god_entry_no_rank));
                }
            } else {
                this.y.setText(this.a.getString(g.god_entry_no_rank));
            }
            TiebaStatic.log(new StatisticItem("c13898").param("uid", this.B.getUserId()));
            return;
        }
        this.w.setVisibility(8);
    }

    public void n(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z2 && z) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25803b : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(c.a.s0.y2.e.person_information_header, (ViewGroup) null);
            this.f25803b = inflate;
            inflate.setVisibility(8);
            this.s = (TextView) this.f25803b.findViewById(d.person_information_title);
            this.f25804c = (TextView) this.f25803b.findViewById(d.person_information_constellation);
            AlignTextView alignTextView = (AlignTextView) this.f25803b.findViewById(d.person_information_constellation_label);
            this.f25805d = alignTextView;
            alignTextView.setTextColor(SkinManager.getColor(c.a.s0.y2.a.CAM_X0108));
            this.f25806e = (TextView) this.f25803b.findViewById(d.person_information_age);
            this.f25807f = (LinearLayout) this.f25803b.findViewById(d.person_information_constellation_layout);
            this.t = this.f25803b.findViewById(d.space_view);
            this.f25808g = (TextView) this.f25803b.findViewById(d.person_information_ala_id_label);
            this.f25809h = (TextView) this.f25803b.findViewById(d.person_information_ala_id);
            this.f25810i = (LinearLayout) this.f25803b.findViewById(d.person_information_ala_id_layout);
            AlignTextView alignTextView2 = (AlignTextView) this.f25803b.findViewById(d.person_information_forum_age_label);
            this.f25812k = alignTextView2;
            alignTextView2.setTextColor(SkinManager.getColor(c.a.s0.y2.a.CAM_X0108));
            this.f25811j = (TextView) this.f25803b.findViewById(d.person_information_forum_age);
            AlignTextView alignTextView3 = (AlignTextView) this.f25803b.findViewById(d.person_information_intro_label);
            this.l = alignTextView3;
            alignTextView3.setTextColor(SkinManager.getColor(c.a.s0.y2.a.CAM_X0108));
            this.m = (TextView) this.f25803b.findViewById(d.person_information_intro);
            ImageView imageView = (ImageView) this.f25803b.findViewById(d.person_information_more_icon);
            this.n = imageView;
            imageView.setOnClickListener(this.G);
            RelativeLayout relativeLayout = (RelativeLayout) this.f25803b.findViewById(d.person_information_intro_layout);
            this.o = relativeLayout;
            relativeLayout.setOnClickListener(this.G);
            this.p = (RelativeLayout) this.f25803b.findViewById(d.person_information_perfect);
            TextView textView = (TextView) this.f25803b.findViewById(d.person_information_perfect_btn);
            this.q = textView;
            textView.setOnClickListener(this.G);
            this.u = (ImageView) this.f25803b.findViewById(d.person_information_perfect_image);
            this.v = (TextView) this.f25803b.findViewById(d.person_information_perfect_tip);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f25803b.findViewById(d.god_container);
            this.w = roundRelativeLayout;
            roundRelativeLayout.setOnClickListener(this.G);
            this.A = (ImageView) this.f25803b.findViewById(d.god_arrow);
            this.z = (ImageView) this.f25803b.findViewById(d.god_icon);
            this.y = (TextView) this.f25803b.findViewById(d.god_rank);
            this.x = (TextView) this.f25803b.findViewById(d.god_title);
            ImageView imageView2 = (ImageView) this.f25803b.findViewById(d.person_information_edit_icon);
            this.r = imageView2;
            imageView2.setOnClickListener(this.G);
            int measureText = (int) this.f25808g.getPaint().measureText(this.a.getString(g.person_ala_id));
            ViewGroup.LayoutParams layoutParams = this.f25805d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measureText;
                this.f25805d.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.f25812k.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = measureText;
                this.f25812k.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.l.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = measureText;
                this.l.setLayoutParams(layoutParams3);
            }
            NoDataView a2 = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.y2.b.ds10)), NoDataViewFactory.e.d(null, this.a.getResources().getString(g.no_data_common_txt)), null);
            this.E = a2;
            View view = this.f25803b;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(a2);
            }
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.B;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.B.getUserName());
            personChangeData.setSex(this.B.getSex());
            personChangeData.setIntro(this.B.getIntro());
            personChangeData.setNameShow(this.B.getName_show());
            personChangeData.setMem(this.B.getIsMem());
            personChangeData.setForumAge(this.B.getTb_age());
            personChangeData.setCanModifyAvatar(this.B.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.B.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.B.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.B.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.C.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.B.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.B.getBirthdayInfo().f13379c);
                personChangeData.setBirthdayTime(this.B.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.B.getBirthdayInfo().f13380d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, c.icon_pure_personalba_edit24_svg, c.a.s0.y2.a.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, c.ic_icon_pure_common_arrow16_n_svg, c.a.s0.y2.a.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.s, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25805d, c.a.s0.y2.a.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f25804c, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25806e, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25808g, c.a.s0.y2.a.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f25809h, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f25812k, c.a.s0.y2.a.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.f25811j, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.l, c.a.s0.y2.a.CAM_X0108, 1, i2);
            SkinManager.setViewTextColor(this.m, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.v, c.a.s0.y2.a.CAM_X0105, 1, i2);
            SkinManager.setBackgroundColor(this.w, c.a.s0.y2.a.CAM_X0206);
            SkinManager.setViewTextColor(this.x, c.a.s0.y2.a.CAM_X0311);
            SkinManager.setViewTextColor(this.y, c.a.s0.y2.a.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, c.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, c.ic_icon_pure_common_arrow16_n_svg, c.a.s0.y2.a.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            NoDataView noDataView = this.E;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.a, i2);
            }
        }
    }
}
