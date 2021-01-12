package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahh = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView ams;
    private TextView amt;
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
        this.ams = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.amt = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.ams.setIsBigV(false);
        this.ams.setIsGod(false);
        this.ams.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        bz bkV = aVar.bkV();
        if (bkV != null && bkV.bom() != null) {
            if (!TextUtils.isEmpty(bkV.bom().avatar)) {
                this.ams.startLoad(bkV.bom().avatar, 10, false);
            } else {
                ao.setImageResource(this.ams, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bkV.bom() != null && !TextUtils.isEmpty(bkV.bom().name)) {
                ay.a(this.amt, bkV.bom().name, R.string.ai_smart_app, R.dimen.tbds0, 1, ahh, false);
            } else {
                this.amt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(this.amt, R.color.CAM_X0109);
        }
    }
}
