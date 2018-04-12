package android.support.v4.app;

import android.app.Notification;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.GROUP_ID})
/* loaded from: classes2.dex */
public interface NotificationBuilderWithBuilderAccessor {
    Notification build();

    Notification.Builder getBuilder();
}
