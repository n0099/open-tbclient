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
    private static final int auJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int auK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean asX;
    private ALAImEnterView auL;
    private ALAImMsgListView auM;
    private ALAImMsgMoreChatView auN;
    private boolean auO;
    private boolean auP;

    public ALaImMsgView(Context context) {
        super(context);
        this.auO = false;
        this.auP = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auO = false;
        this.auP = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auO = false;
        this.auP = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.auM.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.auL = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.auL, layoutParams);
        this.auM = new ALAImMsgListView(context);
        this.auM.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void xR() {
                ALaImMsgView.this.auN.setVisibility(8);
            }
        });
        this.auM.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.auM, layoutParams2);
        this.auN = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.auN, layoutParams3);
        this.auN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.auO) {
                    if (!ALaImMsgView.this.auP) {
                        ALaImMsgView.this.auP = false;
                        ALaImMsgView.this.auN.setVisibility(8);
                        ALaImMsgView.this.auM.xP();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.auM.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auM.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.auM.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.auM.setMsgData(list);
    }

    public boolean G(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.auM.getData().size();
    }

    public void s(com.baidu.live.im.data.a aVar) {
        this.auL.r(aVar);
    }

    @Override // com.baidu.live.im.h
    public void wu() {
        this.auM.wu();
    }

    public void wQ() {
        this.auL.wQ();
        this.auM.wQ();
    }

    public void xQ() {
        this.auL.release();
        this.auM.xQ();
        this.auN.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.auM.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.auM.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.auO = z;
    }

    public void setFromMaster(boolean z) {
        this.asX = z;
        if (this.auM != null) {
            this.auM.setFromMaster(this.asX);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.auO) {
                this.auP = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.auP = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void yc() {
        if (this.auM.xN()) {
            this.auN.setVisibility(0);
        }
    }
}
