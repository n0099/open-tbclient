package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
/* loaded from: classes.dex */
public class ApkAssets {
    @CalledByNative
    public static long[] open(String str) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                assetFileDescriptor = ContextUtils.sApplicationContext.getAssets().openNonAssetFd(str);
                long[] jArr = {assetFileDescriptor.getParcelFileDescriptor().detachFd(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength()};
                try {
                    assetFileDescriptor.close();
                } catch (IOException e2) {
                    android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e2);
                }
                return jArr;
            } catch (IOException e3) {
                if (!e3.getMessage().equals("") && !e3.getMessage().equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error while loading asset ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(e3);
                    android.util.Log.e("ApkAssets", sb.toString());
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e4) {
                        android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e4);
                    }
                }
                return jArr2;
            }
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e5) {
                    android.util.Log.e("ApkAssets", "Unable to close AssetFileDescriptor", e5);
                }
            }
            throw th;
        }
    }
}
