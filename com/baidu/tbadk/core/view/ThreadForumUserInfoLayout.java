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
    private TbImageView aAM;
    private TextView aAN;
    private TextView aAO;
    private ForumLikeBotton aAP;
    private com.baidu.tbadk.core.view.commonLike.forum.a aAQ;
    private View.OnClickListener aAR;
    private bb awf;
    private View.OnClickListener azz;
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
        this.aAR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.awf != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.awf.xR() != null ? ThreadForumUserInfoLayout.this.awf.xR().getForumName() : ThreadForumUserInfoLayout.this.awf.ws(), com.baidu.tieba.card.o.wa())));
                    if (ThreadForumUserInfoLayout.this.azz != null) {
                        ThreadForumUserInfoLayout.this.azz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.aAM = (TbImageView) inflate.findViewById(e.g.forum_avatar);
        this.aAN = (TextView) inflate.findViewById(e.g.forum_name);
        this.aAN.setOnClickListener(this.aAR);
        this.aAO = (TextView) inflate.findViewById(e.g.user_name_and_reply_time);
        this.aAP = (ForumLikeBotton) inflate.findViewById(e.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.aAQ = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.aAP);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.aAM != null) {
            this.aAM.setDefaultResource(e.f.icon_default_ba_120);
            this.aAM.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aAM.setOnClickListener(this.aAR);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.awf = bbVar;
            a(bbVar.xR());
            b(bbVar.xR());
            j(bbVar);
            c(bbVar.xR());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.aAM.setVisibility(4);
            return;
        }
        this.aAM.setVisibility(0);
        this.aAM.startLoad(ayVar.getAvatar(), 10, false);
        this.aAM.setBorderColor(al.getColor(e.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.aAN.setVisibility(4);
            return;
        }
        this.aAN.setText(ao.d(ayVar.getForumName(), 14, "...") + getResources().getString(e.j.forum));
        this.aAN.setVisibility(0);
    }

    public void j(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.awf.wm().getName_show())) {
            this.aAO.setText(getContext().getString(e.j.user_name_and_publish, fK(this.awf.wm().getName_show())));
            this.aAO.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.aAP.setVisibility(8);
            return;
        }
        this.aAQ.a(ayVar);
        this.aAP.setVisibility((!ayVar.getIsLike() || ayVar.vK()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.azz = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.aAQ != null) {
            this.aAQ.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aAM != null) {
            this.aAM.setPageId(bdUniqueId);
        }
        if (this.aAQ != null) {
            this.aAQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.aAN, e.d.cp_cont_f);
            al.h(this.aAO, e.d.cp_cont_d);
        }
    }

    protected String fK(String str) {
        return ao.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.aAM;
    }

    public TextView getUserName() {
        return this.aAO;
    }

    public TextView getForumName() {
        return this.aAN;
    }

    public ForumLikeBotton getLikeButton() {
        return this.aAP;
    }
}
