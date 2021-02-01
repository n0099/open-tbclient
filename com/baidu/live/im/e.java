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
import com.baidu.live.data.ab;
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
/* loaded from: classes11.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId blm = BdUniqueId.gen();
    private ab aDd;
    private View blA;
    private Drawable blB;
    private boolean blC;
    private int blD;
    private boolean blF;
    private LinearLayout bln;
    private ALAImMsgListView blo;
    private ALAImEnterView blp;
    private com.baidu.live.ag.b blq;
    private com.baidu.live.liveroom.b.a blr;
    private View bls;
    private HeadImageView blt;
    private TextView blu;
    private ImageView blv;
    private ALALevelView blw;
    private TextView blx;
    private TextView bly;
    private TextView blz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean blE = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener blG = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener blH = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (bVar != null && (bVar.KZ() instanceof com.baidu.live.data.a)) {
                    bVar.KZ().aFY = -1;
                }
                e.this.t(bVar);
            }
        }
    };
    private CustomMessageListener aVh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aDd.aId.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.blm);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.ck(z);
                            e.this.cl(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.h.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Xo().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.blC = !e.this.blC;
                            e.this.ck(e.this.blC);
                            e.this.cl(e.this.blC);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.blC = e.this.blC ? false : true;
                        e.this.ck(e.this.blC);
                        e.this.cl(e.this.blC);
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
                if (com.baidu.live.entereffect.a.CV().h(bVar)) {
                    this.blp.G(bVar);
                }
            } else if ("task".equals(str)) {
                Q(jSONObject);
            }
        }
    }

    public e(Context context, ab abVar) {
        this.mContext = context;
        this.aDd = abVar;
        if (this.aDd != null) {
            this.blB = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            JF();
            initListener();
        }
    }

    private void JF() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bls = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.bls.setVisibility(4);
        this.bln = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.blt = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.blt.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.blt.setIsRound(true);
        this.blt.setAutoChangeStyle(false);
        this.blt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.blu = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.blv = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.blw = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.blx = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bly = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.blz = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.blz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.JJ();
            }
        });
        this.blA = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.blA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.blE = true;
                e.this.bls.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.blo = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.blo.setMode(true);
        this.blo.a(String.valueOf(this.aDd.mLiveInfo.group_id), String.valueOf(this.aDd.mLiveInfo.live_id), false, this.aDd.aId != null ? String.valueOf(this.aDd.aId.userId) : null, this.aDd.getGuardName());
        this.blp = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        f(this.aDd);
        JH();
    }

    private void f(ab abVar) {
        CustomResponsedMessage runTask;
        if (this.blr == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.blr = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.blr != null) {
            this.blr.j(abVar);
            this.blr.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.blr.a(1, null);
        }
    }

    private void JG() {
        this.bls.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bls.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aVh);
        MessageManager.getInstance().registerListener(this.blG);
        MessageManager.getInstance().registerListener(this.blH);
    }

    private void JH() {
        PendantChildView Tv;
        CustomResponsedMessage runTask;
        if (com.baidu.live.ae.a.Qj().buX.Ck()) {
            if (this.blq == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ag.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.blq = (com.baidu.live.ag.b) runTask.getData();
            }
            if (this.blq != null && (Tv = this.blq.Tv()) != null && this.bln.indexOfChild(Tv) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bln.addView(Tv, layoutParams);
            }
            JI();
        }
    }

    private void Q(JSONObject jSONObject) {
        if (this.blq != null) {
            this.blq.ab(jSONObject);
        }
    }

    private void JI() {
        if (this.blq != null && this.blq.Tv() != null && this.aDd != null) {
            this.blq.j(this.aDd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.blC) {
            TiebaInitialize.log("c12553");
        }
        this.blC = !this.blC;
        ck(this.blC);
        cl(this.blC);
        String valueOf = String.valueOf(this.aDd.aId.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aDd.aId.portrait, valueOf, "1", this.blC, blm);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Xo().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        this.blC = z;
        if (z) {
            this.blz.setEnabled(false);
            this.blz.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.blz.setBackgroundDrawable(null);
            this.blz.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.blz.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.blz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.blz.setCompoundDrawablePadding(0);
            return;
        }
        this.blz.setEnabled(true);
        this.blz.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.blz.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.blz.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.blz.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.blz.setCompoundDrawablesWithIntrinsicBounds(this.blB, (Drawable) null, (Drawable) null, (Drawable) null);
        this.blz.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z) {
            TextView textView = this.bly;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.blD + 1;
            this.blD = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bly;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.blD - 1;
        this.blD = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.blo != null) {
            this.blo.setMsgData(list);
            if (z) {
                this.blo.Kc();
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
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.blF) {
            JG();
        }
        this.blF = false;
        this.blo.setSelection(this.blo.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.blq != null) {
            this.blq.onDestroy();
        }
        if (this.aVh != null) {
            MessageManager.getInstance().unRegisterListener(this.aVh);
        }
        MessageManager.getInstance().unRegisterListener(this.blG);
        MessageManager.getInstance().unRegisterListener(this.blH);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.blo != null) {
            this.blo.KJ();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
