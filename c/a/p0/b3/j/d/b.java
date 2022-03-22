package c.a.p0.b3.j.d;

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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.e2;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public UserData B;
    public c.a.p0.b3.e.a C;
    public boolean D;
    public NoDataView E;
    public String F;
    public View.OnClickListener G;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f12800b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12801c;

    /* renamed from: d  reason: collision with root package name */
    public AlignTextView f12802d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12803e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f12804f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12805g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12806h;
    public LinearLayout i;
    public TextView j;
    public AlignTextView k;
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.a.m.getLayout()) == null) {
                return;
            }
            int lineCount = layout.getLineCount();
            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                this.a.o.setOnClickListener(null);
                this.a.n.setVisibility(8);
                return;
            }
            this.a.o.setOnClickListener(this.a.G);
            this.a.n.setVisibility(0);
        }
    }

    /* renamed from: c.a.p0.b3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0964b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC0964b(b bVar) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.o || view == this.a.n) {
                    if (this.a.D) {
                        this.a.q();
                    } else {
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.a.a.getPageActivity(), this.a.B.getIntro());
                    }
                } else if (view == this.a.q) {
                    this.a.q();
                } else if (view == this.a.r) {
                    this.a.q();
                } else if (view == this.a.w) {
                    if (StringUtils.isNull(this.a.F)) {
                        BdToast.c(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(R.string.obfuscated_res_0x7f0f07b7)).q();
                    } else {
                        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.a.getPageActivity());
                        hotUserRankActivityConfig.setCategory(this.a.F);
                        hotUserRankActivityConfig.setIsGod(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    }
                    TiebaStatic.log(new StatisticItem("c13899").param("uid", this.a.B.getUserId()));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = new View$OnClickListenerC0964b(this);
        this.a = tbPageContext;
        this.D = z;
        p();
    }

    public void m(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.C = aVar;
        this.B = aVar.j();
        this.f12800b.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f12800b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, -2);
        } else {
            layoutParams.width = -1;
        }
        this.f12800b.setLayoutParams(layoutParams);
        if (this.B.getAlaUserData() != null && this.B.getAlaUserData().ala_id > 0) {
            this.i.setVisibility(0);
            this.f12806h.setVisibility(0);
            this.f12806h.setText(String.valueOf(this.B.getAlaUserData().ala_id));
        } else {
            this.i.setVisibility(8);
            this.f12806h.setVisibility(8);
        }
        String tb_age = this.B.getTb_age();
        if (m.isEmpty(tb_age)) {
            tb_age = "0";
        }
        this.j.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e05, tb_age));
        e2 birthdayInfo = this.B.getBirthdayInfo();
        if (birthdayInfo != null && !m.isEmpty(birthdayInfo.f10849b)) {
            if (birthdayInfo.f10850c < 0) {
                birthdayInfo.f10850c = 0;
            }
            if (birthdayInfo.f10851d == 2) {
                this.f12803e.setVisibility(0);
                this.f12803e.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e16, Integer.valueOf(birthdayInfo.f10850c)));
            } else {
                this.f12803e.setVisibility(8);
            }
            this.f12801c.setVisibility(0);
            this.f12801c.setText(birthdayInfo.f10849b);
            this.f12804f.setVisibility(0);
        } else {
            this.f12804f.setVisibility(8);
            this.f12801c.setVisibility(8);
            this.f12803e.setVisibility(8);
        }
        if (this.D) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        String intro = this.B.getIntro();
        BaijiahaoInfo baijiahaoInfo = this.B.getBaijiahaoInfo();
        if (baijiahaoInfo != null && !m.isEmpty(baijiahaoInfo.auth_desc)) {
            if (!m.isEmpty(intro)) {
                SpannableString spannableString = new SpannableString(intro);
                spannableString.setSpan(new LeadingMarginSpan.Standard(this.j.getLeft(), 0), 0, spannableString.length(), 18);
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
        } else if (m.isEmpty(intro)) {
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
            this.x.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07b5), this.F));
            if (aVar.E.is_in_rank.booleanValue()) {
                Integer num = aVar.E.today_rank;
                if (num != null && num.intValue() > 0 && aVar.E.today_rank.intValue() <= 500) {
                    this.y.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07b4), aVar.E.today_rank));
                } else {
                    this.y.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07b3));
                }
            } else {
                this.y.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07b3));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12800b : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c7, (ViewGroup) null);
            this.f12800b = inflate;
            inflate.setVisibility(8);
            this.s = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917eb);
            this.f12801c = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917dd);
            AlignTextView alignTextView = (AlignTextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917de);
            this.f12802d = alignTextView;
            alignTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f12803e = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917d9);
            this.f12804f = (LinearLayout) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917df);
            this.t = this.f12800b.findViewById(R.id.obfuscated_res_0x7f091d4a);
            this.f12805g = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917db);
            this.f12806h = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917da);
            this.i = (LinearLayout) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917dc);
            AlignTextView alignTextView2 = (AlignTextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e2);
            this.k = alignTextView2;
            alignTextView2.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.j = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e1);
            AlignTextView alignTextView3 = (AlignTextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e4);
            this.l = alignTextView3;
            alignTextView3.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.m = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e3);
            ImageView imageView = (ImageView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e6);
            this.n = imageView;
            imageView.setOnClickListener(this.G);
            RelativeLayout relativeLayout = (RelativeLayout) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e5);
            this.o = relativeLayout;
            relativeLayout.setOnClickListener(this.G);
            this.p = (RelativeLayout) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e7);
            TextView textView = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e8);
            this.q = textView;
            textView.setOnClickListener(this.G);
            this.u = (ImageView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e9);
            this.v = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917ea);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f12800b.findViewById(R.id.obfuscated_res_0x7f090cc4);
            this.w = roundRelativeLayout;
            roundRelativeLayout.setOnClickListener(this.G);
            this.A = (ImageView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f090cc2);
            this.z = (ImageView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f090cc7);
            this.y = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f090cca);
            this.x = (TextView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f090cd4);
            ImageView imageView2 = (ImageView) this.f12800b.findViewById(R.id.obfuscated_res_0x7f0917e0);
            this.r = imageView2;
            imageView2.setOnClickListener(this.G);
            int measureText = (int) this.f12805g.getPaint().measureText(this.a.getString(R.string.obfuscated_res_0x7f0f0dda));
            ViewGroup.LayoutParams layoutParams = this.f12802d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = measureText;
                this.f12802d.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = measureText;
                this.k.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = this.l.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = measureText;
                this.l.setLayoutParams(layoutParams3);
            }
            NoDataView a2 = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070229)), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2c)), null);
            this.E = a2;
            View view = this.f12800b;
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
                personChangeData.setUserAge(this.B.getBirthdayInfo().f10850c);
                personChangeData.setBirthdayTime(this.B.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.B.getBirthdayInfo().f10851d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12802d, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.f12801c, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12803e, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f12805g, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.f12806h, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, R.drawable.obfuscated_res_0x7f0805eb, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            NoDataView noDataView = this.E;
            if (noDataView != null) {
                noDataView.f(this.a, i);
            }
        }
    }
}
