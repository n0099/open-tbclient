package com.baidu.adp.lib.Disk.ops;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.c;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public class b extends c {
    private Rect kG;

    public Rect cX() {
        return this.kG;
    }

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.kG = null;
        this.kG = new Rect();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0081 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.graphics.BitmapFactory$Options] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    @Override // com.baidu.adp.lib.Disk.ops.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(byte[] bArr) {
        ?? r2;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.kI.l(bArr)) {
            if (this.kI.kM == 0 || this.kI.kM >= System.currentTimeMillis()) {
                if (this.kH == null) {
                    this.kH = new BitmapFactory.Options();
                    this.kH.inDither = false;
                    int i = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                    this.kH.inScreenDensity = i;
                    this.kH.inTargetDensity = i;
                    r2 = this.kH;
                    ((BitmapFactory.Options) r2).inDensity = i;
                }
                int headerSize = c.a.getHeaderSize();
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArr, headerSize, bArr.length - headerSize);
                        try {
                            this.mBitmap = BitmapFactory.decodeStream(byteArrayInputStream, this.kG, this.kH);
                            com.baidu.adp.lib.h.a.j(byteArrayInputStream);
                            r2 = byteArrayInputStream;
                        } catch (Error e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.h.a.j(byteArrayInputStream);
                            r2 = byteArrayInputStream;
                            if (this.mBitmap == null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.h.a.j(r2);
                        throw th;
                    }
                } catch (Error e2) {
                    e = e2;
                    byteArrayInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                    com.baidu.adp.lib.h.a.j(r2);
                    throw th;
                }
                return this.mBitmap == null;
            }
            return false;
        }
        return false;
    }
}
