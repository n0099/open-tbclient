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
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class SmartAppBottomLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private static final int afx = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView akG;
    private TextView akH;
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
        this.akG = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.akH = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.akG.setIsBigV(false);
        this.akG.setIsGod(false);
        this.akG.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        bw bce = absThreadDataSupport.bce();
        if (bce != null && bce.bft() != null) {
            if (!TextUtils.isEmpty(bce.bft().avatar)) {
                this.akG.startLoad(bce.bft().avatar, 10, false);
            } else {
                ap.setImageResource(this.akG, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bce.bft() != null && !TextUtils.isEmpty(bce.bft().name)) {
                ay.a(this.akH, bce.bft().name, R.string.ai_smart_app, R.dimen.tbds0, 1, afx, false);
            } else {
                this.akH.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.akH, R.color.cp_cont_d);
        }
    }
}
