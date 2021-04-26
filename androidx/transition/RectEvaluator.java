package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* loaded from: classes.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    public Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i2 = rect.left;
        int i3 = i2 + ((int) ((rect2.left - i2) * f2));
        int i4 = rect.top;
        int i5 = i4 + ((int) ((rect2.top - i4) * f2));
        int i6 = rect.right;
        int i7 = i6 + ((int) ((rect2.right - i6) * f2));
        int i8 = rect.bottom;
        int i9 = i8 + ((int) ((rect2.bottom - i8) * f2));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i3, i5, i7, i9);
        }
        rect3.set(i3, i5, i7, i9);
        return this.mRect;
    }
}
