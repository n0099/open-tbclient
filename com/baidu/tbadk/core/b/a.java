package com.baidu.tbadk.core.b;

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
    public static a Rs = null;
    private static HashMap<String, Integer> Rt = new HashMap<>();
    private static ArrayList<String> Ru;
    private static HashMap<String, t<byte[]>> Rv;
    private static HashMap<String, t<String>> Rw;

    static {
        Rt.put("tb.pb_mark", 50);
        Rt.put("tb.pb_history", 300);
        Rt.put("tb.pb_normal", 1);
        Rt.put("tb.pb_editor", 50);
        Rt.put("tb.live_hotlist", 20);
        Rt.put("tb.live_hotlist", 20);
        Rt.put("tb.my_pages", 5);
        Rt.put("tb.my_forums", 3);
        Rt.put("tb.my_bookmarks", 3);
        Rt.put("tb.my_posts", 3);
        Rt.put("tb.im_frsgroup", 50);
        Rt.put("tb.im_hotgroup", 30);
        Rt.put("tb.im_groupinfo", 50);
        Rt.put("tb.im_groupactivity", 50);
        Rt.put("tb.im_entergroup", 10);
        Rt.put("tb.im_enterforum_groupinfo", 10);
        Rt.put("tb.im_group_setting", 3);
        Rt.put("tb.im_personal_chat_setting", 3);
        Rt.put("tb.im_official_chat_setting", 3);
        Rt.put("tb.im_group_search_history", 50);
        Rt.put("tb.im_official_history", 50);
        Rt.put("tb.im_recommend_detail", 10);
        Rt.put("tb.square", 1);
        Rt.put("tb.first_dir", 1);
        Rt.put("tb.forum_rank", 20);
        Rt.put("tb.pic_gif", 50);
        Rt.put("tb.official_bar_menu", 1000);
        Rt.put("tb.friend_feed", 20);
        Rt.put("net_err_record", 30);
        Rt.put("tb_face_package", 30);
        Rt.put("tb.recommend_friend", 10);
        Rt.put("tb.searchperson_history", 5);
        Rt.put("tb.game_center_home", 20);
        Rt.put("tb.game_center_list", 20);
        Ru = new ArrayList<>();
        Ru.add("tb.square");
        Ru.add("tb.first_dir");
        Ru.add("tb.forum_rank");
        Ru.add("tb.im_group_setting");
        Ru.add("tb.im_personal_chat_setting");
        Ru.add("tb.im_official_chat_setting");
        Ru.add("net_err_record");
        Ru.add("tb_user_profile");
        Ru.add("tb_forum_recommend");
        Rw = new HashMap<>();
        Rv = new HashMap<>();
    }

    public static a rI() {
        if (Rs == null) {
            Rs = new a();
        }
        return Rs;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> cj(String str) {
        return V(str, null);
    }

    public t<String> ck(String str) {
        return W(str, null);
    }

    public t<byte[]> V(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = Rv.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService gt = BdCacheService.gt();
            Integer num = Rt.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Ru.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = gt.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Rv.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> W(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = Rw.get(str3);
        BdCacheService gt = BdCacheService.gt();
        Integer num = Rt.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Ru.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gt.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return tVar;
        }
    }

    public void X(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = Rw.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.gt().a(tVar);
                    Rw.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cl(String str) {
        X(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Rv.clear();
        Rw.clear();
    }
}
