package c.a.r0.t0.c;

import android.graphics.Bitmap;
import c.a.d.f.l.b;
import c.a.d.f.l.e;
import c.a.d.f.p.l;
import c.a.q0.b0.c;
import c.a.q0.w.p.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DiskEmotionOperate;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a implements e<c.a.d.o.d.a> {
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

    public final String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "_gif" : "");
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.f.l.e
    /* renamed from: b */
    public c.a.d.o.d.a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        c.a.d.o.d.a aVar;
        Bitmap f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            c.a.d.o.d.a aVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || valueOf2 == null || valueOf3 == null) {
                return null;
            }
            ArrayList<d> i4 = c.a.r0.t0.d.e.j().i();
            if (c.a.r0.t0.d.e.j().n(valueOf2) && valueOf3.booleanValue() && !new File(c.a.r0.t0.d.e.j().g(valueOf2, true)).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf3.booleanValue();
            if (c.a.r0.t0.d.e.j().m(valueOf2) && valueOf3.booleanValue()) {
                String g2 = c.a.r0.t0.d.e.j().g(valueOf2, true);
                String h2 = c.a.r0.t0.d.e.j().h(valueOf2);
                if (!new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + h2 + "/" + g2).exists()) {
                    valueOf3 = Boolean.FALSE;
                }
                valueOf = h2;
            }
            if (valueOf3.booleanValue()) {
                String g3 = c.a.r0.t0.d.e.j().g(valueOf2, true);
                Iterator<d> it = i4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next.m(valueOf2)) {
                        if (next.j()) {
                            aVar2 = next.n(valueOf2);
                        } else {
                            aVar2 = e(next.f(), g3, bVar);
                        }
                    }
                }
                return (aVar2 != null || valueOf == null) ? aVar2 : e(valueOf, g3, bVar);
            }
            String g4 = c.a.r0.t0.d.e.j().g(valueOf2, false);
            if (booleanValue && c.a.r0.t0.d.e.j().m(valueOf2)) {
                g4 = g4.replaceFirst("s_", "d_");
            }
            Iterator<d> it2 = i4.iterator();
            c.a.d.o.d.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar = aVar3;
                    break;
                }
                d next2 = it2.next();
                if (next2.m(valueOf2)) {
                    if (next2.j()) {
                        aVar3 = next2.o(valueOf2);
                    } else {
                        Bitmap f3 = f(next2.f(), g4, bVar);
                        if (f3 == null) {
                            return null;
                        }
                        aVar = new c.a.d.o.d.a(f3, false, valueOf2);
                    }
                }
            }
            return (aVar != null || valueOf == null || (f2 = f(valueOf, g4, bVar)) == null) ? aVar : new c.a.d.o.d.a(f2, false, valueOf2);
        }
        return (c.a.d.o.d.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.f.l.e
    /* renamed from: c */
    public c.a.d.o.d.a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) ? c.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue())) : (c.a.d.o.d.a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.f.l.e
    /* renamed from: d */
    public c.a.d.o.d.a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        c.a.d.o.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
                String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
                Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
                String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
                if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g2 = c.a.r0.t0.d.e.j().g(valueOf2, valueOf3.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf3.booleanValue()) {
                                c.a.d.f.a.f.a aVar2 = new c.a.d.f.a.f.a(str3, g2, DiskFileOperate.Action.WRITE);
                                aVar2.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                aVar2.setSubFolder(false);
                                aVar2.setSavedCache(false);
                                aVar2.setSdCard(false);
                                aVar2.setData(downloadImageBytes);
                                c.a.d.f.a.d.f().call(aVar2);
                                if (bVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(aVar2);
                                    bVar.a = diskCancelWorker;
                                }
                                Iterator<d> it = c.a.r0.t0.d.e.j().i().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        aVar = null;
                                        break;
                                    }
                                    d next = it.next();
                                    if (next.m(valueOf2)) {
                                        aVar = e(next.f(), g2, bVar);
                                        break;
                                    }
                                }
                                if (aVar == null && valueOf != null) {
                                    aVar = e(valueOf, g2, bVar);
                                }
                                if (aVar == null) {
                                    return null;
                                }
                            } else {
                                c.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i2, i3);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                c.a.d.o.d.a aVar3 = new c.a.d.o.d.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                                aVar3.y(needCache);
                                if (needCache) {
                                    c.a.d.f.a.f.c cVar = new c.a.d.f.a.f.c(str3, g2, DiskFileOperate.Action.WRITE);
                                    cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    cVar.setSubFolder(false);
                                    cVar.setData(downloadImageBytes);
                                    cVar.setSavedCache(false);
                                    cVar.setSdCard(false);
                                    cVar.setGif(valueOf3.booleanValue());
                                    c.a.d.f.a.d.f().a(cVar);
                                    if (bVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(cVar);
                                        bVar.a = diskCancelWorker2;
                                    }
                                }
                                aVar = aVar3;
                            }
                            return aVar;
                        }
                    }
                }
            }
            return null;
        }
        return (c.a.d.o.d.a) invokeCommon.objValue;
    }

    public c.a.d.o.d.a e(String str, String str2, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, bVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f2 = f(str, str2, bVar);
                if (f2 == null) {
                    return null;
                }
                return new c.a.d.o.d.a(f2, false, str2);
            }
            byte[] bArr = new byte[0];
            c.a.d.f.a.f.a aVar = new c.a.d.f.a.f.a(str3, str2, DiskFileOperate.Action.READ);
            aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar.setSubFolder(false);
            aVar.setIsFormatData(false);
            aVar.setSavedCache(false);
            aVar.setSdCard(false);
            aVar.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(aVar);
                bVar.a = diskCancelWorker;
            }
            if (c.a.d.f.a.d.f().a(aVar)) {
                int i2 = l.H() ? 500 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i2);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
                    }
                }
                if (aVar.isSuccess()) {
                    aVar.formatData(aVar.getData());
                    return new c.a.d.o.d.a(aVar.a());
                }
                return null;
            }
            return null;
        }
        return (c.a.d.o.d.a) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, bVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(".emotions/");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            byte[] bArr = new byte[0];
            DiskEmotionOperate diskEmotionOperate = new DiskEmotionOperate(sb.toString(), str2, DiskFileOperate.Action.READ);
            diskEmotionOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskEmotionOperate.setSubFolder(false);
            diskEmotionOperate.setIsFormatData(false);
            diskEmotionOperate.setSavedCache(false);
            diskEmotionOperate.setSdCard(false);
            diskEmotionOperate.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                bVar.a = diskCancelWorker;
            }
            if (c.a.d.f.a.d.f().a(diskEmotionOperate)) {
                int i2 = l.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i2);
                    } catch (InterruptedException e2) {
                        BdLog.detailException(e2);
                    }
                }
                if (diskEmotionOperate.isSuccess()) {
                    diskEmotionOperate.formatData(diskEmotionOperate.getData());
                    return diskEmotionOperate.getBitmap();
                }
                return null;
            }
            return null;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    @Override // c.a.d.f.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // c.a.d.f.l.e
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // c.a.d.f.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.q0.r.l.c().g() : invokeV.booleanValue;
    }

    @Override // c.a.d.f.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && obj != null && (obj instanceof c.a.d.o.d.a)) {
            c.a.d.o.d.a aVar = (c.a.d.o.d.a) obj;
            if (aVar.u()) {
                aVar.A(i2);
                aVar.z(i3);
                c.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), aVar);
            }
        }
    }
}
