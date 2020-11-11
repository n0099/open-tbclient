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
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {
    private bw agx;
    private View.OnClickListener eWC;
    private TbImageView eWU;
    private TextView eWV;
    private TextView eWW;
    private ForumLikeBotton eWX;
    private com.baidu.tbadk.core.view.commonLike.forum.a eWY;
    private View.OnClickListener eWZ;
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
        this.eWZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadForumUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadForumUserInfoLayout.this.agx != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.agx.boo() != null ? ThreadForumUserInfoLayout.this.agx.boo().getForumName() : ThreadForumUserInfoLayout.this.agx.bmE(), n.bmm())));
                    if (ThreadForumUserInfoLayout.this.eWC != null) {
                        ThreadForumUserInfoLayout.this.eWC.onClick(view);
                    }
                }
            }
        };
        init(getContext());
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.eWU = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        this.eWV = (TextView) inflate.findViewById(R.id.forum_name);
        this.eWV.setOnClickListener(this.eWZ);
        this.eWW = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.eWX = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.eWY = new com.baidu.tbadk.core.view.commonLike.forum.a(((TbPageContextSupport) context).getPageContext(), this.eWX);
        }
        setGravity(16);
        initHeaderImg();
    }

    private void initHeaderImg() {
        if (this.eWU != null) {
            this.eWU.setDefaultBgResource(R.color.cp_bg_line_e);
            this.eWU.setOnClickListener(this.eWZ);
        }
    }

    public void setData(bw bwVar) {
        if (bwVar != null) {
            this.agx = bwVar;
            a(bwVar.boo());
            b(bwVar.boo());
            F(bwVar);
            c(bwVar.boo());
        }
    }

    private void a(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getAvatar())) {
            this.eWU.setVisibility(4);
            return;
        }
        this.eWU.setVisibility(0);
        this.eWU.startLoad(bsVar.getAvatar(), 10, false);
        this.eWU.setBorderColor(ap.getColor(R.color.black_alpha15));
    }

    public void b(bs bsVar) {
        if (bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.eWV.setVisibility(4);
            return;
        }
        this.eWV.setText(at.cutChineseAndEnglishWithSuffix(bsVar.getForumName(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
        this.eWV.setVisibility(0);
    }

    public void F(bw bwVar) {
        if (bwVar != null && !StringUtils.isNull(this.agx.bmA().getName_show())) {
            this.eWW.setText(getContext().getString(R.string.user_name_and_publish, Cv(this.agx.bmA().getName_show())));
            this.eWW.setVisibility(0);
        }
    }

    public void c(bs bsVar) {
        int i = 8;
        if (bsVar == null) {
            this.eWX.setVisibility(8);
            return;
        }
        this.eWY.a(bsVar);
        this.eWX.setVisibility((!bsVar.getIsLike() || bsVar.blP()) ? 0 : 0);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eWC = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        if (this.eWY != null) {
            this.eWY.setLikeButtonAfterClickListener(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWU != null) {
            this.eWU.setPageId(bdUniqueId);
        }
        if (this.eWY != null) {
            this.eWY.setPageUniqueId(bdUniqueId);
        }
    }

    protected String Cv(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public TbImageView getHeaderImg() {
        return this.eWU;
    }

    public TextView getUserName() {
        return this.eWW;
    }

    public TextView getForumName() {
        return this.eWV;
    }

    public ForumLikeBotton getLikeButton() {
        return this.eWX;
    }
}
