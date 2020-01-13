package com.baidu.live.view;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class f extends PopupWindow {
    public f(Context context) {
        super(context);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        ShowUtil.windowCount++;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (ShowUtil.windowCount > 0) {
            ShowUtil.windowCount--;
        }
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
        Object dU = dU("mContentView");
        View view = dU instanceof View ? (View) dU : null;
        if (isShowing() && view != null) {
            Object dU2 = dU("mDecorView");
            View view2 = dU2 instanceof View ? (View) dU2 : null;
            if (view2 != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view2.getLayoutParams();
                Object dU3 = dU("mWidthMode");
                int intValue = dU3 != null ? ((Integer) dU3).intValue() : 0;
                Object dU4 = dU("mLastWidth");
                int intValue2 = dU4 != null ? ((Integer) dU4).intValue() : 0;
                if (intValue >= 0) {
                    intValue = intValue2;
                }
                if (i3 != -1 && layoutParams.width != intValue) {
                    layoutParams.width = intValue;
                    f("mLastWidth", Integer.valueOf(intValue));
                    z = true;
                }
                Object dU5 = dU("mHeightMode");
                int intValue3 = dU5 != null ? ((Integer) dU5).intValue() : 0;
                Object dU6 = dU("mLastHeight");
                int intValue4 = dU6 != null ? ((Integer) dU6).intValue() : 0;
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
                    Object dU7 = dU("mWindowManager");
                    WindowManager windowManager = dU7 instanceof WindowManager ? (WindowManager) dU7 : null;
                    if (windowManager != null) {
                        windowManager.updateViewLayout(view2, layoutParams);
                    }
                }
            }
        }
    }

    private Object dU(String str) {
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
