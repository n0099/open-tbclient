package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.j;
import com.baidu.live.im.view.ALAImMsgListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean aMl;
    private ALAImEnterView aOm;
    private ALAImMsgListView aOn;
    private ALAImMsgMoreChatView aOo;
    private boolean aOp;
    private boolean aOq;

    public ALaImMsgView(Context context) {
        super(context);
        this.aOp = false;
        this.aOq = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOp = false;
        this.aOq = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOp = false;
        this.aOq = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aOn.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aOm = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aOm, layoutParams);
        this.aOn = new ALAImMsgListView(context);
        this.aOn.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void CH() {
                ALaImMsgView.this.aOo.setVisibility(8);
            }
        });
        this.aOn.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aOn, layoutParams2);
        this.aOo = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aOo, layoutParams3);
        this.aOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aOp) {
                    if (!ALaImMsgView.this.aOq) {
                        ALaImMsgView.this.aOq = false;
                        ALaImMsgView.this.aOo.setVisibility(8);
                        ALaImMsgView.this.aOn.CF();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aOn.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aOn.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.aOn.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aOn.setMsgData(list);
    }

    public boolean L(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aOn.getData().size();
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.aOm.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void Be() {
        this.aOn.Be();
    }

    public void BB() {
        this.aOm.BB();
        this.aOn.BB();
    }

    public void CG() {
        this.aOm.release();
        this.aOn.CG();
        this.aOo.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        this.aOn.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.aOn.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aOp = z;
    }

    public void setFromMaster(boolean z) {
        this.aMl = z;
        if (this.aOn != null) {
            this.aOn.setFromMaster(this.aMl);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aOp) {
                this.aOq = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aOq = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void CU() {
        if (this.aOn.CD()) {
            this.aOo.setVisibility(0);
        }
    }
}
