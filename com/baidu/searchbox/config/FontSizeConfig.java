package com.baidu.searchbox.config;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import com.baidu.searchbox.config.utils.FontSizeSharedPrefs;
import java.util.ArrayList;
import kotlin.Deprecated;
/* loaded from: classes3.dex */
public class FontSizeConfig {
    public static final float FONT_SIZE_BIG = 1.35f;
    public static final String FONT_SIZE_COOKIE = "fontsize";
    public static final float FONT_SIZE_DEFAULT = 1.0f;
    public static final String FONT_TIPS_IS_OLDER_AGE_KEY = "font_tips_is_older_age_key";
    public static final String FONT_TIPS_IS_OLDER_AGE_SHOWED_KEY = "font_tips_is_older_showed_key";
    public static final String FONT_TIPS_SHOW_ISFIRST_KEY = "font_tips_show_isfirst_key";
    public static final String KEY_LAUNCH_SET_SYSTEM_FONT = "launch_set_system_font";
    public static final String KEY_SYSTEM_FONT_SCALE = "system_font_scale";
    public static final String KEY_TEXT_SIZE = "key_text_size";
    public static final String KEY_USER_ACTIVELY_SET_FONT = "user_actively_set_font";
    public static final int SCALED_RATIO_ARRAY_SIZE = 5;
    public static final int TEXT_SIZE_BIG = 2;
    public static final String TEXT_SIZE_BIG_STRING = "font-size-2";
    public static final int TEXT_SIZE_EXTRA_BIG = 4;
    public static final String TEXT_SIZE_EXTRA_BIG_STRING = "font-size-4";
    public static final int TEXT_SIZE_INVALID = -1;
    public static final int TEXT_SIZE_MIDDLE = 1;
    public static final String TEXT_SIZE_MIDDLE_STRING = "font-size-1";
    public static final int TEXT_SIZE_SMALL = 0;
    public static final String TEXT_SIZE_SMALL_STRING = "font-size-0";
    public static final int TEXT_SIZE_VERY_BIG = 3;
    public static final String TEXT_SIZE_VERY_BIG_STRING = "font-size-3";
    public static final int WEB_VIEW_TEXT_SIZE_BIG = 112;
    public static final int WEB_VIEW_TEXT_SIZE_MIDDLE = 100;
    public static final int WEB_VIEW_TEXT_SIZE_SMALL = 82;
    public static final int WEB_VIEW_TEXT_SIZE_VERY_BIG = 118;

    /* loaded from: classes3.dex */
    public interface IFontChangeable {
        void onFontSizeChanged(int i);
    }

    public static int getFontSizeByFontSliderBarIndex(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? -1 : 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static String getJSValueFromFontSize(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? TEXT_SIZE_MIDDLE_STRING : TEXT_SIZE_EXTRA_BIG_STRING : TEXT_SIZE_VERY_BIG_STRING : TEXT_SIZE_BIG_STRING : TEXT_SIZE_MIDDLE_STRING : TEXT_SIZE_SMALL_STRING;
    }

    static {
        FontSizeRuntime.getFontSizeBusiness().autoSyncSystemFontSize();
    }

    @Deprecated(message = "过期，请勿使用, 请使用 FontSizeHelper.getFontSizeType()")
    public static int getAppFontSizeSP() {
        return FontSizeHelper.getFontSizeType();
    }

    public static boolean isNeedToast() {
        return FontSizeRuntime.getFontSizeBusiness().isNeedToast();
    }

    public static int lastOperateFontType() {
        return FontSizeRuntime.getFontSizeBusiness().lastOperateFontType();
    }

    public static void launchFontSizeStatistic() {
        FontSizeRuntime.getFontSizeBusiness().launchFontSizeStatistic();
    }

    public static int getFontLevel(Context context) {
        if (getSystemFontScale(context) > 1.35f) {
            return 2;
        }
        return 1;
    }

    @Deprecated(message = "过期，请勿使用, 请使用 FontSizeHelper.getFontSizeType()")
    public static int getFontSize(Context context) {
        return getAppFontSizeSP();
    }

    public static String getFontSizeString(Context context) {
        return getJSValueFromFontSize(getFontSize(context));
    }

    public static float getSystemFontScale(Context context) {
        Configuration configuration;
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 1.0f;
        }
        return configuration.fontScale;
    }

    public static boolean isNeedDialog(Context context) {
        return FontSizeRuntime.getFontSizeBusiness().isNeedDialog();
    }

    public static void showFontMenu(Context context) {
        if (context != null) {
            FontSizeRuntime.getFontSizeBusiness().showFontMenu(context);
        }
    }

    public static String getFontLevelText(Context context) {
        int appFontSizeSP = getAppFontSizeSP();
        if (appFontSizeSP == 0) {
            return context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09ce);
        }
        if (1 == appFontSizeSP) {
            return context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cd);
        }
        if (2 == appFontSizeSP) {
            return context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cb);
        }
        if (3 == appFontSizeSP) {
            return context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cf);
        }
        if (4 == appFontSizeSP) {
            return context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cc);
        }
        return "";
    }

    public static String[] getFontLevelTextArray() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                arrayList.add(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09ce));
            } else if (1 == i) {
                arrayList.add(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cd));
            } else if (2 == i) {
                arrayList.add(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cb));
            } else if (3 == i) {
                arrayList.add(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cf));
            } else {
                arrayList.add(AppRuntime.getAppContext().getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f09cc));
            }
        }
        return (String[]) arrayList.toArray(new String[5]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
        if (r4 != 4) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveFontData(Context context, int i) {
        if (i == -1) {
            return;
        }
        int i2 = 4;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        i2 = 3;
                    }
                } else {
                    i2 = 2;
                }
            }
            i2 = 1;
        } else {
            i2 = 0;
        }
        FontSizeSharedPrefs fontSizeSharedPrefs = FontSizeSharedPrefs.INSTANCE;
        fontSizeSharedPrefs.putInt("key_text_size", i2);
        FontSizeHelper.INSTANCE.setTargetLevel(i2);
        fontSizeSharedPrefs.putBoolean("user_actively_set_font", true);
        FontSizeRuntime.getFontSizeBusiness().setIsActivelySetFont(true);
        BdEventBus.Companion.getDefault().post(new FontSizeChangeMessage(1, Integer.valueOf(i)));
    }
}
