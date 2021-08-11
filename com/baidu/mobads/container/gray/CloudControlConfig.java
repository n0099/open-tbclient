package com.baidu.mobads.container.gray;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudControlConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.baidu.mobads.container.gray.CloudControlConfig";
    public static volatile CloudControlConfig mSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public AvailablePKType availablePKType;
    public JSONObject configJson;
    public double inAvailableVersion;
    public JSONArray inAvailableVersionArray;
    public Context mContext;
    public String mSPName;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class AvailablePKType {
        public static final /* synthetic */ AvailablePKType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AvailablePKType AVAILABLE_PK_TYPE_ASSETS;
        public static final AvailablePKType AVAILABLE_PK_TYPE_GRAY;
        public static final AvailablePKType AVAILABLE_PK_TYPE_SPECIAL;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(387927626, "Lcom/baidu/mobads/container/gray/CloudControlConfig$AvailablePKType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(387927626, "Lcom/baidu/mobads/container/gray/CloudControlConfig$AvailablePKType;");
                    return;
                }
            }
            AVAILABLE_PK_TYPE_GRAY = new AvailablePKType("AVAILABLE_PK_TYPE_GRAY", 0, 1);
            AVAILABLE_PK_TYPE_ASSETS = new AvailablePKType("AVAILABLE_PK_TYPE_ASSETS", 1, 2);
            AvailablePKType availablePKType = new AvailablePKType("AVAILABLE_PK_TYPE_SPECIAL", 2, 3);
            AVAILABLE_PK_TYPE_SPECIAL = availablePKType;
            $VALUES = new AvailablePKType[]{AVAILABLE_PK_TYPE_GRAY, AVAILABLE_PK_TYPE_ASSETS, availablePKType};
        }

        public AvailablePKType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static AvailablePKType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AvailablePKType) Enum.valueOf(AvailablePKType.class, str) : (AvailablePKType) invokeL.objValue;
        }

        public static AvailablePKType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AvailablePKType[]) $VALUES.clone() : (AvailablePKType[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1362685988, "Lcom/baidu/mobads/container/gray/CloudControlConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1362685988, "Lcom/baidu/mobads/container/gray/CloudControlConfig;");
        }
    }

    public CloudControlConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSPName = "baidu_cloudControlConfig";
        this.availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_GRAY;
        this.mContext = context.getApplicationContext();
    }

    public static CloudControlConfig getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (mSingleton == null) {
                synchronized (CloudControlConfig.class) {
                    if (mSingleton == null) {
                        mSingleton = new CloudControlConfig(context);
                    }
                }
            }
            return mSingleton;
        }
        return (CloudControlConfig) invokeL.objValue;
    }

    public int getAvailablePKType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AvailablePKType availablePKType = this.availablePKType;
            if (availablePKType == null) {
                try {
                    return new SPUtils(this.mContext, this.mSPName).getInt("baidu_cloudConfig_pktype", 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return 1;
                }
            }
            return availablePKType.getValue();
        }
        return invokeV.intValue;
    }

    public String getValueForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (this.configJson == null) {
                    this.configJson = new JSONObject(new SPUtils(this.mContext, this.mSPName).getString("baidu_cloudConfig", ""));
                }
                if (this.configJson != null) {
                    return this.configJson.getString(str);
                }
                return null;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean isInAvailableVersion(double d2) {
        InterceptResult invokeCommon;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)})) == null) {
            try {
                try {
                    if (this.inAvailableVersionArray == null) {
                        String string = new SPUtils(this.mContext, this.mSPName).getString("baidu_cloudConfig_v", "");
                        if (!TextUtils.isEmpty(string)) {
                            this.inAvailableVersionArray = new JSONArray(string);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.inAvailableVersionArray == null) {
                return false;
            }
            if (d2 == this.inAvailableVersion) {
                return true;
            }
            for (int i2 = 0; i2 < this.inAvailableVersionArray.length(); i2++) {
                try {
                    parseDouble = Double.parseDouble(this.inAvailableVersionArray.getString(i2));
                    this.inAvailableVersion = parseDouble;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                if (d2 == parseDouble) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setCloudConfigInfo(String str) {
        String str2;
        String str3;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            SPUtils sPUtils = new SPUtils(this.mContext, this.mSPName);
            String str4 = "";
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String decodeStr = Base64.decodeStr(jSONObject.optString("config"));
                    if (decodeStr != null) {
                        this.configJson = new JSONObject(decodeStr);
                    }
                    if (this.configJson == null || (optJSONArray = this.configJson.optJSONArray("inavailable_v")) == null) {
                        str3 = "";
                    } else {
                        this.inAvailableVersionArray = optJSONArray;
                        setVersionFallback(jSONObject.optDouble("version"));
                        this.configJson.remove(APKStateManager.KEY_JSON_CONFIG_PKG_LIST);
                        str3 = this.configJson.toString();
                        try {
                            if (this.inAvailableVersionArray != null) {
                                str4 = this.inAvailableVersionArray.toString();
                            }
                        } catch (JSONException e2) {
                            str2 = str3;
                            e = e2;
                            e.printStackTrace();
                            sPUtils.putString("baidu_cloudConfig_v", str4);
                            sPUtils.putString("baidu_cloudConfig", str2);
                            sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
                        } catch (Throwable th) {
                            str2 = str3;
                            th = th;
                            th.printStackTrace();
                            sPUtils.putString("baidu_cloudConfig_v", str4);
                            sPUtils.putString("baidu_cloudConfig", str2);
                            sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
                        }
                    }
                    str2 = str3;
                } catch (JSONException e3) {
                    e = e3;
                    str2 = "";
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "";
                }
            } else {
                str2 = "";
            }
            sPUtils.putString("baidu_cloudConfig_v", str4);
            sPUtils.putString("baidu_cloudConfig", str2);
            sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
        }
    }

    public void setVersionFallback(double d2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) || this.inAvailableVersionArray == null) {
            return;
        }
        try {
            double runningVersion = RemoteVersionUtil.getInstance(this.mContext).getRunningVersion();
            String str = "";
            String str2 = runningVersion == 0.0d ? "" : "" + runningVersion;
            double downloadedVersion = RemoteVersionUtil.getInstance(this.mContext).getDownloadedVersion();
            if (downloadedVersion != 0.0d) {
                str = "" + downloadedVersion;
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 < this.inAvailableVersionArray.length(); i2++) {
                String string = this.inAvailableVersionArray.getString(i2);
                if (XAdSDKRemoteVersion.getVersion() == Double.valueOf(string).doubleValue()) {
                    this.inAvailableVersion = Double.valueOf(string).doubleValue();
                }
                if (!TextUtils.isEmpty(str2) && string.equals(str2)) {
                    z = true;
                }
                if ((!TextUtils.isEmpty(str) && string.equals(str)) || TextUtils.isEmpty(str)) {
                    z2 = true;
                }
                if (d2 == Double.valueOf(string).doubleValue() || d2 <= runningVersion) {
                    z3 = true;
                }
            }
            if (z && z2 && z3) {
                this.availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_ASSETS;
            } else {
                this.availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_GRAY;
            }
        } catch (Throwable unused) {
        }
    }
}
