package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SmartAppBottomLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private static final int Ky = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView OQ;
    private TextView OR;
    private int mSkinType;
    private View mView;

    public SmartAppBottomLayout(Context context) {
        this(context, null);
        initUI(context);
    }

    public SmartAppBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        initUI(context);
    }

    private void initUI(Context context) {
        this.mView = LayoutInflater.from(context).inflate(R.layout.smart_app_bottom_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.OQ = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.OR = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.OQ.setIsBigV(false);
        this.OQ.setIsGod(false);
        this.OQ.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        bj aAj = aVar.aAj();
        if (aAj != null && aAj.aDd() != null) {
            if (!TextUtils.isEmpty(aAj.aDd().avatar)) {
                this.OQ.startLoad(aAj.aDd().avatar, 10, false);
            } else {
                am.setImageResource(this.OQ, R.drawable.icon_avatar_smallapp_tie);
            }
            if (aAj.aDd() != null && !TextUtils.isEmpty(aAj.aDd().name)) {
                au.a(this.OR, aAj.aDd().name, (int) R.string.ai_smart_app, (int) R.dimen.tbds0, 1, Ky, false);
            } else {
                this.OR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.OR, (int) R.color.cp_cont_d);
        }
    }
}
