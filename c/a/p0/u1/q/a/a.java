package c.a.p0.u1.q.a;

import c.a.d.f.d.l;
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
/* loaded from: classes2.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                c.a.o0.r.s.a.f();
                l<byte[]> d2 = c.a.o0.r.s.a.d("tb.im_recommend_detail");
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
