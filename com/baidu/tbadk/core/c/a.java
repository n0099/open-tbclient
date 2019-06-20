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
    public static a bLJ = null;
    private static HashMap<String, Integer> bLK = new HashMap<>();
    private static ArrayList<String> bLL;
    private static HashMap<String, l<byte[]>> bLM;
    private static HashMap<String, l<String>> bLN;

    static {
        bLK.put("tb.pb_mark", 50);
        bLK.put("tb.pb_history", 300);
        bLK.put("tb.pb_normal", 1);
        bLK.put("tb.pb_editor", 50);
        bLK.put("tb.live_hotlist", 20);
        bLK.put("tb.live_hotlist", 20);
        bLK.put("tb.my_pages", 5);
        bLK.put("tb.my_forums", 3);
        bLK.put("tb.my_bookmarks", 3);
        bLK.put("tb.my_posts", 3);
        bLK.put("tb.im_frsgroup", 50);
        bLK.put("tb.im_hotgroup", 30);
        bLK.put("tb.im_groupinfo", 50);
        bLK.put("tb.im_groupactivity", 50);
        bLK.put("tb.im_entergroup", 10);
        bLK.put("tb.im_enterforum_groupinfo", 10);
        bLK.put("tb.im_group_setting", 3);
        bLK.put("tb.im_personal_chat_setting", 3);
        bLK.put("tb.im_official_chat_setting", 3);
        bLK.put("tb.im_group_search_history", 50);
        bLK.put("tb.im_official_history", 50);
        bLK.put("tb.im_recommend_detail", 10);
        bLK.put("tb.square", 1);
        bLK.put("tb.first_dir", 1);
        bLK.put("tb.forum_rank", 20);
        bLK.put("tb.pic_gif", 50);
        bLK.put("tb.official_bar_menu", 1000);
        bLK.put("tb.friend_feed", 20);
        bLK.put("net_err_record", 30);
        bLK.put("tb_face_package", 30);
        bLK.put("tb.recommend_friend", 10);
        bLK.put("tb.searchperson_history", 5);
        bLK.put("tb.game_center_home", 20);
        bLK.put("tb.game_center_list", 20);
        bLK.put("tb.person_wallet_new", 10);
        bLK.put("tb.frs_hottopic", 100);
        bLL = new ArrayList<>();
        bLL.add("tb.ala.gift_list");
        bLL.add("tb.square");
        bLL.add("tb.first_dir");
        bLL.add("tb.forum_rank");
        bLL.add("tb.im_group_setting");
        bLL.add("tb.im_personal_chat_setting");
        bLL.add("tb.im_official_chat_setting");
        bLL.add("net_err_record");
        bLL.add("tb_user_profile");
        bLL.add("tb_forum_recommend");
        bLL.add("tb.ad_killer_tags");
        bLL.add("tb.manga.settings");
        bLL.add("tb.share_add_experienced");
        bLL.add("tb.write_privacy_state_space");
        bLN = new HashMap<>();
        bLM = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a afD() {
        if (bLJ == null) {
            bLJ = new a();
        }
        return bLJ;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> mz(String str) {
        return bD(str, null);
    }

    public l<String> mA(String str) {
        return bE(str, null);
    }

    public l<byte[]> bD(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bLM.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hq = BdCacheService.hq();
            Integer num = bLK.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bLL.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hq.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bLM.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bE(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bLN.get(str3);
        BdCacheService hq = BdCacheService.hq();
        Integer num = bLK.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bLL.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return hq.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            l<String> lVar = bLN.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hq().a(lVar);
                    bLN.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void mB(String str) {
        bF(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bLM.clear();
        bLN.clear();
    }
}
