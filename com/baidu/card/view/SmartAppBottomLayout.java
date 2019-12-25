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
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class SmartAppBottomLayout extends LinearLayout implements m<a> {
    private static final int JX = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView Oj;
    private TextView Ok;
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
        this.Oj = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.Ok = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.Oj.setIsBigV(false);
        this.Oj.setIsGod(false);
        this.Oj.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        bj axx = aVar.axx();
        if (axx != null && axx.aAq() != null) {
            if (!TextUtils.isEmpty(axx.aAq().avatar)) {
                this.Oj.startLoad(axx.aAq().avatar, 10, false);
            } else {
                am.setImageResource(this.Oj, R.drawable.icon_avatar_smallapp_tie);
            }
            if (axx.aAq() != null && !TextUtils.isEmpty(axx.aAq().name)) {
                au.a(this.Ok, axx.aAq().name, (int) R.string.ai_smart_app, (int) R.dimen.tbds0, 1, JX, false);
            } else {
                this.Ok.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.Ok, (int) R.color.cp_cont_d);
        }
    }
}
