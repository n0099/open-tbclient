package com.baidu.nadcore.widget.uiwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.dz0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.p71;
import com.baidu.tieba.pn0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.y01;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes3.dex */
public class SimpleAdInfoView extends FrameLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public pn0 g;
    public c h;
    public View.OnClickListener i;
    public int j;

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    public final boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (SimpleAdInfoView.this.g == null) {
                return;
            }
            int id = view2.getId();
            String str2 = "";
            if (id == R.id.nad_app_privacy) {
                pn0.c cVar = SimpleAdInfoView.this.g.g;
                if (cVar != null) {
                    str2 = cVar.b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else if (id == R.id.nad_app_permission) {
                pn0.b bVar = SimpleAdInfoView.this.g.h;
                if (bVar != null) {
                    str2 = bVar.b;
                    str = ClogBuilder.Area.APP_PERMISSION.type;
                }
                str = "";
            } else {
                if (id == R.id.nad_app_feature) {
                    pn0.a aVar = SimpleAdInfoView.this.g.i;
                    if (aVar != null) {
                        str2 = aVar.b;
                        str = ClogBuilder.Area.APP_FEATURE.type;
                    }
                } else if (id == R.id.nad_full_author_name) {
                    y01.a().b(SimpleAdInfoView.this.getContext(), SimpleAdInfoView.this.g.d, 1);
                    return;
                } else if (id == R.id.nad_app_version) {
                    y01.a().b(SimpleAdInfoView.this.getContext(), SimpleAdInfoView.this.g.f, 1);
                    return;
                } else if (id == R.id.obfuscated_res_0x7f09192e) {
                    y01.a().b(SimpleAdInfoView.this.getContext(), SimpleAdInfoView.this.g.j, 1);
                    return;
                }
                str = "";
            }
            qe0.c(str2, SimpleAdInfoView.this.getContext());
            c cVar2 = SimpleAdInfoView.this.h;
            if (cVar2 != null) {
                cVar2.a(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ TextView a;

        public b(TextView textView) {
            this.a = textView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int lineCount;
            this.a.removeOnLayoutChangeListener(this);
            Layout layout = this.a.getLayout();
            if (layout != null && (lineCount = layout.getLineCount()) > 0) {
                if (layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.a.setOnClickListener(SimpleAdInfoView.this.i);
                } else {
                    this.a.setOnClickListener(null);
                }
            }
        }
    }

    public SimpleAdInfoView(@NonNull Context context) {
        super(context);
        this.i = new a();
        this.j = R.layout.nad_operate_app_info_layout;
        b(null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p71.SimpleAdInfoView);
        this.j = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
    }

    public final void c(@NonNull TextView textView) {
        textView.addOnLayoutChangeListener(new b(textView));
    }

    public void d(pn0 pn0Var) {
        if (pn0Var != null && f()) {
            e(ClogBuilder.LogType.CHECK, pn0Var.n, PayUVEventType.PAY_WALLET_BANNER_SHOW, "20001");
        }
    }

    public void setAfterListener(c cVar) {
        this.h = cVar;
    }

    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new a();
        this.j = R.layout.nad_operate_app_info_layout;
        b(attributeSet);
    }

    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new a();
        this.j = R.layout.nad_operate_app_info_layout;
        b(attributeSet);
    }

    public static void e(@NonNull ClogBuilder.LogType logType, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType).p(str).k(str2).l(str3);
        dz0.e(clogBuilder);
    }

    public static boolean f() {
        if (ij0.b().a().a("ad_feature_strict_mode_check_switch", 0) != 1) {
            return false;
        }
        return true;
    }

    public int getLayoutId() {
        return this.j;
    }

    public void b(AttributeSet attributeSet) {
        setLayoutByAttrs(attributeSet);
        if (getLayoutId() == -1) {
            return;
        }
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.a = (TextView) findViewById(R.id.nad_app_version);
        this.b = (TextView) findViewById(R.id.nad_full_author_name);
        this.c = (TextView) findViewById(R.id.nad_app_privacy);
        this.d = (TextView) findViewById(R.id.nad_app_permission);
        this.e = (TextView) findViewById(R.id.nad_app_feature);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09192e);
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(this.i);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setOnClickListener(this.i);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setOnClickListener(this.i);
        }
    }

    public void setAdInfo(pn0 pn0Var) {
        if (pn0Var != null && pn0Var.m) {
            this.g = pn0Var;
            int e = pn0Var.e();
            if (this.a != null) {
                if (!a(e, 2)) {
                    this.a.setText(pn0Var.f);
                    this.a.setVisibility(0);
                    c(this.a);
                } else {
                    this.a.setVisibility(8);
                }
            }
            if (this.b != null) {
                if (!a(e, 1)) {
                    this.b.setText(pn0Var.d);
                    this.b.setVisibility(0);
                    c(this.b);
                } else {
                    this.b.setVisibility(8);
                }
            }
            if (this.c != null) {
                if (!a(e, 4)) {
                    this.c.setText(pn0Var.g.a);
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
            }
            if (this.d != null) {
                if (!a(e, 8)) {
                    this.d.setText(pn0Var.h.a);
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
            }
            if (this.e != null) {
                if (!a(e, 16)) {
                    this.e.setText(pn0Var.i.a);
                    this.e.setVisibility(0);
                } else {
                    d(pn0Var);
                    this.e.setVisibility(8);
                }
            }
            if (this.f != null) {
                if (!a(e, 32)) {
                    this.f.setText(pn0Var.j);
                    this.f.setVisibility(0);
                    c(this.f);
                    return;
                }
                this.f.setVisibility(8);
                return;
            }
            return;
        }
        this.g = null;
    }

    public void setFontSize(int i, int i2, int i3, int i4, int i5, int i6) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setTextSize(i);
            c(this.a);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setTextSize(i2);
            c(this.b);
        }
        TextView textView3 = this.d;
        if (textView3 != null) {
            textView3.setTextSize(i3);
        }
        TextView textView4 = this.c;
        if (textView4 != null) {
            textView4.setTextSize(i4);
        }
        TextView textView5 = this.e;
        if (textView5 != null) {
            textView5.setTextSize(i5);
        }
        TextView textView6 = this.f;
        if (textView6 != null) {
            textView6.setTextSize(i6);
            c(this.f);
        }
        requestLayout();
    }
}
