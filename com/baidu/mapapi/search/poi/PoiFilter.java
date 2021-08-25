package com.baidu.mapapi.search.poi;

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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PoiFilter implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiFilter> CREATOR;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f41705f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41706a;

    /* renamed from: b  reason: collision with root package name */
    public String f41707b;

    /* renamed from: c  reason: collision with root package name */
    public String f41708c;

    /* renamed from: d  reason: collision with root package name */
    public String f41709d;

    /* renamed from: e  reason: collision with root package name */
    public String f41710e;

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41711a;

        /* renamed from: b  reason: collision with root package name */
        public String f41712b;

        /* renamed from: c  reason: collision with root package name */
        public String f41713c;

        /* renamed from: d  reason: collision with root package name */
        public String f41714d;

        /* renamed from: e  reason: collision with root package name */
        public String f41715e;

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
            PoiFilter.f41705f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f41705f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f41705f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f41705f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f41705f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f41705f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f41705f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f41705f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f41705f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f41705f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f41705f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f41705f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f41705f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f41705f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f41705f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f41705f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f41705f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PoiFilter(this.f41711a, this.f41712b, this.f41713c, this.f41715e, this.f41714d) : (PoiFilter) invokeV.objValue;
        }

        public Builder industryType(IndustryType industryType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, industryType)) == null) {
                int i2 = d.f41732a[industryType.ordinal()];
                this.f41711a = i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "life" : "cater" : "hotel";
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder isDiscount(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f41715e = z ? "1" : "0";
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder isGroupon(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.f41714d = z ? "1" : "0";
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder sortName(SortName sortName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sortName)) == null) {
                if (!TextUtils.isEmpty(this.f41711a) && sortName != null) {
                    this.f41712b = (String) PoiFilter.f41705f.get(sortName);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sortRule(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f41713c = i2 + "";
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class IndustryType {
        public static /* synthetic */ Interceptable $ic;
        public static final IndustryType CATER;
        public static final IndustryType HOTEL;
        public static final IndustryType LIFE;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ IndustryType[] f41716a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(771085944, "Lcom/baidu/mapapi/search/poi/PoiFilter$IndustryType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(771085944, "Lcom/baidu/mapapi/search/poi/PoiFilter$IndustryType;");
                    return;
                }
            }
            HOTEL = new IndustryType("HOTEL", 0);
            CATER = new IndustryType("CATER", 1);
            IndustryType industryType = new IndustryType("LIFE", 2);
            LIFE = industryType;
            f41716a = new IndustryType[]{HOTEL, CATER, industryType};
        }

        public IndustryType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static IndustryType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IndustryType) Enum.valueOf(IndustryType.class, str) : (IndustryType) invokeL.objValue;
        }

        public static IndustryType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IndustryType[]) f41716a.clone() : (IndustryType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface SortName {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
        public static final class CaterSortName implements SortName {
            public static /* synthetic */ Interceptable $ic;
            public static final CaterSortName CATER_DISTANCE;
            public static final CaterSortName CATER_OVERALL_RATING;
            public static final CaterSortName CATER_PRICE;
            public static final CaterSortName CATER_SERVICE_RATING;
            public static final CaterSortName CATER_TASTE_RATING;
            public static final CaterSortName DEFAULT;

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ CaterSortName[] f41717a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1378438239, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$CaterSortName;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1378438239, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$CaterSortName;");
                        return;
                    }
                }
                DEFAULT = new CaterSortName("DEFAULT", 0);
                CATER_PRICE = new CaterSortName("CATER_PRICE", 1);
                CATER_DISTANCE = new CaterSortName("CATER_DISTANCE", 2);
                CATER_TASTE_RATING = new CaterSortName("CATER_TASTE_RATING", 3);
                CATER_OVERALL_RATING = new CaterSortName("CATER_OVERALL_RATING", 4);
                CaterSortName caterSortName = new CaterSortName("CATER_SERVICE_RATING", 5);
                CATER_SERVICE_RATING = caterSortName;
                f41717a = new CaterSortName[]{DEFAULT, CATER_PRICE, CATER_DISTANCE, CATER_TASTE_RATING, CATER_OVERALL_RATING, caterSortName};
            }

            public CaterSortName(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static CaterSortName valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CaterSortName) Enum.valueOf(CaterSortName.class, str) : (CaterSortName) invokeL.objValue;
            }

            public static CaterSortName[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CaterSortName[]) f41717a.clone() : (CaterSortName[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
        public static final class HotelSortName implements SortName {
            public static /* synthetic */ Interceptable $ic;
            public static final HotelSortName DEFAULT;
            public static final HotelSortName HOTEL_DISTANCE;
            public static final HotelSortName HOTEL_HEALTH_SCORE;
            public static final HotelSortName HOTEL_LEVEL;
            public static final HotelSortName HOTEL_PRICE;
            public static final HotelSortName HOTEL_TOTAL_SCORE;

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ HotelSortName[] f41718a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(217051342, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$HotelSortName;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(217051342, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$HotelSortName;");
                        return;
                    }
                }
                DEFAULT = new HotelSortName("DEFAULT", 0);
                HOTEL_PRICE = new HotelSortName("HOTEL_PRICE", 1);
                HOTEL_DISTANCE = new HotelSortName("HOTEL_DISTANCE", 2);
                HOTEL_TOTAL_SCORE = new HotelSortName("HOTEL_TOTAL_SCORE", 3);
                HOTEL_LEVEL = new HotelSortName("HOTEL_LEVEL", 4);
                HotelSortName hotelSortName = new HotelSortName("HOTEL_HEALTH_SCORE", 5);
                HOTEL_HEALTH_SCORE = hotelSortName;
                f41718a = new HotelSortName[]{DEFAULT, HOTEL_PRICE, HOTEL_DISTANCE, HOTEL_TOTAL_SCORE, HOTEL_LEVEL, hotelSortName};
            }

            public HotelSortName(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static HotelSortName valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HotelSortName) Enum.valueOf(HotelSortName.class, str) : (HotelSortName) invokeL.objValue;
            }

            public static HotelSortName[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HotelSortName[]) f41718a.clone() : (HotelSortName[]) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
        public static final class LifeSortName implements SortName {
            public static /* synthetic */ Interceptable $ic;
            public static final LifeSortName DEFAULT;
            public static final LifeSortName DISTANCE;
            public static final LifeSortName LIFE_COMMENT_RATING;
            public static final LifeSortName LIFE_OVERALL_RATING;
            public static final LifeSortName PRICE;

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ LifeSortName[] f41719a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1758041498, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$LifeSortName;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1758041498, "Lcom/baidu/mapapi/search/poi/PoiFilter$SortName$LifeSortName;");
                        return;
                    }
                }
                DEFAULT = new LifeSortName("DEFAULT", 0);
                PRICE = new LifeSortName("PRICE", 1);
                DISTANCE = new LifeSortName("DISTANCE", 2);
                LIFE_OVERALL_RATING = new LifeSortName("LIFE_OVERALL_RATING", 3);
                LifeSortName lifeSortName = new LifeSortName("LIFE_COMMENT_RATING", 4);
                LIFE_COMMENT_RATING = lifeSortName;
                f41719a = new LifeSortName[]{DEFAULT, PRICE, DISTANCE, LIFE_OVERALL_RATING, lifeSortName};
            }

            public LifeSortName(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static LifeSortName valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LifeSortName) Enum.valueOf(LifeSortName.class, str) : (LifeSortName) invokeL.objValue;
            }

            public static LifeSortName[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LifeSortName[]) f41719a.clone() : (LifeSortName[]) invokeV.objValue;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1176531870, "Lcom/baidu/mapapi/search/poi/PoiFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1176531870, "Lcom/baidu/mapapi/search/poi/PoiFilter;");
                return;
            }
        }
        f41705f = new HashMap();
        CREATOR = new c();
    }

    public PoiFilter(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41706a = "";
        this.f41707b = "";
        this.f41708c = "";
        this.f41709d = "";
        this.f41710e = "";
        this.f41706a = parcel.readString();
        this.f41707b = parcel.readString();
        this.f41708c = parcel.readString();
        this.f41710e = parcel.readString();
        this.f41709d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41706a = "";
        this.f41707b = "";
        this.f41708c = "";
        this.f41709d = "";
        this.f41710e = "";
        this.f41706a = str;
        this.f41707b = str2;
        this.f41708c = str3;
        this.f41710e = str4;
        this.f41709d = str5;
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f41706a)) {
                sb.append("industry_type:");
                sb.append(this.f41706a);
                sb.append("|");
            }
            if (!TextUtils.isEmpty(this.f41707b)) {
                sb.append("sort_name:");
                sb.append(this.f41707b);
                sb.append("|");
            }
            if (!TextUtils.isEmpty(this.f41708c)) {
                sb.append("sort_rule:");
                sb.append(this.f41708c);
                sb.append("|");
            }
            if (!TextUtils.isEmpty(this.f41710e)) {
                sb.append("discount:");
                sb.append(this.f41710e);
                sb.append("|");
            }
            if (!TextUtils.isEmpty(this.f41709d)) {
                sb.append("groupon:");
                sb.append(this.f41709d);
                sb.append("|");
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            parcel.writeString(this.f41706a);
            parcel.writeString(this.f41707b);
            parcel.writeString(this.f41708c);
            parcel.writeString(this.f41710e);
            parcel.writeString(this.f41709d);
        }
    }
}
