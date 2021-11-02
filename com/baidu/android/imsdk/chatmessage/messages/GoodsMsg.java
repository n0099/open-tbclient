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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GoodsMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<GoodsMsg> CREATOR;
    public static final String TAG = "GoodsMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mAllImgs;
    public double mCoupon;
    public String mEvent;
    public int mId;
    public String mImage;
    public String mJumpName;
    public String mOriginPrice;
    public double mPrice;
    public int mSales;
    public String mSchema;
    public String mShopName;
    public String mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1787496148, "Lcom/baidu/android/imsdk/chatmessage/messages/GoodsMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1787496148, "Lcom/baidu/android/imsdk/chatmessage/messages/GoodsMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GoodsMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GoodsMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GoodsMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new GoodsMsg(parcel) : (GoodsMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GoodsMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new GoodsMsg[i2] : (GoodsMsg[]) invokeI.objValue;
            }
        };
    }

    public GoodsMsg() {
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
        this.mSales = -1;
        this.mCoupon = -1.0d;
        this.mAllImgs = new ArrayList();
        setMsgType(29);
    }

    private double getCouponFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return -1.0d;
            }
            try {
                return new JSONObject(jSONObject.optString("coupons")).optDouble("salePrice", -1.0d);
            } catch (Exception unused) {
                return -1.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public List<String> getAllImgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAllImgs : (List) invokeV.objValue;
    }

    public double getCoupon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCoupon : invokeV.doubleValue;
    }

    public String getEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEvent : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mId : invokeV.intValue;
    }

    public String getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImage : (String) invokeV.objValue;
    }

    public String getJumpName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mJumpName : (String) invokeV.objValue;
    }

    public String getOriginPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOriginPrice : (String) invokeV.objValue;
    }

    public double getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPrice : invokeV.doubleValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "[好货来袭]" + this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public int getSales() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSales : invokeV.intValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSchema : (String) invokeV.objValue;
    }

    public String getShopName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mShopName : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                LogUtils.d(TAG, "parse goods msg " + getJsonContent());
                this.mTitle = jSONObject.getString("title");
                this.mImage = jSONObject.getString("image");
                this.mAllImgs.clear();
                this.mAllImgs.add(this.mImage);
                if (jSONObject.has("more_image")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("more_image");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.mAllImgs.add(jSONArray.getString(i2));
                    }
                }
                this.mPrice = jSONObject.getDouble("price");
                this.mSales = jSONObject.optInt("sales", -1);
                this.mCoupon = getCouponFromJson(jSONObject);
                this.mSchema = jSONObject.optString("slink", "");
                this.mShopName = jSONObject.optString("tp_name", "");
                this.mId = jSONObject.optInt("num_id");
                this.mJumpName = jSONObject.optString("des_source");
                this.mEvent = jSONObject.optString("event");
                this.mOriginPrice = jSONObject.optString("origin_price");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parseJsonString JSONException", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mImage);
            parcel.writeDouble(this.mPrice);
            parcel.writeInt(this.mSales);
            parcel.writeDouble(this.mCoupon);
            parcel.writeString(this.mSchema);
            parcel.writeString(this.mShopName);
            parcel.writeInt(this.mId);
            parcel.writeString(this.mJumpName);
            parcel.writeString(this.mEvent);
            parcel.writeString(this.mOriginPrice);
            parcel.writeList(this.mAllImgs);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSales = -1;
        this.mCoupon = -1.0d;
        this.mAllImgs = new ArrayList();
        this.mTitle = parcel.readString();
        this.mImage = parcel.readString();
        this.mPrice = parcel.readDouble();
        this.mSales = parcel.readInt();
        this.mCoupon = parcel.readDouble();
        this.mSchema = parcel.readString();
        this.mShopName = parcel.readString();
        this.mId = parcel.readInt();
        this.mJumpName = parcel.readString();
        this.mEvent = parcel.readString();
        this.mOriginPrice = parcel.readString();
        parcel.readList(this.mAllImgs, String.class.getClassLoader());
    }
}
