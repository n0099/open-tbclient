package com.baidu.searchbox.toolbar;

import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.tieba.R;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\f\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"HIGH_TOOL_BAR_HEIGHT_IDS", "", "TOOL_BAR_HEIGHT_IDS", "getBarHeightDimens", "", "isResponseFontSize", "", "isHightToolbarType", "getBarHeightDimen", "Lcom/baidu/searchbox/toolbar/BaseToolBar;", "lib-toolbar_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseToolBarExtKt {
    public static final int[] TOOL_BAR_HEIGHT_IDS = {R.dimen.obfuscated_res_0x7f070305, R.dimen.obfuscated_res_0x7f070305, R.dimen.obfuscated_res_0x7f07030b, R.dimen.obfuscated_res_0x7f070312, R.dimen.obfuscated_res_0x7f070312};
    public static final int[] HIGH_TOOL_BAR_HEIGHT_IDS = {R.dimen.obfuscated_res_0x7f070310, R.dimen.obfuscated_res_0x7f070310, R.dimen.obfuscated_res_0x7f070317, R.dimen.obfuscated_res_0x7f07031d, R.dimen.obfuscated_res_0x7f07031d};

    public static final int getBarHeightDimen(BaseToolBar baseToolBar) {
        if (baseToolBar != null) {
            return getBarHeightDimens(baseToolBar.getIsResponseFontSize(), baseToolBar.getIsHightToolbarType());
        }
        return R.dimen.obfuscated_res_0x7f070250;
    }

    public static final int getBarHeightDimens(boolean z) {
        return getBarHeightDimens(z, false);
    }

    public static final int getBarHeightDimens(boolean z, boolean z2) {
        if (!z) {
            return R.dimen.obfuscated_res_0x7f070250;
        }
        int fontSizeType = FontSizeHelper.getFontSizeType();
        if (z2) {
            if (fontSizeType < 0) {
                return R.dimen.obfuscated_res_0x7f070250;
            }
            int[] iArr = HIGH_TOOL_BAR_HEIGHT_IDS;
            if (fontSizeType >= iArr.length) {
                return R.dimen.obfuscated_res_0x7f070250;
            }
            return iArr[fontSizeType];
        } else if (fontSizeType < 0) {
            return R.dimen.obfuscated_res_0x7f070250;
        } else {
            int[] iArr2 = TOOL_BAR_HEIGHT_IDS;
            if (fontSizeType >= iArr2.length) {
                return R.dimen.obfuscated_res_0x7f070250;
            }
            return iArr2[fontSizeType];
        }
    }
}
