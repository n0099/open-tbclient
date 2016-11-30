package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.voice.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.a.k;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.resourceLoaderProc.d;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c implements e<a> {
    @Override // com.baidu.adp.lib.g.e
    public boolean eD() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: c */
    public a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.r(false);
        diskFileOperate.s(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(diskFileOperate);
            aVar.oV = dVar;
        }
        diskFileOperate.cC();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String cT = diskFileOperate.cT();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = cT;
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        String str3;
        int i3;
        String str4 = null;
        if (objArr.length == 1) {
            str4 = String.valueOf(objArr[0]);
        }
        a aVar2 = new a();
        k kVar = new k();
        if (aVar != null) {
            aVar.oV = kVar;
        }
        byte[] dT = kVar.dT(!TextUtils.isEmpty(str4) ? String.valueOf(str3) + "&play_from=" + str4 : String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str);
        if (!kVar.wa()) {
            aVar2.error_code = 3;
            aVar2.error_msg = l.getString(r.j.neterror);
            return aVar2;
        } else if (dT == null || dT.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = l.getString(r.j.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (dT == null || dT.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.r(false);
                diskFileOperate.setData(dT);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(diskFileOperate);
                    aVar.oV = dVar;
                }
                diskFileOperate.cC();
                if (diskFileOperate.isSuccess() && diskFileOperate.cQ() != null) {
                    str5 = diskFileOperate.cQ().getAbsolutePath();
                    i3 = 0;
                } else if (m.uw() < dT.length) {
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
                aVar2.error_msg = a.dw(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public int eF() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: e */
    public a b(String str, String str2, Object... objArr) {
        return null;
    }
}
