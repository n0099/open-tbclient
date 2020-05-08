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
    private bj adJ;
    private TbImageView dIB;
    private TextView dIC;
    private TextView dID;
    private ForumLikeBotton dIE;
    private com.baidu.tbadk.core.view.commonLike.forum.a dIF;
    private View.OnClickListener dIG;
    private View.OnClickListener dIj;
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
        this.dIG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.adJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.adJ.aMn() != null ? ThreadForumUserInfoLayout.this.adJ.aMn().getForumName() : ThreadForumUserInfoLayout.this.adJ.aKH(), com.baidu.tieba.card.l.aKo())));
                    if (ThreadForumUserInfoLayout.this.dIj != null) {
                        ThreadForumUserInfoLayout.this.dIj.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dIB = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.dIC = (TextView) inflate.findViewById(R.id.forum_name);
        this.dIC.setOnClickListener(this.dIG);
        this.dID = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.dIE = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dIF = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.dIE);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dIB != null) {
            this.dIB.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dIB.setOnClickListener(this.dIG);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.adJ = bjVar;
            b(bjVar.aMn());
            c(bjVar.aMn());
            G(bjVar);
            d(bjVar.aMn());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.dIB.setVisibility(4);
            return;
        }
        this.dIB.setVisibility(0);
        this.dIB.startLoad(bfVar.getAvatar(), 10, false);
        this.dIB.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.dIC.setVisibility(4);
            return;
        }
        this.dIC.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dIC.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.adJ.aKC().getName_show())) {
            this.dID.setText(getContext().getString(R.string.user_name_and_publish, vp(this.adJ.aKC().getName_show())));
            this.dID.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.dIE.setVisibility(8);
            return;
        }
        this.dIF.a(bfVar);
        this.dIE.setVisibility((!bfVar.getIsLike() || bfVar.aJS()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIj = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dIF != null) {
            this.dIF.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIB != null) {
            this.dIB.setPageId(bdUniqueId);
        }
        if (this.dIF != null) {
            this.dIF.setPageUniqueId(bdUniqueId);
        }
    }

    protected String vp(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dIB;
    }

    public TextView getUserName() {
        return this.dID;
    }

    public TextView getForumName() {
        return this.dIC;
    }

    public ForumLikeBotton getLikeButton() {
        return this.dIE;
    }
}
