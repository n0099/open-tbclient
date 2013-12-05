package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f979a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f979a) {
            this.f979a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null || this.f979a == null) {
            return;
        }
        synchronized (this.f979a) {
            int size = this.f979a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.f979a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.f979a) {
                if (!this.f979a.contains(iShareListener)) {
                    z = this.f979a.add(iShareListener);
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
        synchronized (this.f979a) {
            remove = this.f979a.remove(iShareListener);
        }
        return remove;
    }
}
