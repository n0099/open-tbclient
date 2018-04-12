package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
class ItemTouchUIUtilImpl {
    ItemTouchUIUtilImpl() {
    }

    /* loaded from: classes2.dex */
    static class Lollipop extends Honeycomb {
        @Override // android.support.v7.widget.helper.ItemTouchUIUtilImpl.Honeycomb, android.support.v7.widget.helper.ItemTouchUIUtil
        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
            if (z && view2.getTag(R.id.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view2));
                ViewCompat.setElevation(view2, 1.0f + findMaxElevation(recyclerView, view2));
                view2.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
            }
            super.onDraw(canvas, recyclerView, view2, f, f2, i, z);
        }

        private float findMaxElevation(RecyclerView recyclerView, View view2) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view2) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f) {
                        f = elevation;
                    }
                }
            }
            return f;
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtilImpl.Honeycomb, android.support.v7.widget.helper.ItemTouchUIUtil
        public void clearView(View view2) {
            Object tag = view2.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.setElevation(view2, ((Float) tag).floatValue());
            }
            view2.setTag(R.id.item_touch_helper_previous_elevation, null);
            super.clearView(view2);
        }
    }

    /* loaded from: classes2.dex */
    static class Honeycomb implements ItemTouchUIUtil {
        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void clearView(View view2) {
            ViewCompat.setTranslationX(view2, 0.0f);
            ViewCompat.setTranslationY(view2, 0.0f);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onSelected(View view2) {
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
            ViewCompat.setTranslationX(view2, f);
            ViewCompat.setTranslationY(view2, f2);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
        }
    }

    /* loaded from: classes2.dex */
    static class Gingerbread implements ItemTouchUIUtil {
        private void draw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view2, 0L);
            canvas.restore();
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void clearView(View view2) {
            view2.setVisibility(0);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onSelected(View view2) {
            view2.setVisibility(4);
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
            if (i != 2) {
                draw(canvas, recyclerView, view2, f, f2);
            }
        }

        @Override // android.support.v7.widget.helper.ItemTouchUIUtil
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
            if (i == 2) {
                draw(canvas, recyclerView, view2, f, f2);
            }
        }
    }
}
