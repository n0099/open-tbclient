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
    private boolean bkG;
    private ALAImEnterView bmV;
    private ALAImMsgListView bmW;
    private ALAImMsgMoreChatView bmX;
    private TextView bmY;
    private boolean bmZ;
    private boolean bna;
    private int bnb;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bmZ = false;
        this.bna = false;
        this.bnb = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmZ = false;
        this.bna = false;
        this.bnb = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmZ = false;
        this.bna = false;
        this.bnb = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bmW.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bmV = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bmV, layoutParams);
        this.bmW = new ALAImMsgListView(context);
        this.bmW.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void MX() {
                ALaImMsgView.this.bnb = 0;
                ALaImMsgView.this.bmX.setVisibility(8);
            }
        });
        this.bmW.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bmW, layoutParams2);
        this.bmX = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bmW.getId());
        addView(this.bmX, layoutParams3);
        this.bmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bmZ) {
                    if (!ALaImMsgView.this.bna) {
                        ALaImMsgView.this.bna = false;
                        ALaImMsgView.this.bmX.setVisibility(8);
                        ALaImMsgView.this.bmW.MV();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bmW.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bmW.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bmW.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bnb += Math.max(list.size() - this.bmW.getData().size(), 0);
        this.bmW.setMsgData(list);
    }

    public boolean X(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.bmW.getData().size() && list.get(list.size() + (-1)) == this.bmW.getData().get(this.bmW.getData().size() + (-1))) ? false : true;
    }

    public void y(com.baidu.live.im.data.a aVar) {
        this.bmV.x(aVar);
    }

    @Override // com.baidu.live.im.j
    public void LI() {
        this.bmW.LI();
    }

    public void KS() {
        No();
        this.bmV.KS();
        this.bmW.KS();
    }

    public void MW() {
        this.bmV.release();
        this.bmW.MW();
        this.bmX.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bmW.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bmW.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bmZ = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bmW.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bmW != null) {
            this.bmW.setFromMaster(this.bkG);
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
        if (this.bmW.MT() && this.bnb > 0) {
            this.bmX.setVisibility(0);
            this.bmX.setNewMessageSize(this.bnb);
        }
    }

    public void az(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bmY == null) {
            this.bmY = new AlaImAddTagTextView(getContext());
            this.bmY.setId(a.f.ala_im_add_tag);
            this.bmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bmY);
        }
        if (this.bmY.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bmY.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bmW.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.bmY.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bmW.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.removeRule(12);
        } else {
            layoutParams2.addRule(12, 0);
        }
        layoutParams2.addRule(2, this.bmY.getId());
        this.bmW.setLayoutParams(layoutParams2);
        this.bmY.setVisibility(0);
    }

    public void Nn() {
        if (this.bmY != null) {
            this.bmY.setVisibility(8);
        }
        No();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bmW.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bmW.getHeight();
    }

    private void No() {
        if (this.bmW != null) {
            ViewGroup.LayoutParams layoutParams = this.bmW.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.bmW.setLayoutParams(layoutParams);
            }
        }
    }
}
