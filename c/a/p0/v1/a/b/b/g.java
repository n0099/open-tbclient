package c.a.p0.v1.a.b.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonaltalkSettingViewBlackManView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PersonalTalkSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f19046b;

    /* renamed from: c  reason: collision with root package name */
    public final View f19047c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f19048d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f19049e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f19050f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f19051g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f19052h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public RelativeLayout k;
    public LinearLayout l;
    public PersonaltalkSettingViewBlackManView m;
    public PersonalTalkSettingViewSettingView n;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d0653);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0917fc);
        this.f19047c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f19046b = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f133e));
        this.f19046b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.a.findViewById(R.id.obfuscated_res_0x7f090384);
        this.n = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f091ca4);
        this.l = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0922b1);
        this.f19052h = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091d8e);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091d8f);
        this.j = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09011c);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a3f);
        this.f19052h.setOnClickListener(this.a);
        this.i.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091827);
        this.f19048d = headImageView;
        headImageView.setIsRound(true);
        this.f19049e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0914e9);
        this.f19050f = (UserIconBox) this.a.findViewById(R.id.obfuscated_res_0x7f0922a9);
        this.f19051g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09229f);
    }

    public void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.m.setSex(i);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(0);
            this.m.setVisibility(8);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n.a(z);
        }
    }

    public void c(f fVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null || fVar.j() == null || (str = fVar.j().portrait) == null || str.length() <= 0) {
            return;
        }
        this.f19048d.setImageResource(0);
        this.f19048d.J(str, 12, false);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().j(this.f19047c);
            this.f19046b.onChangeSkinType(this.a.getPageContext(), i);
        }
    }

    public void e(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || (personalTalkSettingViewSettingView = this.n) == null) {
            return;
        }
        personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(DataRes dataRes) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f19049e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f19049e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f19049e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f19049e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i = 9;
            this.f19051g.setText(dataRes.intro);
            if (this.f19050f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f19050f.g(linkedList, i, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                return;
            }
            return;
        }
        i = 8;
        this.f19051g.setText(dataRes.intro);
        if (this.f19050f == null) {
        }
    }

    public void g(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null) {
            return;
        }
        a(fVar.l(), fVar.j().sex.intValue());
        b(fVar.m());
        f(fVar.j());
        c(fVar);
    }
}
