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
    public static a asB = null;
    private static HashMap<String, Integer> asC = new HashMap<>();
    private static ArrayList<String> asD;
    private static HashMap<String, l<byte[]>> asE;
    private static HashMap<String, l<String>> asF;

    static {
        asC.put("tb.pb_mark", 50);
        asC.put("tb.pb_history", 300);
        asC.put("tb.pb_normal", 1);
        asC.put("tb.pb_editor", 50);
        asC.put("tb.live_hotlist", 20);
        asC.put("tb.live_hotlist", 20);
        asC.put("tb.my_pages", 5);
        asC.put("tb.my_forums", 3);
        asC.put("tb.my_bookmarks", 3);
        asC.put("tb.my_posts", 3);
        asC.put("tb.im_frsgroup", 50);
        asC.put("tb.im_hotgroup", 30);
        asC.put("tb.im_groupinfo", 50);
        asC.put("tb.im_groupactivity", 50);
        asC.put("tb.im_entergroup", 10);
        asC.put("tb.im_enterforum_groupinfo", 10);
        asC.put("tb.im_group_setting", 3);
        asC.put("tb.im_personal_chat_setting", 3);
        asC.put("tb.im_official_chat_setting", 3);
        asC.put("tb.im_group_search_history", 50);
        asC.put("tb.im_official_history", 50);
        asC.put("tb.im_recommend_detail", 10);
        asC.put("tb.square", 1);
        asC.put("tb.first_dir", 1);
        asC.put("tb.forum_rank", 20);
        asC.put("tb.pic_gif", 50);
        asC.put("tb.official_bar_menu", 1000);
        asC.put("tb.friend_feed", 20);
        asC.put("net_err_record", 30);
        asC.put("tb_face_package", 30);
        asC.put("tb.recommend_friend", 10);
        asC.put("tb.searchperson_history", 5);
        asC.put("tb.game_center_home", 20);
        asC.put("tb.game_center_list", 20);
        asC.put("tb.person_wallet_new", 10);
        asC.put("tb.frs_hottopic", 100);
        asD = new ArrayList<>();
        asD.add("tb.ala.gift_list");
        asD.add("tb.square");
        asD.add("tb.first_dir");
        asD.add("tb.forum_rank");
        asD.add("tb.im_group_setting");
        asD.add("tb.im_personal_chat_setting");
        asD.add("tb.im_official_chat_setting");
        asD.add("net_err_record");
        asD.add("tb_user_profile");
        asD.add("tb_forum_recommend");
        asD.add("tb.ad_killer_tags");
        asD.add("tb.manga.settings");
        asD.add("tb.share_add_experienced");
        asD.add("tb.write_privacy_state_space");
        asF = new HashMap<>();
        asE = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a Ax() {
        if (asB == null) {
            asB = new a();
        }
        return asB;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> ef(String str) {
        return aj(str, null);
    }

    public l<String> eg(String str) {
        return ak(str, null);
    }

    public l<byte[]> aj(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = asE.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = asC.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (asD.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            asE.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> ak(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = asF.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = asC.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (asD.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return iy.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void al(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = asF.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    asF.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void eh(String str) {
        al(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        asE.clear();
        asF.clear();
    }
}
