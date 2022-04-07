package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tg1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppBearInfo extends SwanAppIPCData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAR_DESC = "sign";
    public static final String BEAR_ID = "office_id";
    public static final String BEAR_INFO = "bear_info";
    public static final String BEAR_LOGO = "avatar";
    public static final String BEAR_NAME = "name";
    public static final String BEAR_URL = "url";
    public static final String BEAR_VIP_TYPE = "v_type";
    public static final Parcelable.Creator<SwanAppBearInfo> CREATOR;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public String bearDesc;
    public String bearHomeUrl;
    public String bearId;
    public String bearLogo;
    public String bearName;
    public String bearVipType;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<SwanAppBearInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanAppBearInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SwanAppBearInfo(parcel, null) : (SwanAppBearInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppBearInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SwanAppBearInfo[i] : (SwanAppBearInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-596612324, "Lcom/baidu/swan/apps/model/SwanAppBearInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-596612324, "Lcom/baidu/swan/apps/model/SwanAppBearInfo;");
                return;
            }
        }
        DEBUG = tg1.a;
        CREATOR = new a();
    }

    public /* synthetic */ SwanAppBearInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.bearId) : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.bearId);
            parcel.writeString(this.bearName);
            parcel.writeString(this.bearLogo);
            parcel.writeString(this.bearHomeUrl);
            parcel.writeString(this.bearDesc);
            parcel.writeString(this.bearVipType);
        }
    }

    public SwanAppBearInfo() {
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
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
    }

    public SwanAppBearInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
        this.bearId = parcel.readString();
        this.bearName = parcel.readString();
        this.bearLogo = parcel.readString();
        this.bearHomeUrl = parcel.readString();
        this.bearDesc = parcel.readString();
        this.bearVipType = parcel.readString();
    }

    public SwanAppBearInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.bearId = "";
        this.bearName = "";
        this.bearLogo = "";
        this.bearHomeUrl = "";
        this.bearDesc = "";
        this.bearVipType = "";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.bearId = jSONObject.optString(BEAR_ID);
            this.bearDesc = jSONObject.optString("sign");
            this.bearHomeUrl = jSONObject.optString("url");
            this.bearLogo = jSONObject.optString("avatar");
            this.bearName = jSONObject.optString("name");
            this.bearVipType = jSONObject.optString(BEAR_VIP_TYPE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
