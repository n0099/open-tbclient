package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ObserverList;
import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.net.NetworkChangeNotifierAutoDetect;
import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class NetworkChangeNotifier {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static NetworkChangeNotifier sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkChangeNotifierAutoDetect mAutoDetector;
    public final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers;
    public final ConnectivityManager mConnectivityManager;
    public int mCurrentConnectionType;
    public final ArrayList<Long> mNativeChangeNotifiers;

    /* renamed from: aegon.chrome.net.NetworkChangeNotifier$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements NetworkChangeNotifierAutoDetect.Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkChangeNotifier this$0;

        public AnonymousClass1(NetworkChangeNotifier networkChangeNotifier) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {networkChangeNotifier};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = networkChangeNotifier;
        }

        public void onConnectionTypeChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                NetworkChangeNotifier.access$000(this.this$0, i2);
            }
        }

        public void purgeActiveNetworkList(long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jArr) == null) {
                this.this$0.notifyObserversToPurgeActiveNetworkList(jArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1179336635, "Laegon/chrome/net/NetworkChangeNotifier;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1179336635, "Laegon/chrome/net/NetworkChangeNotifier;");
        }
    }

    public NetworkChangeNotifier() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentConnectionType = 0;
        this.mNativeChangeNotifiers = new ArrayList<>();
        this.mConnectionTypeObservers = new ObserverList<>();
        this.mConnectivityManager = (ConnectivityManager) ContextUtils.sApplicationContext.getSystemService("connectivity");
    }

    public static /* synthetic */ void access$000(NetworkChangeNotifier networkChangeNotifier, int i2) {
        networkChangeNotifier.mCurrentConnectionType = i2;
        networkChangeNotifier.notifyObserversOfConnectionTypeChange(i2);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversOfConnectionSubtypeChange(i2);
        }
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversOfConnectionTypeChange(i2, j);
        }
    }

    @CalledByNative
    public static void fakeNetworkConnected(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversOfNetworkConnect(j, i2);
        }
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversOfNetworkDisconnect(j);
        }
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversOfNetworkSoonToDisconnect(j);
        }
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, jArr) == null) {
            setAutoDetectConnectivityState(false);
            getInstance().notifyObserversToPurgeActiveNetworkList(jArr);
        }
    }

    @CalledByNative
    public static void forceConnectivityState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            setAutoDetectConnectivityState(false);
            NetworkChangeNotifier networkChangeNotifier = getInstance();
            if ((networkChangeNotifier.mCurrentConnectionType != 6) != z) {
                networkChangeNotifier.updateCurrentConnectionType(z ? 0 : 6);
                networkChangeNotifier.notifyObserversOfConnectionSubtypeChange(!z);
            }
        }
    }

    public static NetworkChangeNotifier getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? sInstance : (NetworkChangeNotifier) invokeV.objValue;
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sInstance == null) {
                sInstance = new NetworkChangeNotifier();
            }
            return sInstance;
        }
        return (NetworkChangeNotifier) invokeV.objValue;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? getInstance().isProcessBoundToNetworkInternal() : invokeV.booleanValue;
    }

    private native void nativeNotifyConnectionTypeChanged(long j, int i2, long j2);

    private native void nativeNotifyMaxBandwidthChanged(long j, int i2);

    private native void nativeNotifyOfNetworkConnect(long j, long j2, int i2);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkSoonToDisconnect(long j, long j2);

    private native void nativeNotifyPurgeActiveNetworkList(long j, long[] jArr);

    public static void setAutoDetectConnectivityState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            getInstance().setAutoDetectConnectivityStateInternal(z, new RegistrationPolicyApplicationStatus());
        }
    }

    @CalledByNative
    public void addNativeObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.mNativeChangeNotifiers.add(Long.valueOf(j));
        }
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.mAutoDetector == null) {
                    return 0;
                }
                return this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentConnectionType : invokeV.intValue;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
            if (networkChangeNotifierAutoDetect == null) {
                return -1L;
            }
            return networkChangeNotifierAutoDetect.getDefaultNetId();
        }
        return invokeV.longValue;
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
            return networkChangeNotifierAutoDetect == null ? new long[0] : networkChangeNotifierAutoDetect.getNetworksAndTypes();
        }
        return (long[]) invokeV.objValue;
    }

    public final boolean isProcessBoundToNetworkInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return false;
            }
            return i2 < 23 ? ConnectivityManager.getProcessDefaultNetwork() != null : this.mConnectivityManager.getBoundNetworkForProcess() != null;
        }
        return invokeV.booleanValue;
    }

    public void notifyObserversOfConnectionSubtypeChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyMaxBandwidthChanged(it.next().longValue(), i2);
            }
        }
    }

    public void notifyObserversOfConnectionTypeChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            notifyObserversOfConnectionTypeChange(i2, getCurrentDefaultNetId());
        }
    }

    public final void notifyObserversOfConnectionTypeChange(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyConnectionTypeChanged(it.next().longValue(), i2, j);
            }
            Iterator<ConnectionTypeObserver> it2 = this.mConnectionTypeObservers.iterator();
            while (it2.hasNext()) {
                it2.next().onConnectionTypeChanged(i2);
            }
        }
    }

    public void notifyObserversOfNetworkConnect(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkConnect(it.next().longValue(), j, i2);
            }
        }
    }

    public void notifyObserversOfNetworkDisconnect(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkDisconnect(it.next().longValue(), j);
            }
        }
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkSoonToDisconnect(it.next().longValue(), j);
            }
        }
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jArr) == null) {
            Iterator<Long> it = this.mNativeChangeNotifiers.iterator();
            while (it.hasNext()) {
                nativeNotifyPurgeActiveNetworkList(it.next().longValue(), jArr);
            }
        }
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
            if (networkChangeNotifierAutoDetect == null) {
                return false;
            }
            return networkChangeNotifierAutoDetect.mRegisterNetworkCallbackFailed;
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public void removeNativeObserver(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mNativeChangeNotifiers.remove(Long.valueOf(j));
        }
    }

    public final void setAutoDetectConnectivityStateInternal(boolean z, NetworkChangeNotifierAutoDetect.RegistrationPolicy registrationPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048591, this, z, registrationPolicy) == null) {
            if (z) {
                if (this.mAutoDetector == null) {
                    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), registrationPolicy);
                    this.mAutoDetector = networkChangeNotifierAutoDetect;
                    NetworkChangeNotifierAutoDetect.NetworkState currentNetworkState = networkChangeNotifierAutoDetect.getCurrentNetworkState();
                    updateCurrentConnectionType(currentNetworkState.getConnectionType());
                    notifyObserversOfConnectionSubtypeChange(currentNetworkState.getConnectionSubtype());
                    return;
                }
                return;
            }
            NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect2 = this.mAutoDetector;
            if (networkChangeNotifierAutoDetect2 != null) {
                networkChangeNotifierAutoDetect2.assertOnThread();
                networkChangeNotifierAutoDetect2.mRegistrationPolicy.destroy();
                networkChangeNotifierAutoDetect2.unregister();
                this.mAutoDetector = null;
            }
        }
    }

    public final void updateCurrentConnectionType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mCurrentConnectionType = i2;
            notifyObserversOfConnectionTypeChange(i2);
        }
    }
}
