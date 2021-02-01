package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
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
/* loaded from: classes11.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bnA;
    private a boN;
    public boolean boQ;
    private ALAImEnterView bra;
    private ALAImMsgListView brb;
    private ALAImMsgMoreChatView brc;
    private TextView brd;
    public boolean bre;
    private boolean brf;
    private boolean brg;
    private int brh;
    private int bri;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.boQ = false;
        this.bre = false;
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boQ = false;
        this.bre = false;
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boQ = false;
        this.bre = false;
        this.brf = false;
        this.brg = false;
        this.brh = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.brb.setPageContext(tbPageContext);
    }

    public void setView(a aVar) {
        this.boN = aVar;
    }

    public void cy(boolean z) {
        this.boQ = z;
    }

    private void init(Context context) {
        this.bra = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bra, layoutParams);
        this.brb = new ALAImMsgListView(context);
        this.brb.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void LR() {
                ALaImMsgView.this.brh = 0;
                ALaImMsgView.this.brc.setVisibility(8);
            }
        });
        this.brb.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.brb, layoutParams2);
        this.brc = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.brb.getId());
        addView(this.brc, layoutParams3);
        this.brc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.brf) {
                    ALaImMsgView.this.brh = 0;
                    if (!ALaImMsgView.this.brg) {
                        ALaImMsgView.this.brg = false;
                        ALaImMsgView.this.brc.setVisibility(8);
                        ALaImMsgView.this.brb.LQ();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.brb.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.brb.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.brb.setMaxHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        if (list != null) {
            this.bri = Math.max(this.brb.getLastVisiblePosition(), this.bri);
            this.brh = Math.max(list.size() - this.bri, 0);
            this.brb.setMsgData(list);
        }
    }

    public boolean aa(List<com.baidu.live.im.data.b> list) {
        return (list.size() == this.brb.getData().size() && list.get(list.size() + (-1)) == this.brb.getData().get(this.brb.getData().size() + (-1))) ? false : true;
    }

    public void H(com.baidu.live.im.data.b bVar) {
        this.bra.G(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Kc() {
        this.brb.Kc();
    }

    public void Jg() {
        setListAlignBottom(this.boQ);
        this.bra.Jg();
        this.brb.Jg();
    }

    public void KJ() {
        this.bra.release();
        this.brb.KJ();
        this.brc.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.brb.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.brb.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.brf = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.brb.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bnA = z;
        if (this.brb != null) {
            this.brb.setFromMaster(this.bnA);
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
        if (this.brb.LO() && this.brh > 0) {
            this.brc.setVisibility(0);
            this.brc.setNewMessageSize(this.brh);
        }
    }

    public void az(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.brd == null) {
            this.brd = new AlaImAddTagTextView(getContext());
            this.brd.setId(a.f.ala_im_add_tag);
            this.brd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.brd);
        }
        if (this.boQ) {
            if (this.brd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) this.brd.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams2.addRule(12);
            layoutParams2.addRule(5, this.brb.getId());
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            this.brd.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.brb.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.removeRule(12);
            } else {
                layoutParams3.addRule(12, 0);
            }
            if (this.brd != null && this.brd.getVisibility() == 0) {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
            } else {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            layoutParams3.addRule(2, this.brd.getId());
            this.brb.setLayoutParams(layoutParams3);
            return;
        }
        if (this.brd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.brd.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.brb.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.brd.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.brb.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.removeRule(12);
        } else {
            layoutParams4.addRule(12, 0);
        }
        layoutParams4.addRule(2, this.brd.getId());
        this.brb.setLayoutParams(layoutParams4);
    }

    private boolean Mo() {
        if (this.brd != null) {
            this.bre = this.brd.getVisibility() == 0;
        } else {
            this.bre = false;
        }
        return this.bre;
    }

    public void cz(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (Mo()) {
            if (z) {
                if (this.brd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) this.brd.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.brb.getId());
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.brd.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.brb.getLayoutParams();
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(12);
                } else {
                    layoutParams2.addRule(12, 0);
                }
                layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams2.addRule(2, this.brd.getId());
                this.brb.setLayoutParams(layoutParams2);
                return;
            }
            setTagViewBottom();
        }
    }

    public void cA(boolean z) {
        if (this.brd != null) {
            this.brd.setVisibility(8);
        }
        setListAlignBottom(!z);
    }

    public int getImMsgListViewTop() {
        return getTop() + this.brb.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.brb.getHeight();
    }

    public void setListAlignBottom(boolean z) {
        if (this.brb != null) {
            ViewGroup.LayoutParams layoutParams = this.brb.getLayoutParams();
            if (z) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                    this.brb.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                }
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.brb.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTagViewBottom() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.brd != null) {
            if (this.brd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.brd.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(5, this.brb.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(a.d.sdk_ds6);
            this.brd.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.brb.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.brd.getId());
            this.brb.setLayoutParams(layoutParams2);
        }
    }
}
