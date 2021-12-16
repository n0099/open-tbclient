package c.a.r0.l0.e;

import c.a.d.f.d.l;
import c.a.d.f.p.q;
import c.a.r0.l0.b.c;
import c.a.r0.l0.b.e;
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
/* loaded from: classes6.dex */
public class c<T extends c.a.r0.l0.b.c> extends a<T> {
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
        c.a.r0.l0.b.c cVar;
        byte[] bArr;
        c.a.r0.l0.b.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
            return (CustomResponsedMessage) invokeL.objValue;
        }
        c.a.r0.l0.b.c cVar3 = null;
        if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
            return null;
        }
        ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
        c.a.r0.l0.b.c cVar4 = (c.a.r0.l0.b.c) a();
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
                            if (cVar4 instanceof c.a.r0.l0.b.b) {
                                c.a.r0.s.s.a.f();
                                List<l.b<byte[]>> a = q.a(c.a.r0.s.s.a.e(this.f12717f, str));
                                if (a != null) {
                                    arrayList = new ArrayList(a.size());
                                    for (l.b<byte[]> bVar : a) {
                                        if (bVar != null && (bArr = bVar.f2322b) != null && (cVar2 = (c.a.r0.l0.b.c) a()) != null) {
                                            ((c.a.r0.l0.b.b) cVar2).initByByteArray(bArr);
                                            arrayList.add(cVar2);
                                        }
                                    }
                                    cVar3 = arrayList;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.r0.s.s.a.f();
                                List<l.b<String>> b2 = q.b(c.a.r0.s.s.a.h(this.f12717f, str));
                                if (b2 != null) {
                                    arrayList = new ArrayList(b2.size());
                                    for (l.b<String> bVar2 : b2) {
                                        if (bVar2 != null && (str2 = bVar2.f2322b) != null && (cVar = (c.a.r0.l0.b.c) a()) != null) {
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
                            return new ReadCacheRespMsg(this.f12719e, cVar3);
                        } catch (Throwable th) {
                            th = th;
                            cVar3 = cVar4;
                            new ReadCacheRespMsg(this.f12719e, cVar3);
                            throw th;
                        }
                    } else {
                        String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                        String v = readCacheMessage.getRequestData().v();
                        try {
                            if (cVar4 instanceof c.a.r0.l0.b.b) {
                                c.a.r0.s.s.a.f();
                                byte[] bArr2 = c.a.r0.s.s.a.e(v, str).get(cacheKey);
                                if (bArr2 != null) {
                                    ((c.a.r0.l0.b.b) cVar4).initByByteArray(bArr2);
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(cVar4);
                                    v = arrayList2;
                                    cVar3 = v;
                                }
                            } else if (cVar4 instanceof e) {
                                c.a.r0.s.s.a.f();
                                String str3 = c.a.r0.s.s.a.h(v, str).get(cacheKey);
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
                            return new ReadCacheRespMsg(this.f12719e, cVar3);
                        } catch (Throwable th2) {
                            cVar3 = v;
                            th = th2;
                            new ReadCacheRespMsg(this.f12719e, cVar3);
                            throw th;
                        }
                    }
                }
                return new ReadCacheRespMsg(this.f12719e, cVar3);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
