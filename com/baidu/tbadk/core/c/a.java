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
    public static a acl = null;
    private static HashMap<String, Integer> acm = new HashMap<>();
    private static ArrayList<String> acn;
    private static HashMap<String, l<byte[]>> aco;
    private static HashMap<String, l<String>> acp;

    static {
        acm.put("tb.pb_mark", 50);
        acm.put("tb.pb_history", 300);
        acm.put("tb.pb_normal", 1);
        acm.put("tb.pb_editor", 50);
        acm.put("tb.live_hotlist", 20);
        acm.put("tb.live_hotlist", 20);
        acm.put("tb.my_pages", 5);
        acm.put("tb.my_forums", 3);
        acm.put("tb.my_bookmarks", 3);
        acm.put("tb.my_posts", 3);
        acm.put("tb.im_frsgroup", 50);
        acm.put("tb.im_hotgroup", 30);
        acm.put("tb.im_groupinfo", 50);
        acm.put("tb.im_groupactivity", 50);
        acm.put("tb.im_entergroup", 10);
        acm.put("tb.im_enterforum_groupinfo", 10);
        acm.put("tb.im_group_setting", 3);
        acm.put("tb.im_personal_chat_setting", 3);
        acm.put("tb.im_official_chat_setting", 3);
        acm.put("tb.im_group_search_history", 50);
        acm.put("tb.im_official_history", 50);
        acm.put("tb.im_recommend_detail", 10);
        acm.put("tb.square", 1);
        acm.put("tb.first_dir", 1);
        acm.put("tb.forum_rank", 20);
        acm.put("tb.pic_gif", 50);
        acm.put("tb.official_bar_menu", 1000);
        acm.put("tb.friend_feed", 20);
        acm.put("net_err_record", 30);
        acm.put("tb_face_package", 30);
        acm.put("tb.recommend_friend", 10);
        acm.put("tb.searchperson_history", 5);
        acm.put("tb.game_center_home", 20);
        acm.put("tb.game_center_list", 20);
        acm.put("tb.person_wallet_new", 10);
        acm.put("tb.frs_hottopic", 100);
        acn = new ArrayList<>();
        acn.add("tb.ala.gift_list");
        acn.add("tb.square");
        acn.add("tb.first_dir");
        acn.add("tb.forum_rank");
        acn.add("tb.im_group_setting");
        acn.add("tb.im_personal_chat_setting");
        acn.add("tb.im_official_chat_setting");
        acn.add("net_err_record");
        acn.add("tb_user_profile");
        acn.add("tb_forum_recommend");
        acn.add("tb.ad_killer_tags");
        acn.add("tb.manga.settings");
        acn.add("tb.share_add_experienced");
        acn.add("tb.write_privacy_state_space");
        acp = new HashMap<>();
        aco = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a ty() {
        if (acl == null) {
            acl = new a();
        }
        return acl;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cY(String str) {
        return N(str, null);
    }

    public l<String> cZ(String str) {
        return O(str, null);
    }

    public l<byte[]> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aco.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService en = BdCacheService.en();
            Integer num = acm.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (acn.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = en.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aco.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = acp.get(str3);
        BdCacheService en = BdCacheService.en();
        Integer num = acm.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (acn.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return en.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void P(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = acp.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.en().a(lVar);
                    acp.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void da(String str) {
        P(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aco.clear();
        acp.clear();
    }
}
