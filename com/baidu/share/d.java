package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f973a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f973a) {
            this.f973a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null || this.f973a == null) {
            return;
        }
        synchronized (this.f973a) {
            int size = this.f973a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.f973a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.f973a) {
                if (!this.f973a.contains(iShareListener)) {
                    z = this.f973a.add(iShareListener);
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
        synchronized (this.f973a) {
            remove = this.f973a.remove(iShareListener);
        }
        return remove;
    }
}
