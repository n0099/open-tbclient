package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    private View.OnClickListener ajo;
    public final int eIA;
    private TextView eIB;
    private bw eji;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;
    private int tbds20;
    private int tbds21;
    private int tbds23;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.eIA = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds21 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.tbds23 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23);
        init(context);
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIA = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds21 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.tbds23 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds23);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.eIB = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.eIB.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eji.bil())) {
            view.setTag(this.eji);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eji.bil(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
                aq("c13967", 2);
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.mContext).createNormalCfg(this.eji.bil(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg2.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            } else if (this.mFrom == 2) {
                aq("c13967", 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921488));
            }
            if (this.ajo != null) {
                this.ajo.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.eji != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            Drawable background = this.eIB.getBackground();
            DrawableCompat.setTint(background, ap.getColor(R.color.cp_link_tip_d_alpha20));
            this.eIB.setBackgroundDrawable(background);
            int color = ap.getColor(R.color.cp_link_tip_d);
            ap.a(this.eIB, color);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_good16, color, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                this.mIconDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds36));
            }
            boC();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aK(R.dimen.tbds0, R.dimen.tbds21)));
        }
    }

    public void r(bw bwVar) {
        this.eji = bwVar;
        if (bwVar != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            boC();
            this.eIB.setText(string);
            this.eIB.setVisibility(0);
            onChangeSkinType();
            boD();
            return;
        }
        setVisibility(8);
    }

    private void boD() {
        if (this.mFrom == 2) {
            aq("c13966", 1);
        } else if (this.mFrom == 1) {
            aq("c13966", 2);
        } else {
            if (this.mFrom == 0) {
            }
        }
    }

    private void aq(String str, int i) {
        TiebaStatic.log(new aq(str).aj("obj_locate", i).u("fid", this.eji.getFid()).dK("fname", this.eji.bil()).dK("tid", this.eji.getTid()));
    }

    private void boC() {
        this.eIB.setGravity(16);
        this.eIB.setPadding(this.tbds23, 0, this.tbds21, 0);
        this.eIB.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
