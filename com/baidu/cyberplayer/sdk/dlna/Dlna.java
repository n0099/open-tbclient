package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class Dlna {
    public static /* synthetic */ Interceptable $ic = null;
    public static int DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL = -1011;
    public static int DLNA_ERROR_CREATE_SSDP_THREAD_FIAL = -1017;
    public static int DLNA_ERROR_DATA_INVALIDATE = -1015;
    public static int DLNA_ERROR_DEVICE_CONNECT_TIMEOUT = -1002;
    public static int DLNA_ERROR_GET_MEDIA_INFO_ACTION_NOT_FOUND = -1006;
    public static int DLNA_ERROR_GET_MUTE_ACTION_NOT_FOUND = -1008;
    public static int DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND = -1009;
    public static int DLNA_ERROR_GET_TRANSPORT_INFO_ACTION_NOT_FOUND = -1010;
    public static int DLNA_ERROR_NO_DEVICE = -1016;
    public static int DLNA_ERROR_PARSE_FAIL = -1014;
    public static int DLNA_ERROR_PAUSE_ACTION_NOT_FOUND = -1004;
    public static int DLNA_ERROR_PLAY_ACTION_NOT_FOUND = -1001;
    public static int DLNA_ERROR_SEEK_ACTION_NOT_FOUND = -1005;
    public static int DLNA_ERROR_SET_AV_TRANSPORT_URI_ACTION_NOT_FOUND = -1003;
    public static int DLNA_ERROR_SET_MUTE_ACTION_NOT_FOUND = -1007;
    public static int DLNA_ERROR_SET_VOLUME_ACTION_NOT_FOUND = -1013;
    public static int DLNA_ERROR_STOP_ACTION_NOT_FOUND = -1012;
    public static int DLNA_ERROR_STOP_SPCE_INVALIDATE = -1018;
    public static String TAG = "DLNA";
    public transient /* synthetic */ FieldHolder $fh;
    public DlnaProvider a;

    /* renamed from: com.baidu.cyberplayer.sdk.dlna.Dlna$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final Dlna a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-330026553, "Lcom/baidu/cyberplayer/sdk/dlna/Dlna$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-330026553, "Lcom/baidu/cyberplayer/sdk/dlna/Dlna$a;");
                    return;
                }
            }
            a = new Dlna(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1791833380, "Lcom/baidu/cyberplayer/sdk/dlna/Dlna;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1791833380, "Lcom/baidu/cyberplayer/sdk/dlna/Dlna;");
        }
    }

    public Dlna() {
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
        this.a = null;
    }

    public /* synthetic */ Dlna(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Dlna getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (Dlna) invokeV.objValue;
    }

    public synchronized PnPController getCtrlPoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (this.a != null && str != null) {
                    return new PnPController(str, this.a);
                }
                return null;
            }
        }
        return (PnPController) invokeL.objValue;
    }

    public synchronized void refresh(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dlnaSearchListener) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = d.f();
                }
                if (this.a != null) {
                    this.a.stop();
                    if (dlnaSearchListener != null) {
                        this.a.search(dlnaSearchListener);
                    }
                }
            }
        }
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.stop();
                } else {
                    CyberLog.d(TAG, "Dlna: provider == null");
                }
            }
        }
    }
}
