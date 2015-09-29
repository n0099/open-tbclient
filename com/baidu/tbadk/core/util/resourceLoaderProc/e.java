package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.emotiontool.r;
import com.baidu.tbadk.editortools.emotiontool.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean hd() {
        return com.baidu.tbadk.core.m.qX().rb();
    }

    private String m(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.Cf().fo(m(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
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
        ArrayList<t> Be = r.Bc().Be();
        if (valueOf3.booleanValue()) {
            String s = r.Bc().s(valueOf2, true);
            Iterator<t> it = Be.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                t next = it.next();
                if (next.eP(valueOf2)) {
                    if (next.Ba()) {
                        aVar2 = next.eR(valueOf2);
                    } else {
                        aVar2 = a(next.getGroupId(), s, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, s, aVar);
            }
        } else {
            String s2 = r.Bc().s(valueOf2, false);
            Iterator<t> it2 = Be.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                t next2 = it2.next();
                if (next2.eP(valueOf2)) {
                    if (next2.Ba()) {
                        aVar3 = next2.eQ(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), s2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, s2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] l;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (l = (iVar = new com.baidu.tbadk.core.util.a.i()).l(valueOf4, false)) == null || !iVar.vi()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.c.Gl) {
            String s = r.Bc().s(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, s, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.o(false);
                aVar3.setData(l);
                com.baidu.adp.lib.Disk.d.fj().b(aVar3);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(aVar3);
                    aVar.vs = dVar;
                }
                Iterator<t> it = r.Bc().Be().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    t next = it.next();
                    if (next.eP(valueOf2)) {
                        aVar2 = a(next.getGroupId(), s, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, s, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                com.baidu.tbadk.imageManager.c.Cf().en(80000);
                Bitmap N = com.baidu.tbadk.core.util.c.N(l);
                if (N == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(N, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, s, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(false);
                cVar.setData(l);
                cVar.r(valueOf3.booleanValue());
                com.baidu.adp.lib.Disk.d.fj().c(cVar);
                if (aVar != null) {
                    d dVar2 = new d();
                    dVar2.f(cVar);
                    aVar.vs = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Cf().c(m(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
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
        aVar2.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(aVar2);
            aVar.vs = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.fj().c(aVar2)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.iN()) {
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
                aVar2.x(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.fE());
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
        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        kVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        kVar.o(false);
        kVar.p(false);
        kVar.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(kVar);
            aVar.vs = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.fj().c(kVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.iN()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (kVar.isSuccess()) {
                kVar.x(kVar.getData());
                bitmap = kVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel he() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int hf() {
        return 1;
    }
}
