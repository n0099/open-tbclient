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
    private boolean aMr;
    private ALAImEnterView aOs;
    private ALAImMsgListView aOt;
    private ALAImMsgMoreChatView aOu;
    private boolean aOv;
    private boolean aOw;

    public ALaImMsgView(Context context) {
        super(context);
        this.aOv = false;
        this.aOw = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOv = false;
        this.aOw = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOv = false;
        this.aOw = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.aOt.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aOs = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aOs, layoutParams);
        this.aOt = new ALAImMsgListView(context);
        this.aOt.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void CG() {
                ALaImMsgView.this.aOu.setVisibility(8);
            }
        });
        this.aOt.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aOt, layoutParams2);
        this.aOu = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(12);
        addView(this.aOu, layoutParams3);
        this.aOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aOv) {
                    if (!ALaImMsgView.this.aOw) {
                        ALaImMsgView.this.aOw = false;
                        ALaImMsgView.this.aOu.setVisibility(8);
                        ALaImMsgView.this.aOt.CE();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aOt.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aOt.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.aOt.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aOt.setMsgData(list);
    }

    public boolean L(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aOt.getData().size();
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.aOs.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void Bd() {
        this.aOt.Bd();
    }

    public void BA() {
        this.aOs.BA();
        this.aOt.BA();
    }

    public void CF() {
        this.aOs.release();
        this.aOt.CF();
        this.aOu.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        this.aOt.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.aOt.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aOv = z;
    }

    public void setFromMaster(boolean z) {
        this.aMr = z;
        if (this.aOt != null) {
            this.aOt.setFromMaster(this.aMr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aOv) {
                this.aOw = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aOw = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void CT() {
        if (this.aOt.CC()) {
            this.aOu.setVisibility(0);
        }
    }
}
