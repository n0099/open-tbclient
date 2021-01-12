package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bz ahu;
    private TextView fiA;
    private ForumLikeBotton fiB;
    private com.baidu.tbadk.core.view.commonLike.forum.a fiC;
    private View.OnClickListener fiD;
    private View.OnClickListener fih;
    private TbImageView fiy;
    private TextView fiz;
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
        this.fiD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.ahu != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.ahu.bpo() != null ? ThreadForumUserInfoLayout.this.ahu.bpo().getForumName() : ThreadForumUserInfoLayout.this.ahu.bnB(), m.bnj())));
                    if (ThreadForumUserInfoLayout.this.fih != null) {
                        ThreadForumUserInfoLayout.this.fih.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.fiy = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.fiz = (TextView) inflate.findViewById(R.id.forum_name);
        this.fiz.setOnClickListener(this.fiD);
        this.fiA = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.fiB = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.fiC = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.fiB);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.fiy != null) {
            this.fiy.setDefaultBgResource(R.color.CAM_X0205);
            this.fiy.setOnClickListener(this.fiD);
        }
    }

    public void setData(bz bzVar) {
        if (bzVar != null) {
            this.ahu = bzVar;
            a(bzVar.bpo());
            b(bzVar.bpo());
            H(bzVar);
            c(bzVar.bpo());
        }
    }

    private void a(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.getAvatar())) {
            this.fiy.setVisibility(4);
            return;
        }
        this.fiy.setVisibility(0);
        this.fiy.startLoad(bvVar.getAvatar(), 10, false);
        this.fiy.setBorderColor(ao.getColor(R.color.black_alpha15));
    }

    public void b(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.getForumName())) {
            this.fiz.setVisibility(4);
            return;
        }
        this.fiz.setText(at.cutChineseAndEnglishWithSuffix(bvVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.fiz.setVisibility(0);
    }

    public void H(bz bzVar) {
        if (bzVar != null && !StringUtils.isNull(this.ahu.bnx().getName_show())) {
            this.fiA.setText(getContext().getString(R.string.user_name_and_publish, Bo(this.ahu.bnx().getName_show())));
            this.fiA.setVisibility(0);
        }
    }

    public void c(bv bvVar) {
        int i = 8;
        if (bvVar == null) {
            this.fiB.setVisibility(8);
            return;
        }
        this.fiC.a(bvVar);
        this.fiB.setVisibility((!bvVar.getIsLike() || bvVar.bmM()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fih = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.fiC != null) {
            this.fiC.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fiy != null) {
            this.fiy.setPageId(bdUniqueId);
        }
        if (this.fiC != null) {
            this.fiC.setPageUniqueId(bdUniqueId);
        }
    }

    protected String Bo(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.fiy;
    }

    public TextView getUserName() {
        return this.fiA;
    }

    public TextView getForumName() {
        return this.fiz;
    }

    public ForumLikeBotton getLikeButton() {
        return this.fiB;
    }
}
