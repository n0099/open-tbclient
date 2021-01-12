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
import androidx.appcompat.widget.ActivityChooserView;
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
    private boolean bkh;
    private a bls;
    public boolean blv;
    private ALAImMsgListView bnA;
    private ALAImMsgMoreChatView bnB;
    private TextView bnC;
    public boolean bnD;
    private boolean bnE;
    private boolean bnF;
    private int bnG;
    private int bnH;
    private ALAImEnterView bnz;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.blv = false;
        this.bnD = false;
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blv = false;
        this.bnD = false;
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blv = false;
        this.bnD = false;
        this.bnE = false;
        this.bnF = false;
        this.bnG = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bnA.setPageContext(tbPageContext);
    }

    public void setView(a aVar) {
        this.bls = aVar;
    }

    public void cp(boolean z) {
        this.blv = z;
    }

    private void init(Context context) {
        this.bnz = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bnz, layoutParams);
        this.bnA = new ALAImMsgListView(context);
        this.bnA.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Kt() {
                ALaImMsgView.this.bnG = 0;
                ALaImMsgView.this.bnB.setVisibility(8);
            }
        });
        this.bnA.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bnA, layoutParams2);
        this.bnB = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bnA.getId());
        addView(this.bnB, layoutParams3);
        this.bnB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bnE) {
                    ALaImMsgView.this.bnG = 0;
                    if (!ALaImMsgView.this.bnF) {
                        ALaImMsgView.this.bnF = false;
                        ALaImMsgView.this.bnB.setVisibility(8);
                        ALaImMsgView.this.bnA.Ks();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bnA.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bnA.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bnA.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
            this.bnH = Math.max(this.bnA.getLastVisiblePosition(), this.bnH);
            this.bnG = Math.max(list.size() - this.bnH, 0);
            this.bnA.setMsgData(list);
        }
    }

    public boolean Z(List<com.baidu.live.im.data.b> list) {
        return (list.size() == this.bnA.getData().size() && list.get(list.size() + (-1)) == this.bnA.getData().get(this.bnA.getData().size() + (-1))) ? false : true;
    }

    public void B(com.baidu.live.im.data.b bVar) {
        this.bnz.A(bVar);
    }

    @Override // com.baidu.live.im.j
    public void IE() {
        this.bnA.IE();
    }

    public void HN() {
        setListAlignBottom(this.blv);
        this.bnz.HN();
        this.bnA.HN();
    }

    public void Jl() {
        this.bnz.release();
        this.bnA.Jl();
        this.bnB.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bnA.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bnA.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bnE = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.bnA.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bkh = z;
        if (this.bnA != null) {
            this.bnA.setFromMaster(this.bkh);
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
        if (this.bnA.Kq() && this.bnG > 0) {
            this.bnB.setVisibility(0);
            this.bnB.setNewMessageSize(this.bnG);
        }
    }

    public void az(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bnC == null) {
            this.bnC = new AlaImAddTagTextView(getContext());
            this.bnC.setId(a.f.ala_im_add_tag);
            this.bnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bnC);
        }
        if (this.blv) {
            if (this.bnC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) this.bnC.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams2.addRule(12);
            layoutParams2.addRule(5, this.bnA.getId());
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            this.bnC.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.bnA.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.removeRule(12);
            } else {
                layoutParams3.addRule(12, 0);
            }
            if (this.bnC != null && this.bnC.getVisibility() == 0) {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
            } else {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            layoutParams3.addRule(2, this.bnC.getId());
            this.bnA.setLayoutParams(layoutParams3);
            return;
        }
        if (this.bnC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bnC.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bnA.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bnC.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.bnA.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.removeRule(12);
        } else {
            layoutParams4.addRule(12, 0);
        }
        layoutParams4.addRule(2, this.bnC.getId());
        this.bnA.setLayoutParams(layoutParams4);
    }

    private boolean KQ() {
        if (this.bnC != null) {
            this.bnD = this.bnC.getVisibility() == 0;
        } else {
            this.bnD = false;
        }
        return this.bnD;
    }

    public void cq(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (KQ()) {
            if (z) {
                if (this.bnC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) this.bnC.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.bnA.getId());
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bnC.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bnA.getLayoutParams();
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(12);
                } else {
                    layoutParams2.addRule(12, 0);
                }
                layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams2.addRule(2, this.bnC.getId());
                this.bnA.setLayoutParams(layoutParams2);
                return;
            }
            setTagViewBottom();
        }
    }

    public void cr(boolean z) {
        if (this.bnC != null) {
            this.bnC.setVisibility(8);
        }
        setListAlignBottom(!z);
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bnA.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bnA.getHeight();
    }

    public void setListAlignBottom(boolean z) {
        if (this.bnA != null) {
            ViewGroup.LayoutParams layoutParams = this.bnA.getLayoutParams();
            if (z) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                    this.bnA.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                }
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bnA.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTagViewBottom() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bnC != null) {
            if (this.bnC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.bnC.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(5, this.bnA.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(a.d.sdk_ds6);
            this.bnC.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bnA.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.bnC.getId());
            this.bnA.setLayoutParams(layoutParams2);
        }
    }
}
