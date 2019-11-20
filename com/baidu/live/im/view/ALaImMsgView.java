package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.h;
import com.baidu.live.im.view.ALAImMsgListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes6.dex */
public class ALaImMsgView extends RelativeLayout implements h {
    private static final int aic = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int aie = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean agG;
    private ALAImEnterView aif;
    private ALAImMsgListView aig;
    private ALAImMsgMoreChatView aih;
    private boolean aii;
    private boolean aij;

    public ALaImMsgView(Context context) {
        super(context);
        this.aii = false;
        this.aij = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aii = false;
        this.aij = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aii = false;
        this.aij = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aig.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aif = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aif, layoutParams);
        this.aig = new ALAImMsgListView(context);
        this.aig.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void tC() {
                ALaImMsgView.this.aih.setVisibility(8);
            }
        });
        this.aig.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aig, layoutParams2);
        this.aih = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aih, layoutParams3);
        this.aih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aii) {
                    if (!ALaImMsgView.this.aij) {
                        ALaImMsgView.this.aij = false;
                        ALaImMsgView.this.aih.setVisibility(8);
                        ALaImMsgView.this.aig.tA();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aig.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aig.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.aig.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aig.setMsgData(list);
    }

    public boolean J(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aig.getData().size();
    }

    public void l(com.baidu.live.im.data.a aVar) {
        this.aif.k(aVar);
    }

    @Override // com.baidu.live.im.h
    public void sD() {
        this.aig.sD();
    }

    public void sX() {
        this.aif.sX();
        this.aig.sX();
    }

    public void tB() {
        this.aif.release();
        this.aig.tB();
        this.aih.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.aig.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.aig.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aii = z;
    }

    public void setFromMaster(boolean z) {
        this.agG = z;
        if (this.aig != null) {
            this.aig.setFromMaster(this.agG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aii) {
                this.aij = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aij = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void tM() {
        if (this.aig.ty()) {
            this.aih.setVisibility(0);
        }
    }
}
