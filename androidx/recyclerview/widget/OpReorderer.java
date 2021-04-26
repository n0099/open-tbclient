package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;
/* loaded from: classes.dex */
public class OpReorderer {
    public final Callback mCallback;

    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i2, int i3, int i4, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        int i4 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i4++;
        }
        int i5 = updateOp2.positionStart;
        int i6 = updateOp.positionStart;
        if (i5 <= i6) {
            updateOp.positionStart = i6 + updateOp2.itemCount;
        }
        int i7 = updateOp2.positionStart;
        int i8 = updateOp.itemCount;
        if (i7 <= i8) {
            updateOp.itemCount = i8 + updateOp2.itemCount;
        }
        updateOp2.positionStart += i4;
        list.set(i2, updateOp2);
        list.set(i3, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i2, int i3) {
        AdapterHelper.UpdateOp updateOp = list.get(i2);
        AdapterHelper.UpdateOp updateOp2 = list.get(i3);
        int i4 = updateOp2.cmd;
        if (i4 == 1) {
            swapMoveAdd(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 2) {
            swapMoveRemove(list, i2, updateOp, i3, updateOp2);
        } else if (i4 != 4) {
        } else {
            swapMoveUpdate(list, i2, updateOp, i3, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            }
            swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        int i4 = updateOp.positionStart;
        int i5 = updateOp.itemCount;
        boolean z2 = false;
        if (i4 < i5) {
            if (updateOp2.positionStart == i4 && updateOp2.itemCount == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (updateOp2.positionStart == i5 + 1 && updateOp2.itemCount == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = updateOp.itemCount;
        int i7 = updateOp2.positionStart;
        if (i6 < i7) {
            updateOp2.positionStart = i7 - 1;
        } else {
            int i8 = updateOp2.itemCount;
            if (i6 < i7 + i8) {
                updateOp2.itemCount = i8 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i3);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i9 = updateOp.positionStart;
        int i10 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i9 <= i10) {
            updateOp2.positionStart = i10 + 1;
        } else {
            int i11 = updateOp2.itemCount;
            if (i9 < i10 + i11) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i9 + 1, (i10 + i11) - i9, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z2) {
            list.set(i2, updateOp2);
            list.remove(i3);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                int i12 = updateOp.positionStart;
                if (i12 > updateOp3.positionStart) {
                    updateOp.positionStart = i12 - updateOp3.itemCount;
                }
                int i13 = updateOp.itemCount;
                if (i13 > updateOp3.positionStart) {
                    updateOp.itemCount = i13 - updateOp3.itemCount;
                }
            }
            int i14 = updateOp.positionStart;
            if (i14 > updateOp2.positionStart) {
                updateOp.positionStart = i14 - updateOp2.itemCount;
            }
            int i15 = updateOp.itemCount;
            if (i15 > updateOp2.positionStart) {
                updateOp.itemCount = i15 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i16 = updateOp.positionStart;
                if (i16 >= updateOp3.positionStart) {
                    updateOp.positionStart = i16 - updateOp3.itemCount;
                }
                int i17 = updateOp.itemCount;
                if (i17 >= updateOp3.positionStart) {
                    updateOp.itemCount = i17 - updateOp3.itemCount;
                }
            }
            int i18 = updateOp.positionStart;
            if (i18 >= updateOp2.positionStart) {
                updateOp.positionStart = i18 - updateOp2.itemCount;
            }
            int i19 = updateOp.itemCount;
            if (i19 >= updateOp2.positionStart) {
                updateOp.itemCount = i19 - updateOp2.itemCount;
            }
        }
        list.set(i2, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i3, updateOp);
        } else {
            list.remove(i3);
        }
        if (updateOp3 != null) {
            list.add(i2, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp obtainUpdateOp;
        int i4;
        int i5;
        int i6 = updateOp.itemCount;
        int i7 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i6 < i7) {
            updateOp2.positionStart = i7 - 1;
        } else {
            int i8 = updateOp2.itemCount;
            if (i6 < i7 + i8) {
                updateOp2.itemCount = i8 - 1;
                obtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
                i4 = updateOp.positionStart;
                i5 = updateOp2.positionStart;
                if (i4 > i5) {
                    updateOp2.positionStart = i5 + 1;
                } else {
                    int i9 = updateOp2.itemCount;
                    if (i4 < i5 + i9) {
                        int i10 = (i5 + i9) - i4;
                        updateOp3 = this.mCallback.obtainUpdateOp(4, i4 + 1, i10, updateOp2.payload);
                        updateOp2.itemCount -= i10;
                    }
                }
                list.set(i3, updateOp);
                if (updateOp2.itemCount <= 0) {
                    list.set(i2, updateOp2);
                } else {
                    list.remove(i2);
                    this.mCallback.recycleUpdateOp(updateOp2);
                }
                if (obtainUpdateOp != null) {
                    list.add(i2, obtainUpdateOp);
                }
                if (updateOp3 == null) {
                    list.add(i2, updateOp3);
                    return;
                }
                return;
            }
        }
        obtainUpdateOp = null;
        i4 = updateOp.positionStart;
        i5 = updateOp2.positionStart;
        if (i4 > i5) {
        }
        list.set(i3, updateOp);
        if (updateOp2.itemCount <= 0) {
        }
        if (obtainUpdateOp != null) {
        }
        if (updateOp3 == null) {
        }
    }
}
