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
    private View.OnClickListener bRz;
    private TbImageView bSX;
    private TextView bSY;
    private TextView bSZ;
    private ForumLikeBotton bTa;
    private com.baidu.tbadk.core.view.commonLike.forum.a bTb;
    private View.OnClickListener bTc;
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
        this.bTc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.XS != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.XS.aaE() != null ? ThreadForumUserInfoLayout.this.XS.aaE().getForumName() : ThreadForumUserInfoLayout.this.XS.YW(), com.baidu.tieba.card.n.YE())));
                    if (ThreadForumUserInfoLayout.this.bRz != null) {
                        ThreadForumUserInfoLayout.this.bRz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.bSX = (TbImageView) inflate.findViewById(d.g.forum_avatar);
        this.bSY = (TextView) inflate.findViewById(d.g.forum_name);
        this.bSY.setOnClickListener(this.bTc);
        this.bSZ = (TextView) inflate.findViewById(d.g.user_name_and_reply_time);
        this.bTa = (ForumLikeBotton) inflate.findViewById(d.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.bTb = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.bTa);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.bSX != null) {
            this.bSX.setDefaultResource(d.f.icon_default_ba_120);
            this.bSX.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.bSX.setOnClickListener(this.bTc);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.XS = bgVar;
            a(bgVar.aaE());
            b(bgVar.aaE());
            y(bgVar);
            c(bgVar.aaE());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.bSX.setVisibility(4);
            return;
        }
        this.bSX.setVisibility(0);
        this.bSX.startLoad(bcVar.getAvatar(), 10, false);
        this.bSX.setBorderColor(al.getColor(d.C0277d.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.bSY.setVisibility(4);
            return;
        }
        this.bSY.setText(ap.g(bcVar.getForumName(), 14, "...") + getResources().getString(d.j.forum));
        this.bSY.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XS.YR().getName_show())) {
            this.bSZ.setText(getContext().getString(d.j.user_name_and_publish, ns(this.XS.YR().getName_show())));
            this.bSZ.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.bTa.setVisibility(8);
            return;
        }
        this.bTb.a(bcVar);
        this.bTa.setVisibility((!bcVar.getIsLike() || bcVar.Yg()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRz = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.bTb != null) {
            this.bTb.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bSX != null) {
            this.bSX.setPageId(bdUniqueId);
        }
        if (this.bTb != null) {
            this.bTb.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bSY, d.C0277d.cp_cont_f);
            al.j(this.bSZ, d.C0277d.cp_cont_d);
        }
    }

    protected String ns(String str) {
        return ap.g(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.bSX;
    }

    public TextView getUserName() {
        return this.bSZ;
    }

    public TextView getForumName() {
        return this.bSY;
    }

    public ForumLikeBotton getLikeButton() {
        return this.bTa;
    }
}
