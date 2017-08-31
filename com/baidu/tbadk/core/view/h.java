package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends ImageView {
    private long ali;
    private int alj;
    private int alk;
    i alm;
    private View.OnClickListener aln;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(an anVar);

        void a(an anVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, an anVar);
    }

    public h(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.ali = 0L;
        this.aln = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.wK();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h.this.ali > 500) {
                    h.this.wJ();
                }
                h.this.ali = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        d(tbPageContext);
    }

    private void d(TbPageContext tbPageContext) {
        this.alm = new i(tbPageContext, this);
        setOnClickListener(this.aln);
        aj.c(this, d.g.icon_home_feedback_selector);
        this.alj = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds60);
        this.alk = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.alm.setUniqueId(bdUniqueId);
    }

    public void wI() {
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.height = g;
        setLayoutParams(layoutParams);
        setPadding(this.alj, 0, this.alk, 0);
    }

    public void setLeftPadding(int i) {
        this.alj = i;
        setPadding(i, 0, this.alk, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ() {
        this.alm.wJ();
    }

    public void wK() {
        this.alm.wK();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.alm.onDetachedFromWindow();
    }

    public void setData(an anVar) {
        this.alm.setData(anVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alm.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.alm.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.alm.setDefaultReasonArray(strArr);
    }
}
