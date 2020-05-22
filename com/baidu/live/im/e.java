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
    private static final BdUniqueId aQq = BdUniqueId.gen();
    private com.baidu.live.data.q aJj;
    private ALALevelView aQA;
    private TextView aQB;
    private TextView aQC;
    private TextView aQD;
    private View aQE;
    private Drawable aQF;
    private boolean aQG;
    private int aQH;
    private boolean aQJ;
    private LinearLayout aQr;
    private ALAImMsgListView aQs;
    private ALAImEnterView aQt;
    private com.baidu.live.x.b aQu;
    private com.baidu.live.liveroom.b.a aQv;
    private View aQw;
    private HeadImageView aQx;
    private TextView aQy;
    private ImageView aQz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aQI = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aQK = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aQL = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.DB() instanceof com.baidu.live.data.a)) {
                    aVar.DB().auw = -1;
                }
                e.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aQM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aJj.avj.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aQq);
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
                            com.baidu.live.view.a.Jl().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aQG = !e.this.aQG;
                            e.this.bE(e.this.aQG);
                            e.this.bF(e.this.aQG);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aQG = e.this.aQG ? false : true;
                        e.this.bE(e.this.aQG);
                        e.this.bF(e.this.aQG);
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
                if (com.baidu.live.entereffect.a.wD().a(aVar)) {
                    this.aQt.v(aVar);
                }
            } else if ("task".equals(str)) {
                E(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.q qVar) {
        this.mContext = context;
        this.aJj = qVar;
        if (this.aJj != null) {
            this.aQF = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            Cd();
            initListener();
        }
    }

    private void Cd() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aQw = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aQw.setVisibility(4);
        this.aQr = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aQx = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aQx.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aQx.setIsRound(true);
        this.aQx.setAutoChangeStyle(false);
        this.aQx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQy = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aQz = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aQA = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aQB = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aQC = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aQD = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Ch();
            }
        });
        this.aQE = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aQI = true;
                e.this.aQw.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aQs = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aQs.setMode(true);
        this.aQs.a(String.valueOf(this.aJj.mLiveInfo.group_id), String.valueOf(this.aJj.mLiveInfo.live_id), false, this.aJj.avj != null ? String.valueOf(this.aJj.avj.userId) : null);
        this.aQt = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.aJj);
        Cf();
    }

    private void f(com.baidu.live.data.q qVar) {
        CustomResponsedMessage runTask;
        if (this.aQv == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aQv = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aQv != null) {
            this.aQv.h(qVar);
            this.aQv.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aQv.a(1, this.aQr, layoutParams);
        }
    }

    private void Ce() {
        this.aQw.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0182a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aQw.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aQM);
        MessageManager.getInstance().registerListener(this.aQK);
        MessageManager.getInstance().registerListener(this.aQL);
    }

    private void Cf() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Ge().aWF.wf()) {
            if (this.aQu == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aQu = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.aQu != null && (view = this.aQu.getView()) != null && this.aQr.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aQr.addView(view, layoutParams);
            }
            Cg();
        }
    }

    private void E(JSONObject jSONObject) {
        if (this.aQu != null) {
            this.aQu.G(jSONObject);
        }
    }

    private void Cg() {
        if (this.aQu != null && this.aQu.getView() != null && this.aJj != null && this.aJj.avM != null) {
            this.aQu.a(this.aJj.avM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aQG) {
            TiebaInitialize.log("c12553");
        }
        this.aQG = !this.aQG;
        bE(this.aQG);
        bF(this.aQG);
        String valueOf = String.valueOf(this.aJj.avj.userId);
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.aJj.avj.portrait, valueOf, "1", this.aQG, aQq);
        dVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Jl().a(valueOf, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        this.aQG = z;
        if (z) {
            this.aQD.setEnabled(false);
            this.aQD.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aQD.setBackgroundDrawable(null);
            this.aQD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aQD.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aQD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aQD.setCompoundDrawablePadding(0);
            return;
        }
        this.aQD.setEnabled(true);
        this.aQD.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aQD.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aQD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aQD.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aQD.setCompoundDrawablesWithIntrinsicBounds(this.aQF, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQD.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (z) {
            TextView textView = this.aQC;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aQH + 1;
            this.aQH = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aQC;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aQH - 1;
        this.aQH = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aQs != null) {
            this.aQs.setMsgData(list);
            if (z) {
                this.aQs.Cz();
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
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aQJ) {
            Ce();
        }
        this.aQJ = false;
        this.aQs.setSelection(this.aQs.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aQu != null) {
            this.aQu.onDestroy();
        }
        if (this.aQM != null) {
            MessageManager.getInstance().unRegisterListener(this.aQM);
        }
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.aQL);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aQs != null) {
            this.aQs.Ec();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
