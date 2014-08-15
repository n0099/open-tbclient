package com.baidu.tbadk.core.voice.a;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.resourceLoader.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.k;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.voice.ae;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c implements h<a> {
    @Override // com.baidu.adp.lib.resourceLoader.h
    public boolean a() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public a a(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.b(false);
        diskFileOperate.d(false);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
            bVar.a(diskFileOperate);
            aVar.a = bVar;
        }
        diskFileOperate.p();
        if (!diskFileOperate.g()) {
            return null;
        }
        String s = diskFileOperate.s();
        a aVar2 = new a();
        aVar2.a = str;
        aVar2.b = s;
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        String str3;
        int i3;
        String str4 = null;
        if (objArr.length == 1) {
            str4 = String.valueOf(objArr[0]);
        }
        a aVar2 = new a();
        k kVar = new k();
        if (aVar != null) {
            aVar.a = kVar;
        }
        byte[] a = kVar.a(!TextUtils.isEmpty(str4) ? String.valueOf(str3) + "&play_from=" + str4 : String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.VOICE_DATA + "?voice_md5=" + str);
        if (!kVar.b()) {
            aVar2.c = 3;
            aVar2.d = ae.a(x.neterror);
            return aVar2;
        } else if (a == null || a.length == 0) {
            aVar2.c = 4;
            aVar2.d = ae.a(x.voice_cache_error_no_file);
            return aVar2;
        } else {
            String str5 = null;
            if (str == null) {
                i3 = 5;
            } else if (a == null || a.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.b(false);
                diskFileOperate.a(a);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
                    bVar.a(diskFileOperate);
                    aVar.a = bVar;
                }
                diskFileOperate.p();
                if (diskFileOperate.g() && diskFileOperate.n() != null) {
                    str5 = diskFileOperate.n().getAbsolutePath();
                    i3 = 0;
                } else if (s.e() < a.length) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            }
            if (i3 == 0) {
                aVar2.b = str5;
                aVar2.a = str;
            } else {
                aVar2.c = i3;
                aVar2.d = a.a(i3);
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public void a(String str, Object obj, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public BdAsyncTaskParallel b() {
        return null;
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public int c() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public a a(String str, String str2, Object... objArr) {
        return null;
    }
}
