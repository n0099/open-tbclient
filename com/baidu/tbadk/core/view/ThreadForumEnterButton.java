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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int XI = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds70) * 2);
    private View.OnClickListener bNu;
    public final int bSP;
    private TextView bSQ;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;
    private bg threadData;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.bSP = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSP = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(d.h.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.bSQ = (TextView) this.mView.findViewById(d.g.forum_name_text);
        this.bSQ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.threadData.YW())) {
            view.setTag(this.threadData);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.threadData.YW(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.bNu != null) {
                this.bNu.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNu = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.threadData != null && this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.bSQ, com.baidu.tbadk.util.j.pD(this.threadData.getId()));
            al.j(this.bSQ, d.C0277d.cp_cont_b);
        }
    }

    public void w(bg bgVar) {
        if (bgVar != null) {
            String YW = bgVar.YW();
            if (StringUtils.isNull(YW)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.threadData = bgVar;
            this.bSQ.setText(((Object) TextUtils.ellipsize(YW, this.bSQ.getPaint(), XI - this.bSQ.getPaint().measureText(getResources().getString(d.j.forum)), TextUtils.TruncateAt.END)) + getResources().getString(d.j.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bg bgVar, int i) {
        if (this.bSQ != null && bgVar != null && i > 0) {
            this.threadData = bgVar;
            float paddingLeft = (i - (this.bSQ.getPaddingLeft() * 2)) - this.bSQ.getPaint().measureText(getResources().getString(d.j.forum));
            String YW = bgVar.YW();
            if (StringUtils.isNull(YW)) {
                setVisibility(8);
                return;
            }
            this.bSQ.setText(((Object) TextUtils.ellipsize(YW, this.bSQ.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(d.j.forum));
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
