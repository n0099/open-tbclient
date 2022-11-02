package com.baidu.searchbox.bddownload;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.dispatcher.DownloadDispatcher;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.searchbox.bddownload.core.file.DownloadOutputStream;
import com.baidu.searchbox.bddownload.core.file.DownloadUriOutputStream;
import com.baidu.searchbox.bddownload.core.file.ProcessFileStrategy;
import com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdDownload {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile BdDownload singleton;
    public transient /* synthetic */ FieldHolder $fh;
    public final BreakpointStore breakpointStore;
    public final CallbackDispatcher callbackDispatcher;
    public final DownloadConnection.Factory connectionFactory;
    public final Context context;
    public final DownloadDispatcher downloadDispatcher;
    public final DownloadStrategy downloadStrategy;
    @Nullable
    public DownloadMonitor monitor;
    public final DownloadOutputStream.Factory outputStreamFactory;
    public final ProcessFileStrategy processFileStrategy;
    @Nullable
    public IBDDownloadStatistic statistic;

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IBDDownloadStatistic bdDownloadStatistic;
        public CallbackDispatcher callbackDispatcher;
        public DownloadConnection.Factory connectionFactory;
        public final Context context;
        public DownloadDispatcher downloadDispatcher;
        public DownloadStore downloadStore;
        public DownloadStrategy downloadStrategy;
        public DownloadMonitor monitor;
        public DownloadOutputStream.Factory outputStreamFactory;
        public ProcessFileStrategy processFileStrategy;

        public Builder(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context.getApplicationContext();
        }

        public Builder bdDownloadStatistic(IBDDownloadStatistic iBDDownloadStatistic) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iBDDownloadStatistic)) == null) {
                this.bdDownloadStatistic = iBDDownloadStatistic;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder callbackDispatcher(CallbackDispatcher callbackDispatcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callbackDispatcher)) == null) {
                this.callbackDispatcher = callbackDispatcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder connectionFactory(DownloadConnection.Factory factory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, factory)) == null) {
                this.connectionFactory = factory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder downloadDispatcher(DownloadDispatcher downloadDispatcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadDispatcher)) == null) {
                this.downloadDispatcher = downloadDispatcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder downloadStore(DownloadStore downloadStore) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadStore)) == null) {
                this.downloadStore = downloadStore;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder downloadStrategy(DownloadStrategy downloadStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, downloadStrategy)) == null) {
                this.downloadStrategy = downloadStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder monitor(DownloadMonitor downloadMonitor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, downloadMonitor)) == null) {
                this.monitor = downloadMonitor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder outputStreamFactory(DownloadOutputStream.Factory factory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, factory)) == null) {
                this.outputStreamFactory = factory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder processFileStrategy(ProcessFileStrategy processFileStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, processFileStrategy)) == null) {
                this.processFileStrategy = processFileStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public BdDownload build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.downloadDispatcher == null) {
                    this.downloadDispatcher = new DownloadDispatcher();
                }
                if (this.callbackDispatcher == null) {
                    this.callbackDispatcher = new CallbackDispatcher();
                }
                if (this.downloadStore == null) {
                    this.downloadStore = Util.createDefaultDatabase(this.context);
                }
                if (this.connectionFactory == null) {
                    this.connectionFactory = Util.createHttpManagerConnectionFactory();
                }
                if (this.outputStreamFactory == null) {
                    this.outputStreamFactory = new DownloadUriOutputStream.Factory();
                }
                if (this.processFileStrategy == null) {
                    this.processFileStrategy = new ProcessFileStrategy();
                }
                if (this.downloadStrategy == null) {
                    this.downloadStrategy = new DownloadStrategy();
                }
                BdDownload bdDownload = new BdDownload(this.context, this.downloadDispatcher, this.callbackDispatcher, this.downloadStore, this.connectionFactory, this.outputStreamFactory, this.processFileStrategy, this.downloadStrategy);
                bdDownload.setMonitor(this.monitor);
                bdDownload.setBDDownloadStatistic(this.bdDownloadStatistic);
                Util.d("BdDownload", "downloadStore[" + this.downloadStore + "] connectionFactory[" + this.connectionFactory);
                return bdDownload;
            }
            return (BdDownload) invokeV.objValue;
        }
    }

    public BdDownload(Context context, DownloadDispatcher downloadDispatcher, CallbackDispatcher callbackDispatcher, DownloadStore downloadStore, DownloadConnection.Factory factory, DownloadOutputStream.Factory factory2, ProcessFileStrategy processFileStrategy, DownloadStrategy downloadStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, downloadDispatcher, callbackDispatcher, downloadStore, factory, factory2, processFileStrategy, downloadStrategy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
        this.downloadDispatcher = downloadDispatcher;
        this.callbackDispatcher = callbackDispatcher;
        this.breakpointStore = downloadStore;
        this.connectionFactory = factory;
        this.outputStreamFactory = factory2;
        this.processFileStrategy = processFileStrategy;
        this.downloadStrategy = downloadStrategy;
        downloadDispatcher.setDownloadStore(Util.createRemitDatabase(downloadStore));
    }

    public static void setSingletonInstance(@NonNull BdDownload bdDownload) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bdDownload) == null) {
            if (singleton == null) {
                synchronized (BdDownload.class) {
                    if (singleton == null) {
                        singleton = bdDownload;
                    } else {
                        throw new IllegalArgumentException("BdDownload must be null.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("BdDownload must be null.");
        }
    }

    public static BdDownload with() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (singleton == null) {
                synchronized (BdDownload.class) {
                    if (singleton == null) {
                        Context appContext = AppRuntime.getAppContext();
                        if (appContext != null) {
                            singleton = new Builder(appContext).build();
                        } else {
                            throw new IllegalStateException("context == null");
                        }
                    }
                }
            }
            return singleton;
        }
        return (BdDownload) invokeV.objValue;
    }

    public BreakpointStore breakpointStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.breakpointStore;
        }
        return (BreakpointStore) invokeV.objValue;
    }

    public CallbackDispatcher callbackDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.callbackDispatcher;
        }
        return (CallbackDispatcher) invokeV.objValue;
    }

    public DownloadConnection.Factory connectionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.connectionFactory;
        }
        return (DownloadConnection.Factory) invokeV.objValue;
    }

    public Context context() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.context;
        }
        return (Context) invokeV.objValue;
    }

    public DownloadDispatcher downloadDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.downloadDispatcher;
        }
        return (DownloadDispatcher) invokeV.objValue;
    }

    public DownloadStrategy downloadStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.downloadStrategy;
        }
        return (DownloadStrategy) invokeV.objValue;
    }

    @Nullable
    public DownloadMonitor getMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.monitor;
        }
        return (DownloadMonitor) invokeV.objValue;
    }

    public IBDDownloadStatistic getStatistic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.statistic;
        }
        return (IBDDownloadStatistic) invokeV.objValue;
    }

    public DownloadOutputStream.Factory outputStreamFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.outputStreamFactory;
        }
        return (DownloadOutputStream.Factory) invokeV.objValue;
    }

    public ProcessFileStrategy processFileStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.processFileStrategy;
        }
        return (ProcessFileStrategy) invokeV.objValue;
    }

    public void setBDDownloadStatistic(@Nullable IBDDownloadStatistic iBDDownloadStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iBDDownloadStatistic) == null) {
            this.statistic = iBDDownloadStatistic;
        }
    }

    public void setMonitor(@Nullable DownloadMonitor downloadMonitor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadMonitor) == null) {
            this.monitor = downloadMonitor;
        }
    }
}
