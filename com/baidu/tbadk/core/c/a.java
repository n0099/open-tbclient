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
    public static a aQM = null;
    private static HashMap<String, Integer> aQN = new HashMap<>();
    private static ArrayList<String> aQO;
    private static HashMap<String, l<byte[]>> aQP;
    private static HashMap<String, l<String>> aQQ;

    static {
        aQN.put("tb.pb_mark", 50);
        aQN.put("tb.pb_history", 300);
        aQN.put("tb.pb_normal", 1);
        aQN.put("tb.pb_editor", 50);
        aQN.put("tb.live_hotlist", 20);
        aQN.put("tb.live_hotlist", 20);
        aQN.put("tb.my_pages", 5);
        aQN.put("tb.my_forums", 3);
        aQN.put("tb.my_bookmarks", 3);
        aQN.put("tb.my_posts", 3);
        aQN.put("tb.im_frsgroup", 50);
        aQN.put("tb.im_hotgroup", 30);
        aQN.put("tb.im_groupinfo", 50);
        aQN.put("tb.im_groupactivity", 50);
        aQN.put("tb.im_entergroup", 10);
        aQN.put("tb.im_enterforum_groupinfo", 10);
        aQN.put("tb.im_group_setting", 3);
        aQN.put("tb.im_personal_chat_setting", 3);
        aQN.put("tb.im_official_chat_setting", 3);
        aQN.put("tb.im_group_search_history", 50);
        aQN.put("tb.im_official_history", 50);
        aQN.put("tb.im_recommend_detail", 10);
        aQN.put("tb.square", 1);
        aQN.put("tb.first_dir", 1);
        aQN.put("tb.forum_rank", 20);
        aQN.put("tb.pic_gif", 50);
        aQN.put("tb.official_bar_menu", 1000);
        aQN.put("tb.friend_feed", 20);
        aQN.put("net_err_record", 30);
        aQN.put("tb_face_package", 30);
        aQN.put("tb.recommend_friend", 10);
        aQN.put("tb.searchperson_history", 5);
        aQN.put("tb.game_center_home", 20);
        aQN.put("tb.game_center_list", 20);
        aQN.put("tb.person_wallet_new", 10);
        aQO = new ArrayList<>();
        aQO.add("tb.ala.gift_list");
        aQO.add("tb.square");
        aQO.add("tb.first_dir");
        aQO.add("tb.forum_rank");
        aQO.add("tb.im_group_setting");
        aQO.add("tb.im_personal_chat_setting");
        aQO.add("tb.im_official_chat_setting");
        aQO.add("net_err_record");
        aQO.add("tb_user_profile");
        aQO.add("tb_forum_recommend");
        aQO.add("tb.ad_killer_tags");
        aQO.add("tb.manga.settings");
        aQO.add("tb.share_add_experienced");
        aQO.add("tb.write_privacy_state_space");
        aQQ = new HashMap<>();
        aQP = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a AQ() {
        if (aQM == null) {
            aQM = new a();
        }
        return aQM;
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
        l<byte[]> lVar = aQP.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mj = BdCacheService.mj();
            Integer num = aQN.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aQO.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mj.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aQP.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aQQ.get(str3);
        BdCacheService mj = BdCacheService.mj();
        Integer num = aQN.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aQO.contains(str)) {
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
            l<String> lVar = aQQ.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mj().a(lVar);
                    aQQ.remove(str);
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
        aQP.clear();
        aQQ.clear();
    }
}
