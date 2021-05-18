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
    public String f7324a;

    /* renamed from: b  reason: collision with root package name */
    public String f7325b;

    /* renamed from: c  reason: collision with root package name */
    public String f7326c;

    /* renamed from: d  reason: collision with root package name */
    public String f7327d;

    /* renamed from: e  reason: collision with root package name */
    public String f7328e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<SortName, String> f7323f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f7329a;

        /* renamed from: b  reason: collision with root package name */
        public String f7330b;

        /* renamed from: c  reason: collision with root package name */
        public String f7331c;

        /* renamed from: d  reason: collision with root package name */
        public String f7332d;

        /* renamed from: e  reason: collision with root package name */
        public String f7333e;

        public Builder() {
            PoiFilter.f7323f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f7323f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f7323f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f7323f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f7323f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f7323f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f7323f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f7323f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f7323f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f7323f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f7323f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f7323f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f7323f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f7323f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f7323f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f7323f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f7323f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.f7329a, this.f7330b, this.f7331c, this.f7333e, this.f7332d);
        }

        public Builder industryType(IndustryType industryType) {
            int i2 = d.f7350a[industryType.ordinal()];
            this.f7329a = i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "life" : "cater" : "hotel";
            return this;
        }

        public Builder isDiscount(boolean z) {
            this.f7333e = z ? "1" : "0";
            return this;
        }

        public Builder isGroupon(boolean z) {
            this.f7332d = z ? "1" : "0";
            return this;
        }

        public Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f7329a) && sortName != null) {
                this.f7330b = (String) PoiFilter.f7323f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i2) {
            this.f7331c = i2 + "";
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
        this.f7324a = "";
        this.f7325b = "";
        this.f7326c = "";
        this.f7327d = "";
        this.f7328e = "";
        this.f7324a = parcel.readString();
        this.f7325b = parcel.readString();
        this.f7326c = parcel.readString();
        this.f7328e = parcel.readString();
        this.f7327d = parcel.readString();
    }

    public PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f7324a = "";
        this.f7325b = "";
        this.f7326c = "";
        this.f7327d = "";
        this.f7328e = "";
        this.f7324a = str;
        this.f7325b = str2;
        this.f7326c = str3;
        this.f7328e = str4;
        this.f7327d = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f7324a)) {
            sb.append("industry_type:");
            sb.append(this.f7324a);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7325b)) {
            sb.append("sort_name:");
            sb.append(this.f7325b);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7326c)) {
            sb.append("sort_rule:");
            sb.append(this.f7326c);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7328e)) {
            sb.append("discount:");
            sb.append(this.f7328e);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(this.f7327d)) {
            sb.append("groupon:");
            sb.append(this.f7327d);
            sb.append(FieldBuilder.SE);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7324a);
        parcel.writeString(this.f7325b);
        parcel.writeString(this.f7326c);
        parcel.writeString(this.f7328e);
        parcel.writeString(this.f7327d);
    }
}
