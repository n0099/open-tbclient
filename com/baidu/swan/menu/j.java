package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class j extends SlideableGridView.a {
    private static final boolean DEBUG = a.DEBUG;
    private int bjT;
    private List<k> bkR;
    private Context mContext;
    private boolean bjU = true;
    private int bkS = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<k> list) {
        this.bkR = list;
    }

    public void cN(boolean z) {
        this.bjU = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjT = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bkR == null) {
            return 0;
        }
        if (this.bkR.size() % this.bkS == 0) {
            return this.bkR.size() / this.bkS;
        }
        return (this.bkR.size() / this.bkS) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int eW(int i) {
        if (this.bkR == null) {
            return 0;
        }
        return i < this.bkR.size() / this.bkS ? this.bkS : this.bkR.size() % this.bkS;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View lVar = view == null ? new l(this.mContext) : view;
        ((l) lVar).setMenuStyle(this.bjT);
        ((l) lVar).e(this.bkR.get((this.bkS * i) + i2));
        return lVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bkR != null) {
            k kVar = this.bkR.get((this.bkS * i) + i2);
            f Rf = kVar.Rf();
            if (Rf != null) {
                Rf.a(view, kVar);
            }
        }
    }
}
