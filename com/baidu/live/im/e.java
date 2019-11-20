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
    private static final BdUniqueId afh = BdUniqueId.gen();
    private com.baidu.live.data.i aaj;
    private boolean afA;
    private LinearLayout afi;
    private ALAImMsgListView afj;
    private ALAImEnterView afk;
    private com.baidu.live.m.b afl;
    private com.baidu.live.liveroom.a.a afm;
    private View afn;
    private HeadImageView afo;
    private TextView afp;
    private ImageView afq;
    private ALALevelView afr;
    private TextView afs;
    private TextView aft;
    private TextView afu;
    private View afv;
    private Drawable afw;
    private boolean afx;
    private int afy;
    private Context mContext;
    private RelativeLayout mRootView;
    private long mUserId = -1;
    private boolean afz = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener afB = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                e.this.e((List) customResponsedMessage.getData(), true);
            }
        }
    };
    private CustomMessageListener afC = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (aVar != null && (aVar.tf() instanceof com.baidu.live.data.a)) {
                    aVar.tf().Oo = -1;
                }
                e.this.g(aVar);
            }
        }
    };
    private CustomMessageListener afD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.im.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && updateAttentionMessage.getData().toUid.equals(String.valueOf(e.this.aaj.OR.userId)) && updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() != null) {
                    boolean equals = updateAttentionMessage.getOrginalMessage().getTag().equals(e.afh);
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
                            com.baidu.live.view.a.wy().a((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), true);
                            return;
                        }
                    }
                    boolean z2 = updateAttentionMessage.getData().isAttention;
                    if (equals) {
                        if (com.baidu.live.view.a.wy().a(updateAttentionMessage.getData(), (TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext), false)) {
                            e.this.afx = !e.this.afx;
                            e.this.av(e.this.afx);
                            e.this.aw(e.this.afx);
                            return;
                        }
                        if (!StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                            ((TbPageContext) IScrollableHelper.getBbPageContext(e.this.mContext)).showToast(updateAttentionMessage.getData().errorString);
                        }
                        e.this.afx = e.this.afx ? false : true;
                        e.this.av(e.this.afx);
                        e.this.aw(e.this.afx);
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
                if (com.baidu.live.entereffect.a.oF().a(aVar)) {
                    this.afk.k(aVar);
                }
            } else if ("task".equals(str)) {
                y(jSONObject);
            }
        }
    }

    public e(Context context, com.baidu.live.data.i iVar) {
        this.mContext = context;
        this.aaj = iVar;
        if (this.aaj != null) {
            this.afw = this.mContext.getResources().getDrawable(a.f.icon_live_follow_plus_white);
            sn();
            initListener();
        }
    }

    private void sn() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.ala_live_room_chat_tab_layout, (ViewGroup) null);
        this.afn = this.mRootView.findViewById(a.g.ala_liveroom_chat_top_op_layout);
        this.afn.setVisibility(4);
        this.afi = (LinearLayout) this.mRootView.findViewById(a.g.ala_liveroom_chat_right_layout);
        this.afo = (HeadImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_icon);
        this.afo.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.afo.setIsRound(true);
        this.afo.setAutoChangeStyle(false);
        this.afo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.afp = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_name);
        this.afq = (ImageView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_sex);
        this.afr = (ALALevelView) this.mRootView.findViewById(a.g.ala_liveroom_chat_level);
        this.afs = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_attention_count);
        this.aft = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_user_fans_count);
        this.afu = (TextView) this.mRootView.findViewById(a.g.ala_liveroom_chat_follow_btn);
        this.afu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.sr();
            }
        });
        this.afv = this.mRootView.findViewById(a.g.ala_liveroom_chat_close_layout);
        this.afv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.afz = true;
                e.this.afn.setVisibility(8);
                TiebaInitialize.log("c12554");
            }
        });
        this.afj = (ALAImMsgListView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_listview);
        this.afj.setMode(true);
        this.afj.a(String.valueOf(this.aaj.mLiveInfo.group_id), String.valueOf(this.aaj.mLiveInfo.live_id), false, this.aaj.OR != null ? String.valueOf(this.aaj.OR.userId) : null);
        this.afk = (ALAImEnterView) this.mRootView.findViewById(a.g.ala_liveroom_chat_im_enterview);
        e(this.aaj);
        sp();
    }

    private void e(com.baidu.live.data.i iVar) {
        CustomResponsedMessage runTask;
        if (this.afm == null && (runTask = MessageManager.getInstance().runTask(2913053, com.baidu.live.liveroom.a.a.class, (TbPageContext) IScrollableHelper.getBbPageContext(this.mContext))) != null) {
            this.afm = (com.baidu.live.liveroom.a.a) runTask.getData();
        }
        if (this.afm != null) {
            this.afm.g(iVar);
            this.afm.setHost(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.gravity = 1;
            this.afm.a(1, this.afi, layoutParams);
        }
    }

    private void so() {
        this.afn.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0068a.sdk_push_top_in);
        loadAnimation.setDuration(300L);
        this.afn.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.afD);
        MessageManager.getInstance().registerListener(this.afB);
        MessageManager.getInstance().registerListener(this.afC);
    }

    private void sp() {
        View view;
        CustomResponsedMessage runTask;
        if (com.baidu.live.l.a.uB().ajF.oo()) {
            if (this.afl == null && (runTask = MessageManager.getInstance().runTask(2913034, com.baidu.live.m.b.class, this.mContext)) != null && runTask.getData() != null) {
                this.afl = (com.baidu.live.m.b) runTask.getData();
            }
            if (this.afl != null && (view = this.afl.getView()) != null && this.afi.indexOfChild(view) < 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.afi.addView(view, layoutParams);
            }
            sq();
        }
    }

    private void y(JSONObject jSONObject) {
        if (this.afl != null) {
            this.afl.z(jSONObject);
        }
    }

    private void sq() {
        if (this.afl != null && this.afl.getView() != null && this.aaj != null && this.aaj.Pp != null) {
            this.afl.a(this.aaj.Pp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
            return;
        }
        if (!this.afx) {
            TiebaInitialize.log("c12553");
        }
        this.afx = !this.afx;
        av(this.afx);
        aw(this.afx);
        String valueOf = String.valueOf(this.aaj.OR.userId);
        com.baidu.live.view.a.wy().a(valueOf, new com.baidu.live.data.b(this.aaj.OR.portrait, valueOf, "1", this.afx, afh));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z) {
        this.afx = z;
        if (z) {
            this.afu.setEnabled(false);
            this.afu.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize24));
            this.afu.setBackgroundDrawable(null);
            this.afu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
            this.afu.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_followed_tip));
            this.afu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.afu.setCompoundDrawablePadding(0);
            return;
        }
        this.afu.setEnabled(true);
        this.afu.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_fontsize26));
        this.afu.setBackgroundResource(a.f.ala_live_chat_tab_follow_btn_bg);
        this.afu.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        this.afu.setText(this.mContext.getResources().getText(a.i.ala_chat_tab_unfollow_tip));
        this.afu.setCompoundDrawablesWithIntrinsicBounds(this.afw, (Drawable) null, (Drawable) null, (Drawable) null);
        this.afu.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z) {
        if (z) {
            TextView textView = this.aft;
            Resources resources = this.mContext.getResources();
            int i = a.i.ala_chat_tab_fans_count;
            int i2 = this.afy + 1;
            this.afy = i2;
            textView.setText(resources.getString(i, StringHelper.numberUniformFormat(i2)));
            return;
        }
        TextView textView2 = this.aft;
        Resources resources2 = this.mContext.getResources();
        int i3 = a.i.ala_chat_tab_fans_count;
        int i4 = this.afy - 1;
        this.afy = i4;
        textView2.setText(resources2.getString(i3, StringHelper.numberUniformFormat(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.afj != null) {
            this.afj.setMsgData(list);
            if (z) {
                this.afj.sD();
            }
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mContext.getResources().getString(a.i.ala_chat_tab_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
        return (short) 1;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.afA) {
            so();
        }
        this.afA = false;
        this.afj.setSelection(this.afj.getBottom());
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.afl != null) {
            this.afl.onDestroy();
        }
        if (this.afD != null) {
            MessageManager.getInstance().unRegisterListener(this.afD);
        }
        MessageManager.getInstance().unRegisterListener(this.afB);
        MessageManager.getInstance().unRegisterListener(this.afC);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.afj != null) {
            this.afj.tB();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
