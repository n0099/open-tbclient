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
    private View.OnClickListener bNw;
    public final int bSR;
    private TextView bSS;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;
    private bg threadData;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.bSR = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSR = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(d.h.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.bSS = (TextView) this.mView.findViewById(d.g.forum_name_text);
        this.bSS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.threadData.YT())) {
            view.setTag(this.threadData);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.threadData.YT(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.bNw != null) {
                this.bNw.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNw = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.threadData != null && this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.bSS, com.baidu.tbadk.util.j.pE(this.threadData.getId()));
            al.j(this.bSS, d.C0277d.cp_cont_b);
        }
    }

    public void w(bg bgVar) {
        if (bgVar != null) {
            String YT = bgVar.YT();
            if (StringUtils.isNull(YT)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.threadData = bgVar;
            this.bSS.setText(((Object) TextUtils.ellipsize(YT, this.bSS.getPaint(), XI - this.bSS.getPaint().measureText(getResources().getString(d.j.forum)), TextUtils.TruncateAt.END)) + getResources().getString(d.j.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bg bgVar, int i) {
        if (this.bSS != null && bgVar != null && i > 0) {
            this.threadData = bgVar;
            float paddingLeft = (i - (this.bSS.getPaddingLeft() * 2)) - this.bSS.getPaint().measureText(getResources().getString(d.j.forum));
            String YT = bgVar.YT();
            if (StringUtils.isNull(YT)) {
                setVisibility(8);
                return;
            }
            this.bSS.setText(((Object) TextUtils.ellipsize(YT, this.bSS.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(d.j.forum));
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
