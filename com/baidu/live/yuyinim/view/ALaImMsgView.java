package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
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
    private ALAImEnterView bZu;
    private ALAImMsgListView bZv;
    private ALAImMsgMoreChatView bZw;
    private boolean bkh;
    private TextView bnC;
    private boolean bnE;
    private boolean bnF;
    private int bnG;
    private int bnH;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bZv.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bZu = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bZu, layoutParams);
        this.bZv = new ALAImMsgListView(context);
        this.bZv.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void Kt() {
                ALaImMsgView.this.bnG = 0;
                ALaImMsgView.this.bZw.setVisibility(8);
            }
        });
        this.bZv.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bZv, layoutParams2);
        this.bZw = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bZv.getId());
        addView(this.bZw, layoutParams3);
        this.bZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bnE) {
                    ALaImMsgView.this.bnG = 0;
                    if (!ALaImMsgView.this.bnF) {
                        ALaImMsgView.this.bnF = false;
                        ALaImMsgView.this.bZw.setVisibility(8);
                        ALaImMsgView.this.bZv.Ks();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bZv.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bZv.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bZv.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        LogUtils.e(">>>>>>", "msgList.size:" + list.size() + " mListView.getData().size():" + this.bZv.getData().size() + " newMsgSize: " + this.bnG + " lastVisitPos:" + this.bnH + " mListView.getLastVisiblePosition():" + this.bZv.getLastVisiblePosition());
        if (list != null) {
            if (this.bZv.getLastVisiblePosition() > list.size()) {
                this.bnH = Math.max(0, this.bnH);
            } else {
                this.bnH = Math.max(this.bZv.getLastVisiblePosition(), this.bnH);
            }
            this.bnG = Math.max((list.size() - this.bnH) - 1, 0);
            this.bZv.setMsgData(list);
        }
    }

    public boolean az(List<b> list) {
        return list.size() != this.bZv.getData().size();
    }

    public void B(b bVar) {
        this.bZu.A(bVar);
    }

    @Override // com.baidu.live.im.j
    public void IE() {
        this.bZv.IE();
    }

    public void HN() {
        this.bnH = 0;
        this.bZu.HN();
        this.bZv.HN();
    }

    public void Jl() {
        this.bZu.release();
        this.bZv.Jl();
        this.bZw.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bZv.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bZv.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bnE = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bZv.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bkh = z;
        if (this.bZv != null) {
            this.bZv.setFromMaster(this.bkh);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bnE) {
                this.bnF = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bnF = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void KP() {
        if (this.bZv.Kq() && this.bnG > 0) {
            this.bZw.setVisibility(0);
            this.bZw.setNewMessageSize(this.bnG);
        }
    }

    public void XS() {
        if (this.bnC != null) {
            this.bnC.setVisibility(8);
        }
    }
}
