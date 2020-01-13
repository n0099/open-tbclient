package com.baidu.swan.apps.component.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.a.a.b;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
/* loaded from: classes10.dex */
public abstract class a<V extends SwanEditText, M extends b> extends com.baidu.swan.apps.component.a.c.a<V, M> {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.a.a<V extends com.baidu.swan.apps.component.components.textarea.SwanEditText, M extends com.baidu.swan.apps.component.a.a.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.d.a
    protected /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.a.d.b bVar) {
        a((a<V, M>) ((SwanEditText) view), (SwanEditText) ((b) bVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.a.a<V extends com.baidu.swan.apps.component.components.textarea.SwanEditText, M extends com.baidu.swan.apps.component.a.a.b> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a
    public /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.a.d.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((SwanEditText) view), (SwanEditText) ((b) bVar), bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.a.a<V extends com.baidu.swan.apps.component.components.textarea.SwanEditText, M extends com.baidu.swan.apps.component.a.a.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    protected /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((SwanEditText) view), (SwanEditText) ((b) bVar), bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.a.a<V extends com.baidu.swan.apps.component.components.textarea.SwanEditText, M extends com.baidu.swan.apps.component.a.a.b> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.a.c.a
    public /* bridge */ /* synthetic */ void a(@NonNull TextView textView, @NonNull com.baidu.swan.apps.component.a.c.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) ((SwanEditText) textView), (SwanEditText) ((b) bVar), bVar2);
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.a.c.a, com.baidu.swan.apps.component.a.d.a, com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b a = super.a(m, m2);
        if (getView() != 0 && !TextUtils.equals(((SwanEditText) getView()).getText().toString(), m2.text)) {
            a.dS(6);
        }
        if (m.maxLength != m2.maxLength) {
            a.dS(10);
        }
        if (m.bds != m2.bds) {
            a.dS(11);
        }
        if (m.bdt != m2.bdt || m.bdu != m2.bdu) {
            a.dS(12);
        }
        if (!TextUtils.equals(m.bdv, m2.bdv)) {
            a.dS(13);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.dT(11)) {
            b((a<V, M>) v, (V) m);
        }
        if (bVar.dT(12)) {
            c((a<V, M>) v, (V) m);
        }
        if (bVar.dT(10)) {
            d((a<V, M>) v, (V) m);
        }
        if (bVar.dT(13)) {
            e((a<V, M>) v, (V) m);
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-EditText", "renderBackground");
        }
        v.setBackgroundColor(0);
    }

    protected void b(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-EditText", "renderCursor");
        }
        Editable text = v.getText();
        int i = 0;
        if (text != null) {
            i = text.length();
        }
        if (m.bds <= i && m.bds >= 0) {
            v.setSelection(m.bds);
        }
    }

    protected void c(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-EditText", "renderSelection");
        }
        Editable text = v.getText();
        int i = 0;
        if (text != null) {
            i = text.length();
        }
        if (m.bdu <= i && m.bdt >= 0 && m.bdt <= m.bdu) {
            v.setSelection(m.bdt, m.bdu);
        }
    }

    private void d(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-EditText", "renderMaxLength");
        }
        if (m.maxLength >= 0) {
            v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.maxLength)});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(@NonNull V v, @NonNull M m) {
        if (DEBUG) {
            Log.d("Component-EditText", "renderConfirmType:" + m.bdv);
        }
        String str = m.bdv;
        char c = 65535;
        switch (str.hashCode()) {
            case -906336856:
                if (str.equals("search")) {
                    c = 1;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    c = 3;
                    break;
                }
                break;
            case 3089282:
                if (str.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                    c = 4;
                    break;
                }
                break;
            case 3377907:
                if (str.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                    c = 2;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                v.setImeOptions(4);
                break;
            case 1:
                v.setImeOptions(3);
                break;
            case 2:
                v.setImeOptions(5);
                break;
            case 3:
                v.setImeOptions(2);
                break;
            case 4:
                v.setImeOptions(6);
                break;
            default:
                return false;
        }
        return true;
    }
}
