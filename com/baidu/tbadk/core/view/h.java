package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends ImageView {
    private long alO;
    private int alP;
    private int alQ;
    i alR;
    private View.OnClickListener alS;
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
        this.alO = 0L;
        this.alS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.wM();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h.this.alO > 500) {
                    h.this.wL();
                }
                h.this.alO = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        d(tbPageContext);
    }

    private void d(TbPageContext tbPageContext) {
        this.alR = new i(tbPageContext, this);
        setOnClickListener(this.alS);
        ai.c(this, d.g.icon_home_feedback_selector);
        this.alP = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds60);
        this.alQ = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.alR.setUniqueId(bdUniqueId);
    }

    public void wK() {
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.height = g;
        setLayoutParams(layoutParams);
        setPadding(this.alP, 0, this.alQ, 0);
    }

    public void setLeftPadding(int i) {
        this.alP = i;
        setPadding(i, 0, this.alQ, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL() {
        this.alR.wL();
    }

    public void wM() {
        this.alR.wM();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.alR.onDetachedFromWindow();
    }

    public void setData(an anVar) {
        this.alR.setData(anVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alR.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        ai.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.alR.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.alR.setDefaultReasonArray(strArr);
    }
}
