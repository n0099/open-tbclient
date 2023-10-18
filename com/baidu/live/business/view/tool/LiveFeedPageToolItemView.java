package com.baidu.live.business.view.tool;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.spswitch.emotion.view.CircleIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.b80;
import com.baidu.tieba.f80;
import com.baidu.tieba.o50;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class LiveFeedPageToolItemView extends FrameLayout {
    public SimpleDraweeView a;
    public TextView b;
    public View c;

    public LiveFeedPageToolItemView(Context context) {
        super(context);
        a();
    }

    private void setData(String str) {
        TextView textView = this.b;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public void setDividerShowing(boolean z) {
        int i;
        View view2 = this.c;
        if (view2 != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05e4, (ViewGroup) this, true);
        this.a = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09100b);
        this.b = (TextView) findViewById(R.id.tv_name);
        this.c = findViewById(R.id.obfuscated_res_0x7f090904);
        c();
    }

    public void c() {
        b80.f(this.a, o50.c(getContext().getResources(), 19.0f), o50.c(getContext().getResources(), 19.0f));
        b80.h(this.b, 1, 9.0f);
    }

    public void d() {
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageDrawable(null);
        }
    }

    public void b(String str, boolean z) {
        boolean z2;
        boolean z3;
        float applyDimension;
        ViewGroup.LayoutParams layoutParams;
        if (this.a != null) {
            int i = 0;
            if (this.b == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!(z2 | z3)) {
                if (this.a.getHierarchy() != null) {
                    this.a.getHierarchy().setUseGlobalColorFilter(false);
                }
                if (z) {
                    if (this.a.getTag() instanceof Boolean) {
                        this.a.setColorFilter(-1694498817);
                    } else if (this.a.getHierarchy() != null) {
                        this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(-1694498817, PorterDuff.Mode.SRC_ATOP));
                    }
                    this.b.setTextColor(-1694498817);
                    this.c.setBackgroundColor(-13619152);
                    applyDimension = TypedValue.applyDimension(1, 0.6f, getResources().getDisplayMetrics());
                } else {
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 99228) {
                        if (hashCode == 104817688 && str.equals("night")) {
                            c = 1;
                        }
                    } else if (str.equals("day")) {
                        c = 0;
                    }
                    if (c != 0) {
                        if (c == 1) {
                            if (this.a.getTag() instanceof Boolean) {
                                this.a.setColorFilter(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT);
                            } else if (this.a.getHierarchy() != null) {
                                this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT, PorterDuff.Mode.SRC_ATOP));
                            }
                            this.b.setTextColor(CircleIndicator.NIGHT_COLOR_EMOTION_CIRCLE_INDICATOR_HIGHLIGHT);
                            this.c.setBackgroundColor(-13619152);
                            applyDimension = TypedValue.applyDimension(1, 0.6f, getResources().getDisplayMetrics());
                        }
                        layoutParams = this.c.getLayoutParams();
                        if (layoutParams == null && i > 0 && layoutParams.height != i) {
                            layoutParams.height = i;
                            this.c.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    if (this.a.getTag() instanceof Boolean) {
                        this.a.setColorFilter(-11382190);
                    } else if (this.a.getHierarchy() != null) {
                        this.a.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(-11382190, PorterDuff.Mode.SRC_ATOP));
                    }
                    this.b.setTextColor(-11382190);
                    this.c.setBackgroundColor(-1118482);
                    applyDimension = TypedValue.applyDimension(1, 0.4f, getResources().getDisplayMetrics());
                }
                i = (int) applyDimension;
                layoutParams = this.c.getLayoutParams();
                if (layoutParams == null) {
                }
            }
        }
    }

    public void setData(boolean z, int i, String str) {
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null) {
            simpleDraweeView.setTag(Boolean.TRUE);
            this.a.setImageResource(i);
        }
        setData(str);
        b(f80.f().r(), z);
    }

    public void setData(boolean z, String str, String str2) {
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null && str != null) {
            simpleDraweeView.setImageURI(str);
        }
        setData(str2);
        b(f80.f().r(), z);
    }
}
