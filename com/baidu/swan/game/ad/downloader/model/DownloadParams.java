package com.baidu.swan.game.ad.downloader.model;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11788a;

    /* renamed from: b  reason: collision with root package name */
    public String f11789b;

    /* renamed from: c  reason: collision with root package name */
    public String f11790c;

    /* renamed from: d  reason: collision with root package name */
    public String f11791d;

    /* renamed from: e  reason: collision with root package name */
    public String f11792e;

    /* renamed from: f  reason: collision with root package name */
    public long f11793f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SwanAppDownloadType {
        public static final /* synthetic */ SwanAppDownloadType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwanAppDownloadType TYPE_CANCEL_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_INSTALL_APP;
        public static final SwanAppDownloadType TYPE_OTHER;
        public static final SwanAppDownloadType TYPE_PAUSE_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_QUERY_STATUS;
        public static final SwanAppDownloadType TYPE_RESUME_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_START_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_STOP_SERVICE;
        public transient /* synthetic */ FieldHolder $fh;
        public String typeName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117517790, "Lcom/baidu/swan/game/ad/downloader/model/DownloadParams$SwanAppDownloadType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2117517790, "Lcom/baidu/swan/game/ad/downloader/model/DownloadParams$SwanAppDownloadType;");
                    return;
                }
            }
            TYPE_QUERY_STATUS = new SwanAppDownloadType("TYPE_QUERY_STATUS", 0, "queryStatus");
            TYPE_START_DOWNLOAD = new SwanAppDownloadType("TYPE_START_DOWNLOAD", 1, "startDownload");
            TYPE_PAUSE_DOWNLOAD = new SwanAppDownloadType("TYPE_PAUSE_DOWNLOAD", 2, "pauseDownload");
            TYPE_CANCEL_DOWNLOAD = new SwanAppDownloadType("TYPE_CANCEL_DOWNLOAD", 3, "cancelDownload");
            TYPE_RESUME_DOWNLOAD = new SwanAppDownloadType("TYPE_RESUME_DOWNLOAD", 4, "resumeDownload");
            TYPE_INSTALL_APP = new SwanAppDownloadType("TYPE_INSTALL_APP", 5, "installApp");
            TYPE_STOP_SERVICE = new SwanAppDownloadType("TYPE_STOP_SERVICE", 6, "stopService");
            SwanAppDownloadType swanAppDownloadType = new SwanAppDownloadType("TYPE_OTHER", 7, "#");
            TYPE_OTHER = swanAppDownloadType;
            $VALUES = new SwanAppDownloadType[]{TYPE_QUERY_STATUS, TYPE_START_DOWNLOAD, TYPE_PAUSE_DOWNLOAD, TYPE_CANCEL_DOWNLOAD, TYPE_RESUME_DOWNLOAD, TYPE_INSTALL_APP, TYPE_STOP_SERVICE, swanAppDownloadType};
        }

        public SwanAppDownloadType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
        }

        public static SwanAppDownloadType find(@Nullable String str) {
            InterceptResult invokeL;
            SwanAppDownloadType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (SwanAppDownloadType swanAppDownloadType : values()) {
                    if (swanAppDownloadType.typeName.equals(str)) {
                        return swanAppDownloadType;
                    }
                }
                return TYPE_OTHER;
            }
            return (SwanAppDownloadType) invokeL.objValue;
        }

        public static SwanAppDownloadType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SwanAppDownloadType) Enum.valueOf(SwanAppDownloadType.class, str) : (SwanAppDownloadType) invokeL.objValue;
        }

        public static SwanAppDownloadType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SwanAppDownloadType[]) $VALUES.clone() : (SwanAppDownloadType[]) invokeV.objValue;
        }

        public String getTypeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.typeName : (String) invokeV.objValue;
        }
    }

    public DownloadParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11788a = str;
        this.f11789b = str2;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.f11788a);
                jSONObject.put("name", this.f11789b);
                jSONObject.put("userAgent", this.f11790c);
                jSONObject.put("contentDisposition", this.f11791d);
                jSONObject.put("mimeType", this.f11792e);
                jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.f11793f);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public DownloadParams(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11788a = str;
        this.f11789b = str2;
    }
}
