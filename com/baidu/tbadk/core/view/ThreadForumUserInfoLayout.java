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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bx agB;
    private View.OnClickListener eVM;
    private TbImageView eWb;
    private TextView eWc;
    private TextView eWd;
    private ForumLikeBotton eWe;
    private com.baidu.tbadk.core.view.commonLike.forum.a eWf;
    private View.OnClickListener eWg;
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
        this.eWg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.agB != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.agB.bns() != null ? ThreadForumUserInfoLayout.this.agB.bns().getForumName() : ThreadForumUserInfoLayout.this.agB.blG(), n.blo())));
                    if (ThreadForumUserInfoLayout.this.eVM != null) {
                        ThreadForumUserInfoLayout.this.eVM.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eWb = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.eWc = (TextView) inflate.findViewById(R.id.forum_name);
        this.eWc.setOnClickListener(this.eWg);
        this.eWd = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.eWe = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.eWf = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.eWe);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eWb != null) {
            this.eWb.setDefaultBgResource(R.color.CAM_X0205);
            this.eWb.setOnClickListener(this.eWg);
        }
    }

    public void setData(bx bxVar) {
        if (bxVar != null) {
            this.agB = bxVar;
            a(bxVar.bns());
            b(bxVar.bns());
            H(bxVar);
            c(bxVar.bns());
        }
    }

    private void a(bt btVar) {
        if (btVar == null || StringUtils.isNull(btVar.getAvatar())) {
            this.eWb.setVisibility(4);
            return;
        }
        this.eWb.setVisibility(0);
        this.eWb.startLoad(btVar.getAvatar(), 10, false);
        this.eWb.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bt btVar) {
        if (btVar == null || StringUtils.isNull(btVar.getForumName())) {
            this.eWc.setVisibility(4);
            return;
        }
        this.eWc.setText(au.cutChineseAndEnglishWithSuffix(btVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.eWc.setVisibility(0);
    }

    public void H(bx bxVar) {
        if (bxVar != null && !StringUtils.isNull(this.agB.blC().getName_show())) {
            this.eWd.setText(getContext().getString(R.string.user_name_and_publish, BU(this.agB.blC().getName_show())));
            this.eWd.setVisibility(0);
        }
    }

    public void c(bt btVar) {
        int i = 8;
        if (btVar == null) {
            this.eWe.setVisibility(8);
            return;
        }
        this.eWf.a(btVar);
        this.eWe.setVisibility((!btVar.getIsLike() || btVar.bkR()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eVM = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.eWf != null) {
            this.eWf.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWb != null) {
            this.eWb.setPageId(bdUniqueId);
        }
        if (this.eWf != null) {
            this.eWf.setPageUniqueId(bdUniqueId);
        }
    }

    protected String BU(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eWb;
    }

    public TextView getUserName() {
        return this.eWd;
    }

    public TextView getForumName() {
        return this.eWc;
    }

    public ForumLikeBotton getLikeButton() {
        return this.eWe;
    }
}
