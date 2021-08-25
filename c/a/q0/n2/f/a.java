package c.a.q0.n2.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.q0.a4.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22661a;

    /* renamed from: b  reason: collision with root package name */
    public int f22662b;

    /* renamed from: c  reason: collision with root package name */
    public int f22663c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22664d;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22662b = 1;
        this.f22663c = 2;
        this.f22664d = false;
        this.f22661a = tbPageContext;
    }

    @Override // c.a.q0.a4.e
    public void a(View view, c.a.q0.n0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || aVar == null) {
            return;
        }
        UserData userData = null;
        Bundle bundle = aVar.f22452b;
        if (bundle != null && (userData = (UserData) bundle.getSerializable(UserData.TYPE_USER)) != null) {
            this.f22662b = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
            this.f22663c = userData.isGod() ? 1 : 2;
            this.f22664d = this.f22662b == 1;
        }
        switch (aVar.f22451a) {
            case 2:
                if (ViewHelper.checkUpIsLogin(this.f22661a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f22661a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            case 3:
                if (userData == null) {
                    return;
                }
                c.a.p0.m.a.p(this.f22661a.getPageActivity(), this.f22661a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                return;
            case 4:
                if (userData == null) {
                    return;
                }
                if (aVar instanceof c.a.q0.l2.f.a) {
                    TiebaStatic.log(new StatisticItem("c11586"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", this.f22662b).param("obj_source", this.f22663c));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22661a.getPageActivity(), true, userData.getUserId(), userData.getSex()).updateFollowNum(userData.getConcernNum(), userData.getPortrait())));
                return;
            case 5:
                c.a.q0.y2.a.v().L(2, false, this.f22664d);
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", this.f22662b).param("obj_source", this.f22663c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22661a.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                return;
            case 6:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 1).param("obj_type", this.f22662b).param("obj_source", this.f22663c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f22661a.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                return;
            case 7:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", this.f22662b).param("obj_source", this.f22663c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f22661a.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                return;
            default:
                return;
        }
    }
}
