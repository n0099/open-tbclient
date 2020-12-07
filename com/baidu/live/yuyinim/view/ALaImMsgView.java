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
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinim.view.ALAImMsgListView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private ALAImMsgMoreChatView bXA;
    private ALAImEnterView bXy;
    private ALAImMsgListView bXz;
    private boolean bnn;
    private boolean bqA;
    private boolean bqB;
    private TextView bqy;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bqA = false;
        this.bqB = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqA = false;
        this.bqB = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqA = false;
        this.bqB = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bXz.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bXy = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bXy, layoutParams);
        this.bXz = new ALAImMsgListView(context);
        this.bXz.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void OJ() {
                ALaImMsgView.this.bXA.setVisibility(8);
            }
        });
        this.bXz.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bXz, layoutParams2);
        this.bXA = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.d.sdk_ds236), context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bXz.getId());
        addView(this.bXA, layoutParams3);
        this.bXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bqA) {
                    if (!ALaImMsgView.this.bqB) {
                        ALaImMsgView.this.bqB = false;
                        ALaImMsgView.this.bXA.setVisibility(8);
                        ALaImMsgView.this.bXz.OH();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bXz.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bXz.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bXz.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        this.bXz.setMsgData(list);
    }

    public boolean au(List<b> list) {
        return list.size() != this.bXz.getData().size();
    }

    public void z(b bVar) {
        this.bXy.y(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Nc() {
        this.bXz.Nc();
    }

    public void Ml() {
        this.bXy.Ml();
        this.bXz.Ml();
    }

    public void OI() {
        this.bXy.release();
        this.bXz.OI();
        this.bXA.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bXz.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bXz.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bqA = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bXz.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bXz != null) {
            this.bXz.setFromMaster(this.bnn);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bqA) {
                this.bqB = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bqB = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void OZ() {
        if (this.bXz.OF()) {
            this.bXA.setVisibility(0);
        }
    }

    public void ZW() {
        if (this.bqy != null) {
            this.bqy.setVisibility(8);
        }
    }
}
