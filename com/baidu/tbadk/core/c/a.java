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
    public static a bEp = null;
    private static HashMap<String, Integer> bEq = new HashMap<>();
    private static ArrayList<String> bEr;
    private static HashMap<String, l<byte[]>> bEs;
    private static HashMap<String, l<String>> bEt;

    static {
        bEq.put("tb.pb_mark", 50);
        bEq.put("tb.pb_history", 300);
        bEq.put("tb.pb_normal", 1);
        bEq.put("tb.pb_editor", 50);
        bEq.put("tb.live_hotlist", 20);
        bEq.put("tb.live_hotlist", 20);
        bEq.put("tb.my_pages", 5);
        bEq.put("tb.my_forums", 3);
        bEq.put("tb.my_bookmarks", 3);
        bEq.put("tb.my_posts", 3);
        bEq.put("tb.im_frsgroup", 50);
        bEq.put("tb.im_hotgroup", 30);
        bEq.put("tb.im_groupinfo", 50);
        bEq.put("tb.im_groupactivity", 50);
        bEq.put("tb.im_entergroup", 10);
        bEq.put("tb.im_enterforum_groupinfo", 10);
        bEq.put("tb.im_group_setting", 3);
        bEq.put("tb.im_personal_chat_setting", 3);
        bEq.put("tb.im_official_chat_setting", 3);
        bEq.put("tb.im_group_search_history", 50);
        bEq.put("tb.im_official_history", 50);
        bEq.put("tb.im_recommend_detail", 10);
        bEq.put("tb.square", 1);
        bEq.put("tb.first_dir", 1);
        bEq.put("tb.forum_rank", 20);
        bEq.put("tb.pic_gif", 50);
        bEq.put("tb.official_bar_menu", 1000);
        bEq.put("tb.friend_feed", 20);
        bEq.put("net_err_record", 30);
        bEq.put("tb_face_package", 30);
        bEq.put("tb.recommend_friend", 10);
        bEq.put("tb.searchperson_history", 5);
        bEq.put("tb.game_center_home", 20);
        bEq.put("tb.game_center_list", 20);
        bEq.put("tb.person_wallet_new", 10);
        bEq.put("tb.frs_hottopic", 100);
        bEr = new ArrayList<>();
        bEr.add("tb.ala.gift_list");
        bEr.add("tb.square");
        bEr.add("tb.first_dir");
        bEr.add("tb.forum_rank");
        bEr.add("tb.im_group_setting");
        bEr.add("tb.im_personal_chat_setting");
        bEr.add("tb.im_official_chat_setting");
        bEr.add("net_err_record");
        bEr.add("tb_user_profile");
        bEr.add("tb_forum_recommend");
        bEr.add("tb.ad_killer_tags");
        bEr.add("tb.manga.settings");
        bEr.add("tb.share_add_experienced");
        bEr.add("tb.write_privacy_state_space");
        bEt = new HashMap<>();
        bEs = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a aaT() {
        if (bEp == null) {
            bEp = new a();
        }
        return bEp;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> lv(String str) {
        return bu(str, null);
    }

    public l<String> lw(String str) {
        return bv(str, null);
    }

    public l<byte[]> bu(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bEs.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = bEq.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bEr.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bEs.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bv(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bEt.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = bEq.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bEr.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return iy.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void bw(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = bEt.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    bEt.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void lx(String str) {
        bw(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bEs.clear();
        bEt.clear();
    }
}
