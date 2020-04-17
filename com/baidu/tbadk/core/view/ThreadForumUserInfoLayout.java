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
    private bj adG;
    private ForumLikeBotton dIA;
    private com.baidu.tbadk.core.view.commonLike.forum.a dIB;
    private View.OnClickListener dIC;
    private View.OnClickListener dIf;
    private TbImageView dIx;
    private TextView dIy;
    private TextView dIz;
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
        this.dIC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.adG != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.adG.aMp() != null ? ThreadForumUserInfoLayout.this.adG.aMp().getForumName() : ThreadForumUserInfoLayout.this.adG.aKJ(), com.baidu.tieba.card.l.aKq())));
                    if (ThreadForumUserInfoLayout.this.dIf != null) {
                        ThreadForumUserInfoLayout.this.dIf.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dIx = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.dIy = (TextView) inflate.findViewById(R.id.forum_name);
        this.dIy.setOnClickListener(this.dIC);
        this.dIz = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.dIA = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dIB = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.dIA);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dIx != null) {
            this.dIx.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dIx.setOnClickListener(this.dIC);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.adG = bjVar;
            b(bjVar.aMp());
            c(bjVar.aMp());
            G(bjVar);
            d(bjVar.aMp());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.dIx.setVisibility(4);
            return;
        }
        this.dIx.setVisibility(0);
        this.dIx.startLoad(bfVar.getAvatar(), 10, false);
        this.dIx.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.dIy.setVisibility(4);
            return;
        }
        this.dIy.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dIy.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.adG.aKE().getName_show())) {
            this.dIz.setText(getContext().getString(R.string.user_name_and_publish, vm(this.adG.aKE().getName_show())));
            this.dIz.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.dIA.setVisibility(8);
            return;
        }
        this.dIB.a(bfVar);
        this.dIA.setVisibility((!bfVar.getIsLike() || bfVar.aJU()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIf = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dIB != null) {
            this.dIB.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIx != null) {
            this.dIx.setPageId(bdUniqueId);
        }
        if (this.dIB != null) {
            this.dIB.setPageUniqueId(bdUniqueId);
        }
    }

    protected String vm(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dIx;
    }

    public TextView getUserName() {
        return this.dIz;
    }

    public TextView getForumName() {
        return this.dIy;
    }

    public ForumLikeBotton getLikeButton() {
        return this.dIA;
    }
}
