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
    public static a bLI = null;
    private static HashMap<String, Integer> bLJ = new HashMap<>();
    private static ArrayList<String> bLK;
    private static HashMap<String, l<byte[]>> bLL;
    private static HashMap<String, l<String>> bLM;

    static {
        bLJ.put("tb.pb_mark", 50);
        bLJ.put("tb.pb_history", 300);
        bLJ.put("tb.pb_normal", 1);
        bLJ.put("tb.pb_editor", 50);
        bLJ.put("tb.live_hotlist", 20);
        bLJ.put("tb.live_hotlist", 20);
        bLJ.put("tb.my_pages", 5);
        bLJ.put("tb.my_forums", 3);
        bLJ.put("tb.my_bookmarks", 3);
        bLJ.put("tb.my_posts", 3);
        bLJ.put("tb.im_frsgroup", 50);
        bLJ.put("tb.im_hotgroup", 30);
        bLJ.put("tb.im_groupinfo", 50);
        bLJ.put("tb.im_groupactivity", 50);
        bLJ.put("tb.im_entergroup", 10);
        bLJ.put("tb.im_enterforum_groupinfo", 10);
        bLJ.put("tb.im_group_setting", 3);
        bLJ.put("tb.im_personal_chat_setting", 3);
        bLJ.put("tb.im_official_chat_setting", 3);
        bLJ.put("tb.im_group_search_history", 50);
        bLJ.put("tb.im_official_history", 50);
        bLJ.put("tb.im_recommend_detail", 10);
        bLJ.put("tb.square", 1);
        bLJ.put("tb.first_dir", 1);
        bLJ.put("tb.forum_rank", 20);
        bLJ.put("tb.pic_gif", 50);
        bLJ.put("tb.official_bar_menu", 1000);
        bLJ.put("tb.friend_feed", 20);
        bLJ.put("net_err_record", 30);
        bLJ.put("tb_face_package", 30);
        bLJ.put("tb.recommend_friend", 10);
        bLJ.put("tb.searchperson_history", 5);
        bLJ.put("tb.game_center_home", 20);
        bLJ.put("tb.game_center_list", 20);
        bLJ.put("tb.person_wallet_new", 10);
        bLJ.put("tb.frs_hottopic", 100);
        bLK = new ArrayList<>();
        bLK.add("tb.ala.gift_list");
        bLK.add("tb.square");
        bLK.add("tb.first_dir");
        bLK.add("tb.forum_rank");
        bLK.add("tb.im_group_setting");
        bLK.add("tb.im_personal_chat_setting");
        bLK.add("tb.im_official_chat_setting");
        bLK.add("net_err_record");
        bLK.add("tb_user_profile");
        bLK.add("tb_forum_recommend");
        bLK.add("tb.ad_killer_tags");
        bLK.add("tb.manga.settings");
        bLK.add("tb.share_add_experienced");
        bLK.add("tb.write_privacy_state_space");
        bLM = new HashMap<>();
        bLL = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a afD() {
        if (bLI == null) {
            bLI = new a();
        }
        return bLI;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> mA(String str) {
        return bD(str, null);
    }

    public l<String> mB(String str) {
        return bE(str, null);
    }

    public l<byte[]> bD(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bLL.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hq = BdCacheService.hq();
            Integer num = bLJ.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bLK.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hq.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bLL.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bE(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bLM.get(str3);
        BdCacheService hq = BdCacheService.hq();
        Integer num = bLJ.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bLK.contains(str)) {
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
            l<String> lVar = bLM.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hq().a(lVar);
                    bLM.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void mC(String str) {
        bF(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bLL.clear();
        bLM.clear();
    }
}
