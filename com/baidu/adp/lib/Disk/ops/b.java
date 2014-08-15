package com.baidu.adp.lib.Disk.ops;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends c {
    private Rect j;

    public Rect v() {
        return this.j;
    }

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.j = null;
        this.j = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.Disk.ops.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.i.a(bArr)) {
            if (this.i.b == 0 || this.i.b >= System.currentTimeMillis()) {
                if (this.h == null) {
                    this.h = new BitmapFactory.Options();
                    this.h.inDither = false;
                    int i = BdBaseApplication.getInst().getResources().getDisplayMetrics().densityDpi;
                    this.h.inScreenDensity = i;
                    this.h.inTargetDensity = i;
                    this.h.inDensity = i;
                }
                int a = d.a();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr, a, bArr.length - a);
                    try {
                        try {
                            this.g = BitmapFactory.decodeStream(byteArrayInputStream, this.j, this.h);
                            com.baidu.adp.lib.e.a.a((InputStream) byteArrayInputStream);
                        } catch (Error e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.e.a.a((InputStream) byteArrayInputStream);
                            if (this.g == null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.e.a.a((InputStream) byteArrayInputStream);
                        throw th;
                    }
                } catch (Error e2) {
                    e = e2;
                    byteArrayInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = null;
                    com.baidu.adp.lib.e.a.a((InputStream) byteArrayInputStream);
                    throw th;
                }
                return this.g == null;
            }
            return false;
        }
        return false;
    }
}
