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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALaImMsgView extends RelativeLayout implements h {
    private static final int auy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int auz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean asM;
    private ALAImEnterView auA;
    private ALAImMsgListView auB;
    private ALAImMsgMoreChatView auC;
    private boolean auD;
    private boolean auE;

    public ALaImMsgView(Context context) {
        super(context);
        this.auD = false;
        this.auE = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auD = false;
        this.auE = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auD = false;
        this.auE = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.auB.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.auA = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.auA, layoutParams);
        this.auB = new ALAImMsgListView(context);
        this.auB.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void xM() {
                ALaImMsgView.this.auC.setVisibility(8);
            }
        });
        this.auB.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.auB, layoutParams2);
        this.auC = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.auC, layoutParams3);
        this.auC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.auD) {
                    if (!ALaImMsgView.this.auE) {
                        ALaImMsgView.this.auE = false;
                        ALaImMsgView.this.auC.setVisibility(8);
                        ALaImMsgView.this.auB.xK();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.auB.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auB.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.auB.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.auB.setMsgData(list);
    }

    public boolean G(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.auB.getData().size();
    }

    public void s(com.baidu.live.im.data.a aVar) {
        this.auA.r(aVar);
    }

    @Override // com.baidu.live.im.h
    public void wp() {
        this.auB.wp();
    }

    public void wL() {
        this.auA.wL();
        this.auB.wL();
    }

    public void xL() {
        this.auA.release();
        this.auB.xL();
        this.auC.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.auB.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.auB.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auD = z;
    }

    public void setFromMaster(boolean z) {
        this.asM = z;
        if (this.auB != null) {
            this.auB.setFromMaster(this.asM);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.auD) {
                this.auE = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.auE = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xX() {
        if (this.auB.xI()) {
            this.auC.setVisibility(0);
        }
    }
}
