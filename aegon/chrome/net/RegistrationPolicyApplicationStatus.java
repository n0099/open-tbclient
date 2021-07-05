package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.net.NetworkChangeNotifierAutoDetect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mDestroyed;

    public RegistrationPolicyApplicationStatus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mDestroyed) {
            return;
        }
        ApplicationStatus.sApplicationStateListeners.removeObserver(this);
        this.mDestroyed = true;
    }

    @Override // aegon.chrome.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkChangeNotifierAutoDetect) == null) {
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
}
