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
    private bb aAQ;
    private View.OnClickListener aEh;
    private TbImageView aFt;
    private TextView aFu;
    private TextView aFv;
    private ForumLikeBotton aFw;
    private com.baidu.tbadk.core.view.commonLike.forum.a aFx;
    private View.OnClickListener aFy;
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
        this.aFy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aAQ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aAQ.Aa() != null ? ThreadForumUserInfoLayout.this.aAQ.Aa().getForumName() : ThreadForumUserInfoLayout.this.aAQ.yB(), com.baidu.tieba.card.o.yj())));
                    if (ThreadForumUserInfoLayout.this.aEh != null) {
                        ThreadForumUserInfoLayout.this.aEh.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aFt = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aFu = (TextView) inflate.findViewById(e.g.forum_name);
        this.aFu.setOnClickListener(this.aFy);
        this.aFv = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aFw = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aFx = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aFw);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aFt != null) {
            this.aFt.setDefaultResource(e.f.icon_default_ba_120);
            this.aFt.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aFt.setOnClickListener(this.aFy);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.aAQ = bbVar;
            a(bbVar.Aa());
            b(bbVar.Aa());
            j(bbVar);
            c(bbVar.Aa());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aFt.setVisibility(4);
            return;
        }
        this.aFt.setVisibility(0);
        this.aFt.startLoad(ayVar.getAvatar(), 10, false);
        this.aFt.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aFu.setVisibility(4);
            return;
        }
        this.aFu.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aFu.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.aAQ.yv().getName_show())) {
            this.aFv.setText(getContext().getString(e.j.user_name_and_publish, fY(this.aAQ.yv().getName_show())));
            this.aFv.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aFw.setVisibility(8);
            return;
        }
        this.aFx.a(ayVar);
        this.aFw.setVisibility((!ayVar.getIsLike() || ayVar.xT()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aFx != null) {
            this.aFx.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aFt != null) {
            this.aFt.setPageId(bdUniqueId);
        }
        if (this.aFx != null) {
            this.aFx.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aFu, e.d.cp_cont_f);
            al.h(this.aFv, e.d.cp_cont_d);
        }
    }

    protected String fY(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aFt;
    }

    public TextView getUserName() {
        return this.aFv;
    }

    public TextView getForumName() {
        return this.aFu;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aFw;
    }
}
