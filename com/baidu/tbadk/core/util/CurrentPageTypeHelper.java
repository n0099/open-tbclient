package com.baidu.tbadk.core.util;
/* loaded from: classes3.dex */
public class CurrentPageTypeHelper {
    public static PageType currentPageType = PageType.NONE;

    /* loaded from: classes3.dex */
    public enum PageType {
        NATIVE,
        FLUTTER,
        WEB,
        SMART_APP,
        OTHER,
        NATIVE_WEB,
        NONE
    }
}
