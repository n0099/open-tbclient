package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class PoiFilter implements Parcelable {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private static Map<SortName, String> f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new c();

    /* loaded from: classes6.dex */
    public static final class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;

        public Builder() {
            PoiFilter.f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_LEVEL, ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public PoiFilter build() {
            return new PoiFilter(this.a, this.b, this.c, this.e, this.d);
        }

        public Builder industryType(IndustryType industryType) {
            switch (industryType) {
                case HOTEL:
                    this.a = "hotel";
                    break;
                case CATER:
                    this.a = "cater";
                    break;
                case LIFE:
                    this.a = "life";
                    break;
                default:
                    this.a = "";
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
            if (!TextUtils.isEmpty(this.a) && sortName != null) {
                this.b = (String) PoiFilter.f.get(sortName);
            }
            return this;
        }

        public Builder sortRule(int i) {
            this.c = i + "";
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public enum IndustryType {
        HOTEL,
        CATER,
        LIFE
    }

    /* loaded from: classes6.dex */
    public interface SortName {

        /* loaded from: classes6.dex */
        public enum CaterSortName implements SortName {
            DEFAULT,
            CATER_PRICE,
            CATER_DISTANCE,
            CATER_TASTE_RATING,
            CATER_OVERALL_RATING,
            CATER_SERVICE_RATING
        }

        /* loaded from: classes6.dex */
        public enum HotelSortName implements SortName {
            DEFAULT,
            HOTEL_PRICE,
            HOTEL_DISTANCE,
            HOTEL_TOTAL_SCORE,
            HOTEL_LEVEL,
            HOTEL_HEALTH_SCORE
        }

        /* loaded from: classes6.dex */
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
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
    }

    PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.a = str;
        this.b = str2;
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
        if (!TextUtils.isEmpty(this.a)) {
            sb.append("industry_type:");
            sb.append(this.a);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append("sort_name:");
            sb.append(this.b);
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
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
    }
}
