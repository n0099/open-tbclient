package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int VU = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener bWq;
    public final int cbU;
    private TextView cbV;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;
    private bh threadData;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.cbU = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbU = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.cbV = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.cbV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.threadData.aeD())) {
            view.setTag(this.threadData);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.threadData.aeD(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.bWq != null) {
                this.bWq.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.threadData != null) {
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                am.j(this.cbV, R.color.cp_cont_b);
            }
            am.l(this.cbV, com.baidu.tbadk.util.j.rd(this.threadData.getId()));
        }
    }

    public void x(bh bhVar) {
        if (bhVar != null) {
            String aeD = bhVar.aeD();
            if (StringUtils.isNull(aeD)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.threadData = bhVar;
            this.cbV.setText(((Object) TextUtils.ellipsize(aeD, this.cbV.getPaint(), VU - this.cbV.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bh bhVar, int i) {
        if (this.cbV != null && bhVar != null && i > 0) {
            this.threadData = bhVar;
            float paddingLeft = (i - (this.cbV.getPaddingLeft() * 2)) - this.cbV.getPaint().measureText(getResources().getString(R.string.forum));
            String aeD = bhVar.aeD();
            if (StringUtils.isNull(aeD)) {
                setVisibility(8);
                return;
            }
            this.cbV.setText(((Object) TextUtils.ellipsize(aeD, this.cbV.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
