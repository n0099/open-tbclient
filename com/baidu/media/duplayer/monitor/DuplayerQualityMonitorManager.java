package com.baidu.media.duplayer.monitor;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes5.dex */
public class DuplayerQualityMonitorManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static DuplayerQualityMonitorManager f42697c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f42698d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f42699a;

    /* renamed from: b  reason: collision with root package name */
    public int f42700b;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42702f;

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42701e = str;
            this.f42702f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DuplayerQualityMonitorManager.getInstance().e(this.f42701e, this.f42702f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-565484812, "Lcom/baidu/media/duplayer/monitor/DuplayerQualityMonitorManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-565484812, "Lcom/baidu/media/duplayer/monitor/DuplayerQualityMonitorManager;");
                return;
            }
        }
        f42698d = new int[]{480, RecordConstants.DEFAULT_PREVIEW_WIDTH, 720, 1080};
    }

    public DuplayerQualityMonitorManager() {
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
        this.f42699a = new ConcurrentHashMap<>();
        this.f42700b = 100;
    }

    public static synchronized DuplayerQualityMonitorManager getInstance() {
        InterceptResult invokeV;
        DuplayerQualityMonitorManager duplayerQualityMonitorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (DuplayerQualityMonitorManager.class) {
                if (f42697c == null) {
                    f42697c = new DuplayerQualityMonitorManager();
                }
                duplayerQualityMonitorManager = f42697c;
            }
            return duplayerQualityMonitorManager;
        }
        return (DuplayerQualityMonitorManager) invokeV.objValue;
    }

    private native int nativeGetPlayQualityScore(String str, int i2, int i3, int i4);

    private native int nativeInit(String str, boolean z);

    @Keep
    public static void updateMonitorData(int i2, String str, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 == 1000) {
            new Handler(Looper.getMainLooper()).post(new a(str, i3));
        }
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0 || i2 == 2 || i2 == 1) {
                return i2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            int min = Math.min(i2, i3);
            if (min <= 0) {
                return RecordConstants.DEFAULT_PREVIEW_WIDTH;
            }
            for (int length = f42698d.length - 1; length >= 0; length--) {
                int[] iArr = f42698d;
                if (min >= iArr[length]) {
                    return iArr[length];
                }
            }
            return f42698d[0];
        }
        return invokeII.intValue;
    }

    public final String c(String str, int i2, int i3, int i4, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                str = "video/hevc";
            }
            sb.append(str);
            sb.append("_");
            sb.append(a(i2));
            sb.append("_");
            sb.append(b(i3, i4));
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public final void e(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            CyberLog.i("DuplayerQualityMonitorManager", "onUpdateMonitorData key:" + str + " score:" + i2);
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.f42699a;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, Integer.valueOf(i2));
            }
        }
    }

    public int getPlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            String c2 = c(str, i2, i3, i4, map);
            Integer num = this.f42699a.get(c2);
            CyberLog.i("DuplayerQualityMonitorManager", "getPlayQualityScore key:" + c2 + " score:" + num);
            return num != null ? num.intValue() : this.f42700b;
        }
        return invokeCommon.intValue;
    }

    public void init(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            this.f42700b = CyberCfgManager.getInstance().getCfgIntValue("default_play_quality_score", 100);
            nativeInit(str, z);
        }
    }
}
