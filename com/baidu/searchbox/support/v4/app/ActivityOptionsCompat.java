package com.baidu.searchbox.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
/* loaded from: classes2.dex */
public class ActivityOptionsCompat {
    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, i, i2)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(view, i, i2, i3, i4)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(view, bitmap, i, i2)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        return Build.VERSION.SDK_INT >= 21 ? new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, view, str)) : new ActivityOptionsCompat();
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
                    viewArr2[i2] = (View) pairArr[i2].first;
                    strArr2[i2] = (String) pairArr[i2].second;
                    i = i2 + 1;
                }
                strArr = strArr2;
                viewArr = viewArr2;
            } else {
                viewArr = null;
            }
            return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, viewArr, strArr));
        }
        return new ActivityOptionsCompat();
    }

    /* loaded from: classes2.dex */
    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB activityOptionsCompatJB) {
            this.mImpl = activityOptionsCompatJB;
        }

        @Override // com.baidu.searchbox.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // com.baidu.searchbox.support.v4.app.ActivityOptionsCompat
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

        @Override // com.baidu.searchbox.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // com.baidu.searchbox.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsImpl21) {
                this.mImpl.update(((ActivityOptionsImpl21) activityOptionsCompat).mImpl);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}
