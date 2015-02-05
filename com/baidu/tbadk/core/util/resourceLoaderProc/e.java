package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.editortool.ae;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    private final String Lh = "_gif";

    @Override // com.baidu.adp.lib.f.g
    public boolean ef() {
        return com.baidu.tbadk.core.l.lV().lZ();
    }

    private String m(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.vY().ek(m(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        Bitmap b;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<ae> vp = ab.vn().vp();
        if (valueOf3.booleanValue()) {
            String p = ab.vn().p(valueOf2, true);
            Iterator<ae> it = vp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                ae next = it.next();
                if (next.dR(valueOf2)) {
                    if (next.vg()) {
                        aVar2 = next.dT(valueOf2);
                    } else {
                        aVar2 = a(next.getGroupId(), p, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, p, aVar);
            }
        } else {
            String p2 = ab.vn().p(valueOf2, false);
            Iterator<ae> it2 = vp.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                ae next2 = it2.next();
                if (next2.dR(valueOf2)) {
                    if (next2.vg()) {
                        aVar3 = next2.dS(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), p2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, p2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.httpNet.i iVar;
        byte[] l;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (l = (iVar = new com.baidu.tbadk.core.util.httpNet.i()).l(valueOf4, false)) == null || !iVar.qg()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.d.vv) {
            String p = ab.vn().p(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, p, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.o(false);
                aVar3.setData(l);
                com.baidu.adp.lib.Disk.d.bM().b(aVar3);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(aVar3);
                    aVar.lf = dVar;
                }
                Iterator<ae> it = ab.vn().vp().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    ae next = it.next();
                    if (next.dR(valueOf2)) {
                        aVar2 = a(next.getGroupId(), p, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, p, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                com.baidu.tbadk.imageManager.e.vY().dx(80000);
                Bitmap v = com.baidu.tbadk.core.util.d.v(l);
                if (v == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(v, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, p, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(false);
                cVar.setData(l);
                cVar.r(valueOf3.booleanValue());
                com.baidu.adp.lib.Disk.d.bM().c(cVar);
                if (aVar != null) {
                    d dVar2 = new d();
                    dVar2.g(cVar);
                    aVar.lf = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.vY().c(m(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        String str3 = ".emotions/";
        if (str != null) {
            str3 = String.valueOf(".emotions/") + str + "/";
        }
        if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
            Bitmap b = b(str, str2, aVar);
            if (b == null) {
                return null;
            }
            return new com.baidu.adp.widget.a.a(b, false, str2);
        }
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(str3, str2, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.o(false);
        aVar2.p(false);
        aVar2.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(aVar2);
            aVar.lf = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.bM().c(aVar2)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (com.baidu.adp.lib.util.i.fg()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (aVar2.isSuccess()) {
                aVar2.j(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.cj());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oVar.o(false);
        oVar.p(false);
        oVar.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(oVar);
            aVar.lf = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.bM().c(oVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (com.baidu.adp.lib.util.i.fg()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (oVar.isSuccess()) {
                oVar.j(oVar.getData());
                bitmap = oVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int eh() {
        return 1;
    }
}
