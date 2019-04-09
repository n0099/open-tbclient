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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bg XT;
    private View.OnClickListener bRC;
    private TbImageView bTa;
    private TextView bTb;
    private TextView bTc;
    private ForumLikeBotton bTd;
    private com.baidu.tbadk.core.view.commonLike.forum.a bTe;
    private View.OnClickListener bTf;
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
        this.bTf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.XT != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.XT.aaB() != null ? ThreadForumUserInfoLayout.this.XT.aaB().getForumName() : ThreadForumUserInfoLayout.this.XT.YT(), com.baidu.tieba.card.n.YB())));
                    if (ThreadForumUserInfoLayout.this.bRC != null) {
                        ThreadForumUserInfoLayout.this.bRC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.bTa = (TbImageView) inflate.findViewById(d.g.forum_avatar);
        this.bTb = (TextView) inflate.findViewById(d.g.forum_name);
        this.bTb.setOnClickListener(this.bTf);
        this.bTc = (TextView) inflate.findViewById(d.g.user_name_and_reply_time);
        this.bTd = (ForumLikeBotton) inflate.findViewById(d.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.bTe = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.bTd);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.bTa != null) {
            this.bTa.setDefaultResource(d.f.icon_default_ba_120);
            this.bTa.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.bTa.setOnClickListener(this.bTf);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.XT = bgVar;
            a(bgVar.aaB());
            b(bgVar.aaB());
            y(bgVar);
            c(bgVar.aaB());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.bTa.setVisibility(4);
            return;
        }
        this.bTa.setVisibility(0);
        this.bTa.startLoad(bcVar.getAvatar(), 10, false);
        this.bTa.setBorderColor(al.getColor(d.C0277d.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.bTb.setVisibility(4);
            return;
        }
        this.bTb.setText(ap.g(bcVar.getForumName(), 14, "...") + getResources().getString(d.j.forum));
        this.bTb.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XT.YO().getName_show())) {
            this.bTc.setText(getContext().getString(d.j.user_name_and_publish, nt(this.XT.YO().getName_show())));
            this.bTc.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.bTd.setVisibility(8);
            return;
        }
        this.bTe.a(bcVar);
        this.bTd.setVisibility((!bcVar.getIsLike() || bcVar.Yd()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRC = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.bTe != null) {
            this.bTe.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTa != null) {
            this.bTa.setPageId(bdUniqueId);
        }
        if (this.bTe != null) {
            this.bTe.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bTb, d.C0277d.cp_cont_f);
            al.j(this.bTc, d.C0277d.cp_cont_d);
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.bTa;
    }

    public TextView getUserName() {
        return this.bTc;
    }

    public TextView getForumName() {
        return this.bTb;
    }

    public ForumLikeBotton getLikeButton() {
        return this.bTd;
    }
}
