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
    private boolean asN;
    private ALAImEnterView auB;
    private ALAImMsgListView auC;
    private ALAImMsgMoreChatView auD;
    private boolean auE;
    private boolean auF;
    private static final int auz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int auA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);

    public ALaImMsgView(Context context) {
        super(context);
        this.auE = false;
        this.auF = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auE = false;
        this.auF = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auE = false;
        this.auF = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.auC.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.auB = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.auB, layoutParams);
        this.auC = new ALAImMsgListView(context);
        this.auC.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void xM() {
                ALaImMsgView.this.auD.setVisibility(8);
            }
        });
        this.auC.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.auC, layoutParams2);
        this.auD = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.auD, layoutParams3);
        this.auD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.auE) {
                    if (!ALaImMsgView.this.auF) {
                        ALaImMsgView.this.auF = false;
                        ALaImMsgView.this.auD.setVisibility(8);
                        ALaImMsgView.this.auC.xK();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.auC.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auC.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.auC.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.auC.setMsgData(list);
    }

    public boolean G(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.auC.getData().size();
    }

    public void s(com.baidu.live.im.data.a aVar) {
        this.auB.r(aVar);
    }

    @Override // com.baidu.live.im.h
    public void wp() {
        this.auC.wp();
    }

    public void wL() {
        this.auB.wL();
        this.auC.wL();
    }

    public void xL() {
        this.auB.release();
        this.auC.xL();
        this.auD.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.auC.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.auC.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auE = z;
    }

    public void setFromMaster(boolean z) {
        this.asN = z;
        if (this.auC != null) {
            this.auC.setFromMaster(this.asN);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.auE) {
                this.auF = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.auF = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void xX() {
        if (this.auC.xI()) {
            this.auD.setVisibility(0);
        }
    }
}
