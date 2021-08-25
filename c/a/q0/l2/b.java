package c.a.q0.l2;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f21736b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21737a;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21737a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f21736b == null) {
                synchronized (b.class) {
                    if (f21736b == null) {
                        f21736b = new b(TbadkCoreApplication.getInst());
                    }
                }
            }
            return f21736b;
        }
        return (b) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                TbadkCoreApplication.getInst();
                UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
            }
            UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
            UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
            Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f21737a, 0);
            feedbackInputIntent.addFlags(268435456);
            this.f21737a.startActivity(feedbackInputIntent);
        }
    }
}
