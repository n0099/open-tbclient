package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: h */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ah */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private Object yA;
    private final int yy;
    private final float yz;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface Style {
    }

    RatingCompat(int i, float f) {
        this.yy = i;
        this.yz = f;
    }

    public String toString() {
        return "Rating:style=" + this.yy + " rating=" + (this.yz < 0.0f ? "unrated" : String.valueOf(this.yz));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.yy;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.yy);
        parcel.writeFloat(this.yz);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f < 0.0f || f > f2) {
            Log.e("Rating", "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(i, f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f < 0.0f || f > 100.0f) {
            Log.e("Rating", "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, f);
    }

    public boolean isRated() {
        return this.yz >= 0.0f;
    }

    public int getRatingStyle() {
        return this.yy;
    }

    public boolean hasHeart() {
        if (this.yy != 1) {
            return false;
        }
        return this.yz == 1.0f;
    }

    public boolean isThumbUp() {
        return this.yy == 2 && this.yz == 1.0f;
    }

    public float getStarRating() {
        switch (this.yy) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.yz;
                }
                break;
        }
        return -1.0f;
    }

    public float getPercentRating() {
        if (this.yy == 6 && isRated()) {
            return this.yz;
        }
        return -1.0f;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && Build.VERSION.SDK_INT >= 19) {
            int B = f.B(obj);
            if (f.A(obj)) {
                switch (B) {
                    case 1:
                        ratingCompat = newHeartRating(f.C(obj));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(f.D(obj));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(B, f.E(obj));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(f.F(obj));
                        break;
                }
            } else {
                ratingCompat = newUnratedRating(B);
            }
            ratingCompat.yA = obj;
        }
        return ratingCompat;
    }

    public Object getRating() {
        if (this.yA != null || Build.VERSION.SDK_INT < 19) {
            return this.yA;
        }
        if (isRated()) {
            switch (this.yy) {
                case 1:
                    this.yA = f.t(hasHeart());
                    break;
                case 2:
                    this.yA = f.u(isThumbUp());
                    break;
                case 3:
                case 4:
                case 5:
                    this.yA = f.e(this.yy, getStarRating());
                    break;
                case 6:
                    this.yA = f.n(getPercentRating());
                    return null;
                default:
                    return null;
            }
        } else {
            this.yA = f.ai(this.yy);
        }
        return this.yA;
    }
}
