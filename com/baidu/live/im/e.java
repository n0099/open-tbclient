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
    private static final BdUniqueId aZD = BdUniqueId.gen();
    private r aAh;
    private LinearLayout aZE;
    private ALAImMsgListView aZF;
    private ALAImEnterView aZG;
    private com.baidu.live.y.b aZH;
    private com.baidu.live.liveroom.b.a aZI;
    private View aZJ;
    private HeadImageView aZK;
    private TextView aZL;
    private ImageView aZM;
    private ALALevelView aZN;
    private TextView aZO;
    private TextView aZP;
    private TextView aZQ;
    private View aZR;
    private Drawable aZS;
    private boolean aZT;
    private int aZU;
    private boolean aZW;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aZV = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aZX = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aZY = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.JK() instanceof com.baidu.live.data.a)) {
                    aVar.JK().aCR = -1;
                }
                e.this.r(aVar);
            }
        }
    };
    private CustomMessageListener aZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aAh.aDE.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aZD);
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
                            e.this.aZT = !e.this.aZT;
                            e.this.bN(e.this.aZT);
                            e.this.bO(e.this.aZT);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aZT = e.this.aZT ? false : true;
                        e.this.bN(e.this.aZT);
                        e.this.bO(e.this.aZT);
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
                    this.aZG.v(aVar);
                }
            } else if ("task".equals(str)) {
                I(jSONObject);
            }
        }
    }

    public e(Context context, r rVar) {
        this.mContext = context;
        this.aAh = rVar;
        if (this.aAh != null) {
            this.aZS = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            IH();
            initListener();
        }
    }

    private void IH() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aZJ = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aZJ.setVisibility(4);
        this.aZE = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aZK = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aZK.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aZK.setIsRound(true);
        this.aZK.setAutoChangeStyle(false);
        this.aZK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aZL = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aZM = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aZN = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aZO = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aZP = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aZQ = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aZQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.IL();
            }
        });
        this.aZR = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aZR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aZV = true;
                e.this.aZJ.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aZF = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aZF.setMode(true);
        this.aZF.b(String.valueOf(this.aAh.mLiveInfo.group_id), String.valueOf(this.aAh.mLiveInfo.live_id), false, this.aAh.aDE != null ? String.valueOf(this.aAh.aDE.userId) : null);
        this.aZG = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aAh);
        IJ();
    }

    private void f(r rVar) {
        CustomResponsedMessage runTask;
        if (this.aZI == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aZI = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aZI != null) {
            this.aZI.j(rVar);
            this.aZI.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aZI.a(1, null);
        }
    }

    private void II() {
        this.aZJ.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0185a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aZJ.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aZZ);
        MessageManager.getInstance().registerListener(this.aZX);
        MessageManager.getInstance().registerListener(this.aZY);
    }

    private void IJ() {
        PendantChildView NC;
        CustomResponsedMessage runTask;
        if (com.baidu.live.w.a.Nk().beH.CI()) {
            if (this.aZH == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.y.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aZH = (com.baidu.live.y.b) runTask.getData();
            }
            if (this.aZH != null && (NC = this.aZH.NC()) != null && this.aZE.indexOfChild(NC) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aZE.addView(NC, layoutParams);
            }
            IK();
        }
    }

    private void I(JSONObject jSONObject) {
        if (this.aZH != null) {
            this.aZH.N(jSONObject);
        }
    }

    private void IK() {
        if (this.aZH != null && this.aZH.NC() != null && this.aAh != null) {
            this.aZH.j(this.aAh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aZT) {
            TiebaInitialize.log("c12553");
        }
        this.aZT = !this.aZT;
        bN(this.aZT);
        bO(this.aZT);
        String valueOf = String.valueOf(this.aAh.aDE.userId);
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aAh.aDE.portrait, valueOf, "1", this.aZT, aZD);
        dVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Qx().a(valueOf, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        this.aZT = z;
        if (z) {
            this.aZQ.setEnabled(false);
            this.aZQ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aZQ.setBackgroundDrawable(null);
            this.aZQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aZQ.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aZQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aZQ.setCompoundDrawablePadding(0);
            return;
        }
        this.aZQ.setEnabled(true);
        this.aZQ.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aZQ.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aZQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aZQ.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aZQ.setCompoundDrawablesWithIntrinsicBounds(this.aZS, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aZQ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z) {
            TextView textView = this.aZP;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aZU + 1;
            this.aZU = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aZP;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aZU - 1;
        this.aZU = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aZF != null) {
            this.aZF.setMsgData(list);
            if (z) {
                this.aZF.Je();
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
        if (this.aZW) {
            II();
        }
        this.aZW = false;
        this.aZF.setSelection(this.aZF.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aZH != null) {
            this.aZH.onDestroy();
        }
        if (this.aZZ != null) {
            MessageManager.getInstance().unRegisterListener(this.aZZ);
        }
        MessageManager.getInstance().unRegisterListener(this.aZX);
        MessageManager.getInstance().unRegisterListener(this.aZY);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aZF != null) {
            this.aZF.Kq();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
