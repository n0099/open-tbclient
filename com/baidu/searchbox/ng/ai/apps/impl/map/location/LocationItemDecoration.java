package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes4.dex */
public class LocationItemDecoration extends RecyclerView.ItemDecoration {
    private static final int MARGIN = AiAppsUIUtils.dp2px(15.0f);
    private static final int THICK = 1;
    private ColorDrawable mColorDrawable;
    private boolean mIsShowLastDec;

    public LocationItemDecoration(Context context) {
        this(context, false);
    }

    public LocationItemDecoration(Context context, boolean z) {
        this.mIsShowLastDec = true;
        this.mColorDrawable = new ColorDrawable(context.getResources().getColor(R.color.aiapps_location_item_bg_pressed));
        this.mIsShowLastDec = z;
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + MARGIN;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - MARGIN;
        int childCount = recyclerView.getChildCount();
        int i = this.mIsShowLastDec ? childCount : childCount - 1;
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                this.mColorDrawable.setBounds(paddingLeft, bottom, width, bottom + 1);
                this.mColorDrawable.draw(canvas);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawVertical(canvas, recyclerView);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 1);
    }
}
