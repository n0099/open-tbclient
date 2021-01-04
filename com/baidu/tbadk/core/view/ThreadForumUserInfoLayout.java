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
    private bz aim;
    private View.OnClickListener fmS;
    private TbImageView fnh;
    private TextView fni;
    private TextView fnj;
    private ForumLikeBotton fnk;
    private com.baidu.tbadk.core.view.commonLike.forum.a fnl;
    private View.OnClickListener fnm;
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
        this.fnm = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aim != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aim.bth() != null ? ThreadForumUserInfoLayout.this.aim.bth().getForumName() : ThreadForumUserInfoLayout.this.aim.bru(), m.brc())));
                    if (ThreadForumUserInfoLayout.this.fmS != null) {
                        ThreadForumUserInfoLayout.this.fmS.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.fnh = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.fni = (TextView) inflate.findViewById(R.id.forum_name);
        this.fni.setOnClickListener(this.fnm);
        this.fnj = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.fnk = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.fnl = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.fnk);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.fnh != null) {
            this.fnh.setDefaultBgResource(R.color.CAM_X0205);
            this.fnh.setOnClickListener(this.fnm);
        }
    }

    public void setData(bz bzVar) {
        if (bzVar != null) {
            this.aim = bzVar;
            a(bzVar.bth());
            b(bzVar.bth());
            H(bzVar);
            c(bzVar.bth());
        }
    }

    private void a(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.getAvatar())) {
            this.fnh.setVisibility(4);
            return;
        }
        this.fnh.setVisibility(0);
        this.fnh.startLoad(bvVar.getAvatar(), 10, false);
        this.fnh.setBorderColor(ao.getColor(R.color.black_alpha15));
    }

    public void b(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.getForumName())) {
            this.fni.setVisibility(4);
            return;
        }
        this.fni.setText(at.cutChineseAndEnglishWithSuffix(bvVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.fni.setVisibility(0);
    }

    public void H(bz bzVar) {
        if (bzVar != null && !StringUtils.isNull(this.aim.brq().getName_show())) {
            this.fnj.setText(getContext().getString(R.string.user_name_and_publish, CA(this.aim.brq().getName_show())));
            this.fnj.setVisibility(0);
        }
    }

    public void c(bv bvVar) {
        int i = 8;
        if (bvVar == null) {
            this.fnk.setVisibility(8);
            return;
        }
        this.fnl.a(bvVar);
        this.fnk.setVisibility((!bvVar.getIsLike() || bvVar.bqF()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fmS = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.fnl != null) {
            this.fnl.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fnh != null) {
            this.fnh.setPageId(bdUniqueId);
        }
        if (this.fnl != null) {
            this.fnl.setPageUniqueId(bdUniqueId);
        }
    }

    protected String CA(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.fnh;
    }

    public TextView getUserName() {
        return this.fnj;
    }

    public TextView getForumName() {
        return this.fni;
    }

    public ForumLikeBotton getLikeButton() {
        return this.fnk;
    }
}
