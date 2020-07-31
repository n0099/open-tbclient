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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class SmartAppBottomLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int aeo = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView ajr;
    private TextView ajs;
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
        this.ajr = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.ajs = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.ajr.setIsBigV(false);
        this.ajr.setIsGod(false);
        this.ajr.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        bv aTN = absThreadDataSupport.aTN();
        if (aTN != null && aTN.aXa() != null) {
            if (!TextUtils.isEmpty(aTN.aXa().avatar)) {
                this.ajr.startLoad(aTN.aXa().avatar, 10, false);
            } else {
                ao.setImageResource(this.ajr, R.drawable.icon_avatar_smallapp_tie);
            }
            if (aTN.aXa() != null && !TextUtils.isEmpty(aTN.aXa().name)) {
                ax.a(this.ajs, aTN.aXa().name, R.string.ai_smart_app, R.dimen.tbds0, 1, aeo, false);
            } else {
                this.ajs.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(this.ajs, R.color.cp_cont_d);
        }
    }
}
