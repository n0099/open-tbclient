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
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId aZF = BdUniqueId.gen();
    private r aAj;
    private LinearLayout aZG;
    private ALAImMsgListView aZH;
    private ALAImEnterView aZI;
    private com.baidu.live.y.b aZJ;
    private com.baidu.live.liveroom.b.a aZK;
    private View aZL;
    private HeadImageView aZM;
    private TextView aZN;
    private ImageView aZO;
    private ALALevelView aZP;
    private TextView aZQ;
    private TextView aZR;
    private TextView aZS;
    private View aZT;
    private Drawable aZU;
    private boolean aZV;
    private int aZW;
    private boolean aZY;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aZX = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aZZ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener baa = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.JK() instanceof com.baidu.live.data.a)) {
                    aVar.JK().aCT = -1;
                }
                e.this.r(aVar);
            }
        }
    };
    private CustomMessageListener bab = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aAj.aDG.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aZF);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bN(z);
                            e.this.bO(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Qx().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aZV = !e.this.aZV;
                            e.this.bN(e.this.aZV);
                            e.this.bO(e.this.aZV);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aZV = e.this.aZV ? false : true;
                        e.this.bN(e.this.aZV);
                        e.this.bO(e.this.aZV);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.live.im.data.a aVar) {
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
                if (com.baidu.live.entereffect.a.Dg().h(aVar)) {
                    this.aZI.v(aVar);
                }
            } else if ("task".equals(str)) {
                I(jSONObject);
            }
        }
    }

    public e(Context context, r rVar) {
        this.mContext = context;
        this.aAj = rVar;
        if (this.aAj != null) {
            this.aZU = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            IH();
            initListener();
        }
    }

    private void IH() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aZL = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aZL.setVisibility(4);
        this.aZG = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aZM = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aZM.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aZM.setIsRound(true);
        this.aZM.setAutoChangeStyle(false);
        this.aZM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aZN = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aZO = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aZP = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aZQ = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aZR = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aZS = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.IL();
            }
        });
        this.aZT = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aZT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aZX = true;
                e.this.aZL.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aZH = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aZH.setMode(true);
        this.aZH.b(String.valueOf(this.aAj.mLiveInfo.group_id), String.valueOf(this.aAj.mLiveInfo.live_id), false, this.aAj.aDG != null ? String.valueOf(this.aAj.aDG.userId) : null);
        this.aZI = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aAj);
        IJ();
    }

    private void f(r rVar) {
        CustomResponsedMessage runTask;
        if (this.aZK == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aZK = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aZK != null) {
            this.aZK.j(rVar);
            this.aZK.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aZK.a(1, null);
        }
    }

    private void II() {
        this.aZL.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aZL.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bab);
        MessageManager.getInstance().registerListener(this.aZZ);
        MessageManager.getInstance().registerListener(this.baa);
    }

    private void IJ() {
        PendantChildView NC;
        CustomResponsedMessage runTask;
        if (com.baidu.live.w.a.Nk().beJ.CI()) {
            if (this.aZJ == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.y.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aZJ = (com.baidu.live.y.b) runTask.getData();
            }
            if (this.aZJ != null && (NC = this.aZJ.NC()) != null && this.aZG.indexOfChild(NC) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aZG.addView(NC, layoutParams);
            }
            IK();
        }
    }

    private void I(JSONObject jSONObject) {
        if (this.aZJ != null) {
            this.aZJ.N(jSONObject);
        }
    }

    private void IK() {
        if (this.aZJ != null && this.aZJ.NC() != null && this.aAj != null) {
            this.aZJ.j(this.aAj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aZV) {
            TiebaInitialize.log("c12553");
        }
        this.aZV = !this.aZV;
        bN(this.aZV);
        bO(this.aZV);
        String valueOf = String.valueOf(this.aAj.aDG.userId);
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aAj.aDG.portrait, valueOf, "1", this.aZV, aZF);
        dVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Qx().a(valueOf, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        this.aZV = z;
        if (z) {
            this.aZS.setEnabled(false);
            this.aZS.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aZS.setBackgroundDrawable(null);
            this.aZS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aZS.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aZS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aZS.setCompoundDrawablePadding(0);
            return;
        }
        this.aZS.setEnabled(true);
        this.aZS.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aZS.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aZS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aZS.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aZS.setCompoundDrawablesWithIntrinsicBounds(this.aZU, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aZS.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z) {
            TextView textView = this.aZR;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aZW + 1;
            this.aZW = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aZR;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aZW - 1;
        this.aZW = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aZH != null) {
            this.aZH.setMsgData(list);
            if (z) {
                this.aZH.Je();
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
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aZY) {
            II();
        }
        this.aZY = false;
        this.aZH.setSelection(this.aZH.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aZJ != null) {
            this.aZJ.onDestroy();
        }
        if (this.bab != null) {
            MessageManager.getInstance().unRegisterListener(this.bab);
        }
        MessageManager.getInstance().unRegisterListener(this.aZZ);
        MessageManager.getInstance().unRegisterListener(this.baa);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aZH != null) {
            this.aZH.Kq();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
