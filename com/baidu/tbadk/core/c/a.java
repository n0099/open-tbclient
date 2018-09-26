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
    public static a amT = null;
    private static HashMap<String, Integer> amU = new HashMap<>();
    private static ArrayList<String> amV;
    private static HashMap<String, l<byte[]>> amW;
    private static HashMap<String, l<String>> amX;

    static {
        amU.put("tb.pb_mark", 50);
        amU.put("tb.pb_history", 300);
        amU.put("tb.pb_normal", 1);
        amU.put("tb.pb_editor", 50);
        amU.put("tb.live_hotlist", 20);
        amU.put("tb.live_hotlist", 20);
        amU.put("tb.my_pages", 5);
        amU.put("tb.my_forums", 3);
        amU.put("tb.my_bookmarks", 3);
        amU.put("tb.my_posts", 3);
        amU.put("tb.im_frsgroup", 50);
        amU.put("tb.im_hotgroup", 30);
        amU.put("tb.im_groupinfo", 50);
        amU.put("tb.im_groupactivity", 50);
        amU.put("tb.im_entergroup", 10);
        amU.put("tb.im_enterforum_groupinfo", 10);
        amU.put("tb.im_group_setting", 3);
        amU.put("tb.im_personal_chat_setting", 3);
        amU.put("tb.im_official_chat_setting", 3);
        amU.put("tb.im_group_search_history", 50);
        amU.put("tb.im_official_history", 50);
        amU.put("tb.im_recommend_detail", 10);
        amU.put("tb.square", 1);
        amU.put("tb.first_dir", 1);
        amU.put("tb.forum_rank", 20);
        amU.put("tb.pic_gif", 50);
        amU.put("tb.official_bar_menu", 1000);
        amU.put("tb.friend_feed", 20);
        amU.put("net_err_record", 30);
        amU.put("tb_face_package", 30);
        amU.put("tb.recommend_friend", 10);
        amU.put("tb.searchperson_history", 5);
        amU.put("tb.game_center_home", 20);
        amU.put("tb.game_center_list", 20);
        amU.put("tb.person_wallet_new", 10);
        amU.put("tb.frs_hottopic", 100);
        amV = new ArrayList<>();
        amV.add("tb.ala.gift_list");
        amV.add("tb.square");
        amV.add("tb.first_dir");
        amV.add("tb.forum_rank");
        amV.add("tb.im_group_setting");
        amV.add("tb.im_personal_chat_setting");
        amV.add("tb.im_official_chat_setting");
        amV.add("net_err_record");
        amV.add("tb_user_profile");
        amV.add("tb_forum_recommend");
        amV.add("tb.ad_killer_tags");
        amV.add("tb.manga.settings");
        amV.add("tb.share_add_experienced");
        amV.add("tb.write_privacy_state_space");
        amX = new HashMap<>();
        amW = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a yh() {
        if (amT == null) {
            amT = new a();
        }
        return amT;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> dP(String str) {
        return W(str, null);
    }

    public l<String> dQ(String str) {
        return X(str, null);
    }

    public l<byte[]> W(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = amW.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService ij = BdCacheService.ij();
            Integer num = amU.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (amV.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = ij.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            amW.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> X(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = amX.get(str3);
        BdCacheService ij = BdCacheService.ij();
        Integer num = amU.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (amV.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return ij.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void Y(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = amX.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.ij().a(lVar);
                    amX.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void dR(String str) {
        Y(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        amW.clear();
        amX.clear();
    }
}
