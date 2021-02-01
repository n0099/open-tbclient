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
    private static final int agW = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    private HeadImageView ami;
    private TextView amj;
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
        this.ami = (HeadImageView) this.mView.findViewById(R.id.ai_smart_app_icon);
        this.amj = (TextView) this.mView.findViewById(R.id.ai_smart_app_text);
        this.ami.setIsBigV(false);
        this.ami.setIsGod(false);
        this.ami.setShowV(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        cb bln = aVar.bln();
        if (bln != null && bln.boE() != null) {
            if (!TextUtils.isEmpty(bln.boE().avatar)) {
                this.ami.startLoad(bln.boE().avatar, 10, false);
            } else {
                ap.setImageResource(this.ami, R.drawable.icon_avatar_smallapp_tie);
            }
            if (bln.boE() != null && !TextUtils.isEmpty(bln.boE().name)) {
                az.a(this.amj, bln.boE().name, R.string.ai_smart_app, R.dimen.tbds0, 1, agW, false);
            } else {
                this.amj.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
            }
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.amj, R.color.CAM_X0109);
        }
    }
}
