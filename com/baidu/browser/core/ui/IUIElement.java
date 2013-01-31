package com.baidu.browser.core.ui;

import com.baidu.browser.core.IElement;
import com.baidu.browser.core.IEventSource;
/* loaded from: classes.dex */
public interface IUIElement extends IElement, IEventSource {
    public static final int STATE_ACTIVATED = 5;
    public static final int STATE_CHECKED = 4;
    public static final int STATE_DISABLED = 1;
    public static final int STATE_ENABLED = 0;
    public static final int STATE_FOCUSED = 2;
    public static final int STATE_MAX_COUNT = 6;
    public static final int STATE_SELECTED = 3;

    int getState();

    boolean isPressed();

    void onActionChanged();

    boolean onCaptureLoseFocus();

    void onStateChanged(int i);

    void setPressed(boolean z);

    void setState(int i);
}
