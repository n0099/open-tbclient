package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build;
/* loaded from: classes2.dex */
public final class ConfigurationHelper {
    private static final a wn;

    /* loaded from: classes2.dex */
    private interface a {
        int getDensityDpi(Resources resources);

        int getScreenHeightDp(Resources resources);

        int getScreenWidthDp(Resources resources);

        int getSmallestScreenWidthDp(Resources resources);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            wn = new d();
        } else if (i >= 13) {
            wn = new c();
        } else {
            wn = new b();
        }
    }

    private ConfigurationHelper() {
    }

    /* loaded from: classes2.dex */
    private static class b implements a {
        b() {
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.a
        public int getScreenHeightDp(Resources resources) {
            return android.support.v4.content.res.a.getScreenHeightDp(resources);
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.a
        public int getScreenWidthDp(Resources resources) {
            return android.support.v4.content.res.a.getScreenWidthDp(resources);
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.a
        public int getSmallestScreenWidthDp(Resources resources) {
            return android.support.v4.content.res.a.getSmallestScreenWidthDp(resources);
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.a
        public int getDensityDpi(Resources resources) {
            return android.support.v4.content.res.a.getDensityDpi(resources);
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends b {
        c() {
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.b, android.support.v4.content.res.ConfigurationHelper.a
        public int getScreenHeightDp(Resources resources) {
            return android.support.v4.content.res.b.getScreenHeightDp(resources);
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.b, android.support.v4.content.res.ConfigurationHelper.a
        public int getScreenWidthDp(Resources resources) {
            return android.support.v4.content.res.b.getScreenWidthDp(resources);
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.b, android.support.v4.content.res.ConfigurationHelper.a
        public int getSmallestScreenWidthDp(Resources resources) {
            return android.support.v4.content.res.b.getSmallestScreenWidthDp(resources);
        }
    }

    /* loaded from: classes2.dex */
    private static class d extends c {
        d() {
        }

        @Override // android.support.v4.content.res.ConfigurationHelper.b, android.support.v4.content.res.ConfigurationHelper.a
        public int getDensityDpi(Resources resources) {
            return android.support.v4.content.res.c.getDensityDpi(resources);
        }
    }

    public static int getScreenHeightDp(Resources resources) {
        return wn.getScreenHeightDp(resources);
    }

    public static int getScreenWidthDp(Resources resources) {
        return wn.getScreenWidthDp(resources);
    }

    public static int getSmallestScreenWidthDp(Resources resources) {
        return wn.getSmallestScreenWidthDp(resources);
    }

    public static int getDensityDpi(Resources resources) {
        return wn.getDensityDpi(resources);
    }
}
