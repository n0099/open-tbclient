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
import com.baidu.live.data.q;
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
    private static final BdUniqueId aUp = BdUniqueId.gen();
    private TextView aUA;
    private TextView aUB;
    private TextView aUC;
    private View aUD;
    private Drawable aUE;
    private boolean aUF;
    private int aUG;
    private boolean aUI;
    private LinearLayout aUq;
    private ALAImMsgListView aUr;
    private ALAImEnterView aUs;
    private com.baidu.live.x.b aUt;
    private com.baidu.live.liveroom.b.a aUu;
    private View aUv;
    private HeadImageView aUw;
    private TextView aUx;
    private ImageView aUy;
    private ALALevelView aUz;
    private q avf;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aUH = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aUJ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aUK = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Eh() instanceof com.baidu.live.data.a)) {
                    aVar.Eh().axP = -1;
                }
                e.this.r(aVar);
            }
        }
    };
    private CustomMessageListener aUL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.avf.ayC.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aUp);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bH(z);
                            e.this.bI(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.KF().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.aUF = !e.this.aUF;
                            e.this.bH(e.this.aUF);
                            e.this.bI(e.this.aUF);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aUF = e.this.aUF ? false : true;
                        e.this.bH(e.this.aUF);
                        e.this.bI(e.this.aUF);
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
                if (com.baidu.live.entereffect.a.xD().h(aVar)) {
                    this.aUs.v(aVar);
                }
            } else if ("task".equals(str)) {
                G(jSONObject);
            }
        }
    }

    public e(Context context, q qVar) {
        this.mContext = context;
        this.avf = qVar;
        if (this.avf != null) {
            this.aUE = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            De();
            initListener();
        }
    }

    private void De() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aUv = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aUv.setVisibility(4);
        this.aUq = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aUw = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aUw.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aUw.setIsRound(true);
        this.aUw.setAutoChangeStyle(false);
        this.aUw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aUx = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aUy = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aUz = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aUA = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aUB = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aUC = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Di();
            }
        });
        this.aUD = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aUH = true;
                e.this.aUv.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.aUr = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.aUr.setMode(true);
        this.aUr.a(String.valueOf(this.avf.mLiveInfo.group_id), String.valueOf(this.avf.mLiveInfo.live_id), false, this.avf.ayC != null ? String.valueOf(this.avf.ayC.userId) : null);
        this.aUs = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.avf);
        Dg();
    }

    private void f(q qVar) {
        CustomResponsedMessage runTask;
        if (this.aUu == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aUu = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aUu != null) {
            this.aUu.j(qVar);
            this.aUu.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aUu.a(1, null);
        }
    }

    private void Df() {
        this.aUv.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0178a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aUv.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aUL);
        MessageManager.getInstance().registerListener(this.aUJ);
        MessageManager.getInstance().registerListener(this.aUK);
    }

    private void Dg() {
        PendantChildView HJ;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Hs().aZn.xf()) {
            if (this.aUt == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aUt = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.aUt != null && (HJ = this.aUt.HJ()) != null && this.aUq.indexOfChild(HJ) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.aUq.addView(HJ, layoutParams);
            }
            Dh();
        }
    }

    private void G(JSONObject jSONObject) {
        if (this.aUt != null) {
            this.aUt.L(jSONObject);
        }
    }

    private void Dh() {
        if (this.aUt != null && this.aUt.HJ() != null && this.avf != null) {
            this.aUt.j(this.avf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aUF) {
            TiebaInitialize.log("c12553");
        }
        this.aUF = !this.aUF;
        bH(this.aUF);
        bI(this.aUF);
        String valueOf = String.valueOf(this.avf.ayC.userId);
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.avf.ayC.portrait, valueOf, "1", this.aUF, aUp);
        dVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.KF().a(valueOf, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
        this.aUF = z;
        if (z) {
            this.aUC.setEnabled(false);
            this.aUC.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aUC.setBackgroundDrawable(null);
            this.aUC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aUC.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aUC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aUC.setCompoundDrawablePadding(0);
            return;
        }
        this.aUC.setEnabled(true);
        this.aUC.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aUC.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aUC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aUC.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aUC.setCompoundDrawablesWithIntrinsicBounds(this.aUE, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aUC.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (z) {
            TextView textView = this.aUB;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aUG + 1;
            this.aUG = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aUB;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aUG - 1;
        this.aUG = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aUr != null) {
            this.aUr.setMsgData(list);
            if (z) {
                this.aUr.DB();
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
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.aUI) {
            Df();
        }
        this.aUI = false;
        this.aUr.setSelection(this.aUr.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.aUt != null) {
            this.aUt.onDestroy();
        }
        if (this.aUL != null) {
            MessageManager.getInstance().unRegisterListener(this.aUL);
        }
        MessageManager.getInstance().unRegisterListener(this.aUJ);
        MessageManager.getInstance().unRegisterListener(this.aUK);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.aUr != null) {
            this.aUr.EL();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
