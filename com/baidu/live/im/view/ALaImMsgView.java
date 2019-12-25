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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* loaded from: classes2.dex */
public class ALaImMsgView extends RelativeLayout implements h {
    private static final int aqc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds340);
    private static final int aqd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds154);
    private boolean aoH;
    private ALAImEnterView aqe;
    private ALAImMsgListView aqf;
    private ALAImMsgMoreChatView aqg;
    private boolean aqh;
    private boolean aqi;

    public ALaImMsgView(Context context) {
        super(context);
        this.aqh = false;
        this.aqi = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqh = false;
        this.aqi = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqh = false;
        this.aqi = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aqf.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aqe = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aqe, layoutParams);
        this.aqf = new ALAImMsgListView(context);
        this.aqf.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void vw() {
                ALaImMsgView.this.aqg.setVisibility(8);
            }
        });
        this.aqf.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aqf, layoutParams2);
        this.aqg = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aqg, layoutParams3);
        this.aqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aqh) {
                    if (!ALaImMsgView.this.aqi) {
                        ALaImMsgView.this.aqi = false;
                        ALaImMsgView.this.aqg.setVisibility(8);
                        ALaImMsgView.this.aqf.vu();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aqf.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aqf.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.aqf.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aqf.setMsgData(list);
    }

    public boolean H(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aqf.getData().size();
    }

    public void l(com.baidu.live.im.data.a aVar) {
        this.aqe.k(aVar);
    }

    @Override // com.baidu.live.im.h
    public void uu() {
        this.aqf.uu();
    }

    public void uQ() {
        this.aqe.uQ();
        this.aqf.uQ();
    }

    public void vv() {
        this.aqe.release();
        this.aqf.vv();
        this.aqg.setVisibility(8);
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        this.aqf.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        this.aqf.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aqh = z;
    }

    public void setFromMaster(boolean z) {
        this.aoH = z;
        if (this.aqf != null) {
            this.aqf.setFromMaster(this.aoH);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aqh) {
                this.aqi = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aqi = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void vI() {
        if (this.aqf.vs()) {
            this.aqg.setVisibility(0);
        }
    }
}
