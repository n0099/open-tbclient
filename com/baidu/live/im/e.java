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
import com.baidu.live.im.view.ALAImEnterView;
import com.baidu.live.im.view.ALAImMsgListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.live.view.ALALevelView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId aKC = BdUniqueId.gen();
    private com.baidu.live.data.n aDK;
    private LinearLayout aKD;
    private ALAImMsgListView aKE;
    private ALAImEnterView aKF;
    private com.baidu.live.x.b aKG;
    private com.baidu.live.liveroom.b.a aKH;
    private View aKI;
    private HeadImageView aKJ;
    private TextView aKK;
    private ImageView aKL;
    private ALALevelView aKM;
    private TextView aKN;
    private TextView aKO;
    private TextView aKP;
    private View aKQ;
    private Drawable aKR;
    private boolean aKS;
    private int aKT;
    private boolean aKV;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aKU = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aKW = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aKX = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Ce() instanceof com.baidu.live.data.a)) {
                    aVar.Ce().apD = -1;
                }
                e.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aKY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aDK.aqk.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aKC);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bu(z);
                            e.this.bv(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Hs().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Hs().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aKS = !e.this.aKS;
                            e.this.bu(e.this.aKS);
                            e.this.bv(e.this.aKS);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aKS = e.this.aKS ? false : true;
                        e.this.bu(e.this.aKS);
                        e.this.bv(e.this.aKS);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.baidu.live.im.data.a aVar) {
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
                if (com.baidu.live.entereffect.a.vn().a(aVar)) {
                    this.aKF.v(aVar);
                }
            } else if ("task".equals(str)) {
                A(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.n nVar) {
        this.mContext = context;
        this.aDK = nVar;
        if (this.aDK != null) {
            this.aKR = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            AN();
            initListener();
        }
    }

    private void AN() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aKI = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aKI.setVisibility(4);
        this.aKD = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aKJ = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aKJ.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKJ.setIsRound(true);
        this.aKJ.setAutoChangeStyle(false);
        this.aKJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aKK = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aKL = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aKM = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aKN = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aKO = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aKP = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aKP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.AR();
            }
        });
        this.aKQ = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aKU = true;
                e.this.aKI.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aKE = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aKE.setMode(true);
        this.aKE.a(String.valueOf(this.aDK.mLiveInfo.group_id), String.valueOf(this.aDK.mLiveInfo.live_id), false, this.aDK.aqk != null ? String.valueOf(this.aDK.aqk.userId) : null);
        this.aKF = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aDK);
        AP();
    }

    private void f(com.baidu.live.data.n nVar) {
        CustomResponsedMessage runTask;
        if (this.aKH == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aKH = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aKH != null) {
            this.aKH.h(nVar);
            this.aKH.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aKH.a(1, this.aKD, layoutParams);
        }
    }

    private void AO() {
        this.aKI.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0149a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aKI.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aKY);
        MessageManager.getInstance().registerListener(this.aKW);
        MessageManager.getInstance().registerListener(this.aKX);
    }

    private void AP() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.En().aQu.uT()) {
            if (this.aKG == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aKG = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.aKG != null && (view = this.aKG.getView()) != null && this.aKD.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aKD.addView(view, layoutParams);
            }
            AQ();
        }
    }

    private void A(JSONObject jSONObject) {
        if (this.aKG != null) {
            this.aKG.B(jSONObject);
        }
    }

    private void AQ() {
        if (this.aKG != null && this.aKG.getView() != null && this.aDK != null && this.aDK.aqN != null) {
            this.aKG.a(this.aDK.aqN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aKS) {
            TiebaInitialize.log("c12553");
        }
        this.aKS = !this.aKS;
        bu(this.aKS);
        bv(this.aKS);
        String valueOf = String.valueOf(this.aDK.aqk.userId);
        com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.aDK.aqk.portrait, valueOf, "1", this.aKS, aKC);
        bVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Hs().a(valueOf, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.aKS = z;
        if (z) {
            this.aKP.setEnabled(false);
            this.aKP.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aKP.setBackgroundDrawable(null);
            this.aKP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aKP.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aKP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aKP.setCompoundDrawablePadding(0);
            return;
        }
        this.aKP.setEnabled(true);
        this.aKP.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aKP.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aKP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aKP.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aKP.setCompoundDrawablesWithIntrinsicBounds(this.aKR, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aKP.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (z) {
            TextView textView = this.aKO;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aKT + 1;
            this.aKT = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aKO;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aKT - 1;
        this.aKT = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aKE != null) {
            this.aKE.setMsgData(list);
            if (z) {
                this.aKE.Bd();
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AS() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aKV) {
            AO();
        }
        this.aKV = false;
        this.aKE.setSelection(this.aKE.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aKG != null) {
            this.aKG.onDestroy();
        }
        if (this.aKY != null) {
            MessageManager.getInstance().unRegisterListener(this.aKY);
        }
        MessageManager.getInstance().unRegisterListener(this.aKW);
        MessageManager.getInstance().unRegisterListener(this.aKX);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aKE != null) {
            this.aKE.CF();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
