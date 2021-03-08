package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinim.view.ALAImMsgListView;
import java.util.List;
/* loaded from: classes10.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bpa;
    private TextView bsD;
    private boolean bsF;
    private boolean bsG;
    private int bsH;
    private int bsI;
    private ALAImEnterView cfa;
    private ALAImMsgListView cfb;
    private ALAImMsgMoreChatView cfc;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cfb.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.cfa = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.cfa, layoutParams);
        this.cfb = new ALAImMsgListView(context);
        this.cfb.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void LU() {
                ALaImMsgView.this.bsH = 0;
                ALaImMsgView.this.cfc.setVisibility(8);
            }
        });
        this.cfb.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.cfb, layoutParams2);
        this.cfc = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.cfb.getId());
        addView(this.cfc, layoutParams3);
        this.cfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bsF) {
                    ALaImMsgView.this.bsH = 0;
                    if (!ALaImMsgView.this.bsG) {
                        ALaImMsgView.this.bsG = false;
                        ALaImMsgView.this.cfc.setVisibility(8);
                        ALaImMsgView.this.cfb.LT();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.cfb.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.cfb.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.cfb.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        LogUtils.e(">>>>>>", "msgList.size:" + list.size() + " mListView.getData().size():" + this.cfb.getData().size() + " newMsgSize: " + this.bsH + " lastVisitPos:" + this.bsI + " mListView.getLastVisiblePosition():" + this.cfb.getLastVisiblePosition());
        if (list != null) {
            if (this.cfb.getLastVisiblePosition() > list.size()) {
                this.bsI = Math.max(0, this.bsI);
            } else {
                this.bsI = Math.max(this.cfb.getLastVisiblePosition(), this.bsI);
            }
            this.bsH = Math.max((list.size() - this.bsI) - 1, 0);
            this.cfb.setMsgData(list);
        }
    }

    public boolean aw(List<b> list) {
        return list.size() != this.cfb.getData().size();
    }

    public void H(b bVar) {
        this.cfa.G(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Kf() {
        this.cfb.Kf();
    }

    public void Jj() {
        this.bsI = 0;
        this.cfa.Jj();
        this.cfb.Jj();
    }

    public void KM() {
        this.cfa.release();
        this.cfb.KM();
        this.cfc.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.cfb.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.cfb.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsF = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.cfb.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bpa = z;
        if (this.cfb != null) {
            this.cfb.setFromMaster(this.bpa);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bsF) {
                this.bsG = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bsG = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Mq() {
        if (this.cfb.LR() && this.bsH > 0) {
            this.cfc.setVisibility(0);
            this.cfc.setNewMessageSize(this.bsH);
        }
    }

    public void ZM() {
        if (this.bsD != null) {
            this.bsD.setVisibility(8);
        }
    }
}
