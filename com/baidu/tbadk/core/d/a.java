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
    public static a bMJ = null;
    private static HashMap<String, Integer> bMK = new HashMap<>();
    private static ArrayList<String> bML;
    private static HashMap<String, l<byte[]>> bMM;
    private static HashMap<String, l<String>> bMN;

    static {
        bMK.put("tb.pb_mark", 50);
        bMK.put("tb.pb_history", 300);
        bMK.put("tb.pb_normal", 1);
        bMK.put("tb.pb_editor", 50);
        bMK.put("tb.live_hotlist", 20);
        bMK.put("tb.live_hotlist", 20);
        bMK.put("tb.my_pages", 5);
        bMK.put("tb.my_forums", 3);
        bMK.put("tb.my_bookmarks", 3);
        bMK.put("tb.my_posts", 3);
        bMK.put("tb.im_frsgroup", 50);
        bMK.put("tb.im_hotgroup", 30);
        bMK.put("tb.im_groupinfo", 50);
        bMK.put("tb.im_groupactivity", 50);
        bMK.put("tb.im_entergroup", 10);
        bMK.put("tb.im_enterforum_groupinfo", 10);
        bMK.put("tb.im_group_setting", 3);
        bMK.put("tb.im_personal_chat_setting", 3);
        bMK.put("tb.im_official_chat_setting", 3);
        bMK.put("tb.im_group_search_history", 50);
        bMK.put("tb.im_official_history", 50);
        bMK.put("tb.im_recommend_detail", 10);
        bMK.put("tb.square", 1);
        bMK.put("tb.first_dir", 1);
        bMK.put("tb.forum_rank", 20);
        bMK.put("tb.pic_gif", 50);
        bMK.put("tb.official_bar_menu", 1000);
        bMK.put("tb.friend_feed", 20);
        bMK.put("net_err_record", 30);
        bMK.put("tb_face_package", 30);
        bMK.put("tb.recommend_friend", 10);
        bMK.put("tb.searchperson_history", 5);
        bMK.put("tb.game_center_home", 20);
        bMK.put("tb.game_center_list", 20);
        bMK.put("tb.person_wallet_new", 10);
        bMK.put("tb.frs_hottopic", 100);
        bML = new ArrayList<>();
        bML.add("tb.ala.gift_list");
        bML.add("tb.square");
        bML.add("tb.first_dir");
        bML.add("tb.forum_rank");
        bML.add("tb.im_group_setting");
        bML.add("tb.im_personal_chat_setting");
        bML.add("tb.im_official_chat_setting");
        bML.add("net_err_record");
        bML.add("tb_user_profile");
        bML.add("tb_forum_recommend");
        bML.add("tb.ad_killer_tags");
        bML.add("tb.manga.settings");
        bML.add("tb.share_add_experienced");
        bML.add("tb.write_privacy_state_space");
        bMN = new HashMap<>();
        bMM = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a agF() {
        if (bMJ == null) {
            bMJ = new a();
        }
        return bMJ;
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
        l<byte[]> lVar = bMM.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hA = BdCacheService.hA();
            Integer num = bMK.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bML.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hA.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bMM.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bE(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bMN.get(str3);
        BdCacheService hA = BdCacheService.hA();
        Integer num = bMK.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bML.contains(str)) {
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
            l<String> lVar = bMN.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hA().a(lVar);
                    bMN.remove(str);
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
        bMM.clear();
        bMN.clear();
    }
}
