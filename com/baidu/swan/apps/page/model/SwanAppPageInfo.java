package com.baidu.swan.apps.page.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public class SwanAppPageInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SwanAppPageInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String appDesc;
    public String appName;
    public String fragmentId;
    public String iconUrl;
    public String imageUrl;
    public String scheme;
    public String title;
    public String type;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SwanAppPageInfo> {
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
        public SwanAppPageInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new SwanAppPageInfo(parcel);
            }
            return (SwanAppPageInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanAppPageInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new SwanAppPageInfo[i];
            }
            return (SwanAppPageInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1590369575, "Lcom/baidu/swan/apps/page/model/SwanAppPageInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1590369575, "Lcom/baidu/swan/apps/page/model/SwanAppPageInfo;");
                return;
            }
        }
        CREATOR = new a();
    }

    public SwanAppPageInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appDesc = parcel.readString();
        this.title = parcel.readString();
        this.imageUrl = parcel.readString();
        this.type = parcel.readString();
        this.url = parcel.readString();
        this.scheme = parcel.readString();
        this.fragmentId = parcel.readString();
    }

    private void parsePageInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.type = jSONObject.optString("type");
        JSONObject optJSONObject = jSONObject.optJSONObject("pageInfo");
        if (optJSONObject != null) {
            this.title = optJSONObject.optString("title");
            this.imageUrl = optJSONObject.optString("img");
        }
        this.url = jSONObject.optString("url");
        this.appName = jSONObject.optString("appName");
        this.iconUrl = jSONObject.optString("iconUrl");
        this.appDesc = jSONObject.optString("appDesc");
        this.scheme = jSONObject.optString("scheme");
        this.fragmentId = jSONObject.optString("pageId");
    }

    public SwanAppPageInfo(String str) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        parsePageInfo(jSONObject);
    }

    public SwanAppPageInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        parsePageInfo(jSONObject);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanAppPageInfo{appName='" + this.appName + "', iconUrl='" + this.iconUrl + "', appDesc='" + this.appDesc + "', title='" + this.title + "', imageUrl='" + this.imageUrl + "', type='" + this.type + "', url='" + this.url + "', scheme='" + this.scheme + "', fragmentId='" + this.fragmentId + "'}";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.appName);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.appDesc);
            parcel.writeString(this.title);
            parcel.writeString(this.imageUrl);
            parcel.writeString(this.type);
            parcel.writeString(this.url);
            parcel.writeString(this.scheme);
            parcel.writeString(this.fragmentId);
        }
    }
}
