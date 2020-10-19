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
    private boolean bhP;
    private ALAImEnterView bkg;
    private ALAImMsgListView bkh;
    private ALAImMsgMoreChatView bki;
    private TextView bkj;
    private boolean bkk;
    private boolean bkl;
    private int bkm;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bkk = false;
        this.bkl = false;
        this.bkm = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkk = false;
        this.bkl = false;
        this.bkm = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkk = false;
        this.bkl = false;
        this.bkm = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bkh.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bkg = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.e.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.bkg, layoutParams);
        this.bkh = new ALAImMsgListView(context);
        this.bkh.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Md() {
                ALaImMsgView.this.bkm = 0;
                ALaImMsgView.this.bki.setVisibility(8);
            }
        });
        this.bkh.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bkh, layoutParams2);
        this.bki = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.bkh.getId());
        addView(this.bki, layoutParams3);
        this.bki.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bkk) {
                    if (!ALaImMsgView.this.bkl) {
                        ALaImMsgView.this.bkl = false;
                        ALaImMsgView.this.bki.setVisibility(8);
                        ALaImMsgView.this.bkh.Mb();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bkh.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bkh.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bkh.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bkm += Math.max(list.size() - this.bkh.getData().size(), 0);
        this.bkh.setMsgData(list);
    }

    public boolean W(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.bkh.getData().size() && list.get(list.size() + (-1)) == this.bkh.getData().get(this.bkh.getData().size() + (-1))) ? false : true;
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.bkg.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void KO() {
        this.bkh.KO();
    }

    public void JY() {
        Mu();
        this.bkg.JY();
        this.bkh.JY();
    }

    public void Mc() {
        this.bkg.release();
        this.bkh.Mc();
        this.bki.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bkh.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bkh.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bkk = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bkh.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bhP = z;
        if (this.bkh != null) {
            this.bkh.setFromMaster(this.bhP);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bkk) {
                this.bkl = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bkl = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Ms() {
        if (this.bkh.LZ() && this.bkm > 0) {
            this.bki.setVisibility(0);
            this.bki.setNewMessageSize(this.bkm);
        }
    }

    public void ay(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bkj == null) {
            this.bkj = new AlaImAddTagTextView(getContext());
            this.bkj.setId(a.g.ala_im_add_tag);
            this.bkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bkj);
        }
        if (this.bkj.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bkj.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bkh.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.bkj.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bkh.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.removeRule(12);
        } else {
            layoutParams2.addRule(12, 0);
        }
        layoutParams2.addRule(2, this.bkj.getId());
        this.bkh.setLayoutParams(layoutParams2);
        this.bkj.setVisibility(0);
    }

    public void Mt() {
        if (this.bkj != null) {
            this.bkj.setVisibility(8);
        }
        Mu();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bkh.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bkh.getHeight();
    }

    private void Mu() {
        if (this.bkh != null) {
            ViewGroup.LayoutParams layoutParams = this.bkh.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.bkh.setLayoutParams(layoutParams);
            }
        }
    }
}
