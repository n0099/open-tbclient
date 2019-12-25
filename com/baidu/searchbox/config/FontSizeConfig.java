package com.baidu.searchbox.config;

import android.content.Context;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
/* loaded from: classes11.dex */
public class FontSizeConfig {
    public static final String FONT_SIZE_COOKIE = "fontsize";
    public static final String FONT_TIPS_IS_OLDER_AGE_KEY = "font_tips_is_older_age_key";
    public static final String FONT_TIPS_IS_OLDER_AGE_SHOWED_KEY = "font_tips_is_older_showed_key";
    public static final String FONT_TIPS_SHOW_ISFIRST_KEY = "font_tips_show_isfirst_key";
    private static final String TAG = "FontSizeConfig";
    public static final int TEXT_SIZE_BIG = 2;
    private static final String TEXT_SIZE_BIG_STRING = "font-size-2";
    public static final int TEXT_SIZE_INVALID = -1;
    public static final int TEXT_SIZE_MIDDLE = 1;
    private static final String TEXT_SIZE_MIDDLE_STRING = "font-size-1";
    public static final int TEXT_SIZE_SMALL = 0;
    private static final String TEXT_SIZE_SMALL_STRING = "font-size-0";
    public static final int TEXT_SIZE_VERY_BIG = 3;
    private static final String TEXT_SIZE_VERY_BIG_STRING = "font-size-3";
    public static final int WEB_VIEW_TEXT_SIZE_BIG = 112;
    public static final int WEB_VIEW_TEXT_SIZE_MIDDLE = 100;
    public static final int WEB_VIEW_TEXT_SIZE_SMALL = 82;
    public static final int WEB_VIEW_TEXT_SIZE_VERY_BIG = 118;

    /* loaded from: classes11.dex */
    public interface IFontChangeable {
        void onFontSizeChanged(int i);
    }

    public static int getFontSizeByFontSliderBarIndex(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return -1;
        }
    }

    private static String getJSValueFromFontSize(int i) {
        switch (i) {
            case 0:
                return TEXT_SIZE_SMALL_STRING;
            case 1:
                return TEXT_SIZE_MIDDLE_STRING;
            case 2:
                return TEXT_SIZE_BIG_STRING;
            case 3:
                return TEXT_SIZE_VERY_BIG_STRING;
            default:
                return TEXT_SIZE_MIDDLE_STRING;
        }
    }

    public static String getFontSizeString(Context context) {
        return getJSValueFromFontSize(getFontSize(context));
    }

    public static int getFontSize(Context context) {
        return QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_TEXT_SIZE, 1);
    }

    public static void saveFontData(Context context, int i) {
        int i2;
        if (i != -1) {
            switch (i) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 3;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i2);
            EventBusWrapper.post(new FontSizeChangeMessage(1, Integer.valueOf(i)));
        }
    }
}
