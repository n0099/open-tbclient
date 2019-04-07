package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class j extends SlideableGridView.a {
    private static final boolean DEBUG = a.DEBUG;
    private int bjS;
    private List<k> bkQ;
    private Context mContext;
    private boolean bjT = true;
    private int bkR = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<k> list) {
        this.bkQ = list;
    }

    public void cN(boolean z) {
        this.bjT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjS = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bkQ == null) {
            return 0;
        }
        if (this.bkQ.size() % this.bkR == 0) {
            return this.bkQ.size() / this.bkR;
        }
        return (this.bkQ.size() / this.bkR) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int eW(int i) {
        if (this.bkQ == null) {
            return 0;
        }
        return i < this.bkQ.size() / this.bkR ? this.bkR : this.bkQ.size() % this.bkR;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View lVar = view == null ? new l(this.mContext) : view;
        ((l) lVar).setMenuStyle(this.bjS);
        ((l) lVar).e(this.bkQ.get((this.bkR * i) + i2));
        return lVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bkQ != null) {
            k kVar = this.bkQ.get((this.bkR * i) + i2);
            f Rf = kVar.Rf();
            if (Rf != null) {
                Rf.a(view, kVar);
            }
        }
    }
}
