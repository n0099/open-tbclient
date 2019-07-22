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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bg We;
    private View.OnClickListener caw;
    private TbImageView cbV;
    private TextView cbW;
    private TextView cbX;
    private ForumLikeBotton cbY;
    private com.baidu.tbadk.core.view.commonLike.forum.a cbZ;
    private View.OnClickListener cca;
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
        this.cca = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.We != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.We.agk() != null ? ThreadForumUserInfoLayout.this.We.agk().getForumName() : ThreadForumUserInfoLayout.this.We.aeC(), com.baidu.tieba.card.n.aek())));
                    if (ThreadForumUserInfoLayout.this.caw != null) {
                        ThreadForumUserInfoLayout.this.caw.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.cbV = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.cbW = (TextView) inflate.findViewById(R.id.forum_name);
        this.cbW.setOnClickListener(this.cca);
        this.cbX = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.cbY = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.cbZ = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.cbY);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.cbV != null) {
            this.cbV.setDefaultResource(R.drawable.icon_default_ba_120);
            this.cbV.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cbV.setOnClickListener(this.cca);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.We = bgVar;
            a(bgVar.agk());
            b(bgVar.agk());
            y(bgVar);
            c(bgVar.agk());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.cbV.setVisibility(4);
            return;
        }
        this.cbV.setVisibility(0);
        this.cbV.startLoad(bcVar.getAvatar(), 10, false);
        this.cbV.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.cbW.setVisibility(4);
            return;
        }
        this.cbW.setText(aq.j(bcVar.getForumName(), 14, "...") + getResources().getString(R.string.forum));
        this.cbW.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.We.aex().getName_show())) {
            this.cbX.setText(getContext().getString(R.string.user_name_and_publish, oT(this.We.aex().getName_show())));
            this.cbX.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.cbY.setVisibility(8);
            return;
        }
        this.cbZ.a(bcVar);
        this.cbY.setVisibility((!bcVar.getIsLike() || bcVar.adM()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caw = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.cbZ != null) {
            this.cbZ.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbV != null) {
            this.cbV.setPageId(bdUniqueId);
        }
        if (this.cbZ != null) {
            this.cbZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.cbW, R.color.cp_cont_f);
            am.j(this.cbX, R.color.cp_cont_d);
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.cbV;
    }

    public TextView getUserName() {
        return this.cbX;
    }

    public TextView getForumName() {
        return this.cbW;
    }

    public ForumLikeBotton getLikeButton() {
        return this.cbY;
    }
}
