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
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bh We;
    private View.OnClickListener caC;
    private TbImageView ccc;
    private TextView ccd;
    private TextView cce;
    private ForumLikeBotton ccf;
    private com.baidu.tbadk.core.view.commonLike.forum.a ccg;
    private View.OnClickListener cch;
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
        this.cch = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.We != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.We.agl() != null ? ThreadForumUserInfoLayout.this.We.agl().getForumName() : ThreadForumUserInfoLayout.this.We.aeD(), com.baidu.tieba.card.n.ael())));
                    if (ThreadForumUserInfoLayout.this.caC != null) {
                        ThreadForumUserInfoLayout.this.caC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ccc = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ccd = (TextView) inflate.findViewById(R.id.forum_name);
        this.ccd.setOnClickListener(this.cch);
        this.cce = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ccf = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.ccg = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ccf);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ccc != null) {
            this.ccc.setDefaultResource(R.drawable.icon_default_ba_120);
            this.ccc.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ccc.setOnClickListener(this.cch);
        }
    }

    public void setData(bh bhVar) {
        if (bhVar != null) {
            this.We = bhVar;
            a(bhVar.agl());
            b(bhVar.agl());
            z(bhVar);
            c(bhVar.agl());
        }
    }

    private void a(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAvatar())) {
            this.ccc.setVisibility(4);
            return;
        }
        this.ccc.setVisibility(0);
        this.ccc.startLoad(bdVar.getAvatar(), 10, false);
        this.ccc.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void b(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.ccd.setVisibility(4);
            return;
        }
        this.ccd.setText(aq.j(bdVar.getForumName(), 14, "...") + getResources().getString(R.string.forum));
        this.ccd.setVisibility(0);
    }

    public void z(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.We.aey().getName_show())) {
            this.cce.setText(getContext().getString(R.string.user_name_and_publish, oT(this.We.aey().getName_show())));
            this.cce.setVisibility(0);
        }
    }

    public void c(bd bdVar) {
        int i = 8;
        if (bdVar == null) {
            this.ccf.setVisibility(8);
            return;
        }
        this.ccg.a(bdVar);
        this.ccf.setVisibility((!bdVar.getIsLike() || bdVar.adN()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caC = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.ccg != null) {
            this.ccg.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ccc != null) {
            this.ccc.setPageId(bdUniqueId);
        }
        if (this.ccg != null) {
            this.ccg.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.ccd, R.color.cp_cont_f);
            am.j(this.cce, R.color.cp_cont_d);
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.ccc;
    }

    public TextView getUserName() {
        return this.cce;
    }

    public TextView getForumName() {
        return this.ccd;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ccf;
    }
}
