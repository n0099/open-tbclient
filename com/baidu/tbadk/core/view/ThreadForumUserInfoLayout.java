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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bw afJ;
    private View.OnClickListener etZ;
    private TbImageView eur;
    private TextView eus;
    private TextView eut;
    private ForumLikeBotton euu;
    private com.baidu.tbadk.core.view.commonLike.forum.a euv;
    private View.OnClickListener euw;
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
        this.euw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.afJ != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.afJ.bgs() != null ? ThreadForumUserInfoLayout.this.afJ.bgs().getForumName() : ThreadForumUserInfoLayout.this.afJ.beI(), m.beq())));
                    if (ThreadForumUserInfoLayout.this.etZ != null) {
                        ThreadForumUserInfoLayout.this.etZ.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eur = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.eus = (TextView) inflate.findViewById(R.id.forum_name);
        this.eus.setOnClickListener(this.euw);
        this.eut = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.euu = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.euv = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.euu);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eur != null) {
            this.eur.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eur.setOnClickListener(this.euw);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.afJ = bwVar;
            a(bwVar.bgs());
            b(bwVar.bgs());
            E(bwVar);
            c(bwVar.bgs());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.eur.setVisibility(4);
            return;
        }
        this.eur.setVisibility(0);
        this.eur.startLoad(bsVar.getAvatar(), 10, false);
        this.eur.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.eus.setVisibility(4);
            return;
        }
        this.eus.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.eus.setVisibility(0);
    }

    public void E(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.afJ.beE().getName_show())) {
            this.eut.setText(getContext().getString(R.string.user_name_and_publish, AF(this.afJ.beE().getName_show())));
            this.eut.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.euu.setVisibility(8);
            return;
        }
        this.euv.a(bsVar);
        this.euu.setVisibility((!bsVar.getIsLike() || bsVar.bdT()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.etZ = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.euv != null) {
            this.euv.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eur != null) {
            this.eur.setPageId(bdUniqueId);
        }
        if (this.euv != null) {
            this.euv.setPageUniqueId(bdUniqueId);
        }
    }

    protected String AF(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eur;
    }

    public TextView getUserName() {
        return this.eut;
    }

    public TextView getForumName() {
        return this.eus;
    }

    public ForumLikeBotton getLikeButton() {
        return this.euu;
    }
}
