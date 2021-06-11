package aegon.chrome.base;

import aegon.chrome.base.memory.MemoryPressureCallback;
/* loaded from: classes.dex */
public final /* synthetic */ class MemoryPressureListener$$Lambda$1 implements MemoryPressureCallback {
    public static final MemoryPressureListener$$Lambda$1 instance = new MemoryPressureListener$$Lambda$1();

    public void onPressure(int i2) {
        MemoryPressureListener.nativeOnMemoryPressure(i2);
    }
}
