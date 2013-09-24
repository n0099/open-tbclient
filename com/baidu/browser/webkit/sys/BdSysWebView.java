package com.baidu.browser.webkit.sys;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webkit.BdWapClient;
import com.baidu.browser.webkit.BdWapEngine;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewClient;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSysWebView extends WebView implements BdNoProGuard, BdWapClient {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdSysWebView";
    private BdWapEngine mWapEngine;
    private BdWebView mWebView;

    public BdSysWebView(BdWebView bdWebView, Context context) {
        super(context);
        onInit(bdWebView, context);
    }

    public BdSysWebView(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        onInit(bdWebView, context);
    }

    public BdSysWebView(BdWebView bdWebView, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onInit(bdWebView, context);
    }

    public void onInit(BdWebView bdWebView, Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
        setTag(bdWebView);
        this.mWebView = bdWebView;
        this.mWapEngine = new BdWapEngine(this);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadWapUrl(str);
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        loadWapUrl(str);
        super.loadUrl(str, map);
    }

    private void loadWapUrl(String str) {
        if (BdWapEngine.checkWapUrl(str)) {
            BdWebViewClient webViewClient = this.mWebView.getWebViewClient();
            if (webViewClient != null) {
                webViewClient.onWapPageStarted(this.mWebView, str, false);
            }
            this.mWapEngine.loadUrl(str);
        }
    }

    @Override // com.baidu.browser.webkit.BdWapClient
    public void onLoadWapUrl(String str) {
        BdWebViewClient webViewClient = this.mWebView.getWebViewClient();
        if (webViewClient != null) {
            webViewClient.onWapPageStarted(this.mWebView, str, true);
        }
        super.loadUrl(str);
    }

    @Override // com.baidu.browser.webkit.BdWapClient
    public void onUnloadWapUrl(String str) {
        BdWebViewClient webViewClient = this.mWebView.getWebViewClient();
        if (webViewClient != null) {
            webViewClient.onWapPageFinished(this.mWebView, str);
        }
    }

    public boolean superPerformLongClick() {
        return super.performLongClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return this.mWebView.drawChild(canvas, view, j);
    }

    public boolean superDrawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWebView.onTouchEvent(motionEvent);
    }

    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mWebView.onScrollChanged(i, i2, i3, i4);
    }

    public void superOnScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void reflectOnPause() {
        try {
            invokeMethod(this, "onPause", null, null);
        } catch (Exception e) {
        }
    }

    public void reflectOnResume() {
        try {
            invokeMethod(this, "onResume", null, null);
        } catch (Exception e) {
        }
    }

    public void reflectSetEmbeddedTitleBar(View view) {
        try {
            invokeMethod(this, "setEmbeddedTitleBar", new Class[]{View.class}, new Object[]{view}, null);
        } catch (Exception e) {
        }
    }

    public String reflectGetSelection() {
        try {
            Object[] objArr = new Object[1];
            if (invokeMethod(this, "nativeGetSelection", null, objArr) && (objArr[0] instanceof String)) {
                return (String) objArr[0];
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public boolean getExtendSelection() {
        Object fieldValue = getFieldValue(this, "mExtendSelection");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    public boolean setExtendSelection(boolean z) {
        return setFieldValue(this, "mExtendSelection", Boolean.valueOf(z));
    }

    public boolean getSelectingText() {
        Object fieldValue = getFieldValue(this, "mSelectingText");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    public boolean setSelectingText(boolean z) {
        return setFieldValue(this, "mSelectingText", Boolean.valueOf(z));
    }

    public boolean getDrawSelectionPointer() {
        Object fieldValue = getFieldValue(this, "mDrawSelectionPointer");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    public boolean setDrawSelectionPointer(boolean z) {
        return setFieldValue(this, "mDrawSelectionPointer", Boolean.valueOf(z));
    }

    public boolean getShiftIsPressed() {
        Object fieldValue = getFieldValue(this, "mShiftIsPressed");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    public boolean setShiftIsPressed(boolean z) {
        return setFieldValue(this, "mShiftIsPressed", Boolean.valueOf(z));
    }

    public boolean getTouchSelection() {
        Object fieldValue = getFieldValue(this, "mTouchSelection");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    public boolean setTouchSelection(boolean z) {
        return setFieldValue(this, "mTouchSelection", Boolean.valueOf(z));
    }

    public ZoomButtonsController reflectGetZoomButtonsController() {
        try {
            return getZoomButtonsController();
        } catch (NoSuchMethodError e) {
            try {
                Object[] objArr = new Object[1];
                if (invokeMethod(this, "getZoomButtonsController", null, objArr) && (objArr[0] instanceof ZoomButtonsController)) {
                    return (ZoomButtonsController) objArr[0];
                }
                return null;
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float reflectGetActualScale() {
        Object fieldValue = getFieldValue(this, "mActualScale");
        if (fieldValue == null) {
            return 0.0f;
        }
        return ((Float) fieldValue).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float reflectGetMaxZoomScale() {
        Object fieldValue = getFieldValue(this, "mMaxZoomScale");
        if (fieldValue == null) {
            return 0.0f;
        }
        return ((Float) fieldValue).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float reflectGetMinZoomScale() {
        Object fieldValue = getFieldValue(this, "mMinZoomScale");
        if (fieldValue == null) {
            return 0.0f;
        }
        return ((Float) fieldValue).floatValue();
    }

    protected float reflectGetDefaultScale() {
        Object fieldValue = getFieldValue(this, "mDefaultScale");
        if (fieldValue == null) {
            return 0.0f;
        }
        return ((Float) fieldValue).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean reflectGetInZoomOverview() {
        Object fieldValue = getFieldValue(this, "mInZoomOverview");
        if (fieldValue == null) {
            return false;
        }
        return ((Boolean) fieldValue).booleanValue();
    }

    protected int reflectGetViewportWidth() {
        Object fieldValue;
        Object fieldValue2 = getFieldValue(this, "mWebViewCore");
        if (fieldValue2 != null && (fieldValue = getFieldValue(fieldValue2, "mViewportWidth")) != null) {
            return ((Integer) fieldValue).intValue();
        }
        return -1;
    }

    protected boolean reflectGetViewportUserScalable() {
        Object fieldValue;
        Object fieldValue2 = getFieldValue(this, "mWebViewCore");
        if (fieldValue2 != null && (fieldValue = getFieldValue(fieldValue2, "mViewportUserScalable")) != null) {
            return ((Boolean) fieldValue).booleanValue();
        }
        return true;
    }

    @Override // android.webkit.WebView
    public void setFindIsUp(boolean z) {
        super.setFindIsUp(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reflectSetFindIsUp(boolean z) {
        try {
            invokeMethod(this, "setFindIsUp", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}, null);
        } catch (Exception e) {
        }
    }

    public boolean isMobileSite() {
        String host;
        boolean reflectGetViewportUserScalable = reflectGetViewportUserScalable();
        int reflectGetViewportWidth = reflectGetViewportWidth();
        String url = getUrl();
        if (url != null && (host = Uri.parse(url).getHost()) != null && reflectGetViewportWidth == -1 && (host.startsWith("m.") || host.startsWith("mobile.") || host.startsWith("wap.") || host.startsWith("3g.") || host.contains(".m.") || host.contains(".mobile.") || host.contains(".wap.") || host.contains(".3g."))) {
            reflectGetViewportWidth = 0;
        }
        return !reflectGetViewportUserScalable || reflectGetViewportWidth == 0;
    }

    public void setDisplayZoomControls(boolean z) {
        ZoomButtonsController reflectGetZoomButtonsController = reflectGetZoomButtonsController();
        if (reflectGetZoomButtonsController != null) {
            if (!z) {
                reflectGetZoomButtonsController.setOnZoomListener(null);
                reflectGetZoomButtonsController.setVisible(false);
                reflectGetZoomButtonsController.getZoomControls().setVisibility(8);
                reflectGetZoomButtonsController.getZoomControls().setEnabled(false);
                return;
            }
            reflectGetZoomButtonsController.setOnZoomListener(null);
            reflectGetZoomButtonsController.setVisible(true);
            reflectGetZoomButtonsController.getZoomControls().setVisibility(0);
            reflectGetZoomButtonsController.getZoomControls().setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean invokeMethod(Object obj, String str, Object[] objArr, Object[] objArr2) {
        Class<?>[] clsArr = objArr == null ? null : new Class[objArr.length];
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
            }
        }
        return invokeMethod(obj, str, clsArr, objArr, objArr2);
    }

    protected boolean invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr, Object[] objArr2) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        Method method = getMethod(obj, str, clsArr);
        if (method != null) {
            method.setAccessible(true);
            try {
                Object invoke = method.invoke(obj, objArr);
                if (objArr2 != null && objArr2.length > 0) {
                    objArr2[0] = invoke;
                }
            } catch (ExceptionInInitializerError e) {
                throw new IllegalArgumentException(str, e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(str, e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalArgumentException(str, e3);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getFieldValue(Object obj, String str) {
        Field field;
        if (obj == null || (field = getField(obj, str)) == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (ExceptionInInitializerError e) {
            throw new IllegalArgumentException(str, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(str, e2);
        }
    }

    protected boolean setFieldValue(Object obj, String str, Object obj2) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        Field field = getField(obj, str);
        if (field != null) {
            field.setAccessible(true);
            try {
                field.set(obj, obj2);
            } catch (ExceptionInInitializerError e) {
                throw new IllegalArgumentException(str, e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(str, e2);
            }
        } else {
            z = false;
        }
        return z;
    }

    protected Field getField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(String.valueOf(cls.getName()) + "." + str, e2);
            }
        }
        return null;
    }

    protected Method getMethod(Object obj, String str, Class<?>[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(String.valueOf(cls.getName()) + "." + str, e2);
            }
        }
        return null;
    }
}
