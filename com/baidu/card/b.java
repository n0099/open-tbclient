package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.data.a;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements p<T>, q {
    protected ak agE;
    private Boolean agF = false;
    private com.baidu.tieba.card.ab<T> agG;
    public a agH;
    protected Context mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ak akVar) {
        this.agE = akVar;
    }

    public void bs(int i) {
    }

    public void bt(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tD() {
    }

    public com.baidu.tieba.card.ab<T> tE() {
        return this.agG;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<T> abVar) {
        this.agG = abVar;
    }

    public void a(int i, a.b bVar) {
        this.agE.a(i, bVar);
    }

    public void bu(int i) {
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public Boolean tF() {
        return this.agF;
    }

    public void b(Boolean bool) {
        this.agF = bool;
    }

    private ThreadCardView d(View view, int i) {
        if (view == null || view.getParent() == null || i == 0) {
            return null;
        }
        if (view.getParent() instanceof ThreadCardView) {
            return (ThreadCardView) view.getParent();
        }
        return d((View) view.getParent(), i - 1);
    }

    public void e(View view, int i) {
        ThreadCardView d = d(view, i);
        if (d != null) {
            com.baidu.tbadk.core.elementsMaven.c.bm(d).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }
}
