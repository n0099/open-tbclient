package com.baidu.searchbox.network.outback.statistics;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public final class DoRecordManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static int DEFAULT_INITIAL_CAPACITY = 50;
    public static int FAILED_MSG = 101;
    public static int SUCCESSFUL_MSG = 100;
    public static final String TAG = "DoRecordManager";
    public static DoRecordManager sDoRecordManager;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile List<RecordObserver> mSynchronizedList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1170770465, "Lcom/baidu/searchbox/network/outback/statistics/DoRecordManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1170770465, "Lcom/baidu/searchbox/network/outback/statistics/DoRecordManager;");
        }
    }

    public DoRecordManager() {
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
        this.mSynchronizedList = Collections.synchronizedList(new ArrayList(DEFAULT_INITIAL_CAPACITY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcast(int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, networkStatRecord) == null) {
            synchronized (this.mSynchronizedList) {
                for (RecordObserver recordObserver : this.mSynchronizedList) {
                    recordObserver.doRecord(networkStatRecord, i2);
                }
            }
        }
    }

    private void doAdditionalRecord(NetworkStatRecord networkStatRecord) {
        IAdditionalRecord additionalRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, networkStatRecord) == null) || networkStatRecord == null || (additionalRecord = OutbackComponent.getInstance().getAdditionalRecord()) == null) {
            return;
        }
        networkStatRecord.processName = additionalRecord.getProcessName();
        networkStatRecord.appLaunchTimestamp = additionalRecord.getAppLaunchTimeStamp();
        networkStatRecord.clientIPv6 = additionalRecord.getClientIPV6();
        networkStatRecord.httpDnsAreaInfo = additionalRecord.getHttpDnsAreaInfo();
        networkStatRecord.httpDnsAreaInfoLastUpdateTime = additionalRecord.getHttpDnsAreaInfoLastUpdateTime();
        networkStatRecord.ipStack = additionalRecord.getIpStack();
        networkStatRecord.networkQuality = additionalRecord.getNetworkQuality();
    }

    public static DoRecordManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sDoRecordManager == null) {
                synchronized (DoRecordManager.class) {
                    if (sDoRecordManager == null) {
                        sDoRecordManager = new DoRecordManager();
                    }
                }
            }
            return sDoRecordManager;
        }
        return (DoRecordManager) invokeV.objValue;
    }

    private List<String> parseRawAddressArray(InetAddress[] inetAddressArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, inetAddressArr)) == null) {
            if (inetAddressArr == null || inetAddressArr.length <= 0) {
                return null;
            }
            List<InetAddress> asList = Arrays.asList(inetAddressArr);
            ArrayList arrayList = new ArrayList(asList.size());
            for (InetAddress inetAddress : asList) {
                arrayList.add(inetAddress.getHostAddress());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecordLocalDnsList(NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, networkStatRecord) == null) || networkStatRecord == null) {
            return;
        }
        try {
            URL url = new URL(networkStatRecord.url);
            if (TextUtils.isEmpty(url.getHost())) {
                return;
            }
            networkStatRecord.localDnsIpList = parseRawAddressArray(InetAddress.getAllByName(url.getHost()));
        } catch (IllegalArgumentException | NullPointerException | SecurityException | MalformedURLException | UnknownHostException unused) {
        }
    }

    public void attach(RecordObserver recordObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recordObserver) == null) {
            this.mSynchronizedList.add(recordObserver);
        }
    }

    public void detach(RecordObserver recordObserver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recordObserver) == null) || this.mSynchronizedList.isEmpty()) {
            return;
        }
        this.mSynchronizedList.remove(recordObserver);
    }

    public void doRecord(NetworkStatRecord networkStatRecord, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord, i2) == null) || networkStatRecord == null) {
            return;
        }
        doAdditionalRecord(networkStatRecord);
        ExecutorUtilsExt.postOnSerial(new Runnable(this, networkStatRecord, i2) { // from class: com.baidu.searchbox.network.outback.statistics.DoRecordManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DoRecordManager this$0;
            public final /* synthetic */ NetworkStatRecord val$record;
            public final /* synthetic */ int val$type;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, networkStatRecord, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$record = networkStatRecord;
                this.val$type = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (TextUtils.isEmpty(this.val$record.clientIP)) {
                        this.val$record.clientIP = ConnectManager.getClientIP();
                    }
                    this.this$0.setRecordLocalDnsList(this.val$record);
                    this.this$0.broadcast(this.val$type, this.val$record);
                }
            }
        }, "OutbackParseLocalDnsDoRecord");
    }
}
