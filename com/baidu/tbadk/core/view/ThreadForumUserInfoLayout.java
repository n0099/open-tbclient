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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bw afL;
    private View.OnClickListener euA;
    private View.OnClickListener eud;
    private TbImageView euv;
    private TextView euw;
    private TextView eux;
    private ForumLikeBotton euy;
    private com.baidu.tbadk.core.view.commonLike.forum.a euz;
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
        this.euA = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.afL != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.afL.bgs() != null ? ThreadForumUserInfoLayout.this.afL.bgs().getForumName() : ThreadForumUserInfoLayout.this.afL.beI(), m.beq())));
                    if (ThreadForumUserInfoLayout.this.eud != null) {
                        ThreadForumUserInfoLayout.this.eud.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.euv = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.euw = (TextView) inflate.findViewById(R.id.forum_name);
        this.euw.setOnClickListener(this.euA);
        this.eux = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.euy = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.euz = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.euy);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.euv != null) {
            this.euv.setDefaultBgResource(R.color.cp_bg_line_e);
            this.euv.setOnClickListener(this.euA);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.afL = bwVar;
            a(bwVar.bgs());
            b(bwVar.bgs());
            E(bwVar);
            c(bwVar.bgs());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.euv.setVisibility(4);
            return;
        }
        this.euv.setVisibility(0);
        this.euv.startLoad(bsVar.getAvatar(), 10, false);
        this.euv.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.euw.setVisibility(4);
            return;
        }
        this.euw.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.euw.setVisibility(0);
    }

    public void E(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.afL.beE().getName_show())) {
            this.eux.setText(getContext().getString(R.string.user_name_and_publish, AG(this.afL.beE().getName_show())));
            this.eux.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.euy.setVisibility(8);
            return;
        }
        this.euz.a(bsVar);
        this.euy.setVisibility((!bsVar.getIsLike() || bsVar.bdT()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eud = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.euz != null) {
            this.euz.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euv != null) {
            this.euv.setPageId(bdUniqueId);
        }
        if (this.euz != null) {
            this.euz.setPageUniqueId(bdUniqueId);
        }
    }

    protected String AG(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.euv;
    }

    public TextView getUserName() {
        return this.eux;
    }

    public TextView getForumName() {
        return this.euw;
    }

    public ForumLikeBotton getLikeButton() {
        return this.euy;
    }
}
