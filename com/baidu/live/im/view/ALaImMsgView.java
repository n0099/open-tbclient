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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes2.dex */
public class ALaImMsgView extends RelativeLayout implements h {
    private static final int aqO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int aqP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean apu;
    private ALAImEnterView aqQ;
    private ALAImMsgListView aqR;
    private ALAImMsgMoreChatView aqS;
    private boolean aqT;
    private boolean aqU;

    public ALaImMsgView(Context context) {
        super(context);
        this.aqT = false;
        this.aqU = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqT = false;
        this.aqU = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqT = false;
        this.aqU = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aqR.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aqQ = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aqQ, layoutParams);
        this.aqR = new ALAImMsgListView(context);
        this.aqR.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void vN() {
                ALaImMsgView.this.aqS.setVisibility(8);
            }
        });
        this.aqR.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aqR, layoutParams2);
        this.aqS = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aqS, layoutParams3);
        this.aqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aqT) {
                    if (!ALaImMsgView.this.aqU) {
                        ALaImMsgView.this.aqU = false;
                        ALaImMsgView.this.aqS.setVisibility(8);
                        ALaImMsgView.this.aqR.vL();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aqR.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aqR.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.aqR.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aqR.setMsgData(list);
    }

    public boolean G(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aqR.getData().size();
    }

    public void l(com.baidu.live.im.data.a aVar) {
        this.aqQ.k(aVar);
    }

    @Override // com.baidu.live.im.h
    public void uL() {
        this.aqR.uL();
    }

    public void vh() {
        this.aqQ.vh();
        this.aqR.vh();
    }

    public void vM() {
        this.aqQ.release();
        this.aqR.vM();
        this.aqS.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.aqR.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.aqR.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aqT = z;
    }

    public void setFromMaster(boolean z) {
        this.apu = z;
        if (this.aqR != null) {
            this.aqR.setFromMaster(this.apu);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aqT) {
                this.aqU = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aqU = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void vZ() {
        if (this.aqR.vJ()) {
            this.aqS.setVisibility(0);
        }
    }
}
