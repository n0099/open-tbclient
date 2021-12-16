package c.a.s0.t1.a.b.b;

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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PersonalTalkSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final NavigationBar f23814b;

    /* renamed from: c  reason: collision with root package name */
    public final View f23815c;

    /* renamed from: d  reason: collision with root package name */
    public final HeadImageView f23816d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23817e;

    /* renamed from: f  reason: collision with root package name */
    public final UserIconBox f23818f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23819g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f23820h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f23821i;

    /* renamed from: j  reason: collision with root package name */
    public TbSettingTextTipView f23822j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f23823k;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.p2ptalk_setting_activity);
        View findViewById = this.a.findViewById(R.id.person_talk_setting_parent);
        this.f23815c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f23814b = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.talk_detail));
        this.f23814b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m = (PersonaltalkSettingViewBlackManView) this.a.findViewById(R.id.black_status_view);
        this.n = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.setting_detail_view);
        this.l = (LinearLayout) this.a.findViewById(R.id.user_info_lin);
        this.f23820h = (TbSettingTextTipView) this.a.findViewById(R.id.st_delete_talk_history);
        this.f23821i = (TbSettingTextTipView) this.a.findViewById(R.id.st_report);
        this.f23822j = (TbSettingTextTipView) this.a.findViewById(R.id.add_to_black);
        this.f23823k = (RelativeLayout) this.a.findViewById(R.id.remove_from_black_man);
        this.f23820h.setOnClickListener(this.a);
        this.f23821i.setOnClickListener(this.a);
        this.f23822j.setOnClickListener(this.a);
        this.f23823k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.photo);
        this.f23816d = headImageView;
        headImageView.setIsRound(true);
        this.f23817e = (TextView) this.a.findViewById(R.id.name);
        this.f23818f = (UserIconBox) this.a.findViewById(R.id.user_icon_box);
        this.f23819g = (TextView) this.a.findViewById(R.id.user_desc);
    }

    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                this.m.setSex(i2);
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
            this.n.changeNotify(z);
        }
    }

    public void c(f fVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null || fVar.j() == null || (str = fVar.j().portrait) == null || str.length() <= 0) {
            return;
        }
        this.f23816d.setImageResource(0);
        this.f23816d.startLoad(str, 12, false);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.getLayoutMode().j(this.f23815c);
            this.f23814b.onChangeSkinType(this.a.getPageContext(), i2);
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(DataRes dataRes) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f23817e.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
        if (dataRes.sex.intValue() == 1) {
            this.f23817e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (dataRes.sex.intValue() == 2) {
            if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.f23817e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f23817e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i2 = 9;
            this.f23819g.setText(dataRes.intro);
            if (this.f23818f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.f23818f.loadIcon(linkedList, i2, this.a.getResources().getDimensionPixelSize(R.dimen.ds28), this.a.getResources().getDimensionPixelSize(R.dimen.ds28), this.a.getResources().getDimensionPixelSize(R.dimen.ds4));
                return;
            }
            return;
        }
        i2 = 8;
        this.f23819g.setText(dataRes.intro);
        if (this.f23818f == null) {
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
