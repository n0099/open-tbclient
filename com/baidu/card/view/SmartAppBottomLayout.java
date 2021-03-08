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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int aip = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView anA;
    private TextView anB;
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
        this.anA = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.anB = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.anA.setIsBigV(false);
        this.anA.setIsGod(false);
        this.anA.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        cb blp = aVar.blp();
        if (blp != null && blp.boG() != null) {
            if (!TextUtils.isEmpty(blp.boG().avatar)) {
                this.anA.startLoad(blp.boG().avatar, 10, false);
            } else {
                ap.setImageResource(this.anA, R.drawable.icon_avatar_smallapp_tie);
            }
            if (blp.boG() != null && !TextUtils.isEmpty(blp.boG().name)) {
                az.a(this.anB, blp.boG().name, R.string.ai_smart_app, R.dimen.tbds0, 1, aip, false);
            } else {
                this.anB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.anB, R.color.CAM_X0109);
        }
    }
}
