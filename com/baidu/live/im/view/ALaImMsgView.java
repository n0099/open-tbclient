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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveTagActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bjm;
    private ALAImEnterView blB;
    private ALAImMsgListView blC;
    private ALAImMsgMoreChatView blD;
    private TextView blE;
    private boolean blF;
    private boolean blG;
    private int blH;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.blF = false;
        this.blG = false;
        this.blH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blF = false;
        this.blG = false;
        this.blH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blF = false;
        this.blG = false;
        this.blH = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.blC.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.blB = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.e.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.blB, layoutParams);
        this.blC = new ALAImMsgListView(context);
        this.blC.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Mx() {
                ALaImMsgView.this.blH = 0;
                ALaImMsgView.this.blD.setVisibility(8);
            }
        });
        this.blC.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.blC, layoutParams2);
        this.blD = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.blC.getId());
        addView(this.blD, layoutParams3);
        this.blD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.blF) {
                    if (!ALaImMsgView.this.blG) {
                        ALaImMsgView.this.blG = false;
                        ALaImMsgView.this.blD.setVisibility(8);
                        ALaImMsgView.this.blC.Mv();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.blC.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.blC.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.blC.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.blH += Math.max(list.size() - this.blC.getData().size(), 0);
        this.blC.setMsgData(list);
    }

    public boolean X(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.blC.getData().size() && list.get(list.size() + (-1)) == this.blC.getData().get(this.blC.getData().size() + (-1))) ? false : true;
    }

    public void x(com.baidu.live.im.data.a aVar) {
        this.blB.w(aVar);
    }

    @Override // com.baidu.live.im.j
    public void Li() {
        this.blC.Li();
    }

    public void Ks() {
        MO();
        this.blB.Ks();
        this.blC.Ks();
    }

    public void Mw() {
        this.blB.release();
        this.blC.Mw();
        this.blD.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.blC.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.blC.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blF = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.blC.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bjm = z;
        if (this.blC != null) {
            this.blC.setFromMaster(this.bjm);
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
        if (this.blC.Mt() && this.blH > 0) {
            this.blD.setVisibility(0);
            this.blD.setNewMessageSize(this.blH);
        }
    }

    public void ay(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.blE == null) {
            this.blE = new AlaImAddTagTextView(getContext());
            this.blE.setId(a.g.ala_im_add_tag);
            this.blE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(ALaImMsgView.this.mTbPageContext.getPageActivity());
                        return;
                    }
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
            addView(this.blE);
        }
        if (this.blE.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.blE.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.blC.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.blE.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.blC.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.removeRule(12);
        } else {
            layoutParams2.addRule(12, 0);
        }
        layoutParams2.addRule(2, this.blE.getId());
        this.blC.setLayoutParams(layoutParams2);
        this.blE.setVisibility(0);
    }

    public void MN() {
        if (this.blE != null) {
            this.blE.setVisibility(8);
        }
        MO();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.blC.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.blC.getHeight();
    }

    private void MO() {
        if (this.blC != null) {
            ViewGroup.LayoutParams layoutParams = this.blC.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.blC.setLayoutParams(layoutParams);
            }
        }
    }
}
