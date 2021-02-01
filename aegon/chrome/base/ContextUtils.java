package aegon.chrome.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes3.dex */
public class ContextUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = !ContextUtils.class.desiredAssertionStatus();
    public static Context sApplicationContext;

    /* loaded from: classes3.dex */
    private static class Holder {
        public static SharedPreferences sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ContextUtils.sApplicationContext);
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.sSharedPreferences;
    }

    public static void initApplicationContext(Context context) {
        Context context2;
        if (!$assertionsDisabled && (context2 = sApplicationContext) != null && context2 != context && ((ContextWrapper) context2).getBaseContext() != context) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && context == null) {
            throw new AssertionError();
        }
        if (BuildConfig.DCHECK_IS_ON && (context instanceof Application)) {
            context = new ContextWrapper(context);
        }
        sApplicationContext = context;
    }
}
