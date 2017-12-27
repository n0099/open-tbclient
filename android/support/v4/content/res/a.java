package android.support.v4.content.res;

import android.content.res.Resources;
import android.util.DisplayMetrics;
/* loaded from: classes2.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getScreenHeightDp(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (displayMetrics.heightPixels / displayMetrics.density);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getScreenWidthDp(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSmallestScreenWidthDp(Resources resources) {
        return Math.min(getScreenWidthDp(resources), getScreenHeightDp(resources));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDensityDpi(Resources resources) {
        return resources.getDisplayMetrics().densityDpi;
    }
}
