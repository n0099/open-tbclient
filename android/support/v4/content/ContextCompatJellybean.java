package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes2.dex */
class ContextCompatJellybean {
    public static void startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
