package com.baidu.adp.lib.h;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.InputStream;
/* loaded from: classes.dex */
public class c extends Resources {
    private static final ColorStateList wf = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
    private Resources wg;
    private boolean wh;

    public c(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.wg = resources;
        this.wh = false;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 3) {
                try {
                    return this.wg.getDrawable(i);
                } catch (OutOfMemoryError e) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            } else {
                h("drawable", i);
                return null;
            }
            i2 = i3 + 1;
        }
        throw e2;
    }

    @Override // android.content.res.Resources
    public String getString(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 3) {
                try {
                    return this.wg.getString(i);
                } catch (OutOfMemoryError e) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            } else {
                h("string", i);
                return "";
            }
            i2 = i3 + 1;
        }
        throw e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
        return r0;
     */
    @Override // android.content.res.Resources
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getColor(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 < 3) {
                try {
                    i2 = this.wg.getColor(i);
                    break;
                } catch (OutOfMemoryError e) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            } else {
                h("color", i);
                break;
            }
            i3++;
        }
        throw e;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 3) {
                try {
                    return this.wg.getColorStateList(i);
                } catch (OutOfMemoryError e) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2 && (BdBaseApplication.getInst().isDebugMode() || this.wh)) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            } else {
                h("colorstatelist", i);
                return wf;
            }
            i2 = i3 + 1;
        }
        throw e;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) {
        return this.wg.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.wg.openRawResource(i, typedValue);
    }

    private final void h(String str, int i) {
        String str2 = null;
        try {
            str2 = this.wg.getResourceEntryName(i);
        } catch (Exception e) {
        }
        try {
            com.baidu.adp.lib.stats.a.ht().a("resources", str, (String) null, -9115, (String) null, "resid", Integer.valueOf(i), "resname", str2 == null ? "" : str2);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
