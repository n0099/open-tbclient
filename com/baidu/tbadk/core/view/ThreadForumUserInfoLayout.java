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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bb atD;
    private TbImageView axS;
    private TextView axT;
    private TextView axU;
    private ForumLikeBotton axV;
    private com.baidu.tbadk.core.view.commonLike.forum.a axW;
    private View.OnClickListener axX;
    private View.OnClickListener axz;
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
        this.axX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.atD != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.atD.wL() != null ? ThreadForumUserInfoLayout.this.atD.wL().getForumName() : ThreadForumUserInfoLayout.this.atD.vq(), o.uY())));
                    if (ThreadForumUserInfoLayout.this.axz != null) {
                        ThreadForumUserInfoLayout.this.axz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.axS = (TbImageView) inflate.findViewById(d.g.forum_avatar);
        this.axT = (TextView) inflate.findViewById(d.g.forum_name);
        this.axT.setOnClickListener(this.axX);
        this.axU = (TextView) inflate.findViewById(d.g.user_name_and_reply_time);
        this.axV = (ForumLikeBotton) inflate.findViewById(d.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.axW = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.axV);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.axS != null) {
            this.axS.setDefaultResource(d.f.icon_default_ba_120);
            this.axS.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.axS.setOnClickListener(this.axX);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.atD = bbVar;
            a(bbVar.wL());
            b(bbVar.wL());
            i(bbVar);
            c(bbVar.wL());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.axS.setVisibility(4);
            return;
        }
        this.axS.setVisibility(0);
        this.axS.startLoad(ayVar.getAvatar(), 10, false);
        this.axS.setBorderColor(am.getColor(d.C0140d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.axT.setVisibility(4);
            return;
        }
        this.axT.setText(ap.e(ayVar.getForumName(), 14, "...") + getResources().getString(d.j.forum));
        this.axT.setVisibility(0);
    }

    public void i(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.atD.vk().getName_show())) {
            this.axU.setText(getContext().getString(d.j.user_name_and_publish, fp(this.atD.vk().getName_show())));
            this.axU.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.axV.setVisibility(8);
            return;
        }
        this.axW.a(ayVar);
        this.axV.setVisibility((!ayVar.getIsLike() || ayVar.uI()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axz = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.axW != null) {
            this.axW.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axS != null) {
            this.axS.setPageId(bdUniqueId);
        }
        if (this.axW != null) {
            this.axW.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.axT, d.C0140d.cp_cont_f);
            am.h(this.axU, d.C0140d.cp_cont_d);
        }
    }

    protected String fp(String str) {
        return ap.e(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.axS;
    }

    public TextView getUserName() {
        return this.axU;
    }

    public TextView getForumName() {
        return this.axT;
    }

    public ForumLikeBotton getLikeButton() {
        return this.axV;
    }
}
