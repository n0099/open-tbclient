package c.a.r0.o2.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.r0.b4.e;
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
    public TbPageContext f23242a;

    /* renamed from: b  reason: collision with root package name */
    public int f23243b;

    /* renamed from: c  reason: collision with root package name */
    public int f23244c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23245d;

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
        this.f23243b = 1;
        this.f23244c = 2;
        this.f23245d = false;
        this.f23242a = tbPageContext;
    }

    @Override // c.a.r0.b4.e
    public void a(View view, c.a.r0.o0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || aVar == null) {
            return;
        }
        UserData userData = null;
        Bundle bundle = aVar.f23033b;
        if (bundle != null && (userData = (UserData) bundle.getSerializable(UserData.TYPE_USER)) != null) {
            this.f23243b = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
            this.f23244c = userData.isGod() ? 1 : 2;
            this.f23245d = this.f23243b == 1;
        }
        switch (aVar.f23032a) {
            case 2:
                if (ViewHelper.checkUpIsLogin(this.f23242a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f23242a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            case 3:
                if (userData == null) {
                    return;
                }
                c.a.q0.m.a.o(this.f23242a.getPageActivity(), this.f23242a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                return;
            case 4:
                if (userData == null) {
                    return;
                }
                if (aVar instanceof c.a.r0.m2.f.a) {
                    TiebaStatic.log(new StatisticItem("c11586"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", this.f23243b).param("obj_source", this.f23244c));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f23242a.getPageActivity(), true, userData.getUserId(), userData.getSex()).updateFollowNum(userData.getConcernNum(), userData.getPortrait())));
                return;
            case 5:
                c.a.r0.z2.a.v().L(2, false, this.f23245d);
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", this.f23243b).param("obj_source", this.f23244c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f23242a.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                return;
            case 6:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 1).param("obj_type", this.f23243b).param("obj_source", this.f23244c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f23242a.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                return;
            case 7:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", this.f23243b).param("obj_source", this.f23244c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f23242a.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                return;
            default:
                return;
        }
    }
}
