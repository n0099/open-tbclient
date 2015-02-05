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
    public static a Fg = null;
    private static HashMap<String, Integer> Fh = new HashMap<>();
    private static ArrayList<String> Fi;
    private static HashMap<String, t<byte[]>> Fj;
    private static HashMap<String, t<String>> Fk;

    static {
        Fh.put("tb.pb_mark", 50);
        Fh.put("tb.pb_history", 300);
        Fh.put("tb.pb_normal", 1);
        Fh.put("tb.pb_editor", 50);
        Fh.put("tb.live_hotlist", 20);
        Fh.put("tb.live_hotlist", 20);
        Fh.put("tb.my_pages", 5);
        Fh.put("tb.my_forums", 3);
        Fh.put("tb.my_bookmarks", 3);
        Fh.put("tb.my_posts", 3);
        Fh.put("tb.im_frsgroup", 50);
        Fh.put("tb.im_hotgroup", 30);
        Fh.put("tb.im_groupinfo", 50);
        Fh.put("tb.im_groupactivity", 50);
        Fh.put("tb.im_entergroup", 10);
        Fh.put("tb.im_enterforum_groupinfo", 10);
        Fh.put("tb.im_group_setting", 3);
        Fh.put("tb.im_personal_chat_setting", 3);
        Fh.put("tb.im_official_chat_setting", 3);
        Fh.put("tb.im_group_search_history", 50);
        Fh.put("tb.im_official_history", 50);
        Fh.put("tb.square", 1);
        Fh.put("tb.first_dir", 1);
        Fh.put("tb.pic_gif", 50);
        Fh.put("tb.official_bar_menu", 1000);
        Fh.put("tb.friend_feed", 20);
        Fh.put("net_err_record", 30);
        Fh.put("tb_face_package", 30);
        Fh.put("tb.recommend_friend", 10);
        Fh.put("tb.searchperson_history", 10);
        Fh.put("tb.game_center_home", 20);
        Fh.put("tb.game_center_list", 20);
        Fi = new ArrayList<>();
        Fi.add("tb.square");
        Fi.add("tb.first_dir");
        Fi.add("tb.im_group_setting");
        Fi.add("tb.im_personal_chat_setting");
        Fi.add("tb.im_official_chat_setting");
        Fi.add("net_err_record");
        Fi.add("tb_user_profile");
        Fi.add("tb_forum_recommend");
        Fk = new HashMap<>();
        Fj = new HashMap<>();
    }

    public static void ct() {
        Fg = null;
    }

    public static a nO() {
        if (Fg == null) {
            Fg = new a();
        }
        return Fg;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> bP(String str) {
        return Q(str, null);
    }

    public t<String> bQ(String str) {
        return R(str, null);
    }

    public t<byte[]> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = Fj.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService cQ = BdCacheService.cQ();
            Integer num = Fh.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Fi.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = cQ.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Fj.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = Fk.get(str3);
        BdCacheService cQ = BdCacheService.cQ();
        Integer num = Fh.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Fi.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cQ.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return tVar;
        }
    }

    public void S(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = Fk.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.cQ().a(tVar);
                    Fk.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void bR(String str) {
        S(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fj.clear();
        Fk.clear();
    }
}
