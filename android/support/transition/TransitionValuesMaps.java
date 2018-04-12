package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes2.dex */
class TransitionValuesMaps {
    public ArrayMap<View, TransitionValues> viewValues = new ArrayMap<>();
    public SparseArray<TransitionValues> idValues = new SparseArray<>();
    public LongSparseArray<TransitionValues> itemIdValues = new LongSparseArray<>();
}
