package com.baidu.searchbox.ui.fontsize.listener;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ui/fontsize/listener/IFontSizeViewListener;", "", "isResponseFontSize", "", "onFontSizeChange", "", "setIsResponseFontSize", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IFontSizeViewListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isResponseFontSize(IFontSizeViewListener iFontSizeViewListener) {
            return true;
        }

        public static void onFontSizeChange(IFontSizeViewListener iFontSizeViewListener) {
        }

        public static void setIsResponseFontSize(IFontSizeViewListener iFontSizeViewListener, boolean z) {
        }
    }

    boolean isResponseFontSize();

    void onFontSizeChange();

    void setIsResponseFontSize(boolean z);
}
