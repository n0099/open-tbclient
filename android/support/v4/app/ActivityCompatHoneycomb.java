package android.support.v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
class ActivityCompatHoneycomb {
    ActivityCompatHoneycomb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }

    static void dump(Activity activity, String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        activity.dump(prefix, fd, writer, args);
    }
}
