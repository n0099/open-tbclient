package c.a.p0.c4.q;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b0 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(MainTabActivity mainTabActivity) {
        super(2921636);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.syncHasFinish) {
            this.a.doSyncFinishTask();
        }
        MainTabActivity mainTabActivity = this.a;
        if (mainTabActivity.videoChannelNoticeNeedShow) {
            mainTabActivity.doVideoChannelNoticeShow();
        }
        MainTabActivity mainTabActivity2 = this.a;
        if (mainTabActivity2.myCreateCenterTipNeedShow) {
            mainTabActivity2.doMyCreateCenterTip();
        }
        MainTabActivity mainTabActivity3 = this.a;
        if (mainTabActivity3.isCheckNewUserRedPackageRunnable) {
            mainTabActivity3.isCheckNewUserRedPackageRunnable = false;
            c.a.d.f.m.e.a().removeCallbacks(this.a.mCheckNewUserRedPackageRunnable);
            c.a.d.f.m.e.a().postDelayed(this.a.mCheckNewUserRedPackageRunnable, 200L);
        }
        if (c.a.o0.r.a0.c.a().f()) {
            c.a.o0.r.a0.c.a().g(this.a.getClass().getName());
            c.a.o0.r.a0.c.a().l(false);
        }
        if (c.a.o0.r.a0.c.a().e()) {
            c.a.o0.r.a0.c.a().h(c.a.o0.r.a0.c.a().b(), this.a.getClass().getName());
            c.a.o0.r.a0.c.a().k(false);
        }
    }
}
