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
    public static a RI = null;
    private static HashMap<String, Integer> RJ = new HashMap<>();
    private static ArrayList<String> RK;
    private static HashMap<String, o<byte[]>> RL;
    private static HashMap<String, o<String>> RM;

    static {
        RJ.put("tb.pb_mark", 50);
        RJ.put("tb.pb_history", 300);
        RJ.put("tb.pb_normal", 1);
        RJ.put("tb.pb_editor", 50);
        RJ.put("tb.live_hotlist", 20);
        RJ.put("tb.live_hotlist", 20);
        RJ.put("tb.my_pages", 5);
        RJ.put("tb.my_forums", 3);
        RJ.put("tb.my_bookmarks", 3);
        RJ.put("tb.my_posts", 3);
        RJ.put("tb.im_frsgroup", 50);
        RJ.put("tb.im_hotgroup", 30);
        RJ.put("tb.im_groupinfo", 50);
        RJ.put("tb.im_groupactivity", 50);
        RJ.put("tb.im_entergroup", 10);
        RJ.put("tb.im_enterforum_groupinfo", 10);
        RJ.put("tb.im_group_setting", 3);
        RJ.put("tb.im_personal_chat_setting", 3);
        RJ.put("tb.im_official_chat_setting", 3);
        RJ.put("tb.im_group_search_history", 50);
        RJ.put("tb.im_official_history", 50);
        RJ.put("tb.im_recommend_detail", 10);
        RJ.put("tb.square", 1);
        RJ.put("tb.first_dir", 1);
        RJ.put("tb.forum_rank", 20);
        RJ.put("tb.pic_gif", 50);
        RJ.put("tb.official_bar_menu", 1000);
        RJ.put("tb.friend_feed", 20);
        RJ.put("net_err_record", 30);
        RJ.put("tb_face_package", 30);
        RJ.put("tb.recommend_friend", 10);
        RJ.put("tb.searchperson_history", 5);
        RJ.put("tb.game_center_home", 20);
        RJ.put("tb.game_center_list", 20);
        RJ.put("tb.ecomm", 5);
        RJ.put("tb.person_wallet_new", 10);
        RK = new ArrayList<>();
        RK.add("tb.square");
        RK.add("tb.first_dir");
        RK.add("tb.forum_rank");
        RK.add("tb.im_group_setting");
        RK.add("tb.im_personal_chat_setting");
        RK.add("tb.im_official_chat_setting");
        RK.add("net_err_record");
        RK.add("tb_user_profile");
        RK.add("tb_forum_recommend");
        RK.add("tb.ad_killer_tags");
        RK.add("tb.manga.settings");
        RM = new HashMap<>();
        RL = new HashMap<>();
    }

    public static a rP() {
        if (RI == null) {
            RI = new a();
        }
        return RI;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cv(String str) {
        return M(str, null);
    }

    public o<String> cw(String str) {
        return N(str, null);
    }

    public o<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = RL.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService cH = BdCacheService.cH();
            Integer num = RJ.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (RK.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = cH.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            RL.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = RM.get(str3);
        BdCacheService cH = BdCacheService.cH();
        Integer num = RJ.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (RK.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cH.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = RM.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.cH().a(oVar);
                    RM.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cx(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        RL.clear();
        RM.clear();
    }
}
