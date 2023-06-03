package com.baidu.searchbox.ui;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes4.dex */
public final class ViewHolderUtils {
    public static <T extends View> T get(View view2, int i) {
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view2.setTag(sparseArray);
        }
        T t = (T) sparseArray.get(i);
        if (t == null) {
            T t2 = (T) view2.findViewById(i);
            sparseArray.put(i, t2);
            return t2;
        }
        return t;
    }
}
