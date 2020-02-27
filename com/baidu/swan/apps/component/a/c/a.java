package com.baidu.swan.apps.component.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.swan.apps.component.a.c.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public abstract class a<V extends TextView, M extends b> extends com.baidu.swan.apps.component.a.d.a<V, M> {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.c.a<V extends android.widget.TextView, M extends com.baidu.swan.apps.component.a.c.b> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.d.a
    public /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.a.d.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((TextView) view), (TextView) ((b) bVar), bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.c.a<V extends android.widget.TextView, M extends com.baidu.swan.apps.component.a.c.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    protected /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((TextView) view), (TextView) ((b) bVar), bVar2);
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b a = super.a(m, m2);
        if (!TextUtils.equals(m.text, m2.text)) {
            a.ei(6);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.ej(6)) {
            a((a<V, M>) v, (V) m);
        }
        if (bVar.ej(4)) {
            b((a<V, M>) v, (V) m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-TextView", "renderText");
        }
        v.setText(m.text);
    }

    private void b(@NonNull V v, @NonNull M m) {
        if (m.bhT != null) {
            if (DEBUG) {
                Log.d("Component-TextView", "renderTextStyle");
            }
            if (m.bhM) {
                v.setTextColor(m.textColor);
            }
            float f = (float) m.fontSize;
            if (f > 0.0f) {
                v.setTextSize(1, f);
            }
            c((a<V, M>) v, (V) m);
            d(v, m);
            e(v, m);
            String str = m.bhN;
            char c = 65535;
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals("normal")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1039592053:
                    if (str.equals("nowrap")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    v.setSingleLine(false);
                    break;
                case 1:
                    v.setSingleLine(true);
                    break;
            }
            if ("ellipsis".equals(m.bhO)) {
                v.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    protected void c(@NonNull V v, @NonNull M m) {
        if (m.bhT != null) {
            if (DEBUG) {
                Log.d("Component-TextView", "renderTextStyleLineSpace");
            }
            int i = m.lineSpace;
            if (i > 0) {
                v.setPadding(v.getPaddingLeft(), v.getPaddingTop() + (i / 2), v.getPaddingRight(), v.getPaddingBottom());
                v.setLineSpacing(i, 1.0f);
            }
        }
    }

    protected void d(@NonNull V v, @NonNull M m) {
        a((a<V, M>) v, (V) m, 48);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(@NonNull V v, @NonNull M m, int i) {
        int i2;
        if (m.bhT != null) {
            if (DEBUG) {
                Log.d("Component-TextView", "renderTextStyleTextAlign");
            }
            String str = m.textAlign;
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 0;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals(HorizontalTranslateLayout.DIRECTION_RIGHT)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i2 = i | GravityCompat.START;
                    break;
                case 1:
                    i2 = 8388613 | i;
                    break;
                case 2:
                    i2 = i | 1;
                    break;
                default:
                    c.w("Component-TextView", "invalid text align: " + m.textAlign);
                    i2 = i | GravityCompat.START;
                    break;
            }
            v.setGravity(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull V v, @NonNull M m) {
        if (m.bhT != null) {
            if (DEBUG) {
                Log.d("Component-TextView", "renderTextStyleFontWeight");
            }
            String str = m.fontWeight;
            char c = 65535;
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals("normal")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3029637:
                    if (str.equals("bold")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    v.setTypeface(Typeface.SANS_SERIF, 0);
                    return;
                case 1:
                    v.setTypeface(Typeface.SANS_SERIF, 1);
                    return;
                default:
                    c.w("Component-TextView", "invalid font weight : " + m.fontWeight);
                    v.setTypeface(Typeface.SANS_SERIF, 0);
                    return;
            }
        }
    }
}
