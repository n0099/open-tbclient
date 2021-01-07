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
/* loaded from: classes11.dex */
public class e implements com.baidu.live.liveroom.d.d {
    private static final BdUniqueId bmH = BdUniqueId.gen();
    private x aGe;
    private LinearLayout bmI;
    private ALAImMsgListView bmJ;
    private ALAImEnterView bmK;
    private com.baidu.live.ai.b bmL;
    private com.baidu.live.liveroom.b.a bmM;
    private View bmN;
    private HeadImageView bmO;
    private TextView bmP;
    private ImageView bmQ;
    private ALALevelView bmR;
    private TextView bmS;
    private TextView bmT;
    private TextView bmU;
    private View bmV;
    private Drawable bmW;
    private boolean bmX;
    private int bmY;
    private boolean bna;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bmZ = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bnb = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bnc = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (bVar != null && (bVar.Nw() instanceof com.baidu.live.data.a)) {
                    bVar.Nw().aIY = -1;
                }
                e.this.t(bVar);
            }
        }
    };
    private CustomMessageListener aWQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aGe.aKu.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bmH);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.cg(z);
                            e.this.ch(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.h.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.Zy().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Zy().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bmX = !e.this.bmX;
                            e.this.cg(e.this.bmX);
                            e.this.ch(e.this.bmX);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bmX = e.this.bmX ? false : true;
                        e.this.cg(e.this.bmX);
                        e.this.ch(e.this.bmX);
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
                if (com.baidu.live.entereffect.a.FB().h(bVar)) {
                    this.bmK.A(bVar);
                }
            } else if ("task".equals(str)) {
                Q(jSONObject);
            }
        }
    }

    public e(Context context, x xVar) {
        this.mContext = context;
        this.aGe = xVar;
        if (this.aGe != null) {
            this.bmW = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            Mc();
            initListener();
        }
    }

    private void Mc() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bmN = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.bmN.setVisibility(4);
        this.bmI = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.bmO = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.bmO.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bmO.setIsRound(true);
        this.bmO.setAutoChangeStyle(false);
        this.bmO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bmP = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.bmQ = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.bmR = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.bmS = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bmT = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.bmU = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.bmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Mg();
            }
        });
        this.bmV = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.bmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bmZ = true;
                e.this.bmN.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bmJ = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.bmJ.setMode(true);
        this.bmJ.a(String.valueOf(this.aGe.mLiveInfo.group_id), String.valueOf(this.aGe.mLiveInfo.live_id), false, this.aGe.aKu != null ? String.valueOf(this.aGe.aKu.userId) : null, this.aGe.getGuardName());
        this.bmK = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        g(this.aGe);
        Me();
    }

    private void g(x xVar) {
        CustomResponsedMessage runTask;
        if (this.bmM == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bmM = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bmM != null) {
            this.bmM.j(xVar);
            this.bmM.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.bmM.a(1, null);
        }
    }

    private void Md() {
        this.bmN.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0203a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bmN.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aWQ);
        MessageManager.getInstance().registerListener(this.bnb);
        MessageManager.getInstance().registerListener(this.bnc);
    }

    private void Me() {
        PendantChildView VH;
        CustomResponsedMessage runTask;
        if (com.baidu.live.af.a.SE().bwi.ES()) {
            if (this.bmL == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ai.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bmL = (com.baidu.live.ai.b) runTask.getData();
            }
            if (this.bmL != null && (VH = this.bmL.VH()) != null && this.bmI.indexOfChild(VH) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bmI.addView(VH, layoutParams);
            }
            Mf();
        }
    }

    private void Q(JSONObject jSONObject) {
        if (this.bmL != null) {
            this.bmL.Z(jSONObject);
        }
    }

    private void Mf() {
        if (this.bmL != null && this.bmL.VH() != null && this.aGe != null) {
            this.bmL.j(this.aGe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mg() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bmX) {
            TiebaInitialize.log("c12553");
        }
        this.bmX = !this.bmX;
        cg(this.bmX);
        ch(this.bmX);
        String valueOf = String.valueOf(this.aGe.aKu.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aGe.aKu.portrait, valueOf, "1", this.bmX, bmH);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Zy().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        this.bmX = z;
        if (z) {
            this.bmU.setEnabled(false);
            this.bmU.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.bmU.setBackgroundDrawable(null);
            this.bmU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.bmU.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.bmU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bmU.setCompoundDrawablePadding(0);
            return;
        }
        this.bmU.setEnabled(true);
        this.bmU.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.bmU.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.bmU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.bmU.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.bmU.setCompoundDrawablesWithIntrinsicBounds(this.bmW, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bmU.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (z) {
            TextView textView = this.bmT;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.bmY + 1;
            this.bmY = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bmT;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.bmY - 1;
        this.bmY = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bmJ != null) {
            this.bmJ.setMsgData(list);
            if (z) {
                this.bmJ.Mz();
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
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bna) {
            Md();
        }
        this.bna = false;
        this.bmJ.setSelection(this.bmJ.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bmL != null) {
            this.bmL.onDestroy();
        }
        if (this.aWQ != null) {
            MessageManager.getInstance().unRegisterListener(this.aWQ);
        }
        MessageManager.getInstance().unRegisterListener(this.bnb);
        MessageManager.getInstance().unRegisterListener(this.bnc);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bmJ != null) {
            this.bmJ.Ng();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
