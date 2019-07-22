package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class i extends SlideableGridView.a {
    private int bqJ;
    private List<j> brG;
    private Context mContext;
    private boolean bqK = true;
    private int brH = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<j> list) {
        this.brG = list;
    }

    public void dj(boolean z) {
        this.bqK = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bqJ = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.brG == null) {
            return 0;
        }
        if (this.brG.size() % this.brH == 0) {
            return this.brG.size() / this.brH;
        }
        return (this.brG.size() / this.brH) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int fz(int i) {
        if (this.brG == null) {
            return 0;
        }
        return i < this.brG.size() / this.brH ? this.brH : this.brG.size() % this.brH;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View kVar = view == null ? new k(this.mContext) : view;
        ((k) kVar).setMenuStyle(this.bqJ);
        ((k) kVar).e(this.brG.get((this.brH * i) + i2));
        return kVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.brG != null) {
            j jVar = this.brG.get((this.brH * i) + i2);
            e VK = jVar.VK();
            if (VK != null) {
                VK.a(view, jVar);
            }
        }
    }
}
