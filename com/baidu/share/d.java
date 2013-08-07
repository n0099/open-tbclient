package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f795a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f795a) {
            this.f795a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null || this.f795a == null) {
            return;
        }
        synchronized (this.f795a) {
            int size = this.f795a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.f795a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.f795a) {
                if (!this.f795a.contains(iShareListener)) {
                    z = this.f795a.add(iShareListener);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(IShareListener iShareListener) {
        boolean remove;
        if (iShareListener == null) {
            return false;
        }
        synchronized (this.f795a) {
            remove = this.f795a.remove(iShareListener);
        }
        return remove;
    }
}
