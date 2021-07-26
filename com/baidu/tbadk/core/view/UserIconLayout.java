package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import d.a.d.a.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import d.a.p0.s.q.b2;
import d.a.q0.a0.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UserIconLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12683e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12684f;

    /* renamed from: g  reason: collision with root package name */
    public View f12685g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f12686h;

    /* renamed from: i  reason: collision with root package name */
    public UserIconBox f12687i;
    public boolean j;
    public b2 k;
    public View.OnClickListener l;
    public boolean m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f12688e;

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
            this.f12688e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12688e.k == null || this.f12688e.k.H() == null) {
                return;
            }
            d.a.p0.m.a.o(this.f12688e.f12683e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f12688e.k.H().getUserId(), true, true, true);
            if (this.f12688e.n == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f12689e;

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
            this.f12689e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f12689e.f12683e) || this.f12689e.k == null || this.f12689e.k.H() == null || this.f12689e.k.H().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.f12689e.k.H().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = this.f12689e.k.H().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f12689e.f12683e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f12689e.f12683e), new String[]{url});
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserIconLayout f12690e;

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
            this.f12690e = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12690e.k == null || this.f12690e.k.H() == null || StringUtils.isNull(this.f12690e.k.H().getName_show()) || StringUtils.isNull(this.f12690e.k.H().getUserId()) || this.f12690e.k.X() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f12690e.f12683e, this.f12690e.k.H().getUserId(), this.f12690e.k.H().getName_show(), this.f12690e.k.X(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
            if (this.f12690e.l != null) {
                this.f12690e.l.onClick(view);
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
        this.j = false;
        this.m = false;
        this.n = 0;
        this.o = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.f12683e = context;
        f();
    }

    private void setUserTextColor(b2 b2Var) {
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, b2Var) == null) || (b2Var2 = this.k) == null || b2Var2.H() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.k.H().getTShowInfoNew()) && !this.k.H().isBigV()) {
            SkinManager.setViewTextColor(this.f12684f, R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.f12684f, R.color.CAM_X0301);
        if (b2Var.H() == null || b2Var.H().getAlaUserData() == null) {
            return;
        }
        b2Var.H().getAlaUserData();
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
            return m.h(this.f12683e, str2, arrayList, true);
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
            this.f12686h = new UserIconBox(this.f12683e);
            this.f12687i = new UserIconBox(this.f12683e);
            this.f12684f = new TextView(this.f12683e);
            View a2 = d.a.p0.e.c.b().a(this.f12683e, 1);
            this.f12685g = a2;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            layoutParams.setMargins(0, 0, l.g(this.f12683e, R.dimen.ds10), l.g(this.f12683e, R.dimen.ds4));
            layoutParams2.setMargins(l.g(this.f12683e, R.dimen.ds14), -l.g(this.f12683e, R.dimen.ds1), 0, 0);
            layoutParams3.setMargins(0, l.g(this.f12683e, R.dimen.ds2), 0, 0);
            layoutParams4.setMargins(l.g(this.f12683e, R.dimen.ds8), l.g(this.f12683e, R.dimen.ds3), 0, 0);
            this.f12684f.setTextSize(0, l.g(this.f12683e, R.dimen.fontsize24));
            if (!this.m) {
                this.f12684f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            this.f12686h.setLayoutParams(layoutParams);
            this.f12687i.setLayoutParams(layoutParams2);
            this.f12684f.setLayoutParams(layoutParams3);
            addView(this.f12686h);
            addView(this.f12684f);
            View view = this.f12685g;
            if (view != null) {
                addView(view);
            }
            addView(this.f12687i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(b2 b2Var) {
        int i2;
        ArrayList<IconData> tShowInfoNew;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        this.k = b2Var;
        this.f12686h.setOnClickListener(this.q);
        this.f12687i.setOnClickListener(this.p);
        this.f12684f.setOnClickListener(this.r);
        if (b2Var.H() != null && b2Var.H().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = b2Var.H().getAlaUserData();
            if (this.f12685g != null) {
                d.a.p0.e.b bVar = new d.a.p0.e.b();
                bVar.f52498a = alaUserData;
                bVar.f52499b = 1;
                this.f12685g.setTag(bVar);
            }
        }
        if (StringUtils.isNull(this.k.H().getName_show())) {
            this.f12684f.setVisibility(8);
        } else {
            this.f12684f.setVisibility(0);
            String name_show = this.k.H().getName_show();
            if (this.m) {
                if (this.o) {
                    this.f12684f.setText(e(this.k.H().getSealPrefix(), j0.j(name_show, 20)));
                    int byteLength = k.byteLength(name_show);
                    i2 = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = b2Var.H().getIconInfo();
                    if (!this.j && ListUtils.getCount(iconInfo) != 0) {
                        this.f12687i.setVisibility(0);
                        this.f12687i.h(iconInfo, i2, this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds10), true);
                    } else {
                        this.f12687i.setVisibility(8);
                    }
                    tShowInfoNew = b2Var.H().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f12686h.setVisibility(0);
                        this.f12686h.h(tShowInfoNew, 2, this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f12683e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    } else {
                        this.f12686h.setVisibility(8);
                    }
                    setUserTextColor(b2Var);
                }
                this.f12684f.setText(j0.j(name_show, 20));
            } else if (this.o) {
                this.f12684f.setText(e(this.k.H().getSealPrefix(), name_show));
            } else {
                this.f12684f.setText(name_show);
            }
        }
        i2 = 4;
        ArrayList<IconData> iconInfo2 = b2Var.H().getIconInfo();
        if (!this.j) {
        }
        this.f12687i.setVisibility(8);
        tShowInfoNew = b2Var.H().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(b2Var);
    }

    public void setEntelechyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.m = z;
        }
    }

    public void setPageName(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void setUserNameTextSizeRid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f12684f.setTextSize(0, l.g(this.f12683e, i2));
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
        this.j = false;
        this.m = false;
        this.n = 0;
        this.o = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.f12683e = context;
        f();
    }
}
