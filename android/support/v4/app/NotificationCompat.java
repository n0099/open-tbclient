package android.support.v4.app;

import android.os.Build;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NotificationCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final am f273a;

    /* loaded from: classes.dex */
    public class BigPictureStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class BigTextStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class InboxStyle extends ar {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<CharSequence> f274a = new ArrayList<>();
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f273a = new aq();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f273a = new ap();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f273a = new ao();
        } else {
            f273a = new an();
        }
    }
}
