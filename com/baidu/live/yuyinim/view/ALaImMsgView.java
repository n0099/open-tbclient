package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinim.view.ALAImMsgListView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private ALAImEnterView bOj;
    private ALAImMsgListView bOk;
    private ALAImMsgMoreChatView bOl;
    private boolean bjm;
    private TextView blE;
    private boolean blF;
    private boolean blG;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.blF = false;
        this.blG = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blF = false;
        this.blG = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blF = false;
        this.blG = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bOk.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bOj = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.bOj, layoutParams);
        this.bOk = new ALAImMsgListView(context);
        this.bOk.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void Mx() {
                ALaImMsgView.this.bOl.setVisibility(8);
            }
        });
        this.bOk.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bOk, layoutParams2);
        this.bOl = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.bOk.getId());
        addView(this.bOl, layoutParams3);
        this.bOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.blF) {
                    if (!ALaImMsgView.this.blG) {
                        ALaImMsgView.this.blG = false;
                        ALaImMsgView.this.bOl.setVisibility(8);
                        ALaImMsgView.this.bOk.Mv();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bOk.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bOk.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bOk.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bOk.setMsgData(list);
    }

    public boolean al(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.bOk.getData().size();
    }

    public void x(com.baidu.live.im.data.a aVar) {
        this.bOj.w(aVar);
    }

    @Override // com.baidu.live.im.j
    public void Li() {
        this.bOk.Li();
    }

    public void Ks() {
        this.bOj.Ks();
        this.bOk.Ks();
    }

    public void Mw() {
        this.bOj.release();
        this.bOk.Mw();
        this.bOl.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bOk.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bOk.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blF = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bOk.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bjm = z;
        if (this.bOk != null) {
            this.bOk.setFromMaster(this.bjm);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.blF) {
                this.blG = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.blG = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void MM() {
        if (this.bOk.Mt()) {
            this.bOl.setVisibility(0);
        }
    }

    public void MN() {
        if (this.blE != null) {
            this.blE.setVisibility(8);
        }
    }
}
