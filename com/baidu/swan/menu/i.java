package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class i extends SlideableGridView.a {
    private int bpW;
    private List<j> bqT;
    private Context mContext;
    private boolean bpX = true;
    private int bqU = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<j> list) {
        this.bqT = list;
    }

    public void de(boolean z) {
        this.bpX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.bpW = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bqT == null) {
            return 0;
        }
        if (this.bqT.size() % this.bqU == 0) {
            return this.bqT.size() / this.bqU;
        }
        return (this.bqT.size() / this.bqU) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int fv(int i) {
        if (this.bqT == null) {
            return 0;
        }
        return i < this.bqT.size() / this.bqU ? this.bqU : this.bqT.size() % this.bqU;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View kVar = view == null ? new k(this.mContext) : view;
        ((k) kVar).setMenuStyle(this.bpW);
        ((k) kVar).e(this.bqT.get((this.bqU * i) + i2));
        return kVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bqT != null) {
            j jVar = this.bqT.get((this.bqU * i) + i2);
            e UR = jVar.UR();
            if (UR != null) {
                UR.a(view, jVar);
            }
        }
    }
}
