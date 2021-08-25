package com.baidu.media.playerconfig;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.media.duplayer.Keep;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
public class PlayerConfigManagerInternal {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINI_VIDEO = 0;
    public static final int SHORT_VIDEO = 1;
    public static final int UNKNOWN = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final PlayerConfigManagerInternal f42532d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f42533a;

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f42534b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f42535c;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42536e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PlayerConfigManagerInternal f42537f;

        public a(PlayerConfigManagerInternal playerConfigManagerInternal, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playerConfigManagerInternal, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42537f = playerConfigManagerInternal;
            this.f42536e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (PlayerConfigManagerInternal.class) {
                    this.f42537f.f42533a = this.f42537f.d(this.f42536e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f42538a;

        /* renamed from: b  reason: collision with root package name */
        public String f42539b;

        public b(String str, int i2) {
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
            this.f42538a = i2;
            this.f42539b = str;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f42540a;

        /* renamed from: b  reason: collision with root package name */
        public long f42541b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.z.d.a f42542c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.z.d.a f42543d;

        public c() {
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
            this.f42540a = 300L;
            this.f42541b = 0L;
            this.f42542c = null;
            this.f42543d = null;
        }

        public c.a.z.d.a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        return null;
                    }
                    return this.f42542c;
                }
                return this.f42543d;
            }
            return (c.a.z.d.a) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769339481, "Lcom/baidu/media/playerconfig/PlayerConfigManagerInternal;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769339481, "Lcom/baidu/media/playerconfig/PlayerConfigManagerInternal;");
                return;
            }
        }
        f42532d = new PlayerConfigManagerInternal();
    }

    public PlayerConfigManagerInternal() {
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
        this.f42533a = null;
        this.f42534b = null;
        this.f42535c = null;
        HandlerThread handlerThread = new HandlerThread("player_config_thread");
        this.f42534b = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.f42535c = new Handler(this.f42534b.getLooper());
        }
    }

    public static PlayerConfigManagerInternal getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f42532d : (PlayerConfigManagerInternal) invokeV.objValue;
    }

    public int a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            String query = uri.getQuery();
            if (query == null) {
                return -1;
            }
            String[] split = query.split("&");
            boolean z = false;
            int i2 = -1;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].indexOf("vt") != -1) {
                    try {
                        i2 = Integer.parseInt(split[i3].substring(3));
                        z = true;
                    } catch (Exception unused) {
                        z = true;
                        i2 = -1;
                    }
                }
            }
            if (z) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        CyberLog.i("PlayerServer-PlyrCnfgMngr", "This URI is UNKNOWN video!!!");
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final c d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                try {
                    if (str.isEmpty()) {
                        return null;
                    }
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("bandwidth_config");
                    try {
                        cVar.f42541b = jSONObject.getLong("now_time");
                        cVar.f42540a = jSONObject.getLong("update_interval");
                    } catch (Exception e2) {
                        CyberLog.e("PlayerServer-PlyrCnfgMngr", "get now time fail!", e2);
                    }
                    cVar.f42542c = e(jSONObject.getJSONObject("default"), "Short Video");
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "" + cVar.f42542c);
                    cVar.f42543d = e(jSONObject.getJSONObject("mini_video"), "Mini Video");
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "" + cVar.f42543d);
                    return cVar;
                } catch (Exception e3) {
                    CyberLog.e("PlayerServer-PlyrCnfgMngr", "update config fail : ", e3);
                    return null;
                }
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public final c.a.z.d.a e(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            c.a.z.d.a aVar = null;
            try {
                String string = jSONObject.getString("host");
                if (string != null) {
                    if (!string.isEmpty()) {
                        aVar = new c.a.z.d.a(str);
                        aVar.f31162e = string.split(";");
                        aVar.f31163f = jSONObject.getString("cntl_id");
                        try {
                            boolean z = true;
                            if (jSONObject.getJSONObject("pcdn_config").getInt(SetImageWatermarkTypeReqMsg.SWITCH) != 1) {
                                z = false;
                            }
                            aVar.f31164g = z;
                        } catch (Exception e2) {
                            CyberLog.e("PlayerServer-PlyrCnfgMngr", "update pcdn_config fail", e2);
                        }
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("cdn_config").getJSONObject("limit_rate");
                            aVar.f31166i.f31168e = jSONObject2.getInt("sle");
                            aVar.f31166i.f31169f = (float) jSONObject2.getDouble("sl_rate");
                            aVar.f31166i.f31170g = (float) jSONObject2.getDouble("split_rate");
                        } catch (Exception e3) {
                            CyberLog.e("PlayerServer-PlyrCnfgMngr", "update cdn config fail", e3);
                        }
                        try {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("prefetch_config");
                            aVar.f31167j.f31171e = jSONObject3.getInt("duration");
                            aVar.f31167j.f31172f = jSONObject3.getInt("pcdn_enable");
                            aVar.f31167j.f31173g = jSONObject3.getInt("p2p_enable");
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("limit_rate");
                            aVar.f31167j.f31174h = jSONObject4.getInt("sle");
                            aVar.f31167j.f31175i = (float) jSONObject4.getDouble("sl_rate");
                            aVar.f31167j.f31176j = (float) jSONObject4.getDouble("split_rate");
                        } catch (Exception e4) {
                            CyberLog.e("PlayerServer-PlyrCnfgMngr", "update prefetch config fail", e4);
                        }
                    }
                }
                return aVar;
            } catch (Exception e5) {
                CyberLog.e("PlayerServer-PlyrCnfgMngr", "NO HOST fail : ", e5);
                return null;
            }
        }
        return (c.a.z.d.a) invokeLL.objValue;
    }

    public final boolean f(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, strArr)) == null) {
            if (str != null && !str.isEmpty()) {
                for (int i2 = 0; strArr != null && i2 < strArr.length; i2++) {
                    if (str.equals(strArr[i2])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public c getPlayerConfig() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (PlayerConfigManagerInternal.class) {
                cVar = this.f42533a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @RequiresApi(api = 11)
    public Uri rebuildUrlForPlay(Uri uri, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048581, this, uri, str, i2, i3)) == null) {
            if (uri == null || i2 <= 0 || i3 <= 0) {
                CyberLog.i("PlayerServer-PlyrCnfgMngr", "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!");
                return uri;
            }
            c d2 = d(str);
            if (d2 == null && (d2 = getPlayerConfig()) == null) {
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "rebuildUrl get container null!");
                return uri;
            } else if ((System.currentTimeMillis() / 1000) - d2.f42541b > d2.f42540a * 4) {
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "This config is time out!");
                return uri;
            } else {
                int a2 = a(uri);
                if (a2 == -1) {
                    return uri;
                }
                c.a.z.d.a a3 = d2.a(a2);
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "" + a3);
                if (!a3.e()) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "The player server config is invalidate, use old uri continue!");
                    return uri;
                } else if (!f(uri.getHost(), a3.f31162e)) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "host : " + uri.getHost() + " not match");
                    return uri;
                } else {
                    String query = uri.getQuery();
                    if (query == null || query.isEmpty()) {
                        CyberLog.i("PlayerServer-PlyrCnfgMngr", "This host has no query!");
                        return uri;
                    }
                    String[] split = query.split("&");
                    boolean z = false;
                    int i4 = -1;
                    boolean z2 = false;
                    for (int i5 = 0; i5 < split.length; i5++) {
                        if (split[i5].indexOf("sle") != -1) {
                            split[i5] = "sle=" + a3.f31166i.f31168e;
                            z2 = true;
                        } else if (split[i5].indexOf("sl") != -1) {
                            split[i5] = "sl=" + ((int) ((a3.f31166i.f31169f * i2) / 8.0f));
                        } else if (split[i5].indexOf("split") != -1) {
                            split[i5] = "split=" + ((int) ((((a3.f31166i.f31170g * i2) * 1024.0f) / 8.0f) + i3));
                        } else {
                            if (split[i5].indexOf("vt") != -1) {
                                i4 = Integer.parseInt(split[i5].substring(3));
                                z = true;
                            }
                        }
                    }
                    if (!z || (i4 != 1 && i4 != 0)) {
                        CyberLog.i("PlayerServer-PlyrCnfgMngr", "This URI is not shot video!!!");
                        return uri;
                    }
                    try {
                        Uri.Builder buildUpon = uri.buildUpon();
                        buildUpon.clearQuery();
                        for (String str2 : split) {
                            String[] split2 = str2.split("=");
                            buildUpon.appendQueryParameter(split2[0], split2[1]);
                        }
                        if (!z2) {
                            buildUpon.appendQueryParameter("sle", "" + a3.f31166i.f31168e);
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append((int) ((a3.f31166i.f31169f * ((float) i2)) / 8.0f));
                            buildUpon.appendQueryParameter("sl", sb.toString());
                            buildUpon.appendQueryParameter("split", "" + ((int) ((((a3.f31166i.f31170g * f2) * 1024.0f) / 8.0f) + i3)));
                        }
                        if (a3.f31163f != null && a3.f31163f.length() > 0) {
                            buildUpon.appendQueryParameter("ctid", a3.f31163f);
                        }
                        return buildUpon.build();
                    } catch (Exception unused) {
                        return uri;
                    }
                }
            }
        }
        return (Uri) invokeLLII.objValue;
    }

    public Uri rebuildUrlForPlay(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048582, this, str, str2, i2, i3)) == null) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            return rebuildUrlForPlay(Uri.parse(str), str2, i2, i3);
        }
        return (Uri) invokeLLII.objValue;
    }

    @RequiresApi(api = 11)
    public b rebuildUrlForPrefetch(Uri uri, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        b bVar;
        String str2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048583, this, uri, str, i2, i3)) == null) {
            if (uri == null || i2 <= 0 || i3 <= 0) {
                bVar = null;
                str2 = "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!";
            } else {
                c d2 = d(str);
                if (d2 == null && (d2 = getPlayerConfig()) == null) {
                    CyberLog.d("PlayerServer-PlyrCnfgMngr", "rebuildUrl get container null!");
                    return null;
                } else if ((System.currentTimeMillis() / 1000) - d2.f42541b > d2.f42540a * 4) {
                    CyberLog.d("PlayerServer-PlyrCnfgMngr", "This config is time out!");
                    return null;
                } else {
                    int a2 = a(uri);
                    if (a2 == -1) {
                        return null;
                    }
                    c.a.z.d.a a3 = d2.a(a2);
                    CyberLog.d("PlayerServer-PlyrCnfgMngr", "" + a3);
                    if (!a3.e()) {
                        CyberLog.i("PlayerServer-PlyrCnfgMngr", "The player server config is invalidate, use old uri continue!");
                        return null;
                    } else if (!f(uri.getHost(), a3.f31162e)) {
                        CyberLog.i("PlayerServer-PlyrCnfgMngr", "host : " + uri.getHost() + " not match");
                        return null;
                    } else {
                        String query = uri.getQuery();
                        if (query == null || query.isEmpty()) {
                            bVar = null;
                            str2 = "This host has no query!";
                        } else {
                            String[] split = query.split("&");
                            boolean z = false;
                            int i4 = -1;
                            boolean z2 = false;
                            for (int i5 = 0; i5 < split.length; i5++) {
                                if (split[i5].indexOf("sle") != -1) {
                                    split[i5] = "sle=" + a3.f31167j.f31174h;
                                    z2 = true;
                                } else if (split[i5].indexOf("sl") != -1) {
                                    split[i5] = "sl=" + ((int) ((a3.f31167j.f31175i * i2) / 8.0f));
                                } else if (split[i5].indexOf("split") != -1) {
                                    split[i5] = "split=" + ((int) ((((a3.f31167j.f31176j * i2) * 1024.0f) / 8.0f) + i3));
                                } else {
                                    if (split[i5].indexOf("vt") != -1) {
                                        i4 = Integer.parseInt(split[i5].substring(3));
                                        z = true;
                                    }
                                }
                            }
                            if (z && (i4 == 1 || i4 == 0)) {
                                try {
                                    Uri.Builder buildUpon = uri.buildUpon();
                                    buildUpon.clearQuery();
                                    for (String str3 : split) {
                                        String[] split2 = str3.split("=");
                                        buildUpon.appendQueryParameter(split2[0], split2[1]);
                                    }
                                    if (!z2) {
                                        buildUpon.appendQueryParameter("sle", "" + a3.f31167j.f31174h);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("");
                                        sb.append((int) ((a3.f31167j.f31175i * ((float) i2)) / 8.0f));
                                        buildUpon.appendQueryParameter("sl", sb.toString());
                                        buildUpon.appendQueryParameter("split", "" + ((int) ((((a3.f31167j.f31176j * f2) * 1024.0f) / 8.0f) + i3)));
                                    }
                                    if (a3.f31163f != null && a3.f31163f.length() > 0) {
                                        buildUpon.appendQueryParameter("ctid", a3.f31163f);
                                    }
                                    return new b(buildUpon.build().toString(), (((i2 * 1024) / 8) * a3.f31167j.f31171e) + i3);
                                } catch (Exception unused) {
                                    return null;
                                }
                            }
                            bVar = null;
                            str2 = "This URI is not shot video!!!";
                        }
                    }
                }
            }
            CyberLog.i("PlayerServer-PlyrCnfgMngr", str2);
            return bVar;
        }
        return (b) invokeLLII.objValue;
    }

    public b rebuildUrlForPrefetch(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2, i3)) == null) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            return rebuildUrlForPrefetch(Uri.parse(str), str2, i2, i3);
        }
        return (b) invokeLLII.objValue;
    }

    public void updatePlayerConfig(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || str == null || str.isEmpty()) {
            return;
        }
        Handler handler = this.f42535c;
        if (handler != null) {
            handler.post(new a(this, str));
            return;
        }
        synchronized (PlayerConfigManagerInternal.class) {
            this.f42533a = d(str);
        }
    }
}
