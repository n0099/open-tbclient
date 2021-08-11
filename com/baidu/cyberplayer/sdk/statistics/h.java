package com.baidu.cyberplayer.sdk.statistics;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f39026a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39027b;

    public h() {
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
        this.f39027b = false;
        this.f39026a = new g();
    }

    public synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                String str = null;
                if (this.f39026a != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        a.a().a(jSONObject);
                        jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(this.f39026a.a());
                        jSONObject.put("items", jSONArray);
                        str = jSONObject.toString();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONObject.remove("cuid");
                    CyberLog.i("DpStatSessionImpl", "all session = " + jSONObject.toString());
                    return str;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void a(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (this.f39026a != null) {
                    this.f39026a.a(i2, str, String.valueOf(i3));
                }
            }
        }
    }

    public synchronized void a(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            synchronized (this) {
                if (this.f39026a != null) {
                    this.f39026a.a(i2, str, String.valueOf(j2));
                }
            }
        }
    }

    public synchronized void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            synchronized (this) {
                if (this.f39026a != null) {
                    this.f39026a.a(i2, str, str2);
                }
            }
        }
    }

    public synchronized void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            synchronized (this) {
                if (this.f39026a != null && kVar != null) {
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(kVar.getCurrentPosition()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(kVar.getDecodeMode()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(kVar.b()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.a(CyberPlayerManager.getApplicationContext()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", kVar.a());
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(kVar.b()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(kVar.getDuration()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(kVar.getPlayedTime()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_IS_USER_STARTED, kVar.c() ? "1" : "0");
                }
            }
        }
    }

    public synchronized void b(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            synchronized (this) {
                if (this.f39026a != null && kVar != null) {
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(kVar.getVideoWidth()));
                    this.f39026a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(kVar.getVideoHeight()));
                }
            }
        }
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                z = this.f39027b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f39026a != null) {
                    this.f39026a.b();
                }
                this.f39027b = false;
            }
        }
    }

    public synchronized void c(k kVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar) == null) {
            synchronized (this) {
                if (kVar != null) {
                    if (this.f39026a != null && (a2 = a()) != null) {
                        this.f39027b = true;
                        DpSessionDatasUploader.getInstance().upload(a2, "sailor_monitor");
                    }
                }
            }
        }
    }
}
