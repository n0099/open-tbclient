package com.baidu.searchbox.block.impl;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
import com.repackage.ik9;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
@Singleton
@Service
/* loaded from: classes2.dex */
public class BlockMonitor implements IBlockMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BLOCK_TIMEOUT = 2000;
    public static final String SEPARATOR = "\r\n";
    public static final String TAG = "Ruka";
    public static final SimpleDateFormat TIME_FORMATTER;
    public static String sBlockTimeStamp;
    public transient /* synthetic */ FieldHolder $fh;
    public ik9 mBlockWatchDog;
    public boolean mMonitorStarted;

    /* renamed from: com.baidu.searchbox.block.impl.BlockMonitor$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class BlockListenerImpl implements ik9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BlockListenerImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ik9.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                Log.d(BlockMonitor.TAG, "BlockWatchDog catch block", aNRError);
                BlockMonitor.collectData(aNRError.getSTStackMap());
            }
        }

        public /* synthetic */ BlockListenerImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1148068283, "Lcom/baidu/searchbox/block/impl/BlockMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1148068283, "Lcom/baidu/searchbox/block/impl/BlockMonitor;");
                return;
            }
        }
        TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    }

    public BlockMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMonitorStarted = false;
        this.mBlockWatchDog = null;
    }

    public static void collectData(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, linkedHashMap) == null) || AppRuntime.getAppContext() == null) {
            return;
        }
        sBlockTimeStamp = String.valueOf(System.currentTimeMillis());
        String str = null;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            str = getThreadStackEntries(linkedHashMap);
        }
        if (TextUtils.isEmpty(str)) {
            str = ThreadCollector.getMainThreadStackTrace();
        }
        BlockContext.getBlockContext().onAppBlock(AppRuntime.getAppContext(), new BlockInfo(sBlockTimeStamp, str));
    }

    public static String getThreadStackEntries(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedHashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Long l : linkedHashMap.keySet()) {
                sb.append(TIME_FORMATTER.format(l));
                sb.append("\r\n");
                sb.append(stack2String(linkedHashMap.get(l)));
                sb.append("\r\n");
                sb.append("\r\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String stack2String(StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, stackTraceElementArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (stackTraceElementArr != null) {
                try {
                    if (stackTraceElementArr.length >= 1) {
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            sb.append(stackTraceElement.toString() + "\r\n");
                        }
                    }
                } catch (Exception e) {
                    Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public boolean enableMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BlockRuntime.getInstance().enableBlock() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public void startBlockMonitor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.mMonitorStarted) {
            return;
        }
        this.mMonitorStarted = true;
        ik9 ik9Var = new ik9(i);
        this.mBlockWatchDog = ik9Var;
        ik9Var.e();
        this.mBlockWatchDog.d(true);
        this.mBlockWatchDog.c(new BlockListenerImpl(null));
        if (AppConfig.isDebug()) {
            Log.d(TAG, "start mBlockWatchDog = " + this.mBlockWatchDog.getName() + " Monitor");
        }
        this.mBlockWatchDog.start();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public void stopBlockMonitor() {
        ik9 ik9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mMonitorStarted && (ik9Var = this.mBlockWatchDog) != null) {
            ik9Var.interrupt();
            this.mMonitorStarted = false;
        }
    }
}
