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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class e implements com.baidu.live.liveroom.c.d {
    private static final BdUniqueId anW = BdUniqueId.gen();
    private com.baidu.live.data.l aiW;
    private LinearLayout anX;
    private ALAImMsgListView anY;
    private ALAImEnterView anZ;
    private com.baidu.live.u.b aoa;
    private com.baidu.live.liveroom.a.a aob;
    private View aoc;
    private HeadImageView aod;
    private TextView aoe;
    private ImageView aof;
    private ALALevelView aog;
    private TextView aoh;
    private TextView aoi;
    private TextView aoj;
    private View aok;
    private Drawable aol;
    private boolean aom;
    private int aon;
    private boolean aop;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean aoo = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener aoq = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener aor = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.vq() instanceof com.baidu.live.data.a)) {
                    aVar.vq().VE = -1;
                }
                e.this.g(aVar);
            }
        }
    };
    private CustomMessageListener aos = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aiW.Wf.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.anW);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.aO(z);
                            e.this.aP(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.yR().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.aom = !e.this.aom;
                            e.this.aO(e.this.aom);
                            e.this.aP(e.this.aom);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.aom = e.this.aom ? false : true;
                        e.this.aO(e.this.aom);
                        e.this.aP(e.this.aom);
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
                if (com.baidu.live.entereffect.a.qg().a(aVar)) {
                    this.anZ.k(aVar);
                }
            } else if ("task".equals(str)) {
                u(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.l lVar) {
        this.mContext = context;
        this.aiW = lVar;
        if (this.aiW != null) {
            this.aol = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            uv();
            initListener();
        }
    }

    private void uv() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aoc = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aoc.setVisibility(4);
        this.anX = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.aod = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.aod.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aod.setIsRound(true);
        this.aod.setAutoChangeStyle(false);
        this.aod.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aoe = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.aof = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.aog = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.aoh = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aoi = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.aoj = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.aoj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.uz();
            }
        });
        this.aok = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.aok.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aoo = true;
                e.this.aoc.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.anY = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.anY.setMode(true);
        this.anY.a(String.valueOf(this.aiW.mLiveInfo.group_id), String.valueOf(this.aiW.mLiveInfo.live_id), false, this.aiW.Wf != null ? String.valueOf(this.aiW.Wf.userId) : null);
        this.anZ = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        e(this.aiW);
        ux();
    }

    private void e(com.baidu.live.data.l lVar) {
        CustomResponsedMessage runTask;
        if (this.aob == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.a.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aob = (com.baidu.live.liveroom.a.a) runTask.getData();
        }
        if (this.aob != null) {
            this.aob.g(lVar);
            this.aob.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aob.a(1, this.anX, layoutParams);
        }
    }

    private void uw() {
        this.aoc.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0086a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aoc.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aos);
        MessageManager.getInstance().registerListener(this.aoq);
        MessageManager.getInstance().registerListener(this.aor);
    }

    private void ux() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.s.a.wR().asq.pN()) {
            if (this.aoa == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.u.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.aoa = (com.baidu.live.u.b) runTask.getData();
            }
            if (this.aoa != null && (view = this.aoa.getView()) != null && this.anX.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.anX.addView(view, layoutParams);
            }
            uy();
        }
    }

    private void u(JSONObject jSONObject) {
        if (this.aoa != null) {
            this.aoa.v(jSONObject);
        }
    }

    private void uy() {
        if (this.aoa != null && this.aoa.getView() != null && this.aiW != null && this.aiW.WB != null) {
            this.aoa.a(this.aiW.WB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.aom) {
            TiebaInitialize.log("c12553");
        }
        this.aom = !this.aom;
        aO(this.aom);
        aP(this.aom);
        String valueOf = String.valueOf(this.aiW.Wf.userId);
        com.baidu.live.view.a.yR().a(valueOf, new com.baidu.live.data.b(this.aiW.Wf.portrait, valueOf, "1", this.aom, anW));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(boolean z) {
        this.aom = z;
        if (z) {
            this.aoj.setEnabled(false);
            this.aoj.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.aoj.setBackgroundDrawable(null);
            this.aoj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.aoj.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.aoj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.aoj.setCompoundDrawablePadding(0);
            return;
        }
        this.aoj.setEnabled(true);
        this.aoj.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.aoj.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.aoj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.aoj.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.aoj.setCompoundDrawablesWithIntrinsicBounds(this.aol, (Drawable) null, (Drawable) null, (Drawable) null);
        this.aoj.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (z) {
            TextView textView = this.aoi;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.aon + 1;
            this.aon = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aoi;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.aon - 1;
        this.aon = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.anY != null) {
            this.anY.setMsgData(list);
            if (z) {
                this.anY.uL();
            }
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.aop) {
            uw();
        }
        this.aop = false;
        this.anY.setSelection(this.anY.getBottom());
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.aoa != null) {
            this.aoa.onDestroy();
        }
        if (this.aos != null) {
            MessageManager.getInstance().unRegisterListener(this.aos);
        }
        MessageManager.getInstance().unRegisterListener(this.aoq);
        MessageManager.getInstance().unRegisterListener(this.aor);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.anY != null) {
            this.anY.vM();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
