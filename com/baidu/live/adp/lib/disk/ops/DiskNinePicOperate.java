package com.baidu.live.adp.lib.disk.ops;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import com.baidu.live.adp.lib.disk.ops.DiskPicOperate;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class DiskNinePicOperate extends DiskPicOperate {
    private Rect mRect;

    public Rect getRect() {
        return this.mRect;
    }

    public DiskNinePicOperate(String str, String str2, DiskFileOperate.Action action) {
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
    @Override // com.baidu.live.adp.lib.disk.ops.DiskPicOperate, com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.mDiskPicHeader.paserFromByte(bArr)) {
            long j = this.mDiskPicHeader.mValidTime;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            long j2 = j;
            if (i != 0) {
                long j3 = this.mDiskPicHeader.mValidTime;
                int i2 = (j3 > System.currentTimeMillis() ? 1 : (j3 == System.currentTimeMillis() ? 0 : -1));
                j2 = j3;
                if (i2 < 0) {
                    return false;
                }
            }
            ByteArrayInputStream byteArrayInputStream2 = j2;
            if (this.mOptions == null) {
                this.mOptions = new BitmapFactory.Options();
                this.mOptions.inDither = false;
                int i3 = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                this.mOptions.inScreenDensity = i3;
                this.mOptions.inTargetDensity = i3;
                ?? r2 = this.mOptions;
                ((BitmapFactory.Options) r2).inDensity = i3;
                byteArrayInputStream2 = r2;
            }
            int headerSize = DiskPicOperate.DiskPicHeader.getHeaderSize();
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr, headerSize, bArr.length - headerSize);
                    try {
                        this.mBitmap = BitmapFactory.decodeStream(byteArrayInputStream, this.mRect, this.mOptions);
                        BdCloseHelper.close((InputStream) byteArrayInputStream);
                        byteArrayInputStream2 = byteArrayInputStream;
                    } catch (Error e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        BdCloseHelper.close((InputStream) byteArrayInputStream);
                        byteArrayInputStream2 = byteArrayInputStream;
                        if (this.mBitmap == null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    BdCloseHelper.close((InputStream) byteArrayInputStream2);
                    throw th;
                }
            } catch (Error e2) {
                e = e2;
                byteArrayInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream2 = 0;
                BdCloseHelper.close((InputStream) byteArrayInputStream2);
                throw th;
            }
            return this.mBitmap == null;
        }
        return false;
    }
}
