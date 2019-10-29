package com.baidu.live.tbadk.log;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public interface ILiveGoodsLogger {
    public static final Set<Long> displayStoreIconMap = new HashSet();
    public static final Set<Long> displayGoodsListMap = new HashSet();
    public static final Set<Long> displayGoodsGuideMap = new HashSet();

    void doClickGoodsGuideLog(String str, String str2, String str3, String str4);

    void doDisplayGoodsGuideLog(String str, String str2, String str3, String str4);

    void doDisplayGoodsListLog(String str, String str2, String str3, String str4);

    void doDisplayStoreIconLog(String str, String str2, String str3, String str4);
}
