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
    private bb aFJ;
    private View.OnClickListener aJb;
    private TbImageView aKo;
    private TextView aKp;
    private TextView aKq;
    private ForumLikeBotton aKr;
    private com.baidu.tbadk.core.view.commonLike.forum.a aKs;
    private View.OnClickListener aKt;
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
        this.aKt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aFJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aFJ.By() != null ? ThreadForumUserInfoLayout.this.aFJ.By().getForumName() : ThreadForumUserInfoLayout.this.aFJ.zZ(), com.baidu.tieba.card.o.zH())));
                    if (ThreadForumUserInfoLayout.this.aJb != null) {
                        ThreadForumUserInfoLayout.this.aJb.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aKo = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aKp = (TextView) inflate.findViewById(e.g.forum_name);
        this.aKp.setOnClickListener(this.aKt);
        this.aKq = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aKr = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aKs = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aKr);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aKo != null) {
            this.aKo.setDefaultResource(e.f.icon_default_ba_120);
            this.aKo.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKo.setOnClickListener(this.aKt);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.aFJ = bbVar;
            a(bbVar.By());
            b(bbVar.By());
            j(bbVar);
            c(bbVar.By());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aKo.setVisibility(4);
            return;
        }
        this.aKo.setVisibility(0);
        this.aKo.startLoad(ayVar.getAvatar(), 10, false);
        this.aKo.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aKp.setVisibility(4);
            return;
        }
        this.aKp.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aKp.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFJ.zT().getName_show())) {
            this.aKq.setText(getContext().getString(e.j.user_name_and_publish, gG(this.aFJ.zT().getName_show())));
            this.aKq.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aKr.setVisibility(8);
            return;
        }
        this.aKs.a(ayVar);
        this.aKr.setVisibility((!ayVar.getIsLike() || ayVar.zr()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJb = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aKs != null) {
            this.aKs.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKo != null) {
            this.aKo.setPageId(bdUniqueId);
        }
        if (this.aKs != null) {
            this.aKs.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aKp, e.d.cp_cont_f);
            al.h(this.aKq, e.d.cp_cont_d);
        }
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aKo;
    }

    public TextView getUserName() {
        return this.aKq;
    }

    public TextView getForumName() {
        return this.aKp;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aKr;
    }
}
