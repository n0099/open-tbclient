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
    private static final BdUniqueId arz = BdUniqueId.gen();
    private com.baidu.live.data.m alp;
    private LinearLayout arA;
    private ALAImMsgListView arB;
    private ALAImEnterView arC;
    private com.baidu.live.x.b arD;
    private com.baidu.live.liveroom.b.a arE;
    private View arF;
    private HeadImageView arG;
    private TextView arH;
    private ImageView arI;
    private ALALevelView arJ;
    private TextView arK;
    private TextView arL;
    private TextView arM;
    private View arN;
    private Drawable arO;
    private boolean arP;
    private int arQ;
    private boolean arS;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean arR = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener arT = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener arU = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.xt() instanceof com.baidu.live.data.a)) {
                    aVar.xt().Xu = -1;
                }
                e.this.g(aVar);
            }
        }
    };
    private CustomMessageListener arV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.alp.Ya.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.arz);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.aR(z);
                            e.this.aS(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Bq().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.arP = !e.this.arP;
                            e.this.aR(e.this.arP);
                            e.this.aS(e.this.arP);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.arP = e.this.arP ? false : true;
                        e.this.aR(e.this.arP);
                        e.this.aS(e.this.arP);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.im.data.a aVar) {
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
                if (com.baidu.live.entereffect.a.qW().a(aVar)) {
                    this.arC.r(aVar);
                }
            } else if ("task".equals(str)) {
                u(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.m mVar) {
        this.mContext = context;
        this.alp = mVar;
        if (this.alp != null) {
            this.arO = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            we();
            initListener();
        }
    }

    private void we() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.arF = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.arF.setVisibility(4);
        this.arA = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.arG = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.arG.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arG.setIsRound(true);
        this.arG.setAutoChangeStyle(false);
        this.arG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.arH = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.arI = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.arJ = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.arK = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.arL = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.arM = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.arM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.wi();
            }
        });
        this.arN = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.arN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.arR = true;
                e.this.arF.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.arB = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.arB.setMode(true);
        this.arB.a(String.valueOf(this.alp.mLiveInfo.group_id), String.valueOf(this.alp.mLiveInfo.live_id), false, this.alp.Ya != null ? String.valueOf(this.alp.Ya.userId) : null);
        this.arC = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.alp);
        wg();
    }

    private void f(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.arE == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.arE = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.arE != null) {
            this.arE.h(mVar);
            this.arE.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.arE.a(1, this.arA, layoutParams);
        }
    }

    private void wf() {
        this.arF.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0102a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.arF.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.arV);
        MessageManager.getInstance().registerListener(this.arT);
        MessageManager.getInstance().registerListener(this.arU);
    }

    private void wg() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.zs().awM.qD()) {
            if (this.arD == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.arD = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.arD != null && (view = this.arD.getView()) != null && this.arA.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.arA.addView(view, layoutParams);
            }
            wh();
        }
    }

    private void u(JSONObject jSONObject) {
        if (this.arD != null) {
            this.arD.v(jSONObject);
        }
    }

    private void wh() {
        if (this.arD != null && this.arD.getView() != null && this.alp != null && this.alp.Yx != null) {
            this.arD.a(this.alp.Yx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.arP) {
            TiebaInitialize.log("c12553");
        }
        this.arP = !this.arP;
        aR(this.arP);
        aS(this.arP);
        String valueOf = String.valueOf(this.alp.Ya.userId);
        com.baidu.live.view.a.Bq().a(valueOf, new com.baidu.live.data.b(this.alp.Ya.portrait, valueOf, "1", this.arP, arz));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arP = z;
        if (z) {
            this.arM.setEnabled(false);
            this.arM.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.arM.setBackgroundDrawable(null);
            this.arM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.arM.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.arM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.arM.setCompoundDrawablePadding(0);
            return;
        }
        this.arM.setEnabled(true);
        this.arM.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.arM.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.arM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.arM.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.arM.setCompoundDrawablesWithIntrinsicBounds(this.arO, (Drawable) null, (Drawable) null, (Drawable) null);
        this.arM.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.arL;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.arQ + 1;
            this.arQ = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.arL;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.arQ - 1;
        this.arQ = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.arB != null) {
            this.arB.setMsgData(list);
            if (z) {
                this.arB.wu();
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.arS) {
            wf();
        }
        this.arS = false;
        this.arB.setSelection(this.arB.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.arD != null) {
            this.arD.onDestroy();
        }
        if (this.arV != null) {
            MessageManager.getInstance().unRegisterListener(this.arV);
        }
        MessageManager.getInstance().unRegisterListener(this.arT);
        MessageManager.getInstance().unRegisterListener(this.arU);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.arB != null) {
            this.arB.xQ();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
