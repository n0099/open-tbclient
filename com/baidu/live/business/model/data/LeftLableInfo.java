package com.baidu.live.business.model.data;

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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LeftLableInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LeftLableInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String cmd;
    public String dot;
    public String endColor;
    public String isShow;
    public String leftIcon;
    public String newText;
    public String prefix;
    public String rightIcon;
    public String startColor;
    public String text;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-346283661, "Lcom/baidu/live/business/model/data/LeftLableInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-346283661, "Lcom/baidu/live/business/model/data/LeftLableInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<LeftLableInfo>() { // from class: com.baidu.live.business.model.data.LeftLableInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LeftLableInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new LeftLableInfo(parcel) : (LeftLableInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LeftLableInfo[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new LeftLableInfo[i] : (LeftLableInfo[]) invokeI.objValue;
            }
        };
    }

    public LeftLableInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean canShowLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "1".equals(this.isShow) && !TextUtils.isEmpty(this.text) : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isRankTopStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (!"1".equals(this.isShow) || TextUtils.isEmpty(this.prefix) || TextUtils.isEmpty(this.newText)) ? false : true : invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.text = jSONObject.optString("text");
        this.startColor = jSONObject.optString("start_color");
        this.endColor = jSONObject.optString("end_color");
        this.dot = jSONObject.optString("dot");
        this.isShow = jSONObject.optString("is_show");
        this.leftIcon = jSONObject.optString("left_icon");
        this.rightIcon = jSONObject.optString("right_icon");
        this.cmd = jSONObject.optString("url");
        this.prefix = jSONObject.optString("prefix");
        this.newText = jSONObject.optString("new_text");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
            parcel.writeString(this.text);
            parcel.writeString(this.startColor);
            parcel.writeString(this.endColor);
            parcel.writeString(this.dot);
            parcel.writeString(this.isShow);
            parcel.writeString(this.leftIcon);
            parcel.writeString(this.rightIcon);
            parcel.writeString(this.cmd);
        }
    }

    public LeftLableInfo(Parcel parcel) {
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
        this.text = parcel.readString();
        this.startColor = parcel.readString();
        this.endColor = parcel.readString();
        this.dot = parcel.readString();
        this.isShow = parcel.readString();
        this.leftIcon = parcel.readString();
        this.rightIcon = parcel.readString();
    }
}
