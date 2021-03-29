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
    public String f7216a;

    /* renamed from: b  reason: collision with root package name */
    public String f7217b;

    /* renamed from: c  reason: collision with root package name */
    public String f7218c;

    /* renamed from: d  reason: collision with root package name */
    public String f7219d;

    /* renamed from: e  reason: collision with root package name */
    public String f7220e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f7215f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f7221a;

        /* renamed from: b  reason: collision with root package name */
        public String f7222b;

        /* renamed from: c  reason: collision with root package name */
        public String f7223c;

        /* renamed from: d  reason: collision with root package name */
        public String f7224d;

        /* renamed from: e  reason: collision with root package name */
        public String f7225e;

        public Builder() {
            PoiFilter.f7215f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7215f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7215f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7215f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7215f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7215f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7215f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7215f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7215f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7215f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7215f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7215f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7215f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7215f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7215f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7215f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7215f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7221a, this.f7222b, this.f7223c, this.f7225e, this.f7224d);
        }

        public Builder industryType(IndustryType industryType) {
            int i = d.f7242a[industryType.ordinal()];
            this.f7221a = i != 1 ? i != 2 ? i != 3 ? "" : "life" : "cater" : "hotel";
            return this;
        }

        public Builder isDiscount(boolean z) {
            this.f7225e = z ? "1" : "0";
            return this;
        }

        public Builder isGroupon(boolean z) {
            this.f7224d = z ? "1" : "0";
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f7221a) && sortName != null) {
                this.f7222b = (String) PoiFilter.f7215f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i) {
            this.f7223c = i + "";
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
        this.f7216a = "";
        this.f7217b = "";
        this.f7218c = "";
        this.f7219d = "";
        this.f7220e = "";
        this.f7216a = parcel.readString();
        this.f7217b = parcel.readString();
        this.f7218c = parcel.readString();
        this.f7220e = parcel.readString();
        this.f7219d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7216a = "";
        this.f7217b = "";
        this.f7218c = "";
        this.f7219d = "";
        this.f7220e = "";
        this.f7216a = str;
        this.f7217b = str2;
        this.f7218c = str3;
        this.f7220e = str4;
        this.f7219d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7216a)) {
            sb.append("industry_type:");
            sb.append(this.f7216a);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7217b)) {
            sb.append("sort_name:");
            sb.append(this.f7217b);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7218c)) {
            sb.append("sort_rule:");
            sb.append(this.f7218c);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7220e)) {
            sb.append("discount:");
            sb.append(this.f7220e);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7219d)) {
            sb.append("groupon:");
            sb.append(this.f7219d);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7216a);
        parcel.writeString(this.f7217b);
        parcel.writeString(this.f7218c);
        parcel.writeString(this.f7220e);
        parcel.writeString(this.f7219d);
    }
}
