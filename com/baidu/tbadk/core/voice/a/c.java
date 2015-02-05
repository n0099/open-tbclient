package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.voice.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.i;
import com.baidu.tbadk.core.util.resourceLoaderProc.d;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class c implements g<a> {
    @Override // com.baidu.adp.lib.f.g
    public boolean ef() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: c */
    public a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.o(false);
        diskFileOperate.p(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(diskFileOperate);
            aVar.lf = dVar;
        }
        diskFileOperate.bO();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String cg = diskFileOperate.cg();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = cg;
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        int i3;
        String str4 = null;
        if (objArr.length == 1) {
            str4 = String.valueOf(objArr[0]);
        }
        a aVar2 = new a();
        i iVar = new i();
        if (aVar != null) {
            aVar.lf = iVar;
        }
        byte[] cM = iVar.cM(!TextUtils.isEmpty(str4) ? String.valueOf(str3) + "&play_from=" + str4 : String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str);
        if (!iVar.qg()) {
            aVar2.error_code = 3;
            aVar2.error_msg = q.getString(z.neterror);
            return aVar2;
        } else if (cM == null || cM.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = q.getString(z.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (cM == null || cM.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.o(false);
                diskFileOperate.setData(cM);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(diskFileOperate);
                    aVar.lf = dVar;
                }
                diskFileOperate.bO();
                if (diskFileOperate.isSuccess() && diskFileOperate.cc() != null) {
                    str5 = diskFileOperate.cc().getAbsolutePath();
                    i3 = 0;
                } else if (s.oo() < cM.length) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            }
            if (i3 == 0) {
                aVar2.path = str5;
                aVar2.md5 = str;
            } else {
                aVar2.error_code = i3;
                aVar2.error_msg = a.cv(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int eh() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: g */
    public a c(String str, String str2, Object... objArr) {
        return null;
    }
}
