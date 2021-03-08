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
/* loaded from: classes10.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId bmN = BdUniqueId.gen();
    private ab aED;
    private LinearLayout bmO;
    private ALAImMsgListView bmP;
    private ALAImEnterView bmQ;
    private com.baidu.live.ag.b bmR;
    private com.baidu.live.liveroom.b.a bmS;
    private View bmT;
    private HeadImageView bmU;
    private TextView bmV;
    private ImageView bmW;
    private ALALevelView bmX;
    private TextView bmY;
    private TextView bmZ;
    private TextView bna;
    private View bnb;
    private Drawable bnc;
    private boolean bnd;
    private int bne;
    private boolean bng;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bnf = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bnh = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bni = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (bVar != null && (bVar.Lc() instanceof com.baidu.live.data.a)) {
                    bVar.Lc().aHy = -1;
                }
                e.this.t(bVar);
            }
        }
    };
    private CustomMessageListener aWH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aED.aJD.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bmN);
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
                            com.baidu.live.view.a.Xr().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bnd = !e.this.bnd;
                            e.this.ck(e.this.bnd);
                            e.this.cl(e.this.bnd);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bnd = e.this.bnd ? false : true;
                        e.this.ck(e.this.bnd);
                        e.this.cl(e.this.bnd);
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
                if (com.baidu.live.entereffect.a.CY().h(bVar)) {
                    this.bmQ.G(bVar);
                }
            } else if ("task".equals(str)) {
                S(jSONObject);
            }
        }
    }

    public e(Context context, ab abVar) {
        this.mContext = context;
        this.aED = abVar;
        if (this.aED != null) {
            this.bnc = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            JI();
            initListener();
        }
    }

    private void JI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bmT = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.bmT.setVisibility(4);
        this.bmO = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.bmU = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.bmU.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.bmU.setIsRound(true);
        this.bmU.setAutoChangeStyle(false);
        this.bmU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bmV = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.bmW = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.bmX = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.bmY = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bmZ = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.bna = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.bna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.JM();
            }
        });
        this.bnb = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.bnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bnf = true;
                e.this.bmT.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bmP = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.bmP.setMode(true);
        this.bmP.a(String.valueOf(this.aED.mLiveInfo.group_id), String.valueOf(this.aED.mLiveInfo.live_id), false, this.aED.aJD != null ? String.valueOf(this.aED.aJD.userId) : null, this.aED.getGuardName());
        this.bmQ = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        f(this.aED);
        JK();
    }

    private void f(ab abVar) {
        CustomResponsedMessage runTask;
        if (this.bmS == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bmS = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bmS != null) {
            this.bmS.j(abVar);
            this.bmS.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.bmS.a(1, null);
        }
    }

    private void JJ() {
        this.bmT.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0201a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bmT.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aWH);
        MessageManager.getInstance().registerListener(this.bnh);
        MessageManager.getInstance().registerListener(this.bni);
    }

    private void JK() {
        PendantChildView Ty;
        CustomResponsedMessage runTask;
        if (com.baidu.live.ae.a.Qm().bwx.Cn()) {
            if (this.bmR == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ag.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bmR = (com.baidu.live.ag.b) runTask.getData();
            }
            if (this.bmR != null && (Ty = this.bmR.Ty()) != null && this.bmO.indexOfChild(Ty) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bmO.addView(Ty, layoutParams);
            }
            JL();
        }
    }

    private void S(JSONObject jSONObject) {
        if (this.bmR != null) {
            this.bmR.ad(jSONObject);
        }
    }

    private void JL() {
        if (this.bmR != null && this.bmR.Ty() != null && this.aED != null) {
            this.bmR.j(this.aED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bnd) {
            TiebaInitialize.log("c12553");
        }
        this.bnd = !this.bnd;
        ck(this.bnd);
        cl(this.bnd);
        String valueOf = String.valueOf(this.aED.aJD.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aED.aJD.portrait, valueOf, "1", this.bnd, bmN);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Xr().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        this.bnd = z;
        if (z) {
            this.bna.setEnabled(false);
            this.bna.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.bna.setBackgroundDrawable(null);
            this.bna.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.bna.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.bna.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bna.setCompoundDrawablePadding(0);
            return;
        }
        this.bna.setEnabled(true);
        this.bna.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.bna.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.bna.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.bna.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.bna.setCompoundDrawablesWithIntrinsicBounds(this.bnc, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bna.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z) {
            TextView textView = this.bmZ;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.bne + 1;
            this.bne = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bmZ;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.bne - 1;
        this.bne = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bmP != null) {
            this.bmP.setMsgData(list);
            if (z) {
                this.bmP.Kf();
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
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bng) {
            JJ();
        }
        this.bng = false;
        this.bmP.setSelection(this.bmP.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bmR != null) {
            this.bmR.onDestroy();
        }
        if (this.aWH != null) {
            MessageManager.getInstance().unRegisterListener(this.aWH);
        }
        MessageManager.getInstance().unRegisterListener(this.bnh);
        MessageManager.getInstance().unRegisterListener(this.bni);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bmP != null) {
            this.bmP.KM();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
