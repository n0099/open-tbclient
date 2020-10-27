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
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bw agx;
    private View.OnClickListener eQN;
    private TbImageView eRf;
    private TextView eRg;
    private TextView eRh;
    private ForumLikeBotton eRi;
    private com.baidu.tbadk.core.view.commonLike.forum.a eRj;
    private View.OnClickListener eRk;
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
        this.eRk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.agx != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.agx.blO() != null ? ThreadForumUserInfoLayout.this.agx.blO().getForumName() : ThreadForumUserInfoLayout.this.agx.bke(), n.bjM())));
                    if (ThreadForumUserInfoLayout.this.eQN != null) {
                        ThreadForumUserInfoLayout.this.eQN.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eRf = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.eRg = (TextView) inflate.findViewById(R.id.forum_name);
        this.eRg.setOnClickListener(this.eRk);
        this.eRh = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.eRi = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.eRj = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.eRi);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eRf != null) {
            this.eRf.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eRf.setOnClickListener(this.eRk);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.agx = bwVar;
            a(bwVar.blO());
            b(bwVar.blO());
            F(bwVar);
            c(bwVar.blO());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.eRf.setVisibility(4);
            return;
        }
        this.eRf.setVisibility(0);
        this.eRf.startLoad(bsVar.getAvatar(), 10, false);
        this.eRf.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.eRg.setVisibility(4);
            return;
        }
        this.eRg.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.eRg.setVisibility(0);
    }

    public void F(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.agx.bka().getName_show())) {
            this.eRh.setText(getContext().getString(R.string.user_name_and_publish, Ch(this.agx.bka().getName_show())));
            this.eRh.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.eRi.setVisibility(8);
            return;
        }
        this.eRj.a(bsVar);
        this.eRi.setVisibility((!bsVar.getIsLike() || bsVar.bjp()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eQN = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.eRj != null) {
            this.eRj.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eRf != null) {
            this.eRf.setPageId(bdUniqueId);
        }
        if (this.eRj != null) {
            this.eRj.setPageUniqueId(bdUniqueId);
        }
    }

    protected String Ch(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eRf;
    }

    public TextView getUserName() {
        return this.eRh;
    }

    public TextView getForumName() {
        return this.eRg;
    }

    public ForumLikeBotton getLikeButton() {
        return this.eRi;
    }
}
