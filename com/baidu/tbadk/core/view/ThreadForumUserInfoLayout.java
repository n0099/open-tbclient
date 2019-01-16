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
    private bb aFI;
    private View.OnClickListener aJa;
    private TbImageView aKn;
    private TextView aKo;
    private TextView aKp;
    private ForumLikeBotton aKq;
    private com.baidu.tbadk.core.view.commonLike.forum.a aKr;
    private View.OnClickListener aKs;
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
        this.aKs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aFI != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aFI.By() != null ? ThreadForumUserInfoLayout.this.aFI.By().getForumName() : ThreadForumUserInfoLayout.this.aFI.zZ(), com.baidu.tieba.card.o.zH())));
                    if (ThreadForumUserInfoLayout.this.aJa != null) {
                        ThreadForumUserInfoLayout.this.aJa.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aKn = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aKo = (TextView) inflate.findViewById(e.g.forum_name);
        this.aKo.setOnClickListener(this.aKs);
        this.aKp = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aKq = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aKr = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aKq);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aKn != null) {
            this.aKn.setDefaultResource(e.f.icon_default_ba_120);
            this.aKn.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKn.setOnClickListener(this.aKs);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.aFI = bbVar;
            a(bbVar.By());
            b(bbVar.By());
            j(bbVar);
            c(bbVar.By());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aKn.setVisibility(4);
            return;
        }
        this.aKn.setVisibility(0);
        this.aKn.startLoad(ayVar.getAvatar(), 10, false);
        this.aKn.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aKo.setVisibility(4);
            return;
        }
        this.aKo.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aKo.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aFI.zT().getName_show())) {
            this.aKp.setText(getContext().getString(e.j.user_name_and_publish, gG(this.aFI.zT().getName_show())));
            this.aKp.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aKq.setVisibility(8);
            return;
        }
        this.aKr.a(ayVar);
        this.aKq.setVisibility((!ayVar.getIsLike() || ayVar.zr()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJa = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aKr != null) {
            this.aKr.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKn != null) {
            this.aKn.setPageId(bdUniqueId);
        }
        if (this.aKr != null) {
            this.aKr.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aKo, e.d.cp_cont_f);
            al.h(this.aKp, e.d.cp_cont_d);
        }
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aKn;
    }

    public TextView getUserName() {
        return this.aKp;
    }

    public TextView getForumName() {
        return this.aKo;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aKq;
    }
}
