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
    private boolean biV;
    private ALAImEnterView blk;
    private ALAImMsgListView bll;
    private ALAImMsgMoreChatView blm;
    private TextView bln;
    private boolean blo;
    private boolean blp;
    private int blq;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.blo = false;
        this.blp = false;
        this.blq = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blo = false;
        this.blp = false;
        this.blq = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blo = false;
        this.blp = false;
        this.blq = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bll.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.blk = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.blk, layoutParams);
        this.bll = new ALAImMsgListView(context);
        this.bll.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Mo() {
                ALaImMsgView.this.blq = 0;
                ALaImMsgView.this.blm.setVisibility(8);
            }
        });
        this.bll.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bll, layoutParams2);
        this.blm = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bll.getId());
        addView(this.blm, layoutParams3);
        this.blm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.blo) {
                    if (!ALaImMsgView.this.blp) {
                        ALaImMsgView.this.blp = false;
                        ALaImMsgView.this.blm.setVisibility(8);
                        ALaImMsgView.this.bll.Mm();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bll.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bll.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bll.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.blq += Math.max(list.size() - this.bll.getData().size(), 0);
        this.bll.setMsgData(list);
    }

    public boolean X(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.bll.getData().size() && list.get(list.size() + (-1)) == this.bll.getData().get(this.bll.getData().size() + (-1))) ? false : true;
    }

    public void y(com.baidu.live.im.data.a aVar) {
        this.blk.x(aVar);
    }

    @Override // com.baidu.live.im.j
    public void KZ() {
        this.bll.KZ();
    }

    public void Kj() {
        MF();
        this.blk.Kj();
        this.bll.Kj();
    }

    public void Mn() {
        this.blk.release();
        this.bll.Mn();
        this.blm.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bll.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bll.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.blo = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bll.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.biV = z;
        if (this.bll != null) {
            this.bll.setFromMaster(this.biV);
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
        if (this.bll.Mk() && this.blq > 0) {
            this.blm.setVisibility(0);
            this.blm.setNewMessageSize(this.blq);
        }
    }

    public void ay(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bln == null) {
            this.bln = new AlaImAddTagTextView(getContext());
            this.bln.setId(a.f.ala_im_add_tag);
            this.bln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bln);
        }
        if (this.bln.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bln.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bll.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.bln.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bll.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.removeRule(12);
        } else {
            layoutParams2.addRule(12, 0);
        }
        layoutParams2.addRule(2, this.bln.getId());
        this.bll.setLayoutParams(layoutParams2);
        this.bln.setVisibility(0);
    }

    public void ME() {
        if (this.bln != null) {
            this.bln.setVisibility(8);
        }
        MF();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bll.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bll.getHeight();
    }

    private void MF() {
        if (this.bll != null) {
            ViewGroup.LayoutParams layoutParams = this.bll.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.bll.setLayoutParams(layoutParams);
            }
        }
    }
}
