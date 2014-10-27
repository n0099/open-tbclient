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
    private Rect dZ;

    public Rect bL() {
        return this.dZ;
    }

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.dZ = null;
        this.dZ = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.Disk.ops.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.eb.j(bArr)) {
            if (this.eb.ef == 0 || this.eb.ef >= System.currentTimeMillis()) {
                if (this.ea == null) {
                    this.ea = new BitmapFactory.Options();
                    this.ea.inDither = false;
                    int i = BdBaseApplication.getInst().getResources().getDisplayMetrics().densityDpi;
                    this.ea.inScreenDensity = i;
                    this.ea.inTargetDensity = i;
                    this.ea.inDensity = i;
                }
                int bP = d.bP();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr, bP, bArr.length - bP);
                    try {
                        try {
                            this.mBitmap = BitmapFactory.decodeStream(byteArrayInputStream, this.dZ, this.ea);
                            com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
                        } catch (Error e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
                            if (this.mBitmap == null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
                        throw th;
                    }
                } catch (Error e2) {
                    e = e2;
                    byteArrayInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = null;
                    com.baidu.adp.lib.g.a.a((InputStream) byteArrayInputStream);
                    throw th;
                }
                return this.mBitmap == null;
            }
            return false;
        }
        return false;
    }
}
