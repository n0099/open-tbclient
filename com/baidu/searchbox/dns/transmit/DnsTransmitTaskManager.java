package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class DnsTransmitTaskManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile DnsTransmitTaskManager taskManager;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object taskLock;
    public HashMap<String, DnsTransmitTask> taskMap;

    /* renamed from: com.baidu.searchbox.dns.transmit.DnsTransmitTaskManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static DnsTransmitTaskManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1983124679, "Lcom/baidu/searchbox/dns/transmit/DnsTransmitTaskManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1983124679, "Lcom/baidu/searchbox/dns/transmit/DnsTransmitTaskManager$Holder;");
                    return;
                }
            }
            INSTANCE = new DnsTransmitTaskManager(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public DnsTransmitTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskLock = new Object();
        this.taskMap = new HashMap<>(10);
    }

    public static DnsTransmitTaskManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Holder.INSTANCE;
        }
        return (DnsTransmitTaskManager) invokeV.objValue;
    }

    public /* synthetic */ DnsTransmitTaskManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void addTask(String str, DnsTransmitTask dnsTransmitTask) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, dnsTransmitTask) == null) && !TextUtils.isEmpty(str) && dnsTransmitTask != null) {
            synchronized (this.taskLock) {
                this.taskMap.put(str, dnsTransmitTask);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " add dns transmit task: " + str);
            }
        }
    }

    public DnsTransmitTask getTask(String str, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!TextUtils.isEmpty(str)) {
                synchronized (this.taskLock) {
                    if (this.taskMap.get(str) == null) {
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, " creat dns transmit task isBatch: " + z + " host: " + str);
                        }
                        return new DnsTransmitTask(z, str, i);
                    }
                    return null;
                }
            }
            return null;
        }
        return (DnsTransmitTask) invokeCommon.objValue;
    }

    public void removeTask(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(str)) {
            synchronized (this.taskLock) {
                this.taskMap.remove(str);
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " remove dns transmit task: " + str);
            }
        }
    }
}
