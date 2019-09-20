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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bh Wd;
    private View.OnClickListener cbv;
    private TbImageView ccW;
    private TextView ccX;
    private TextView ccY;
    private ForumLikeBotton ccZ;
    private com.baidu.tbadk.core.view.commonLike.forum.a cda;
    private View.OnClickListener cdb;
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
        this.cdb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.Wd != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.Wd.agp() != null ? ThreadForumUserInfoLayout.this.Wd.agp().getForumName() : ThreadForumUserInfoLayout.this.Wd.aeH(), com.baidu.tieba.card.n.aep())));
                    if (ThreadForumUserInfoLayout.this.cbv != null) {
                        ThreadForumUserInfoLayout.this.cbv.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ccW = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ccX = (TextView) inflate.findViewById(R.id.forum_name);
        this.ccX.setOnClickListener(this.cdb);
        this.ccY = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ccZ = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.cda = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ccZ);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ccW != null) {
            this.ccW.setDefaultResource(R.drawable.icon_default_ba_120);
            this.ccW.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ccW.setOnClickListener(this.cdb);
        }
    }

    public void setData(bh bhVar) {
        if (bhVar != null) {
            this.Wd = bhVar;
            a(bhVar.agp());
            b(bhVar.agp());
            A(bhVar);
            c(bhVar.agp());
        }
    }

    private void a(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAvatar())) {
            this.ccW.setVisibility(4);
            return;
        }
        this.ccW.setVisibility(0);
        this.ccW.startLoad(bdVar.getAvatar(), 10, false);
        this.ccW.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void b(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.ccX.setVisibility(4);
            return;
        }
        this.ccX.setText(aq.j(bdVar.getForumName(), 14, "...") + getResources().getString(R.string.forum));
        this.ccX.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.Wd.aeC().getName_show())) {
            this.ccY.setText(getContext().getString(R.string.user_name_and_publish, pb(this.Wd.aeC().getName_show())));
            this.ccY.setVisibility(0);
        }
    }

    public void c(bd bdVar) {
        int i = 8;
        if (bdVar == null) {
            this.ccZ.setVisibility(8);
            return;
        }
        this.cda.a(bdVar);
        this.ccZ.setVisibility((!bdVar.getIsLike() || bdVar.adR()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbv = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.cda != null) {
            this.cda.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ccW != null) {
            this.ccW.setPageId(bdUniqueId);
        }
        if (this.cda != null) {
            this.cda.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.ccX, R.color.cp_cont_f);
            am.j(this.ccY, R.color.cp_cont_d);
        }
    }

    protected String pb(String str) {
        return aq.j(str, 14, "...");
    }

    public TbImageView getHeaderImg() {
        return this.ccW;
    }

    public TextView getUserName() {
        return this.ccY;
    }

    public TextView getForumName() {
        return this.ccX;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ccZ;
    }
}
