package android.webkit;
/* loaded from: classes.dex */
public class ConsoleMessage {
    private MessageLevel mLevel;
    private int mLineNumber;
    private String mMessage;
    private String mSourceId;

    /* loaded from: classes.dex */
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static MessageLevel[] valuesCustom() {
            MessageLevel[] valuesCustom = values();
            int length = valuesCustom.length;
            MessageLevel[] messageLevelArr = new MessageLevel[length];
            System.arraycopy(valuesCustom, 0, messageLevelArr, 0, length);
            return messageLevelArr;
        }
    }

    public ConsoleMessage(String str, String str2, int i, MessageLevel messageLevel) {
        this.mMessage = str;
        this.mSourceId = str2;
        this.mLineNumber = i;
        this.mLevel = messageLevel;
    }

    public MessageLevel messageLevel() {
        return this.mLevel;
    }

    public String message() {
        return this.mMessage;
    }

    public String sourceId() {
        return this.mSourceId;
    }

    public int lineNumber() {
        return this.mLineNumber;
    }
}
