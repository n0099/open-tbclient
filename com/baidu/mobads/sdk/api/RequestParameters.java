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
    public boolean customSize;
    public int downloadAppConfirmPolicy;
    public Map<String, String> extras;
    public int height;
    public final String mKeywords;
    public String mPlacementId;
    public int width;

    /* renamed from: com.baidu.mobads.sdk.api.RequestParameters$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int adsType;
        public boolean clickConfirm;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extras = new HashMap();
            this.adsType = 3;
            this.clickConfirm = false;
            this.width = 640;
            this.height = 480;
            this.downloadAppConfirmPolicy = 1;
            this.customSize = false;
        }

        public final Builder addExtra(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (ArticleInfo.PAGE_TITLE.equals(str)) {
                    this.extras.put("mpt", String.valueOf(1));
                }
                this.extras.put(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public final RequestParameters build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new RequestParameters(this, null) : (RequestParameters) invokeV.objValue;
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                if (z) {
                    downloadAppConfirmPolicy(2);
                } else {
                    downloadAppConfirmPolicy(3);
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final Builder downloadAppConfirmPolicy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.downloadAppConfirmPolicy = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.height = i2;
                this.customSize = true;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.width = i2;
                this.customSize = true;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public /* synthetic */ RequestParameters(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public int getAPPConfirmPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.downloadAppConfirmPolicy : invokeV.intValue;
    }

    public String getAdPlacementId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPlacementId : (String) invokeV.objValue;
    }

    public int getAdsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.adsType : invokeV.intValue;
    }

    public Map<String, String> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extras : (Map) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.height : invokeV.intValue;
    }

    public final String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mKeywords : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.width : invokeV.intValue;
    }

    public boolean isConfirmDownloading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.confirmDownloading : invokeV.booleanValue;
    }

    public boolean isCustomSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.customSize : invokeV.booleanValue;
    }

    public void setAdsType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.adsType = i2;
        }
    }

    public void setExtras(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            this.extras = map;
        }
    }

    public HashMap<String, Object> toHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public RequestParameters(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.width = 0;
        this.height = 0;
        this.mKeywords = builder.keywords;
        this.adsType = builder.adsType;
        this.width = builder.width;
        this.height = builder.height;
        this.customSize = builder.customSize;
        this.confirmDownloading = builder.clickConfirm;
        this.downloadAppConfirmPolicy = builder.downloadAppConfirmPolicy;
        setExtras(builder.extras);
    }
}
