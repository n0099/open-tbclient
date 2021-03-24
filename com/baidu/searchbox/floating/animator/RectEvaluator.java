package com.baidu.searchbox.floating.animator;

import android.animation.TypeEvaluator;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator;", "Landroid/animation/TypeEvaluator;", "", "fraction", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", IntentConfig.START, ProgressInfo.JSON_KEY_END, "evaluate", "(FLcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;)Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "<init>", "()V", "ViewRect", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RectEvaluator implements TypeEvaluator<ViewRect> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000B'\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005R\u0019\u0010\b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "", "h", "I", "getH", "()I", "w", "getW", "x", "getX", "y", "getY", "<init>", "(IIII)V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ViewRect {

        /* renamed from: h  reason: collision with root package name */
        public final int f11592h;
        public final int w;
        public final int x;
        public final int y;

        public ViewRect(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.w = i3;
            this.f11592h = i4;
        }

        public final int getH() {
            return this.f11592h;
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
    public ViewRect evaluate(float f2, ViewRect viewRect, ViewRect viewRect2) {
        return new ViewRect((int) (viewRect.getX() + ((viewRect2.getX() - viewRect.getX()) * f2)), (int) (viewRect.getY() + ((viewRect2.getY() - viewRect.getY()) * f2)), (int) (viewRect.getW() + ((viewRect2.getW() - viewRect.getW()) * f2)), (int) (viewRect.getH() + (f2 * (viewRect2.getH() - viewRect.getH()))));
    }
}
