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
    private View.OnClickListener dhI;
    private TbImageView dia;
    private TextView dib;
    private TextView dic;
    private ForumLikeBotton die;
    private com.baidu.tbadk.core.view.commonLike.forum.a dif;
    private View.OnClickListener dig;
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
        this.dig = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.KJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.KJ.aDV() != null ? ThreadForumUserInfoLayout.this.KJ.aDV().getForumName() : ThreadForumUserInfoLayout.this.KJ.aCr(), com.baidu.tieba.card.l.aBY())));
                    if (ThreadForumUserInfoLayout.this.dhI != null) {
                        ThreadForumUserInfoLayout.this.dhI.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.dia = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.dib = (TextView) inflate.findViewById(R.id.forum_name);
        this.dib.setOnClickListener(this.dig);
        this.dic = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.die = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.dif = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.die);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.dia != null) {
            this.dia.setDefaultBgResource(R.color.cp_bg_line_e);
            this.dia.setOnClickListener(this.dig);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.KJ = bjVar;
            b(bjVar.aDV());
            c(bjVar.aDV());
            F(bjVar);
            d(bjVar.aDV());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.dia.setVisibility(4);
            return;
        }
        this.dia.setVisibility(0);
        this.dia.startLoad(bfVar.getAvatar(), 10, false);
        this.dia.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.dib.setVisibility(4);
            return;
        }
        this.dib.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.dib.setVisibility(0);
    }

    public void F(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.KJ.aCm().getName_show())) {
            this.dic.setText(getContext().getString(R.string.user_name_and_publish, tY(this.KJ.aCm().getName_show())));
            this.dic.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.die.setVisibility(8);
            return;
        }
        this.dif.a(bfVar);
        this.die.setVisibility((!bfVar.getIsLike() || bfVar.aBC()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhI = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.dif != null) {
            this.dif.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dia != null) {
            this.dia.setPageId(bdUniqueId);
        }
        if (this.dif != null) {
            this.dif.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.dia;
    }

    public TextView getUserName() {
        return this.dic;
    }

    public TextView getForumName() {
        return this.dib;
    }

    public ForumLikeBotton getLikeButton() {
        return this.die;
    }
}
