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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agp = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView alF;
    private TextView alG;
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
        this.alF = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.alG = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.alF.setIsBigV(false);
        this.alF.setIsGod(false);
        this.alF.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        bx bjd = aVar.bjd();
        if (bjd != null && bjd.bmr() != null) {
            if (!TextUtils.isEmpty(bjd.bmr().avatar)) {
                this.alF.startLoad(bjd.bmr().avatar, 10, false);
            } else {
                ap.setImageResource(this.alF, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bjd.bmr() != null && !TextUtils.isEmpty(bjd.bmr().name)) {
                az.a(this.alG, bjd.bmr().name, R.string.ai_smart_app, R.dimen.tbds0, 1, agp, false);
            } else {
                this.alG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.alG, R.color.CAM_X0109);
        }
    }
}
