package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.data.a;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public abstract class b<T extends com.baidu.tbadk.core.data.a> implements p<T>, q {
    protected ak afI;
    private Boolean afJ = false;
    private com.baidu.tieba.card.ab<T> afK;
    public a afL;
    protected Context mContext;

    /* loaded from: classes20.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public b(Context context) {
        this.mContext = context;
    }

    public void a(ak akVar) {
        this.afI = akVar;
    }

    public void bo(int i) {
    }

    public void bp(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA() {
    }

    public com.baidu.tieba.card.ab<T> tB() {
        return this.afK;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.ab<T> abVar) {
        this.afK = abVar;
    }

    public void a(int i, a.b bVar) {
        this.afI.a(i, bVar);
    }

    public void bq(int i) {
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

    public Boolean tC() {
        return this.afJ;
    }

    public void b(Boolean bool) {
        this.afJ = bool;
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
            com.baidu.tbadk.core.elementsMaven.c.bj(d).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }
}
