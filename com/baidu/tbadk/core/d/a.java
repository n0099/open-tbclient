package com.baidu.tbadk.core.d;

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
    public static a bMO = null;
    private static HashMap<String, Integer> bMP = new HashMap<>();
    private static ArrayList<String> bMQ;
    private static HashMap<String, l<byte[]>> bMR;
    private static HashMap<String, l<String>> bMS;

    static {
        bMP.put("tb.pb_mark", 50);
        bMP.put("tb.pb_history", 300);
        bMP.put("tb.pb_normal", 1);
        bMP.put("tb.pb_editor", 50);
        bMP.put("tb.live_hotlist", 20);
        bMP.put("tb.live_hotlist", 20);
        bMP.put("tb.my_pages", 5);
        bMP.put("tb.my_forums", 3);
        bMP.put("tb.my_bookmarks", 3);
        bMP.put("tb.my_posts", 3);
        bMP.put("tb.im_frsgroup", 50);
        bMP.put("tb.im_hotgroup", 30);
        bMP.put("tb.im_groupinfo", 50);
        bMP.put("tb.im_groupactivity", 50);
        bMP.put("tb.im_entergroup", 10);
        bMP.put("tb.im_enterforum_groupinfo", 10);
        bMP.put("tb.im_group_setting", 3);
        bMP.put("tb.im_personal_chat_setting", 3);
        bMP.put("tb.im_official_chat_setting", 3);
        bMP.put("tb.im_group_search_history", 50);
        bMP.put("tb.im_official_history", 50);
        bMP.put("tb.im_recommend_detail", 10);
        bMP.put("tb.square", 1);
        bMP.put("tb.first_dir", 1);
        bMP.put("tb.forum_rank", 20);
        bMP.put("tb.pic_gif", 50);
        bMP.put("tb.official_bar_menu", 1000);
        bMP.put("tb.friend_feed", 20);
        bMP.put("net_err_record", 30);
        bMP.put("tb_face_package", 30);
        bMP.put("tb.recommend_friend", 10);
        bMP.put("tb.searchperson_history", 5);
        bMP.put("tb.game_center_home", 20);
        bMP.put("tb.game_center_list", 20);
        bMP.put("tb.person_wallet_new", 10);
        bMP.put("tb.frs_hottopic", 100);
        bMQ = new ArrayList<>();
        bMQ.add("tb.ala.gift_list");
        bMQ.add("tb.square");
        bMQ.add("tb.first_dir");
        bMQ.add("tb.forum_rank");
        bMQ.add("tb.im_group_setting");
        bMQ.add("tb.im_personal_chat_setting");
        bMQ.add("tb.im_official_chat_setting");
        bMQ.add("net_err_record");
        bMQ.add("tb_user_profile");
        bMQ.add("tb_forum_recommend");
        bMQ.add("tb.ad_killer_tags");
        bMQ.add("tb.manga.settings");
        bMQ.add("tb.share_add_experienced");
        bMQ.add("tb.write_privacy_state_space");
        bMS = new HashMap<>();
        bMR = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a agH() {
        if (bMO == null) {
            bMO = new a();
        }
        return bMO;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> mK(String str) {
        return bD(str, null);
    }

    public l<String> mL(String str) {
        return bE(str, null);
    }

    public l<byte[]> bD(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bMR.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hA = BdCacheService.hA();
            Integer num = bMP.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bMQ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hA.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bMR.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bE(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bMS.get(str3);
        BdCacheService hA = BdCacheService.hA();
        Integer num = bMP.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bMQ.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return hA.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void bF(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = bMS.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hA().a(lVar);
                    bMS.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void mM(String str) {
        bF(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bMR.clear();
        bMS.clear();
    }
}
