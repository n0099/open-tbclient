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
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class e implements com.baidu.live.liveroom.c.d {
    private static final BdUniqueId afz = BdUniqueId.gen();
    private com.baidu.live.data.i aaB;
    private LinearLayout afA;
    private ALAImMsgListView afB;
    private ALAImEnterView afC;
    private com.baidu.live.m.b afD;
    private com.baidu.live.liveroom.a.a afE;
    private View afF;
    private HeadImageView afG;
    private TextView afH;
    private ImageView afI;
    private ALALevelView afJ;
    private TextView afK;
    private TextView afL;
    private TextView afM;
    private View afN;
    private Drawable afO;
    private boolean afP;
    private int afQ;
    private boolean afS;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean afR = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener afT = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener afU = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.te() instanceof com.baidu.live.data.a)) {
                    aVar.te().OQ = -1;
                }
                e.this.f(aVar);
            }
        }
    };
    private CustomMessageListener afV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aaB.Ps.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.afz);
                    if (updateAttentionMessage.getData().isSucc) {
                        boolean z = updateAttentionMessage.getData().isAttention;
                        if (!equals) {
                            e.this.av(z);
                            e.this.aw(z);
                            return;
                        } else if (!z) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(a.i.sdk_unfollow_success_toast);
                            return;
                        } else {
                            com.baidu.live.view.a.wx().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.wx().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.afP = !e.this.afP;
                            e.this.av(e.this.afP);
                            e.this.aw(e.this.afP);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.afP = e.this.afP ? false : true;
                        e.this.av(e.this.afP);
                        e.this.aw(e.this.afP);
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.im.data.a aVar) {
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
                if (com.baidu.live.entereffect.a.oF().a(aVar)) {
                    this.afC.j(aVar);
                }
            } else if ("task".equals(str)) {
                x(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.i iVar) {
        this.mContext = context;
        this.aaB = iVar;
        if (this.aaB != null) {
            this.afO = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            sm();
            initListener();
        }
    }

    private void sm() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.afF = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.afF.setVisibility(4);
        this.afA = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.afG = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.afG.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.afG.setIsRound(true);
        this.afG.setAutoChangeStyle(false);
        this.afG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.afH = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.afI = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.afJ = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.afK = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.afL = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.afM = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.afM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.sq();
            }
        });
        this.afN = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.afN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.afR = true;
                e.this.afF.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.afB = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.afB.setMode(true);
        this.afB.a(String.valueOf(this.aaB.mLiveInfo.group_id), String.valueOf(this.aaB.mLiveInfo.live_id), false, this.aaB.Ps != null ? String.valueOf(this.aaB.Ps.userId) : null);
        this.afC = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        e(this.aaB);
        so();
    }

    private void e(com.baidu.live.data.i iVar) {
        CustomResponsedMessage runTask;
        if (this.afE == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.a.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.afE = (com.baidu.live.liveroom.a.a) runTask.getData();
        }
        if (this.afE != null) {
            this.afE.g(iVar);
            this.afE.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.afE.a(1, this.afA, layoutParams);
        }
    }

    private void sn() {
        this.afF.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0068a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.afF.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.afV);
        MessageManager.getInstance().registerListener(this.afT);
        MessageManager.getInstance().registerListener(this.afU);
    }

    private void so() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.l.a.uA().ajX.oo()) {
            if (this.afD == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.m.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.afD = (com.baidu.live.m.b) runTask.getData();
            }
            if (this.afD != null && (view = this.afD.getView()) != null && this.afA.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.afA.addView(view, layoutParams);
            }
            sp();
        }
    }

    private void x(JSONObject jSONObject) {
        if (this.afD != null) {
            this.afD.y(jSONObject);
        }
    }

    private void sp() {
        if (this.afD != null && this.afD.getView() != null && this.aaB != null && this.aaB.PU != null) {
            this.afD.a(this.aaB.PU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.afP) {
            TiebaInitialize.log("c12553");
        }
        this.afP = !this.afP;
        av(this.afP);
        aw(this.afP);
        String valueOf = String.valueOf(this.aaB.Ps.userId);
        com.baidu.live.view.a.wx().a(valueOf, new com.baidu.live.data.b(this.aaB.Ps.portrait, valueOf, "1", this.afP, afz));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z) {
        this.afP = z;
        if (z) {
            this.afM.setEnabled(false);
            this.afM.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.afM.setBackgroundDrawable(null);
            this.afM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.afM.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.afM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.afM.setCompoundDrawablePadding(0);
            return;
        }
        this.afM.setEnabled(true);
        this.afM.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.afM.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.afM.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.afM.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.afM.setCompoundDrawablesWithIntrinsicBounds(this.afO, (Drawable) null, (Drawable) null, (Drawable) null);
        this.afM.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z) {
        if (z) {
            TextView textView = this.afL;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.afQ + 1;
            this.afQ = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.afL;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.afQ - 1;
        this.afQ = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.afB != null) {
            this.afB.setMsgData(list);
            if (z) {
                this.afB.sC();
            }
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.afS) {
            sn();
        }
        this.afS = false;
        this.afB.setSelection(this.afB.getBottom());
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.afD != null) {
            this.afD.onDestroy();
        }
        if (this.afV != null) {
            MessageManager.getInstance().unRegisterListener(this.afV);
        }
        MessageManager.getInstance().unRegisterListener(this.afT);
        MessageManager.getInstance().unRegisterListener(this.afU);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.afB != null) {
            this.afB.tA();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
