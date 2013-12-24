package android.support.v4.app;

import android.os.Build;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NotificationCompat {
    private static final am a;

    /* loaded from: classes.dex */
    public class BigPictureStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class BigTextStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class InboxStyle extends ar {
        ArrayList<CharSequence> a = new ArrayList<>();
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new aq();
        } else if (Build.VERSION.SDK_INT >= 14) {
            a = new ap();
        } else if (Build.VERSION.SDK_INT >= 11) {
            a = new ao();
        } else {
            a = new an();
        }
    }
}
