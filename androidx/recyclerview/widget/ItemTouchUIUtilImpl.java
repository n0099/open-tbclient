package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    public static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View view2) {
    }

    public static float findMaxElevation(RecyclerView recyclerView, View view2) {
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

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View view2) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f091240);
            if (tag instanceof Float) {
                ViewCompat.setElevation(view2, ((Float) tag).floatValue());
            }
            view2.setTag(R.id.obfuscated_res_0x7f091240, null);
        }
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view2, float f, float f2, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view2.getTag(R.id.obfuscated_res_0x7f091240) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view2));
            ViewCompat.setElevation(view2, findMaxElevation(recyclerView, view2) + 1.0f);
            view2.setTag(R.id.obfuscated_res_0x7f091240, valueOf);
        }
        view2.setTranslationX(f);
        view2.setTranslationY(f2);
    }
}
