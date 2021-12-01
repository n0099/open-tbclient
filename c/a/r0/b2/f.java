package c.a.r0.b2;

import c.a.d.f.d.l;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryWriteMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryWriteMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
            if (customMessage != null && (customMessage instanceof RequestSearchPersonHistoryWriteMessage)) {
                RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = (RequestSearchPersonHistoryWriteMessage) customMessage;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                c.a.q0.s.r.a.f();
                l<String> h2 = c.a.q0.s.r.a.h("tb.searchperson_history", currentAccount);
                if (requestSearchPersonHistoryWriteMessage.isClear()) {
                    BdCacheService.j().i(h2);
                } else {
                    Object data = requestSearchPersonHistoryWriteMessage.getData();
                    if (data != null && (data instanceof String)) {
                        h2.g((String) data, null);
                    }
                }
                return new ResponseSearchPersonHistoryWriteMessage();
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
