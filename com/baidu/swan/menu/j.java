package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class j extends SlideableGridView.a {
    private static final boolean DEBUG = a.DEBUG;
    private int bjP;
    private List<k> bkN;
    private Context mContext;
    private boolean bjQ = true;
    private int bkO = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<k> list) {
        this.bkN = list;
    }

    public void cN(boolean z) {
        this.bjQ = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bjP = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bkN == null) {
            return 0;
        }
        if (this.bkN.size() % this.bkO == 0) {
            return this.bkN.size() / this.bkO;
        }
        return (this.bkN.size() / this.bkO) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int eX(int i) {
        if (this.bkN == null) {
            return 0;
        }
        return i < this.bkN.size() / this.bkO ? this.bkO : this.bkN.size() % this.bkO;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View lVar = view == null ? new l(this.mContext) : view;
        ((l) lVar).setMenuStyle(this.bjP);
        ((l) lVar).e(this.bkN.get((this.bkO * i) + i2));
        return lVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bkN != null) {
            k kVar = this.bkN.get((this.bkO * i) + i2);
            f Rh = kVar.Rh();
            if (Rh != null) {
                Rh.a(view, kVar);
            }
        }
    }
}
