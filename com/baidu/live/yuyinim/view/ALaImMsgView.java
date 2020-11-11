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
    private ALAImEnterView bTS;
    private ALAImMsgListView bTT;
    private ALAImMsgMoreChatView bTU;
    private boolean bkG;
    private TextView bmY;
    private boolean bmZ;
    private boolean bna;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bmZ = false;
        this.bna = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmZ = false;
        this.bna = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmZ = false;
        this.bna = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bTT.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bTS = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bTS, layoutParams);
        this.bTT = new ALAImMsgListView(context);
        this.bTT.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void MX() {
                ALaImMsgView.this.bTU.setVisibility(8);
            }
        });
        this.bTT.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bTT, layoutParams2);
        this.bTU = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.d.sdk_ds236), context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bTT.getId());
        addView(this.bTU, layoutParams3);
        this.bTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bmZ) {
                    if (!ALaImMsgView.this.bna) {
                        ALaImMsgView.this.bna = false;
                        ALaImMsgView.this.bTU.setVisibility(8);
                        ALaImMsgView.this.bTT.MV();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bTT.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bTT.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bTT.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bTT.setMsgData(list);
    }

    public boolean as(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.bTT.getData().size();
    }

    public void y(com.baidu.live.im.data.a aVar) {
        this.bTS.x(aVar);
    }

    @Override // com.baidu.live.im.j
    public void LI() {
        this.bTT.LI();
    }

    public void KS() {
        this.bTS.KS();
        this.bTT.KS();
    }

    public void MW() {
        this.bTS.release();
        this.bTT.MW();
        this.bTU.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bTT.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bTT.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bmZ = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bTT.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bTT != null) {
            this.bTT.setFromMaster(this.bkG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bmZ) {
                this.bna = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bna = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Nm() {
        if (this.bTT.MT()) {
            this.bTU.setVisibility(0);
        }
    }

    public void Nn() {
        if (this.bmY != null) {
            this.bmY.setVisibility(8);
        }
    }
}
