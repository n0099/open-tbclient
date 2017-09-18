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
    private long alh;
    private int ali;
    private int alj;
    i alk;
    private View.OnClickListener alm;
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
        this.alh = 0L;
        this.alm = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.wK();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h.this.alh > 500) {
                    h.this.wJ();
                }
                h.this.alh = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        d(tbPageContext);
    }

    private void d(TbPageContext tbPageContext) {
        this.alk = new i(tbPageContext, this);
        setOnClickListener(this.alm);
        aj.c(this, d.g.icon_home_feedback_selector);
        this.ali = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds60);
        this.alj = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds16);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.alk.setUniqueId(bdUniqueId);
    }

    public void wI() {
        int f = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds48);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.height = f;
        setLayoutParams(layoutParams);
        setPadding(this.ali, 0, this.alj, 0);
    }

    public void setLeftPadding(int i) {
        this.ali = i;
        setPadding(i, 0, this.alj, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ() {
        this.alk.wJ();
    }

    public void wK() {
        this.alk.wK();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.alk.onDetachedFromWindow();
    }

    public void setData(an anVar) {
        this.alk.setData(anVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alk.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.alk.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.alk.setDefaultReasonArray(strArr);
    }
}
