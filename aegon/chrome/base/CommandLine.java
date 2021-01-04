package aegon.chrome.base;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public abstract class CommandLine {
    public static final /* synthetic */ boolean $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
    public static final AtomicReference<CommandLine> sCommandLine = new AtomicReference<>();

    public static CommandLine getInstance() {
        CommandLine commandLine = sCommandLine.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    public static native void nativeAppendSwitch(String str);

    public static native void nativeAppendSwitchWithValue(String str, String str2);

    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    public static native String nativeGetSwitchValue(String str);

    public static native boolean nativeHasSwitch(String str);

    public static native void nativeInit(String[] strArr);

    public abstract String getSwitchValue(String str);

    public abstract boolean hasSwitch(String str);
}
