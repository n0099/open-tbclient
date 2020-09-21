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
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bw agf;
    private TextView ewA;
    private TextView ewB;
    private ForumLikeBotton ewC;
    private com.baidu.tbadk.core.view.commonLike.forum.a ewD;
    private View.OnClickListener ewE;
    private View.OnClickListener ewh;
    private TbImageView ewz;
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
        this.ewE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.agf != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.agf.bhm() != null ? ThreadForumUserInfoLayout.this.agf.bhm().getForumName() : ThreadForumUserInfoLayout.this.agf.bfC(), m.bfk())));
                    if (ThreadForumUserInfoLayout.this.ewh != null) {
                        ThreadForumUserInfoLayout.this.ewh.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ewz = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ewA = (TextView) inflate.findViewById(R.id.forum_name);
        this.ewA.setOnClickListener(this.ewE);
        this.ewB = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ewC = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.ewD = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ewC);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ewz != null) {
            this.ewz.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ewz.setOnClickListener(this.ewE);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.agf = bwVar;
            a(bwVar.bhm());
            b(bwVar.bhm());
            F(bwVar);
            c(bwVar.bhm());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.ewz.setVisibility(4);
            return;
        }
        this.ewz.setVisibility(0);
        this.ewz.startLoad(bsVar.getAvatar(), 10, false);
        this.ewz.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.ewA.setVisibility(4);
            return;
        }
        this.ewA.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ewA.setVisibility(0);
    }

    public void F(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.agf.bfy().getName_show())) {
            this.ewB.setText(getContext().getString(R.string.user_name_and_publish, Bc(this.agf.bfy().getName_show())));
            this.ewB.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.ewC.setVisibility(8);
            return;
        }
        this.ewD.a(bsVar);
        this.ewC.setVisibility((!bsVar.getIsLike() || bsVar.beN()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ewh = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.ewD != null) {
            this.ewD.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ewz != null) {
            this.ewz.setPageId(bdUniqueId);
        }
        if (this.ewD != null) {
            this.ewD.setPageUniqueId(bdUniqueId);
        }
    }

    protected String Bc(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.ewz;
    }

    public TextView getUserName() {
        return this.ewB;
    }

    public TextView getForumName() {
        return this.ewA;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ewC;
    }
}
