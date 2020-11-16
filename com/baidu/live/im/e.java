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
    private static final BdUniqueId bgM = BdUniqueId.gen();
    private w aDh;
    private LinearLayout bgN;
    private ALAImMsgListView bgO;
    private ALAImEnterView bgP;
    private com.baidu.live.ad.b bgQ;
    private com.baidu.live.liveroom.b.a bgR;
    private View bgS;
    private HeadImageView bgT;
    private TextView bgU;
    private ImageView bgV;
    private ALALevelView bgW;
    private TextView bgX;
    private TextView bgY;
    private TextView bgZ;
    private View bha;
    private Drawable bhb;
    private boolean bhc;
    private int bhd;
    private boolean bhf;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bhe = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bhg = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bhh = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.LF() instanceof com.baidu.live.data.a)) {
                    aVar.LF().aFU = -1;
                }
                e.this.t(aVar);
            }
        }
    };
    private CustomMessageListener bhi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aDh.aHk.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bgM);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bX(z);
                            e.this.bY(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.h.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.VO().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bhc = !e.this.bhc;
                            e.this.bX(e.this.bhc);
                            e.this.bY(e.this.bhc);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bhc = e.this.bhc ? false : true;
                        e.this.bX(e.this.bhc);
                        e.this.bY(e.this.bhc);
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
                if (com.baidu.live.entereffect.a.Ex().h(aVar)) {
                    this.bgP.x(aVar);
                }
            } else if ("task".equals(str)) {
                I(jSONObject);
            }
        }
    }

    public e(Context context, w wVar) {
        this.mContext = context;
        this.aDh = wVar;
        if (this.aDh != null) {
            this.bhb = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            KD();
            initListener();
        }
    }

    private void KD() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bgS = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.bgS.setVisibility(4);
        this.bgN = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.bgT = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.bgT.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bgT.setIsRound(true);
        this.bgT.setAutoChangeStyle(false);
        this.bgT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bgU = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.bgV = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.bgW = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.bgX = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bgY = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.bgZ = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.bgZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.KH();
            }
        });
        this.bha = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.bha.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bhe = true;
                e.this.bgS.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bgO = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.bgO.setMode(true);
        this.bgO.b(String.valueOf(this.aDh.mLiveInfo.group_id), String.valueOf(this.aDh.mLiveInfo.live_id), false, this.aDh.aHk != null ? String.valueOf(this.aDh.aHk.userId) : null);
        this.bgP = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        f(this.aDh);
        KF();
    }

    private void f(w wVar) {
        CustomResponsedMessage runTask;
        if (this.bgR == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bgR = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bgR != null) {
            this.bgR.i(wVar);
            this.bgR.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.bgR.a(1, null);
        }
    }

    private void KE() {
        this.bgS.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bgS.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bhi);
        MessageManager.getInstance().registerListener(this.bhg);
        MessageManager.getInstance().registerListener(this.bhh);
    }

    private void KF() {
        PendantChildView Se;
        CustomResponsedMessage runTask;
        if (com.baidu.live.aa.a.Ph().bms.DR()) {
            if (this.bgQ == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ad.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bgQ = (com.baidu.live.ad.b) runTask.getData();
            }
            if (this.bgQ != null && (Se = this.bgQ.Se()) != null && this.bgN.indexOfChild(Se) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bgN.addView(Se, layoutParams);
            }
            KG();
        }
    }

    private void I(JSONObject jSONObject) {
        if (this.bgQ != null) {
            this.bgQ.P(jSONObject);
        }
    }

    private void KG() {
        if (this.bgQ != null && this.bgQ.Se() != null && this.aDh != null) {
            this.bgQ.i(this.aDh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bhc) {
            TiebaInitialize.log("c12553");
        }
        this.bhc = !this.bhc;
        bX(this.bhc);
        bY(this.bhc);
        String valueOf = String.valueOf(this.aDh.aHk.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aDh.aHk.portrait, valueOf, "1", this.bhc, bgM);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.VO().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        this.bhc = z;
        if (z) {
            this.bgZ.setEnabled(false);
            this.bgZ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.bgZ.setBackgroundDrawable(null);
            this.bgZ.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.bgZ.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.bgZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bgZ.setCompoundDrawablePadding(0);
            return;
        }
        this.bgZ.setEnabled(true);
        this.bgZ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.bgZ.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.bgZ.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.bgZ.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.bgZ.setCompoundDrawablesWithIntrinsicBounds(this.bhb, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bgZ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        if (z) {
            TextView textView = this.bgY;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.bhd + 1;
            this.bhd = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bgY;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.bhd - 1;
        this.bhd = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bgO != null) {
            this.bgO.setMsgData(list);
            if (z) {
                this.bgO.KZ();
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
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bhf) {
            KE();
        }
        this.bhf = false;
        this.bgO.setSelection(this.bgO.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bgQ != null) {
            this.bgQ.onDestroy();
        }
        if (this.bhi != null) {
            MessageManager.getInstance().unRegisterListener(this.bhi);
        }
        MessageManager.getInstance().unRegisterListener(this.bhg);
        MessageManager.getInstance().unRegisterListener(this.bhh);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bgO != null) {
            this.bgO.Mn();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
