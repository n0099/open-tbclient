package aegon.chrome.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes.dex */
public class ContextUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Context sApplicationContext;

    /* loaded from: classes.dex */
    public static class Holder {
        public static SharedPreferences sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ContextUtils.sApplicationContext);
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.sSharedPreferences;
    }

    public static void initApplicationContext(Context context) {
        if (BuildConfig.DCHECK_IS_ON && (context instanceof Application)) {
            context = new ContextWrapper(context);
        }
        sApplicationContext = context;
    }
}
