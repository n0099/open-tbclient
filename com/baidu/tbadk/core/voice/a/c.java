package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.voice.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.k;
import com.baidu.tbadk.core.util.resourceLoaderProc.d;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class c implements g<a> {
    @Override // com.baidu.adp.lib.f.g
    public boolean eh() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: c */
    public a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.k(false);
        diskFileOperate.l(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(diskFileOperate);
            aVar.lb = dVar;
        }
        diskFileOperate.bp();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String bH = diskFileOperate.bH();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = bH;
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
        k kVar = new k();
        if (aVar != null) {
            aVar.lb = kVar;
        }
        byte[] bY = kVar.bY(!TextUtils.isEmpty(str4) ? String.valueOf(str3) + "&play_from=" + str4 : String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str);
        if (!kVar.ni()) {
            aVar2.error_code = 3;
            aVar2.error_msg = q.getString(y.neterror);
            return aVar2;
        } else if (bY == null || bY.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = q.getString(y.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (bY == null || bY.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.k(false);
                diskFileOperate.setData(bY);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(diskFileOperate);
                    aVar.lb = dVar;
                }
                diskFileOperate.bp();
                if (diskFileOperate.isSuccess() && diskFileOperate.bD() != null) {
                    str5 = diskFileOperate.bD().getAbsolutePath();
                    i3 = 0;
                } else if (s.lx() < bY.length) {
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
                aVar2.error_msg = a.bQ(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int ej() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: c */
    public a a(String str, String str2, Object... objArr) {
        return null;
    }
}
