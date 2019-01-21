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
/* loaded from: classes6.dex */
public abstract class BasePraiseView<T> extends LinearLayout {
    protected View.OnClickListener aFD;
    protected int aFT;
    protected int aFU;
    public int aFV;
    public int aFW;
    public int aFX;
    public int aFY;
    public int aFZ;
    protected TextView aGa;
    protected ImageView aGb;
    protected ScaleAnimation aGc;
    protected int agreeType;
    protected long avK;
    protected long avL;
    protected T mData;
    protected String mForumId;
    protected int mFrom;
    protected TbPageContext mPageContext;
    protected String mPostId;
    private int mSkinType;
    protected String mThreadId;

    public abstract long getNum();

    public abstract void updateUI();

    public BasePraiseView(Context context) {
        this(context, null);
    }

    public BasePraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.agreeType = 2;
        this.aFT = 3;
        this.aFU = 1;
        this.mFrom = 2;
        this.aFV = e.j.action_praise_default;
        this.aFW = e.f.icon_card_like_n;
        this.aFX = e.f.icon_card_like_s;
        this.aFY = e.d.cp_cont_j;
        this.aFZ = e.d.cp_cont_h;
        this.mThreadId = "";
        this.mForumId = "";
        this.mPostId = "";
        setOrientation(0);
        setGravity(17);
        initView(context);
        EU();
    }

    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view, this);
            this.aGa = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aGb = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
        this.agreeType = 2;
        this.aFV = e.j.action_praise_default;
        this.aFY = e.d.cp_cont_j;
        this.aFZ = e.d.cp_cont_h;
        this.aFW = e.f.icon_card_like_n;
        this.aFX = e.f.icon_card_like_s;
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
        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
        jVar.aXY = i;
        jVar.aXZ = bbVar;
        jVar.forumId = this.mForumId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, jVar));
    }

    public void dZ(int i) {
        if (this.aGb != null && i == 0) {
            this.aGb.startAnimation(getScaleAnimation());
        }
    }

    public void ea(int i) {
        if (this.mData != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.mThreadId);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", this.aFT);
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
        if (this.aGc == null) {
            this.aGc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.aGc.setDuration(200L);
        }
        return this.aGc;
    }

    public void onChangeSkinType(int i) {
        if (this.mData == null && this.mSkinType != i) {
            updateUI();
            this.mSkinType = i;
        }
    }

    public void setDisPraiseFrom(int i) {
        this.aFU = i;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setObjType(int i) {
        this.aFT = i;
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
        this.aGb.setEnabled(z);
        this.aGa.setEnabled(z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFD = onClickListener;
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
        return this.aGb;
    }

    public TextView getTextView() {
        return this.aGa;
    }

    public void bA(boolean z) {
        am amVar = new am("c13271");
        amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.aB(ImageViewerConfig.FORUM_ID, this.mForumId);
        amVar.aB("tid", this.mThreadId);
        amVar.aB("post_id", this.mPostId);
        amVar.y("obj_type", getObjType());
        amVar.y("obj_locate", getObjLocate());
        amVar.y(VideoPlayActivityConfig.OBJ_ID, z ? 1 : 0);
        amVar.y("obj_param1", com.baidu.tbadk.util.a.Qb().Gt() ? 1 : 0);
        TiebaStatic.log(amVar);
    }

    private int getObjLocate() {
        return this.aFU;
    }

    private int getObjType() {
        if (this.aFT == 1) {
            return 2;
        }
        return this.aFT == 2 ? 3 : 1;
    }
}
