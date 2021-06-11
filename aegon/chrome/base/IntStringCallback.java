package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public interface IntStringCallback {
    @CalledByNative
    void onResult(int i2, String str);
}
