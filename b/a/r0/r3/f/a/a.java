package b.a.r0.r3.f.a;

import b.a.r0.r3.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f23174a;

    /* renamed from: b  reason: collision with root package name */
    public int f23175b;

    public a(TbPageContext<?> tbPageContext) {
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
        this.f23174a = tbPageContext;
    }

    public final boolean a(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dressItemData)) == null) ? TbadkCoreApplication.getCurrentMemberType() == 1 && dressItemData.getFreeUserLevel() == 1 : invokeL.booleanValue;
    }

    public void b(DressItemData dressItemData, boolean z) {
        String string;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData, z) == null) || dressItemData == null) {
            return;
        }
        boolean a2 = b.a(dressItemData);
        if (!a2) {
            a2 = a(dressItemData);
        }
        if (a2) {
            this.f23175b = dressItemData.getPropsId();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BUBBLE_SET);
            httpMessage.setExtra(Integer.valueOf(this.f23175b));
            httpMessage.addParam("bcode", String.valueOf(this.f23175b));
            MessageManager.getInstance().sendMessage(httpMessage);
        } else if (dressItemData.getFreeUserLevel() == 100) {
            if (dressItemData.getActivityFinish() == 0) {
                b.b(this.f23174a, 5, dressItemData.getActivityUrl());
            }
        } else {
            if (dressItemData.getFreeUserLevel() == 101) {
                str = this.f23174a.getString(R.string.become_annual_can_use_bubble);
                i2 = 9;
            } else {
                if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.f23174a.getString(R.string.become_vip_can_use_bubble), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.f23174a.getString(R.string.become_member_can_use_bubble);
                }
                str = string;
                i2 = 0;
            }
            b.d(this.f23174a, 5, str, i2, z ? MemberPayStatistic.REFER_PAGE_POST_BUBBLE : MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
        }
    }
}
