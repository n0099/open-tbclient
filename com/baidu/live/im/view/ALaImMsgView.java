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
    private static final int aiv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int aiw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean agY;
    private boolean aiA;
    private boolean aiB;
    private ALAImEnterView aix;
    private ALAImMsgListView aiy;
    private ALAImMsgMoreChatView aiz;

    public ALaImMsgView(Context context) {
        super(context);
        this.aiA = false;
        this.aiB = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiA = false;
        this.aiB = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiA = false;
        this.aiB = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aiy.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aix = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aix, layoutParams);
        this.aiy = new ALAImMsgListView(context);
        this.aiy.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void tB() {
                ALaImMsgView.this.aiz.setVisibility(8);
            }
        });
        this.aiy.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aiy, layoutParams2);
        this.aiz = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aiz, layoutParams3);
        this.aiz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aiA) {
                    if (!ALaImMsgView.this.aiB) {
                        ALaImMsgView.this.aiB = false;
                        ALaImMsgView.this.aiz.setVisibility(8);
                        ALaImMsgView.this.aiy.tz();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aiy.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aiy.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.aiy.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aiy.setMsgData(list);
    }

    public boolean J(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aiy.getData().size();
    }

    public void k(com.baidu.live.im.data.a aVar) {
        this.aix.j(aVar);
    }

    @Override // com.baidu.live.im.h
    public void sC() {
        this.aiy.sC();
    }

    public void sW() {
        this.aix.sW();
        this.aiy.sW();
    }

    public void tA() {
        this.aix.release();
        this.aiy.tA();
        this.aiz.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.aiy.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.aiy.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aiA = z;
    }

    public void setFromMaster(boolean z) {
        this.agY = z;
        if (this.aiy != null) {
            this.aiy.setFromMaster(this.agY);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aiA) {
                this.aiB = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aiB = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void tL() {
        if (this.aiy.tx()) {
            this.aiz.setVisibility(0);
        }
    }
}
