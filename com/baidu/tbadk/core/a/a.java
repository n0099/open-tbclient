package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a a = null;
    private static HashMap<String, Integer> b = new HashMap<>();
    private static ArrayList<String> c;
    private static HashMap<String, t<byte[]>> d;
    private static HashMap<String, t<String>> e;

    static {
        b.put("tb.pb_mark", 50);
        b.put("tb.pb_history", Integer.valueOf((int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI));
        b.put("tb.pb_normal", 1);
        b.put("tb.pb_editor", 50);
        b.put("tb.live_hotlist", 20);
        b.put("tb.live_hotlist", 20);
        b.put("tb.my_pages", 5);
        b.put("tb.my_forums", 3);
        b.put("tb.my_bookmarks", 3);
        b.put("tb.my_posts", 3);
        b.put("tb.im_frsgroup", 50);
        b.put("tb.im_hotgroup", 30);
        b.put("tb.im_groupinfo", 50);
        b.put("tb.im_groupactivity", 50);
        b.put("tb.im_entergroup", 10);
        b.put("tb.im_enterforum_groupinfo", 10);
        b.put("tb.im_group_setting", 3);
        b.put("tb.im_personal_chat_setting", 3);
        b.put("tb.im_official_chat_setting", 3);
        b.put("tb.im_group_search_history", 50);
        b.put("tb.im_official_history", 50);
        b.put("tb.square", 1);
        b.put("tb.first_dir", 1);
        b.put("tb.pic_gif", 50);
        b.put("tb.hao123", 1);
        b.put("tb.official_bar_menu", 1000);
        b.put("tb.friend_feed", 20);
        b.put("net_err_record", 30);
        b.put("tb_face_package", 30);
        b.put("tb.recommend_friend", 10);
        b.put("tb.searchperson_history", 10);
        b.put("tb.game_center_home", 20);
        c = new ArrayList<>();
        c.add("tb.square");
        c.add("tb.first_dir");
        c.add("tb.im_group_setting");
        c.add("tb.im_personal_chat_setting");
        c.add("tb.im_official_chat_setting");
        c.add("net_err_record");
        c.add("tb_user_profile");
        e = new HashMap<>();
        d = new HashMap<>();
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> a(String str) {
        return a(str, null);
    }

    public t<String> b(String str) {
        return b(str, null);
    }

    public t<byte[]> a(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = d.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService c2 = BdCacheService.c();
            Integer num = b.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (c.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = c2.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
            d.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> b(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = e.get(str3);
        BdCacheService c2 = BdCacheService.c();
        Integer num = b.get(str);
        if (num.intValue() == 0) {
            num = 20;
        }
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (c.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return c2.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return tVar;
        }
    }

    public void c(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = e.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.c().a(tVar);
                    e.remove(str);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
        }
    }

    public void c(String str) {
        c(str, null);
    }

    public void d(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<byte[]> tVar = d.get(str);
            if (tVar != null) {
                BdCacheService.c().a((t<?>) tVar);
                d.remove(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d.clear();
        e.clear();
    }
}
