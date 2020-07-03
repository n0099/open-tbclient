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
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bu aeK;
    private View.OnClickListener edU;
    private TbImageView eem;
    private TextView een;
    private TextView eeo;
    private ForumLikeBotton eep;
    private com.baidu.tbadk.core.view.commonLike.forum.a eeq;
    private View.OnClickListener eer;
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
        this.eer = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aeK != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aeK.aUd() != null ? ThreadForumUserInfoLayout.this.aeK.aUd().getForumName() : ThreadForumUserInfoLayout.this.aeK.aSt(), m.aSb())));
                    if (ThreadForumUserInfoLayout.this.edU != null) {
                        ThreadForumUserInfoLayout.this.edU.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eem = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.een = (TextView) inflate.findViewById(R.id.forum_name);
        this.een.setOnClickListener(this.eer);
        this.eeo = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.eep = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.eeq = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.eep);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eem != null) {
            this.eem.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eem.setOnClickListener(this.eer);
        }
    }

    public void setData(bu buVar) {
        if (buVar != null) {
            this.aeK = buVar;
            b(buVar.aUd());
            c(buVar.aUd());
            H(buVar);
            d(buVar.aUd());
        }
    }

    private void b(bq bqVar) {
        if (bqVar == null || StringUtils.isNull(bqVar.getAvatar())) {
            this.eem.setVisibility(4);
            return;
        }
        this.eem.setVisibility(0);
        this.eem.startLoad(bqVar.getAvatar(), 10, false);
        this.eem.setBorderColor(an.getColor(R.color.black_alpha15));
    }

    public void c(bq bqVar) {
        if (bqVar == null || StringUtils.isNull(bqVar.getForumName())) {
            this.een.setVisibility(4);
            return;
        }
        this.een.setText(ar.cutChineseAndEnglishWithSuffix(bqVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.een.setVisibility(0);
    }

    public void H(bu buVar) {
        if (buVar != null && !StringUtils.isNull(this.aeK.aSp().getName_show())) {
            this.eeo.setText(getContext().getString(R.string.user_name_and_publish, xm(this.aeK.aSp().getName_show())));
            this.eeo.setVisibility(0);
        }
    }

    public void d(bq bqVar) {
        int i = 8;
        if (bqVar == null) {
            this.eep.setVisibility(8);
            return;
        }
        this.eeq.a(bqVar);
        this.eep.setVisibility((!bqVar.getIsLike() || bqVar.aRE()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.edU = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.eeq != null) {
            this.eeq.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eem != null) {
            this.eem.setPageId(bdUniqueId);
        }
        if (this.eeq != null) {
            this.eeq.setPageUniqueId(bdUniqueId);
        }
    }

    protected String xm(String str) {
        return ar.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eem;
    }

    public TextView getUserName() {
        return this.eeo;
    }

    public TextView getForumName() {
        return this.een;
    }

    public ForumLikeBotton getLikeButton() {
        return this.eep;
    }
}
