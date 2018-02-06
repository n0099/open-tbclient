package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
/* loaded from: classes2.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);

    /* loaded from: classes2.dex */
    public static final class Helper {
        private LayoutInflater Xf;
        private final Context mContext;
        private final LayoutInflater mInflater;

        public Helper(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.Xf = null;
            } else if (theme == this.mContext.getTheme()) {
                this.Xf = this.mInflater;
            } else {
                this.Xf = LayoutInflater.from(new ContextThemeWrapper(this.mContext, theme));
            }
        }

        public Resources.Theme getDropDownViewTheme() {
            if (this.Xf == null) {
                return null;
            }
            return this.Xf.getContext().getTheme();
        }

        public LayoutInflater getDropDownViewInflater() {
            return this.Xf != null ? this.Xf : this.mInflater;
        }
    }
}
