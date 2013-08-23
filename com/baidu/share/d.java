package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f818a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f818a) {
            this.f818a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null || this.f818a == null) {
            return;
        }
        synchronized (this.f818a) {
            int size = this.f818a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.f818a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.f818a) {
                if (!this.f818a.contains(iShareListener)) {
                    z = this.f818a.add(iShareListener);
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
        synchronized (this.f818a) {
            remove = this.f818a.remove(iShareListener);
        }
        return remove;
    }
}
