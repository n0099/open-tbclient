package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;
/* loaded from: classes.dex */
public class OpReorderer {
    public final Callback mCallback;

    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd == 8) {
                if (z) {
                    return size;
                }
            } else {
                z = true;
            }
        }
        return -1;
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3;
        if (updateOp.itemCount < updateOp2.positionStart) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        int i4 = updateOp2.positionStart;
        int i5 = updateOp.positionStart;
        if (i4 <= i5) {
            updateOp.positionStart = i5 + updateOp2.itemCount;
        }
        int i6 = updateOp2.positionStart;
        int i7 = updateOp.itemCount;
        if (i6 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4) {
                    swapMoveUpdate(list, i, updateOp, i2, updateOp2);
                    return;
                }
                return;
            }
            swapMoveRemove(list, i, updateOp, i2, updateOp2);
            return;
        }
        swapMoveAdd(list, i, updateOp, i2, updateOp2);
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        int i3 = updateOp.positionStart;
        int i4 = updateOp.itemCount;
        boolean z2 = false;
        if (i3 < i4) {
            if (updateOp2.positionStart == i3 && updateOp2.itemCount == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (updateOp2.positionStart == i4 + 1 && updateOp2.itemCount == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = updateOp.itemCount;
        int i6 = updateOp2.positionStart;
        if (i5 < i6) {
            updateOp2.positionStart = i6 - 1;
        } else {
            int i7 = updateOp2.itemCount;
            if (i5 < i6 + i7) {
                updateOp2.itemCount = i7 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i2);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i8 = updateOp.positionStart;
        int i9 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i8 <= i9) {
            updateOp2.positionStart = i9 + 1;
        } else {
            int i10 = updateOp2.itemCount;
            if (i8 < i9 + i10) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i8 + 1, (i9 + i10) - i8, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z2) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                int i11 = updateOp.positionStart;
                if (i11 > updateOp3.positionStart) {
                    updateOp.positionStart = i11 - updateOp3.itemCount;
                }
                int i12 = updateOp.itemCount;
                if (i12 > updateOp3.positionStart) {
                    updateOp.itemCount = i12 - updateOp3.itemCount;
                }
            }
            int i13 = updateOp.positionStart;
            if (i13 > updateOp2.positionStart) {
                updateOp.positionStart = i13 - updateOp2.itemCount;
            }
            int i14 = updateOp.itemCount;
            if (i14 > updateOp2.positionStart) {
                updateOp.itemCount = i14 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i15 = updateOp.positionStart;
                if (i15 >= updateOp3.positionStart) {
                    updateOp.positionStart = i15 - updateOp3.itemCount;
                }
                int i16 = updateOp.itemCount;
                if (i16 >= updateOp3.positionStart) {
                    updateOp.itemCount = i16 - updateOp3.itemCount;
                }
            }
            int i17 = updateOp.positionStart;
            if (i17 >= updateOp2.positionStart) {
                updateOp.positionStart = i17 - updateOp2.itemCount;
            }
            int i18 = updateOp.itemCount;
            if (i18 >= updateOp2.positionStart) {
                updateOp.itemCount = i18 - updateOp2.itemCount;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
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
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp obtainUpdateOp;
        int i3;
        int i4;
        int i5 = updateOp.itemCount;
        int i6 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i5 < i6) {
            updateOp2.positionStart = i6 - 1;
        } else {
            int i7 = updateOp2.itemCount;
            if (i5 < i6 + i7) {
                updateOp2.itemCount = i7 - 1;
                obtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
                i3 = updateOp.positionStart;
                i4 = updateOp2.positionStart;
                if (i3 > i4) {
                    updateOp2.positionStart = i4 + 1;
                } else {
                    int i8 = updateOp2.itemCount;
                    if (i3 < i4 + i8) {
                        int i9 = (i4 + i8) - i3;
                        updateOp3 = this.mCallback.obtainUpdateOp(4, i3 + 1, i9, updateOp2.payload);
                        updateOp2.itemCount -= i9;
                    }
                }
                list.set(i2, updateOp);
                if (updateOp2.itemCount <= 0) {
                    list.set(i, updateOp2);
                } else {
                    list.remove(i);
                    this.mCallback.recycleUpdateOp(updateOp2);
                }
                if (obtainUpdateOp != null) {
                    list.add(i, obtainUpdateOp);
                }
                if (updateOp3 == null) {
                    list.add(i, updateOp3);
                    return;
                }
                return;
            }
        }
        obtainUpdateOp = null;
        i3 = updateOp.positionStart;
        i4 = updateOp2.positionStart;
        if (i3 > i4) {
        }
        list.set(i2, updateOp);
        if (updateOp2.itemCount <= 0) {
        }
        if (obtainUpdateOp != null) {
        }
        if (updateOp3 == null) {
        }
    }
}
