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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class BasePraiseView<T> extends LinearLayout {
    protected int agreeType;
    protected long bDh;
    protected long bDi;
    protected ScaleAnimation bNL;
    protected View.OnClickListener bNt;
    protected int bOc;
    public int bOd;
    public int bOe;
    public int bOf;
    public int bOg;
    public int bOh;
    protected TextView bOi;
    protected ImageView bOj;
    protected T mData;
    protected String mForumId;
    protected int mFrom;
    protected TbPageContext mPageContext;
    protected String mPostId;
    private int mSkinType;
    protected String mThreadId;
    protected int objType;

    public abstract void GR();

    public abstract long getNum();

    public BasePraiseView(Context context) {
        this(context, null);
    }

    public BasePraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.agreeType = 2;
        this.objType = 3;
        this.bOc = 1;
        this.mFrom = 2;
        this.bOd = d.j.action_praise_default;
        this.bOe = d.f.icon_card_like_n;
        this.bOf = d.f.icon_card_like_s;
        this.bOg = d.C0236d.cp_cont_j;
        this.bOh = d.C0236d.cp_cont_h;
        this.mThreadId = "";
        this.mForumId = "";
        this.mPostId = "";
        setOrientation(0);
        setGravity(17);
        initView(context);
        aeg();
    }

    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, d.h.praise_view, this);
            this.bOi = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
            this.bOj = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeg() {
        this.agreeType = 2;
        this.bOd = d.j.action_praise_default;
        this.bOg = d.C0236d.cp_cont_j;
        this.bOh = d.C0236d.cp_cont_h;
        this.bOe = d.f.icon_card_like_n;
        this.bOf = d.f.icon_card_like_s;
    }

    public StateListDrawable W(int i, int i2) {
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

    public void a(int i, bg bgVar) {
        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
        jVar.chs = i;
        jVar.cht = bgVar;
        jVar.forumId = this.mForumId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, jVar));
    }

    public void hE(int i) {
        if (this.bOj != null && i == 0) {
            this.bOj.startAnimation(getScaleAnimation());
        }
    }

    public void hD(int i) {
        if (this.mData != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.mThreadId);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", this.objType);
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
        if (this.bNL == null) {
            this.bNL = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bNL.setDuration(200L);
        }
        return this.bNL;
    }

    public void onChangeSkinType(int i) {
        if (this.mData == null && this.mSkinType != i) {
            GR();
            this.mSkinType = i;
        }
    }

    public void setDisPraiseFrom(int i) {
        this.bOc = i;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setObjType(int i) {
        this.objType = i;
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
        this.bOj.setEnabled(z);
        this.bOi.setEnabled(z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
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
        return this.bOj;
    }

    public TextView getTextView() {
        return this.bOi;
    }

    public void dI(boolean z) {
        am amVar = new am("c13271");
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.mForumId);
        amVar.bJ("tid", this.mThreadId);
        amVar.bJ("post_id", this.mPostId);
        amVar.T("obj_type", getObjType());
        amVar.T("obj_locate", getObjLocate());
        amVar.T(VideoPlayActivityConfig.OBJ_ID, z ? 1 : 0);
        amVar.T("obj_param1", com.baidu.tbadk.util.a.apN().afN() ? 1 : 0);
        TiebaStatic.log(amVar);
    }

    private int getObjLocate() {
        return this.bOc;
    }

    private int getObjType() {
        if (this.objType == 1) {
            return 2;
        }
        return this.objType == 2 ? 3 : 1;
    }
}
