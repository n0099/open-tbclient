package com.baidu.nps.main.manager;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IAlertManager;
import com.baidu.nps.interfa.IPackageChangeNotifier;
import com.baidu.nps.interfa.IPackageGetter;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.ISignatureVerifier;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.interfa.IThreadManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Configurations {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IAlertManager alertManager;
    public boolean debug;
    public IPackageChangeNotifier packageChangeNotifier;
    public IPackageGetter packageGetter;
    public IResourcesFetcher resourcesFetcher;
    public ISignatureVerifier signatureVerifier;
    public IStatisticManager statisticManager;
    public IThreadManager threadManager;
    public IWebViewDataDirectoryManager webViewDataDirectoryManager;

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IAlertManager alertManager;
        public boolean debug;
        public IPackageChangeNotifier packageChangeNotifier;
        public IPackageGetter packageGetter;
        public IResourcesFetcher resourcesFetcher;
        public ISignatureVerifier signatureVerifier;
        public IStatisticManager statisticManager;
        public IThreadManager threadManager;
        public IWebViewDataDirectoryManager webViewDataDirectoryManager;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.alertManager = null;
            this.packageChangeNotifier = null;
            this.packageGetter = null;
            this.signatureVerifier = null;
            this.statisticManager = null;
            this.threadManager = null;
            this.resourcesFetcher = null;
            this.webViewDataDirectoryManager = null;
        }

        public Builder alertManager(IAlertManager iAlertManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iAlertManager)) == null) {
                this.alertManager = iAlertManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Configurations build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Configurations(this.alertManager, this.packageChangeNotifier, this.packageGetter, this.signatureVerifier, this.statisticManager, this.threadManager, this.resourcesFetcher, this.webViewDataDirectoryManager, this.debug) : (Configurations) invokeV.objValue;
        }

        public Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.debug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder packageChangeNotifier(IPackageChangeNotifier iPackageChangeNotifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iPackageChangeNotifier)) == null) {
                this.packageChangeNotifier = iPackageChangeNotifier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder packageGetter(IPackageGetter iPackageGetter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iPackageGetter)) == null) {
                this.packageGetter = iPackageGetter;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder resourcesFetcher(IResourcesFetcher iResourcesFetcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iResourcesFetcher)) == null) {
                this.resourcesFetcher = iResourcesFetcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder signatureVerifier(ISignatureVerifier iSignatureVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iSignatureVerifier)) == null) {
                this.signatureVerifier = iSignatureVerifier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder statisticManager(IStatisticManager iStatisticManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iStatisticManager)) == null) {
                this.statisticManager = iStatisticManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder threadManager(IThreadManager iThreadManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iThreadManager)) == null) {
                this.threadManager = iThreadManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder webViewDataDirectoryManager(IWebViewDataDirectoryManager iWebViewDataDirectoryManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iWebViewDataDirectoryManager)) == null) {
                this.webViewDataDirectoryManager = iWebViewDataDirectoryManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public Configurations(IAlertManager iAlertManager, IPackageChangeNotifier iPackageChangeNotifier, IPackageGetter iPackageGetter, ISignatureVerifier iSignatureVerifier, IStatisticManager iStatisticManager, IThreadManager iThreadManager, IResourcesFetcher iResourcesFetcher, IWebViewDataDirectoryManager iWebViewDataDirectoryManager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAlertManager, iPackageChangeNotifier, iPackageGetter, iSignatureVerifier, iStatisticManager, iThreadManager, iResourcesFetcher, iWebViewDataDirectoryManager, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.alertManager = iAlertManager;
        this.packageChangeNotifier = iPackageChangeNotifier;
        this.packageGetter = iPackageGetter;
        this.signatureVerifier = iSignatureVerifier;
        this.statisticManager = iStatisticManager;
        this.threadManager = iThreadManager;
        this.resourcesFetcher = iResourcesFetcher;
        this.webViewDataDirectoryManager = iWebViewDataDirectoryManager;
        this.debug = z;
    }
}
