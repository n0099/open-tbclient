package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
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
/* loaded from: classes.dex */
public class ProductMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ProductMsg> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String mDesc;
    public String[] mDiscountInfo;
    public String mImg;
    public String mPrice;
    public String mProductId;
    public String mProductUrl;
    public String mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1675266323, "Lcom/baidu/android/imsdk/chatmessage/messages/ProductMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1675266323, "Lcom/baidu/android/imsdk/chatmessage/messages/ProductMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<ProductMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ProductMsg.1
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
            public ProductMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ProductMsg(parcel);
                }
                return (ProductMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ProductMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ProductMsg[i];
                }
                return (ProductMsg[]) invokeI.objValue;
            }
        };
    }

    public ProductMsg() {
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
        setMsgType(25);
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    public String[] getDiscountInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDiscountInfo;
        }
        return (String[]) invokeV.objValue;
    }

    public String getImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImg;
        }
        return (String) invokeV.objValue;
    }

    public String getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mPrice;
        }
        return (String) invokeV.objValue;
    }

    public String getProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mProductId;
        }
        return (String) invokeV.objValue;
    }

    public String getProductUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mProductUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImg = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mDiscountInfo = parcel.createStringArray();
        this.mPrice = parcel.readString();
        this.mProductUrl = parcel.readString();
        this.mProductId = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getMsgContent());
                this.mImg = jSONObject.optString("img");
                this.mTitle = jSONObject.optString("title");
                this.mDesc = jSONObject.optString("description");
                JSONArray optJSONArray = jSONObject.optJSONArray("discount_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.mDiscountInfo = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.mDiscountInfo[i] = (String) optJSONArray.get(i);
                    }
                }
                this.mPrice = jSONObject.optString("price");
                this.mProductUrl = jSONObject.optString("product_url");
                this.mProductId = jSONObject.optString("product_id");
                return true;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "parseJsonString", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mDesc = str;
        }
    }

    public void setDiscountInfo(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
            this.mDiscountInfo = strArr;
        }
    }

    public void setImg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mImg = str;
        }
    }

    public void setPrice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mPrice = str;
        }
    }

    public void setProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mProductId = str;
        }
    }

    public void setProductUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mProductUrl = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mTitle = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mImg);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDesc);
            parcel.writeStringArray(this.mDiscountInfo);
            parcel.writeString(this.mPrice);
            parcel.writeString(this.mProductUrl);
            parcel.writeString(this.mProductId);
        }
    }
}
