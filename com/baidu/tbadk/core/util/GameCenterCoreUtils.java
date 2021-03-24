package com.baidu.tbadk.core.util;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class GameCenterCoreUtils {
    public static final String GAME_NATIVE_PREFIX = "game:detail";
    public static final String GAME_WEB_PREFIX = "http";
    public static final int ILLEGAL_URL = 0;
    public static final int NATIVE_URL = 1;
    public static final int NET_URL = 2;
    public static final String REF_TYPE_CLASSIFY = "1000104";
    public static final String REF_TYPE_CLASSIFY_DETAIL = "3001401";
    public static final String REF_TYPE_CURRENT_BAR = "1000601";
    public static final String REF_TYPE_DETAIL = "3000301";
    public static final String REF_TYPE_DETAIL_ABOUT = "1000301";
    public static final String REF_TYPE_DETAIL_COMPANY = "1000302";
    public static final String REF_TYPE_FROM_FORUM = "605";
    public static final String REF_TYPE_FROM_FRS = "603";
    public static final String REF_TYPE_FROM_GAMECENTER = "606";
    public static final String REF_TYPE_FROM_NAVIGATION = "601";
    public static final String REF_TYPE_FROM_PB = "604";
    public static final String REF_TYPE_FRS_AD = "4000601";
    public static final String REF_TYPE_GAME_BANNER = "4000102";
    public static final String REF_TYPE_GAME_MANAGER = "3001301";
    public static final String REF_TYPE_GAME_RUNNING = "1001102";
    public static final String REF_TYPE_GAME_TESTING = "1001101";
    public static final String REF_TYPE_HOT = "1000103";
    public static final String REF_TYPE_HOT_RANK = "1001201";
    public static final String REF_TYPE_IM = "2000801";
    public static final String REF_TYPE_LIGHT_GALLERY = "4000201";
    public static final String REF_TYPE_LIGHT_GOOD = "1000202";
    public static final String REF_TYPE_LIGHT_HOT = "1000201";
    public static final String REF_TYPE_LIGHT_RECOMMEND = "1000201";
    public static final String REF_TYPE_MAINTAB_AD = "4000401";
    public static final String REF_TYPE_MY_GAME = "3000201";
    public static final String REF_TYPE_NEW = "1000102";
    public static final String REF_TYPE_NEW_GAME = "1001101";
    public static final String REF_TYPE_OTHER = "5000901";
    public static final String REF_TYPE_PB = "2000701";
    public static final String REF_TYPE_RECOMMEND = "1000101";
    public static final String REF_TYPE_RECOMMEND_GALLERY = "4000101";
    public static final String REF_TYPE_SEARCH = "3000901";
    public static final String REF_TYPE_SINGLE_GALLERY = "4001001";
    public static final String REF_TYPE_SINGLE_RECOMMEND = "1001001";
    public static final String REF_TYPE_USER_FAVOURITE = "1000303";

    public static int getJumpTypeByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith(GAME_NATIVE_PREFIX)) {
            return 1;
        }
        return str.startsWith("http") ? 2 : 0;
    }
}
