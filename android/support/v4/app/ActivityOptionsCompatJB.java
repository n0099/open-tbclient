package android.support.v4.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes2.dex */
class ActivityOptionsCompatJB {
    private final ActivityOptions mActivityOptions;

    public static ActivityOptionsCompatJB makeCustomAnimation(Context context, int i, int i2) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeCustomAnimation(context, i, i2));
    }

    public static ActivityOptionsCompatJB makeScaleUpAnimation(View view2, int i, int i2, int i3, int i4) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeScaleUpAnimation(view2, i, i2, i3, i4));
    }

    public static ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(View view2, Bitmap bitmap, int i, int i2) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeThumbnailScaleUpAnimation(view2, bitmap, i, i2));
    }

    private ActivityOptionsCompatJB(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompatJB activityOptionsCompatJB) {
        this.mActivityOptions.update(activityOptionsCompatJB.mActivityOptions);
    }
}
