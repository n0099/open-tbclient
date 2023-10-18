package com.baidu.mobads.sdk.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class RequestParameters {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    public transient /* synthetic */ FieldHolder $fh;
    public int adsType;
    public boolean confirmDownloading;
    public Map<String, String> customExt;
    public boolean customSize;
    public int downloadAppConfirmPolicy;
    public Map<String, String> extras;
    public int height;
    public String mAdPlaceId;
    public int mBidFloor;
    public final String mKeywords;
    public int width;

    /* renamed from: com.baidu.mobads.sdk.api.RequestParameters$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String adPlaceId;
        public int adsType;
        public int bidFloor;
        public boolean clickConfirm;
        public Map<String, String> customExt;
        public boolean customSize;
        public int downloadAppConfirmPolicy;
        public Map<String, String> extras;
        public int height;
        public String keywords;
        public int width;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extras = new HashMap();
            this.customExt = new HashMap();
            this.adsType = 3;
            this.clickConfirm = false;
            this.width = 640;
            this.height = 480;
            this.downloadAppConfirmPolicy = 1;
            this.customSize = false;
            this.bidFloor = -1;
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                if (z) {
                    downloadAppConfirmPolicy(2);
                } else {
                    downloadAppConfirmPolicy(3);
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder downloadAppConfirmPolicy(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.downloadAppConfirmPolicy = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setAdPlaceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.adPlaceId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setBidFloor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.bidFloor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setHeight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.height = i;
                this.customSize = true;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setWidth(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.width = i;
                this.customSize = true;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder addCustExt(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.customExt.put(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public final Builder addExtra(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                this.extras.put(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public final RequestParameters build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new RequestParameters(this, null);
            }
            return (RequestParameters) invokeV.objValue;
        }
    }

    public RequestParameters(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.width = 0;
        this.height = 0;
        this.mBidFloor = -1;
        this.mKeywords = builder.keywords;
        this.adsType = builder.adsType;
        this.width = builder.width;
        this.height = builder.height;
        this.customSize = builder.customSize;
        this.confirmDownloading = builder.clickConfirm;
        this.downloadAppConfirmPolicy = builder.downloadAppConfirmPolicy;
        this.mAdPlaceId = builder.adPlaceId;
        this.mBidFloor = builder.bidFloor;
        setExtras(builder.extras);
        setExt(builder.customExt);
    }

    public /* synthetic */ RequestParameters(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public int getAPPConfirmPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.downloadAppConfirmPolicy;
        }
        return invokeV.intValue;
    }

    public String getAdPlacementId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAdPlaceId;
        }
        return (String) invokeV.objValue;
    }

    public int getAdsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.adsType;
        }
        return invokeV.intValue;
    }

    public int getBidFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBidFloor;
        }
        return invokeV.intValue;
    }

    public Map<String, String> getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.customExt;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, String> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.extras;
        }
        return (Map) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public final String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mKeywords;
        }
        return (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public boolean isConfirmDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.confirmDownloading;
        }
        return invokeV.booleanValue;
    }

    public boolean isCustomSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.customSize;
        }
        return invokeV.booleanValue;
    }

    public void setAdsType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.adsType = i;
        }
    }

    public void setExt(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            this.customExt = map;
        }
    }

    public void setExtras(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            this.extras = map;
        }
    }

    public HashMap<String, Object> toHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("mKeywords", this.mKeywords);
            hashMap.put("adsType", Integer.valueOf(this.adsType));
            hashMap.put("confirmDownloading", Boolean.valueOf(this.confirmDownloading));
            HashMap hashMap2 = new HashMap();
            Map<String, String> map = this.extras;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            hashMap.put("extras", hashMap2);
            HashMap hashMap3 = new HashMap();
            Map<String, String> map2 = this.customExt;
            if (map2 != null) {
                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                    hashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            hashMap.put("ext", hashMap3);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
