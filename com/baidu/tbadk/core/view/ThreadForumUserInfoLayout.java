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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private cb ahi;
    private TbImageView fkP;
    private TextView fkQ;
    private TextView fkR;
    private ForumLikeBotton fkS;
    private com.baidu.tbadk.core.view.commonLike.forum.a fkT;
    private View.OnClickListener fkU;
    private View.OnClickListener fkz;
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
        this.fkU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.ahi != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.ahi.bpG() != null ? ThreadForumUserInfoLayout.this.ahi.bpG().getForumName() : ThreadForumUserInfoLayout.this.ahi.bnU(), m.bnC())));
                    if (ThreadForumUserInfoLayout.this.fkz != null) {
                        ThreadForumUserInfoLayout.this.fkz.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.fkP = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.fkQ = (TextView) inflate.findViewById(R.id.forum_name);
        this.fkQ.setOnClickListener(this.fkU);
        this.fkR = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.fkS = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.fkT = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.fkS);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.fkP != null) {
            this.fkP.setDefaultBgResource(R.color.CAM_X0205);
            this.fkP.setOnClickListener(this.fkU);
        }
    }

    public void setData(cb cbVar) {
        if (cbVar != null) {
            this.ahi = cbVar;
            a(cbVar.bpG());
            b(cbVar.bpG());
            I(cbVar);
            c(cbVar.bpG());
        }
    }

    private void a(bx bxVar) {
        if (bxVar == null || StringUtils.isNull(bxVar.getAvatar())) {
            this.fkP.setVisibility(4);
            return;
        }
        this.fkP.setVisibility(0);
        this.fkP.startLoad(bxVar.getAvatar(), 10, false);
        this.fkP.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bx bxVar) {
        if (bxVar == null || StringUtils.isNull(bxVar.getForumName())) {
            this.fkQ.setVisibility(4);
            return;
        }
        this.fkQ.setText(au.cutChineseAndEnglishWithSuffix(bxVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.fkQ.setVisibility(0);
    }

    public void I(cb cbVar) {
        if (cbVar != null && !StringUtils.isNull(this.ahi.bnQ().getName_show())) {
            this.fkR.setText(getContext().getString(R.string.user_name_and_publish, BF(this.ahi.bnQ().getName_show())));
            this.fkR.setVisibility(0);
        }
    }

    public void c(bx bxVar) {
        int i = 8;
        if (bxVar == null) {
            this.fkS.setVisibility(8);
            return;
        }
        this.fkT.a(bxVar);
        this.fkS.setVisibility((!bxVar.getIsLike() || bxVar.bnf()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fkz = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.fkT != null) {
            this.fkT.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fkP != null) {
            this.fkP.setPageId(bdUniqueId);
        }
        if (this.fkT != null) {
            this.fkT.setPageUniqueId(bdUniqueId);
        }
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.fkP;
    }

    public TextView getUserName() {
        return this.fkR;
    }

    public TextView getForumName() {
        return this.fkQ;
    }

    public ForumLikeBotton getLikeButton() {
        return this.fkS;
    }
}
