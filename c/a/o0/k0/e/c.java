package c.a.o0.k0.e;

import c.a.d.f.d.l;
import c.a.d.f.p.s;
import c.a.o0.k0.b.c;
import c.a.o0.k0.b.e;
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
/* loaded from: classes2.dex */
public class c<T extends c.a.o0.k0.b.c> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, String str, Class<T> cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        c.a.o0.k0.b.c cVar;
        byte[] bArr;
        c.a.o0.k0.b.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        c.a.o0.k0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        c.a.o0.k0.b.c cVar4 = (c.a.o0.k0.b.c) a();
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
                            if (cVar4 instanceof c.a.o0.k0.b.b) {
                                c.a.o0.r.s.a.f();
                                List<l.b<byte[]>> a = s.a(c.a.o0.r.s.a.e(this.f10374b, str));
                                if (a != null) {
                                    arrayList = new ArrayList(a.size());
                                    for (l.b<byte[]> bVar : a) {
                                        if (bVar != null && (bArr = bVar.f2089b) != null && (cVar2 = (c.a.o0.k0.b.c) a()) != null) {
                                            ((c.a.o0.k0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.o0.r.s.a.f();
                                List<l.b<String>> b2 = s.b(c.a.o0.r.s.a.h(this.f10374b, str));
                                if (b2 != null) {
                                    arrayList = new ArrayList(b2.size());
                                    for (l.b<String> bVar2 : b2) {
                                        if (bVar2 != null && (str2 = bVar2.f2089b) != null && (cVar = (c.a.o0.k0.b.c) a()) != null) {
                                            ((e) cVar).p(str2);
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
                            return new ReadCacheRespMsg(this.a, cVar3);
                        } catch (Throwable th) {
                            th = th;
                            cVar3 = cVar4;
                            new ReadCacheRespMsg(this.a, cVar3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String x = readCacheMessage.getRequestData().x();
                        try {
                            if (cVar4 instanceof c.a.o0.k0.b.b) {
                                c.a.o0.r.s.a.f();
                                byte[] bArr2 = c.a.o0.r.s.a.e(x, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((c.a.o0.k0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    x = arrayList2;
                                    cVar3 = x;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.o0.r.s.a.f();
                                String str3 = c.a.o0.r.s.a.h(x, str).get(cacheKey);
                                if (str3 != null) {
                                    ((e) cVar4).p(str3);
                                    ?? arrayList3 = new ArrayList();
                                    arrayList3.add(cVar4);
                                    x = arrayList3;
                                    cVar3 = x;
                                }
                            }
                        } catch (Exception e3) {
                            cVar3 = x;
                            e = e3;
                            e.printStackTrace();
                            return new ReadCacheRespMsg(this.a, cVar3);
                        } catch (Throwable th2) {
                            cVar3 = x;
                            th = th2;
                            new ReadCacheRespMsg(this.a, cVar3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.a, cVar3);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
