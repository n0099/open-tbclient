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
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId bhS = BdUniqueId.gen();
    private x aBr;
    private LinearLayout bhT;
    private ALAImMsgListView bhU;
    private ALAImEnterView bhV;
    private com.baidu.live.ai.b bhW;
    private com.baidu.live.liveroom.b.a bhX;
    private View bhY;
    private HeadImageView bhZ;
    private TextView bia;
    private ImageView bib;
    private ALALevelView bic;
    private TextView bie;
    private TextView bif;
    private TextView bih;
    private View bii;
    private Drawable bij;
    private boolean bik;
    private int bil;
    private boolean bin;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bim = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bio = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bip = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (bVar != null && (bVar.JB() instanceof com.baidu.live.data.a)) {
                    bVar.JB().aEl = -1;
                }
                e.this.t(bVar);
            }
        }
    };
    private CustomMessageListener aSd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aBr.aFH.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bhS);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.cc(z);
                            e.this.cd(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.h.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.VF().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bik = !e.this.bik;
                            e.this.cc(e.this.bik);
                            e.this.cd(e.this.bik);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bik = e.this.bik ? false : true;
                        e.this.cc(e.this.bik);
                        e.this.cd(e.this.bik);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        String str = null;
        if (bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                try {
                    str = jSONObject.optString("content_type");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if ("enter_live".equals(str)) {
                if (com.baidu.live.entereffect.a.BG().h(bVar)) {
                    this.bhV.A(bVar);
                }
            } else if ("task".equals(str)) {
                Q(jSONObject);
            }
        }
    }

    public e(Context context, x xVar) {
        this.mContext = context;
        this.aBr = xVar;
        if (this.aBr != null) {
            this.bij = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            Ih();
            initListener();
        }
    }

    private void Ih() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bhY = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.bhY.setVisibility(4);
        this.bhT = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.bhZ = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.bhZ.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bhZ.setIsRound(true);
        this.bhZ.setAutoChangeStyle(false);
        this.bhZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bia = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.bib = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.bic = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.bie = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bif = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.bih = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.bih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Il();
            }
        });
        this.bii = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.bii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bim = true;
                e.this.bhY.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bhU = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.bhU.setMode(true);
        this.bhU.a(String.valueOf(this.aBr.mLiveInfo.group_id), String.valueOf(this.aBr.mLiveInfo.live_id), false, this.aBr.aFH != null ? String.valueOf(this.aBr.aFH.userId) : null, this.aBr.getGuardName());
        this.bhV = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        g(this.aBr);
        Ij();
    }

    private void g(x xVar) {
        CustomResponsedMessage runTask;
        if (this.bhX == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bhX = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bhX != null) {
            this.bhX.j(xVar);
            this.bhX.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.bhX.a(1, null);
        }
    }

    private void Ii() {
        this.bhY.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bhY.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aSd);
        MessageManager.getInstance().registerListener(this.bio);
        MessageManager.getInstance().registerListener(this.bip);
    }

    private void Ij() {
        PendantChildView RO;
        CustomResponsedMessage runTask;
        if (com.baidu.live.af.a.OJ().bru.AX()) {
            if (this.bhW == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ai.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bhW = (com.baidu.live.ai.b) runTask.getData();
            }
            if (this.bhW != null && (RO = this.bhW.RO()) != null && this.bhT.indexOfChild(RO) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bhT.addView(RO, layoutParams);
            }
            Ik();
        }
    }

    private void Q(JSONObject jSONObject) {
        if (this.bhW != null) {
            this.bhW.Z(jSONObject);
        }
    }

    private void Ik() {
        if (this.bhW != null && this.bhW.RO() != null && this.aBr != null) {
            this.bhW.j(this.aBr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bik) {
            TiebaInitialize.log("c12553");
        }
        this.bik = !this.bik;
        cc(this.bik);
        cd(this.bik);
        String valueOf = String.valueOf(this.aBr.aFH.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aBr.aFH.portrait, valueOf, "1", this.bik, bhS);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.VF().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        this.bik = z;
        if (z) {
            this.bih.setEnabled(false);
            this.bih.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.bih.setBackgroundDrawable(null);
            this.bih.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.bih.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.bih.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bih.setCompoundDrawablePadding(0);
            return;
        }
        this.bih.setEnabled(true);
        this.bih.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.bih.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.bih.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.bih.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.bih.setCompoundDrawablesWithIntrinsicBounds(this.bij, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bih.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(boolean z) {
        if (z) {
            TextView textView = this.bif;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.bil + 1;
            this.bil = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bif;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.bil - 1;
        this.bil = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bhU != null) {
            this.bhU.setMsgData(list);
            if (z) {
                this.bhU.IE();
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
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bin) {
            Ii();
        }
        this.bin = false;
        this.bhU.setSelection(this.bhU.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bhW != null) {
            this.bhW.onDestroy();
        }
        if (this.aSd != null) {
            MessageManager.getInstance().unRegisterListener(this.aSd);
        }
        MessageManager.getInstance().unRegisterListener(this.bio);
        MessageManager.getInstance().unRegisterListener(this.bip);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bhU != null) {
            this.bhU.Jl();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
