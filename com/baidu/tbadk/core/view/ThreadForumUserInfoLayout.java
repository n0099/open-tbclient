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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bg VJ;
    private View.OnClickListener bZu;
    private TbImageView caT;
    private TextView caU;
    private TextView caV;
    private ForumLikeBotton caW;
    private com.baidu.tbadk.core.view.commonLike.forum.a caX;
    private View.OnClickListener caY;
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
        this.caY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.VJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.VJ.afi() != null ? ThreadForumUserInfoLayout.this.VJ.afi().getForumName() : ThreadForumUserInfoLayout.this.VJ.adA(), com.baidu.tieba.card.n.adi())));
                    if (ThreadForumUserInfoLayout.this.bZu != null) {
                        ThreadForumUserInfoLayout.this.bZu.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.caT = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.caU = (TextView) inflate.findViewById(R.id.forum_name);
        this.caU.setOnClickListener(this.caY);
        this.caV = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.caW = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.caX = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.caW);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.caT != null) {
            this.caT.setDefaultResource(R.drawable.icon_default_ba_120);
            this.caT.setDefaultBgResource(R.color.cp_bg_line_e);
            this.caT.setOnClickListener(this.caY);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.VJ = bgVar;
            a(bgVar.afi());
            b(bgVar.afi());
            y(bgVar);
            c(bgVar.afi());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.caT.setVisibility(4);
            return;
        }
        this.caT.setVisibility(0);
        this.caT.startLoad(bcVar.getAvatar(), 10, false);
        this.caT.setBorderColor(al.getColor(R.color.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.caU.setVisibility(4);
            return;
        }
        this.caU.setText(ap.j(bcVar.getForumName(), 14, "...") + getResources().getString(R.string.forum));
        this.caU.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.VJ.adv().getName_show())) {
            this.caV.setText(getContext().getString(R.string.user_name_and_publish, oC(this.VJ.adv().getName_show())));
            this.caV.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.caW.setVisibility(8);
            return;
        }
        this.caX.a(bcVar);
        this.caW.setVisibility((!bcVar.getIsLike() || bcVar.acK()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZu = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.caX != null) {
            this.caX.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caT != null) {
            this.caT.setPageId(bdUniqueId);
        }
        if (this.caX != null) {
            this.caX.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.caU, R.color.cp_cont_f);
            al.j(this.caV, R.color.cp_cont_d);
        }
    }

    protected String oC(String str) {
        return ap.j(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.caT;
    }

    public TextView getUserName() {
        return this.caV;
    }

    public TextView getForumName() {
        return this.caU;
    }

    public ForumLikeBotton getLikeButton() {
        return this.caW;
    }
}
