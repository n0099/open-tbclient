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
/* loaded from: classes7.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean bbC;
    private ALAImMsgListView bdA;
    private ALAImMsgMoreChatView bdB;
    private TextView bdC;
    private boolean bdD;
    private boolean bdE;
    private ALAImEnterView bdz;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bdD = false;
        this.bdE = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdD = false;
        this.bdE = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdD = false;
        this.bdE = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bdA.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.bdz = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(a.e.sdk_im_entereffect_height));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.bdz, layoutParams);
        this.bdA = new ALAImMsgListView(context);
        this.bdA.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void Kr() {
                ALaImMsgView.this.bdB.setVisibility(8);
            }
        });
        this.bdA.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = layoutParams.height + getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.bdA, layoutParams2);
        this.bdB = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.bdA.getId());
        addView(this.bdB, layoutParams3);
        this.bdB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bdD) {
                    if (!ALaImMsgView.this.bdE) {
                        ALaImMsgView.this.bdE = false;
                        ALaImMsgView.this.bdB.setVisibility(8);
                        ALaImMsgView.this.bdA.Kp();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.bdA.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bdA.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.bdA.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.bdA.setMsgData(list);
    }

    public boolean R(List<com.baidu.live.im.data.a> list) {
        return (list.size() == this.bdA.getData().size() && list.get(list.size() + (-1)) == this.bdA.getData().get(this.bdA.getData().size() + (-1))) ? false : true;
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.bdz.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void Je() {
        this.bdA.Je();
    }

    public void Ju() {
        KI();
        this.bdz.Ju();
        this.bdA.Ju();
    }

    public void Kq() {
        this.bdz.release();
        this.bdA.Kq();
        this.bdB.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        this.bdA.b(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.bdA.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bdD = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.bdA.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.bbC = z;
        if (this.bdA != null) {
            this.bdA.setFromMaster(this.bbC);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bdD) {
                this.bdE = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bdE = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void KG() {
        if (this.bdA.Kn()) {
            this.bdB.setVisibility(0);
        }
    }

    public void av(final String str, final String str2) {
        if (this.bdC == null) {
            this.bdC = new AlaImAddTagTextView(getContext());
            this.bdC.setId(a.g.ala_im_add_tag);
            this.bdC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.bdA.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds8);
            addView(this.bdC, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bdA.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.bdC.getId());
            this.bdA.setLayoutParams(layoutParams2);
        }
        this.bdC.setVisibility(0);
    }

    public void KH() {
        if (this.bdC != null) {
            this.bdC.setVisibility(8);
        }
        KI();
    }

    public int getImMsgListViewTop() {
        return getTop() + this.bdA.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.bdA.getHeight();
    }

    private void KI() {
        if (this.bdA != null) {
            ViewGroup.LayoutParams layoutParams = this.bdA.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                this.bdA.setLayoutParams(layoutParams);
            }
        }
    }
}
