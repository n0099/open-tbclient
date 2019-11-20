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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bh Fs;
    private View.OnClickListener coV;
    private TbImageView cqs;
    private TextView cqt;
    private TextView cqu;
    private ForumLikeBotton cqv;
    private com.baidu.tbadk.core.view.commonLike.forum.a cqw;
    private View.OnClickListener cqx;
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
        this.cqx = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.Fs != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.Fs.akq() != null ? ThreadForumUserInfoLayout.this.Fs.akq().getForumName() : ThreadForumUserInfoLayout.this.Fs.aiJ(), com.baidu.tieba.card.n.air())));
                    if (ThreadForumUserInfoLayout.this.coV != null) {
                        ThreadForumUserInfoLayout.this.coV.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.cqs = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.cqt = (TextView) inflate.findViewById(R.id.forum_name);
        this.cqt.setOnClickListener(this.cqx);
        this.cqu = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.cqv = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.cqw = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.cqv);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.cqs != null) {
            this.cqs.setDefaultResource(R.drawable.icon_default_ba_120);
            this.cqs.setDefaultBgResource(R.color.cp_bg_line_e);
            this.cqs.setOnClickListener(this.cqx);
        }
    }

    public void setData(bh bhVar) {
        if (bhVar != null) {
            this.Fs = bhVar;
            a(bhVar.akq());
            b(bhVar.akq());
            A(bhVar);
            c(bhVar.akq());
        }
    }

    private void a(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAvatar())) {
            this.cqs.setVisibility(4);
            return;
        }
        this.cqs.setVisibility(0);
        this.cqs.startLoad(bdVar.getAvatar(), 10, false);
        this.cqs.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void b(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.cqt.setVisibility(4);
            return;
        }
        this.cqt.setText(aq.cutChineseAndEnglishWithSuffix(bdVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.cqt.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.Fs.aiE().getName_show())) {
            this.cqu.setText(getContext().getString(R.string.user_name_and_publish, oA(this.Fs.aiE().getName_show())));
            this.cqu.setVisibility(0);
        }
    }

    public void c(bd bdVar) {
        int i = 8;
        if (bdVar == null) {
            this.cqv.setVisibility(8);
            return;
        }
        this.cqw.a(bdVar);
        this.cqv.setVisibility((!bdVar.getIsLike() || bdVar.ahT()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.coV = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.cqw != null) {
            this.cqw.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cqs != null) {
            this.cqs.setPageId(bdUniqueId);
        }
        if (this.cqw != null) {
            this.cqw.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.cqt, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.cqu, (int) R.color.cp_cont_d);
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.cqs;
    }

    public TextView getUserName() {
        return this.cqu;
    }

    public TextView getForumName() {
        return this.cqt;
    }

    public ForumLikeBotton getLikeButton() {
        return this.cqv;
    }
}
