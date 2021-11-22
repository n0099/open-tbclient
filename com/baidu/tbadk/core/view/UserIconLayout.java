package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
import b.a.q0.s.q.d2;
import b.a.r0.b0.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class UserIconLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENTELECHY_USER_NAME_MAX_LENGTH = 20;
    public static final int MAX_USER_NAME_LENTH = 14;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46329e;

    /* renamed from: f  reason: collision with root package name */
    public View f46330f;

    /* renamed from: g  reason: collision with root package name */
    public UserIconBox f46331g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f46332h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f46333i;
    public View.OnClickListener j;
    public boolean k;
    public int l;
    public boolean m;
    public TextView mUserName;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public boolean showUserIcon;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f46334e;

        public a(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46334e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46334e.f46333i == null || this.f46334e.f46333i.J() == null) {
                return;
            }
            b.a.q0.m.a.q(this.f46334e.f46329e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f46334e.f46333i.J().getUserId(), true, true, true);
            if (this.f46334e.l == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f46335e;

        public b(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46335e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f46335e.f46329e) || this.f46335e.f46333i == null || this.f46335e.f46333i.J() == null || this.f46335e.f46333i.J().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.f46335e.f46333i.J().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = this.f46335e.f46333i.J().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f46335e.f46329e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f46335e.f46329e), new String[]{url});
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f46336e;

        public c(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46336e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46336e.f46333i == null || this.f46336e.f46333i.J() == null || StringUtils.isNull(this.f46336e.f46333i.J().getName_show()) || StringUtils.isNull(this.f46336e.f46333i.J().getUserId()) || this.f46336e.f46333i.Z() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f46336e.f46329e, this.f46336e.f46333i.J().getUserId(), this.f46336e.f46333i.J().getName_show(), this.f46336e.f46333i.Z(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.f46336e.f46333i.r1() != null);
            if (this.f46336e.f46333i.V0() != 1) {
                if (this.f46336e.f46333i.V0() != 2) {
                    if (this.f46336e.f46333i.V0() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom("home");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f46336e.j != null) {
                this.f46336e.j.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconLayout(Context context) {
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
        this.showUserIcon = false;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.f46329e = context;
        f();
    }

    private void setUserTextColor(d2 d2Var) {
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, d2Var) == null) || (d2Var2 = this.f46333i) == null || d2Var2.J() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f46333i.J().getTShowInfoNew()) && !this.f46333i.J().isBigV()) {
            SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301);
        if (d2Var.J() == null || d2Var.J().getAlaUserData() == null) {
            return;
        }
        d2Var.J().getAlaUserData();
    }

    public final SpannableStringBuilder e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.h(this.f46329e, str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams2.gravity = 16;
            layoutParams3.gravity = 16;
            layoutParams4.gravity = 16;
            this.f46331g = new UserIconBox(this.f46329e);
            this.f46332h = new UserIconBox(this.f46329e);
            this.mUserName = new TextView(this.f46329e);
            View a2 = b.a.q0.e.c.b().a(this.f46329e, 1);
            this.f46330f = a2;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            layoutParams.setMargins(0, 0, l.g(this.f46329e, R.dimen.ds10), l.g(this.f46329e, R.dimen.ds4));
            layoutParams2.setMargins(l.g(this.f46329e, R.dimen.ds14), -l.g(this.f46329e, R.dimen.ds1), 0, 0);
            layoutParams3.setMargins(0, l.g(this.f46329e, R.dimen.ds2), 0, 0);
            layoutParams4.setMargins(l.g(this.f46329e, R.dimen.ds8), l.g(this.f46329e, R.dimen.ds3), 0, 0);
            this.mUserName.setTextSize(0, l.g(this.f46329e, R.dimen.fontsize24));
            if (!this.k) {
                this.mUserName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            this.f46331g.setLayoutParams(layoutParams);
            this.f46332h.setLayoutParams(layoutParams2);
            this.mUserName.setLayoutParams(layoutParams3);
            addView(this.f46331g);
            addView(this.mUserName);
            View view = this.f46330f;
            if (view != null) {
                addView(view);
            }
            addView(this.f46332h);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setUserTextColor(this.f46333i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(d2 d2Var) {
        int i2;
        ArrayList<IconData> tShowInfoNew;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        this.f46333i = d2Var;
        this.f46331g.setOnClickListener(this.o);
        this.f46332h.setOnClickListener(this.n);
        this.mUserName.setOnClickListener(this.p);
        if (d2Var.J() != null && d2Var.J().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = d2Var.J().getAlaUserData();
            if (this.f46330f != null) {
                b.a.q0.e.b bVar = new b.a.q0.e.b();
                bVar.f12949a = alaUserData;
                bVar.f12950b = 1;
                this.f46330f.setTag(bVar);
            }
        }
        if (StringUtils.isNull(this.f46333i.J().getName_show())) {
            this.mUserName.setVisibility(8);
        } else {
            this.mUserName.setVisibility(0);
            String name_show = this.f46333i.J().getName_show();
            if (this.k) {
                if (this.m) {
                    this.mUserName.setText(e(this.f46333i.J().getSealPrefix(), m0.k(name_show, 20)));
                    int byteLength = k.byteLength(name_show);
                    i2 = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = d2Var.J().getIconInfo();
                    if (!this.showUserIcon && ListUtils.getCount(iconInfo) != 0) {
                        this.f46332h.setVisibility(0);
                        this.f46332h.loadIcon(iconInfo, i2, this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds10), true);
                    } else {
                        this.f46332h.setVisibility(8);
                    }
                    tShowInfoNew = d2Var.J().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f46331g.setVisibility(0);
                        this.f46331g.loadIcon(tShowInfoNew, 2, this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f46329e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    } else {
                        this.f46331g.setVisibility(8);
                    }
                    setUserTextColor(d2Var);
                }
                this.mUserName.setText(m0.k(name_show, 20));
            } else if (this.m) {
                this.mUserName.setText(e(this.f46333i.J().getSealPrefix(), name_show));
            } else {
                this.mUserName.setText(name_show);
            }
        }
        i2 = 4;
        ArrayList<IconData> iconInfo2 = d2Var.J().getIconInfo();
        if (!this.showUserIcon) {
        }
        this.f46332h.setVisibility(8);
        tShowInfoNew = d2Var.J().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(d2Var);
    }

    public void setEntelechyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
        }
    }

    public void setPageName(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public void setUserNameTextSizeRid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mUserName.setTextSize(0, l.g(this.f46329e, i2));
        }
    }

    public void showSealPrefix(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.m = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconLayout(Context context, AttributeSet attributeSet) {
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
        this.showUserIcon = false;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.f46329e = context;
        f();
    }
}
