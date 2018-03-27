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
    public static a aQO = null;
    private static HashMap<String, Integer> aQP = new HashMap<>();
    private static ArrayList<String> aQQ;
    private static HashMap<String, l<byte[]>> aQR;
    private static HashMap<String, l<String>> aQS;

    static {
        aQP.put("tb.pb_mark", 50);
        aQP.put("tb.pb_history", 300);
        aQP.put("tb.pb_normal", 1);
        aQP.put("tb.pb_editor", 50);
        aQP.put("tb.live_hotlist", 20);
        aQP.put("tb.live_hotlist", 20);
        aQP.put("tb.my_pages", 5);
        aQP.put("tb.my_forums", 3);
        aQP.put("tb.my_bookmarks", 3);
        aQP.put("tb.my_posts", 3);
        aQP.put("tb.im_frsgroup", 50);
        aQP.put("tb.im_hotgroup", 30);
        aQP.put("tb.im_groupinfo", 50);
        aQP.put("tb.im_groupactivity", 50);
        aQP.put("tb.im_entergroup", 10);
        aQP.put("tb.im_enterforum_groupinfo", 10);
        aQP.put("tb.im_group_setting", 3);
        aQP.put("tb.im_personal_chat_setting", 3);
        aQP.put("tb.im_official_chat_setting", 3);
        aQP.put("tb.im_group_search_history", 50);
        aQP.put("tb.im_official_history", 50);
        aQP.put("tb.im_recommend_detail", 10);
        aQP.put("tb.square", 1);
        aQP.put("tb.first_dir", 1);
        aQP.put("tb.forum_rank", 20);
        aQP.put("tb.pic_gif", 50);
        aQP.put("tb.official_bar_menu", 1000);
        aQP.put("tb.friend_feed", 20);
        aQP.put("net_err_record", 30);
        aQP.put("tb_face_package", 30);
        aQP.put("tb.recommend_friend", 10);
        aQP.put("tb.searchperson_history", 5);
        aQP.put("tb.game_center_home", 20);
        aQP.put("tb.game_center_list", 20);
        aQP.put("tb.person_wallet_new", 10);
        aQQ = new ArrayList<>();
        aQQ.add("tb.ala.gift_list");
        aQQ.add("tb.square");
        aQQ.add("tb.first_dir");
        aQQ.add("tb.forum_rank");
        aQQ.add("tb.im_group_setting");
        aQQ.add("tb.im_personal_chat_setting");
        aQQ.add("tb.im_official_chat_setting");
        aQQ.add("net_err_record");
        aQQ.add("tb_user_profile");
        aQQ.add("tb_forum_recommend");
        aQQ.add("tb.ad_killer_tags");
        aQQ.add("tb.manga.settings");
        aQQ.add("tb.share_add_experienced");
        aQQ.add("tb.write_privacy_state_space");
        aQS = new HashMap<>();
        aQR = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a AR() {
        if (aQO == null) {
            aQO = new a();
        }
        return aQO;
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
        l<byte[]> lVar = aQR.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mj = BdCacheService.mj();
            Integer num = aQP.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aQQ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mj.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aQR.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aQS.get(str3);
        BdCacheService mj = BdCacheService.mj();
        Integer num = aQP.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aQQ.contains(str)) {
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
            l<String> lVar = aQS.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mj().a(lVar);
                    aQS.remove(str);
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
        aQR.clear();
        aQS.clear();
    }
}
