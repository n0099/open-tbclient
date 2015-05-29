package com.baidu.adp.lib.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class b {
    private static b vS = new b();

    private b() {
    }

    public static b hr() {
        return vS;
    }

    private LayoutInflater F(Context context) {
        if (context == null) {
            return null;
        }
        return (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View inflate(Context context, int i, ViewGroup viewGroup) {
        View view = null;
        if (context != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                try {
                    view = F(context).inflate(i, viewGroup);
                    break;
                } catch (OutOfMemoryError e) {
                    if (i3 == 2) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
                i2 = i3 + 1;
            }
        }
        return view;
    }

    public View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        View view = null;
        if (context != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                try {
                    view = F(context).inflate(i, viewGroup, z);
                    break;
                } catch (OutOfMemoryError e) {
                    if (i3 == 2) {
                        throw e;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                } catch (RuntimeException e2) {
                    if (i3 == 2) {
                        throw e2;
                    }
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
                i2 = i3 + 1;
            }
        }
        return view;
    }
}
