package com.baidu.adp.lib.Disk.ops;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.c;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends c {
    private Rect mRect;

    public Rect getRect() {
        return this.mRect;
    }

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mRect = null;
        this.mRect = new Rect();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0081 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.graphics.BitmapFactory$Options] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // com.baidu.adp.lib.Disk.ops.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.ws.j(bArr)) {
            long j = this.ws.wv;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            long j2 = j;
            if (i != 0) {
                long j3 = this.ws.wv;
                int i2 = (j3 > System.currentTimeMillis() ? 1 : (j3 == System.currentTimeMillis() ? 0 : -1));
                j2 = j3;
                if (i2 < 0) {
                    return false;
                }
            }
            ByteArrayInputStream byteArrayInputStream2 = j2;
            if (this.wr == null) {
                this.wr = new BitmapFactory.Options();
                this.wr.inDither = false;
                int i3 = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                this.wr.inScreenDensity = i3;
                this.wr.inTargetDensity = i3;
                ?? r2 = this.wr;
                ((BitmapFactory.Options) r2).inDensity = i3;
                byteArrayInputStream2 = r2;
            }
            int headerSize = c.a.getHeaderSize();
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr, headerSize, bArr.length - headerSize);
                    try {
                        this.mBitmap = BitmapFactory.decodeStream(byteArrayInputStream, this.mRect, this.wr);
                        com.baidu.adp.lib.g.a.f(byteArrayInputStream);
                        byteArrayInputStream2 = byteArrayInputStream;
                    } catch (Error e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.f(byteArrayInputStream);
                        byteArrayInputStream2 = byteArrayInputStream;
                        if (this.mBitmap == null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.g.a.f((InputStream) byteArrayInputStream2);
                    throw th;
                }
            } catch (Error e2) {
                e = e2;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream2 = 0;
                com.baidu.adp.lib.g.a.f((InputStream) byteArrayInputStream2);
                throw th;
            }
            return this.mBitmap == null;
        }
        return false;
    }
}
