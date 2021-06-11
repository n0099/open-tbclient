package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PoiFilter implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public String f7267a;

    /* renamed from: b  reason: collision with root package name */
    public String f7268b;

    /* renamed from: c  reason: collision with root package name */
    public String f7269c;

    /* renamed from: d  reason: collision with root package name */
    public String f7270d;

    /* renamed from: e  reason: collision with root package name */
    public String f7271e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f7266f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f7272a;

        /* renamed from: b  reason: collision with root package name */
        public String f7273b;

        /* renamed from: c  reason: collision with root package name */
        public String f7274c;

        /* renamed from: d  reason: collision with root package name */
        public String f7275d;

        /* renamed from: e  reason: collision with root package name */
        public String f7276e;

        public Builder() {
            PoiFilter.f7266f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7266f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7266f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7266f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7266f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7266f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7266f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7266f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7266f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7266f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7266f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7266f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7266f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7266f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7266f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7266f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7266f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7272a, this.f7273b, this.f7274c, this.f7276e, this.f7275d);
        }

        public Builder industryType(IndustryType industryType) {
            int i2 = d.f7293a[industryType.ordinal()];
            this.f7272a = i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "life" : "cater" : "hotel";
            return this;
        }

        public Builder isDiscount(boolean z) {
            this.f7276e = z ? "1" : "0";
            return this;
        }

        public Builder isGroupon(boolean z) {
            this.f7275d = z ? "1" : "0";
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f7272a) && sortName != null) {
                this.f7273b = (String) PoiFilter.f7266f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i2) {
            this.f7274c = i2 + "";
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum IndustryType {
        HOTEL,
        CATER,
        LIFE
    }

    /* loaded from: classes2.dex */
    public interface SortName {

        /* loaded from: classes2.dex */
        public enum CaterSortName implements SortName {
            DEFAULT,
            CATER_PRICE,
            CATER_DISTANCE,
            CATER_TASTE_RATING,
            CATER_OVERALL_RATING,
            CATER_SERVICE_RATING
        }

        /* loaded from: classes2.dex */
        public enum HotelSortName implements SortName {
            DEFAULT,
            HOTEL_PRICE,
            HOTEL_DISTANCE,
            HOTEL_TOTAL_SCORE,
            HOTEL_LEVEL,
            HOTEL_HEALTH_SCORE
        }

        /* loaded from: classes2.dex */
        public enum LifeSortName implements SortName {
            DEFAULT,
            PRICE,
            DISTANCE,
            LIFE_OVERALL_RATING,
            LIFE_COMMENT_RATING
        }
    }

    public PoiFilter(Parcel parcel) {
        this.f7267a = "";
        this.f7268b = "";
        this.f7269c = "";
        this.f7270d = "";
        this.f7271e = "";
        this.f7267a = parcel.readString();
        this.f7268b = parcel.readString();
        this.f7269c = parcel.readString();
        this.f7271e = parcel.readString();
        this.f7270d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7267a = "";
        this.f7268b = "";
        this.f7269c = "";
        this.f7270d = "";
        this.f7271e = "";
        this.f7267a = str;
        this.f7268b = str2;
        this.f7269c = str3;
        this.f7271e = str4;
        this.f7270d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7267a)) {
            sb.append("industry_type:");
            sb.append(this.f7267a);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f7268b)) {
            sb.append("sort_name:");
            sb.append(this.f7268b);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f7269c)) {
            sb.append("sort_rule:");
            sb.append(this.f7269c);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f7271e)) {
            sb.append("discount:");
            sb.append(this.f7271e);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f7270d)) {
            sb.append("groupon:");
            sb.append(this.f7270d);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7267a);
        parcel.writeString(this.f7268b);
        parcel.writeString(this.f7269c);
        parcel.writeString(this.f7271e);
        parcel.writeString(this.f7270d);
    }
}
