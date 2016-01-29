package com.baidu.tbadk.core.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a XN = null;
    private static HashMap<String, Integer> XO = new HashMap<>();
    private static ArrayList<String> XP;
    private static HashMap<String, o<byte[]>> XQ;
    private static HashMap<String, o<String>> XR;

    static {
        XO.put("tb.pb_mark", 50);
        XO.put("tb.pb_history", 300);
        XO.put("tb.pb_normal", 1);
        XO.put("tb.pb_editor", 50);
        XO.put("tb.live_hotlist", 20);
        XO.put("tb.live_hotlist", 20);
        XO.put("tb.my_pages", 5);
        XO.put("tb.my_forums", 3);
        XO.put("tb.my_bookmarks", 3);
        XO.put("tb.my_posts", 3);
        XO.put("tb.im_frsgroup", 50);
        XO.put("tb.im_hotgroup", 30);
        XO.put("tb.im_groupinfo", 50);
        XO.put("tb.im_groupactivity", 50);
        XO.put("tb.im_entergroup", 10);
        XO.put("tb.im_enterforum_groupinfo", 10);
        XO.put("tb.im_group_setting", 3);
        XO.put("tb.im_personal_chat_setting", 3);
        XO.put("tb.im_official_chat_setting", 3);
        XO.put("tb.im_group_search_history", 50);
        XO.put("tb.im_official_history", 50);
        XO.put("tb.im_recommend_detail", 10);
        XO.put("tb.square", 1);
        XO.put("tb.first_dir", 1);
        XO.put("tb.forum_rank", 20);
        XO.put("tb.pic_gif", 50);
        XO.put("tb.official_bar_menu", 1000);
        XO.put("tb.friend_feed", 20);
        XO.put("net_err_record", 30);
        XO.put("tb_face_package", 30);
        XO.put("tb.recommend_friend", 10);
        XO.put("tb.searchperson_history", 5);
        XO.put("tb.game_center_home", 20);
        XO.put("tb.game_center_list", 20);
        XP = new ArrayList<>();
        XP.add("tb.square");
        XP.add("tb.first_dir");
        XP.add("tb.forum_rank");
        XP.add("tb.im_group_setting");
        XP.add("tb.im_personal_chat_setting");
        XP.add("tb.im_official_chat_setting");
        XP.add("net_err_record");
        XP.add("tb_user_profile");
        XP.add("tb_forum_recommend");
        XP.add("tb.ad_killer_tags");
        XR = new HashMap<>();
        XQ = new HashMap<>();
    }

    public static a ug() {
        if (XN == null) {
            XN = new a();
        }
        return XN;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cA(String str) {
        return P(str, null);
    }

    public o<String> cB(String str) {
        return Q(str, null);
    }

    public o<byte[]> P(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = XQ.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gs = BdCacheService.gs();
            Integer num = XO.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (XP.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gs.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            XQ.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = XR.get(str3);
        BdCacheService gs = BdCacheService.gs();
        Integer num = XO.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (XP.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gs.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void R(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = XR.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gs().a(oVar);
                    XR.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cC(String str) {
        R(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        XQ.clear();
        XR.clear();
    }
}
