package com.baidu.live.im;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.w;
import com.baidu.live.im.view.ALAImEnterView;
import com.baidu.live.im.view.ALAImMsgListView;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.view.ALALevelView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId biA = BdUniqueId.gen();
    private w aES;
    private LinearLayout biB;
    private ALAImMsgListView biC;
    private ALAImEnterView biD;
    private com.baidu.live.ad.b biE;
    private com.baidu.live.liveroom.b.a biF;
    private View biG;
    private HeadImageView biH;
    private TextView biI;
    private ImageView biJ;
    private ALALevelView biK;
    private TextView biL;
    private TextView biM;
    private TextView biN;
    private View biO;
    private Drawable biP;
    private boolean biQ;
    private int biR;
    private boolean biT;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean biS = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener biU = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener biV = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Mo() instanceof com.baidu.live.data.a)) {
                    aVar.Mo().aHF = -1;
                }
                e.this.t(aVar);
            }
        }
    };
    private CustomMessageListener biW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aES.aIV.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.biA);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bV(z);
                            e.this.bW(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.h.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Wx().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.biQ = !e.this.biQ;
                            e.this.bV(e.this.biQ);
                            e.this.bW(e.this.biQ);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.biQ = e.this.biQ ? false : true;
                        e.this.bV(e.this.biQ);
                        e.this.bW(e.this.biQ);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str = null;
        if (aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str = jSONObject.optString("content_type");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if ("enter_live".equals(str)) {
                if (com.baidu.live.entereffect.a.Fg().h(aVar)) {
                    this.biD.x(aVar);
                }
            } else if ("task".equals(str)) {
                O(jSONObject);
            }
        }
    }

    public e(Context context, w wVar) {
        this.mContext = context;
        this.aES = wVar;
        if (this.aES != null) {
            this.biP = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            Lm();
            initListener();
        }
    }

    private void Lm() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.biG = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.biG.setVisibility(4);
        this.biB = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.biH = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.biH.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.biH.setIsRound(true);
        this.biH.setAutoChangeStyle(false);
        this.biH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.biI = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.biJ = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.biK = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.biL = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.biM = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.biN = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.biN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Lq();
            }
        });
        this.biO = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.biO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.biS = true;
                e.this.biG.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.biC = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.biC.setMode(true);
        this.biC.b(String.valueOf(this.aES.mLiveInfo.group_id), String.valueOf(this.aES.mLiveInfo.live_id), false, this.aES.aIV != null ? String.valueOf(this.aES.aIV.userId) : null);
        this.biD = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        f(this.aES);
        Lo();
    }

    private void f(w wVar) {
        CustomResponsedMessage runTask;
        if (this.biF == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.biF = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.biF != null) {
            this.biF.i(wVar);
            this.biF.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.biF.a(1, null);
        }
    }

    private void Ln() {
        this.biG.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0197a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.biG.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.biW);
        MessageManager.getInstance().registerListener(this.biU);
        MessageManager.getInstance().registerListener(this.biV);
    }

    private void Lo() {
        PendantChildView SN;
        CustomResponsedMessage runTask;
        if (com.baidu.live.aa.a.PQ().bod.EA()) {
            if (this.biE == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ad.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.biE = (com.baidu.live.ad.b) runTask.getData();
            }
            if (this.biE != null && (SN = this.biE.SN()) != null && this.biB.indexOfChild(SN) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.biB.addView(SN, layoutParams);
            }
            Lp();
        }
    }

    private void O(JSONObject jSONObject) {
        if (this.biE != null) {
            this.biE.V(jSONObject);
        }
    }

    private void Lp() {
        if (this.biE != null && this.biE.SN() != null && this.aES != null) {
            this.biE.i(this.aES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.biQ) {
            TiebaInitialize.log("c12553");
        }
        this.biQ = !this.biQ;
        bV(this.biQ);
        bW(this.biQ);
        String valueOf = String.valueOf(this.aES.aIV.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aES.aIV.portrait, valueOf, "1", this.biQ, biA);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Wx().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        this.biQ = z;
        if (z) {
            this.biN.setEnabled(false);
            this.biN.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.biN.setBackgroundDrawable(null);
            this.biN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.biN.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.biN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.biN.setCompoundDrawablePadding(0);
            return;
        }
        this.biN.setEnabled(true);
        this.biN.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.biN.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.biN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.biN.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.biN.setCompoundDrawablesWithIntrinsicBounds(this.biP, (Drawable) null, (Drawable) null, (Drawable) null);
        this.biN.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(boolean z) {
        if (z) {
            TextView textView = this.biM;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.biR + 1;
            this.biR = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.biM;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.biR - 1;
        this.biR = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.biC != null) {
            this.biC.setMsgData(list);
            if (z) {
                this.biC.LI();
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.h.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.biT) {
            Ln();
        }
        this.biT = false;
        this.biC.setSelection(this.biC.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.biE != null) {
            this.biE.onDestroy();
        }
        if (this.biW != null) {
            MessageManager.getInstance().unRegisterListener(this.biW);
        }
        MessageManager.getInstance().unRegisterListener(this.biU);
        MessageManager.getInstance().unRegisterListener(this.biV);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.biC != null) {
            this.biC.MW();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
