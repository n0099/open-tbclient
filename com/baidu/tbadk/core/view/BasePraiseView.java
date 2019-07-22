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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class BasePraiseView<T> extends LinearLayout {
    protected int agreeType;
    protected long bLE;
    protected long bLF;
    protected ScaleAnimation bWC;
    protected int bWX;
    public int bWY;
    public int bWZ;
    protected View.OnClickListener bWk;
    public int bXa;
    public int bXb;
    public int bXc;
    protected TextView bXd;
    protected ImageView bXe;
    protected T mData;
    protected String mForumId;
    protected int mFrom;
    protected TbPageContext mPageContext;
    protected String mPostId;
    private int mSkinType;
    protected String mThreadId;
    protected int objType;

    public abstract void JS();

    public abstract long getNum();

    public BasePraiseView(Context context) {
        this(context, null);
    }

    public BasePraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.agreeType = 2;
        this.objType = 3;
        this.bWX = 1;
        this.mFrom = 2;
        this.bWY = R.string.action_praise_default;
        this.bWZ = R.drawable.icon_card_like_n;
        this.bXa = R.drawable.icon_card_like_s;
        this.bXb = R.color.cp_cont_j;
        this.bXc = R.color.cp_cont_h;
        this.mThreadId = "";
        this.mForumId = "";
        this.mPostId = "";
        setOrientation(0);
        setGravity(17);
        initView(context);
        akg();
    }

    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, R.layout.praise_view, this);
            this.bXd = (TextView) inflate.findViewById(R.id.thread_info_praise_num);
            this.bXe = (ImageView) inflate.findViewById(R.id.thread_info_praise_img);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akg() {
        this.agreeType = 2;
        this.bWY = R.string.action_praise_default;
        this.bXb = R.color.cp_cont_j;
        this.bXc = R.color.cp_cont_h;
        this.bWZ = R.drawable.icon_card_like_n;
        this.bXa = R.drawable.icon_card_like_s;
    }

    public StateListDrawable Z(int i, int i2) {
        Drawable drawable = am.getDrawable(i);
        Drawable drawable2 = am.getDrawable(i2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public ColorStateList createColorStateList(int i, int i2) {
        int color = am.getColor(i);
        int color2 = am.getColor(i2);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
    }

    public void a(int i, bg bgVar) {
        com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
        jVar.cqQ = i;
        jVar.cqR = bgVar;
        jVar.forumId = this.mForumId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, jVar));
    }

    public void ix(int i) {
        if (this.bXe != null && i == 0) {
            this.bXe.startAnimation(getScaleAnimation());
        }
    }

    public void iw(int i) {
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
        if (this.bWC == null) {
            this.bWC = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bWC.setDuration(200L);
        }
        return this.bWC;
    }

    public void onChangeSkinType(int i) {
        if (this.mData == null && this.mSkinType != i) {
            JS();
            this.mSkinType = i;
        }
    }

    public void setDisPraiseFrom(int i) {
        this.bWX = i;
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
        this.bXe.setEnabled(z);
        this.bXd.setEnabled(z);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
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
        return this.bXe;
    }

    public TextView getTextView() {
        return this.bXd;
    }

    public void ei(boolean z) {
        an anVar = new an("c13271");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.mForumId);
        anVar.bT("tid", this.mThreadId);
        anVar.bT("post_id", this.mPostId);
        anVar.P("obj_type", getObjType());
        anVar.P("obj_locate", getObjLocate());
        anVar.P(VideoPlayActivityConfig.OBJ_ID, z ? 1 : 0);
        anVar.P("obj_param1", com.baidu.tbadk.util.a.avW().alO() ? 1 : 0);
        TiebaStatic.log(anVar);
    }

    private int getObjLocate() {
        return this.bWX;
    }

    private int getObjType() {
        if (this.objType == 1) {
            return 2;
        }
        return this.objType == 2 ? 3 : 1;
    }
}
