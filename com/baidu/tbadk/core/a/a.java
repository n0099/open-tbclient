package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a Fe = null;
    private static HashMap<String, Integer> Ff = new HashMap<>();
    private static ArrayList<String> Fg;
    private static HashMap<String, t<byte[]>> Fh;
    private static HashMap<String, t<String>> Fi;

    static {
        Ff.put("tb.pb_mark", 50);
        Ff.put("tb.pb_history", 300);
        Ff.put("tb.pb_normal", 1);
        Ff.put("tb.pb_editor", 50);
        Ff.put("tb.live_hotlist", 20);
        Ff.put("tb.live_hotlist", 20);
        Ff.put("tb.my_pages", 5);
        Ff.put("tb.my_forums", 3);
        Ff.put("tb.my_bookmarks", 3);
        Ff.put("tb.my_posts", 3);
        Ff.put("tb.im_frsgroup", 50);
        Ff.put("tb.im_hotgroup", 30);
        Ff.put("tb.im_groupinfo", 50);
        Ff.put("tb.im_groupactivity", 50);
        Ff.put("tb.im_entergroup", 10);
        Ff.put("tb.im_enterforum_groupinfo", 10);
        Ff.put("tb.im_group_setting", 3);
        Ff.put("tb.im_personal_chat_setting", 3);
        Ff.put("tb.im_official_chat_setting", 3);
        Ff.put("tb.im_group_search_history", 50);
        Ff.put("tb.im_official_history", 50);
        Ff.put("tb.square", 1);
        Ff.put("tb.first_dir", 1);
        Ff.put("tb.pic_gif", 50);
        Ff.put("tb.hao123", 1);
        Ff.put("tb.official_bar_menu", 1000);
        Ff.put("tb.friend_feed", 20);
        Ff.put("net_err_record", 30);
        Ff.put("tb_face_package", 30);
        Ff.put("tb.recommend_friend", 10);
        Ff.put("tb.searchperson_history", 10);
        Ff.put("tb.game_center_home", 20);
        Ff.put("tb.game_center_list", 20);
        Fg = new ArrayList<>();
        Fg.add("tb.square");
        Fg.add("tb.first_dir");
        Fg.add("tb.im_group_setting");
        Fg.add("tb.im_personal_chat_setting");
        Fg.add("tb.im_official_chat_setting");
        Fg.add("net_err_record");
        Fg.add("tb_user_profile");
        Fg.add("tb_forum_recommend");
        Fi = new HashMap<>();
        Fh = new HashMap<>();
    }

    public static void cv() {
        Fe = null;
    }

    public static a nS() {
        if (Fe == null) {
            Fe = new a();
        }
        return Fe;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> bU(String str) {
        return N(str, null);
    }

    public t<String> bV(String str) {
        return O(str, null);
    }

    public t<byte[]> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = Fh.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService cS = BdCacheService.cS();
            Integer num = Ff.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Fg.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = cS.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Fh.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = Fi.get(str3);
        BdCacheService cS = BdCacheService.cS();
        Integer num = Ff.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Fg.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cS.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return tVar;
        }
    }

    public void P(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = Fi.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.cS().a(tVar);
                    Fi.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void bW(String str) {
        P(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fh.clear();
        Fi.clear();
    }
}
