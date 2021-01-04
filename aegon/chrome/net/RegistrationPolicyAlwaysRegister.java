package aegon.chrome.net;

import aegon.chrome.net.NetworkChangeNotifierAutoDetect;
/* loaded from: classes5.dex */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
    }

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        this.mNotifier = networkChangeNotifierAutoDetect;
        register();
    }
}
