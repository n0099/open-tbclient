package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
/* loaded from: classes3.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean aUX;
    private ALAImEnterView aXg;
    private ALAImMsgListView aXh;
    private ALAImMsgMoreChatView aXi;
    private TextView aXj;
    private boolean aXk;
    private boolean aXl;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.aXk = false;
        this.aXl = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXk = false;
        this.aXl = false;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXk = false;
        this.aXl = false;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.aXh.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.aXg = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.e.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        addView(this.aXg, layoutParams);
        this.aXh = new ALAImMsgListView(context);
        this.aXh.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.im.view.ALaImMsgView.1
            @Override // com.baidu.live.im.view.ALAImMsgListView.a
            public void EF() {
                ALaImMsgView.this.aXi.setVisibility(8);
            }
        });
        this.aXh.setId(a.g.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds80);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.aXh, layoutParams2);
        this.aXi = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(a.e.sdk_ds236), context.getResources().getDimensionPixelSize(a.e.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams3.addRule(8, this.aXh.getId());
        addView(this.aXi, layoutParams3);
        this.aXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.aXk) {
                    if (!ALaImMsgView.this.aXl) {
                        ALaImMsgView.this.aXl = false;
                        ALaImMsgView.this.aXi.setVisibility(8);
                        ALaImMsgView.this.aXh.ED();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.aXh.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aXh.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.aXh.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        this.aXh.setMsgData(list);
    }

    public boolean Q(List<com.baidu.live.im.data.a> list) {
        return list.size() != this.aXh.getData().size();
    }

    public void w(com.baidu.live.im.data.a aVar) {
        this.aXg.v(aVar);
    }

    @Override // com.baidu.live.im.j
    public void CZ() {
        this.aXh.CZ();
    }

    public void Dy() {
        this.aXg.Dy();
        this.aXh.Dy();
    }

    public void EE() {
        this.aXg.release();
        this.aXh.EE();
        this.aXi.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        this.aXh.a(str, str2, z, str3);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.aXh.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.aXk = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.aXh.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.aUX = z;
        if (this.aXh != null) {
            this.aXh.setFromMaster(this.aUX);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aXk) {
                this.aXl = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.aXl = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void EU() {
        if (this.aXh.EB()) {
            this.aXi.setVisibility(0);
        }
    }

    public void as(final String str, final String str2) {
        if (this.aXj == null) {
            this.aXj = new AlaImAddTagTextView(getContext());
            this.aXj.setId(a.g.ala_im_add_tag);
            this.aXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALaImMsgView.3
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
            layoutParams.addRule(5, this.aXh.getId());
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds8);
            addView(this.aXj, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aXh.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(12);
            } else {
                layoutParams2.addRule(12, 0);
            }
            layoutParams2.addRule(2, this.aXj.getId());
            this.aXh.setLayoutParams(layoutParams2);
        }
        this.aXj.setVisibility(0);
    }

    public void EV() {
        if (this.aXj != null) {
            this.aXj.setVisibility(8);
        }
    }

    public int getImMsgListViewTop() {
        return getTop() + this.aXh.getTop();
    }

    public int getImMsgListViewHeight() {
        return this.aXh.getHeight();
    }
}
