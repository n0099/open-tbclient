package c.a.q0.k0.e;

import c.a.e.e.d.l;
import c.a.e.e.p.p;
import c.a.q0.k0.b.c;
import c.a.q0.k0.b.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c<T extends c.a.q0.k0.b.c> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, Class<T> cls) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x00d5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0073 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v11. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v8. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        c.a.q0.k0.b.c cVar;
        byte[] bArr;
        c.a.q0.k0.b.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        c.a.q0.k0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        c.a.q0.k0.b.c cVar4 = (c.a.q0.k0.b.c) a();
        try {
            try {
                if (readCacheMessage.isNeedUid()) {
                    str = TbadkCoreApplication.getCurrentAccount();
                    if (str == null) {
                        str = "";
                    }
                } else {
                    str = null;
                }
                if (cVar4 != null) {
                    if (readCacheMessage.getRequestData() == null) {
                        try {
                            if (cVar4 instanceof c.a.q0.k0.b.b) {
                                c.a.q0.s.r.a.f();
                                List<l.b<byte[]>> a2 = p.a(c.a.q0.s.r.a.e(this.f13535f, str));
                                if (a2 != null) {
                                    arrayList = new ArrayList(a2.size());
                                    for (l.b<byte[]> bVar : a2) {
                                        if (bVar != null && (bArr = bVar.f2224b) != null && (cVar2 = (c.a.q0.k0.b.c) a()) != null) {
                                            ((c.a.q0.k0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.q0.s.r.a.f();
                                List<l.b<String>> b2 = p.b(c.a.q0.s.r.a.h(this.f13535f, str));
                                if (b2 != null) {
                                    arrayList = new ArrayList(b2.size());
                                    for (l.b<String> bVar2 : b2) {
                                        if (bVar2 != null && (str2 = bVar2.f2224b) != null && (cVar = (c.a.q0.k0.b.c) a()) != null) {
                                            ((e) cVar).n(str2);
                                            arrayList.add(cVar);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cVar3 = cVar4;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f13537e, cVar3);
                        } catch (Throwable unused) {
                            cVar3 = cVar4;
                            return new ReadCacheRespMsg(this.f13537e, cVar3);
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String v = readCacheMessage.getRequestData().v();
                        try {
                            if (cVar4 instanceof c.a.q0.k0.b.b) {
                                c.a.q0.s.r.a.f();
                                byte[] bArr2 = c.a.q0.s.r.a.e(v, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((c.a.q0.k0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    v = arrayList2;
                                    cVar3 = v;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.q0.s.r.a.f();
                                String str3 = c.a.q0.s.r.a.h(v, str).get(cacheKey);
                                if (str3 != null) {
                                    ((e) cVar4).n(str3);
                                    ?? arrayList3 = new ArrayList();
                                    arrayList3.add(cVar4);
                                    v = arrayList3;
                                    cVar3 = v;
                                }
                            }
                        } catch (Exception e3) {
                            cVar3 = v;
                            e = e3;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.f13537e, cVar3);
                        } catch (Throwable unused2) {
                            cVar3 = v;
                            return new ReadCacheRespMsg(this.f13537e, cVar3);
                        }
                    }
                }
                return new ReadCacheRespMsg(this.f13537e, cVar3);
            } catch (Throwable unused3) {
            }
        } catch (Exception e4) {
            e = e4;
        }
    }
}
