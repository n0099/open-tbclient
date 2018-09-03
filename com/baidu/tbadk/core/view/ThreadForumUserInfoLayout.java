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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bb atE;
    private TbImageView axP;
    private TextView axQ;
    private TextView axR;
    private ForumLikeBotton axS;
    private com.baidu.tbadk.core.view.commonLike.forum.a axT;
    private View.OnClickListener axU;
    private View.OnClickListener axw;
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
        this.axU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.atE != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.atE.wK() != null ? ThreadForumUserInfoLayout.this.atE.wK().getForumName() : ThreadForumUserInfoLayout.this.atE.vp(), o.uX())));
                    if (ThreadForumUserInfoLayout.this.axw != null) {
                        ThreadForumUserInfoLayout.this.axw.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.h.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.axP = (TbImageView) inflate.findViewById(f.g.forum_avatar);
        this.axQ = (TextView) inflate.findViewById(f.g.forum_name);
        this.axQ.setOnClickListener(this.axU);
        this.axR = (TextView) inflate.findViewById(f.g.user_name_and_reply_time);
        this.axS = (ForumLikeBotton) inflate.findViewById(f.g.like_button);
        if (context instanceof TbPageContextSupport) {
            this.axT = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.axS);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.axP != null) {
            this.axP.setDefaultResource(f.C0146f.icon_default_ba_120);
            this.axP.setDefaultBgResource(f.d.cp_bg_line_e);
            this.axP.setOnClickListener(this.axU);
        }
    }

    public void setData(bb bbVar) {
        if (bbVar != null) {
            this.atE = bbVar;
            a(bbVar.wK());
            b(bbVar.wK());
            i(bbVar);
            c(bbVar.wK());
        }
    }

    private void a(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getAvatar())) {
            this.axP.setVisibility(4);
            return;
        }
        this.axP.setVisibility(0);
        this.axP.startLoad(ayVar.getAvatar(), 10, false);
        this.axP.setBorderColor(am.getColor(f.d.black_alpha15));
    }

    public void b(ay ayVar) {
        if (ayVar == null || StringUtils.isNull(ayVar.getForumName())) {
            this.axQ.setVisibility(4);
            return;
        }
        this.axQ.setText(ap.d(ayVar.getForumName(), 14, "...") + getResources().getString(f.j.forum));
        this.axQ.setVisibility(0);
    }

    public void i(bb bbVar) {
        if (bbVar != null && !StringUtils.isNull(this.atE.vj().getName_show())) {
            this.axR.setText(getContext().getString(f.j.user_name_and_publish, fp(this.atE.vj().getName_show())));
            this.axR.setVisibility(0);
        }
    }

    public void c(ay ayVar) {
        int i = 8;
        if (ayVar == null) {
            this.axS.setVisibility(8);
            return;
        }
        this.axT.a(ayVar);
        this.axS.setVisibility((!ayVar.getIsLike() || ayVar.uH()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axw = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.axT != null) {
            this.axT.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axP != null) {
            this.axP.setPageId(bdUniqueId);
        }
        if (this.axT != null) {
            this.axT.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.axQ, f.d.cp_cont_f);
            am.h(this.axR, f.d.cp_cont_d);
        }
    }

    protected String fp(String str) {
        return ap.d(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.axP;
    }

    public TextView getUserName() {
        return this.axR;
    }

    public TextView getForumName() {
        return this.axQ;
    }

    public ForumLikeBotton getLikeButton() {
        return this.axS;
    }
}
