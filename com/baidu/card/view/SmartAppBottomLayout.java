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
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private static final int agj = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView alA;
    private TextView alB;
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
        this.alA = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.alB = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.alA.setIsBigV(false);
        this.alA.setIsGod(false);
        this.alA.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        bw bfG = absThreadDataSupport.bfG();
        if (bfG != null && bfG.biW() != null) {
            if (!TextUtils.isEmpty(bfG.biW().avatar)) {
                this.alA.startLoad(bfG.biW().avatar, 10, false);
            } else {
                ap.setImageResource(this.alA, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bfG.biW() != null && !TextUtils.isEmpty(bfG.biW().name)) {
                ay.a(this.alB, bfG.biW().name, R.string.ai_smart_app, R.dimen.tbds0, 1, agj, false);
            } else {
                this.alB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.alB, R.color.cp_cont_d);
        }
    }
}
