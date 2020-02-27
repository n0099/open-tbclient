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
    private static final BdUniqueId aro = BdUniqueId.gen();
    private com.baidu.live.data.m ald;
    private TextView arA;
    private TextView arB;
    private View arC;
    private Drawable arD;
    private boolean arE;
    private int arF;
    private boolean arH;
    private LinearLayout arp;
    private ALAImMsgListView arq;
    private ALAImEnterView arr;
    private com.baidu.live.x.b ars;
    private com.baidu.live.liveroom.b.a art;
    private View aru;
    private HeadImageView arv;
    private TextView arw;
    private ImageView arx;
    private ALALevelView ary;
    private TextView arz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean arG = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener arI = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener arJ = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.xo() instanceof com.baidu.live.data.a)) {
                    aVar.xo().Xk = -1;
                }
                e.this.g(aVar);
            }
        }
    };
    private CustomMessageListener arK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.ald.XQ.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.aro);
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
                            com.baidu.live.view.a.Bh().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Bh().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.arE = !e.this.arE;
                            e.this.aR(e.this.arE);
                            e.this.aS(e.this.arE);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.arE = e.this.arE ? false : true;
                        e.this.aR(e.this.arE);
                        e.this.aS(e.this.arE);
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
                if (com.baidu.live.entereffect.a.qR().a(aVar)) {
                    this.arr.r(aVar);
                }
            } else if ("task".equals(str)) {
                u(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.m mVar) {
        this.mContext = context;
        this.ald = mVar;
        if (this.ald != null) {
            this.arD = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            vZ();
            initListener();
        }
    }

    private void vZ() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.aru = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.aru.setVisibility(4);
        this.arp = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.arv = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.arv.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arv.setIsRound(true);
        this.arv.setAutoChangeStyle(false);
        this.arv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.arw = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.arx = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.ary = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.arz = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.arA = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.arB = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.arB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.wd();
            }
        });
        this.arC = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.arC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.arG = true;
                e.this.aru.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.arq = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.arq.setMode(true);
        this.arq.a(String.valueOf(this.ald.mLiveInfo.group_id), String.valueOf(this.ald.mLiveInfo.live_id), false, this.ald.XQ != null ? String.valueOf(this.ald.XQ.userId) : null);
        this.arr = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.ald);
        wb();
    }

    private void f(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.art == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.art = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.art != null) {
            this.art.h(mVar);
            this.art.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.art.a(1, this.arp, layoutParams);
        }
    }

    private void wa() {
        this.aru.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0102a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.aru.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.arK);
        MessageManager.getInstance().registerListener(this.arI);
        MessageManager.getInstance().registerListener(this.arJ);
    }

    private void wb() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.zj().awA.qy()) {
            if (this.ars == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.ars = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.ars != null && (view = this.ars.getView()) != null && this.arp.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.arp.addView(view, layoutParams);
            }
            wc();
        }
    }

    private void u(JSONObject jSONObject) {
        if (this.ars != null) {
            this.ars.v(jSONObject);
        }
    }

    private void wc() {
        if (this.ars != null && this.ars.getView() != null && this.ald != null && this.ald.Yn != null) {
            this.ars.a(this.ald.Yn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.arE) {
            TiebaInitialize.log("c12553");
        }
        this.arE = !this.arE;
        aR(this.arE);
        aS(this.arE);
        String valueOf = String.valueOf(this.ald.XQ.userId);
        com.baidu.live.view.a.Bh().a(valueOf, new com.baidu.live.data.b(this.ald.XQ.portrait, valueOf, "1", this.arE, aro));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arE = z;
        if (z) {
            this.arB.setEnabled(false);
            this.arB.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.arB.setBackgroundDrawable(null);
            this.arB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.arB.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.arB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.arB.setCompoundDrawablePadding(0);
            return;
        }
        this.arB.setEnabled(true);
        this.arB.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.arB.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.arB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.arB.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.arB.setCompoundDrawablesWithIntrinsicBounds(this.arD, (Drawable) null, (Drawable) null, (Drawable) null);
        this.arB.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.arA;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.arF + 1;
            this.arF = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.arA;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.arF - 1;
        this.arF = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.arq != null) {
            this.arq.setMsgData(list);
            if (z) {
                this.arq.wp();
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.arH) {
            wa();
        }
        this.arH = false;
        this.arq.setSelection(this.arq.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ars != null) {
            this.ars.onDestroy();
        }
        if (this.arK != null) {
            MessageManager.getInstance().unRegisterListener(this.arK);
        }
        MessageManager.getInstance().unRegisterListener(this.arI);
        MessageManager.getInstance().unRegisterListener(this.arJ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.arq != null) {
            this.arq.xL();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
