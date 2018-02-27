package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.RatingBar;
/* loaded from: classes2.dex */
public class AppCompatRatingBar extends RatingBar {
    private g Nc;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nc = new g(this);
        this.Nc.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap fM = this.Nc.fM();
        if (fM != null) {
            setMeasuredDimension(ViewCompat.resolveSizeAndState(fM.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
