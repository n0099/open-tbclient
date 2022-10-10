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
import com.baidu.tieba.ao4;
import com.baidu.tieba.bo4;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.ji5;
import com.baidu.tieba.t16;
import com.baidu.tieba.w9;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UserIconLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public View c;
    public UserIconBox d;
    public UserIconBox e;
    public boolean f;
    public ThreadData g;
    public View.OnClickListener h;
    public boolean i;
    public int j;
    public boolean k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null || this.a.g.getAuthor() == null) {
                return;
            }
            yo4.s(this.a.a.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.g.getAuthor().getUserId() + "&opacity=0", true, true, true);
            if (this.a.j == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || this.a.g == null || this.a.g.getAuthor() == null || this.a.g.getAuthor().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.a.g.getAuthor().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = this.a.g.getAuthor().getTShowInfoNew().get(0).getUrl()) == null || !(w9.a(this.a.a) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(this.a.a), new String[]{url});
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null || this.a.g.getAuthor() == null || StringUtils.isNull(this.a.g.getAuthor().getName_show()) || StringUtils.isNull(this.a.g.getAuthor().getUserId()) || this.a.g.getForum_name() == null) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.a, this.a.g.getAuthor().getUserId(), this.a.g.getAuthor().getName_show(), this.a.g.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setIsVideoThread(this.a.g.getThreadVideoInfo() != null);
            if (this.a.g.getResource() != 1) {
                if (this.a.g.getResource() != 2) {
                    if (this.a.g.getResource() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom("topic_detail");
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.a.h != null) {
                this.a.h.onClick(view2);
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
        this.f = false;
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
        if (!(interceptable == null || interceptable.invokeL(65542, this, threadData) == null) || (threadData2 = this.g) == null || threadData2.getAuthor() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.g.getAuthor().getTShowInfoNew()) && !this.g.getAuthor().isBigV()) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0301);
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
            arrayList.add(new t16.a(str, R.drawable.pic_smalldot_title));
            return t16.h(this.a, str2, arrayList, true);
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
            this.d = new UserIconBox(this.a);
            this.e = new UserIconBox(this.a);
            this.b = new TextView(this.a);
            View a2 = bo4.b().a(this.a, 1);
            this.c = a2;
            if (a2 != null) {
                a2.setVisibility(8);
            }
            layoutParams.setMargins(0, 0, ej.f(this.a, R.dimen.obfuscated_res_0x7f070230), ej.f(this.a, R.dimen.obfuscated_res_0x7f070224));
            layoutParams2.setMargins(ej.f(this.a, R.dimen.obfuscated_res_0x7f0701b2), -ej.f(this.a, R.dimen.obfuscated_res_0x7f070198), 0, 0);
            layoutParams3.setMargins(0, ej.f(this.a, R.dimen.obfuscated_res_0x7f0701d4), 0, 0);
            layoutParams4.setMargins(ej.f(this.a, R.dimen.obfuscated_res_0x7f070302), ej.f(this.a, R.dimen.obfuscated_res_0x7f070298), 0, 0);
            this.b.setTextSize(0, ej.f(this.a, R.dimen.obfuscated_res_0x7f0702b3));
            if (!this.i) {
                this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            }
            this.d.setLayoutParams(layoutParams);
            this.e.setLayoutParams(layoutParams2);
            this.b.setLayoutParams(layoutParams3);
            addView(this.d);
            addView(this.b);
            View view2 = this.c;
            if (view2 != null) {
                addView(view2);
            }
            addView(this.e);
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
        this.g = threadData;
        this.d.setOnClickListener(this.m);
        this.e.setOnClickListener(this.l);
        this.b.setOnClickListener(this.n);
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
            if (this.c != null) {
                ao4 ao4Var = new ao4();
                ao4Var.a = alaUserData;
                ao4Var.b = 1;
                this.c.setTag(ao4Var);
            }
        }
        if (StringUtils.isNull(this.g.getAuthor().getName_show())) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            String name_show = this.g.getAuthor().getName_show();
            if (this.i) {
                if (this.k) {
                    this.b.setText(e(this.g.getAuthor().getSealPrefix(), ji5.l(name_show, 20)));
                    int byteLength = dj.byteLength(name_show);
                    i = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
                    if (!this.f && ListUtils.getCount(iconInfo) != 0) {
                        this.e.setVisibility(0);
                        this.e.h(iconInfo, i, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230), true);
                    } else {
                        this.e.setVisibility(8);
                    }
                    tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.d.setVisibility(0);
                        this.d.h(tShowInfoNew, 2, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302), true);
                    } else {
                        this.d.setVisibility(8);
                    }
                    setUserTextColor(threadData);
                }
                this.b.setText(ji5.l(name_show, 20));
            } else if (this.k) {
                this.b.setText(e(this.g.getAuthor().getSealPrefix(), name_show));
            } else {
                this.b.setText(name_show);
            }
        }
        i = 4;
        ArrayList<IconData> iconInfo2 = threadData.getAuthor().getIconInfo();
        if (!this.f) {
        }
        this.e.setVisibility(8);
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
            this.h = onClickListener;
        }
    }

    public void setUserNameTextSizeRid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b.setTextSize(0, ej.f(this.a, i));
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
        this.f = false;
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
