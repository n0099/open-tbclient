package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class DpSessionDatasUploader {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String SAILOR_MONITOR = "sailor_monitor";

    /* renamed from: a  reason: collision with root package name */
    public static DpSessionDatasUploader f39269a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d f39270b;

    /* renamed from: c  reason: collision with root package name */
    public d f39271c;

    public DpSessionDatasUploader() {
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
        this.f39270b = new d();
        this.f39271c = new d("live_show_session");
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            d dVar = this.f39270b;
            if (dVar != null) {
                dVar.a();
            }
            d dVar2 = this.f39271c;
            if (dVar2 != null) {
                dVar2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, str, str2, i2) == null) {
            String a2 = a(str2, i2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue("enable_session_gzip", true);
            byte[] a3 = a(str.getBytes(), cfgBoolValue);
            if (a3 == null && cfgBoolValue) {
                a3 = a(str.getBytes(), false);
                cfgBoolValue = false;
            }
            if (a(n.a(a3), a2, cfgBoolValue)) {
                a();
            } else {
                a(Base64.encode(n.a(a(str.getBytes(), false)), 2), i2);
            }
        }
    }

    private void a(byte[] bArr, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, i2) == null) {
            if (i2 == 24) {
                dVar = this.f39271c;
                if (dVar == null) {
                    return;
                }
            } else {
                dVar = this.f39270b;
                if (dVar == null) {
                    return;
                }
            }
            dVar.a(bArr);
        }
    }

    public static byte[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, bArr, z)) == null) {
            if (z) {
                try {
                    return n.b(bArr);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return Base64.encode(bArr, 2);
        }
        return (byte[]) invokeLZ.objValue;
    }

    @Keep
    public static synchronized DpSessionDatasUploader getInstance() {
        InterceptResult invokeV;
        DpSessionDatasUploader dpSessionDatasUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (DpSessionDatasUploader.class) {
                if (f39269a == null) {
                    f39269a = new DpSessionDatasUploader();
                }
                dpSessionDatasUploader = f39269a;
            }
            return dpSessionDatasUploader;
        }
        return (DpSessionDatasUploader) invokeV.objValue;
    }

    public String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            String e2 = com.baidu.cyberplayer.sdk.c.a().e();
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            String str2 = e2 + str;
            if (i2 == 24) {
                return str2 + "&upload_type=tieba_live";
            }
            return str2;
        }
        return (String) invokeLI.objValue;
    }

    public void a(Context context) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null || (dVar = this.f39270b) == null || this.f39271c == null) {
            return;
        }
        dVar.a(context);
        this.f39271c.a(context);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x00e1 */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
        r10.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b7, code lost:
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d8, code lost:
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        int i2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, str, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CyberLog.d("SessionDatasUploader", "sendStatisticsDataToServer called uploadUrl:" + ((String) str) + " isGzipCompressed:" + z);
        OutputStream outputStream = null;
        i2 = -1;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (str != 0) {
                    try {
                        str.disconnect();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Error e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
            }
            if (str != 0) {
            }
            throw th;
        }
        try {
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            if (z) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-gzip");
            }
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            i2 = httpURLConnection.getResponseCode();
            CyberLog.d("SessionDatasUploader", "upload response : " + i2);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Error e6) {
            e = e6;
            CyberLog.e("SessionDatasUploader", "upload error " + e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        } catch (Exception e8) {
            e = e8;
            CyberLog.e("SessionDatasUploader", "upload error " + e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
        }
        return i2 == 200;
    }

    @Keep
    public void upload(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && com.baidu.cyberplayer.sdk.c.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable(this, str, str2) { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f39272a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f39273b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DpSessionDatasUploader f39274c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39274c = this;
                    this.f39272a = str;
                    this.f39273b = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39274c.a(this.f39272a, this.f39273b, 1);
                    }
                }
            });
        }
    }

    @Keep
    public void upload(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048580, this, str, str2, i2) == null) && com.baidu.cyberplayer.sdk.c.a().b()) {
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable(this, i2, str, str2) { // from class: com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f39275a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f39276b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f39277c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DpSessionDatasUploader f39278d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39278d = this;
                    this.f39275a = i2;
                    this.f39276b = str;
                    this.f39277c = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.baidu.cyberplayer.sdk.c.a().c() && this.f39275a == 24) {
                            this.f39278d.a(this.f39276b, this.f39277c, 24);
                        }
                        this.f39278d.a(this.f39276b, this.f39277c, 1);
                    }
                }
            });
        }
    }
}
