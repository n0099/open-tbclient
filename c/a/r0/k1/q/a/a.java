package c.a.r0.k1.q.a;

import c.a.e.e.d.l;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
            UserInfoBigVip userInfoBigVip = null;
            if (customMessage != null && (customMessage.getData() instanceof Long)) {
                long longValue = ((Long) customMessage.getData()).longValue();
                c.a.q0.s.r.a.f();
                l<byte[]> d2 = c.a.q0.s.r.a.d("tb.im_recommend_detail");
                if (d2 == null) {
                    return new CustomResponsedMessage<>(2001306, null);
                }
                byte[] bArr = d2.get(longValue + "");
                if (bArr == null) {
                    return new CustomResponsedMessage<>(2001306, null);
                }
                try {
                    userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                return new CustomResponsedMessage<>(2001306, userInfoBigVip);
            }
            return new CustomResponsedMessage<>(2001306, null);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
