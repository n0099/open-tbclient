package c.a.p0.c4.q;

import android.app.Activity;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class u extends c.a.d.c.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.mLikeForumNum == 1) {
                mainTabActivity.createLikeFirstForumTips();
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                MainTabActivity mainTabActivity2 = this.a;
                if (currentActivity != mainTabActivity2 || mainTabActivity2.mCurrentTabIndex.intValue() == 1) {
                    return;
                }
                this.a.showLikeFirstForumTips();
            }
        }
    }

    public final void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileHttpResponseMessage) == null) {
            if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
                this.a.mLikeForumNum = profileHttpResponseMessage.GetUser().my_like_num.intValue();
                MainTabActivity mainTabActivity = this.a;
                if (mainTabActivity.mLikeForumNum == 1) {
                    mainTabActivity.createLikeFirstForumTips();
                    this.a.showLikeFirstForumTips();
                }
                a();
            }
            if (profileHttpResponseMessage == null || profileHttpResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.isPermanentBan = profileHttpResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.isAutoPay = profileHttpResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
        }
    }

    public final void c(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, profileSocketResponseMessage) == null) {
            if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
                this.a.mLikeForumNum = profileSocketResponseMessage.GetUser().my_like_num.intValue();
                MainTabActivity mainTabActivity = this.a;
                if (mainTabActivity.mLikeForumNum == 1) {
                    mainTabActivity.createLikeFirstForumTips();
                    a();
                }
            }
            if (profileSocketResponseMessage == null || profileSocketResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.isPermanentBan = profileSocketResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.isAutoPay = profileSocketResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
        }
    }

    @Override // c.a.d.c.g.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, responsedMessage) == null) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() != null) {
                    this.a.getUniqueId();
                }
                if (z) {
                    c((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    b((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
