package com.baidu.nadcore.widget.uiwidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.cd1;
import com.baidu.tieba.cs0;
import com.baidu.tieba.uj0;
/* loaded from: classes3.dex */
public class SimpleAdInfoView extends FrameLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public cs0 e;
    public c f;
    public View.OnClickListener g;
    public int h;

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (SimpleAdInfoView.this.e == null) {
                return;
            }
            int id = view2.getId();
            String str2 = "";
            if (id == R.id.nad_app_privacy) {
                cs0.b bVar = SimpleAdInfoView.this.e.g;
                if (bVar != null) {
                    str2 = bVar.b;
                    str = ClogBuilder.Area.APP_PRIVACY.type;
                }
                str = "";
            } else {
                if (id == R.id.nad_app_permission) {
                    cs0.a aVar = SimpleAdInfoView.this.e.h;
                    if (aVar != null) {
                        str2 = aVar.b;
                        str = ClogBuilder.Area.APP_PERMISSION.type;
                    }
                } else if (id == R.id.nad_full_author_name) {
                    Toast.makeText(SimpleAdInfoView.this.getContext(), SimpleAdInfoView.this.e.d, 1).show();
                    return;
                } else if (id == R.id.nad_app_version) {
                    Toast.makeText(SimpleAdInfoView.this.getContext(), SimpleAdInfoView.this.e.f, 1).show();
                    return;
                }
                str = "";
            }
            uj0.c(str2, SimpleAdInfoView.this.getContext());
            c cVar = SimpleAdInfoView.this.f;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ViewTreeObserver b;

        public b(TextView textView, ViewTreeObserver viewTreeObserver) {
            this.a = textView;
            this.b = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int lineCount;
            Layout layout = this.a.getLayout();
            if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                this.a.setOnClickListener(SimpleAdInfoView.this.g);
            }
            if (this.b.isAlive()) {
                this.b.removeOnGlobalLayoutListener(this);
                return;
            }
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public SimpleAdInfoView(@NonNull Context context) {
        super(context);
        this.g = new a();
        this.h = R.layout.nad_operate_app_info_layout;
        a(null);
    }

    private void setLayoutByAttrs(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cd1.SimpleAdInfoView);
        this.h = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
    }

    public final void b(@NonNull TextView textView) {
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b(textView, viewTreeObserver));
    }

    public void setAfterListener(c cVar) {
        this.f = cVar;
    }

    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new a();
        this.h = R.layout.nad_operate_app_info_layout;
        a(attributeSet);
    }

    public SimpleAdInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new a();
        this.h = R.layout.nad_operate_app_info_layout;
        a(attributeSet);
    }

    public void a(AttributeSet attributeSet) {
        setLayoutByAttrs(attributeSet);
        if (getLayoutId() == -1) {
            return;
        }
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.a = (TextView) findViewById(R.id.nad_app_version);
        this.b = (TextView) findViewById(R.id.nad_full_author_name);
        this.c = (TextView) findViewById(R.id.nad_app_privacy);
        this.d = (TextView) findViewById(R.id.nad_app_permission);
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(this.g);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setOnClickListener(this.g);
        }
    }

    public int getLayoutId() {
        return this.h;
    }

    public void setAdInfo(cs0 cs0Var) {
        if (cs0Var != null && cs0Var.k) {
            this.e = cs0Var;
            if (this.a != null) {
                if (!TextUtils.isEmpty(cs0Var.f)) {
                    this.a.setText(cs0Var.f);
                    this.a.setVisibility(0);
                    b(this.a);
                } else {
                    this.a.setVisibility(8);
                }
            }
            if (this.b != null) {
                if (!TextUtils.isEmpty(cs0Var.d)) {
                    this.b.setText(cs0Var.d);
                    this.b.setVisibility(0);
                    b(this.b);
                } else {
                    this.b.setVisibility(8);
                }
            }
            if (this.c != null) {
                cs0.b bVar = cs0Var.g;
                if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(cs0Var.g.a)) {
                    this.c.setText(cs0Var.g.a);
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
            }
            if (this.d != null) {
                cs0.a aVar = cs0Var.h;
                if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(cs0Var.h.a)) {
                    this.d.setText(cs0Var.h.a);
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
                return;
            }
            return;
        }
        this.e = null;
    }
}
