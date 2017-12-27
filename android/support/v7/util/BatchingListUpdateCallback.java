package android.support.v7.util;
/* loaded from: classes2.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    final ListUpdateCallback FB;
    int FC = 0;
    int FD = -1;
    int FE = -1;
    Object FF = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.FB = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        if (this.FC != 0) {
            switch (this.FC) {
                case 1:
                    this.FB.onInserted(this.FD, this.FE);
                    break;
                case 2:
                    this.FB.onRemoved(this.FD, this.FE);
                    break;
                case 3:
                    this.FB.onChanged(this.FD, this.FE, this.FF);
                    break;
            }
            this.FF = null;
            this.FC = 0;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        if (this.FC == 1 && i >= this.FD && i <= this.FD + this.FE) {
            this.FE += i2;
            this.FD = Math.min(i, this.FD);
            return;
        }
        dispatchLastEvent();
        this.FD = i;
        this.FE = i2;
        this.FC = 1;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        if (this.FC == 2 && this.FD >= i && this.FD <= i + i2) {
            this.FE += i2;
            this.FD = i;
            return;
        }
        dispatchLastEvent();
        this.FD = i;
        this.FE = i2;
        this.FC = 2;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.FB.onMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        if (this.FC == 3 && i <= this.FD + this.FE && i + i2 >= this.FD && this.FF == obj) {
            int i3 = this.FD + this.FE;
            this.FD = Math.min(i, this.FD);
            this.FE = Math.max(i3, i + i2) - this.FD;
            return;
        }
        dispatchLastEvent();
        this.FD = i;
        this.FE = i2;
        this.FF = obj;
        this.FC = 3;
    }
}
