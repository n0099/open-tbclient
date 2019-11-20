package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class i extends SlideableGridView.a {
    private List<j> bJY;
    private int bJb;
    private Context mContext;
    private boolean bJc = true;
    private int bJZ = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<j> list) {
        this.bJY = list;
    }

    public void dA(boolean z) {
        this.bJc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bJb = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bJY == null) {
            return 0;
        }
        if (this.bJY.size() % this.bJZ == 0) {
            return this.bJY.size() / this.bJZ;
        }
        return (this.bJY.size() / this.bJZ) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int gu(int i) {
        if (this.bJY == null) {
            return 0;
        }
        return i < this.bJY.size() / this.bJZ ? this.bJZ : this.bJY.size() % this.bJZ;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View kVar = view == null ? new k(this.mContext) : view;
        ((k) kVar).setMenuStyle(this.bJb);
        ((k) kVar).e(this.bJY.get((this.bJZ * i) + i2));
        return kVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bJY != null) {
            j jVar = this.bJY.get((this.bJZ * i) + i2);
            e aaB = jVar.aaB();
            if (aaB != null) {
                aaB.a(view, jVar);
            }
        }
    }
}
