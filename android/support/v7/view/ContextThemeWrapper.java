package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;
@RestrictTo
/* loaded from: classes2.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private int Gw;
    private LayoutInflater mInflater;
    private Resources.Theme mTheme;

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.Gw = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.Gw != i) {
            this.Gw = i;
            eF();
        }
    }

    public int getThemeResId() {
        return this.Gw;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.Gw == 0) {
            this.Gw = R.style.Theme_AppCompat_Light;
        }
        eF();
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.mInflater;
        }
        return getBaseContext().getSystemService(str);
    }

    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void eF() {
        boolean z = this.mTheme == null;
        if (z) {
            this.mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(this.mTheme, this.Gw, z);
    }
}
