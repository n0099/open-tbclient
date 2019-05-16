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
    private bg VK;
    private View.OnClickListener bZt;
    private TbImageView caS;
    private TextView caT;
    private TextView caU;
    private ForumLikeBotton caV;
    private com.baidu.tbadk.core.view.commonLike.forum.a caW;
    private View.OnClickListener caX;
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
        this.caX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.VK != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.VK.afi() != null ? ThreadForumUserInfoLayout.this.VK.afi().getForumName() : ThreadForumUserInfoLayout.this.VK.adA(), com.baidu.tieba.card.n.adi())));
                    if (ThreadForumUserInfoLayout.this.bZt != null) {
                        ThreadForumUserInfoLayout.this.bZt.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.caS = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.caT = (TextView) inflate.findViewById(R.id.forum_name);
        this.caT.setOnClickListener(this.caX);
        this.caU = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.caV = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.caW = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.caV);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.caS != null) {
            this.caS.setDefaultResource(R.drawable.icon_default_ba_120);
            this.caS.setDefaultBgResource(R.color.cp_bg_line_e);
            this.caS.setOnClickListener(this.caX);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.VK = bgVar;
            a(bgVar.afi());
            b(bgVar.afi());
            y(bgVar);
            c(bgVar.afi());
        }
    }

    private void a(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAvatar())) {
            this.caS.setVisibility(4);
            return;
        }
        this.caS.setVisibility(0);
        this.caS.startLoad(bcVar.getAvatar(), 10, false);
        this.caS.setBorderColor(al.getColor(R.color.black_alpha15));
    }

    public void b(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getForumName())) {
            this.caT.setVisibility(4);
            return;
        }
        this.caT.setText(ap.j(bcVar.getForumName(), 14, "...") + getResources().getString(R.string.forum));
        this.caT.setVisibility(0);
    }

    public void y(bg bgVar) {
        if (bgVar != null && !StringUtils.isNull(this.VK.adv().getName_show())) {
            this.caU.setText(getContext().getString(R.string.user_name_and_publish, oD(this.VK.adv().getName_show())));
            this.caU.setVisibility(0);
        }
    }

    public void c(bc bcVar) {
        int i = 8;
        if (bcVar == null) {
            this.caV.setVisibility(8);
            return;
        }
        this.caW.a(bcVar);
        this.caV.setVisibility((!bcVar.getIsLike() || bcVar.acK()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZt = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.caW != null) {
            this.caW.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caS != null) {
            this.caS.setPageId(bdUniqueId);
        }
        if (this.caW != null) {
            this.caW.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.caT, R.color.cp_cont_f);
            al.j(this.caU, R.color.cp_cont_d);
        }
    }

    protected String oD(String str) {
        return ap.j(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.caS;
    }

    public TextView getUserName() {
        return this.caU;
    }

    public TextView getForumName() {
        return this.caT;
    }

    public ForumLikeBotton getLikeButton() {
        return this.caV;
    }
}
