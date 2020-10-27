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
    private static final BdUniqueId bhe = BdUniqueId.gen();
    private w aEc;
    private LinearLayout bhf;
    private ALAImMsgListView bhg;
    private ALAImEnterView bhh;
    private com.baidu.live.ac.b bhi;
    private com.baidu.live.liveroom.b.a bhj;
    private View bhk;
    private HeadImageView bhl;
    private TextView bhm;
    private ImageView bhn;
    private ALALevelView bho;
    private TextView bhp;
    private TextView bhq;
    private TextView bhr;
    private View bhs;
    private Drawable bht;
    private boolean bhu;
    private int bhv;
    private boolean bhx;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bhw = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bhy = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bhz = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.LO() instanceof com.baidu.live.data.a)) {
                    aVar.LO().aGP = -1;
                }
                e.this.s(aVar);
            }
        }
    };
    private CustomMessageListener bhA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aEc.aIe.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bhe);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bU(z);
                            e.this.bV(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.TX().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.TX().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bhu = !e.this.bhu;
                            e.this.bU(e.this.bhu);
                            e.this.bV(e.this.bhu);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bhu = e.this.bhu ? false : true;
                        e.this.bU(e.this.bhu);
                        e.this.bV(e.this.bhu);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.baidu.live.im.data.a aVar) {
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
                if (com.baidu.live.entereffect.a.EF().h(aVar)) {
                    this.bhh.w(aVar);
                }
            } else if ("task".equals(str)) {
                L(jSONObject);
            }
        }
    }

    public e(Context context, w wVar) {
        this.mContext = context;
        this.aEc = wVar;
        if (this.aEc != null) {
            this.bht = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            KM();
            initListener();
        }
    }

    private void KM() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bhk = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.bhk.setVisibility(4);
        this.bhf = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.bhl = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.bhl.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bhl.setIsRound(true);
        this.bhl.setAutoChangeStyle(false);
        this.bhl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bhm = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.bhn = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.bho = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.bhp = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.bhq = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.bhr = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.bhr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.KQ();
            }
        });
        this.bhs = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.bhs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bhw = true;
                e.this.bhk.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bhg = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.bhg.setMode(true);
        this.bhg.b(String.valueOf(this.aEc.mLiveInfo.group_id), String.valueOf(this.aEc.mLiveInfo.live_id), false, this.aEc.aIe != null ? String.valueOf(this.aEc.aIe.userId) : null);
        this.bhh = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        g(this.aEc);
        KO();
    }

    private void g(w wVar) {
        CustomResponsedMessage runTask;
        if (this.bhj == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bhj = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bhj != null) {
            this.bhj.j(wVar);
            this.bhj.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.bhj.a(1, null);
        }
    }

    private void KN() {
        this.bhk.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bhk.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bhA);
        MessageManager.getInstance().registerListener(this.bhy);
        MessageManager.getInstance().registerListener(this.bhz);
    }

    private void KO() {
        PendantChildView Qd;
        CustomResponsedMessage runTask;
        if (com.baidu.live.z.a.Pq().bmJ.Ee()) {
            if (this.bhi == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ac.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bhi = (com.baidu.live.ac.b) runTask.getData();
            }
            if (this.bhi != null && (Qd = this.bhi.Qd()) != null && this.bhf.indexOfChild(Qd) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bhf.addView(Qd, layoutParams);
            }
            KP();
        }
    }

    private void L(JSONObject jSONObject) {
        if (this.bhi != null) {
            this.bhi.R(jSONObject);
        }
    }

    private void KP() {
        if (this.bhi != null && this.bhi.Qd() != null && this.aEc != null) {
            this.bhi.j(this.aEc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KQ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bhu) {
            TiebaInitialize.log("c12553");
        }
        this.bhu = !this.bhu;
        bU(this.bhu);
        bV(this.bhu);
        String valueOf = String.valueOf(this.aEc.aIe.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aEc.aIe.portrait, valueOf, "1", this.bhu, bhe);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.TX().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        this.bhu = z;
        if (z) {
            this.bhr.setEnabled(false);
            this.bhr.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.bhr.setBackgroundDrawable(null);
            this.bhr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.bhr.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.bhr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bhr.setCompoundDrawablePadding(0);
            return;
        }
        this.bhr.setEnabled(true);
        this.bhr.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.bhr.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.bhr.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.bhr.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.bhr.setCompoundDrawablesWithIntrinsicBounds(this.bht, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bhr.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        if (z) {
            TextView textView = this.bhq;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.bhv + 1;
            this.bhv = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bhq;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.bhv - 1;
        this.bhv = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bhg != null) {
            this.bhg.setMsgData(list);
            if (z) {
                this.bhg.Li();
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
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bhx) {
            KN();
        }
        this.bhx = false;
        this.bhg.setSelection(this.bhg.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bhi != null) {
            this.bhi.onDestroy();
        }
        if (this.bhA != null) {
            MessageManager.getInstance().unRegisterListener(this.bhA);
        }
        MessageManager.getInstance().unRegisterListener(this.bhy);
        MessageManager.getInstance().unRegisterListener(this.bhz);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bhg != null) {
            this.bhg.Mw();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
