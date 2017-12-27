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
        private LayoutInflater Xg;
        private final Context mContext;
        private final LayoutInflater mInflater;

        public Helper(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.Xg = null;
            } else if (theme == this.mContext.getTheme()) {
                this.Xg = this.mInflater;
            } else {
                this.Xg = LayoutInflater.from(new ContextThemeWrapper(this.mContext, theme));
            }
        }

        public Resources.Theme getDropDownViewTheme() {
            if (this.Xg == null) {
                return null;
            }
            return this.Xg.getContext().getTheme();
        }

        public LayoutInflater getDropDownViewInflater() {
            return this.Xg != null ? this.Xg : this.mInflater;
        }
    }
}
