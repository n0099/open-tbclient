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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView amF;
    private TextView amG;
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
        this.amF = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.amG = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.amF.setIsBigV(false);
        this.amF.setIsGod(false);
        this.amF.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        by bmn = aVar.bmn();
        if (bmn != null && bmn.bpE() != null) {
            if (!TextUtils.isEmpty(bmn.bpE().avatar)) {
                this.amF.startLoad(bmn.bpE().avatar, 10, false);
            } else {
                ap.setImageResource(this.amF, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bmn.bpE() != null && !TextUtils.isEmpty(bmn.bpE().name)) {
                az.a(this.amG, bmn.bpE().name, R.string.ai_smart_app, R.dimen.tbds0, 1, ahn, false);
            } else {
                this.amG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.amG, R.color.CAM_X0109);
        }
    }
}
