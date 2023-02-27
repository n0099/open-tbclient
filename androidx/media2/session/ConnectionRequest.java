package androidx.media2.session;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.VersionedParcelable;
/* loaded from: classes.dex */
public class ConnectionRequest implements VersionedParcelable {
    public Bundle mConnectionHints;
    public String mPackageName;
    public int mPid;
    public int mVersion;

    public ConnectionRequest() {
    }

    public Bundle getConnectionHints() {
        return this.mConnectionHints;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public ConnectionRequest(String str, int i, @Nullable Bundle bundle) {
        this.mVersion = 0;
        this.mPackageName = str;
        this.mPid = i;
        this.mConnectionHints = bundle;
    }
}
