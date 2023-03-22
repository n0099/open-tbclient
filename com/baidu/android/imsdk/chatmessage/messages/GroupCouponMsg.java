package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
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
/* loaded from: classes.dex */
public class GroupCouponMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<GroupCouponMsg> CREATOR;
    public static final String TAG = "GroupCouponMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public Bottom mBottom;
    public String mBuid;
    public List<Coupon> mCoupons;
    public String mProductTitle;
    public List<Product> mProducts;
    public String mTitle;

    /* loaded from: classes.dex */
    public static class Bottom implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Bottom> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDescription;
        public String mLinkAddr;
        public int mLinkType;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-140671644, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Bottom;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-140671644, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Bottom;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Bottom>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupCouponMsg.Bottom.1
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
                public Bottom createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Bottom(parcel);
                    }
                    return (Bottom) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Bottom[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Bottom[i];
                    }
                    return (Bottom[]) invokeI.objValue;
                }
            };
        }

        public Bottom() {
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

        public Bottom(Parcel parcel) {
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
            this.mDescription = parcel.readString();
            this.mLinkType = parcel.readInt();
            this.mLinkAddr = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeString(this.mDescription);
                parcel.writeInt(this.mLinkType);
                parcel.writeString(this.mLinkAddr);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Coupon implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<Coupon> CREATOR;
        public static final int STATUS_EXPIRE = 3;
        public static final int STATUS_INITIAL = 1;
        public static final int STATUS_OBTAINED = 2;
        public static final int TYPE_DISCOUNT = 2;
        public static final int TYPE_MONEY = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCouponBatchId;
        public int mCouponLimitApp;
        public String mCouponName;
        public int mCouponSendBizType;
        public int mCouponTakeId;
        public String mDiscountCondition;
        public String mDiscountEndTime;
        public int mDiscountType;
        public String mDiscountValue;
        public int mStatus;
        public String mStatusContent;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(747636425, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Coupon;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(747636425, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Coupon;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Coupon>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupCouponMsg.Coupon.1
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
                public Coupon createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Coupon(parcel);
                    }
                    return (Coupon) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Coupon[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Coupon[i];
                    }
                    return (Coupon[]) invokeI.objValue;
                }
            };
        }

        public Coupon() {
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

        public Coupon(Parcel parcel) {
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
            this.mCouponName = parcel.readString();
            this.mDiscountType = parcel.readInt();
            this.mDiscountValue = parcel.readString();
            this.mDiscountCondition = parcel.readString();
            this.mDiscountEndTime = parcel.readString();
            this.mCouponBatchId = parcel.readString();
            this.mCouponSendBizType = parcel.readInt();
            this.mCouponLimitApp = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.mCouponTakeId = parcel.readInt();
            this.mStatusContent = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeString(this.mCouponName);
                parcel.writeInt(this.mDiscountType);
                parcel.writeString(this.mDiscountValue);
                parcel.writeString(this.mDiscountCondition);
                parcel.writeString(this.mDiscountEndTime);
                parcel.writeString(this.mCouponBatchId);
                parcel.writeInt(this.mCouponSendBizType);
                parcel.writeInt(this.mCouponLimitApp);
                parcel.writeInt(this.mStatus);
                parcel.writeInt(this.mCouponTakeId);
                parcel.writeString(this.mStatusContent);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Product implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Product> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDescription;
        public String mDiscountPrice;
        public String mImg;
        public String mLinkAddr;
        public int mLinkType;
        public String mOriginalPrice;
        public List<String> mTags;
        public String mTitle;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1068447160, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Product;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1068447160, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg$Product;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Product>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupCouponMsg.Product.1
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
                public Product createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Product(parcel);
                    }
                    return (Product) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Product[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Product[i];
                    }
                    return (Product[]) invokeI.objValue;
                }
            };
        }

        public Product() {
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
            this.mTags = new ArrayList();
        }

        public Product(Parcel parcel) {
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
            this.mTags = new ArrayList();
            this.mImg = parcel.readString();
            this.mTitle = parcel.readString();
            this.mDescription = parcel.readString();
            this.mTags = parcel.createStringArrayList();
            this.mDiscountPrice = parcel.readString();
            this.mOriginalPrice = parcel.readString();
            this.mLinkType = parcel.readInt();
            this.mLinkAddr = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeString(this.mImg);
                parcel.writeString(this.mTitle);
                parcel.writeString(this.mDescription);
                parcel.writeStringList(this.mTags);
                parcel.writeString(this.mDiscountPrice);
                parcel.writeString(this.mOriginalPrice);
                parcel.writeInt(this.mLinkType);
                parcel.writeString(this.mLinkAddr);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035349123, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035349123, "Lcom/baidu/android/imsdk/chatmessage/messages/GroupCouponMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GroupCouponMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupCouponMsg.1
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
            public GroupCouponMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GroupCouponMsg(parcel);
                }
                return (GroupCouponMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupCouponMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GroupCouponMsg[i];
                }
                return (GroupCouponMsg[]) invokeI.objValue;
            }
        };
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.mTitle;
            if (TextUtils.isEmpty(str) && !this.mCoupons.isEmpty()) {
                return this.mCoupons.get(0).mCouponName;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public GroupCouponMsg() {
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
        this.mCoupons = new ArrayList();
        this.mProducts = new ArrayList();
        setMsgType(60);
        setCategory(1);
        setChatType(57);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCouponMsg(Parcel parcel) {
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
        this.mCoupons = new ArrayList();
        this.mProducts = new ArrayList();
        this.mBuid = parcel.readString();
        this.mTitle = parcel.readString();
        this.mProductTitle = parcel.readString();
        this.mCoupons = parcel.createTypedArrayList(Coupon.CREATOR);
        this.mProducts = parcel.createTypedArrayList(Product.CREATOR);
        this.mBottom = (Bottom) parcel.readParcelable(Bottom.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String jsonContent = getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mBuid = jSONObject.optString("buid");
                this.mTitle = jSONObject.optString("title");
                this.mProductTitle = jSONObject.optString("product_description");
                JSONArray optJSONArray = jSONObject.optJSONArray("coupons");
                this.mCoupons.clear();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            Coupon coupon = new Coupon();
                            coupon.mCouponName = optJSONObject.optString("coupon_name");
                            coupon.mDiscountType = optJSONObject.optInt("discount_type");
                            coupon.mDiscountValue = optJSONObject.optString("discount_value");
                            coupon.mDiscountCondition = optJSONObject.optString("discount_condition");
                            coupon.mDiscountEndTime = optJSONObject.optString("discount_end_time");
                            coupon.mCouponBatchId = optJSONObject.optString("coupon_batch_id");
                            coupon.mCouponSendBizType = optJSONObject.optInt("coupon_send_biz_type");
                            coupon.mCouponLimitApp = optJSONObject.optInt("coupon_limit_app");
                            coupon.mStatus = optJSONObject.optInt("status");
                            coupon.mCouponTakeId = optJSONObject.optInt("coupon_take_id");
                            coupon.mStatusContent = optJSONObject.optString("coupon_content");
                            this.mCoupons.add(coupon);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("products");
                this.mProducts.clear();
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            Product product = new Product();
                            product.mImg = optJSONObject2.optString("img");
                            product.mTitle = optJSONObject2.optString("title");
                            product.mDescription = optJSONObject2.optString("description");
                            product.mDiscountPrice = optJSONObject2.optString("discount_price");
                            product.mOriginalPrice = optJSONObject2.optString("original_price");
                            product.mLinkType = optJSONObject2.optInt("link_type");
                            product.mLinkAddr = optJSONObject2.optString("link_addr");
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("discount_tag");
                            if (optJSONArray3 != null) {
                                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                    String optString = optJSONArray3.optString(i3);
                                    if (!TextUtils.isEmpty(optString)) {
                                        product.mTags.add(optString);
                                    }
                                }
                            }
                            this.mProducts.add(product);
                        }
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("bottom");
                if (optJSONObject3 != null) {
                    Bottom bottom = new Bottom();
                    this.mBottom = bottom;
                    bottom.mDescription = optJSONObject3.optString("description");
                    this.mBottom.mLinkType = optJSONObject3.optInt("link_type");
                    this.mBottom.mLinkAddr = optJSONObject3.optString("link_addr");
                }
                return true;
            } catch (JSONException e) {
                LogUtils.e(TAG, "parse json err!", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mBuid);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mProductTitle);
            parcel.writeTypedList(this.mCoupons);
            parcel.writeTypedList(this.mProducts);
            parcel.writeParcelable(this.mBottom, i);
        }
    }
}
