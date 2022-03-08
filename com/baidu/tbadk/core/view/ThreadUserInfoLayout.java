package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.q0.r.r.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRS = 3;
    public static final int GOOD_FRS = 4;
    public static final int HOME = 1;
    public static final int MAX_USERNAME_LENGTH = 14;
    public static final int MY_THREAD = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public UserIconBox f39207e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39208f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f39209g;

    /* renamed from: h  reason: collision with root package name */
    public View f39210h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f39211i;

    /* renamed from: j  reason: collision with root package name */
    public View f39212j;
    public FrameLayout k;
    public boolean l;
    public View m;
    public TbImageView mHeadMask;
    public ClickableHeaderImageView mHeaderImg;
    public TextView mIdentityView;
    public TextView mShareIntro;
    public UserIconBox mUserIcon;
    public TextView mUsername;
    public TextView n;
    public e2 o;
    public Context p;
    public View.OnClickListener q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f39213e;

        public a(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39213e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f39213e.p) || this.f39213e.o == null || this.f39213e.o.J() == null || this.f39213e.o.J().getTShowInfoNew() == null || ListUtils.getItem(this.f39213e.o.J().getTShowInfoNew(), 0) == null || (url = this.f39213e.o.J().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f39213e.p) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f39213e.p), new String[]{url});
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f39214e;

        public b(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39214e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f39214e.o == null || this.f39214e.o.J() == null || StringUtils.isNull(this.f39214e.o.J().getName_show()) || StringUtils.isNull(this.f39214e.o.J().getUserId()) || this.f39214e.o.b0() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.f39214e.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f39214e.p, this.f39214e.o.J().getUserId(), this.f39214e.o.J().getName_show(), this.f39214e.o.b0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.f39214e.o.w1());
            personInfoActivityConfig.setIsVideoThread(this.f39214e.o.u1() != null);
            if (this.f39214e.o.X0() != 1) {
                if (this.f39214e.o.X0() != 2) {
                    if (this.f39214e.o.X0() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom("home");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f39214e.q != null) {
                this.f39214e.q.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f39215e;

        public c(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39215e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f39215e.o == null || this.f39215e.o.J() == null) {
                return;
            }
            c.a.q0.l.a.q(this.f39215e.p.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f39215e.o.J().getUserId() + "&opacity=0", true, true, true);
            if (this.f39215e.r == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.r = 1;
        this.u = 3;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }

    public final void e(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) && this.r == 3) {
            if (e2Var != null && e2Var.J() != null && e2Var.J().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = e2Var.J().getAlaUserData();
                if (this.f39212j != null) {
                    c.a.q0.d.b bVar = new c.a.q0.d.b();
                    bVar.a = alaUserData;
                    bVar.f12250b = 1;
                    this.f39212j.setTag(bVar);
                    if (alaUserData.anchor_live == 0) {
                        this.f39212j.setVisibility(8);
                        return;
                    } else {
                        this.f39212j.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            View view = this.f39212j;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.p = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
            this.mHeaderImg = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
            this.f39207e = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
            this.mUsername = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
            this.mIdentityView = (TextView) inflate.findViewById(R.id.identity_view);
            this.mUserIcon = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
            this.f39208f = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
            this.f39209g = (TextView) inflate.findViewById(R.id.thread_info_address);
            this.f39210h = inflate.findViewById(R.id.divider);
            this.m = findViewById(R.id.divider_forum_name);
            this.n = (TextView) findViewById(R.id.thread_info_forum_name);
            this.mShareIntro = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
            this.f39211i = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
            this.k = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
            View a2 = c.a.q0.d.c.b().a(this.p, 1);
            this.f39212j = a2;
            if (a2 != null) {
                a2.setVisibility(8);
                this.k.addView(this.f39212j);
            }
            setGravity(16);
            g();
            this.f39207e.setOnClickListener(this.v);
            this.mUsername.setOnClickListener(this.w);
            this.mUserIcon.setOnClickListener(this.x);
        }
    }

    public final void g() {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (clickableHeaderImageView = this.mHeaderImg) == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.mHeaderImg.setPlaceHolder(1);
        this.mHeaderImg.setIsRound(true);
        this.mHeaderImg.setAfterClickListener(this.q);
    }

    public ClickableHeaderImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHeaderImg : (ClickableHeaderImageView) invokeV.objValue;
    }

    public boolean getIsSimpleThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUsername : (TextView) invokeV.objValue;
    }

    public final void h() {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (e2Var = this.o) == null || e2Var.J() == null) {
            return;
        }
        e2 e2Var2 = this.o;
        if (e2Var2.x1 > 0 && e2Var2.y1 == 0) {
            SkinManager.setViewTextColor(this.mUsername, (int) R.color.CAM_X0106);
        } else if (ListUtils.isEmpty(this.o.J().getTShowInfoNew()) && !this.o.J().isBigV()) {
            SkinManager.setViewTextColor(this.mUsername, (int) R.color.CAM_X0106);
        } else {
            SkinManager.setViewTextColor(this.mUsername, (int) R.color.CAM_X0301);
        }
    }

    public final void i(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e2Var) == null) {
            if (e2Var != null && !StringUtils.isNull(e2Var.A())) {
                this.f39209g.setText(this.o.A());
                this.f39209g.setVisibility(0);
                this.f39210h.setVisibility(0);
                return;
            }
            this.f39209g.setVisibility(8);
            this.f39210h.setVisibility(8);
        }
    }

    public boolean isTShowVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public final void j(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, e2Var) == null) || this.f39211i == null || e2Var == null || e2Var.J() == null) {
            return;
        }
        if (e2Var.J().hadConcerned()) {
            this.f39211i.setVisibility(0);
            SkinManager.setViewTextColor(this.f39211i, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f39211i, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            return;
        }
        this.f39211i.setVisibility(8);
    }

    public final void k(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, e2Var) == null) || this.mHeaderImg == null || e2Var == null || this.o.J() == null) {
            return;
        }
        e2 e2Var2 = this.o;
        if (e2Var2.x1 > 0 && e2Var2.y1 == 0) {
            this.mHeaderImg.setShowV(false);
        } else {
            this.mHeaderImg.setShowV(this.o.J().isBigV());
        }
    }

    public final void l(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, e2Var) == null) || this.mIdentityView == null || e2Var == null || e2Var.J() == null) {
            return;
        }
        MetaData J = e2Var.J();
        if (J.getIs_bawu() == 1) {
            int i2 = e2Var.K1 ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
            int i3 = e2Var.K1 ? R.color.CAM_X0101 : R.color.CAM_X0107;
            SkinManager.setBackgroundResource(this.mIdentityView, i2);
            SkinManager.setViewTextColor(this.mIdentityView, i3);
            if (e2Var.K1) {
                this.mIdentityView.setVisibility(0);
                this.mIdentityView.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(J.getBawu_type())) {
                this.mIdentityView.setVisibility(0);
                this.mIdentityView.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(J.getBawu_type())) {
                this.mIdentityView.setText(R.string.bawu_member_xbazhu_tip);
                this.mIdentityView.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(J.getBawu_type())) {
                this.mIdentityView.setText(R.string.bawu_content_assist_tip);
                this.mIdentityView.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(J.getBawu_type())) {
                this.mIdentityView.setText(R.string.bawu_manage_assist_tip);
                this.mIdentityView.setVisibility(0);
                return;
            } else {
                this.mIdentityView.setVisibility(8);
                return;
            }
        }
        this.mIdentityView.setVisibility(8);
    }

    public final void m(e2 e2Var) {
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, e2Var) == null) || this.f39208f == null || e2Var == null) {
            return;
        }
        if (e2Var.x0() <= 0) {
            this.f39208f.setVisibility(4);
            return;
        }
        this.f39208f.setVisibility(0);
        if (this.r == 2) {
            formatTime = StringHelper.getPostTimeInterval(e2Var.x0());
        } else if (e2Var.l2()) {
            formatTime = StringHelper.getFormatTime(e2Var.P());
        } else {
            formatTime = StringHelper.getFormatTime(e2Var.x0() * 1000);
        }
        this.f39208f.setText(formatTime);
    }

    public final void n(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, e2Var) == null) || this.f39207e == null || e2Var == null || e2Var.J() == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = e2Var.J().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.f39207e.setVisibility(0);
            this.f39207e.loadIcon(tShowInfoNew, 2, this.p.getResources().getDimensionPixelSize(R.dimen.tbds48), this.p.getResources().getDimensionPixelSize(R.dimen.tbds48), this.p.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.f39207e.setVisibility(8);
    }

    public final void o(e2 e2Var) {
        UserIconBox userIconBox;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, e2Var) == null) || (userIconBox = this.mUserIcon) == null) {
            return;
        }
        if (this.t) {
            userIconBox.setVisibility(8);
        } else if (e2Var != null && e2Var.J() != null && ((e2Var.x1 <= 0 || e2Var.y1 != 0) && this.l)) {
            ArrayList<IconData> iconInfo = e2Var.J().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.mUserIcon.setVisibility(0);
                this.mUserIcon.loadIcon(iconInfo, 4, this.p.getResources().getDimensionPixelSize(R.dimen.tbds40), this.p.getResources().getDimensionPixelSize(R.dimen.tbds40), this.p.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.mUserIcon.setVisibility(8);
        } else {
            this.mUserIcon.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.u == i2) {
            return;
        }
        this.u = i2;
        onChangeSkinType();
    }

    public final void p(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) || this.mUsername == null || e2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.o.J().getName_show())) {
            this.mUsername.setText(processUserName(this.o.J().getName_show()));
        }
        h();
        int i2 = this.r;
        if (i2 == 3 || i2 == 4) {
            String name_show = this.o.J().getName_show();
            String userName = this.o.J().getUserName();
            if (!NickNameActivitySwitch.isOn() || name_show == null || name_show.equals(userName)) {
                return;
            }
            this.mUsername.setText(c.a.r0.u2.c.b(this.p, this.mUsername.getText().toString()));
            this.mUsername.setGravity(16);
            this.mUsername.setTag(R.id.tag_nick_name_activity, c.a.r0.u2.c.a());
            SkinManager.setViewTextColor(this.mUsername, R.color.CAM_X0312, 1);
        }
    }

    public String processUserName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...") : (String) invokeL.objValue;
    }

    public boolean setData(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, e2Var)) == null) {
            if (e2Var == null) {
                setVisibility(8);
                return false;
            }
            this.o = e2Var;
            if (e2Var.x1 > 0) {
                if (e2Var.y1 == 0 && e2Var.J() != null) {
                    if (!ListUtils.isEmpty(this.o.J().getTShowInfoNew())) {
                        this.o.J().getTShowInfoNew().clear();
                    }
                    this.o.J().setName_show(getContext().getString(R.string.perfect_selection_video));
                }
                this.f39207e.setOnClickListener(null);
                this.mUsername.setOnClickListener(null);
                this.mUserIcon.setOnClickListener(null);
                this.mHeaderImg.setClickable(false);
            } else {
                this.f39207e.setOnClickListener(this.v);
                this.mUsername.setOnClickListener(this.w);
                this.mUserIcon.setOnClickListener(this.x);
                this.mHeaderImg.setClickable(true);
            }
            n(e2Var);
            p(e2Var);
            updateShareIntro(e2Var);
            o(e2Var);
            l(e2Var);
            m(e2Var);
            i(e2Var);
            k(e2Var);
            updateForumName(e2Var);
            setVisibility(0);
            j(e2Var);
            e(e2Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setIsFromConcern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.t = z;
        }
    }

    public void setIsSimpleThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.s = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) || (clickableHeaderImageView = this.mHeaderImg) == null) {
            return;
        }
        clickableHeaderImageView.setPageId(bdUniqueId);
    }

    public void setTShowVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.l = z;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.q = onClickListener;
            ClickableHeaderImageView clickableHeaderImageView = this.mHeaderImg;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setAfterClickListener(onClickListener);
            }
        }
    }

    public void showForumNameView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                updateForumName(this.o);
                return;
            }
            this.n.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    public void updateForumName(e2 e2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, e2Var) == null) {
            if (e2Var == null) {
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            this.o.b0();
            int i2 = this.r;
            String str2 = (i2 == 3 || i2 == 4) ? null : null;
            if (e2Var.G2()) {
                str2 = e2Var.J1.ori_fname;
            }
            if (StringUtils.isNull(str2)) {
                this.n.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            e2 e2Var2 = this.o;
            if (e2Var2.x1 > 0 && e2Var2.y1 == 0) {
                str = getContext().getString(R.string.select_video_list);
            } else {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str2, 12, "...") + getResources().getString(R.string.forum);
            }
            this.n.setText(str);
            this.n.setVisibility(0);
            this.m.setVisibility(0);
        }
    }

    public void updateShareIntro(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, e2Var) == null) {
            if (this.mShareIntro != null && e2Var != null) {
                if (this.t) {
                    if (StringUtils.isNull(e2Var.getRecomReason())) {
                        this.mShareIntro.setVisibility(8);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mShareIntro.getLayoutParams();
                    if (layoutParams != null && layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = 0;
                        this.mShareIntro.setLayoutParams(layoutParams);
                    }
                    this.mShareIntro.setText(e2Var.getRecomReason());
                    this.mShareIntro.setVisibility(0);
                    return;
                }
                if (this.o.p1() != null && this.o.p1().share_info != null && this.o.p1().share_info.share_user_count > 0 && this.o.x2()) {
                    e2 e2Var2 = this.o;
                    if (e2Var2.x1 <= 0 || e2Var2.y1 != 0) {
                        this.mShareIntro.setVisibility(0);
                        int i2 = this.o.p1().share_info.share_user_count;
                        if (i2 == 1) {
                            this.mShareIntro.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
                            return;
                        } else {
                            this.mShareIntro.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)}));
                            return;
                        }
                    }
                }
                this.mShareIntro.setVisibility(8);
                return;
            }
            TextView textView = this.mShareIntro;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            h();
            SkinManager.setViewTextColor(this.mShareIntro, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f39208f, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f39210h, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.f39209g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f39210h, R.color.CAM_X0110);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0110);
            l(this.o);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.r = 1;
        this.u = 3;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = true;
        this.r = 1;
        this.u = 3;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }
}
