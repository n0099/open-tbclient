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
    private bg XR;
    private View.OnClickListener bRy;
    private TbImageView bSW;
    private TextView bSX;
    private TextView bSY;
    private ForumLikeBotton bSZ;
    private com.baidu.tbadk.core.view.commonLike.forum.a bTa;
    private View.OnClickListener bTb;
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
        this.bTb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.XR != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.XR.aaE() != null ? ThreadForumUserInfoLayout.this.XR.aaE().getForumName() : ThreadForumUserInfoLayout.this.XR.YW(), com.baidu.tieba.card.n.YE())));
                    if (ThreadForumUserInfoLayout.this.bRy != null) {
                        ThreadForumUserInfoLayout.this.bRy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.bSW = (TbImageView) inflate.findViewById(d.g.forum_avatar);
        this.bSX = (TextView) inflate.findViewById(d.g.forum_name);
        this.bSX.setOnClickListener(this.bTb);
        this.bSY = (TextView) inflate.findViewById(d.g.user_name_and_reply_time);
        this.bSZ = (ForumLikeBotton) inflate.findViewById(d.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.bTa = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.bSZ);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.bSW != null) {
            this.bSW.setDefaultResource(d.f.icon_default_ba_120);
            this.bSW.setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.bSW.setOnClickListener(this.bTb);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.XR = bgVar;
            a(bgVar.aaE());
            b(bgVar.aaE());
            y(bgVar);
            c(bgVar.aaE());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.bSW.setVisibility(4);
            return;
        }
        this.bSW.setVisibility(0);
        this.bSW.startLoad(bcVar.getAvatar(), 10, false);
        this.bSW.setBorderColor(al.getColor(d.C0236d.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.bSX.setVisibility(4);
            return;
        }
        this.bSX.setText(ap.g(bcVar.getForumName(), 14, "...") + getResources().getString(d.j.forum));
        this.bSX.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.XR.YR().getName_show())) {
            this.bSY.setText(getContext().getString(d.j.user_name_and_publish, ns(this.XR.YR().getName_show())));
            this.bSY.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.bSZ.setVisibility(8);
            return;
        }
        this.bTa.a(bcVar);
        this.bSZ.setVisibility((!bcVar.getIsLike() || bcVar.Yg()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRy = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.bTa != null) {
            this.bTa.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bSW != null) {
            this.bSW.setPageId(bdUniqueId);
        }
        if (this.bTa != null) {
            this.bTa.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.bSX, d.C0236d.cp_cont_f);
            al.j(this.bSY, d.C0236d.cp_cont_d);
        }
    }

    protected String ns(String str) {
        return ap.g(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.bSW;
    }

    public TextView getUserName() {
        return this.bSY;
    }

    public TextView getForumName() {
        return this.bSX;
    }

    public ForumLikeBotton getLikeButton() {
        return this.bSZ;
    }
}
