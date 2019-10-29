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
    private bh FT;
    private View.OnClickListener cpN;
    private TbImageView crk;
    private TextView crl;
    private TextView crm;
    private ForumLikeBotton crn;
    private com.baidu.tbadk.core.view.commonLike.forum.a cro;
    private View.OnClickListener crp;
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
        this.crp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.FT != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.FT.aks() != null ? ThreadForumUserInfoLayout.this.FT.aks().getForumName() : ThreadForumUserInfoLayout.this.FT.aiL(), com.baidu.tieba.card.n.ait())));
                    if (ThreadForumUserInfoLayout.this.cpN != null) {
                        ThreadForumUserInfoLayout.this.cpN.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.crk = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.crl = (TextView) inflate.findViewById(R.id.forum_name);
        this.crl.setOnClickListener(this.crp);
        this.crm = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.crn = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.cro = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.crn);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.crk != null) {
            this.crk.setDefaultResource(R.drawable.icon_default_ba_120);
            this.crk.setDefaultBgResource(R.color.cp_bg_line_e);
            this.crk.setOnClickListener(this.crp);
        }
    }

    public void setData(bh bhVar) {
        if (bhVar != null) {
            this.FT = bhVar;
            a(bhVar.aks());
            b(bhVar.aks());
            A(bhVar);
            c(bhVar.aks());
        }
    }

    private void a(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAvatar())) {
            this.crk.setVisibility(4);
            return;
        }
        this.crk.setVisibility(0);
        this.crk.startLoad(bdVar.getAvatar(), 10, false);
        this.crk.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void b(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.crl.setVisibility(4);
            return;
        }
        this.crl.setText(aq.cutChineseAndEnglishWithSuffix(bdVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.crl.setVisibility(0);
    }

    public void A(bh bhVar) {
        if (bhVar != null && !StringUtils.isNull(this.FT.aiG().getName_show())) {
            this.crm.setText(getContext().getString(R.string.user_name_and_publish, oA(this.FT.aiG().getName_show())));
            this.crm.setVisibility(0);
        }
    }

    public void c(bd bdVar) {
        int i = 8;
        if (bdVar == null) {
            this.crn.setVisibility(8);
            return;
        }
        this.cro.a(bdVar);
        this.crn.setVisibility((!bdVar.getIsLike() || bdVar.ahV()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cpN = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.cro != null) {
            this.cro.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.crk != null) {
            this.crk.setPageId(bdUniqueId);
        }
        if (this.cro != null) {
            this.cro.setPageUniqueId(bdUniqueId);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.crl, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.crm, (int) R.color.cp_cont_d);
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.crk;
    }

    public TextView getUserName() {
        return this.crm;
    }

    public TextView getForumName() {
        return this.crl;
    }

    public ForumLikeBotton getLikeButton() {
        return this.crn;
    }
}
