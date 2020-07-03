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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SmartAppBottomLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int aey = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView ajw;
    private TextView ajx;
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
        this.ajw = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.ajx = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.ajw.setIsBigV(false);
        this.ajw.setIsGod(false);
        this.ajw.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        bu aPS = absThreadDataSupport.aPS();
        if (aPS != null && aPS.aTe() != null) {
            if (!TextUtils.isEmpty(aPS.aTe().avatar)) {
                this.ajw.startLoad(aPS.aTe().avatar, 10, false);
            } else {
                an.setImageResource(this.ajw, R.drawable.icon_avatar_smallapp_tie);
            }
            if (aPS.aTe() != null && !TextUtils.isEmpty(aPS.aTe().name)) {
                aw.a(this.ajx, aPS.aTe().name, (int) R.string.ai_smart_app, (int) R.dimen.tbds0, 1, aey, false);
            } else {
                this.ajx.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            an.setViewTextColor(this.ajx, (int) R.color.cp_cont_d);
        }
    }
}
