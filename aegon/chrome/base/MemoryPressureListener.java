package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.base.memory.MemoryPressureCallback;
/* loaded from: classes4.dex */
public class MemoryPressureListener {
    public static final ObserverList<MemoryPressureCallback> sCallbacks = new ObserverList<>();

    @CalledByNative
    public static void addNativeCallback() {
        MemoryPressureCallback memoryPressureCallback;
        memoryPressureCallback = MemoryPressureListener$$Lambda$1.instance;
        sCallbacks.addObserver(memoryPressureCallback);
    }

    public static native void nativeOnMemoryPressure(int i);
}
