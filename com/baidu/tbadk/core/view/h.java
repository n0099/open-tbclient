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
    private long aku;
    private int akv;
    private int akw;
    i akx;
    private View.OnClickListener aky;
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
        this.aku = 0L;
        this.aky = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.wC();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h.this.aku > 500) {
                    h.this.wB();
                }
                h.this.aku = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        d(tbPageContext);
    }

    private void d(TbPageContext tbPageContext) {
        this.akx = new i(tbPageContext, this);
        setOnClickListener(this.aky);
        ai.c(this, d.g.icon_home_feedback_selector);
        this.akv = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds60);
        this.akw = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.akx.setUniqueId(bdUniqueId);
    }

    public void wA() {
        int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds48);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.height = g;
        setLayoutParams(layoutParams);
        setPadding(this.akv, 0, this.akw, 0);
    }

    public void setLeftPadding(int i) {
        this.akv = i;
        setPadding(i, 0, this.akw, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB() {
        this.akx.wB();
    }

    public void wC() {
        this.akx.wC();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.akx.onDetachedFromWindow();
    }

    public void setData(an anVar) {
        this.akx.setData(anVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.akx.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        ai.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.akx.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.akx.setDefaultReasonArray(strArr);
    }
}
