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
/* loaded from: classes11.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean boU;
    private a bqf;
    public boolean bqi;
    private ALAImEnterView bsl;
    private ALAImMsgListView bsm;
    private ALAImMsgMoreChatView bsn;
    private TextView bso;
    public boolean bsp;
    private boolean bsq;
    private boolean bsr;
    private int bss;
    private int bst;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bqi = false;
        this.bsp = false;
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqi = false;
        this.bsp = false;
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqi = false;
        this.bsp = false;
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bsm.setPageContext(tbPageContext);
    }

    public void setView(a aVar) {
        this.bqf = aVar;
    }

    public void ct(boolean z) {
        this.bqi = z;
    }

    private void init(Context context) {
        this.bsl = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bsl, layoutParams);
        this.bsm = new ALAImMsgListView(context);
        this.bsm.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Oo() {
                ALaImMsgView.this.bss = 0;
                ALaImMsgView.this.bsn.setVisibility(8);
            }
        });
        this.bsm.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bsm, layoutParams2);
        this.bsn = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bsm.getId());
        addView(this.bsn, layoutParams3);
        this.bsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bsq) {
                    ALaImMsgView.this.bss = 0;
                    if (!ALaImMsgView.this.bsr) {
                        ALaImMsgView.this.bsr = false;
                        ALaImMsgView.this.bsn.setVisibility(8);
                        ALaImMsgView.this.bsm.On();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bsm.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bsm.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bsm.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
            this.bst = Math.max(this.bsm.getLastVisiblePosition(), this.bst);
            this.bss = Math.max(list.size() - this.bst, 0);
            this.bsm.setMsgData(list);
        }
    }

    public boolean Z(List<com.baidu.live.im.data.b> list) {
        return (list.size() == this.bsm.getData().size() && list.get(list.size() + (-1)) == this.bsm.getData().get(this.bsm.getData().size() + (-1))) ? false : true;
    }

    public void B(com.baidu.live.im.data.b bVar) {
        this.bsl.A(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Mz() {
        this.bsm.Mz();
    }

    public void LI() {
        setListAlignBottom(this.bqi);
        this.bsl.LI();
        this.bsm.LI();
    }

    public void Ng() {
        this.bsl.release();
        this.bsm.Ng();
        this.bsn.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bsm.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bsm.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsq = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.bsm.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.boU = z;
        if (this.bsm != null) {
            this.bsm.setFromMaster(this.boU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bsq) {
                this.bsr = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bsr = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void OK() {
        if (this.bsm.Ol() && this.bss > 0) {
            this.bsn.setVisibility(0);
            this.bsn.setNewMessageSize(this.bss);
        }
    }

    public void aA(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bso == null) {
            this.bso = new AlaImAddTagTextView(getContext());
            this.bso.setId(a.f.ala_im_add_tag);
            this.bso.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bso);
        }
        if (this.bqi) {
            if (this.bso.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) this.bso.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams2.addRule(12);
            layoutParams2.addRule(5, this.bsm.getId());
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            this.bso.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.bsm.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.removeRule(12);
            } else {
                layoutParams3.addRule(12, 0);
            }
            if (this.bso != null && this.bso.getVisibility() == 0) {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
            } else {
                layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            layoutParams3.addRule(2, this.bso.getId());
            this.bsm.setLayoutParams(layoutParams3);
            return;
        }
        if (this.bso.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bso.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bsm.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bso.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.bsm.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.removeRule(12);
        } else {
            layoutParams4.addRule(12, 0);
        }
        layoutParams4.addRule(2, this.bso.getId());
        this.bsm.setLayoutParams(layoutParams4);
    }

    private boolean OL() {
        if (this.bso != null) {
            this.bsp = this.bso.getVisibility() == 0;
        } else {
            this.bsp = false;
        }
        return this.bsp;
    }

    public void cu(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (OL()) {
            if (z) {
                if (this.bso.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) this.bso.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.bsm.getId());
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bso.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bsm.getLayoutParams();
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(12);
                } else {
                    layoutParams2.addRule(12, 0);
                }
                layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams2.addRule(2, this.bso.getId());
                this.bsm.setLayoutParams(layoutParams2);
                return;
            }
            setTagViewBottom();
        }
    }

    public void cv(boolean z) {
        if (this.bso != null) {
            this.bso.setVisibility(8);
        }
        setListAlignBottom(!z);
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bsm.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bsm.getHeight();
    }

    public void setListAlignBottom(boolean z) {
        if (this.bsm != null) {
            ViewGroup.LayoutParams layoutParams = this.bsm.getLayoutParams();
            if (z) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                    this.bsm.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                }
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds80);
                this.bsm.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTagViewBottom() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bso != null) {
            if (this.bso.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.bso.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(5, this.bsm.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(a.d.sdk_ds6);
            this.bso.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bsm.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.bso.getId());
            this.bsm.setLayoutParams(layoutParams2);
        }
    }
}
