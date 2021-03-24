package com.baidu.card.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.z0.l;
import d.b.i0.b0.g;
/* loaded from: classes2.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public g f4531e;

    /* renamed from: f  reason: collision with root package name */
    public int f4532f;

    /* renamed from: g  reason: collision with root package name */
    public int f4533g;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public void a(a2 a2Var) {
        this.f4531e.h(a2Var);
        if (!ThreadCardUtils.isSelf(a2Var) && a2Var.Y1()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public final TbPageContext b(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void c() {
        setImageDrawable(WebPManager.getPureDrawable(this.f4532f, SkinManager.getColor(this.f4533g), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l.a()) {
            return;
        }
        this.f4531e.n();
    }

    public void setWebPResId(int i, int i2) {
        this.f4532f = i;
        this.f4533g = i2;
        setImageDrawable(WebPManager.getPureDrawable(i, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4532f = R.drawable.icon_pure_card_more22;
        this.f4533g = R.color.CAM_X0111;
        this.f4531e = new g(b((Activity) context), this);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_more22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
