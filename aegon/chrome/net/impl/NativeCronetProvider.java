package aegon.chrome.net.impl;

import aegon.chrome.net.CronetProvider;
import android.content.Context;
import java.util.Arrays;
/* loaded from: classes.dex */
public class NativeCronetProvider extends CronetProvider {
    public NativeCronetProvider(Context context) {
        super(context);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof NativeCronetProvider) && this.mContext.equals(((NativeCronetProvider) obj).mContext));
    }

    @Override // aegon.chrome.net.CronetProvider
    public String getName() {
        return "App-Packaged-Cronet-Provider";
    }

    @Override // aegon.chrome.net.CronetProvider
    public String getVersion() {
        return "77.0.3865.0";
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.mContext});
    }

    @Override // aegon.chrome.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }
}
