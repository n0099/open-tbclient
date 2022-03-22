package c.a.p0.c4.q;

import c.a.o0.r.r.l1;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class v extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public l1 f13575b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2921333);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (this.f13575b != null || (customResponsedMessage.getData() instanceof l1)) {
            if (customResponsedMessage.getData() != null) {
                this.f13575b = (l1) customResponsedMessage.getData();
            }
            if (this.a.mIsAdd || this.f13575b == null || !TbadkCoreApplication.isLogin()) {
                return;
            }
            c.a.p0.c4.f fVar = this.a.mMainTabTopicTipController;
            l1 l1Var = this.f13575b;
            fVar.j(l1Var.a, l1Var.f10906b, l1Var.f10907c);
        }
    }
}
