package com.baidu.mobads.utils;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
/* loaded from: classes2.dex */
public class ab implements IXAdViewUtils {
    private boolean a(View view) {
        return view.getWidth() > 15 && view.getHeight() > 15;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public int getViewState(View view) {
        if (isScreenOn(view.getContext())) {
            if (isAdViewShown(view)) {
                if (a(view)) {
                    return !isVisible(view, 50) ? 3 : 0;
                }
                return 6;
            }
            return 1;
        }
        return 4;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public int getVisiblePercent(View view, Context context) {
        if (view != null) {
            try {
                if (view.isShown()) {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i = displayMetrics.heightPixels;
                    int i2 = displayMetrics.widthPixels;
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    if (rect.top <= i && rect.left <= i2) {
                        return (int) (((rect.width() * rect.height()) * 100.0d) / (view.getWidth() * view.getHeight()));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public boolean isAdViewOutsideScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect windowRect = XAdSDKFoundationFacade.getInstance().getCommonUtils().getWindowRect(view.getContext());
        int width = iArr[0] + (view.getWidth() / 2);
        int height = iArr[1] + (view.getHeight() / 2);
        return width <= 0 || width >= windowRect.width() || height <= 0 || height >= windowRect.height();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public boolean isAdViewShown(View view) {
        return view != null && view.isShown();
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public boolean isAdViewTooSmall(View view) {
        return view != null && (view.getWidth() < 10 || view.getHeight() < 10);
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public boolean isScreenOn(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
            return true;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdViewUtils
    public boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i) * height2;
        }
        return false;
    }
}
