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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.R;
import com.baidu.tieba.l9;
import com.baidu.tieba.mv4;
import com.baidu.tieba.nv4;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.wb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView a;
    public UserIconBox b;
    public TextView c;
    public TextView d;
    public UserIconBox e;
    public TextView f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public View k;
    public FrameLayout l;
    public boolean m;
    public View n;
    public TextView o;
    public ThreadData p;
    public Context q;
    public View.OnClickListener r;
    public int s;
    public boolean t;
    public boolean u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadUserInfoLayout a;

        public a(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.q) && this.a.p != null && this.a.p.getAuthor() != null && this.a.p.getAuthor().getTShowInfoNew() != null && ListUtils.getItem(this.a.p.getAuthor().getTShowInfoNew(), 0) != null && (url = this.a.p.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (l9.a(this.a.q) instanceof TbPageContext)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) l9.a(this.a.q), new String[]{url});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadUserInfoLayout a;

        public b(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p != null && this.a.p.getAuthor() != null && !StringUtils.isNull(this.a.p.getAuthor().getName_show()) && !StringUtils.isNull(this.a.p.getAuthor().getUserId()) && this.a.p.getForum_name() != null) {
                if (view2.getTag(R.id.tag_nick_name_activity) != null && (view2.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                    String str = (String) view2.getTag(R.id.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        BrowserHelper.startWebActivity(view2.getContext(), (String) null, str, true);
                        return;
                    }
                }
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.q, this.a.p.getAuthor().getUserId(), this.a.p.getAuthor().getName_show(), this.a.p.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                personInfoActivityConfig.setSourceTid(this.a.p.getTid());
                if (this.a.p.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                if (this.a.p.getResource() == 1) {
                    personInfoActivityConfig.setVideoPersonFrom("home");
                } else if (this.a.p.getResource() == 2) {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                } else if (this.a.p.getResource() == 5) {
                    personInfoActivityConfig.setVideoPersonFrom("topic_detail");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                if (this.a.r != null) {
                    this.a.r.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadUserInfoLayout a;

        public c(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p != null && this.a.p.getAuthor() != null) {
                BrowserHelper.startWebActivity(this.a.q.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.p.getAuthor().getUserId() + "&opacity=0", true, true, true);
                if (this.a.s == 1) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.s = 1;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }

    public final void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadData) != null) || this.s != 3) {
            return;
        }
        if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
            if (this.k != null) {
                mv4 mv4Var = new mv4();
                mv4Var.a = alaUserData;
                mv4Var.b = 1;
                this.k.setTag(mv4Var);
                if (alaUserData.anchor_live == 0) {
                    this.k.setVisibility(8);
                    return;
                } else {
                    this.k.setVisibility(0);
                    return;
                }
            }
            return;
        }
        View view2 = this.k;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void r(ThreadData threadData) {
        String formatTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) && this.f != null && threadData != null) {
            if (threadData.getLast_time_int() <= 0) {
                this.f.setVisibility(4);
                return;
            }
            this.f.setVisibility(0);
            if (this.s == 2) {
                formatTime = StringHelper.getPostTimeInterval(threadData.getLast_time_int());
            } else if (threadData.isLiveThread()) {
                formatTime = StringHelper.getFormatTime(threadData.getCreateTime());
            } else {
                formatTime = StringHelper.getFormatTime(threadData.getLast_time_int() * 1000);
            }
            this.f.setText(formatTime);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = true;
        this.s = 1;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = true;
        this.s = 1;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        f(context);
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...");
        }
        return (String) invokeL.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                o(this.p);
                return;
            }
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.s = i;
        }
    }

    public void setIsFromConcern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.u = z;
        }
    }

    public void setIsSimpleThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.t = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) && (clickableHeaderImageView = this.a) != null) {
            clickableHeaderImageView.setPageId(bdUniqueId);
        }
    }

    public void setTShowVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.m = z;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.r = onClickListener;
            ClickableHeaderImageView clickableHeaderImageView = this.a;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setAfterClickListener(onClickListener);
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.q = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
            this.a = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
            this.b = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
            this.c = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
            this.d = (TextView) inflate.findViewById(R.id.identity_view);
            this.e = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
            this.f = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
            this.g = (TextView) inflate.findViewById(R.id.thread_info_address);
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f0908f5);
            this.n = findViewById(R.id.divider_forum_name);
            this.o = (TextView) findViewById(R.id.thread_info_forum_name);
            this.i = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
            this.j = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
            this.l = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
            View a2 = nv4.b().a(this.q, 1);
            this.k = a2;
            if (a2 != null) {
                a2.setVisibility(8);
                this.l.addView(this.k);
            }
            setGravity(16);
            g();
            this.b.setOnClickListener(this.v);
            this.c.setOnClickListener(this.w);
            this.e.setOnClickListener(this.x);
        }
    }

    public final void q(ThreadData threadData) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) && this.d != null && threadData != null && threadData.getAuthor() != null) {
            MetaData author = threadData.getAuthor();
            if (author.getIs_bawu() == 1) {
                if (threadData.isFromBrandForum) {
                    i = R.drawable.brand_official_btn;
                } else {
                    i = R.drawable.user_identity_btn;
                }
                if (threadData.isFromBrandForum) {
                    i2 = R.color.CAM_X0101;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setBackgroundResource(this.d, i);
                SkinManager.setViewTextColor(this.d, i2);
                if (threadData.isFromBrandForum) {
                    this.d.setVisibility(0);
                    this.d.setText(R.string.brand_official);
                    return;
                } else if ("manager".equals(author.getBawu_type())) {
                    this.d.setVisibility(0);
                    this.d.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(author.getBawu_type())) {
                    this.d.setText(R.string.bawu_member_xbazhu_tip);
                    this.d.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(author.getBawu_type())) {
                    this.d.setText(R.string.bawu_content_assist_tip);
                    this.d.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(author.getBawu_type())) {
                    this.d.setText(R.string.bawu_manage_assist_tip);
                    this.d.setVisibility(0);
                    return;
                } else {
                    this.d.setVisibility(8);
                    return;
                }
            }
            this.d.setVisibility(8);
        }
    }

    public void s(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            if (this.i != null && threadData != null) {
                if (this.u) {
                    if (StringUtils.isNull(threadData.getRecomReason())) {
                        this.i.setVisibility(8);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                    if (layoutParams != null && layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = 0;
                        this.i.setLayoutParams(layoutParams);
                    }
                    this.i.setText(threadData.getRecomReason());
                    this.i.setVisibility(0);
                    return;
                }
                if (this.p.getThreadAlaInfo() != null && this.p.getThreadAlaInfo().share_info != null && this.p.getThreadAlaInfo().share_info.share_user_count > 0 && this.p.isSharedLiveThread()) {
                    ThreadData threadData2 = this.p;
                    if (threadData2.middle_page_num <= 0 || threadData2.middle_page_pass_flag != 0) {
                        this.i.setVisibility(0);
                        int i = this.p.getThreadAlaInfo().share_info.share_user_count;
                        if (i == 1) {
                            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
                            return;
                        } else {
                            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i)}));
                            return;
                        }
                    }
                }
                this.i.setVisibility(8);
                return;
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public final void g() {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (clickableHeaderImageView = this.a) == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.a.setPlaceHolder(1);
        this.a.setIsRound(true);
        this.a.setAfterClickListener(this.r);
    }

    public ClickableHeaderImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ClickableHeaderImageView) invokeV.objValue;
    }

    public boolean getIsSimpleThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0110);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0110);
            q(this.p);
        }
    }

    public boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.p = threadData;
            if (threadData.middle_page_num > 0) {
                if (threadData.middle_page_pass_flag == 0 && threadData.getAuthor() != null) {
                    if (!ListUtils.isEmpty(this.p.getAuthor().getTShowInfoNew())) {
                        this.p.getAuthor().getTShowInfoNew().clear();
                    }
                    this.p.getAuthor().setName_show(getContext().getString(R.string.perfect_selection_video));
                }
                this.b.setOnClickListener(null);
                this.c.setOnClickListener(null);
                this.e.setOnClickListener(null);
                this.a.setClickable(false);
            } else {
                this.b.setOnClickListener(this.v);
                this.c.setOnClickListener(this.w);
                this.e.setOnClickListener(this.x);
                this.a.setClickable(true);
            }
            t(threadData);
            v(threadData);
            s(threadData);
            u(threadData);
            q(threadData);
            r(threadData);
            m(threadData);
            p(threadData);
            o(threadData);
            setVisibility(0);
            n(threadData);
            e(threadData);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, threadData) == null) && this.c != null && threadData != null) {
            if (!StringUtils.isNull(this.p.getAuthor().getName_show())) {
                this.c.setText(i(this.p.getAuthor().getName_show()));
            }
            k();
            int i = this.s;
            if (i == 3 || i == 4) {
                String name_show = this.p.getAuthor().getName_show();
                String userName = this.p.getAuthor().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.c.setText(wb9.b(this.q, this.c.getText().toString()));
                    this.c.setGravity(16);
                    this.c.setTag(R.id.tag_nick_name_activity, wb9.a());
                    SkinManager.setViewTextColor(this.c, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    public final void k() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (threadData = this.p) != null && threadData.getAuthor() != null) {
            ThreadData threadData2 = this.p;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
            } else if (ListUtils.isEmpty(this.p.getAuthor().getTShowInfoNew()) && !this.p.getAuthor().isBigV()) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
            } else {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0301);
            }
        }
    }

    public final void m(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            if (threadData != null && !StringUtils.isNull(threadData.getAddress())) {
                this.g.setText(this.p.getAddress());
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                return;
            }
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        }
    }

    public final void n(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) && this.j != null && threadData != null && threadData.getAuthor() != null) {
            if (threadData.getAuthor().hadConcerned()) {
                this.j.setVisibility(0);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.j, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public final void p(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) && this.a != null && threadData != null && this.p.getAuthor() != null) {
            ThreadData threadData2 = this.p;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                this.a.setShowV(false);
            } else {
                this.a.setShowV(this.p.getAuthor().isBigV());
            }
        }
    }

    public void o(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            if (threadData == null) {
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                return;
            }
            this.p.getForum_name();
            int i = this.s;
            String str2 = (i == 3 || i == 4) ? null : null;
            if (threadData.isTransportThread()) {
                str2 = threadData.mOriginalForumInfo.ori_fname;
            }
            if (StringUtils.isNull(str2)) {
                this.o.setVisibility(8);
                this.n.setVisibility(8);
                return;
            }
            ThreadData threadData2 = this.p;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                str = getContext().getString(R.string.select_video_list);
            } else {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str2, 12, "...") + getResources().getString(R.string.obfuscated_res_0x7f0f0774);
            }
            this.o.setText(str);
            this.o.setVisibility(0);
            this.n.setVisibility(0);
        }
    }

    public final void t(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) && this.b != null && threadData != null && threadData.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) != 0) {
                this.b.setVisibility(0);
                this.b.h(tShowInfoNew, 2, this.q.getResources().getDimensionPixelSize(R.dimen.tbds48), this.q.getResources().getDimensionPixelSize(R.dimen.tbds48), this.q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c), true);
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public final void u(ThreadData threadData) {
        UserIconBox userIconBox;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, threadData) != null) || (userIconBox = this.e) == null) {
            return;
        }
        if (this.u) {
            userIconBox.setVisibility(8);
        } else if (threadData != null && threadData.getAuthor() != null && ((threadData.middle_page_num <= 0 || threadData.middle_page_pass_flag != 0) && this.m)) {
            ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.e.setVisibility(0);
                this.e.h(iconInfo, 4, this.q.getResources().getDimensionPixelSize(R.dimen.tbds40), this.q.getResources().getDimensionPixelSize(R.dimen.tbds40), this.q.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c), true);
                return;
            }
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(8);
        }
    }
}
