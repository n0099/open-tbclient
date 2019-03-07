package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class j extends SlideableGridView.a {
    private static final boolean DEBUG = a.DEBUG;
    private int bjO;
    private List<k> bkM;
    private Context mContext;
    private boolean bjP = true;
    private int bkN = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<k> list) {
        this.bkM = list;
    }

    public void cN(boolean z) {
        this.bjP = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjO = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bkM == null) {
            return 0;
        }
        if (this.bkM.size() % this.bkN == 0) {
            return this.bkM.size() / this.bkN;
        }
        return (this.bkM.size() / this.bkN) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int eX(int i) {
        if (this.bkM == null) {
            return 0;
        }
        return i < this.bkM.size() / this.bkN ? this.bkN : this.bkM.size() % this.bkN;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View lVar = view == null ? new l(this.mContext) : view;
        ((l) lVar).setMenuStyle(this.bjO);
        ((l) lVar).e(this.bkM.get((this.bkN * i) + i2));
        return lVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bkM != null) {
            k kVar = this.bkM.get((this.bkN * i) + i2);
            f Rh = kVar.Rh();
            if (Rh != null) {
                Rh.a(view, kVar);
            }
        }
    }
}
