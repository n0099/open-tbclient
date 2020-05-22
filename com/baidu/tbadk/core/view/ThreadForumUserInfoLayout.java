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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bk aee;
    private TbImageView dWQ;
    private TextView dWR;
    private TextView dWS;
    private ForumLikeBotton dWT;
    private com.baidu.tbadk.core.view.commonLike.forum.a dWU;
    private View.OnClickListener dWV;
    private View.OnClickListener dWy;
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
        this.dWV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aee != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aee.aSm() != null ? ThreadForumUserInfoLayout.this.aee.aSm().getForumName() : ThreadForumUserInfoLayout.this.aee.aQC(), m.aQj())));
                    if (ThreadForumUserInfoLayout.this.dWy != null) {
                        ThreadForumUserInfoLayout.this.dWy.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dWQ = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.dWR = (TextView) inflate.findViewById(R.id.forum_name);
        this.dWR.setOnClickListener(this.dWV);
        this.dWS = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.dWT = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dWU = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.dWT);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dWQ != null) {
            this.dWQ.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dWQ.setOnClickListener(this.dWV);
        }
    }

    public void setData(bk bkVar) {
        if (bkVar != null) {
            this.aee = bkVar;
            b(bkVar.aSm());
            c(bkVar.aSm());
            H(bkVar);
            d(bkVar.aSm());
        }
    }

    private void b(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAvatar())) {
            this.dWQ.setVisibility(4);
            return;
        }
        this.dWQ.setVisibility(0);
        this.dWQ.startLoad(bgVar.getAvatar(), 10, false);
        this.dWQ.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getForumName())) {
            this.dWR.setVisibility(4);
            return;
        }
        this.dWR.setText(aq.cutChineseAndEnglishWithSuffix(bgVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dWR.setVisibility(0);
    }

    public void H(bk bkVar) {
        if (bkVar != null && !StringUtils.isNull(this.aee.aQx().getName_show())) {
            this.dWS.setText(getContext().getString(R.string.user_name_and_publish, wV(this.aee.aQx().getName_show())));
            this.dWS.setVisibility(0);
        }
    }

    public void d(bg bgVar) {
        int i = 8;
        if (bgVar == null) {
            this.dWT.setVisibility(8);
            return;
        }
        this.dWU.a(bgVar);
        this.dWT.setVisibility((!bgVar.getIsLike() || bgVar.aPN()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dWy = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dWU != null) {
            this.dWU.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dWQ != null) {
            this.dWQ.setPageId(bdUniqueId);
        }
        if (this.dWU != null) {
            this.dWU.setPageUniqueId(bdUniqueId);
        }
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dWQ;
    }

    public TextView getUserName() {
        return this.dWS;
    }

    public TextView getForumName() {
        return this.dWR;
    }

    public ForumLikeBotton getLikeButton() {
        return this.dWT;
    }
}
