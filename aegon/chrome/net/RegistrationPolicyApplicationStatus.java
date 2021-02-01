package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.net.NetworkChangeNotifierAutoDetect;
/* loaded from: classes3.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    public boolean mDestroyed;

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
        if (this.mDestroyed) {
            return;
        }
        ApplicationStatus.sApplicationStateListeners.removeObserver(this);
        this.mDestroyed = true;
    }

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        this.mNotifier = networkChangeNotifierAutoDetect;
        ApplicationStatus.registerApplicationStateListener(this);
        int stateForApplication = ApplicationStatus.getStateForApplication();
        if (stateForApplication == 1) {
            register();
        } else if (stateForApplication == 2) {
            if (!NetworkChangeNotifierAutoDetect.RegistrationPolicy.$assertionsDisabled && this.mNotifier == null) {
                throw new AssertionError();
            }
            this.mNotifier.unregister();
        }
    }
}
