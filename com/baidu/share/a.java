package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    ArrayList a = new ArrayList();

    final void a() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    final void a(ShareModel shareModel) {
        if (shareModel == null || this.a == null) {
            return;
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.a) {
                if (!this.a.contains(iShareListener)) {
                    z = this.a.add(iShareListener);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(IShareListener iShareListener) {
        boolean remove;
        if (iShareListener == null) {
            return false;
        }
        synchronized (this.a) {
            remove = this.a.remove(iShareListener);
        }
        return remove;
    }
}
