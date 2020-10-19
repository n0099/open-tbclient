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
import com.baidu.live.data.u;
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
    private static final BdUniqueId bfP = BdUniqueId.gen();
    private u aDU;
    private LinearLayout bfQ;
    private ALAImMsgListView bfR;
    private ALAImEnterView bfS;
    private com.baidu.live.z.b bfT;
    private com.baidu.live.liveroom.b.a bfU;
    private View bfV;
    private HeadImageView bfW;
    private TextView bfX;
    private ImageView bfY;
    private ALALevelView bfZ;
    private TextView bga;
    private TextView bgb;
    private TextView bgc;
    private View bgd;
    private Drawable bge;
    private boolean bgf;
    private int bgg;
    private boolean bgi;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean bgh = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bgj = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener bgk = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.Lt() instanceof com.baidu.live.data.a)) {
                    aVar.Lt().aGH = -1;
                }
                e.this.r(aVar);
            }
        }
    };
    private CustomMessageListener bgl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aDU.aHD.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.bfP);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.bS(z);
                            e.this.bT(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.SY().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.bgf = !e.this.bgf;
                            e.this.bS(e.this.bgf);
                            e.this.bT(e.this.bgf);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.bgf = e.this.bgf ? false : true;
                        e.this.bS(e.this.bgf);
                        e.this.bT(e.this.bgf);
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
                if (com.baidu.live.entereffect.a.Et().h(aVar)) {
                    this.bfS.v(aVar);
                }
            } else if ("task".equals(str)) {
                J(jSONObject);
            }
        }
    }

    public e(Context context, u uVar) {
        this.mContext = context;
        this.aDU = uVar;
        if (this.aDU != null) {
            this.bge = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            Ks();
            initListener();
        }
    }

    private void Ks() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.bfV = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.bfV.setVisibility(4);
        this.bfQ = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.bfW = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.bfW.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bfW.setIsRound(true);
        this.bfW.setAutoChangeStyle(false);
        this.bfW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bfX = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.bfY = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.bfZ = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.bga = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.bgb = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.bgc = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.bgc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Kw();
            }
        });
        this.bgd = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.bgd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bgh = true;
                e.this.bfV.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bfR = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.bfR.setMode(true);
        this.bfR.b(String.valueOf(this.aDU.mLiveInfo.group_id), String.valueOf(this.aDU.mLiveInfo.live_id), false, this.aDU.aHD != null ? String.valueOf(this.aDU.aHD.userId) : null);
        this.bfS = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        h(this.aDU);
        Ku();
    }

    private void h(u uVar) {
        CustomResponsedMessage runTask;
        if (this.bfU == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.bfU = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.bfU != null) {
            this.bfU.k(uVar);
            this.bfU.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.bfU.a(1, null);
        }
    }

    private void Kt() {
        this.bfV.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.bfV.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bgl);
        MessageManager.getInstance().registerListener(this.bgj);
        MessageManager.getInstance().registerListener(this.bgk);
    }

    private void Ku() {
        PendantChildView Pk;
        CustomResponsedMessage runTask;
        if (com.baidu.live.x.a.OS().blo.DV()) {
            if (this.bfT == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.z.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.bfT = (com.baidu.live.z.b) runTask.getData();
            }
            if (this.bfT != null && (Pk = this.bfT.Pk()) != null && this.bfQ.indexOfChild(Pk) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.bfQ.addView(Pk, layoutParams);
            }
            Kv();
        }
    }

    private void J(JSONObject jSONObject) {
        if (this.bfT != null) {
            this.bfT.P(jSONObject);
        }
    }

    private void Kv() {
        if (this.bfT != null && this.bfT.Pk() != null && this.aDU != null) {
            this.bfT.k(this.aDU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.bgf) {
            TiebaInitialize.log("c12553");
        }
        this.bgf = !this.bgf;
        bS(this.bgf);
        bT(this.bgf);
        String valueOf = String.valueOf(this.aDU.aHD.userId);
        com.baidu.live.data.e eVar = new com.baidu.live.data.e(this.aDU.aHD.portrait, valueOf, "1", this.bgf, bfP);
        eVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.SY().a(valueOf, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        this.bgf = z;
        if (z) {
            this.bgc.setEnabled(false);
            this.bgc.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.bgc.setBackgroundDrawable(null);
            this.bgc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.bgc.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.bgc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.bgc.setCompoundDrawablePadding(0);
            return;
        }
        this.bgc.setEnabled(true);
        this.bgc.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.bgc.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.bgc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.bgc.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.bgc.setCompoundDrawablesWithIntrinsicBounds(this.bge, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bgc.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z) {
            TextView textView = this.bgb;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.bgg + 1;
            this.bgg = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bgb;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.bgg - 1;
        this.bgg = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bfR != null) {
            this.bfR.setMsgData(list);
            if (z) {
                this.bfR.KO();
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
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.bgi) {
            Kt();
        }
        this.bgi = false;
        this.bfR.setSelection(this.bfR.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.bfT != null) {
            this.bfT.onDestroy();
        }
        if (this.bgl != null) {
            MessageManager.getInstance().unRegisterListener(this.bgl);
        }
        MessageManager.getInstance().unRegisterListener(this.bgj);
        MessageManager.getInstance().unRegisterListener(this.bgk);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bfR != null) {
            this.bfR.Mc();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
