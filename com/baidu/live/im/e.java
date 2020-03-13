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
    private static final BdUniqueId arp = BdUniqueId.gen();
    private com.baidu.live.data.m ale;
    private TextView arA;
    private TextView arB;
    private TextView arC;
    private View arD;
    private Drawable arE;
    private boolean arF;
    private int arG;
    private boolean arI;
    private LinearLayout arq;
    private ALAImMsgListView arr;
    private ALAImEnterView ars;
    private com.baidu.live.x.b art;
    private com.baidu.live.liveroom.b.a aru;
    private View arv;
    private HeadImageView arw;
    private TextView arx;
    private ImageView ary;
    private ALALevelView arz;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean arH = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener arJ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener arK = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
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
    private CustomMessageListener arL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.ale.XQ.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.arp);
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
                            com.baidu.live.view.a.Bj().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.Bj().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.arF = !e.this.arF;
                            e.this.aR(e.this.arF);
                            e.this.aS(e.this.arF);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.arF = e.this.arF ? false : true;
                        e.this.aR(e.this.arF);
                        e.this.aS(e.this.arF);
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
                    this.ars.r(aVar);
                }
            } else if ("task".equals(str)) {
                u(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.m mVar) {
        this.mContext = context;
        this.ale = mVar;
        if (this.ale != null) {
            this.arE = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            vZ();
            initListener();
        }
    }

    private void vZ() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.arv = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.arv.setVisibility(4);
        this.arq = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.arw = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.arw.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arw.setIsRound(true);
        this.arw.setAutoChangeStyle(false);
        this.arw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.arx = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.ary = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.arz = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.arA = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.arB = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.arC = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.arC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.wd();
            }
        });
        this.arD = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.arD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.arH = true;
                e.this.arv.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.arr = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.arr.setMode(true);
        this.arr.a(String.valueOf(this.ale.mLiveInfo.group_id), String.valueOf(this.ale.mLiveInfo.live_id), false, this.ale.XQ != null ? String.valueOf(this.ale.XQ.userId) : null);
        this.ars = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        f(this.ale);
        wb();
    }

    private void f(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.aru == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.b.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.aru = (com.baidu.live.liveroom.b.a) runTask.getData();
        }
        if (this.aru != null) {
            this.aru.h(mVar);
            this.aru.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.aru.a(1, this.arq, layoutParams);
        }
    }

    private void wa() {
        this.arv.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0102a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.arv.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.arL);
        MessageManager.getInstance().registerListener(this.arJ);
        MessageManager.getInstance().registerListener(this.arK);
    }

    private void wb() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.zl().awC.qy()) {
            if (this.art == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.x.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.art = (com.baidu.live.x.b) runTask.getData();
            }
            if (this.art != null && (view = this.art.getView()) != null && this.arq.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.arq.addView(view, layoutParams);
            }
            wc();
        }
    }

    private void u(JSONObject jSONObject) {
        if (this.art != null) {
            this.art.v(jSONObject);
        }
    }

    private void wc() {
        if (this.art != null && this.art.getView() != null && this.ale != null && this.ale.Yn != null) {
            this.art.a(this.ale.Yn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.arF) {
            TiebaInitialize.log("c12553");
        }
        this.arF = !this.arF;
        aR(this.arF);
        aS(this.arF);
        String valueOf = String.valueOf(this.ale.XQ.userId);
        com.baidu.live.view.a.Bj().a(valueOf, new com.baidu.live.data.b(this.ale.XQ.portrait, valueOf, "1", this.arF, arp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        this.arF = z;
        if (z) {
            this.arC.setEnabled(false);
            this.arC.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.arC.setBackgroundDrawable(null);
            this.arC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.arC.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.arC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.arC.setCompoundDrawablePadding(0);
            return;
        }
        this.arC.setEnabled(true);
        this.arC.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.arC.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.arC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.arC.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.arC.setCompoundDrawablesWithIntrinsicBounds(this.arE, (Drawable) null, (Drawable) null, (Drawable) null);
        this.arC.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z) {
            TextView textView = this.arB;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.arG + 1;
            this.arG = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.arB;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.arG - 1;
        this.arG = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.arr != null) {
            this.arr.setMsgData(list);
            if (z) {
                this.arr.wp();
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
        if (this.arI) {
            wa();
        }
        this.arI = false;
        this.arr.setSelection(this.arr.getBottom());
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.art != null) {
            this.art.onDestroy();
        }
        if (this.arL != null) {
            MessageManager.getInstance().unRegisterListener(this.arL);
        }
        MessageManager.getInstance().unRegisterListener(this.arJ);
        MessageManager.getInstance().unRegisterListener(this.arK);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.arr != null) {
            this.arr.xL();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
