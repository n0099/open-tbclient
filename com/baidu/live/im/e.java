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
    private static final BdUniqueId aKw = BdUniqueId.gen();
    private com.baidu.live.data.n aDE;
    private com.baidu.live.x.b aKA;
    private com.baidu.live.liveroom.b.a aKB;
    private View aKC;
    private HeadImageView aKD;
    private TextView aKE;
    private ImageView aKF;
    private ALALevelView aKG;
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private View aKK;
    private Drawable aKL;
    private boolean aKM;
    private int aKN;
    private boolean aKP;
    private LinearLayout aKx;
    private ALAImMsgListView aKy;
    private ALAImEnterView aKz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aKO = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aKQ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aKR = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Cf() instanceof com.baidu.live.data.a)) {
                    aVar.Cf().apx = -1;
                }
                e.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aKS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aDE.aqe.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aKw);
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
                            com.baidu.live.view.a.Ht().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Ht().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aKM = !e.this.aKM;
                            e.this.bu(e.this.aKM);
                            e.this.bv(e.this.aKM);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aKM = e.this.aKM ? false : true;
                        e.this.bu(e.this.aKM);
                        e.this.bv(e.this.aKM);
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
                if (com.baidu.live.entereffect.a.vo().a(aVar)) {
                    this.aKz.v(aVar);
                }
            } else if ("task".equals(str)) {
                A(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.n nVar) {
        this.mContext = context;
        this.aDE = nVar;
        if (this.aDE != null) {
            this.aKL = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            AO();
            initListener();
        }
    }

    private void AO() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aKC = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aKC.setVisibility(4);
        this.aKx = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aKD = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aKD.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKD.setIsRound(true);
        this.aKD.setAutoChangeStyle(false);
        this.aKD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aKE = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aKF = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aKG = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aKH = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aKI = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aKJ = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.AS();
            }
        });
        this.aKK = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aKO = true;
                e.this.aKC.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aKy = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aKy.setMode(true);
        this.aKy.a(String.valueOf(this.aDE.mLiveInfo.group_id), String.valueOf(this.aDE.mLiveInfo.live_id), false, this.aDE.aqe != null ? String.valueOf(this.aDE.aqe.userId) : null);
        this.aKz = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aDE);
        AQ();
    }

    private void f(com.baidu.live.data.n nVar) {
        CustomResponsedMessage runTask;
        if (this.aKB == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aKB = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aKB != null) {
            this.aKB.h(nVar);
            this.aKB.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aKB.a(1, this.aKx, layoutParams);
        }
    }

    private void AP() {
        this.aKC.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0128a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aKC.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aKS);
        MessageManager.getInstance().registerListener(this.aKQ);
        MessageManager.getInstance().registerListener(this.aKR);
    }

    private void AQ() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Eo().aQp.uU()) {
            if (this.aKA == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aKA = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.aKA != null && (view = this.aKA.getView()) != null && this.aKx.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aKx.addView(view, layoutParams);
            }
            AR();
        }
    }

    private void A(JSONObject jSONObject) {
        if (this.aKA != null) {
            this.aKA.B(jSONObject);
        }
    }

    private void AR() {
        if (this.aKA != null && this.aKA.getView() != null && this.aDE != null && this.aDE.aqH != null) {
            this.aKA.a(this.aDE.aqH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aKM) {
            TiebaInitialize.log("c12553");
        }
        this.aKM = !this.aKM;
        bu(this.aKM);
        bv(this.aKM);
        String valueOf = String.valueOf(this.aDE.aqe.userId);
        com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.aDE.aqe.portrait, valueOf, "1", this.aKM, aKw);
        bVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Ht().a(valueOf, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.aKM = z;
        if (z) {
            this.aKJ.setEnabled(false);
            this.aKJ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aKJ.setBackgroundDrawable(null);
            this.aKJ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aKJ.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aKJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aKJ.setCompoundDrawablePadding(0);
            return;
        }
        this.aKJ.setEnabled(true);
        this.aKJ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aKJ.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aKJ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aKJ.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aKJ.setCompoundDrawablesWithIntrinsicBounds(this.aKL, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aKJ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (z) {
            TextView textView = this.aKI;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aKN + 1;
            this.aKN = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aKI;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aKN - 1;
        this.aKN = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aKy != null) {
            this.aKy.setMsgData(list);
            if (z) {
                this.aKy.Be();
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
    public String AT() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aKP) {
            AP();
        }
        this.aKP = false;
        this.aKy.setSelection(this.aKy.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aKA != null) {
            this.aKA.onDestroy();
        }
        if (this.aKS != null) {
            MessageManager.getInstance().unRegisterListener(this.aKS);
        }
        MessageManager.getInstance().unRegisterListener(this.aKQ);
        MessageManager.getInstance().unRegisterListener(this.aKR);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aKy != null) {
            this.aKy.CG();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
