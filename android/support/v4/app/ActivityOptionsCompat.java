package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;
/* loaded from: classes2.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(context, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(context, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(context, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(view, i, i2, i3, i4));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(view, i, i2, i3, i4));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(view, i, i2, i3, i4));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(view, i, i2, i3, i4));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(view, i, i2, i3, i4));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(view, i, i2, i3, i4));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(activity, view, str));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(activity, view, str));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, view, str));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        View[] viewArr;
        String[] strArr = null;
        if (Build.VERSION.SDK_INT >= 21) {
            if (pairArr != null) {
                View[] viewArr2 = new View[pairArr.length];
                String[] strArr2 = new String[pairArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= pairArr.length) {
                        break;
                    }
                    viewArr2[i2] = pairArr[i2].first;
                    strArr2[i2] = pairArr[i2].second;
                    i = i2 + 1;
                }
                strArr = strArr2;
                viewArr = viewArr2;
            } else {
                viewArr = null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(activity, viewArr, strArr));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(activity, viewArr, strArr));
            }
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, viewArr, strArr));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind());
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic());
        }
        return new ActivityOptionsCompat();
    }

    /* loaded from: classes2.dex */
    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB activityOptionsCompatJB) {
            this.mImpl = activityOptionsCompatJB;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImplJB) {
                this.mImpl.update(((ActivityOptionsImplJB) activityOptionsCompat).mImpl);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class ActivityOptionsImpl21 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat21 mImpl;

        ActivityOptionsImpl21(ActivityOptionsCompat21 activityOptionsCompat21) {
            this.mImpl = activityOptionsCompat21;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImpl21) {
                this.mImpl.update(((ActivityOptionsImpl21) activityOptionsCompat).mImpl);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class ActivityOptionsImpl23 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat23 mImpl;

        ActivityOptionsImpl23(ActivityOptionsCompat23 activityOptionsCompat23) {
            this.mImpl = activityOptionsCompat23;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImpl23) {
                this.mImpl.update(((ActivityOptionsImpl23) activityOptionsCompat).mImpl);
            }
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            this.mImpl.requestUsageTimeReport(pendingIntent);
        }
    }

    /* loaded from: classes2.dex */
    private static class ActivityOptionsImpl24 extends ActivityOptionsCompat {
        private final ActivityOptionsCompat24 mImpl;

        ActivityOptionsImpl24(ActivityOptionsCompat24 activityOptionsCompat24) {
            this.mImpl = activityOptionsCompat24;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImpl24) {
                this.mImpl.update(((ActivityOptionsImpl24) activityOptionsCompat).mImpl);
            }
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            return new ActivityOptionsImpl24(this.mImpl.setLaunchBounds(rect));
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return this.mImpl.getLaunchBounds();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            this.mImpl.requestUsageTimeReport(pendingIntent);
        }
    }

    protected ActivityOptionsCompat() {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return null;
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }
}
