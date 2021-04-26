package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
/* loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i2, boolean z);

    void onSelected(View view);
}
