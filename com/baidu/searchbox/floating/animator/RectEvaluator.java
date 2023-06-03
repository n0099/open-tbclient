package com.baidu.searchbox.floating.animator;

import android.animation.TypeEvaluator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "()V", "evaluate", "fraction", "", "start", "end", "ViewRect", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RectEvaluator implements TypeEvaluator<ViewRect> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "", "x", "", "y", "w", "h", "(IIII)V", "getH", "()I", "getW", "getX", "getY", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ViewRect {
        public final int h;
        public final int w;
        public final int x;
        public final int y;

        public ViewRect(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.w = i3;
            this.h = i4;
        }

        public final int getH() {
            return this.h;
        }

        public final int getW() {
            return this.w;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public ViewRect evaluate(float f, ViewRect start, ViewRect end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new ViewRect((int) (start.getX() + ((end.getX() - start.getX()) * f)), (int) (start.getY() + ((end.getY() - start.getY()) * f)), (int) (start.getW() + ((end.getW() - start.getW()) * f)), (int) (start.getH() + (f * (end.getH() - start.getH()))));
    }
}
