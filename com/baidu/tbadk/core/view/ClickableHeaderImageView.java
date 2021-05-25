package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.m0.m.d;
import d.a.m0.r.q.a2;
/* loaded from: classes3.dex */
public class ClickableHeaderImageView extends HeadImageView {
    public a2 W0;
    public boolean X0;
    public View.OnClickListener Y0;
    public d Z0;
    public View.OnClickListener a1;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = ClickableHeaderImageView.this.Z0;
            if ((dVar == null || !dVar.a(view)) && ClickableHeaderImageView.this.W0 != null) {
                MetaData t = ClickableHeaderImageView.this.X0 ? ClickableHeaderImageView.this.W0.B1().t() : ClickableHeaderImageView.this.W0.T();
                if (t == null || StringUtils.isNull(t.getName_show()) || StringUtils.isNull(t.getUserId())) {
                    return;
                }
                long f2 = b.f(t.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(f2, f2 == b.f(TbadkCoreApplication.getCurrentAccount(), 0L), t.isBigV());
                createNormalConfig.setSourceTid(ClickableHeaderImageView.this.W0.y1());
                createNormalConfig.setSourceNid(ClickableHeaderImageView.this.W0.M0());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                if (ClickableHeaderImageView.this.Y0 != null) {
                    ClickableHeaderImageView.this.Y0.onClick(view);
                }
            }
        }
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.a1 = new a();
        G();
    }

    public void G() {
        setOnClickListener(this.a1);
        setDefaultResource(17170445);
        setPlaceHolder(1);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Y0 = onClickListener;
    }

    public void setData(a2 a2Var, boolean z, boolean z2) {
        MetaData T;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        this.W0 = a2Var;
        this.X0 = z2;
        if (z2) {
            T = a2Var.B1().t();
        } else {
            T = a2Var.T();
        }
        setContentDescription(T.getName_show() + getContext().getString(R.string.somebodys_portrait));
        setUserId(T.getUserId());
        setUserName(T.getUserName());
        if (a2Var.r1() != null && (this.W0.u1() == 49 || this.W0.u1() == 69)) {
            setUrl(a2Var.T().getAvater());
            V(a2Var.T().getAvater(), 28, false);
        } else {
            setUrl(T.getAvater());
            if (!StringUtils.isNull(T.getAvater()) && T.getAvater().contains("http")) {
                V(T.getAvater(), 10, false);
            } else {
                V(T.getAvater(), 28, false);
            }
        }
        UtilHelper.showHeadImageViewBigV(this, T);
    }

    public void setOnInterceptClickEventListener(d dVar) {
        this.Z0 = dVar;
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a1 = new a();
        G();
    }

    public void setData(a2 a2Var, boolean z) {
        setData(a2Var, z, false);
    }

    public void setData(a2 a2Var) {
        setData(a2Var, true);
    }

    public void setData(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        a2 a2Var = new a2();
        a2Var.t3(metaData);
        setData(a2Var);
    }
}
