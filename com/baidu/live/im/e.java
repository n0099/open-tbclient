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
/* loaded from: classes3.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId aSW = BdUniqueId.gen();
    private com.baidu.live.data.q aLQ;
    private LinearLayout aSX;
    private ALAImMsgListView aSY;
    private ALAImEnterView aSZ;
    private com.baidu.live.x.b aTa;
    private com.baidu.live.liveroom.b.a aTb;
    private View aTc;
    private HeadImageView aTd;
    private TextView aTe;
    private ImageView aTf;
    private ALALevelView aTg;
    private TextView aTh;
    private TextView aTi;
    private TextView aTj;
    private View aTk;
    private Drawable aTl;
    private boolean aTm;
    private int aTn;
    private boolean aTp;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aTo = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aTq = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aTr = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Ed() instanceof com.baidu.live.data.a)) {
                    aVar.Ed().awC = -1;
                }
                e.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aTs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aLQ.axp.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aSW);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bE(z);
                            e.this.bF(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Ky().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aTm = !e.this.aTm;
                            e.this.bE(e.this.aTm);
                            e.this.bF(e.this.aTm);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aTm = e.this.aTm ? false : true;
                        e.this.bE(e.this.aTm);
                        e.this.bF(e.this.aTm);
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
                if (com.baidu.live.entereffect.a.xa().a(aVar)) {
                    this.aSZ.v(aVar);
                }
            } else if ("task".equals(str)) {
                G(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.q qVar) {
        this.mContext = context;
        this.aLQ = qVar;
        if (this.aLQ != null) {
            this.aTl = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            CD();
            initListener();
        }
    }

    private void CD() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aTc = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aTc.setVisibility(4);
        this.aSX = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aTd = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aTd.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aTd.setIsRound(true);
        this.aTd.setAutoChangeStyle(false);
        this.aTd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aTe = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aTf = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aTg = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aTh = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aTi = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aTj = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aTj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.CH();
            }
        });
        this.aTk = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aTo = true;
                e.this.aTc.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aSY = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aSY.setMode(true);
        this.aSY.a(String.valueOf(this.aLQ.mLiveInfo.group_id), String.valueOf(this.aLQ.mLiveInfo.live_id), false, this.aLQ.axp != null ? String.valueOf(this.aLQ.axp.userId) : null);
        this.aSZ = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aLQ);
        CF();
    }

    private void f(com.baidu.live.data.q qVar) {
        CustomResponsedMessage runTask;
        if (this.aTb == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aTb = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aTb != null) {
            this.aTb.j(qVar);
            this.aTb.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aTb.a(1, null);
        }
    }

    private void CE() {
        this.aTc.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0176a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aTc.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aTs);
        MessageManager.getInstance().registerListener(this.aTq);
        MessageManager.getInstance().registerListener(this.aTr);
    }

    private void CF() {
        PendantChildView HD;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Hm().aZp.wD()) {
            if (this.aTa == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aTa = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.aTa != null && (HD = this.aTa.HD()) != null && this.aSX.indexOfChild(HD) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aSX.addView(HD, layoutParams);
            }
            CG();
        }
    }

    private void G(JSONObject jSONObject) {
        if (this.aTa != null) {
            this.aTa.L(jSONObject);
        }
    }

    private void CG() {
        if (this.aTa != null && this.aTa.HD() != null && this.aLQ != null && this.aLQ.axS != null) {
            this.aTa.a(this.aLQ.axS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aTm) {
            TiebaInitialize.log("c12553");
        }
        this.aTm = !this.aTm;
        bE(this.aTm);
        bF(this.aTm);
        String valueOf = String.valueOf(this.aLQ.axp.userId);
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aLQ.axp.portrait, valueOf, "1", this.aTm, aSW);
        dVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Ky().a(valueOf, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        this.aTm = z;
        if (z) {
            this.aTj.setEnabled(false);
            this.aTj.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aTj.setBackgroundDrawable(null);
            this.aTj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aTj.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aTj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aTj.setCompoundDrawablePadding(0);
            return;
        }
        this.aTj.setEnabled(true);
        this.aTj.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aTj.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aTj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aTj.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aTj.setCompoundDrawablesWithIntrinsicBounds(this.aTl, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aTj.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (z) {
            TextView textView = this.aTi;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aTn + 1;
            this.aTn = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aTi;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aTn - 1;
        this.aTn = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aSY != null) {
            this.aSY.setMsgData(list);
            if (z) {
                this.aSY.CZ();
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
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aTp) {
            CE();
        }
        this.aTp = false;
        this.aSY.setSelection(this.aSY.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aTa != null) {
            this.aTa.onDestroy();
        }
        if (this.aTs != null) {
            MessageManager.getInstance().unRegisterListener(this.aTs);
        }
        MessageManager.getInstance().unRegisterListener(this.aTq);
        MessageManager.getInstance().unRegisterListener(this.aTr);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aSY != null) {
            this.aSY.EE();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
