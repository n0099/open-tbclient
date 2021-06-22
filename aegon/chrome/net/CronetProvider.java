package aegon.chrome.net;

import android.content.Context;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes.dex */
public abstract class CronetProvider {
    public final Context mContext;

    public CronetProvider(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.mContext = context;
    }

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + PreferencesUtil.RIGHT_MOUNT;
    }
}
