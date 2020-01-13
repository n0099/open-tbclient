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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bj Kn;
    private View.OnClickListener ddE;
    private TbImageView ddW;
    private TextView ddX;
    private TextView ddY;
    private ForumLikeBotton ddZ;
    private com.baidu.tbadk.core.view.commonLike.forum.a dea;
    private View.OnClickListener deb;
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
        this.deb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.Kn != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.Kn.aBJ() != null ? ThreadForumUserInfoLayout.this.Kn.aBJ().getForumName() : ThreadForumUserInfoLayout.this.Kn.aAc(), com.baidu.tieba.card.l.azJ())));
                    if (ThreadForumUserInfoLayout.this.ddE != null) {
                        ThreadForumUserInfoLayout.this.ddE.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ddW = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ddX = (TextView) inflate.findViewById(R.id.forum_name);
        this.ddX.setOnClickListener(this.deb);
        this.ddY = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ddZ = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dea = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ddZ);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ddW != null) {
            this.ddW.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ddW.setOnClickListener(this.deb);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.Kn = bjVar;
            b(bjVar.aBJ());
            c(bjVar.aBJ());
            E(bjVar);
            d(bjVar.aBJ());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.ddW.setVisibility(4);
            return;
        }
        this.ddW.setVisibility(0);
        this.ddW.startLoad(bfVar.getAvatar(), 10, false);
        this.ddW.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.ddX.setVisibility(4);
            return;
        }
        this.ddX.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ddX.setVisibility(0);
    }

    public void E(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.Kn.azX().getName_show())) {
            this.ddY.setText(getContext().getString(R.string.user_name_and_publish, tI(this.Kn.azX().getName_show())));
            this.ddY.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.ddZ.setVisibility(8);
            return;
        }
        this.dea.a(bfVar);
        this.ddZ.setVisibility((!bfVar.getIsLike() || bfVar.azm()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddE = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dea != null) {
            this.dea.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddW != null) {
            this.ddW.setPageId(bdUniqueId);
        }
        if (this.dea != null) {
            this.dea.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tI(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.ddW;
    }

    public TextView getUserName() {
        return this.ddY;
    }

    public TextView getForumName() {
        return this.ddX;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ddZ;
    }
}
