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
    public static a bNn = null;
    private static HashMap<String, Integer> bNo = new HashMap<>();
    private static ArrayList<String> bNp;
    private static HashMap<String, l<byte[]>> bNq;
    private static HashMap<String, l<String>> bNr;

    static {
        bNo.put("tb.pb_mark", 50);
        bNo.put("tb.pb_history", 300);
        bNo.put("tb.pb_normal", 1);
        bNo.put("tb.pb_editor", 50);
        bNo.put("tb.live_hotlist", 20);
        bNo.put("tb.live_hotlist", 20);
        bNo.put("tb.my_pages", 5);
        bNo.put("tb.my_forums", 3);
        bNo.put("tb.my_bookmarks", 3);
        bNo.put("tb.my_posts", 3);
        bNo.put("tb.im_frsgroup", 50);
        bNo.put("tb.im_hotgroup", 30);
        bNo.put("tb.im_groupinfo", 50);
        bNo.put("tb.im_groupactivity", 50);
        bNo.put("tb.im_entergroup", 10);
        bNo.put("tb.im_enterforum_groupinfo", 10);
        bNo.put("tb.im_group_setting", 3);
        bNo.put("tb.im_personal_chat_setting", 3);
        bNo.put("tb.im_official_chat_setting", 3);
        bNo.put("tb.im_group_search_history", 50);
        bNo.put("tb.im_official_history", 50);
        bNo.put("tb.im_recommend_detail", 10);
        bNo.put("tb.square", 1);
        bNo.put("tb.first_dir", 1);
        bNo.put("tb.forum_rank", 20);
        bNo.put("tb.pic_gif", 50);
        bNo.put("tb.official_bar_menu", 1000);
        bNo.put("tb.friend_feed", 20);
        bNo.put("net_err_record", 30);
        bNo.put("tb_face_package", 30);
        bNo.put("tb.recommend_friend", 10);
        bNo.put("tb.searchperson_history", 5);
        bNo.put("tb.game_center_home", 20);
        bNo.put("tb.game_center_list", 20);
        bNo.put("tb.person_wallet_new", 10);
        bNo.put("tb.frs_hottopic", 100);
        bNp = new ArrayList<>();
        bNp.add("tb.ala.gift_list");
        bNp.add("tb.square");
        bNp.add("tb.first_dir");
        bNp.add("tb.forum_rank");
        bNp.add("tb.im_group_setting");
        bNp.add("tb.im_personal_chat_setting");
        bNp.add("tb.im_official_chat_setting");
        bNp.add("net_err_record");
        bNp.add("tb_user_profile");
        bNp.add("tb_forum_recommend");
        bNp.add("tb.ad_killer_tags");
        bNp.add("tb.manga.settings");
        bNp.add("tb.share_add_experienced");
        bNp.add("tb.write_privacy_state_space");
        bNr = new HashMap<>();
        bNq = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a agL() {
        if (bNn == null) {
            bNn = new a();
        }
        return bNn;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> mM(String str) {
        return bD(str, null);
    }

    public l<String> mN(String str) {
        return bE(str, null);
    }

    public l<byte[]> bD(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bNq.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hA = BdCacheService.hA();
            Integer num = bNo.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bNp.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hA.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bNq.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bE(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bNr.get(str3);
        BdCacheService hA = BdCacheService.hA();
        Integer num = bNo.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bNp.contains(str)) {
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
            l<String> lVar = bNr.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hA().a(lVar);
                    bNr.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void mO(String str) {
        bF(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bNq.clear();
        bNr.clear();
    }
}
