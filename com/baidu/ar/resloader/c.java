package com.baidu.ar.resloader;

import android.content.Context;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.resloader.d;
import com.baidu.ar.util.ARSDKInfo;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.ZipUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class c extends Thread {
    private String a;
    private d.a b;
    private e c;
    private final File d;
    private volatile boolean e = false;

    public c(Context context, String str, d.a aVar, e eVar) {
        this.d = d.a(context);
        this.a = str;
        this.b = aVar;
        this.c = eVar;
    }

    private void a(final boolean z, final f fVar) {
        if (z) {
            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_LOAD_SUCCESS);
        } else {
            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_LOAD_FAILURE);
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.resloader.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    c.this.c.b(String.valueOf(ARSDKInfo.getVersionCode()));
                    c.this.c.a(fVar.a);
                }
                if (c.this.b() || c.this.b == null) {
                    return;
                }
                c.this.b.a(z);
            }
        });
    }

    private boolean a(String str, File file) {
        com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_START_DOWNLOAD);
        return HttpUtils.downloadFile(str, file, new IoUtils.Operation() { // from class: com.baidu.ar.resloader.c.1
            @Override // com.baidu.ar.util.IoUtils.Cancelable
            public boolean isCancelled() {
                return c.this.b();
            }

            @Override // com.baidu.ar.util.IoUtils.ProgressListener
            public void progress(long j, long j2) {
            }
        });
    }

    public void a() {
        this.e = true;
        this.b = null;
    }

    public boolean b() {
        return this.e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        f fVar = new f();
        fVar.b = this.a;
        fVar.a = d.b(this.a);
        String str = fVar.b;
        File file = new File(this.d, fVar.a);
        File file2 = new File(file, "res.zip");
        FileUtils.ensureParent(file2);
        boolean a = a(str, file2);
        if (b()) {
            FileUtils.deleteDir(file);
            return;
        }
        if (a) {
            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_DOWNLOAD_SUCCESS);
        } else {
            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_DOWNLOAD_FAILURE);
        }
        if (a && ZipUtils.unzip(file2, file) && d.a(new File(file, "res"))) {
            a(true, fVar);
        } else {
            a(false, (f) null);
        }
    }
}
