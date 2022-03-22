package com.baidu.swan.game.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdResponseInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdResponseInfo> CREATOR;
    public static final String TAG = "AdResponseInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AdElementInfo> mAdInstanceList;
    public int mAdsNum;
    public String mErrorCode;
    public String mRequestId;

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<AdResponseInfo> {
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
        public AdResponseInfo createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new AdResponseInfo(parcel) : (AdResponseInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdResponseInfo[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new AdResponseInfo[i] : (AdResponseInfo[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(919325148, "Lcom/baidu/swan/game/ad/entity/AdResponseInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(919325148, "Lcom/baidu/swan/game/ad/entity/AdResponseInfo;");
                return;
            }
        }
        CREATOR = new a();
    }

    public AdResponseInfo(String str) {
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
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mAdsNum = jSONObject.optInt("n", 0);
            this.mRequestId = jSONObject.optString("req_id");
            this.mErrorCode = jSONObject.optString("error_code", "");
            JSONArray jSONArray = jSONObject.getJSONArray("ad");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        this.mAdInstanceList.add(new AdElementInfo(jSONArray.getJSONObject(i3)));
                    } catch (Exception unused) {
                        this.mAdInstanceList = new ArrayList<>();
                    }
                }
            }
        } catch (Exception unused2) {
            this.mAdInstanceList = new ArrayList<>();
        }
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

    public ArrayList<AdElementInfo> getAdInstanceList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdInstanceList : (ArrayList) invokeV.objValue;
    }

    public int getAdsNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdsNum : invokeV.intValue;
    }

    public String getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mErrorCode : (String) invokeV.objValue;
    }

    public AdElementInfo getPrimaryAdInstanceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mAdInstanceList.size() > 0) {
                return this.mAdInstanceList.get(0);
            }
            return null;
        }
        return (AdElementInfo) invokeV.objValue;
    }

    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRequestId : (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeInt(this.mAdsNum);
            parcel.writeString(this.mRequestId);
            parcel.writeString(this.mErrorCode);
        }
    }

    public AdResponseInfo(String str, boolean z) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(Constants.KEYS.RET, "");
            this.mErrorCode = optString;
            if (TextUtils.equals(optString, "0") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.mRequestId = optJSONObject.optString("id");
                JSONArray optJSONArray = optJSONObject.optJSONArray("ads");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            this.mAdInstanceList.add(new AdElementInfo(optJSONObject2, z));
                        }
                    }
                }
            }
        } catch (Exception unused) {
            this.mAdInstanceList = new ArrayList<>();
        }
    }

    public AdResponseInfo(Parcel parcel) {
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
        this.mAdsNum = 0;
        this.mAdInstanceList = new ArrayList<>();
        this.mAdsNum = parcel.readInt();
        this.mRequestId = parcel.readString();
        this.mErrorCode = parcel.readString();
    }
}
