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
/* loaded from: classes11.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bnA;
    private TextView brd;
    private boolean brf;
    private boolean brg;
    private int brh;
    private int bri;
    private ALAImEnterView cdA;
    private ALAImMsgListView cdB;
    private ALAImMsgMoreChatView cdC;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cdB.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.cdA = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.cdA, layoutParams);
        this.cdB = new ALAImMsgListView(context);
        this.cdB.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void LR() {
                ALaImMsgView.this.brh = 0;
                ALaImMsgView.this.cdC.setVisibility(8);
            }
        });
        this.cdB.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.cdB, layoutParams2);
        this.cdC = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.cdB.getId());
        addView(this.cdC, layoutParams3);
        this.cdC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.brf) {
                    ALaImMsgView.this.brh = 0;
                    if (!ALaImMsgView.this.brg) {
                        ALaImMsgView.this.brg = false;
                        ALaImMsgView.this.cdC.setVisibility(8);
                        ALaImMsgView.this.cdB.LQ();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.cdB.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.cdB.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.cdB.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        LogUtils.e(">>>>>>", "msgList.size:" + list.size() + " mListView.getData().size():" + this.cdB.getData().size() + " newMsgSize: " + this.brh + " lastVisitPos:" + this.bri + " mListView.getLastVisiblePosition():" + this.cdB.getLastVisiblePosition());
        if (list != null) {
            if (this.cdB.getLastVisiblePosition() > list.size()) {
                this.bri = Math.max(0, this.bri);
            } else {
                this.bri = Math.max(this.cdB.getLastVisiblePosition(), this.bri);
            }
            this.brh = Math.max((list.size() - this.bri) - 1, 0);
            this.cdB.setMsgData(list);
        }
    }

    public boolean aw(List<b> list) {
        return list.size() != this.cdB.getData().size();
    }

    public void H(b bVar) {
        this.cdA.G(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Kc() {
        this.cdB.Kc();
    }

    public void Jg() {
        this.bri = 0;
        this.cdA.Jg();
        this.cdB.Jg();
    }

    public void KJ() {
        this.cdA.release();
        this.cdB.KJ();
        this.cdC.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.cdB.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.cdB.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.brf = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.cdB.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bnA = z;
        if (this.cdB != null) {
            this.cdB.setFromMaster(this.bnA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.brf) {
                this.brg = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.brg = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Mn() {
        if (this.cdB.LO() && this.brh > 0) {
            this.cdC.setVisibility(0);
            this.cdC.setNewMessageSize(this.brh);
        }
    }

    public void ZJ() {
        if (this.brd != null) {
            this.brd.setVisibility(8);
        }
    }
}
