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
    private static final BdUniqueId blb = BdUniqueId.gen();
    private w aFN;
    private LinearLayout blc;
    private ALAImMsgListView bld;
    private ALAImEnterView ble;
    private com.baidu.live.ah.b blf;
    private com.baidu.live.liveroom.b.a blg;
    private View blh;
    private HeadImageView bli;
    private TextView blj;
    private ImageView blk;
    private ALALevelView bll;
    private TextView blm;
    private TextView bln;
    private TextView blo;
    private View blp;
    private Drawable blq;
    private boolean blr;
    private int bls;
    private boolean blu;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean blt = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener blv = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener blw = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (bVar != null && (bVar.NU() instanceof com.baidu.live.data.a)) {
                    bVar.NU().aIC = -1;
                }
                e.this.t(bVar);
            }
        }
    };
    private CustomMessageListener blx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aFN.aJV.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.blb);
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
                            com.baidu.live.view.a.Yo().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)), false)) {
                            e.this.blr = !e.this.blr;
                            e.this.cg(e.this.blr);
                            e.this.ch(e.this.blr);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.blr = e.this.blr ? false : true;
                        e.this.cg(e.this.blr);
                        e.this.ch(e.this.blr);
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
                if (com.baidu.live.entereffect.a.Gi().h(bVar)) {
                    this.ble.y(bVar);
                }
            } else if ("task".equals(str)) {
                J(jSONObject);
            }
        }
    }

    public e(Context context, w wVar) {
        this.mContext = context;
        this.aFN = wVar;
        if (this.aFN != null) {
            this.blq = this.mContext.getResources().getDrawable(a.e.icon_live_follow_plus_white);
            MF();
            initListener();
        }
    }

    private void MF() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.blh = this.mRootView.findViewById(a.f.ala_liveroom_chat_top_op_layout);
        this.blh.setVisibility(4);
        this.blc = (LinearLayout) this.mRootView.findViewById(a.f.ala_liveroom_chat_right_layout);
        this.bli = (HeadImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_icon);
        this.bli.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bli.setIsRound(true);
        this.bli.setAutoChangeStyle(false);
        this.bli.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.blj = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_name);
        this.blk = (ImageView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_sex);
        this.bll = (ALALevelView) this.mRootView.findViewById(a.f.ala_liveroom_chat_level);
        this.blm = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_attention_count);
        this.bln = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_user_fans_count);
        this.blo = (TextView) this.mRootView.findViewById(a.f.ala_liveroom_chat_follow_btn);
        this.blo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.MJ();
            }
        });
        this.blp = this.mRootView.findViewById(a.f.ala_liveroom_chat_close_layout);
        this.blp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.blt = true;
                e.this.blh.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.bld = (ALAImMsgListView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_listview);
        this.bld.setMode(true);
        this.bld.a(String.valueOf(this.aFN.mLiveInfo.group_id), String.valueOf(this.aFN.mLiveInfo.live_id), false, this.aFN.aJV != null ? String.valueOf(this.aFN.aJV.userId) : null, this.aFN.getGuardName());
        this.ble = (ALAImEnterView) this.mRootView.findViewById(a.f.ala_liveroom_chat_im_enterview);
        f(this.aFN);
        MH();
    }

    private void f(w wVar) {
        CustomResponsedMessage runTask;
        if (this.blg == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.blg = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.blg != null) {
            this.blg.i(wVar);
            this.blg.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.gravity = 1;
            this.blg.a(1, null);
        }
    }

    private void MG() {
        this.blh.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0205a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.blh.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.blx);
        MessageManager.getInstance().registerListener(this.blv);
        MessageManager.getInstance().registerListener(this.blw);
    }

    private void MH() {
        PendantChildView UC;
        CustomResponsedMessage runTask;
        if (com.baidu.live.ae.a.RB().brA.FC()) {
            if (this.blf == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.ah.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.blf = (com.baidu.live.ah.b) runTask.getData();
            }
            if (this.blf != null && (UC = this.blf.UC()) != null && this.blc.indexOfChild(UC) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.blc.addView(UC, layoutParams);
            }
            MI();
        }
    }

    private void J(JSONObject jSONObject) {
        if (this.blf != null) {
            this.blf.R(jSONObject);
        }
    }

    private void MI() {
        if (this.blf != null && this.blf.UC() != null && this.aFN != null) {
            this.blf.i(this.aFN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.blr) {
            TiebaInitialize.log("c12553");
        }
        this.blr = !this.blr;
        cg(this.blr);
        ch(this.blr);
        String valueOf = String.valueOf(this.aFN.aJV.userId);
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.aFN.aJV.portrait, valueOf, "1", this.blr, blb);
        fVar.setFrom("source_chat_tab");
        com.baidu.live.view.a.Yo().a(valueOf, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        this.blr = z;
        if (z) {
            this.blo.setEnabled(false);
            this.blo.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize24));
            this.blo.setBackgroundDrawable(null);
            this.blo.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
            this.blo.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_followed_tip));
            this.blo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.blo.setCompoundDrawablePadding(0);
            return;
        }
        this.blo.setEnabled(true);
        this.blo.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.d.sdk_fontsize26));
        this.blo.setBackgroundResource(a.e.ala_live_chat_tab_follow_btn_bg);
        this.blo.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        this.blo.setText(this.mContext.getResources().getText(a.h.ala_chat_tab_unfollow_tip));
        this.blo.setCompoundDrawablesWithIntrinsicBounds(this.blq, (Drawable) null, (Drawable) null, (Drawable) null);
        this.blo.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (z) {
            TextView textView = this.bln;
            Resources resources = this.mContext.getResources();
            int i = a.h.ala_chat_tab_fans_count;
            int i2 = this.bls + 1;
            this.bls = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.bln;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.h.ala_chat_tab_fans_count;
        int i4 = this.bls - 1;
        this.bls = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bld != null) {
            this.bld.setMsgData(list);
            if (z) {
                this.bld.Nc();
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
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.blu) {
            MG();
        }
        this.blu = false;
        this.bld.setSelection(this.bld.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.blf != null) {
            this.blf.onDestroy();
        }
        if (this.blx != null) {
            MessageManager.getInstance().unRegisterListener(this.blx);
        }
        MessageManager.getInstance().unRegisterListener(this.blv);
        MessageManager.getInstance().unRegisterListener(this.blw);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.bld != null) {
            if (this.bld.getAdapterManager() != null) {
                MessageManager.getInstance().unRegisterListener(this.bld.getAdapterManager().Nu().bon);
            }
            this.bld.OI();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
