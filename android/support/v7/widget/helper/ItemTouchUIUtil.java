package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes2.dex */
public interface ItemTouchUIUtil {
    void clearView(View view2);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z);

    void onSelected(View view2);
}
