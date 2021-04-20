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
    public String f7251a;

    /* renamed from: b  reason: collision with root package name */
    public String f7252b;

    /* renamed from: c  reason: collision with root package name */
    public String f7253c;

    /* renamed from: d  reason: collision with root package name */
    public String f7254d;

    /* renamed from: e  reason: collision with root package name */
    public String f7255e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f7250f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f7256a;

        /* renamed from: b  reason: collision with root package name */
        public String f7257b;

        /* renamed from: c  reason: collision with root package name */
        public String f7258c;

        /* renamed from: d  reason: collision with root package name */
        public String f7259d;

        /* renamed from: e  reason: collision with root package name */
        public String f7260e;

        public Builder() {
            PoiFilter.f7250f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7250f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7250f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7250f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7250f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7250f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7250f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7250f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7250f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7250f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7250f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7250f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7250f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7250f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7250f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7250f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7250f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7256a, this.f7257b, this.f7258c, this.f7260e, this.f7259d);
        }

        public Builder industryType(IndustryType industryType) {
            int i = d.f7277a[industryType.ordinal()];
            this.f7256a = i != 1 ? i != 2 ? i != 3 ? "" : "life" : "cater" : "hotel";
            return this;
        }

        public Builder isDiscount(boolean z) {
            this.f7260e = z ? "1" : "0";
            return this;
        }

        public Builder isGroupon(boolean z) {
            this.f7259d = z ? "1" : "0";
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f7256a) && sortName != null) {
                this.f7257b = (String) PoiFilter.f7250f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i) {
            this.f7258c = i + "";
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
        this.f7251a = "";
        this.f7252b = "";
        this.f7253c = "";
        this.f7254d = "";
        this.f7255e = "";
        this.f7251a = parcel.readString();
        this.f7252b = parcel.readString();
        this.f7253c = parcel.readString();
        this.f7255e = parcel.readString();
        this.f7254d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7251a = "";
        this.f7252b = "";
        this.f7253c = "";
        this.f7254d = "";
        this.f7255e = "";
        this.f7251a = str;
        this.f7252b = str2;
        this.f7253c = str3;
        this.f7255e = str4;
        this.f7254d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7251a)) {
            sb.append("industry_type:");
            sb.append(this.f7251a);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7252b)) {
            sb.append("sort_name:");
            sb.append(this.f7252b);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7253c)) {
            sb.append("sort_rule:");
            sb.append(this.f7253c);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7255e)) {
            sb.append("discount:");
            sb.append(this.f7255e);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7254d)) {
            sb.append("groupon:");
            sb.append(this.f7254d);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7251a);
        parcel.writeString(this.f7252b);
        parcel.writeString(this.f7253c);
        parcel.writeString(this.f7255e);
        parcel.writeString(this.f7254d);
    }
}
