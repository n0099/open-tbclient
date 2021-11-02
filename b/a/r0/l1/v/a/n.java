package b.a.r0.l1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
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
            if (customMessage == null || !(customMessage instanceof GroupsByUidLocalMessage)) {
                return null;
            }
            String str = ResponseGroupsByUidMessage.CACHE_KEY_PREFIX + (TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "");
            b.a.q0.s.r.a.f();
            byte[] bArr = b.a.q0.s.r.a.d("tb.im_entergroup").get(str);
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = new ResponseGroupsByUidLocalMessage();
            if (bArr != null) {
                try {
                    responseGroupsByUidLocalMessage.decodeInBackGround(2001106, bArr);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return responseGroupsByUidLocalMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
