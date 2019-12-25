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
import com.baidu.live.q.a;
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
    private static final BdUniqueId anj = BdUniqueId.gen();
    private com.baidu.live.data.k aio;
    private int anA;
    private boolean anC;
    private LinearLayout ank;
    private ALAImMsgListView anl;
    private ALAImEnterView anm;
    private com.baidu.live.s.b ann;
    private com.baidu.live.liveroom.a.a ano;
    private View anp;
    private HeadImageView anq;
    private TextView anr;
    private ImageView ans;
    private ALALevelView ant;
    private TextView anu;
    private TextView anv;
    private TextView anw;
    private View anx;
    private Drawable any;
    private boolean anz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean anB = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener anD = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.d((List<com.baidu.live.im.data.a>) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener anE = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.uZ() instanceof com.baidu.live.data.a)) {
                    aVar.uZ().Vo = -1;
                }
                e.this.g(aVar);
            }
        }
    };
    private CustomMessageListener anF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aio.VP.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.anj);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.aM(z);
                            e.this.aN(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.yy().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.yy().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.anz = !e.this.anz;
                            e.this.aM(e.this.anz);
                            e.this.aN(e.this.anz);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.anz = e.this.anz ? false : true;
                        e.this.aM(e.this.anz);
                        e.this.aN(e.this.anz);
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
                if (com.baidu.live.entereffect.a.pZ().a(aVar)) {
                    this.anm.k(aVar);
                }
            } else if ("task".equals(str)) {
                u(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.k kVar) {
        this.mContext = context;
        this.aio = kVar;
        if (this.aio != null) {
            this.any = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            ue();
            initListener();
        }
    }

    private void ue() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.anp = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.anp.setVisibility(4);
        this.ank = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.anq = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.anq.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.anq.setIsRound(true);
        this.anq.setAutoChangeStyle(false);
        this.anq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.anr = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.ans = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.ant = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.anu = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.anv = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.anw = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.anw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.ui();
            }
        });
        this.anx = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.anx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.anB = true;
                e.this.anp.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.anl = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.anl.setMode(true);
        this.anl.a(String.valueOf(this.aio.mLiveInfo.group_id), String.valueOf(this.aio.mLiveInfo.live_id), false, this.aio.VP != null ? String.valueOf(this.aio.VP.userId) : null);
        this.anm = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        e(this.aio);
        ug();
    }

    private void e(com.baidu.live.data.k kVar) {
        CustomResponsedMessage runTask;
        if (this.ano == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.a.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.ano = (com.baidu.live.liveroom.a.a) runTask.getData();
        }
        if (this.ano != null) {
            this.ano.g(kVar);
            this.ano.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.ano.a(1, this.ank, layoutParams);
        }
    }

    private void uf() {
        this.anp.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0086a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.anp.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.anF);
        MessageManager.getInstance().registerListener(this.anD);
        MessageManager.getInstance().registerListener(this.anE);
    }

    private void ug() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.r.a.wA().arE.pJ()) {
            if (this.ann == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.s.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.ann = (com.baidu.live.s.b) runTask.getData();
            }
            if (this.ann != null && (view = this.ann.getView()) != null && this.ank.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.ank.addView(view, layoutParams);
            }
            uh();
        }
    }

    private void u(JSONObject jSONObject) {
        if (this.ann != null) {
            this.ann.v(jSONObject);
        }
    }

    private void uh() {
        if (this.ann != null && this.ann.getView() != null && this.aio != null && this.aio.Wk != null) {
            this.ann.a(this.aio.Wk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.anz) {
            TiebaInitialize.log("c12553");
        }
        this.anz = !this.anz;
        aM(this.anz);
        aN(this.anz);
        String valueOf = String.valueOf(this.aio.VP.userId);
        com.baidu.live.view.a.yy().a(valueOf, new com.baidu.live.data.b(this.aio.VP.portrait, valueOf, "1", this.anz, anj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(boolean z) {
        this.anz = z;
        if (z) {
            this.anw.setEnabled(false);
            this.anw.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.anw.setBackgroundDrawable(null);
            this.anw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.anw.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.anw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.anw.setCompoundDrawablePadding(0);
            return;
        }
        this.anw.setEnabled(true);
        this.anw.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.anw.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.anw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.anw.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.anw.setCompoundDrawablesWithIntrinsicBounds(this.any, (Drawable) null, (Drawable) null, (Drawable) null);
        this.anw.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        if (z) {
            TextView textView = this.anv;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.anA + 1;
            this.anA = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.anv;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.anA - 1;
        this.anA = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.anl != null) {
            this.anl.setMsgData(list);
            if (z) {
                this.anl.uu();
            }
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.anC) {
            uf();
        }
        this.anC = false;
        this.anl.setSelection(this.anl.getBottom());
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.ann != null) {
            this.ann.onDestroy();
        }
        if (this.anF != null) {
            MessageManager.getInstance().unRegisterListener(this.anF);
        }
        MessageManager.getInstance().unRegisterListener(this.anD);
        MessageManager.getInstance().unRegisterListener(this.anE);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.anl != null) {
            this.anl.vv();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
