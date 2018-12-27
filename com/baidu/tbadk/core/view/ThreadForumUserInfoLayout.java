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
    private bb aFg;
    private View.OnClickListener aIy;
    private TbImageView aJL;
    private TextView aJM;
    private TextView aJN;
    private ForumLikeBotton aJO;
    private com.baidu.tbadk.core.view.commonLike.forum.a aJP;
    private View.OnClickListener aJQ;
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
        this.aJQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aFg != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aFg.Bl() != null ? ThreadForumUserInfoLayout.this.aFg.Bl().getForumName() : ThreadForumUserInfoLayout.this.aFg.zM(), com.baidu.tieba.card.o.zu())));
                    if (ThreadForumUserInfoLayout.this.aIy != null) {
                        ThreadForumUserInfoLayout.this.aIy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aJL = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aJM = (TextView) inflate.findViewById(e.g.forum_name);
        this.aJM.setOnClickListener(this.aJQ);
        this.aJN = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aJO = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aJP = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aJO);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aJL != null) {
            this.aJL.setDefaultResource(e.f.icon_default_ba_120);
            this.aJL.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aJL.setOnClickListener(this.aJQ);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.aFg = bbVar;
            a(bbVar.Bl());
            b(bbVar.Bl());
            j(bbVar);
            c(bbVar.Bl());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aJL.setVisibility(4);
            return;
        }
        this.aJL.setVisibility(0);
        this.aJL.startLoad(ayVar.getAvatar(), 10, false);
        this.aJL.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aJM.setVisibility(4);
            return;
        }
        this.aJM.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aJM.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFg.zG().getName_show())) {
            this.aJN.setText(getContext().getString(e.j.user_name_and_publish, gt(this.aFg.zG().getName_show())));
            this.aJN.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aJO.setVisibility(8);
            return;
        }
        this.aJP.a(ayVar);
        this.aJO.setVisibility((!ayVar.getIsLike() || ayVar.ze()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIy = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aJP != null) {
            this.aJP.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aJL != null) {
            this.aJL.setPageId(bdUniqueId);
        }
        if (this.aJP != null) {
            this.aJP.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aJM, e.d.cp_cont_f);
            al.h(this.aJN, e.d.cp_cont_d);
        }
    }

    protected String gt(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aJL;
    }

    public TextView getUserName() {
        return this.aJN;
    }

    public TextView getForumName() {
        return this.aJM;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aJO;
    }
}
