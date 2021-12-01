package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.q.d2;
import c.a.r0.g0.m;
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
/* loaded from: classes9.dex */
public class UserIconLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENTELECHY_USER_NAME_MAX_LENGTH = 20;
    public static final int MAX_USER_NAME_LENTH = 14;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f41373e;

    /* renamed from: f  reason: collision with root package name */
    public View f41374f;

    /* renamed from: g  reason: collision with root package name */
    public UserIconBox f41375g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f41376h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f41377i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f41378j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f41379k;
    public int l;
    public boolean m;
    public TextView mUserName;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public boolean showUserIcon;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f41380e;

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
            this.f41380e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41380e.f41377i == null || this.f41380e.f41377i.J() == null) {
                return;
            }
            c.a.q0.m.a.q(this.f41380e.f41373e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f41380e.f41377i.J().getUserId(), true, true, true);
            if (this.f41380e.l == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f41381e;

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
            this.f41381e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f41381e.f41373e) || this.f41381e.f41377i == null || this.f41381e.f41377i.J() == null || this.f41381e.f41377i.J().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.f41381e.f41377i.J().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = this.f41381e.f41377i.J().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f41381e.f41373e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f41381e.f41373e), new String[]{url});
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f41382e;

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
            this.f41382e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41382e.f41377i == null || this.f41382e.f41377i.J() == null || StringUtils.isNull(this.f41382e.f41377i.J().getName_show()) || StringUtils.isNull(this.f41382e.f41377i.J().getUserId()) || this.f41382e.f41377i.a0() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f41382e.f41373e, this.f41382e.f41377i.J().getUserId(), this.f41382e.f41377i.J().getName_show(), this.f41382e.f41377i.a0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.f41382e.f41377i.t1() != null);
            if (this.f41382e.f41377i.W0() != 1) {
                if (this.f41382e.f41377i.W0() != 2) {
                    if (this.f41382e.f41377i.W0() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom("home");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f41382e.f41378j != null) {
                this.f41382e.f41378j.onClick(view);
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
        this.f41379k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.f41373e = context;
        f();
    }

    private void setUserTextColor(d2 d2Var) {
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, d2Var) == null) || (d2Var2 = this.f41377i) == null || d2Var2.J() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f41377i.J().getTShowInfoNew()) && !this.f41377i.J().isBigV()) {
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
            return m.h(this.f41373e, str2, arrayList, true);
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
            this.f41375g = new UserIconBox(this.f41373e);
            this.f41376h = new UserIconBox(this.f41373e);
            this.mUserName = new TextView(this.f41373e);
            View a2 = c.a.q0.e.c.b().a(this.f41373e, 1);
            this.f41374f = a2;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            layoutParams.setMargins(0, 0, l.f(this.f41373e, R.dimen.ds10), l.f(this.f41373e, R.dimen.ds4));
            layoutParams2.setMargins(l.f(this.f41373e, R.dimen.ds14), -l.f(this.f41373e, R.dimen.ds1), 0, 0);
            layoutParams3.setMargins(0, l.f(this.f41373e, R.dimen.ds2), 0, 0);
            layoutParams4.setMargins(l.f(this.f41373e, R.dimen.ds8), l.f(this.f41373e, R.dimen.ds3), 0, 0);
            this.mUserName.setTextSize(0, l.f(this.f41373e, R.dimen.fontsize24));
            if (!this.f41379k) {
                this.mUserName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            this.f41375g.setLayoutParams(layoutParams);
            this.f41376h.setLayoutParams(layoutParams2);
            this.mUserName.setLayoutParams(layoutParams3);
            addView(this.f41375g);
            addView(this.mUserName);
            View view = this.f41374f;
            if (view != null) {
                addView(view);
            }
            addView(this.f41376h);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setUserTextColor(this.f41377i);
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
        this.f41377i = d2Var;
        this.f41375g.setOnClickListener(this.o);
        this.f41376h.setOnClickListener(this.n);
        this.mUserName.setOnClickListener(this.p);
        if (d2Var.J() != null && d2Var.J().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = d2Var.J().getAlaUserData();
            if (this.f41374f != null) {
                c.a.q0.e.b bVar = new c.a.q0.e.b();
                bVar.a = alaUserData;
                bVar.f11960b = 1;
                this.f41374f.setTag(bVar);
            }
        }
        if (StringUtils.isNull(this.f41377i.J().getName_show())) {
            this.mUserName.setVisibility(8);
        } else {
            this.mUserName.setVisibility(0);
            String name_show = this.f41377i.J().getName_show();
            if (this.f41379k) {
                if (this.m) {
                    this.mUserName.setText(e(this.f41377i.J().getSealPrefix(), m0.k(name_show, 20)));
                    int byteLength = k.byteLength(name_show);
                    i2 = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = d2Var.J().getIconInfo();
                    if (!this.showUserIcon && ListUtils.getCount(iconInfo) != 0) {
                        this.f41376h.setVisibility(0);
                        this.f41376h.loadIcon(iconInfo, i2, this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds10), true);
                    } else {
                        this.f41376h.setVisibility(8);
                    }
                    tShowInfoNew = d2Var.J().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f41375g.setVisibility(0);
                        this.f41375g.loadIcon(tShowInfoNew, 2, this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f41373e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    } else {
                        this.f41375g.setVisibility(8);
                    }
                    setUserTextColor(d2Var);
                }
                this.mUserName.setText(m0.k(name_show, 20));
            } else if (this.m) {
                this.mUserName.setText(e(this.f41377i.J().getSealPrefix(), name_show));
            } else {
                this.mUserName.setText(name_show);
            }
        }
        i2 = 4;
        ArrayList<IconData> iconInfo2 = d2Var.J().getIconInfo();
        if (!this.showUserIcon) {
        }
        this.f41376h.setVisibility(8);
        tShowInfoNew = d2Var.J().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(d2Var);
    }

    public void setEntelechyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f41379k = z;
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
            this.f41378j = onClickListener;
        }
    }

    public void setUserNameTextSizeRid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mUserName.setTextSize(0, l.f(this.f41373e, i2));
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
        this.f41379k = false;
        this.l = 0;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.f41373e = context;
        f();
    }
}
