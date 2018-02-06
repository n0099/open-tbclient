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
    public static a aQX = null;
    private static HashMap<String, Integer> aQY = new HashMap<>();
    private static ArrayList<String> aQZ;
    private static HashMap<String, l<byte[]>> aRa;
    private static HashMap<String, l<String>> aRb;

    static {
        aQY.put("tb.pb_mark", 50);
        aQY.put("tb.pb_history", 300);
        aQY.put("tb.pb_normal", 1);
        aQY.put("tb.pb_editor", 50);
        aQY.put("tb.live_hotlist", 20);
        aQY.put("tb.live_hotlist", 20);
        aQY.put("tb.my_pages", 5);
        aQY.put("tb.my_forums", 3);
        aQY.put("tb.my_bookmarks", 3);
        aQY.put("tb.my_posts", 3);
        aQY.put("tb.im_frsgroup", 50);
        aQY.put("tb.im_hotgroup", 30);
        aQY.put("tb.im_groupinfo", 50);
        aQY.put("tb.im_groupactivity", 50);
        aQY.put("tb.im_entergroup", 10);
        aQY.put("tb.im_enterforum_groupinfo", 10);
        aQY.put("tb.im_group_setting", 3);
        aQY.put("tb.im_personal_chat_setting", 3);
        aQY.put("tb.im_official_chat_setting", 3);
        aQY.put("tb.im_group_search_history", 50);
        aQY.put("tb.im_official_history", 50);
        aQY.put("tb.im_recommend_detail", 10);
        aQY.put("tb.square", 1);
        aQY.put("tb.first_dir", 1);
        aQY.put("tb.forum_rank", 20);
        aQY.put("tb.pic_gif", 50);
        aQY.put("tb.official_bar_menu", 1000);
        aQY.put("tb.friend_feed", 20);
        aQY.put("net_err_record", 30);
        aQY.put("tb_face_package", 30);
        aQY.put("tb.recommend_friend", 10);
        aQY.put("tb.searchperson_history", 5);
        aQY.put("tb.game_center_home", 20);
        aQY.put("tb.game_center_list", 20);
        aQY.put("tb.person_wallet_new", 10);
        aQZ = new ArrayList<>();
        aQZ.add("tb.ala.gift_list");
        aQZ.add("tb.square");
        aQZ.add("tb.first_dir");
        aQZ.add("tb.forum_rank");
        aQZ.add("tb.im_group_setting");
        aQZ.add("tb.im_personal_chat_setting");
        aQZ.add("tb.im_official_chat_setting");
        aQZ.add("net_err_record");
        aQZ.add("tb_user_profile");
        aQZ.add("tb_forum_recommend");
        aQZ.add("tb.ad_killer_tags");
        aQZ.add("tb.manga.settings");
        aQZ.add("tb.share_add_experienced");
        aQZ.add("tb.write_privacy_state_space");
        aRb = new HashMap<>();
        aRa = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a AQ() {
        if (aQX == null) {
            aQX = new a();
        }
        return aQX;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> dg(String str) {
        return M(str, null);
    }

    public l<String> dh(String str) {
        return N(str, null);
    }

    public l<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aRa.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mj = BdCacheService.mj();
            Integer num = aQY.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aQZ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mj.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aRa.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aRb.get(str3);
        BdCacheService mj = BdCacheService.mj();
        Integer num = aQY.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aQZ.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return mj.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = aRb.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mj().a(lVar);
                    aRb.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void di(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aRa.clear();
        aRb.clear();
    }
}
