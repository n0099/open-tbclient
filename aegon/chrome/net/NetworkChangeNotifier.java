package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ObserverList;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.NetworkChangeNotifierAutoDetect;
import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class NetworkChangeNotifier {
    public static final /* synthetic */ boolean $assertionsDisabled = !NetworkChangeNotifier.class.desiredAssertionStatus();
    @SuppressLint({"StaticFieldLeak"})
    public static NetworkChangeNotifier sInstance;
    public NetworkChangeNotifierAutoDetect mAutoDetector;
    public int mCurrentConnectionType = 0;
    public final ArrayList<Long> mNativeChangeNotifiers = new ArrayList<>();
    public final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers = new ObserverList<>();
    public final ConnectivityManager mConnectivityManager = (ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity");

    /* renamed from: aegon.chrome.net.NetworkChangeNotifier$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements NetworkChangeNotifierAutoDetect.Observer {
        public AnonymousClass1() {
        }

        public void onConnectionTypeChanged(int i) {
            NetworkChangeNotifier.access$000(NetworkChangeNotifier.this, i);
        }

        public void purgeActiveNetworkList(long[] jArr) {
            NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(jArr);
        }
    }

    /* loaded from: classes3.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i);
    }

    public static /* synthetic */ void access$000(NetworkChangeNotifier networkChangeNotifier, int i) {
        networkChangeNotifier.mCurrentConnectionType = i;
        networkChangeNotifier.notifyObserversOfConnectionTypeChange(i);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(i);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(i, j);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long j, int i) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(j, i);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(j);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(j);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] jArr) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(jArr);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = getInstance();
        if ((networkChangeNotifier.mCurrentConnectionType != 6) != z) {
            networkChangeNotifier.updateCurrentConnectionType(z ? 0 : 6);
            networkChangeNotifier.notifyObserversOfConnectionSubtypeChange(!z);
        }
    }

    public static NetworkChangeNotifier getInstance() {
        if ($assertionsDisabled || sInstance != null) {
            return sInstance;
        }
        throw new AssertionError();
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (sInstance == null) {
            sInstance = new NetworkChangeNotifier();
        }
        return sInstance;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return getInstance().isProcessBoundToNetworkInternal();
    }

    private native void nativeNotifyConnectionTypeChanged(long j, int i, long j2);

    private native void nativeNotifyMaxBandwidthChanged(long j, int i);

    private native void nativeNotifyOfNetworkConnect(long j, long j2, int i);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, long j2);

    private native void nativeNotifyPurgeActiveNetworkList(long j, long[] jArr);

    public static void setAutoDetectConnectivityState(boolean z) {
        getInstance().setAutoDetectConnectivityStateInternal(z, new RegistrationPolicyApplicationStatus());
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        this.mNativeChangeNotifiers.add(Long.valueOf(j));
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        try {
            if (this.mAutoDetector == null) {
                return 0;
            }
            return this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
        } catch (Throwable th) {
            return 0;
        }
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return -1L;
        }
        return networkChangeNotifierAutoDetect.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        return networkChangeNotifierAutoDetect == null ? new long[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
    }

    public final boolean isProcessBoundToNetworkInternal() {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return false;
        }
        return i < 23 ? ConnectivityManager.getProcessDefaultNetwork() != null : this.mConnectivityManager.getBoundNetworkForProcess() != null;
    }

    public void notifyObserversOfConnectionSubtypeChange(int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyMaxBandwidthChanged(it.next().longValue(), i);
        }
    }

    public void notifyObserversOfConnectionTypeChange(int i) {
        notifyObserversOfConnectionTypeChange(i, getCurrentDefaultNetId());
    }

    public final void notifyObserversOfConnectionTypeChange(int i, long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue(), i, j);
        }
        Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
        while (it2.hasNext()) {
            it2.next().onConnectionTypeChanged(i);
        }
    }

    public void notifyObserversOfNetworkConnect(long j, int i) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), j, i);
        }
    }

    public void notifyObserversOfNetworkDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), j);
        }
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long j) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), j);
        }
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] jArr) {
        Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
        while (it.hasNext()) {
            nativeNotifyPurgeActiveNetworkList(it.next().longValue(), jArr);
        }
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect == null) {
            return false;
        }
        return networkChangeNotifierAutoDetect.mRegisterNetworkCallbackFailed;
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(j));
    }

    public final void setAutoDetectConnectivityStateInternal(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        if (z) {
            if (this.mAutoDetector == null) {
                this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(), registrationPolicy);
                NetworkChangeNotifierAutoDetect.NetworkState currentNetworkState = this.mAutoDetector.getCurrentNetworkState();
                updateCurrentConnectionType(currentNetworkState.getConnectionType());
                notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
                return;
            }
            return;
        }
        NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
        if (networkChangeNotifierAutoDetect != null) {
            networkChangeNotifierAutoDetect.assertOnThread();
            networkChangeNotifierAutoDetect.mRegistrationPolicy.destroy();
            networkChangeNotifierAutoDetect.unregister();
            this.mAutoDetector = null;
        }
    }

    public final void updateCurrentConnectionType(int i) {
        this.mCurrentConnectionType = i;
        notifyObserversOfConnectionTypeChange(i);
    }
}
