package android.support.v4.app;

import android.os.Build;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NotificationCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final am f283a;

    /* loaded from: classes.dex */
    public class BigPictureStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class BigTextStyle extends ar {
    }

    /* loaded from: classes.dex */
    public class InboxStyle extends ar {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<CharSequence> f284a = new ArrayList<>();
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f283a = new aq();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f283a = new ap();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f283a = new ao();
        } else {
            f283a = new an();
        }
    }
}
