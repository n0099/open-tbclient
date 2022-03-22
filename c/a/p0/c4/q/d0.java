package c.a.p0.c4.q;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d0 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2001371);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || MainTabActivity.syncHasFinish) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        c.a.p0.x1.c k = c.a.p0.x1.c.k(mainTabActivity);
        int intValue = this.a.mCurrentTabIndex.intValue();
        MainTabActivity mainTabActivity2 = this.a;
        mainTabActivity.isRequestInsertAdCold = k.y("1", intValue, 0, mainTabActivity2.mAppBackgroundTime, new c.a.p0.c4.m(mainTabActivity2), false);
        if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
            return;
        }
        MainTabActivity mainTabActivity3 = this.a;
        if (mainTabActivity3.mIsSplashClick) {
            return;
        }
        mainTabActivity3.showInsertAdDelay();
        this.a.showStampMissionDialog();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
            a();
            MainTabActivity.syncHasFinish = true;
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            if (!this.a.mIsSplashClick) {
                if (UbsABTestHelper.isNewInterestShowTestA()) {
                    this.a.showInterestPanel();
                } else {
                    this.a.firstLoginInterestGuide();
                }
            }
            this.a.doSyncFinishTask();
        }
    }
}
