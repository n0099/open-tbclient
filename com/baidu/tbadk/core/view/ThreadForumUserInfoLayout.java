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
    private bj KJ;
    private TbImageView diE;
    private TextView diF;
    private TextView diG;
    private ForumLikeBotton diH;
    private com.baidu.tbadk.core.view.commonLike.forum.a diI;
    private View.OnClickListener diJ;
    private View.OnClickListener dik;
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
        this.diJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.KJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.KJ.aEb() != null ? ThreadForumUserInfoLayout.this.KJ.aEb().getForumName() : ThreadForumUserInfoLayout.this.KJ.aCw(), com.baidu.tieba.card.l.aCd())));
                    if (ThreadForumUserInfoLayout.this.dik != null) {
                        ThreadForumUserInfoLayout.this.dik.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.diE = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.diF = (TextView) inflate.findViewById(R.id.forum_name);
        this.diF.setOnClickListener(this.diJ);
        this.diG = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.diH = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.diI = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.diH);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.diE != null) {
            this.diE.setDefaultBgResource(R.color.cp_bg_line_e);
            this.diE.setOnClickListener(this.diJ);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.KJ = bjVar;
            b(bjVar.aEb());
            c(bjVar.aEb());
            G(bjVar);
            d(bjVar.aEb());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.diE.setVisibility(4);
            return;
        }
        this.diE.setVisibility(0);
        this.diE.startLoad(bfVar.getAvatar(), 10, false);
        this.diE.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.diF.setVisibility(4);
            return;
        }
        this.diF.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.diF.setVisibility(0);
    }

    public void G(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCr().getName_show())) {
            this.diG.setText(getContext().getString(R.string.user_name_and_publish, tZ(this.KJ.aCr().getName_show())));
            this.diG.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.diH.setVisibility(8);
            return;
        }
        this.diI.a(bfVar);
        this.diH.setVisibility((!bfVar.getIsLike() || bfVar.aBH()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dik = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.diI != null) {
            this.diI.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.diE != null) {
            this.diE.setPageId(bdUniqueId);
        }
        if (this.diI != null) {
            this.diI.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.diE;
    }

    public TextView getUserName() {
        return this.diG;
    }

    public TextView getForumName() {
        return this.diF;
    }

    public ForumLikeBotton getLikeButton() {
        return this.diH;
    }
}
