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
    public static a AR = null;
    private static HashMap<String, Integer> AS = new HashMap<>();
    private static ArrayList<String> AT;
    private static HashMap<String, t<byte[]>> AU;
    private static HashMap<String, t<String>> AV;

    static {
        AS.put("tb.pb_mark", 50);
        AS.put("tb.pb_history", Integer.valueOf((int) TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI));
        AS.put("tb.pb_normal", 1);
        AS.put("tb.pb_editor", 50);
        AS.put("tb.live_hotlist", 20);
        AS.put("tb.live_hotlist", 20);
        AS.put("tb.my_pages", 5);
        AS.put("tb.my_forums", 3);
        AS.put("tb.my_bookmarks", 3);
        AS.put("tb.my_posts", 3);
        AS.put("tb.im_frsgroup", 50);
        AS.put("tb.im_hotgroup", 30);
        AS.put("tb.im_groupinfo", 50);
        AS.put("tb.im_groupactivity", 50);
        AS.put("tb.im_entergroup", 10);
        AS.put("tb.im_enterforum_groupinfo", 10);
        AS.put("tb.im_group_setting", 3);
        AS.put("tb.im_personal_chat_setting", 3);
        AS.put("tb.im_official_chat_setting", 3);
        AS.put("tb.im_group_search_history", 50);
        AS.put("tb.im_official_history", 50);
        AS.put("tb.square", 1);
        AS.put("tb.first_dir", 1);
        AS.put("tb.pic_gif", 50);
        AS.put("tb.hao123", 1);
        AS.put("tb.official_bar_menu", 1000);
        AS.put("tb.friend_feed", 20);
        AS.put("net_err_record", 30);
        AS.put("tb_face_package", 30);
        AS.put("tb.recommend_friend", 10);
        AS.put("tb.searchperson_history", 10);
        AS.put("tb.game_center_home", 20);
        AS.put("tb.game_center_list", 20);
        AT = new ArrayList<>();
        AT.add("tb.square");
        AT.add("tb.first_dir");
        AT.add("tb.im_group_setting");
        AT.add("tb.im_personal_chat_setting");
        AT.add("tb.im_official_chat_setting");
        AT.add("net_err_record");
        AT.add("tb_user_profile");
        AT.add("tb_forum_recommend");
        AV = new HashMap<>();
        AU = new HashMap<>();
    }

    public static a kS() {
        if (AR == null) {
            AR = new a();
        }
        return AR;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> bc(String str) {
        return C(str, null);
    }

    public t<String> bd(String str) {
        return D(str, null);
    }

    public t<byte[]> C(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = AU.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService cr = BdCacheService.cr();
            Integer num = AS.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (AT.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = cr.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            AU.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> D(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = AV.get(str3);
        BdCacheService cr = BdCacheService.cr();
        Integer num = AS.get(str);
        if (num.intValue() == 0) {
            num = 20;
        }
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (AT.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return cr.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return tVar;
        }
    }

    public void E(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = AV.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.cr().a(tVar);
                    AV.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void be(String str) {
        E(str, null);
    }

    public void F(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<byte[]> tVar = AU.get(str);
            if (tVar != null) {
                BdCacheService.cr().a(tVar);
                AU.remove(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AU.clear();
        AV.clear();
    }
}
