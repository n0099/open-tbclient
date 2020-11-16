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
    private ALAImEnterView bSi;
    private ALAImMsgListView bSj;
    private ALAImMsgMoreChatView bSk;
    private boolean biV;
    private TextView bln;
    private boolean blo;
    private boolean blp;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.blo = false;
        this.blp = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blo = false;
        this.blp = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blo = false;
        this.blp = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bSj.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bSi = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bSi, layoutParams);
        this.bSj = new ALAImMsgListView(context);
        this.bSj.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void Mo() {
                ALaImMsgView.this.bSk.setVisibility(8);
            }
        });
        this.bSj.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bSj, layoutParams2);
        this.bSk = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.d.sdk_ds236), context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bSj.getId());
        addView(this.bSk, layoutParams3);
        this.bSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.blo) {
                    if (!ALaImMsgView.this.blp) {
                        ALaImMsgView.this.blp = false;
                        ALaImMsgView.this.bSk.setVisibility(8);
                        ALaImMsgView.this.bSj.Mm();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bSj.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bSj.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bSj.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bSj.setMsgData(list);
    }

    public boolean as(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.bSj.getData().size();
    }

    public void y(com.baidu.live.im.data.a aVar) {
        this.bSi.x(aVar);
    }

    @Override // com.baidu.live.im.j
    public void KZ() {
        this.bSj.KZ();
    }

    public void Kj() {
        this.bSi.Kj();
        this.bSj.Kj();
    }

    public void Mn() {
        this.bSi.release();
        this.bSj.Mn();
        this.bSk.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bSj.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bSj.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blo = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bSj.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.biV = z;
        if (this.bSj != null) {
            this.bSj.setFromMaster(this.biV);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.blo) {
                this.blp = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.blp = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void MD() {
        if (this.bSj.Mk()) {
            this.bSk.setVisibility(0);
        }
    }

    public void ME() {
        if (this.bln != null) {
            this.bln.setVisibility(8);
        }
    }
}
