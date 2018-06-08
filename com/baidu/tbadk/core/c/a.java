package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a akp = null;
    private static HashMap<String, Integer> akq = new HashMap<>();
    private static ArrayList<String> akr;
    private static HashMap<String, l<byte[]>> aks;
    private static HashMap<String, l<String>> akt;

    static {
        akq.put("tb.pb_mark", 50);
        akq.put("tb.pb_history", 300);
        akq.put("tb.pb_normal", 1);
        akq.put("tb.pb_editor", 50);
        akq.put("tb.live_hotlist", 20);
        akq.put("tb.live_hotlist", 20);
        akq.put("tb.my_pages", 5);
        akq.put("tb.my_forums", 3);
        akq.put("tb.my_bookmarks", 3);
        akq.put("tb.my_posts", 3);
        akq.put("tb.im_frsgroup", 50);
        akq.put("tb.im_hotgroup", 30);
        akq.put("tb.im_groupinfo", 50);
        akq.put("tb.im_groupactivity", 50);
        akq.put("tb.im_entergroup", 10);
        akq.put("tb.im_enterforum_groupinfo", 10);
        akq.put("tb.im_group_setting", 3);
        akq.put("tb.im_personal_chat_setting", 3);
        akq.put("tb.im_official_chat_setting", 3);
        akq.put("tb.im_group_search_history", 50);
        akq.put("tb.im_official_history", 50);
        akq.put("tb.im_recommend_detail", 10);
        akq.put("tb.square", 1);
        akq.put("tb.first_dir", 1);
        akq.put("tb.forum_rank", 20);
        akq.put("tb.pic_gif", 50);
        akq.put("tb.official_bar_menu", 1000);
        akq.put("tb.friend_feed", 20);
        akq.put("net_err_record", 30);
        akq.put("tb_face_package", 30);
        akq.put("tb.recommend_friend", 10);
        akq.put("tb.searchperson_history", 5);
        akq.put("tb.game_center_home", 20);
        akq.put("tb.game_center_list", 20);
        akq.put("tb.person_wallet_new", 10);
        akq.put("tb.frs_hottopic", 100);
        akr = new ArrayList<>();
        akr.add("tb.ala.gift_list");
        akr.add("tb.square");
        akr.add("tb.first_dir");
        akr.add("tb.forum_rank");
        akr.add("tb.im_group_setting");
        akr.add("tb.im_personal_chat_setting");
        akr.add("tb.im_official_chat_setting");
        akr.add("net_err_record");
        akr.add("tb_user_profile");
        akr.add("tb_forum_recommend");
        akr.add("tb.ad_killer_tags");
        akr.add("tb.manga.settings");
        akr.add("tb.share_add_experienced");
        akr.add("tb.write_privacy_state_space");
        akt = new HashMap<>();
        aks = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a wW() {
        if (akp == null) {
            akp = new a();
        }
        return akp;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> dx(String str) {
        return Q(str, null);
    }

    public l<String> dy(String str) {
        return R(str, null);
    }

    public l<byte[]> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aks.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService he = BdCacheService.he();
            Integer num = akq.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (akr.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = he.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aks.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = akt.get(str3);
        BdCacheService he = BdCacheService.he();
        Integer num = akq.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (akr.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return he.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void S(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = akt.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.he().a(lVar);
                    akt.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void dz(String str) {
        S(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aks.clear();
        akt.clear();
    }
}
