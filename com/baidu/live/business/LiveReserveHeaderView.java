package com.baidu.live.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveFeedReserveHeaderInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.ac0;
import com.baidu.tieba.j90;
import com.baidu.tieba.wb0;
/* loaded from: classes2.dex */
public class LiveReserveHeaderView extends LiveBaseItemView {
    public View h;
    public TextView i;
    public ImageView j;

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
    }

    public LiveReserveHeaderView(Context context) {
        super(context);
        e();
    }

    public void setData(LiveFeedReserveHeaderInfo liveFeedReserveHeaderInfo) {
        if (liveFeedReserveHeaderInfo == null) {
            return;
        }
        d();
        if (this.i != null && !TextUtils.isEmpty(liveFeedReserveHeaderInfo.tip)) {
            this.i.setText(liveFeedReserveHeaderInfo.tip);
        }
    }

    public final void d() {
        wb0.h(this.i, 1, 13.0f);
        wb0.f(this.j, j90.c(getContext().getResources(), 12.0f), j90.c(getContext().getResources(), 12.0f));
    }

    public String getTip() {
        TextView textView = this.i;
        if (textView != null && textView.getText() != null) {
            return this.i.getText().toString();
        }
        return "";
    }

    public final void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d057e, this);
        this.h = inflate.findViewById(R.id.layout_bg);
        this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092608);
        this.j = (ImageView) inflate.findViewById(R.id.iv_arrow);
        d();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics()));
        this.h.setBackgroundDrawable(gradientDrawable);
    }

    public void f(String str) {
        View view2 = this.h;
        if (view2 != null) {
            Drawable background = view2.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(ac0.f().a(getContext(), this.c, "color_F5F5F53"));
                this.h.setBackgroundDrawable(background);
            }
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextColor(ac0.f().a(getContext(), this.c, "color_white4"));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageResource(ac0.f().p(this.c));
        }
    }
}
