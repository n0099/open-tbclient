package aegon.chrome.base;

import aegon.chrome.base.memory.MemoryPressureCallback;
/* loaded from: classes5.dex */
final /* synthetic */ class MemoryPressureListener$$Lambda$1 implements MemoryPressureCallback {
    private static final MemoryPressureListener$$Lambda$1 instance = new MemoryPressureListener$$Lambda$1();

    private MemoryPressureListener$$Lambda$1() {
    }

    public void onPressure(int i) {
        MemoryPressureListener.nativeOnMemoryPressure(i);
    }
}
