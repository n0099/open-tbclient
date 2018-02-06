package android.support.v7.util;
/* loaded from: classes2.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    final ListUpdateCallback FA;
    int FB = 0;
    int FC = -1;
    int FD = -1;
    Object FE = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.FA = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        if (this.FB != 0) {
            switch (this.FB) {
                case 1:
                    this.FA.onInserted(this.FC, this.FD);
                    break;
                case 2:
                    this.FA.onRemoved(this.FC, this.FD);
                    break;
                case 3:
                    this.FA.onChanged(this.FC, this.FD, this.FE);
                    break;
            }
            this.FE = null;
            this.FB = 0;
        }
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        if (this.FB == 1 && i >= this.FC && i <= this.FC + this.FD) {
            this.FD += i2;
            this.FC = Math.min(i, this.FC);
            return;
        }
        dispatchLastEvent();
        this.FC = i;
        this.FD = i2;
        this.FB = 1;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        if (this.FB == 2 && this.FC >= i && this.FC <= i + i2) {
            this.FD += i2;
            this.FC = i;
            return;
        }
        dispatchLastEvent();
        this.FC = i;
        this.FD = i2;
        this.FB = 2;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.FA.onMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        if (this.FB == 3 && i <= this.FC + this.FD && i + i2 >= this.FC && this.FE == obj) {
            int i3 = this.FC + this.FD;
            this.FC = Math.min(i, this.FC);
            this.FD = Math.max(i3, i + i2) - this.FC;
            return;
        }
        dispatchLastEvent();
        this.FC = i;
        this.FD = i2;
        this.FE = obj;
        this.FB = 3;
    }
}
