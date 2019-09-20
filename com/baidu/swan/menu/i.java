package com.baidu.swan.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class i extends SlideableGridView.a {
    private int brh;
    private List<j> bse;
    private Context mContext;
    private boolean bri = true;
    private int bsf = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<j> list) {
        this.bse = list;
    }

    public void dj(boolean z) {
        this.bri = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.brh = i;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int getPageCount() {
        if (this.bse == null) {
            return 0;
        }
        if (this.bse.size() % this.bsf == 0) {
            return this.bse.size() / this.bsf;
        }
        return (this.bse.size() / this.bsf) + 1;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public int fA(int i) {
        if (this.bse == null) {
            return 0;
        }
        return i < this.bse.size() / this.bsf ? this.bsf : this.bse.size() % this.bsf;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View kVar = view == null ? new k(this.mContext) : view;
        ((k) kVar).setMenuStyle(this.brh);
        ((k) kVar).e(this.bse.get((this.bsf * i) + i2));
        return kVar;
    }

    @Override // com.baidu.swan.menu.viewpager.SlideableGridView.a
    public void a(int i, int i2, View view) {
        if (this.bse != null) {
            j jVar = this.bse.get((this.bsf * i) + i2);
            e VO = jVar.VO();
            if (VO != null) {
                VO.a(view, jVar);
            }
        }
    }
}
