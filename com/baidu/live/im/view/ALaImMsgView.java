package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.j;
import com.baidu.live.im.view.ALAImMsgListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaLiveTagActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bed;
    private ALAImEnterView bgq;
    private ALAImMsgListView bgr;
    private ALAImMsgMoreChatView bgt;
    private TextView bgu;
    private boolean bgv;
    private boolean bgw;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bgv = false;
        this.bgw = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgv = false;
        this.bgw = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgv = false;
        this.bgw = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bgr.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bgq = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.e.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.bgq, layoutParams);
        this.bgr = new ALAImMsgListView(context);
        this.bgr.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void KY() {
                ALaImMsgView.this.bgt.setVisibility(8);
            }
        });
        this.bgr.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bgr, layoutParams2);
        this.bgt = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.bgr.getId());
        addView(this.bgt, layoutParams3);
        this.bgt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bgv) {
                    if (!ALaImMsgView.this.bgw) {
                        ALaImMsgView.this.bgw = false;
                        ALaImMsgView.this.bgt.setVisibility(8);
                        ALaImMsgView.this.bgr.KW();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bgr.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bgr.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bgr.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bgr.setMsgData(list);
    }

    public boolean U(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.bgr.getData().size() && list.get(list.size() + (-1)) == this.bgr.getData().get(this.bgr.getData().size() + (-1))) ? false : true;
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.bgq.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void JI() {
        this.bgr.JI();
    }

    public void JY() {
        Lp();
        this.bgq.JY();
        this.bgr.JY();
    }

    public void KX() {
        this.bgq.release();
        this.bgr.KX();
        this.bgt.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bgr.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bgr.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bgv = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bgr.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bed = z;
        if (this.bgr != null) {
            this.bgr.setFromMaster(this.bed);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bgv) {
                this.bgw = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bgw = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Ln() {
        if (this.bgr.KU()) {
            this.bgt.setVisibility(0);
        }
    }

    public void av(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bgu == null) {
            this.bgu = new AlaImAddTagTextView(getContext());
            this.bgu.setId(a.g.ala_im_add_tag);
            this.bgu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("live_id", str);
                        jSONObject.put("vid", ALaImMsgView.this.mVid == null ? "" : ALaImMsgView.this.mVid);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "add_ impression").setContentExt("im", "", jSONObject));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTagActivityConfig(ALaImMsgView.this.mTbPageContext.getPageActivity(), str2, str)));
                }
            });
            addView(this.bgu);
        }
        if (this.bgu.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bgu.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bgr.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.bgu.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bgr.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.removeRule(12);
        } else {
            layoutParams2.addRule(12, 0);
        }
        layoutParams2.addRule(2, this.bgu.getId());
        this.bgr.setLayoutParams(layoutParams2);
        this.bgu.setVisibility(0);
    }

    public void Lo() {
        if (this.bgu != null) {
            this.bgu.setVisibility(8);
        }
        Lp();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bgr.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bgr.getHeight();
    }

    private void Lp() {
        if (this.bgr != null) {
            ViewGroup.LayoutParams layoutParams = this.bgr.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.bgr.setLayoutParams(layoutParams);
            }
        }
    }
}
