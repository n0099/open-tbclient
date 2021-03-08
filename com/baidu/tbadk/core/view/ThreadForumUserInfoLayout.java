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
    private cb aiB;
    private View.OnClickListener flY;
    private TbImageView fmo;
    private TextView fmq;
    private TextView fmr;
    private ForumLikeBotton fms;
    private com.baidu.tbadk.core.view.commonLike.forum.a fmt;
    private View.OnClickListener fmu;
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
        this.fmu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aiB != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aiB.bpI() != null ? ThreadForumUserInfoLayout.this.aiB.bpI().getForumName() : ThreadForumUserInfoLayout.this.aiB.bnW(), m.bnE())));
                    if (ThreadForumUserInfoLayout.this.flY != null) {
                        ThreadForumUserInfoLayout.this.flY.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.fmo = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.fmq = (TextView) inflate.findViewById(R.id.forum_name);
        this.fmq.setOnClickListener(this.fmu);
        this.fmr = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.fms = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.fmt = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.fms);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.fmo != null) {
            this.fmo.setDefaultBgResource(R.color.CAM_X0205);
            this.fmo.setOnClickListener(this.fmu);
        }
    }

    public void setData(cb cbVar) {
        if (cbVar != null) {
            this.aiB = cbVar;
            a(cbVar.bpI());
            b(cbVar.bpI());
            I(cbVar);
            c(cbVar.bpI());
        }
    }

    private void a(bx bxVar) {
        if (bxVar == null || StringUtils.isNull(bxVar.getAvatar())) {
            this.fmo.setVisibility(4);
            return;
        }
        this.fmo.setVisibility(0);
        this.fmo.startLoad(bxVar.getAvatar(), 10, false);
        this.fmo.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bx bxVar) {
        if (bxVar == null || StringUtils.isNull(bxVar.getForumName())) {
            this.fmq.setVisibility(4);
            return;
        }
        this.fmq.setText(au.cutChineseAndEnglishWithSuffix(bxVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.fmq.setVisibility(0);
    }

    public void I(cb cbVar) {
        if (cbVar != null && !StringUtils.isNull(this.aiB.bnS().getName_show())) {
            this.fmr.setText(getContext().getString(R.string.user_name_and_publish, BM(this.aiB.bnS().getName_show())));
            this.fmr.setVisibility(0);
        }
    }

    public void c(bx bxVar) {
        int i = 8;
        if (bxVar == null) {
            this.fms.setVisibility(8);
            return;
        }
        this.fmt.a(bxVar);
        this.fms.setVisibility((!bxVar.getIsLike() || bxVar.bnh()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.flY = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.fmt != null) {
            this.fmt.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fmo != null) {
            this.fmo.setPageId(bdUniqueId);
        }
        if (this.fmt != null) {
            this.fmt.setPageUniqueId(bdUniqueId);
        }
    }

    protected String BM(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.fmo;
    }

    public TextView getUserName() {
        return this.fmr;
    }

    public TextView getForumName() {
        return this.fmq;
    }

    public ForumLikeBotton getLikeButton() {
        return this.fms;
    }
}
