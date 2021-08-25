package c.a.q0.t0.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof BawuTeamInfoReadCacheRequestMessage)) {
                return null;
            }
            byte[] a2 = new d().a(((BawuTeamInfoReadCacheRequestMessage) customMessage).getCacheKey());
            BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = new BawuTeamReadCacheResponseMessage();
            try {
                bawuTeamReadCacheResponseMessage.decodeInBackGround(2003005, a2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return bawuTeamReadCacheResponseMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
