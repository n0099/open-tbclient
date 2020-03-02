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
    private View.OnClickListener dhJ;
    private TbImageView dib;
    private TextView dic;
    private TextView die;
    private ForumLikeBotton dif;
    private com.baidu.tbadk.core.view.commonLike.forum.a dig;
    private View.OnClickListener dih;
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
        this.dih = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.KJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.KJ.aDX() != null ? ThreadForumUserInfoLayout.this.KJ.aDX().getForumName() : ThreadForumUserInfoLayout.this.KJ.aCt(), com.baidu.tieba.card.l.aCa())));
                    if (ThreadForumUserInfoLayout.this.dhJ != null) {
                        ThreadForumUserInfoLayout.this.dhJ.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dib = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.dic = (TextView) inflate.findViewById(R.id.forum_name);
        this.dic.setOnClickListener(this.dih);
        this.die = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.dif = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dig = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.dif);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dib != null) {
            this.dib.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dib.setOnClickListener(this.dih);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.KJ = bjVar;
            b(bjVar.aDX());
            c(bjVar.aDX());
            F(bjVar);
            d(bjVar.aDX());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.dib.setVisibility(4);
            return;
        }
        this.dib.setVisibility(0);
        this.dib.startLoad(bfVar.getAvatar(), 10, false);
        this.dib.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.dic.setVisibility(4);
            return;
        }
        this.dic.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dic.setVisibility(0);
    }

    public void F(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCo().getName_show())) {
            this.die.setText(getContext().getString(R.string.user_name_and_publish, tY(this.KJ.aCo().getName_show())));
            this.die.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.dif.setVisibility(8);
            return;
        }
        this.dig.a(bfVar);
        this.dif.setVisibility((!bfVar.getIsLike() || bfVar.aBE()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhJ = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dig != null) {
            this.dig.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dib != null) {
            this.dib.setPageId(bdUniqueId);
        }
        if (this.dig != null) {
            this.dig.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dib;
    }

    public TextView getUserName() {
        return this.die;
    }

    public TextView getForumName() {
        return this.dic;
    }

    public ForumLikeBotton getLikeButton() {
        return this.dif;
    }
}
