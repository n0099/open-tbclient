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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private by ahA;
    private TextView fdA;
    private ForumLikeBotton fdB;
    private com.baidu.tbadk.core.view.commonLike.forum.a fdC;
    private View.OnClickListener fdD;
    private View.OnClickListener fdj;
    private TbImageView fdy;
    private TextView fdz;
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
        this.fdD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.ahA != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.ahA.bqF() != null ? ThreadForumUserInfoLayout.this.ahA.bqF().getForumName() : ThreadForumUserInfoLayout.this.ahA.boT(), n.boB())));
                    if (ThreadForumUserInfoLayout.this.fdj != null) {
                        ThreadForumUserInfoLayout.this.fdj.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.fdy = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.fdz = (TextView) inflate.findViewById(R.id.forum_name);
        this.fdz.setOnClickListener(this.fdD);
        this.fdA = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.fdB = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.fdC = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.fdB);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.fdy != null) {
            this.fdy.setDefaultBgResource(R.color.CAM_X0205);
            this.fdy.setOnClickListener(this.fdD);
        }
    }

    public void setData(by byVar) {
        if (byVar != null) {
            this.ahA = byVar;
            a(byVar.bqF());
            b(byVar.bqF());
            H(byVar);
            c(byVar.bqF());
        }
    }

    private void a(bu buVar) {
        if (buVar == null || StringUtils.isNull(buVar.getAvatar())) {
            this.fdy.setVisibility(4);
            return;
        }
        this.fdy.setVisibility(0);
        this.fdy.startLoad(buVar.getAvatar(), 10, false);
        this.fdy.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bu buVar) {
        if (buVar == null || StringUtils.isNull(buVar.getForumName())) {
            this.fdz.setVisibility(4);
            return;
        }
        this.fdz.setText(au.cutChineseAndEnglishWithSuffix(buVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.fdz.setVisibility(0);
    }

    public void H(by byVar) {
        if (byVar != null && !StringUtils.isNull(this.ahA.boP().getName_show())) {
            this.fdA.setText(getContext().getString(R.string.user_name_and_publish, CC(this.ahA.boP().getName_show())));
            this.fdA.setVisibility(0);
        }
    }

    public void c(bu buVar) {
        int i = 8;
        if (buVar == null) {
            this.fdB.setVisibility(8);
            return;
        }
        this.fdC.a(buVar);
        this.fdB.setVisibility((!buVar.getIsLike() || buVar.boe()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fdj = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.fdC != null) {
            this.fdC.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fdy != null) {
            this.fdy.setPageId(bdUniqueId);
        }
        if (this.fdC != null) {
            this.fdC.setPageUniqueId(bdUniqueId);
        }
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.fdy;
    }

    public TextView getUserName() {
        return this.fdA;
    }

    public TextView getForumName() {
        return this.fdz;
    }

    public ForumLikeBotton getLikeButton() {
        return this.fdB;
    }
}
