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
    public static a arO = null;
    private static HashMap<String, Integer> arP = new HashMap<>();
    private static ArrayList<String> arQ;
    private static HashMap<String, l<byte[]>> arR;
    private static HashMap<String, l<String>> arS;

    static {
        arP.put("tb.pb_mark", 50);
        arP.put("tb.pb_history", 300);
        arP.put("tb.pb_normal", 1);
        arP.put("tb.pb_editor", 50);
        arP.put("tb.live_hotlist", 20);
        arP.put("tb.live_hotlist", 20);
        arP.put("tb.my_pages", 5);
        arP.put("tb.my_forums", 3);
        arP.put("tb.my_bookmarks", 3);
        arP.put("tb.my_posts", 3);
        arP.put("tb.im_frsgroup", 50);
        arP.put("tb.im_hotgroup", 30);
        arP.put("tb.im_groupinfo", 50);
        arP.put("tb.im_groupactivity", 50);
        arP.put("tb.im_entergroup", 10);
        arP.put("tb.im_enterforum_groupinfo", 10);
        arP.put("tb.im_group_setting", 3);
        arP.put("tb.im_personal_chat_setting", 3);
        arP.put("tb.im_official_chat_setting", 3);
        arP.put("tb.im_group_search_history", 50);
        arP.put("tb.im_official_history", 50);
        arP.put("tb.im_recommend_detail", 10);
        arP.put("tb.square", 1);
        arP.put("tb.first_dir", 1);
        arP.put("tb.forum_rank", 20);
        arP.put("tb.pic_gif", 50);
        arP.put("tb.official_bar_menu", 1000);
        arP.put("tb.friend_feed", 20);
        arP.put("net_err_record", 30);
        arP.put("tb_face_package", 30);
        arP.put("tb.recommend_friend", 10);
        arP.put("tb.searchperson_history", 5);
        arP.put("tb.game_center_home", 20);
        arP.put("tb.game_center_list", 20);
        arP.put("tb.person_wallet_new", 10);
        arP.put("tb.frs_hottopic", 100);
        arQ = new ArrayList<>();
        arQ.add("tb.ala.gift_list");
        arQ.add("tb.square");
        arQ.add("tb.first_dir");
        arQ.add("tb.forum_rank");
        arQ.add("tb.im_group_setting");
        arQ.add("tb.im_personal_chat_setting");
        arQ.add("tb.im_official_chat_setting");
        arQ.add("net_err_record");
        arQ.add("tb_user_profile");
        arQ.add("tb_forum_recommend");
        arQ.add("tb.ad_killer_tags");
        arQ.add("tb.manga.settings");
        arQ.add("tb.share_add_experienced");
        arQ.add("tb.write_privacy_state_space");
        arS = new HashMap<>();
        arR = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a Aq() {
        if (arO == null) {
            arO = new a();
        }
        return arO;
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
        l<byte[]> lVar = arR.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iz = BdCacheService.iz();
            Integer num = arP.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (arQ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iz.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            arR.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> ak(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = arS.get(str3);
        BdCacheService iz = BdCacheService.iz();
        Integer num = arP.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (arQ.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return iz.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            l<String> lVar = arS.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iz().a(lVar);
                    arS.remove(str);
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
        arR.clear();
        arS.clear();
    }
}
