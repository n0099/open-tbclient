package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class PoiFilter implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private String f2875a;

    /* renamed from: b  reason: collision with root package name */
    private String f2876b;
    private String c;
    private String d;
    private String e;
    private static Map<SortName, String> f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f2877a;

        /* renamed from: b  reason: collision with root package name */
        private String f2878b;
        private String c;
        private String d;
        private String e;

        public Builder() {
            PoiFilter.f.put(SortName.HotelSortName.DEFAULT, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f.put(SortName.CaterSortName.DEFAULT, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
            PoiFilter.f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f.put(SortName.LifeSortName.DEFAULT, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
            PoiFilter.f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f2877a, this.f2878b, this.c, this.e, this.d);
        }

        public Builder industryType(IndustryType industryType) {
            switch (industryType) {
                case HOTEL:
                    this.f2877a = "hotel";
                    break;
                case CATER:
                    this.f2877a = "cater";
                    break;
                case LIFE:
                    this.f2877a = "life";
                    break;
                default:
                    this.f2877a = "";
                    break;
            }
            return this;
        }

        public Builder isDiscount(boolean z) {
            if (z) {
                this.e = "1";
            } else {
                this.e = "0";
            }
            return this;
        }

        public Builder isGroupon(boolean z) {
            if (z) {
                this.d = "1";
            } else {
                this.d = "0";
            }
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f2877a) && sortName != null) {
                this.f2878b = (String) PoiFilter.f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i) {
            this.c = i + "";
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public enum IndustryType {
        HOTEL,
        CATER,
        LIFE
    }

    /* loaded from: classes4.dex */
    public interface SortName {

        /* loaded from: classes4.dex */
        public enum CaterSortName implements SortName {
            DEFAULT,
            CATER_PRICE,
            CATER_DISTANCE,
            CATER_TASTE_RATING,
            CATER_OVERALL_RATING,
            CATER_SERVICE_RATING
        }

        /* loaded from: classes4.dex */
        public enum HotelSortName implements SortName {
            DEFAULT,
            HOTEL_PRICE,
            HOTEL_DISTANCE,
            HOTEL_TOTAL_SCORE,
            HOTEL_LEVEL,
            HOTEL_HEALTH_SCORE
        }

        /* loaded from: classes4.dex */
        public enum LifeSortName implements SortName {
            DEFAULT,
            PRICE,
            DISTANCE,
            LIFE_OVERALL_RATING,
            LIFE_COMMENT_RATING
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiFilter(Parcel parcel) {
        this.f2875a = "";
        this.f2876b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f2875a = parcel.readString();
        this.f2876b = parcel.readString();
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
    }

    PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f2875a = "";
        this.f2876b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f2875a = str;
        this.f2876b = str2;
        this.c = str3;
        this.e = str4;
        this.d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f2875a)) {
            sb.append("industry_type:");
            sb.append(this.f2875a);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f2876b)) {
            sb.append("sort_name:");
            sb.append(this.f2876b);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append("sort_rule:");
            sb.append(this.c);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.e)) {
            sb.append("discount:");
            sb.append(this.e);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.d)) {
            sb.append("groupon:");
            sb.append(this.d);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2875a);
        parcel.writeString(this.f2876b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
    }
}
