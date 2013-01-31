package com.baidu.browser.webkit;

import android.webkit.ConsoleMessage;
import com.baidu.zeus.ConsoleMessage;
/* loaded from: classes.dex */
public class BdConsoleMessage {
    private static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$ConsoleMessage$MessageLevel;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$ConsoleMessage$MessageLevel;
    private ConsoleMessage mSysConsoleMessage;
    private com.baidu.zeus.ConsoleMessage mZeusConsoleMessage;

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

    static /* synthetic */ int[] $SWITCH_TABLE$android$webkit$ConsoleMessage$MessageLevel() {
        int[] iArr = $SWITCH_TABLE$android$webkit$ConsoleMessage$MessageLevel;
        if (iArr == null) {
            iArr = new int[ConsoleMessage.MessageLevel.valuesCustom().length];
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$android$webkit$ConsoleMessage$MessageLevel = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$zeus$ConsoleMessage$MessageLevel() {
        int[] iArr = $SWITCH_TABLE$com$baidu$zeus$ConsoleMessage$MessageLevel;
        if (iArr == null) {
            iArr = new int[ConsoleMessage.MessageLevel.values().length];
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            $SWITCH_TABLE$com$baidu$zeus$ConsoleMessage$MessageLevel = iArr;
        }
        return iArr;
    }

    public BdConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        this.mSysConsoleMessage = consoleMessage;
    }

    public BdConsoleMessage(com.baidu.zeus.ConsoleMessage consoleMessage) {
        this.mZeusConsoleMessage = consoleMessage;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdConsoleMessage) && unwrap() == ((BdConsoleMessage) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage.hashCode() : this.mSysConsoleMessage.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage == obj : this.mSysConsoleMessage == obj;
    }

    public Object unwrap() {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage : this.mSysConsoleMessage;
    }

    public MessageLevel messageLevel() {
        if (this.mZeusConsoleMessage != null) {
            switch ($SWITCH_TABLE$com$baidu$zeus$ConsoleMessage$MessageLevel()[this.mZeusConsoleMessage.messageLevel().ordinal()]) {
                case 1:
                    return MessageLevel.TIP;
                case 2:
                    return MessageLevel.LOG;
                case 3:
                    return MessageLevel.WARNING;
                case 4:
                    return MessageLevel.ERROR;
                case 5:
                    return MessageLevel.DEBUG;
                default:
                    return MessageLevel.TIP;
            }
        }
        switch ($SWITCH_TABLE$android$webkit$ConsoleMessage$MessageLevel()[this.mSysConsoleMessage.messageLevel().ordinal()]) {
            case 1:
                return MessageLevel.TIP;
            case 2:
                return MessageLevel.LOG;
            case 3:
                return MessageLevel.WARNING;
            case 4:
                return MessageLevel.ERROR;
            case 5:
                return MessageLevel.DEBUG;
            default:
                return MessageLevel.TIP;
        }
    }

    public String message() {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage.message() : this.mSysConsoleMessage.message();
    }

    public String sourceId() {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage.sourceId() : this.mSysConsoleMessage.sourceId();
    }

    public int lineNumber() {
        return this.mZeusConsoleMessage != null ? this.mZeusConsoleMessage.lineNumber() : this.mSysConsoleMessage.lineNumber();
    }
}
