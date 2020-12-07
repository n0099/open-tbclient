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
    private boolean bnn;
    private a bow;
    public boolean boz;
    private boolean bqA;
    private boolean bqB;
    private int bqC;
    private ALAImEnterView bqv;
    private ALAImMsgListView bqw;
    private ALAImMsgMoreChatView bqx;
    private TextView bqy;
    public boolean bqz;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.boz = false;
        this.bqz = false;
        this.bqA = false;
        this.bqB = false;
        this.bqC = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boz = false;
        this.bqz = false;
        this.bqA = false;
        this.bqB = false;
        this.bqC = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boz = false;
        this.bqz = false;
        this.bqA = false;
        this.bqB = false;
        this.bqC = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bqw.setPageContext(tbPageContext);
    }

    public void setView(a aVar) {
        this.bow = aVar;
    }

    public void cq(boolean z) {
        this.boz = z;
    }

    private void init(Context context) {
        this.bqv = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.d.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.bqv, layoutParams);
        this.bqw = new ALAImMsgListView(context);
        this.bqw.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void OJ() {
                ALaImMsgView.this.bqC = 0;
                ALaImMsgView.this.bqx.setVisibility(8);
            }
        });
        this.bqw.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bqw, layoutParams2);
        this.bqx = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds48));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.bqw.getId());
        addView(this.bqx, layoutParams3);
        this.bqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bqA) {
                    if (!ALaImMsgView.this.bqB) {
                        ALaImMsgView.this.bqB = false;
                        ALaImMsgView.this.bqx.setVisibility(8);
                        ALaImMsgView.this.bqw.OH();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bqw.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bqw.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bqw.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        this.bqC += Math.max(list.size() - this.bqw.getData().size(), 0);
        this.bqw.setMsgData(list);
    }

    public boolean Z(List<com.baidu.live.im.data.b> list) {
        return (list.size() == this.bqw.getData().size() && list.get(list.size() + (-1)) == this.bqw.getData().get(this.bqw.getData().size() + (-1))) ? false : true;
    }

    public void z(com.baidu.live.im.data.b bVar) {
        this.bqv.y(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Nc() {
        this.bqw.Nc();
    }

    public void Ml() {
        setListAlignBottom(this.boz);
        this.bqv.Ml();
        this.bqw.Ml();
    }

    public void OI() {
        this.bqv.release();
        this.bqw.OI();
        this.bqx.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.bqw.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bqw.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bqA = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bqw.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bqw != null) {
            this.bqw.setFromMaster(this.bnn);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bqA) {
                this.bqB = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bqB = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void OZ() {
        if (this.bqw.OF() && this.bqC > 0) {
            this.bqx.setVisibility(0);
            this.bqx.setNewMessageSize(this.bqC);
        }
    }

    public void aC(final String str, final String str2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bqy == null) {
            this.bqy = new AlaImAddTagTextView(getContext());
            this.bqy.setId(a.f.ala_im_add_tag);
            this.bqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            addView(this.bqy);
        }
        if (this.boz) {
            if (this.bqy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) this.bqy.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams2.addRule(12);
            layoutParams2.addRule(5, this.bqw.getId());
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds60);
            this.bqy.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.bqw.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.removeRule(12);
            } else {
                layoutParams3.addRule(12, 0);
            }
            layoutParams3.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
            layoutParams3.addRule(2, this.bqy.getId());
            this.bqw.setLayoutParams(layoutParams3);
            return;
        }
        if (this.bqy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bqy.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(5, this.bqw.getId());
        layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
        layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
        this.bqy.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.bqw.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.removeRule(12);
        } else {
            layoutParams4.addRule(12, 0);
        }
        layoutParams4.addRule(2, this.bqy.getId());
        this.bqw.setLayoutParams(layoutParams4);
    }

    private boolean Pa() {
        if (this.bqy != null) {
            this.bqz = this.bqy.getVisibility() == 0;
        } else {
            this.bqz = false;
        }
        return this.bqz;
    }

    public void cr(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (Pa()) {
            if (z) {
                if (this.bqy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) this.bqy.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.bqw.getId());
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds60);
                this.bqy.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bqw.getLayoutParams();
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(12);
                } else {
                    layoutParams2.addRule(12, 0);
                }
                layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                layoutParams2.addRule(2, this.bqy.getId());
                this.bqw.setLayoutParams(layoutParams2);
                return;
            }
            setTagViewBottom();
        }
    }

    public void cs(boolean z) {
        if (this.bqy != null) {
            this.bqy.setVisibility(8);
        }
        setListAlignBottom(!z);
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bqw.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bqw.getHeight();
    }

    public void setListAlignBottom(boolean z) {
        if (this.bqw != null) {
            ViewGroup.LayoutParams layoutParams = this.bqw.getLayoutParams();
            if (z) {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                    this.bqw.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds6);
                }
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds60);
                this.bqw.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTagViewBottom() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bqy != null) {
            if (this.bqy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) this.bqy.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(5, this.bqw.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds8);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(a.d.sdk_ds6);
            this.bqy.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bqw.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.bqy.getId());
            this.bqw.setLayoutParams(layoutParams2);
        }
    }
}
