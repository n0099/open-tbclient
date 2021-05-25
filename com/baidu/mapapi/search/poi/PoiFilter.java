package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PoiFilter implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public String f7224a;

    /* renamed from: b  reason: collision with root package name */
    public String f7225b;

    /* renamed from: c  reason: collision with root package name */
    public String f7226c;

    /* renamed from: d  reason: collision with root package name */
    public String f7227d;

    /* renamed from: e  reason: collision with root package name */
    public String f7228e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f7223f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f7229a;

        /* renamed from: b  reason: collision with root package name */
        public String f7230b;

        /* renamed from: c  reason: collision with root package name */
        public String f7231c;

        /* renamed from: d  reason: collision with root package name */
        public String f7232d;

        /* renamed from: e  reason: collision with root package name */
        public String f7233e;

        public Builder() {
            PoiFilter.f7223f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7223f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7223f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7223f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7223f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7223f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7223f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7223f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7223f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7223f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7223f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7223f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7223f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7223f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7223f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7223f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7223f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7229a, this.f7230b, this.f7231c, this.f7233e, this.f7232d);
        }

        public Builder industryType(IndustryType industryType) {
            int i2 = d.f7250a[industryType.ordinal()];
            this.f7229a = i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "life" : "cater" : "hotel";
            return this;
        }

        public Builder isDiscount(boolean z) {
            this.f7233e = z ? "1" : "0";
            return this;
        }

        public Builder isGroupon(boolean z) {
            this.f7232d = z ? "1" : "0";
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f7229a) && sortName != null) {
                this.f7230b = (String) PoiFilter.f7223f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i2) {
            this.f7231c = i2 + "";
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
        this.f7224a = "";
        this.f7225b = "";
        this.f7226c = "";
        this.f7227d = "";
        this.f7228e = "";
        this.f7224a = parcel.readString();
        this.f7225b = parcel.readString();
        this.f7226c = parcel.readString();
        this.f7228e = parcel.readString();
        this.f7227d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7224a = "";
        this.f7225b = "";
        this.f7226c = "";
        this.f7227d = "";
        this.f7228e = "";
        this.f7224a = str;
        this.f7225b = str2;
        this.f7226c = str3;
        this.f7228e = str4;
        this.f7227d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7224a)) {
            sb.append("industry_type:");
            sb.append(this.f7224a);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7225b)) {
            sb.append("sort_name:");
            sb.append(this.f7225b);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7226c)) {
            sb.append("sort_rule:");
            sb.append(this.f7226c);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7228e)) {
            sb.append("discount:");
            sb.append(this.f7228e);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7227d)) {
            sb.append("groupon:");
            sb.append(this.f7227d);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7224a);
        parcel.writeString(this.f7225b);
        parcel.writeString(this.f7226c);
        parcel.writeString(this.f7228e);
        parcel.writeString(this.f7227d);
    }
}
