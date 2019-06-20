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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int Vz = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener bVj;
    public final int caL;
    private TextView caM;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;
    private bg threadData;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.caL = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caL = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.caM = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.caM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.threadData.adA())) {
            view.setTag(this.threadData);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.threadData.adA(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.bVj != null) {
                this.bVj.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVj = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.threadData != null) {
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                al.j(this.caM, R.color.cp_cont_b);
            }
            al.l(this.caM, com.baidu.tbadk.util.j.qM(this.threadData.getId()));
        }
    }

    public void w(bg bgVar) {
        if (bgVar != null) {
            String adA = bgVar.adA();
            if (StringUtils.isNull(adA)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.threadData = bgVar;
            this.caM.setText(((Object) TextUtils.ellipsize(adA, this.caM.getPaint(), Vz - this.caM.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bg bgVar, int i) {
        if (this.caM != null && bgVar != null && i > 0) {
            this.threadData = bgVar;
            float paddingLeft = (i - (this.caM.getPaddingLeft() * 2)) - this.caM.getPaint().measureText(getResources().getString(R.string.forum));
            String adA = bgVar.adA();
            if (StringUtils.isNull(adA)) {
                setVisibility(8);
                return;
            }
            this.caM.setText(((Object) TextUtils.ellipsize(adA, this.caM.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
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
