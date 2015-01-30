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
    public static a Fj = null;
    private static HashMap<String, Integer> Fk = new HashMap<>();
    private static ArrayList<String> Fl;
    private static HashMap<String, t<byte[]>> Fm;
    private static HashMap<String, t<String>> Fn;

    static {
        Fk.put("tb.pb_mark", 50);
        Fk.put("tb.pb_history", 300);
        Fk.put("tb.pb_normal", 1);
        Fk.put("tb.pb_editor", 50);
        Fk.put("tb.live_hotlist", 20);
        Fk.put("tb.live_hotlist", 20);
        Fk.put("tb.my_pages", 5);
        Fk.put("tb.my_forums", 3);
        Fk.put("tb.my_bookmarks", 3);
        Fk.put("tb.my_posts", 3);
        Fk.put("tb.im_frsgroup", 50);
        Fk.put("tb.im_hotgroup", 30);
        Fk.put("tb.im_groupinfo", 50);
        Fk.put("tb.im_groupactivity", 50);
        Fk.put("tb.im_entergroup", 10);
        Fk.put("tb.im_enterforum_groupinfo", 10);
        Fk.put("tb.im_group_setting", 3);
        Fk.put("tb.im_personal_chat_setting", 3);
        Fk.put("tb.im_official_chat_setting", 3);
        Fk.put("tb.im_group_search_history", 50);
        Fk.put("tb.im_official_history", 50);
        Fk.put("tb.square", 1);
        Fk.put("tb.first_dir", 1);
        Fk.put("tb.pic_gif", 50);
        Fk.put("tb.official_bar_menu", 1000);
        Fk.put("tb.friend_feed", 20);
        Fk.put("net_err_record", 30);
        Fk.put("tb_face_package", 30);
        Fk.put("tb.recommend_friend", 10);
        Fk.put("tb.searchperson_history", 10);
        Fk.put("tb.game_center_home", 20);
        Fk.put("tb.game_center_list", 20);
        Fl = new ArrayList<>();
        Fl.add("tb.square");
        Fl.add("tb.first_dir");
        Fl.add("tb.im_group_setting");
        Fl.add("tb.im_personal_chat_setting");
        Fl.add("tb.im_official_chat_setting");
        Fl.add("net_err_record");
        Fl.add("tb_user_profile");
        Fl.add("tb_forum_recommend");
        Fn = new HashMap<>();
        Fm = new HashMap<>();
    }

    public static void ct() {
        Fj = null;
    }

    public static a nV() {
        if (Fj == null) {
            Fj = new a();
        }
        return Fj;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> bS(String str) {
        return Q(str, null);
    }

    public t<String> bT(String str) {
        return R(str, null);
    }

    public t<byte[]> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = Fm.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService cQ = BdCacheService.cQ();
            Integer num = Fk.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Fl.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = cQ.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Fm.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = Fn.get(str3);
        BdCacheService cQ = BdCacheService.cQ();
        Integer num = Fk.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Fl.contains(str)) {
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
            t<String> tVar = Fn.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.cQ().a(tVar);
                    Fn.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void bU(String str) {
        S(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fm.clear();
        Fn.clear();
    }
}
