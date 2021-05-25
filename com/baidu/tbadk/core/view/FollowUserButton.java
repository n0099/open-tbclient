package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.m0.r.f0.q.b;
/* loaded from: classes3.dex */
public class FollowUserButton extends TBSpecificationBtn implements b {
    public a s;
    public int t;
    public boolean u;

    /* loaded from: classes3.dex */
    public interface a {
        void onClick(View view);
    }

    public FollowUserButton(Context context) {
        this(context, null);
    }

    @Override // d.a.m0.r.f0.q.b
    public void a(View view) {
        a aVar = this.s;
        if (aVar != null) {
            aVar.onClick(view);
        }
    }

    @Override // d.a.m0.r.f0.q.b
    public void b(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.m0.r.f0.q.b
    public void c(boolean z, int i2, boolean z2) {
        e(z, i2);
    }

    @Override // d.a.m0.r.f0.q.b
    public void d(int i2) {
    }

    @Override // d.a.m0.r.f0.q.b
    public void e(boolean z, int i2) {
        if (z) {
            s(true);
        } else {
            s(false);
        }
    }

    public void r(int i2) {
        k();
    }

    public void s(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.u);
            d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
            bVar.r(R.color.CAM_X0109);
            bVar.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            d.a.m0.r.f0.m.b bVar2 = new d.a.m0.r.f0.m.b();
            bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            bVar2.i(this.t, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.q(R.color.CAM_X0304);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setClickableUnLike(boolean z) {
        this.u = z;
    }

    public void setOnClickEvent(a aVar) {
        this.s = aVar;
    }

    public void setSvgIconResId(int i2) {
        this.t = i2;
        k();
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = 0;
        this.u = true;
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.i(this.t, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.q(R.color.CAM_X0304);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }
}
