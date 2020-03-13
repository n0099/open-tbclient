package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bj KJ;
    private View.OnClickListener dhW;
    private TbImageView dip;
    private TextView diq;
    private TextView dit;
    private ForumLikeBotton diu;
    private com.baidu.tbadk.core.view.commonLike.forum.a div;
    private View.OnClickListener diw;
    private int mSkinType;

    public ThreadForumUserInfoLayout(Context context) {
        this(context, null);
    }

    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.diw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.KJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.KJ.aDX() != null ? ThreadForumUserInfoLayout.this.KJ.aDX().getForumName() : ThreadForumUserInfoLayout.this.KJ.aCt(), com.baidu.tieba.card.l.aCa())));
                    if (ThreadForumUserInfoLayout.this.dhW != null) {
                        ThreadForumUserInfoLayout.this.dhW.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dip = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.diq = (TextView) inflate.findViewById(R.id.forum_name);
        this.diq.setOnClickListener(this.diw);
        this.dit = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.diu = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.div = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.diu);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dip != null) {
            this.dip.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dip.setOnClickListener(this.diw);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.KJ = bjVar;
            b(bjVar.aDX());
            c(bjVar.aDX());
            F(bjVar);
            d(bjVar.aDX());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.dip.setVisibility(4);
            return;
        }
        this.dip.setVisibility(0);
        this.dip.startLoad(bfVar.getAvatar(), 10, false);
        this.dip.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.diq.setVisibility(4);
            return;
        }
        this.diq.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.diq.setVisibility(0);
    }

    public void F(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCo().getName_show())) {
            this.dit.setText(getContext().getString(R.string.user_name_and_publish, tZ(this.KJ.aCo().getName_show())));
            this.dit.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.diu.setVisibility(8);
            return;
        }
        this.div.a(bfVar);
        this.diu.setVisibility((!bfVar.getIsLike() || bfVar.aBE()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhW = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.div != null) {
            this.div.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dip != null) {
            this.dip.setPageId(bdUniqueId);
        }
        if (this.div != null) {
            this.div.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dip;
    }

    public TextView getUserName() {
        return this.dit;
    }

    public TextView getForumName() {
        return this.diq;
    }

    public ForumLikeBotton getLikeButton() {
        return this.diu;
    }
}
