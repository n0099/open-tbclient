package aegon.chrome.base;
/* loaded from: classes.dex */
public interface Callback<T> {

    /* loaded from: classes.dex */
    public static abstract class Helper {
        public static void onBooleanResultFromNative(Callback callback, boolean z) {
            callback.onResult(Boolean.valueOf(z));
        }

        public static void onIntResultFromNative(Callback callback, int i2) {
            callback.onResult(Integer.valueOf(i2));
        }

        public static void onObjectResultFromNative(Callback callback, Object obj) {
            callback.onResult(obj);
        }

        public static void runRunnable(Runnable runnable) {
            runnable.run();
        }
    }

    void onResult(T t);
}
