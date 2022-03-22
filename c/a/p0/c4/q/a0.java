package c.a.p0.c4.q;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a0 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.c4.h f13562b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2001304);
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
        this.f13562b = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.c4.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer) || (hVar = this.f13562b) == null || hVar.z() == null) {
            return;
        }
        int intValue = ((Integer) customResponsedMessage.getData()).intValue();
        int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
        boolean z = false;
        if ((intValue == 2 || oldSkinType == 2) ? false : true) {
            return;
        }
        if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
            z = true;
        }
        if (z) {
            this.f13562b.z().f(1);
        } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.f13562b.z().f(2);
        } else {
            this.f13562b.z().f(1);
        }
    }
}
