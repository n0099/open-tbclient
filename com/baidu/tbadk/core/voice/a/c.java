package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.voice.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.h;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.resourceLoaderProc.d;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class c implements g<a> {
    @Override // com.baidu.adp.lib.f.g
    public boolean hE() {
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
            aVar.wt = dVar;
        }
        diskFileOperate.fm();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String fE = diskFileOperate.fE();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = fE;
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
        h hVar = new h();
        if (aVar != null) {
            aVar.wt = hVar;
        }
        byte[] cV = hVar.cV(!TextUtils.isEmpty(str4) ? String.valueOf(str3) + "&play_from=" + str4 : String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str);
        if (!hVar.tw()) {
            aVar2.error_code = 3;
            aVar2.error_msg = l.getString(y.neterror);
            return aVar2;
        } else if (cV == null || cV.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = l.getString(y.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (cV == null || cV.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.o(false);
                diskFileOperate.setData(cV);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(diskFileOperate);
                    aVar.wt = dVar;
                }
                diskFileOperate.fm();
                if (diskFileOperate.isSuccess() && diskFileOperate.fA() != null) {
                    str5 = diskFileOperate.fA().getAbsolutePath();
                    i3 = 0;
                } else if (o.rL() < cV.length) {
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
    public BdAsyncTaskParallel hF() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int hG() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: g */
    public a c(String str, String str2, Object... objArr) {
        return null;
    }
}
