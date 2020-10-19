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
    private bw agw;
    private TbImageView eIJ;
    private TextView eIK;
    private TextView eIL;
    private ForumLikeBotton eIM;
    private com.baidu.tbadk.core.view.commonLike.forum.a eIN;
    private View.OnClickListener eIO;
    private View.OnClickListener eIr;
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
        this.eIO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.agw != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.agw.bjV() != null ? ThreadForumUserInfoLayout.this.agw.bjV().getForumName() : ThreadForumUserInfoLayout.this.agw.bil(), m.bhT())));
                    if (ThreadForumUserInfoLayout.this.eIr != null) {
                        ThreadForumUserInfoLayout.this.eIr.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eIJ = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.eIK = (TextView) inflate.findViewById(R.id.forum_name);
        this.eIK.setOnClickListener(this.eIO);
        this.eIL = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.eIM = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.eIN = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.eIM);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eIJ != null) {
            this.eIJ.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eIJ.setOnClickListener(this.eIO);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.agw = bwVar;
            a(bwVar.bjV());
            b(bwVar.bjV());
            F(bwVar);
            c(bwVar.bjV());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.eIJ.setVisibility(4);
            return;
        }
        this.eIJ.setVisibility(0);
        this.eIJ.startLoad(bsVar.getAvatar(), 10, false);
        this.eIJ.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.eIK.setVisibility(4);
            return;
        }
        this.eIK.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.eIK.setVisibility(0);
    }

    public void F(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.agw.bih().getName_show())) {
            this.eIL.setText(getContext().getString(R.string.user_name_and_publish, BO(this.agw.bih().getName_show())));
            this.eIL.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.eIM.setVisibility(8);
            return;
        }
        this.eIN.a(bsVar);
        this.eIM.setVisibility((!bsVar.getIsLike() || bsVar.bhw()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eIr = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.eIN != null) {
            this.eIN.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eIJ != null) {
            this.eIJ.setPageId(bdUniqueId);
        }
        if (this.eIN != null) {
            this.eIN.setPageUniqueId(bdUniqueId);
        }
    }

    protected String BO(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eIJ;
    }

    public TextView getUserName() {
        return this.eIL;
    }

    public TextView getForumName() {
        return this.eIK;
    }

    public ForumLikeBotton getLikeButton() {
        return this.eIM;
    }
}
