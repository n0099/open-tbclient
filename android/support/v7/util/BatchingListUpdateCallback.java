package android.support.v7.util;
/* loaded from: classes2.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    final ListUpdateCallback Fv;
    int Fw = 0;
    int Fx = -1;
    int Fy = -1;
    Object Fz = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.Fv = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        if (this.Fw != 0) {
            switch (this.Fw) {
                case 1:
                    this.Fv.onInserted(this.Fx, this.Fy);
                    break;
                case 2:
                    this.Fv.onRemoved(this.Fx, this.Fy);
                    break;
                case 3:
                    this.Fv.onChanged(this.Fx, this.Fy, this.Fz);
                    break;
            }
            this.Fz = null;
            this.Fw = 0;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        if (this.Fw == 1 && i >= this.Fx && i <= this.Fx + this.Fy) {
            this.Fy += i2;
            this.Fx = Math.min(i, this.Fx);
            return;
        }
        dispatchLastEvent();
        this.Fx = i;
        this.Fy = i2;
        this.Fw = 1;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        if (this.Fw == 2 && this.Fx >= i && this.Fx <= i + i2) {
            this.Fy += i2;
            this.Fx = i;
            return;
        }
        dispatchLastEvent();
        this.Fx = i;
        this.Fy = i2;
        this.Fw = 2;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.Fv.onMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        if (this.Fw == 3 && i <= this.Fx + this.Fy && i + i2 >= this.Fx && this.Fz == obj) {
            int i3 = this.Fx + this.Fy;
            this.Fx = Math.min(i, this.Fx);
            this.Fy = Math.max(i3, i + i2) - this.Fx;
            return;
        }
        dispatchLastEvent();
        this.Fx = i;
        this.Fy = i2;
        this.Fz = obj;
        this.Fw = 3;
    }
}
