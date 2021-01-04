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
/* loaded from: classes11.dex */
public class e extends PopupWindow {
    public e(Context context) {
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
            h("mLastWidth", Integer.valueOf(i3));
            setWidth(i3);
        }
        if (i4 >= 0) {
            h("mLastHeight", Integer.valueOf(i4));
            setHeight(i4);
        }
        Object jb = jb("mContentView");
        View view = jb instanceof View ? (View) jb : null;
        if (isShowing() && view != null) {
            Object jb2 = jb("mDecorView");
            View view2 = jb2 instanceof View ? (View) jb2 : null;
            if (view2 != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view2.getLayoutParams();
                Object jb3 = jb("mWidthMode");
                int intValue = jb3 != null ? ((Integer) jb3).intValue() : 0;
                Object jb4 = jb("mLastWidth");
                int intValue2 = jb4 != null ? ((Integer) jb4).intValue() : 0;
                if (intValue >= 0) {
                    intValue = intValue2;
                }
                if (i3 != -1 && layoutParams.width != intValue) {
                    layoutParams.width = intValue;
                    h("mLastWidth", Integer.valueOf(intValue));
                    z = true;
                }
                Object jb5 = jb("mHeightMode");
                int intValue3 = jb5 != null ? ((Integer) jb5).intValue() : 0;
                Object jb6 = jb("mLastHeight");
                int intValue4 = jb6 != null ? ((Integer) jb6).intValue() : 0;
                if (intValue3 >= 0) {
                    intValue3 = intValue4;
                }
                if (i4 != -1 && layoutParams.height != intValue3) {
                    layoutParams.height = intValue3;
                    h("mLastHeight", Integer.valueOf(intValue3));
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
                    Object jb7 = jb("mWindowManager");
                    WindowManager windowManager = jb7 instanceof WindowManager ? (WindowManager) jb7 : null;
                    if (windowManager != null) {
                        windowManager.updateViewLayout(view2, layoutParams);
                    }
                }
            }
        }
    }

    private Object jb(String str) {
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

    private void h(String str, Object obj) {
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
