package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class GhostViewHolder extends FrameLayout {
    public boolean mAttached;
    @NonNull
    public ViewGroup mParent;

    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090e28, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    public static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090e28);
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            getParents(((GhostViewPort) getChildAt(i2)).mView, arrayList2);
            if (isOnTop(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    public void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<>();
        getParents(ghostViewPort.mView, arrayList);
        int insertIndex = getInsertIndex(arrayList);
        if (insertIndex >= 0 && insertIndex < getChildCount()) {
            addView(ghostViewPort, insertIndex);
        } else {
            addView(ghostViewPort);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        if (this.mAttached) {
            super.onViewAdded(view2);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view2) {
        super.onViewRemoved(view2);
        if ((getChildCount() == 1 && getChildAt(0) == view2) || getChildCount() == 0) {
            this.mParent.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f090e28, null);
            ViewGroupUtils.getOverlay(this.mParent).remove(this);
            this.mAttached = false;
        }
    }

    public static void getParents(View view2, ArrayList<View> arrayList) {
        ViewParent parent = view2.getParent();
        if (parent instanceof ViewGroup) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view2);
    }

    public static boolean isOnTop(View view2, View view3) {
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view2.getZ() != view3.getZ()) {
            if (view2.getZ() <= view3.getZ()) {
                return false;
            }
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i));
            if (childAt == view2) {
                return false;
            }
            if (childAt == view3) {
                break;
            }
        }
        return true;
    }

    public static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < min; i++) {
            View view2 = arrayList.get(i);
            View view3 = arrayList2.get(i);
            if (view2 != view3) {
                return isOnTop(view2, view3);
            }
        }
        if (arrayList2.size() == min) {
            return true;
        }
        return false;
    }

    public void popToOverlayTop() {
        if (this.mAttached) {
            ViewGroupUtils.getOverlay(this.mParent).remove(this);
            ViewGroupUtils.getOverlay(this.mParent).add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }
}
