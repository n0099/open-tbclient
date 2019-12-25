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
    private bj Ki;
    private TbImageView ddM;
    private TextView ddN;
    private TextView ddO;
    private ForumLikeBotton ddP;
    private com.baidu.tbadk.core.view.commonLike.forum.a ddQ;
    private View.OnClickListener ddR;
    private View.OnClickListener ddt;
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
        this.ddR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.Ki != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.Ki.aBq() != null ? ThreadForumUserInfoLayout.this.Ki.aBq().getForumName() : ThreadForumUserInfoLayout.this.Ki.azJ(), com.baidu.tieba.card.l.azq())));
                    if (ThreadForumUserInfoLayout.this.ddt != null) {
                        ThreadForumUserInfoLayout.this.ddt.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ddM = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ddN = (TextView) inflate.findViewById(R.id.forum_name);
        this.ddN.setOnClickListener(this.ddR);
        this.ddO = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ddP = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.ddQ = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ddP);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ddM != null) {
            this.ddM.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ddM.setOnClickListener(this.ddR);
        }
    }

    public void setData(bj bjVar) {
        if (bjVar != null) {
            this.Ki = bjVar;
            b(bjVar.aBq());
            c(bjVar.aBq());
            E(bjVar);
            d(bjVar.aBq());
        }
    }

    private void b(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getAvatar())) {
            this.ddM.setVisibility(4);
            return;
        }
        this.ddM.setVisibility(0);
        this.ddM.startLoad(bfVar.getAvatar(), 10, false);
        this.ddM.setBorderColor(am.getColor(R.color.black_alpha15));
    }

    public void c(bf bfVar) {
        if (bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.ddN.setVisibility(4);
            return;
        }
        this.ddN.setText(aq.cutChineseAndEnglishWithSuffix(bfVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ddN.setVisibility(0);
    }

    public void E(bj bjVar) {
        if (bjVar != null && !StringUtils.isNull(this.Ki.azE().getName_show())) {
            this.ddO.setText(getContext().getString(R.string.user_name_and_publish, tE(this.Ki.azE().getName_show())));
            this.ddO.setVisibility(0);
        }
    }

    public void d(bf bfVar) {
        int i = 8;
        if (bfVar == null) {
            this.ddP.setVisibility(8);
            return;
        }
        this.ddQ.a(bfVar);
        this.ddP.setVisibility((!bfVar.getIsLike() || bfVar.ayT()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddt = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.ddQ != null) {
            this.ddQ.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddM != null) {
            this.ddM.setPageId(bdUniqueId);
        }
        if (this.ddQ != null) {
            this.ddQ.setPageUniqueId(bdUniqueId);
        }
    }

    protected String tE(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.ddM;
    }

    public TextView getUserName() {
        return this.ddO;
    }

    public TextView getForumName() {
        return this.ddN;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ddP;
    }
}
