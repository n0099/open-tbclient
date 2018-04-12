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
    public static a ack = null;
    private static HashMap<String, Integer> acl = new HashMap<>();
    private static ArrayList<String> acm;
    private static HashMap<String, l<byte[]>> acn;
    private static HashMap<String, l<String>> aco;

    static {
        acl.put("tb.pb_mark", 50);
        acl.put("tb.pb_history", 300);
        acl.put("tb.pb_normal", 1);
        acl.put("tb.pb_editor", 50);
        acl.put("tb.live_hotlist", 20);
        acl.put("tb.live_hotlist", 20);
        acl.put("tb.my_pages", 5);
        acl.put("tb.my_forums", 3);
        acl.put("tb.my_bookmarks", 3);
        acl.put("tb.my_posts", 3);
        acl.put("tb.im_frsgroup", 50);
        acl.put("tb.im_hotgroup", 30);
        acl.put("tb.im_groupinfo", 50);
        acl.put("tb.im_groupactivity", 50);
        acl.put("tb.im_entergroup", 10);
        acl.put("tb.im_enterforum_groupinfo", 10);
        acl.put("tb.im_group_setting", 3);
        acl.put("tb.im_personal_chat_setting", 3);
        acl.put("tb.im_official_chat_setting", 3);
        acl.put("tb.im_group_search_history", 50);
        acl.put("tb.im_official_history", 50);
        acl.put("tb.im_recommend_detail", 10);
        acl.put("tb.square", 1);
        acl.put("tb.first_dir", 1);
        acl.put("tb.forum_rank", 20);
        acl.put("tb.pic_gif", 50);
        acl.put("tb.official_bar_menu", 1000);
        acl.put("tb.friend_feed", 20);
        acl.put("net_err_record", 30);
        acl.put("tb_face_package", 30);
        acl.put("tb.recommend_friend", 10);
        acl.put("tb.searchperson_history", 5);
        acl.put("tb.game_center_home", 20);
        acl.put("tb.game_center_list", 20);
        acl.put("tb.person_wallet_new", 10);
        acl.put("tb.frs_hottopic", 100);
        acm = new ArrayList<>();
        acm.add("tb.ala.gift_list");
        acm.add("tb.square");
        acm.add("tb.first_dir");
        acm.add("tb.forum_rank");
        acm.add("tb.im_group_setting");
        acm.add("tb.im_personal_chat_setting");
        acm.add("tb.im_official_chat_setting");
        acm.add("net_err_record");
        acm.add("tb_user_profile");
        acm.add("tb_forum_recommend");
        acm.add("tb.ad_killer_tags");
        acm.add("tb.manga.settings");
        acm.add("tb.share_add_experienced");
        acm.add("tb.write_privacy_state_space");
        aco = new HashMap<>();
        acn = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a tz() {
        if (ack == null) {
            ack = new a();
        }
        return ack;
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
        l<byte[]> lVar = acn.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService en = BdCacheService.en();
            Integer num = acl.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (acm.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = en.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            acn.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> O(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aco.get(str3);
        BdCacheService en = BdCacheService.en();
        Integer num = acl.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (acm.contains(str)) {
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
            l<String> lVar = aco.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.en().a(lVar);
                    aco.remove(str);
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
        acn.clear();
        aco.clear();
    }
}
