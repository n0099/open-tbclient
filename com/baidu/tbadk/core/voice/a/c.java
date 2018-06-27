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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c implements e<a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean ij() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: d */
    public a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.w(false);
        diskFileOperate.x(false);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(diskFileOperate);
            aVar.As = eVar;
        }
        diskFileOperate.gg();
        if (!diskFileOperate.isSuccess()) {
            return null;
        }
        String gx = diskFileOperate.gx();
        a aVar2 = new a();
        aVar2.md5 = str;
        aVar2.path = gx;
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
            aVar.As = iVar;
        }
        String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
        byte[] fa = iVar.fa(!TextUtils.isEmpty(str3) ? str4 + "&play_from=" + str3 : str4);
        if (!iVar.Af()) {
            aVar2.error_code = 3;
            aVar2.error_msg = h.getString(d.k.neterror);
            return aVar2;
        } else if (fa == null || fa.length == 0) {
            aVar2.error_code = 4;
            aVar2.error_msg = h.getString(d.k.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (fa == null || fa.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.w(false);
                diskFileOperate.setData(fa);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
                    eVar.f(diskFileOperate);
                    aVar.As = eVar;
                }
                diskFileOperate.gg();
                if (diskFileOperate.isSuccess() && diskFileOperate.gt() != null) {
                    str5 = diskFileOperate.gt().getAbsolutePath();
                    i3 = 0;
                } else if (l.yu() < fa.length) {
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
                aVar2.error_msg = a.dN(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int il() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: j */
    public a f(String str, String str2, Object... objArr) {
        return null;
    }
}
