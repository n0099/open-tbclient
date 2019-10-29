package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class i extends SlideableGridView.a {
    private int bJS;
    private List<j> bKP;
    private Context mContext;
    private boolean bJT = true;
    private int bKQ = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<j> list) {
        this.bKP = list;
    }

    public void dA(boolean z) {
        this.bJT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bJS = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bKP == null) {
            return 0;
        }
        if (this.bKP.size() % this.bKQ == 0) {
            return this.bKP.size() / this.bKQ;
        }
        return (this.bKP.size() / this.bKQ) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int gv(int i) {
        if (this.bKP == null) {
            return 0;
        }
        return i < this.bKP.size() / this.bKQ ? this.bKQ : this.bKP.size() % this.bKQ;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View kVar = view == null ? new k(this.mContext) : view;
        ((k) kVar).setMenuStyle(this.bJS);
        ((k) kVar).e(this.bKP.get((this.bKQ * i) + i2));
        return kVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bKP != null) {
            j jVar = this.bKP.get((this.bKQ * i) + i2);
            e aaD = jVar.aaD();
            if (aaD != null) {
                aaD.a(view, jVar);
            }
        }
    }
}
