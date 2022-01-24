package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes11.dex */
public class ChannelManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String KEY_CHANNEL = "channel";
    public static final String PREFS_NAME = "com.baidu.common.pubparam";
    public static final String TAG = "ChannelManager";
    public static volatile ChannelManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences mCache;
    public String mChannel;
    public String mLastChannel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39461257, "Lcom/baidu/searchbox/logsystem/basic/upload/identity/ChannelManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39461257, "Lcom/baidu/searchbox/logsystem/basic/upload/identity/ChannelManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ChannelManager() {
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
        init();
    }

    public static ChannelManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (ChannelManager.class) {
                    if (sInstance == null) {
                        sInstance = new ChannelManager();
                    }
                }
            }
            return sInstance;
        }
        return (ChannelManager) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mCache = AppRuntime.getAppContext().getSharedPreferences(PREFS_NAME, 0);
            initLastChannel();
            initChanel();
        }
    }

    private void initChanel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String readChannelFromCache = readChannelFromCache();
            this.mChannel = readChannelFromCache;
            if (!TextUtils.isEmpty(readChannelFromCache) || TextUtils.isEmpty(this.mLastChannel)) {
                return;
            }
            this.mChannel = this.mLastChannel;
            saveCannelToCache();
        }
    }

    private void initLastChannel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            String readLastChannelFromRaw = readLastChannelFromRaw();
            this.mLastChannel = readLastChannelFromRaw;
            if (TextUtils.isEmpty(readLastChannelFromRaw)) {
                this.mLastChannel = readLastChannelFromAssets();
            }
        }
    }

    private String readChannelFromCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.mCache.getString("channel", null) : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006e A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #5 {Exception -> 0x006a, blocks: (B:36:0x0066, B:39:0x006e), top: B:51:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readLastChannelFromAssets() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, this)) != null) {
            return (String) invokeV.objValue;
        }
        InputStream inputStream2 = null;
        String str2 = null;
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open("file:///android_asset/channel");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    str2 = bufferedReader.readLine();
                    inputStream.close();
                    bufferedReader.close();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                            boolean z = DEBUG;
                            return str2;
                        }
                    }
                    bufferedReader.close();
                    return str2;
                } catch (IOException unused2) {
                    String str3 = str2;
                    inputStream2 = inputStream;
                    str = str3;
                    try {
                        boolean z2 = DEBUG;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused3) {
                                boolean z3 = DEBUG;
                                return str;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        InputStream inputStream3 = inputStream2;
                        th = th2;
                        inputStream = inputStream3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                                boolean z4 = DEBUG;
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                bufferedReader = null;
                inputStream2 = inputStream;
                str = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
        } catch (IOException unused6) {
            str = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:16:0x0047). Please submit an issue!!! */
    private String readLastChannelFromRaw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            int identifier = resources.getIdentifier("tnconfig", "raw", AppRuntime.getAppContext().getPackageName());
            String str = null;
            if (identifier == 0) {
                return null;
            }
            InputStream openRawResource = resources.openRawResource(identifier);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
            try {
                try {
                    try {
                        str = bufferedReader.readLine();
                        openRawResource.close();
                        bufferedReader.close();
                    } catch (IOException unused) {
                        boolean z = DEBUG;
                        openRawResource.close();
                        bufferedReader.close();
                    }
                } catch (Exception unused2) {
                    boolean z2 = DEBUG;
                }
                return str;
            } catch (Throwable th) {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (Exception unused3) {
                    boolean z3 = DEBUG;
                }
                throw th;
            }
        }
        return (String) invokeV.objValue;
    }

    private void saveCannelToCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mCache.edit().putString("channel", this.mChannel).apply();
        }
    }

    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChannel : (String) invokeV.objValue;
    }

    public String getLastChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLastChannel : (String) invokeV.objValue;
    }
}
