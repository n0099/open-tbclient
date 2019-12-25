package com.baidu.live.view;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class f extends PopupWindow {
    public f(Context context) {
        super(context);
    }

    @Override // android.widget.PopupWindow
    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT != 24) {
            super.update(i, i2, i3, i4, z);
            return;
        }
        if (i3 >= 0) {
            f("mLastWidth", Integer.valueOf(i3));
            setWidth(i3);
        }
        if (i4 >= 0) {
            f("mLastHeight", Integer.valueOf(i4));
            setHeight(i4);
        }
        Object dS = dS("mContentView");
        View view = dS instanceof View ? (View) dS : null;
        if (isShowing() && view != null) {
            Object dS2 = dS("mDecorView");
            View view2 = dS2 instanceof View ? (View) dS2 : null;
            if (view2 != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view2.getLayoutParams();
                Object dS3 = dS("mWidthMode");
                int intValue = dS3 != null ? ((Integer) dS3).intValue() : 0;
                Object dS4 = dS("mLastWidth");
                int intValue2 = dS4 != null ? ((Integer) dS4).intValue() : 0;
                if (intValue >= 0) {
                    intValue = intValue2;
                }
                if (i3 != -1 && layoutParams.width != intValue) {
                    layoutParams.width = intValue;
                    f("mLastWidth", Integer.valueOf(intValue));
                    z = true;
                }
                Object dS5 = dS("mHeightMode");
                int intValue3 = dS5 != null ? ((Integer) dS5).intValue() : 0;
                Object dS6 = dS("mLastHeight");
                int intValue4 = dS6 != null ? ((Integer) dS6).intValue() : 0;
                if (intValue3 >= 0) {
                    intValue3 = intValue4;
                }
                if (i4 != -1 && layoutParams.height != intValue3) {
                    layoutParams.height = intValue3;
                    f("mLastHeight", Integer.valueOf(intValue3));
                    z = true;
                }
                if (layoutParams.x != i) {
                    layoutParams.x = i;
                    z = true;
                }
                if (layoutParams.y != i2) {
                    layoutParams.y = i2;
                    z = true;
                }
                Object c = c("computeAnimationResource", new Class[]{Integer.TYPE}, null);
                int intValue5 = c == null ? 0 : ((Integer) c).intValue();
                if (intValue5 != layoutParams.windowAnimations) {
                    layoutParams.windowAnimations = intValue5;
                    z = true;
                }
                Object c2 = c("computeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(layoutParams.flags)});
                int intValue6 = c2 != null ? ((Integer) c2).intValue() : 0;
                if (intValue6 != layoutParams.flags) {
                    layoutParams.flags = intValue6;
                } else {
                    z2 = z;
                }
                if (z2) {
                    c("setLayoutDirectionFromAnchor", null, null);
                    Object dS7 = dS("mWindowManager");
                    WindowManager windowManager = dS7 instanceof WindowManager ? (WindowManager) dS7 : null;
                    if (windowManager != null) {
                        windowManager.updateViewLayout(view2, layoutParams);
                    }
                }
            }
        }
    }

    private Object dS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Field declaredField = PopupWindow.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void f(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                declaredField.set(this, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Object c(String str, Class[] clsArr, Object[] objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method method = getMethod(PopupWindow.class, str, clsArr);
            method.setAccessible(true);
            return method.invoke(this, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Method getMethod(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                if (cls.getSuperclass() == null) {
                    return null;
                }
                return getMethod(cls.getSuperclass(), str, clsArr);
            }
        }
    }
}
