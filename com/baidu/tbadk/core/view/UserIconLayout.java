package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.o0.c1.o0;
import c.a.p0.h0.m;
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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class UserIconLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30201b;

    /* renamed from: c  reason: collision with root package name */
    public View f30202c;

    /* renamed from: d  reason: collision with root package name */
    public UserIconBox f30203d;

    /* renamed from: e  reason: collision with root package name */
    public UserIconBox f30204e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30205f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadData f30206g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f30207h;
    public boolean i;
    public int j;
    public boolean k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserIconLayout a;

        public a(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f30206g == null || this.a.f30206g.getAuthor() == null) {
                return;
            }
            c.a.o0.l.a.q(this.a.a.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14a5), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.f30206g.getAuthor().getUserId() + "&opacity=0", true, true, true);
            if (this.a.j == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserIconLayout a;

        public b(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || this.a.f30206g == null || this.a.f30206g.getAuthor() == null || this.a.f30206g.getAuthor().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.a.f30206g.getAuthor().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = this.a.f30206g.getAuthor().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.a.a) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.a), new String[]{url});
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserIconLayout a;

        public c(UserIconLayout userIconLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userIconLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userIconLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f30206g == null || this.a.f30206g.getAuthor() == null || StringUtils.isNull(this.a.f30206g.getAuthor().getName_show()) || StringUtils.isNull(this.a.f30206g.getAuthor().getUserId()) || this.a.f30206g.getForum_name() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.a, this.a.f30206g.getAuthor().getUserId(), this.a.f30206g.getAuthor().getName_show(), this.a.f30206g.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.a.f30206g.getThreadVideoInfo() != null);
            if (this.a.f30206g.getResource() != 1) {
                if (this.a.f30206g.getResource() != 2) {
                    if (this.a.f30206g.getResource() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.a.f30207h != null) {
                this.a.f30207h.onClick(view);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30205f = false;
        this.i = false;
        this.j = 0;
        this.k = false;
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.a = context;
        f();
    }

    private void setUserTextColor(ThreadData threadData) {
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, threadData) == null) || (threadData2 = this.f30206g) == null || threadData2.getAuthor() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.f30206g.getAuthor().getTShowInfoNew()) && !this.f30206g.getAuthor().isBigV()) {
            SkinManager.setViewTextColor(this.f30201b, (int) R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.f30201b, (int) R.color.CAM_X0301);
        if (threadData.getAuthor() == null || threadData.getAuthor().getAlaUserData() == null) {
            return;
        }
        threadData.getAuthor().getAlaUserData();
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
            return m.h(this.a, str2, arrayList, true);
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
            this.f30203d = new UserIconBox(this.a);
            this.f30204e = new UserIconBox(this.a);
            this.f30201b = new TextView(this.a);
            View a2 = c.a.o0.d.c.b().a(this.a, 1);
            this.f30202c = a2;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            layoutParams.setMargins(0, 0, n.f(this.a, R.dimen.obfuscated_res_0x7f070229), n.f(this.a, R.dimen.obfuscated_res_0x7f070224));
            layoutParams2.setMargins(n.f(this.a, R.dimen.obfuscated_res_0x7f0701b2), -n.f(this.a, R.dimen.obfuscated_res_0x7f070198), 0, 0);
            layoutParams3.setMargins(0, n.f(this.a, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
            layoutParams4.setMargins(n.f(this.a, R.dimen.obfuscated_res_0x7f0702fb), n.f(this.a, R.dimen.obfuscated_res_0x7f070291), 0, 0);
            this.f30201b.setTextSize(0, n.f(this.a, R.dimen.obfuscated_res_0x7f0702b3));
            if (!this.i) {
                this.f30201b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            this.f30203d.setLayoutParams(layoutParams);
            this.f30204e.setLayoutParams(layoutParams2);
            this.f30201b.setLayoutParams(layoutParams3);
            addView(this.f30203d);
            addView(this.f30201b);
            View view = this.f30202c;
            if (view != null) {
                addView(view);
            }
            addView(this.f30204e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ThreadData threadData) {
        int i;
        ArrayList<IconData> tShowInfoNew;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        this.f30206g = threadData;
        this.f30203d.setOnClickListener(this.m);
        this.f30204e.setOnClickListener(this.l);
        this.f30201b.setOnClickListener(this.n);
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
            if (this.f30202c != null) {
                c.a.o0.d.b bVar = new c.a.o0.d.b();
                bVar.a = alaUserData;
                bVar.f9997b = 1;
                this.f30202c.setTag(bVar);
            }
        }
        if (StringUtils.isNull(this.f30206g.getAuthor().getName_show())) {
            this.f30201b.setVisibility(8);
        } else {
            this.f30201b.setVisibility(0);
            String name_show = this.f30206g.getAuthor().getName_show();
            if (this.i) {
                if (this.k) {
                    this.f30201b.setText(e(this.f30206g.getAuthor().getSealPrefix(), o0.l(name_show, 20)));
                    int byteLength = c.a.d.f.p.m.byteLength(name_show);
                    i = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
                    if (!this.f30205f && ListUtils.getCount(iconInfo) != 0) {
                        this.f30204e.setVisibility(0);
                        this.f30204e.h(iconInfo, i, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229), true);
                    } else {
                        this.f30204e.setVisibility(8);
                    }
                    tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f30203d.setVisibility(0);
                        this.f30203d.h(tShowInfoNew, 2, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb), true);
                    } else {
                        this.f30203d.setVisibility(8);
                    }
                    setUserTextColor(threadData);
                }
                this.f30201b.setText(o0.l(name_show, 20));
            } else if (this.k) {
                this.f30201b.setText(e(this.f30206g.getAuthor().getSealPrefix(), name_show));
            } else {
                this.f30201b.setText(name_show);
            }
        }
        i = 4;
        ArrayList<IconData> iconInfo2 = threadData.getAuthor().getIconInfo();
        if (!this.f30205f) {
        }
        this.f30204e.setVisibility(8);
        tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(threadData);
    }

    public void setEntelechyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.i = z;
        }
    }

    public void setPageName(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.j = i;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f30207h = onClickListener;
        }
    }

    public void setUserNameTextSizeRid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f30201b.setTextSize(0, n.f(this.a, i));
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
        this.f30205f = false;
        this.i = false;
        this.j = 0;
        this.k = false;
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.a = context;
        f();
    }
}
