package com.baidu.location;
/* loaded from: classes2.dex */
public final class Address {
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

    /* loaded from: classes2.dex */
    public static class Builder {
        public static final String BEI_JING = "北京";
        public static final String CHONG_QIN = "重庆";
        public static final String SHANG_HAI = "上海";
        public static final String TIAN_JIN = "天津";
        public String mCountry = null;
        public String mCountryCode = null;
        public String mProvince = null;
        public String mCity = null;
        public String mCityCode = null;
        public String mDistrict = null;
        public String mStreet = null;
        public String mStreetNumber = null;
        public String mAddress = null;
        public String mAdcode = null;

        public Builder adcode(String str) {
            this.mAdcode = str;
            return this;
        }

        public Address build() {
            String str;
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
            return new Address(this);
        }

        public Builder city(String str) {
            this.mCity = str;
            return this;
        }

        public Builder cityCode(String str) {
            this.mCityCode = str;
            return this;
        }

        public Builder country(String str) {
            this.mCountry = str;
            return this;
        }

        public Builder countryCode(String str) {
            this.mCountryCode = str;
            return this;
        }

        public Builder district(String str) {
            this.mDistrict = str;
            return this;
        }

        public Builder province(String str) {
            this.mProvince = str;
            return this;
        }

        public Builder street(String str) {
            this.mStreet = str;
            return this;
        }

        public Builder streetNumber(String str) {
            this.mStreetNumber = str;
            return this;
        }
    }

    public Address(Builder builder) {
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
}
