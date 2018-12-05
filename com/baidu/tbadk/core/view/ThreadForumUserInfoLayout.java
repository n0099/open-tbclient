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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bb aFf;
    private View.OnClickListener aIx;
    private TbImageView aJJ;
    private TextView aJK;
    private TextView aJL;
    private ForumLikeBotton aJM;
    private com.baidu.tbadk.core.view.commonLike.forum.a aJN;
    private View.OnClickListener aJO;
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
        this.aJO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aFf != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aFf.Bl() != null ? ThreadForumUserInfoLayout.this.aFf.Bl().getForumName() : ThreadForumUserInfoLayout.this.aFf.zM(), com.baidu.tieba.card.o.zu())));
                    if (ThreadForumUserInfoLayout.this.aIx != null) {
                        ThreadForumUserInfoLayout.this.aIx.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aJJ = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aJK = (TextView) inflate.findViewById(e.g.forum_name);
        this.aJK.setOnClickListener(this.aJO);
        this.aJL = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aJM = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aJN = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aJM);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aJJ != null) {
            this.aJJ.setDefaultResource(e.f.icon_default_ba_120);
            this.aJJ.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aJJ.setOnClickListener(this.aJO);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.aFf = bbVar;
            a(bbVar.Bl());
            b(bbVar.Bl());
            j(bbVar);
            c(bbVar.Bl());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aJJ.setVisibility(4);
            return;
        }
        this.aJJ.setVisibility(0);
        this.aJJ.startLoad(ayVar.getAvatar(), 10, false);
        this.aJJ.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aJK.setVisibility(4);
            return;
        }
        this.aJK.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aJK.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFf.zG().getName_show())) {
            this.aJL.setText(getContext().getString(e.j.user_name_and_publish, gr(this.aFf.zG().getName_show())));
            this.aJL.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aJM.setVisibility(8);
            return;
        }
        this.aJN.a(ayVar);
        this.aJM.setVisibility((!ayVar.getIsLike() || ayVar.ze()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIx = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aJN != null) {
            this.aJN.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aJJ != null) {
            this.aJJ.setPageId(bdUniqueId);
        }
        if (this.aJN != null) {
            this.aJN.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aJK, e.d.cp_cont_f);
            al.h(this.aJL, e.d.cp_cont_d);
        }
    }

    protected String gr(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aJJ;
    }

    public TextView getUserName() {
        return this.aJL;
    }

    public TextView getForumName() {
        return this.aJK;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aJM;
    }
}
