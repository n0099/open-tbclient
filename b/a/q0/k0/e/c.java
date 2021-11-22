package b.a.q0.k0.e;

import b.a.e.f.d.l;
import b.a.e.f.p.p;
import b.a.q0.k0.b.c;
import b.a.q0.k0.b.e;
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
/* loaded from: classes4.dex */
public class c<T extends b.a.q0.k0.b.c> extends a<T> {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x00d6 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v12. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v9. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v36 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        b.a.q0.k0.b.c cVar;
        byte[] bArr;
        b.a.q0.k0.b.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        b.a.q0.k0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        b.a.q0.k0.b.c cVar4 = (b.a.q0.k0.b.c) a();
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
                            if (cVar4 instanceof b.a.q0.k0.b.b) {
                                b.a.q0.s.r.a.f();
                                List<l.b<byte[]>> a2 = p.a(b.a.q0.s.r.a.e(this.f13445f, str));
                                if (a2 != null) {
                                    arrayList = new ArrayList(a2.size());
                                    for (l.b<byte[]> bVar : a2) {
                                        if (bVar != null && (bArr = bVar.f1708b) != null && (cVar2 = (b.a.q0.k0.b.c) a()) != null) {
                                            ((b.a.q0.k0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if (cVar4 instanceof e) {
                                b.a.q0.s.r.a.f();
                                List<l.b<String>> b2 = p.b(b.a.q0.s.r.a.h(this.f13445f, str));
                                if (b2 != null) {
                                    arrayList = new ArrayList(b2.size());
                                    for (l.b<String> bVar2 : b2) {
                                        if (bVar2 != null && (str2 = bVar2.f1708b) != null && (cVar = (b.a.q0.k0.b.c) a()) != null) {
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
                            return new ReadCacheRespMsg(this.f13447e, cVar3);
                        } catch (Throwable th) {
                            th = th;
                            cVar3 = cVar4;
                            new ReadCacheRespMsg(this.f13447e, cVar3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String v = readCacheMessage.getRequestData().v();
                        try {
                            if (cVar4 instanceof b.a.q0.k0.b.b) {
                                b.a.q0.s.r.a.f();
                                byte[] bArr2 = b.a.q0.s.r.a.e(v, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((b.a.q0.k0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    v = arrayList2;
                                    cVar3 = v;
                                }
                            } else if (cVar4 instanceof e) {
                                b.a.q0.s.r.a.f();
                                String str3 = b.a.q0.s.r.a.h(v, str).get(cacheKey);
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
                            return new ReadCacheRespMsg(this.f13447e, cVar3);
                        } catch (Throwable th2) {
                            cVar3 = v;
                            th = th2;
                            new ReadCacheRespMsg(this.f13447e, cVar3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.f13447e, cVar3);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
