package com.baidu.location;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class Address {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String adcode;
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;

    /* renamed from: com.baidu.location.Address$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BEI_JING = "北京";
        public static final String CHONG_QIN = "重庆";
        public static final String SHANG_HAI = "上海";
        public static final String TIAN_JIN = "天津";
        public transient /* synthetic */ FieldHolder $fh;
        public String mAdcode;
        public String mAddress;
        public String mCity;
        public String mCityCode;
        public String mCountry;
        public String mCountryCode;
        public String mDistrict;
        public String mProvince;
        public String mStreet;
        public String mStreetNumber;

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
            this.mCountry = null;
            this.mCountryCode = null;
            this.mProvince = null;
            this.mCity = null;
            this.mCityCode = null;
            this.mDistrict = null;
            this.mStreet = null;
            this.mStreetNumber = null;
            this.mAddress = null;
            this.mAdcode = null;
        }

        public Builder adcode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.mAdcode = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Address build() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                String str2 = this.mCountry;
                if (str2 != null) {
                    stringBuffer.append(str2);
                }
                String str3 = this.mProvince;
                if (str3 != null) {
                    stringBuffer.append(str3);
                }
                String str4 = this.mProvince;
                if (str4 != null && (str = this.mCity) != null && !str4.equals(str)) {
                    stringBuffer.append(this.mCity);
                }
                String str5 = this.mDistrict;
                if (str5 != null) {
                    String str6 = this.mCity;
                    if (str6 != null) {
                        if (!str6.equals(str5)) {
                            str5 = this.mDistrict;
                        }
                    }
                    stringBuffer.append(str5);
                }
                String str7 = this.mStreet;
                if (str7 != null) {
                    stringBuffer.append(str7);
                }
                String str8 = this.mStreetNumber;
                if (str8 != null) {
                    stringBuffer.append(str8);
                }
                if (stringBuffer.length() > 0) {
                    this.mAddress = stringBuffer.toString();
                }
                return new Address(this, null);
            }
            return (Address) invokeV.objValue;
        }

        public Builder city(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mCity = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder cityCode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mCityCode = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder country(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mCountry = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder countryCode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mCountryCode = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder district(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.mDistrict = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder province(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.mProvince = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder street(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.mStreet = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder streetNumber(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.mStreetNumber = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public Address(Builder builder) {
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
        this.country = builder.mCountry;
        this.countryCode = builder.mCountryCode;
        this.province = builder.mProvince;
        this.city = builder.mCity;
        this.cityCode = builder.mCityCode;
        this.district = builder.mDistrict;
        this.street = builder.mStreet;
        this.streetNumber = builder.mStreetNumber;
        this.address = builder.mAddress;
        this.adcode = builder.mAdcode;
    }

    public /* synthetic */ Address(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
