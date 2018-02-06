package android.support.v4.media;

import android.media.Rating;
/* loaded from: classes2.dex */
class f {
    public static Object ai(int i) {
        return Rating.newUnratedRating(i);
    }

    public static Object v(boolean z) {
        return Rating.newHeartRating(z);
    }

    public static Object w(boolean z) {
        return Rating.newThumbRating(z);
    }

    public static Object e(int i, float f) {
        return Rating.newStarRating(i, f);
    }

    public static Object r(float f) {
        return Rating.newPercentageRating(f);
    }

    public static boolean A(Object obj) {
        return ((Rating) obj).isRated();
    }

    public static int B(Object obj) {
        return ((Rating) obj).getRatingStyle();
    }

    public static boolean C(Object obj) {
        return ((Rating) obj).hasHeart();
    }

    public static boolean D(Object obj) {
        return ((Rating) obj).isThumbUp();
    }

    public static float E(Object obj) {
        return ((Rating) obj).getStarRating();
    }

    public static float F(Object obj) {
        return ((Rating) obj).getPercentRating();
    }
}
