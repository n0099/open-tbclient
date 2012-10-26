package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_SELECT = 4;
    private static final AccessibilityNodeInfoImpl IMPL;
    private final Object mInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AccessibilityNodeInfoImpl {
        void addAction(Object obj, int i);

        void addChild(Object obj, View view);

        List<Object> findAccessibilityNodeInfosByText(Object obj, String str);

        int getActions(Object obj);

        void getBoundsInParent(Object obj, Rect rect);

        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        CharSequence getClassName(Object obj);

        CharSequence getContentDescription(Object obj);

        CharSequence getPackageName(Object obj);

        Object getParent(Object obj);

        CharSequence getText(Object obj);

        int getWindowId(Object obj);

        boolean isCheckable(Object obj);

        boolean isChecked(Object obj);

        boolean isClickable(Object obj);

        boolean isEnabled(Object obj);

        boolean isFocusable(Object obj);

        boolean isFocused(Object obj);

        boolean isLongClickable(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        boolean isSelected(Object obj);

        Object obtain();

        Object obtain(View view);

        Object obtain(Object obj);

        boolean performAction(Object obj, int i);

        void recycle(Object obj);

        void setBoundsInParent(Object obj, Rect rect);

        void setBoundsInScreen(Object obj, Rect rect);

        void setCheckable(Object obj, boolean z);

        void setChecked(Object obj, boolean z);

        void setClassName(Object obj, CharSequence charSequence);

        void setClickable(Object obj, boolean z);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setEnabled(Object obj, boolean z);

        void setFocusable(Object obj, boolean z);

        void setFocused(Object obj, boolean z);

        void setLongClickable(Object obj, boolean z);

        void setPackageName(Object obj, CharSequence charSequence);

        void setParent(Object obj, View view);

        void setPassword(Object obj, boolean z);

        void setScrollable(Object obj, boolean z);

        void setSelected(Object obj, boolean z);

        void setSource(Object obj, View view);

        void setText(Object obj, CharSequence charSequence);
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain() {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View source) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(Object info) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object info, int action) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object info, View child) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            return Collections.emptyList();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(Object info) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(Object info, Rect outBounds) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(Object info, Rect outBounds) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object getChild(Object info, int index) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(Object info) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getClassName(Object info) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getContentDescription(Object info) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getPackageName(Object info) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public AccessibilityNodeInfoCompat getParent(Object info) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getText(Object info) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(Object info) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(Object info) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object info, int action) {
            return false;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(Object info, Rect bounds) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(Object info, Rect bounds) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(Object info, boolean checkable) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(Object info, boolean checked) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(Object info, CharSequence className) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(Object info, boolean clickable) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(Object info, CharSequence contentDescription) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(Object info, boolean enabled) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(Object info, boolean focusable) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(Object info, boolean focused) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(Object info, boolean longClickable) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(Object info, CharSequence packageName) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object info, View parent) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(Object info, boolean password) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(Object info, boolean scrollable) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(Object info, boolean selected) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object info, View source) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(Object info, CharSequence text) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(Object info) {
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(View source) {
            return AccessibilityNodeInfoCompatIcs.obtain(source);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public Object obtain(Object info) {
            return AccessibilityNodeInfoCompatIcs.obtain(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(Object info, int action) {
            AccessibilityNodeInfoCompatIcs.addAction(info, action);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(Object info, View child) {
            AccessibilityNodeInfoCompatIcs.addChild(info, child);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public List<Object> findAccessibilityNodeInfosByText(Object info, String text) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(info, text);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(Object info) {
            return AccessibilityNodeInfoCompatIcs.getActions(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(info, outBounds);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(Object info, Rect outBounds) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(info, outBounds);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public AccessibilityNodeInfoCompat getChild(Object info, int index) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfoCompat.IMPL.getChild(info, index));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(Object info) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getClassName(Object info) {
            return AccessibilityNodeInfoCompatIcs.getClassName(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getContentDescription(Object info) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getPackageName(Object info) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(info);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public AccessibilityNodeInfoCompat getParent(Object info) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfoCompat.IMPL.getParent(info));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public CharSequence getText(Object info) {
            return AccessibilityNodeInfoCompatIcs.getText(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(Object info) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(Object info) {
            return AccessibilityNodeInfoCompatIcs.isChecked(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isClickable(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(Object info) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(Object info) {
            return AccessibilityNodeInfoCompatIcs.isFocused(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(Object info) {
            return AccessibilityNodeInfoCompatIcs.isPassword(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(Object info) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(Object info) {
            return AccessibilityNodeInfoCompatIcs.isSelected(info);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(Object info, int action) {
            return AccessibilityNodeInfoCompatIcs.performAction(info, action);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(info, bounds);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(Object info, Rect bounds) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(info, bounds);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(Object info, boolean checkable) {
            AccessibilityNodeInfoCompatIcs.setCheckable(info, checkable);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(Object info, boolean checked) {
            AccessibilityNodeInfoCompatIcs.setChecked(info, checked);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(Object info, CharSequence className) {
            AccessibilityNodeInfoCompatIcs.setClassName(info, className);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(Object info, boolean clickable) {
            AccessibilityNodeInfoCompatIcs.setClickable(info, clickable);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(Object info, CharSequence contentDescription) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(info, contentDescription);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(Object info, boolean enabled) {
            AccessibilityNodeInfoCompatIcs.setEnabled(info, enabled);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(Object info, boolean focusable) {
            AccessibilityNodeInfoCompatIcs.setFocusable(info, focusable);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(Object info, boolean focused) {
            AccessibilityNodeInfoCompatIcs.setFocused(info, focused);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(Object info, boolean longClickable) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(info, longClickable);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(Object info, CharSequence packageName) {
            AccessibilityNodeInfoCompatIcs.setPackageName(info, packageName);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(Object info, View parent) {
            AccessibilityNodeInfoCompatIcs.setParent(info, parent);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(Object info, boolean password) {
            AccessibilityNodeInfoCompatIcs.setPassword(info, password);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(Object info, boolean scrollable) {
            AccessibilityNodeInfoCompatIcs.setScrollable(info, scrollable);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(Object info, boolean selected) {
            AccessibilityNodeInfoCompatIcs.setSelected(info, selected);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(Object info, View source) {
            AccessibilityNodeInfoCompatIcs.setSource(info, source);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(Object info, CharSequence text) {
            AccessibilityNodeInfoCompatIcs.setText(info, text);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(Object info) {
            AccessibilityNodeInfoCompatIcs.recycle(info);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityNodeInfoIcsImpl();
        } else {
            IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }

    public AccessibilityNodeInfoCompat(Object info) {
        this.mInfo = info;
    }

    public Object getImpl() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View source) {
        return new AccessibilityNodeInfoCompat(IMPL.obtain(source));
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return new AccessibilityNodeInfoCompat(IMPL.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat info) {
        return new AccessibilityNodeInfoCompat(IMPL.obtain(info.mInfo));
    }

    public void setSource(View source) {
        IMPL.setSource(this.mInfo, source);
    }

    public int getWindowId() {
        return IMPL.getWindowId(this.mInfo);
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getChild(int index) {
        return new AccessibilityNodeInfoCompat(IMPL.getChild(this.mInfo, index));
    }

    public void addChild(View child) {
        IMPL.addChild(this.mInfo, child);
    }

    public int getActions() {
        return IMPL.getActions(this.mInfo);
    }

    public void addAction(int action) {
        IMPL.addAction(this.mInfo, action);
    }

    public boolean performAction(int action) {
        return IMPL.performAction(this.mInfo, action);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        List<AccessibilityNodeInfoCompat> result = new ArrayList<>();
        List<Object> infos = IMPL.findAccessibilityNodeInfosByText(this.mInfo, text);
        int infoCount = infos.size();
        for (int i = 0; i < infoCount; i++) {
            Object info = infos.get(i);
            result.add(new AccessibilityNodeInfoCompat(info));
        }
        return result;
    }

    public AccessibilityNodeInfoCompat getParent() {
        return new AccessibilityNodeInfoCompat(IMPL.getParent(this.mInfo));
    }

    public void setParent(View parent) {
        IMPL.setParent(this.mInfo, parent);
    }

    public void getBoundsInParent(Rect outBounds) {
        IMPL.getBoundsInParent(this.mInfo, outBounds);
    }

    public void setBoundsInParent(Rect bounds) {
        IMPL.setBoundsInParent(this.mInfo, bounds);
    }

    public void getBoundsInScreen(Rect outBounds) {
        IMPL.getBoundsInScreen(this.mInfo, outBounds);
    }

    public void setBoundsInScreen(Rect bounds) {
        IMPL.setBoundsInParent(this.mInfo, bounds);
    }

    public boolean isCheckable() {
        return IMPL.isCheckable(this.mInfo);
    }

    public void setCheckable(boolean checkable) {
        IMPL.setCheckable(this.mInfo, checkable);
    }

    public boolean isChecked() {
        return IMPL.isChecked(this.mInfo);
    }

    public void setChecked(boolean checked) {
        IMPL.setChecked(this.mInfo, checked);
    }

    public boolean isFocusable() {
        return IMPL.isFocusable(this.mInfo);
    }

    public void setFocusable(boolean focusable) {
        IMPL.setFocusable(this.mInfo, focusable);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public void setFocused(boolean focused) {
        IMPL.setFocused(this.mInfo, focused);
    }

    public boolean isSelected() {
        return IMPL.isSelected(this.mInfo);
    }

    public void setSelected(boolean selected) {
        IMPL.setSelected(this.mInfo, selected);
    }

    public boolean isClickable() {
        return IMPL.isClickable(this.mInfo);
    }

    public void setClickable(boolean clickable) {
        IMPL.setClickable(this.mInfo, clickable);
    }

    public boolean isLongClickable() {
        return IMPL.isLongClickable(this.mInfo);
    }

    public void setLongClickable(boolean longClickable) {
        IMPL.setLongClickable(this.mInfo, longClickable);
    }

    public boolean isEnabled() {
        return IMPL.isEnabled(this.mInfo);
    }

    public void setEnabled(boolean enabled) {
        IMPL.setEnabled(this.mInfo, enabled);
    }

    public boolean isPassword() {
        return IMPL.isPassword(this.mInfo);
    }

    public void setPassword(boolean password) {
        IMPL.setPassword(this.mInfo, password);
    }

    public boolean isScrollable() {
        return IMPL.isScrollable(this.mInfo);
    }

    public void setScrollable(boolean scrollable) {
        IMPL.setScrollable(this.mInfo, scrollable);
    }

    public CharSequence getPackageName() {
        return IMPL.getPackageName(this.mInfo);
    }

    public void setPackageName(CharSequence packageName) {
        IMPL.setPackageName(this.mInfo, packageName);
    }

    public CharSequence getClassName() {
        return IMPL.getClassName(this.mInfo);
    }

    public void setClassName(CharSequence className) {
        IMPL.setClassName(this.mInfo, className);
    }

    public CharSequence getText() {
        return IMPL.getText(this.mInfo);
    }

    public void setText(CharSequence text) {
        IMPL.setText(this.mInfo, text);
    }

    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(this.mInfo);
    }

    public void setContentDescription(CharSequence contentDescription) {
        IMPL.setContentDescription(this.mInfo, contentDescription);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public int hashCode() {
        if (this.mInfo == null) {
            return 0;
        }
        return this.mInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityNodeInfoCompat other = (AccessibilityNodeInfoCompat) obj;
            return this.mInfo == null ? other.mInfo == null : this.mInfo.equals(other.mInfo);
        }
        return false;
    }
}
