package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.core.data.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tbadk.core.data.a> implements p<T>, q {
    protected ak ahd;
    private Boolean ahe = false;
    private com.baidu.tieba.card.aa<T> ahf;
    public InterfaceC0089a ahg;
    protected Context mContext;

    /* renamed from: com.baidu.card.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void a(com.baidu.tbadk.core.data.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getView();

    public a(Context context) {
        this.mContext = context;
    }

    public void a(ak akVar) {
        this.ahd = akVar;
    }

    public void bs(int i) {
    }

    public void bt(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tb() {
    }

    public com.baidu.tieba.card.aa<T> tc() {
        return this.ahf;
    }

    public void setOnCardSubClickListener(com.baidu.tieba.card.aa<T> aaVar) {
        this.ahf = aaVar;
    }

    public void a(int i, a.b bVar) {
        this.ahd.a(i, bVar);
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

    public Boolean td() {
        return this.ahe;
    }

    public void c(Boolean bool) {
        this.ahe = bool;
    }

    private ThreadCardView f(View view, int i) {
        if (view == null || view.getParent() == null || i == 0) {
            return null;
        }
        if (view.getParent() instanceof ThreadCardView) {
            return (ThreadCardView) view.getParent();
        }
        return f((View) view.getParent(), i - 1);
    }

    public void g(View view, int i) {
        ThreadCardView f = f(view, i);
        if (f != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(f).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }
}
