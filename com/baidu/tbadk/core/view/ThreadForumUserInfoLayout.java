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
    private bg XS;
    private View.OnClickListener bRB;
    private TbImageView bSZ;
    private TextView bTa;
    private TextView bTb;
    private ForumLikeBotton bTc;
    private com.baidu.tbadk.core.view.commonLike.forum.a bTd;
    private View.OnClickListener bTe;
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
        this.bTe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.XS != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.XS.aaB() != null ? ThreadForumUserInfoLayout.this.XS.aaB().getForumName() : ThreadForumUserInfoLayout.this.XS.YT(), com.baidu.tieba.card.n.YB())));
                    if (ThreadForumUserInfoLayout.this.bRB != null) {
                        ThreadForumUserInfoLayout.this.bRB.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.bSZ = (TbImageView) inflate.findViewById(d.g.forum_avatar);
        this.bTa = (TextView) inflate.findViewById(d.g.forum_name);
        this.bTa.setOnClickListener(this.bTe);
        this.bTb = (TextView) inflate.findViewById(d.g.user_name_and_reply_time);
        this.bTc = (ForumLikeBotton) inflate.findViewById(d.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.bTd = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.bTc);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.bSZ != null) {
            this.bSZ.setDefaultResource(d.f.icon_default_ba_120);
            this.bSZ.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.bSZ.setOnClickListener(this.bTe);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.XS = bgVar;
            a(bgVar.aaB());
            b(bgVar.aaB());
            y(bgVar);
            c(bgVar.aaB());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.bSZ.setVisibility(4);
            return;
        }
        this.bSZ.setVisibility(0);
        this.bSZ.startLoad(bcVar.getAvatar(), 10, false);
        this.bSZ.setBorderColor(al.getColor(d.C0277d.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.bTa.setVisibility(4);
            return;
        }
        this.bTa.setText(ap.g(bcVar.getForumName(), 14, "...") + getResources().getString(d.j.forum));
        this.bTa.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XS.YO().getName_show())) {
            this.bTb.setText(getContext().getString(d.j.user_name_and_publish, nt(this.XS.YO().getName_show())));
            this.bTb.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.bTc.setVisibility(8);
            return;
        }
        this.bTd.a(bcVar);
        this.bTc.setVisibility((!bcVar.getIsLike() || bcVar.Yd()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRB = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.bTd != null) {
            this.bTd.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bSZ != null) {
            this.bSZ.setPageId(bdUniqueId);
        }
        if (this.bTd != null) {
            this.bTd.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bTa, d.C0277d.cp_cont_f);
            al.j(this.bTb, d.C0277d.cp_cont_d);
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.bSZ;
    }

    public TextView getUserName() {
        return this.bTb;
    }

    public TextView getForumName() {
        return this.bTa;
    }

    public ForumLikeBotton getLikeButton() {
        return this.bTc;
    }
}
