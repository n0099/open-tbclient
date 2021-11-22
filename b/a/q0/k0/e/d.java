package b.a.q0.k0.e;

import b.a.e.f.d.l;
import b.a.q0.k0.b.c;
import b.a.q0.k0.b.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d<T extends b.a.q0.k0.b.c> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str, Class<T> cls) {
        super(i2, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
                return null;
            }
            WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.f13447e);
            WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            b.a.q0.k0.b.c cVar = (b.a.q0.k0.b.c) a();
            if (cVar != null) {
                if (cVar instanceof b.a.q0.k0.b.b) {
                    b.a.q0.s.r.a.f();
                    l<byte[]> e2 = b.a.q0.s.r.a.e(this.f13445f, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        b.a.q0.k0.b.c cVar2 = (b.a.q0.k0.b.c) writeCacheMessage.getData();
                        if (cVar2 == null) {
                            BdCacheService.k().j(e2);
                        } else {
                            e2.remove(cVar2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        b.a.q0.k0.b.c cVar3 = (b.a.q0.k0.b.c) writeCacheMessage.getData();
                        if (cVar3 == null) {
                            return writeCacheRespMsg;
                        }
                        e2.g(cVar3.getCacheKey(), ((b.a.q0.k0.b.b) cVar3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (cVar instanceof e) {
                    b.a.q0.s.r.a.f();
                    l<String> h3 = b.a.q0.s.r.a.h(this.f13445f, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        b.a.q0.k0.b.c cVar4 = (b.a.q0.k0.b.c) writeCacheMessage.getData();
                        if (cVar4 == null) {
                            BdCacheService.k().j(h3);
                        } else {
                            h3.remove(cVar4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        b.a.q0.k0.b.c cVar5 = (b.a.q0.k0.b.c) writeCacheMessage.getData();
                        if (cVar5 != null && (h2 = ((e) cVar5).h()) != null) {
                            h3.g(cVar5.getCacheKey(), h2);
                            writeCacheRespMsg.setSuccess(true);
                        }
                    }
                }
            }
            return writeCacheRespMsg;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
