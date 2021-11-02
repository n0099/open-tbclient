package b.a.r0.k2.q.b;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcPbPageResIdl;
/* loaded from: classes5.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
        ExcPbPageResIdl excPbPageResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            a aVar = null;
            if (customMessage != null && customMessage.getCmd() == 2001314) {
                b.a.q0.s.r.a.f();
                byte[] bArr = b.a.q0.s.r.a.d("tb.pb_normal").get(PbChosenActivity.CHOSEN_PB_TABLE_NAME);
                if (bArr != null) {
                    try {
                        excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
                    } catch (Exception unused) {
                        excPbPageResIdl = null;
                    }
                    if (excPbPageResIdl != null && (dataRes = excPbPageResIdl.data) != null) {
                        aVar = new a(dataRes.user_info, dataRes.thread_info, dataRes.post_list, dataRes.user_list);
                    }
                }
                return new ReadChosenPbCacheResponse(aVar);
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
