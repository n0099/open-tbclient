package com.baidu.share;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f959a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f959a) {
            this.f959a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null || this.f959a == null) {
            return;
        }
        synchronized (this.f959a) {
            int size = this.f959a.size();
            for (int i = 0; i < size; i++) {
                ((IShareListener) this.f959a.get(i)).onShareEvent(shareModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(IShareListener iShareListener) {
        boolean z = false;
        if (iShareListener != null) {
            synchronized (this.f959a) {
                if (!this.f959a.contains(iShareListener)) {
                    z = this.f959a.add(iShareListener);
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
        synchronized (this.f959a) {
            remove = this.f959a.remove(iShareListener);
        }
        return remove;
    }
}
