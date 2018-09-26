package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.voice.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.a.i;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c implements e<a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean jq() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: d */
    public a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.D(false);
        diskFileOperate.E(false);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(diskFileOperate);
            aVar.CI = eVar;
        }
        diskFileOperate.hm();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String hD = diskFileOperate.hD();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = hD;
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: d */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        int i3;
        String str3 = null;
        if (objArr.length == 1) {
            str3 = String.valueOf(objArr[0]);
        }
        a aVar2 = new a();
        i iVar = new i();
        if (aVar != null) {
            aVar.CI = iVar;
        }
        String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
        byte[] fq = iVar.fq(!TextUtils.isEmpty(str3) ? str4 + "&play_from=" + str3 : str4);
        if (!iVar.AX()) {
            aVar2.error_code = 3;
            aVar2.error_msg = h.getString(e.j.neterror);
            return aVar2;
        } else if (fq == null || fq.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = h.getString(e.j.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (fq == null || fq.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.D(false);
                diskFileOperate.setData(fq);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
                    eVar.f(diskFileOperate);
                    aVar.CI = eVar;
                }
                diskFileOperate.hm();
                if (diskFileOperate.isSuccess() && diskFileOperate.hz() != null) {
                    str5 = diskFileOperate.hz().getAbsolutePath();
                    i3 = 0;
                } else if (l.zr() < fq.length) {
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
                aVar2.error_msg = a.eb(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jr() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int js() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: d */
    public a a(String str, String str2, int i, int i2, Object... objArr) {
        return null;
    }
}
