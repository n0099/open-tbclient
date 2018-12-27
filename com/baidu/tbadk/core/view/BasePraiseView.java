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
    protected View.OnClickListener aFa;
    protected int aFq;
    protected int aFr;
    public int aFs;
    public int aFt;
    public int aFu;
    public int aFv;
    public int aFw;
    protected TextView aFx;
    protected ImageView aFy;
    protected ScaleAnimation aFz;
    protected int agreeType;
    protected long avh;
    protected long avi;
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
        this.aFq = 3;
        this.aFr = 1;
        this.mFrom = 2;
        this.aFs = e.j.action_praise_default;
        this.aFt = e.f.icon_card_like_n;
        this.aFu = e.f.icon_card_like_s;
        this.aFv = e.d.cp_cont_j;
        this.aFw = e.d.cp_cont_h;
        this.mThreadId = "";
        this.mForumId = "";
        this.mPostId = "";
        setOrientation(0);
        setGravity(17);
        initView(context);
        EH();
    }

    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view, this);
            this.aFx = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aFy = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EH() {
        this.agreeType = 2;
        this.aFs = e.j.action_praise_default;
        this.aFv = e.d.cp_cont_j;
        this.aFw = e.d.cp_cont_h;
        this.aFt = e.f.icon_card_like_n;
        this.aFu = e.f.icon_card_like_s;
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
        hVar.aXn = i;
        hVar.aXo = bbVar;
        hVar.forumId = this.mForumId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, hVar));
    }

    public void dZ(int i) {
        if (this.aFy != null && i == 0) {
            this.aFy.startAnimation(getScaleAnimation());
        }
    }

    public void ea(int i) {
        if (this.mData != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.mThreadId);
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", this.aFq);
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
        if (this.aFz == null) {
            this.aFz = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.aFz.setDuration(200L);
        }
        return this.aFz;
    }

    public void onChangeSkinType(int i) {
        if (this.mData == null && this.mSkinType != i) {
            updateUI();
            this.mSkinType = i;
        }
    }

    public void setDisPraiseFrom(int i) {
        this.aFr = i;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setObjType(int i) {
        this.aFq = i;
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
        this.aFy.setEnabled(z);
        this.aFx.setEnabled(z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFa = onClickListener;
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
        return this.aFy;
    }

    public TextView getTextView() {
        return this.aFx;
    }

    public void bz(boolean z) {
        am amVar = new am("c13271");
        amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.aA(ImageViewerConfig.FORUM_ID, this.mForumId);
        amVar.aA("tid", this.mThreadId);
        amVar.aA("post_id", this.mPostId);
        amVar.x("obj_type", getObjType());
        amVar.x("obj_locate", getObjLocate());
        amVar.x(VideoPlayActivityConfig.OBJ_ID, z ? 1 : 0);
        amVar.x("obj_param1", com.baidu.tbadk.util.a.PJ().Gg() ? 1 : 0);
        TiebaStatic.log(amVar);
    }

    private int getObjLocate() {
        return this.aFr;
    }

    private int getObjType() {
        if (this.aFq == 1) {
            return 2;
        }
        return this.aFq == 2 ? 3 : 1;
    }
}
