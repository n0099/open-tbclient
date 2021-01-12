package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ApkAssets {
    @CalledByNative
    public static long[] open(String str) {
        long[] jArr;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                assetFileDescriptor = ContextUtils.sApplicationContext.getAssets().openNonAssetFd(str);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            jArr = new long[]{assetFileDescriptor.getParcelFileDescriptor().detachFd(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength()};
            try {
                assetFileDescriptor.close();
            } catch (IOException e2) {
                android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e2);
            }
        } catch (IOException e3) {
            e = e3;
            if (!e.getMessage().equals("") && !e.getMessage().equals(str)) {
                android.util.Log.e("ApkAssets", "Error while loading asset " + str + ": " + e);
            }
            jArr = new long[]{-1, -1, -1};
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e4) {
                    android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e4);
                }
            }
            return jArr;
        } catch (Throwable th2) {
            th = th2;
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e5) {
                    android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e5);
                }
            }
            throw th;
        }
        return jArr;
    }
}
