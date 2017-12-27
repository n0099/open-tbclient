package android.support.b;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* loaded from: classes2.dex */
class l implements TypeEvaluator<Rect> {
    private Rect lQ;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = ((int) ((rect2.left - rect.left) * f)) + rect.left;
        int i2 = ((int) ((rect2.top - rect.top) * f)) + rect.top;
        int i3 = ((int) ((rect2.right - rect.right) * f)) + rect.right;
        int i4 = ((int) ((rect2.bottom - rect.bottom) * f)) + rect.bottom;
        if (this.lQ == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.lQ.set(i, i2, i3, i4);
        return this.lQ;
    }
}
