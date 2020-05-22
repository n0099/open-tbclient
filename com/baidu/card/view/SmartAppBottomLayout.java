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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SmartAppBottomLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int adT = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView ahZ;
    private TextView aia;
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
        this.ahZ = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.aia = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.ahZ.setIsBigV(false);
        this.ahZ.setIsGod(false);
        this.ahZ.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        bk aOi = absThreadDataSupport.aOi();
        if (aOi != null && aOi.aRn() != null) {
            if (!TextUtils.isEmpty(aOi.aRn().avatar)) {
                this.ahZ.startLoad(aOi.aRn().avatar, 10, false);
            } else {
                am.setImageResource(this.ahZ, R.drawable.icon_avatar_smallapp_tie);
            }
            if (aOi.aRn() != null && !TextUtils.isEmpty(aOi.aRn().name)) {
                au.a(this.aia, aOi.aRn().name, (int) R.string.ai_smart_app, (int) R.dimen.tbds0, 1, adT, false);
            } else {
                this.aia.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.aia, (int) R.color.cp_cont_d);
        }
    }
}
