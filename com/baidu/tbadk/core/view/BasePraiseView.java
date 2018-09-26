package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public abstract class BasePraiseView<T> extends LinearLayout {
    protected int agreeType;
    protected long alZ;
    protected long ama;
    protected View.OnClickListener avZ;
    protected int awp;
    protected int awq;
    public int awr;
    public int aws;
    public int awt;
    public int awu;
    public int awv;
    protected TextView aww;
    protected ImageView awx;
    protected ScaleAnimation awy;
    protected T mData;
    protected String mForumId;
    protected int mFrom;
    protected TbPageContext mPageContext;
    protected String mPostId;
    private int mSkinType;
    protected String mThreadId;

    public abstract void Bp();

    public abstract long getNum();

    public BasePraiseView(Context context) {
        this(context, null);
    }

    public BasePraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.agreeType = 2;
        this.awp = 3;
        this.awq = 1;
        this.mFrom = 2;
        this.awr = e.j.action_praise_default;
        this.aws = e.f.icon_card_like_n;
        this.awt = e.f.icon_card_like_s;
        this.awu = e.d.cp_cont_j;
        this.awv = e.d.cp_cont_h;
        this.mThreadId = "";
        this.mForumId = "";
        this.mPostId = "";
        setOrientation(0);
        setGravity(17);
        bB(context);
        Bq();
    }

    protected void bB(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view, this);
            this.aww = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.awx = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bq() {
        this.agreeType = 2;
        this.awr = e.j.action_praise_default;
        this.awu = e.d.cp_cont_j;
        this.awv = e.d.cp_cont_h;
        this.aws = e.f.icon_card_like_n;
        this.awt = e.f.icon_card_like_s;
    }

    public StateListDrawable createStateDrawable(int i, int i2) {
        Drawable drawable = al.getDrawable(i);
        Drawable drawable2 = al.getDrawable(i2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public ColorStateList createColorStateList(int i, int i2) {
        int color = al.getColor(i);
        int color2 = al.getColor(i2);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
    }

    public void a(int i, bb bbVar) {
        com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
        hVar.aOv = i;
        hVar.aOw = bbVar;
        hVar.forumId = this.mForumId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016551, hVar));
    }

    public void dn(int i) {
        if (this.awx != null && i == 0) {
            this.awx.startAnimation(getScaleAnimation());
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m15do(int i) {
        if (this.mData != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.mThreadId);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", this.awp);
            httpMessage.addParam("agree_type", this.agreeType);
            httpMessage.addParam("forum_id", this.mForumId);
            if (!TextUtils.isEmpty(this.mPostId)) {
                httpMessage.addParam("post_id", this.mPostId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public Animation getScaleAnimation() {
        if (this.awy == null) {
            this.awy = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.awy.setDuration(200L);
        }
        return this.awy;
    }

    public void onChangeSkinType(int i) {
        if (this.mData == null && this.mSkinType != i) {
            Bp();
            this.mSkinType = i;
        }
    }

    public void setDisPraiseFrom(int i) {
        this.awq = i;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setObjType(int i) {
        this.awp = i;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void setViewEnabled(boolean z) {
        setClickable(z);
        this.awx.setEnabled(z);
        this.aww.setEnabled(z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.avZ = onClickListener;
    }

    public TbPageContext<?> getTbPageContext() {
        if (this.mPageContext == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.mPageContext;
    }

    public BdUniqueId getPageId() {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public ImageView getImageView() {
        return this.awx;
    }

    public TextView getTextView() {
        return this.aww;
    }

    public void aY(boolean z) {
        am amVar = new am("c13271");
        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.al(ImageViewerConfig.FORUM_ID, this.mForumId);
        amVar.al("tid", this.mThreadId);
        amVar.al("post_id", this.mPostId);
        amVar.w("obj_type", getObjType());
        amVar.w("obj_locate", getObjLocate());
        amVar.w(VideoPlayActivityConfig.OBJ_ID, z ? 1 : 0);
        amVar.w("obj_param1", com.baidu.tbadk.util.a.Mu().CM() ? 1 : 0);
        TiebaStatic.log(amVar);
    }

    private int getObjLocate() {
        return this.awq;
    }

    private int getObjType() {
        if (this.awp == 1) {
            return 2;
        }
        return this.awp == 2 ? 3 : 1;
    }
}
