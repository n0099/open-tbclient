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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bv aeA;
    private com.baidu.tbadk.core.view.commonLike.forum.a ekA;
    private View.OnClickListener ekB;
    private View.OnClickListener eke;
    private TbImageView ekw;
    private TextView ekx;
    private TextView eky;
    private ForumLikeBotton ekz;
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
        this.ekB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.aeA != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.aeA.aXZ() != null ? ThreadForumUserInfoLayout.this.aeA.aXZ().getForumName() : ThreadForumUserInfoLayout.this.aeA.aWp(), m.aVX())));
                    if (ThreadForumUserInfoLayout.this.eke != null) {
                        ThreadForumUserInfoLayout.this.eke.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.ekw = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.ekx = (TextView) inflate.findViewById(R.id.forum_name);
        this.ekx.setOnClickListener(this.ekB);
        this.eky = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.ekz = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.ekA = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.ekz);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.ekw != null) {
            this.ekw.setDefaultBgResource(R.color.cp_bg_line_e);
            this.ekw.setOnClickListener(this.ekB);
        }
    }

    public void setData(bv bvVar) {
        if (bvVar != null) {
            this.aeA = bvVar;
            a(bvVar.aXZ());
            b(bvVar.aXZ());
            E(bvVar);
            c(bvVar.aXZ());
        }
    }

    private void a(br brVar) {
        if (brVar == null || StringUtils.isNull(brVar.getAvatar())) {
            this.ekw.setVisibility(4);
            return;
        }
        this.ekw.setVisibility(0);
        this.ekw.startLoad(brVar.getAvatar(), 10, false);
        this.ekw.setBorderColor(ao.getColor(R.color.black_alpha15));
    }

    public void b(br brVar) {
        if (brVar == null || StringUtils.isNull(brVar.getForumName())) {
            this.ekx.setVisibility(4);
            return;
        }
        this.ekx.setText(as.cutChineseAndEnglishWithSuffix(brVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.ekx.setVisibility(0);
    }

    public void E(bv bvVar) {
        if (bvVar != null && !StringUtils.isNull(this.aeA.aWl().getName_show())) {
            this.eky.setText(getContext().getString(R.string.user_name_and_publish, yr(this.aeA.aWl().getName_show())));
            this.eky.setVisibility(0);
        }
    }

    public void c(br brVar) {
        int i = 8;
        if (brVar == null) {
            this.ekz.setVisibility(8);
            return;
        }
        this.ekA.a(brVar);
        this.ekz.setVisibility((!brVar.getIsLike() || brVar.aVA()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eke = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.ekA != null) {
            this.ekA.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ekw != null) {
            this.ekw.setPageId(bdUniqueId);
        }
        if (this.ekA != null) {
            this.ekA.setPageUniqueId(bdUniqueId);
        }
    }

    protected String yr(String str) {
        return as.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.ekw;
    }

    public TextView getUserName() {
        return this.eky;
    }

    public TextView getForumName() {
        return this.ekx;
    }

    public ForumLikeBotton getLikeButton() {
        return this.ekz;
    }
}
