package com.baidu.searchbox.floating.animator;

import android.animation.TypeEvaluator;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes14.dex */
public final class RectEvaluator implements TypeEvaluator<ViewRect> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public ViewRect evaluate(float f, ViewRect viewRect, ViewRect viewRect2) {
        p.o(viewRect, "start");
        p.o(viewRect2, "end");
        return new ViewRect((int) (viewRect.getX() + ((viewRect2.getX() - viewRect.getX()) * f)), (int) (viewRect.getY() + ((viewRect2.getY() - viewRect.getY()) * f)), (int) (viewRect.getW() + ((viewRect2.getW() - viewRect.getW()) * f)), (int) (viewRect.getH() + ((viewRect2.getH() - viewRect.getH()) * f)));
    }

    @e
    /* loaded from: classes14.dex */
    public static final class ViewRect {
        private final int h;
        private final int w;
        private final int x;
        private final int y;

        public ViewRect(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.w = i3;
            this.h = i4;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        public final int getW() {
            return this.w;
        }

        public final int getH() {
            return this.h;
        }
    }
}
