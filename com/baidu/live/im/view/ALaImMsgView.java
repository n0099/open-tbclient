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
/* loaded from: classes10.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bpa;
    private a bqn;
    public boolean bqq;
    private ALAImEnterView bsA;
    private ALAImMsgListView bsB;
    private ALAImMsgMoreChatView bsC;
    private TextView bsD;
    public boolean bsE;
    private boolean bsF;
    private boolean bsG;
    private int bsH;
    private int bsI;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bqq = false;
        this.bsE = false;
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqq = false;
        this.bsE = false;
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqq = false;
        this.bsE = false;
        this.bsF = false;
        this.bsG = false;
        this.bsH = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bsB.setPageContext(tbPageContext);
    }

    public void setView(a aVar) {
        this.bqn = aVar;
    }

    public void cy(boolean z) {
        this.bqq = z;
    }

    private void init(Context context) {
        this.bsA = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bsA, layoutParams);
        this.bsB = new ALAImMsgListView(context);
        this.bsB.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void LU() {
                ALaImMsgView.this.bsH = 0;
                ALaImMsgView.this.bsC.setVisibility(8);
            }
        });
        this.bsB.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bsB, layoutParams2);
        this.bsC = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bsB.getId());
        addView(this.bsC, layoutParams3);
        this.bsC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bsF) {
                    ALaImMsgView.this.bsH = 0;
                    if (!ALaImMsgView.this.bsG) {
                        ALaImMsgView.this.bsG = false;
                        ALaImMsgView.this.bsC.setVisibility(8);
                        ALaImMsgView.this.bsB.LT();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bsB.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bsB.setMaxHeight(Integer.MAX_VALUE);
            } else if (configuration.orientation == 1) {
                this.bsB.setMaxHeight(Integer.MAX_VALUE);
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
            this.bsI = Math.max(this.bsB.getLastVisiblePosition(), this.bsI);
            this.bsH = Math.max(list.size() - this.bsI, 0);
            this.bsB.setMsgData(list);
        }
    }

    public boolean aa(List<com.baidu.live.im.data.b> list) {
        return (list.size() == this.bsB.getData().size() && list.get(list.size() + (-1)) == this.bsB.getData().get(this.bsB.getData().size() + (-1))) ? false : true;
    }

    public void H(com.baidu.live.im.data.b bVar) {
        this.bsA.G(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Kf() {
        this.bsB.Kf();
    }

    public void Jj() {
        setListAlignBottom(this.bqq);
        this.bsA.Jj();
        this.bsB.Jj();
    }

    public void KM() {
        this.bsA.release();
        this.bsB.KM();
        this.bsC.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bsB.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bsB.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsF = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.bsB.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bpa = z;
        if (this.bsB != null) {
            this.bsB.setFromMaster(this.bpa);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bsF) {
                this.bsG = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bsG = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void Mq() {
        if (this.bsB.LR() && this.bsH > 0) {
            this.bsC.setVisibility(0);
            this.bsC.setNewMessageSize(this.bsH);
        }
    }

    public void az(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bsD == null) {
            this.bsD = new AlaImAddTagTextView(getContext());
            this.bsD.setId(a.f.ala_im_add_tag);
            this.bsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bsD);
        }
        if (this.bqq) {
            if (this.bsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) this.bsD.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams2.addRule(12);
            layoutParams2.addRule(5, this.bsB.getId());
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            this.bsD.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.bsB.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.removeRule(12);
            } else {
                layoutParams3.addRule(12, 0);
            }
            if (this.bsD != null && this.bsD.getVisibility() == 0) {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
            } else {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            layoutParams3.addRule(2, this.bsD.getId());
            this.bsB.setLayoutParams(layoutParams3);
            return;
        }
        if (this.bsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bsD.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bsB.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bsD.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.bsB.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.removeRule(12);
        } else {
            layoutParams4.addRule(12, 0);
        }
        layoutParams4.addRule(2, this.bsD.getId());
        this.bsB.setLayoutParams(layoutParams4);
    }

    private boolean Mr() {
        if (this.bsD != null) {
            this.bsE = this.bsD.getVisibility() == 0;
        } else {
            this.bsE = false;
        }
        return this.bsE;
    }

    public void cz(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (Mr()) {
            if (z) {
                if (this.bsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) this.bsD.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.bsB.getId());
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bsD.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bsB.getLayoutParams();
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(12);
                } else {
                    layoutParams2.addRule(12, 0);
                }
                layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams2.addRule(2, this.bsD.getId());
                this.bsB.setLayoutParams(layoutParams2);
                return;
            }
            setTagViewBottom();
        }
    }

    public void cA(boolean z) {
        if (this.bsD != null) {
            this.bsD.setVisibility(8);
        }
        setListAlignBottom(!z);
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bsB.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bsB.getHeight();
    }

    public void setListAlignBottom(boolean z) {
        if (this.bsB != null) {
            ViewGroup.LayoutParams layoutParams = this.bsB.getLayoutParams();
            if (z) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                    this.bsB.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                }
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bsB.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTagViewBottom() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bsD != null) {
            if (this.bsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.bsD.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(5, this.bsB.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(a.d.sdk_ds6);
            this.bsD.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bsB.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.bsD.getId());
            this.bsB.setLayoutParams(layoutParams2);
        }
    }
}
