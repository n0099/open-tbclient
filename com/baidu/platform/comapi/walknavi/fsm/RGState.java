package com.baidu.platform.comapi.walknavi.fsm;
/* loaded from: classes20.dex */
public abstract class RGState {
    public static final String METHOD_NAME_ENTER = "enter";
    public static final String METHOD_NAME_EXCUTE = "excute";
    public static final String METHOD_NAME_EXIT = "exit";
    public static final String PACKAGE_NAME = RGState.class.getPackage().getName();
    public static final String CLASS_PREFIX = RGState.class.getSimpleName();

    protected abstract void onActionLayers();

    protected abstract void onActionMapStatus();

    protected abstract void onActionNaviEngine();

    protected abstract void onActionUI();

    public void enter() {
    }

    public void exit() {
    }

    public void excute() {
        onActionUI();
        onActionNaviEngine();
        onActionLayers();
        onActionMapStatus();
    }
}
