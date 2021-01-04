package aegon.chrome.base.metrics;
/* loaded from: classes5.dex */
public class RecordUserAction {

    /* loaded from: classes5.dex */
    public interface UserActionCallback {
        void onActionRecorded(String str);
    }

    static {
        RecordUserAction.class.desiredAssertionStatus();
    }

    public static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    public static native void nativeRecordUserAction(String str);

    public static native void nativeRemoveActionCallbackForTesting(long j);
}
