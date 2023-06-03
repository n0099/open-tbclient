package com.baidu.searchbox.toolbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.R;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class CommonToolBarStyle {
    public static final int TOOL_BAR_STYLE_AD_IMMERSIVE_LANDING_PAGE = 9;
    public static final int TOOL_BAR_STYLE_BROWSER = 2;
    public static final int TOOL_BAR_STYLE_COMMENTS = 7;
    @Deprecated
    public static final int TOOL_BAR_STYLE_FEED = 1;
    public static final int TOOL_BAR_STYLE_LANDING = 5;
    public static final int TOOL_BAR_STYLE_LANDING_AND_INPUT_COMMENTS = 8;
    public static final int TOOL_BAR_STYLE_LANDING_VERTICAL = 15;
    public static final int TOOL_BAR_STYLE_LANDING_VERTICAL_OPTIMIZATION = 18;
    public static final int TOOL_BAR_STYLE_LIVESHOW = 10;
    public static final int TOOL_BAR_STYLE_NEWS = 4;
    public static final int TOOL_BAR_STYLE_NO = -1;
    public static final int TOOL_BAR_STYLE_NS = 3;
    public static final int TOOL_BAR_STYLE_PHOTOS = 6;
    public static final int TOOL_BAR_STYLE_SEARCH_VIDEO_LANDING = 19;
    public static final int TOOL_ITEM_BACK = 1;
    @Deprecated
    public static final int TOOL_ITEM_CANCEL = 11;
    public static final int TOOL_ITEM_CLOSE = 18;
    public static final int TOOL_ITEM_COMMENTINPUT = 10;
    public static final int TOOL_ITEM_COMMENTS = 7;
    public static final int TOOL_ITEM_COMMENT_EMOTION = 21;
    public static final int TOOL_ITEM_COMMENT_IMG = 20;
    public static final int TOOL_ITEM_COMMENT_INPUT_WITH_SHORTCUT = 22;
    public static final int TOOL_ITEM_COMMENT_TEXT = 25;
    public static final int TOOL_ITEM_DANMA_COMMENTINPUT = 19;
    public static final int TOOL_ITEM_FORWARDING = 15;
    public static final int TOOL_ITEM_FORWDRD = 12;
    public static final int TOOL_ITEM_GROUP_TOPIC = 28;
    public static final int TOOL_ITEM_HOME = 2;
    public static final int TOOL_ITEM_JOIN_IN = 24;
    @Deprecated
    public static final int TOOL_ITEM_MENU = 6;
    public static final int TOOL_ITEM_MORE = 17;
    public static final int TOOL_ITEM_MultiWindows = 16;
    public static final int TOOL_ITEM_POST_QUESTION = 27;
    public static final int TOOL_ITEM_PRAISE = 13;
    public static final int TOOL_ITEM_RECOMMEND = 23;
    public static final int TOOL_ITEM_REFRESH = 5;
    public static final int TOOL_ITEM_SHARE = 9;
    public static final int TOOL_ITEM_SPLIT = 26;
    public static final int TOOL_ITEM_STAR = 8;
    @Deprecated
    public static final int TOOL_ITEM_TTS = 3;
    public static final int TOOL_ITEM_VOICE = 4;
    public static final int TOOL_ITEM_WENDA = 14;

    public static List<BaseToolBarItem> getSearchToolBarItemList(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0707bb);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0707bc);
        ArrayList arrayList = new ArrayList();
        RedTipImageView redTipImageView = new RedTipImageView(context);
        redTipImageView.setIcon(R.drawable.obfuscated_res_0x7f080516);
        redTipImageView.setPadding(dimensionPixelOffset, 0, 0, 0);
        redTipImageView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset, -1, 1.0f));
        arrayList.add(new BaseToolBarItem(1, redTipImageView));
        SelectorImageView selectorImageView = new SelectorImageView(context);
        selectorImageView.setScaleType(ImageView.ScaleType.CENTER);
        selectorImageView.setImageResource(R.drawable.obfuscated_res_0x7f080527);
        selectorImageView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        arrayList.add(new BaseToolBarItem(17, selectorImageView));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset2, 0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset2 * 2, -1, 1.0f));
        arrayList.add(new BaseToolBarItem(4, linearLayout));
        SelectorImageView selectorImageView2 = new SelectorImageView(context);
        selectorImageView2.setScaleType(ImageView.ScaleType.CENTER);
        selectorImageView2.setImageResource(R.drawable.obfuscated_res_0x7f08052d);
        selectorImageView2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        arrayList.add(new BaseToolBarItem(9, selectorImageView2));
        SelectorImageView selectorImageView3 = new SelectorImageView(context);
        selectorImageView3.setScaleType(ImageView.ScaleType.CENTER);
        selectorImageView3.setImageResource(R.drawable.obfuscated_res_0x7f080524);
        selectorImageView3.setPadding(0, 0, dimensionPixelOffset, 0);
        selectorImageView3.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset, -1, 1.0f));
        arrayList.add(new BaseToolBarItem(2, selectorImageView3));
        return arrayList;
    }

    @Deprecated
    public static void handleStatistic(BaseToolBarItem baseToolBarItem, String str, HashMap<String, String> hashMap) {
        if (baseToolBarItem == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("from", str);
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        int itemId = baseToolBarItem.getItemId();
        if (itemId != 1) {
            if (itemId != 2) {
                if (itemId != 5) {
                    if (itemId != 6) {
                        if (itemId != 7) {
                            if (itemId != 16) {
                                if (itemId != 17) {
                                    if (itemId != 22) {
                                        if (itemId != 24) {
                                            switch (itemId) {
                                                case 9:
                                                    uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_SHARE, hashMap2);
                                                    return;
                                                case 10:
                                                    break;
                                                case 11:
                                                    uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_STOP, hashMap2);
                                                    return;
                                                case 12:
                                                    hashMap2.put("type", CommonToolbarStatisticConstants.TOOLBAR_MENU_TYPE_FORWARD);
                                                    uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_FORWARD, hashMap2);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        } else {
                                            hashMap2.put("type", CommonToolbarStatisticConstants.TOOLBAR_MENU_BACK_TYPE_TOOLBAR);
                                            uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_COMMENT_INPUT, hashMap2);
                                            return;
                                        }
                                    }
                                    uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_COMMENT_INPUT, hashMap2);
                                    return;
                                }
                                hashMap2.put("from", "tool");
                                hashMap2.put("type", CommonToolbarStatisticConstants.TOOLBAR_MENU_TYPE_MENU);
                                uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_MENU, hashMap2);
                                return;
                            }
                            uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_MULTI_WINDOW, hashMap2);
                            return;
                        }
                        uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_COMMENTS, hashMap2);
                        return;
                    }
                    uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_MENU, hashMap2);
                    return;
                }
                uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_REFRESH, hashMap2);
                return;
            }
            uBCManager.onEvent(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_KEY_HOME, hashMap2);
            return;
        }
        hashMap2.put("type", CommonToolbarStatisticConstants.TOOLBAR_MENU_BACK_TYPE_TOOLBAR);
        uBCManager.onEvent("206", hashMap2);
    }
}
