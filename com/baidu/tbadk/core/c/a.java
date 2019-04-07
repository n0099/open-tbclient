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
    public static a bEo = null;
    private static HashMap<String, Integer> bEp = new HashMap<>();
    private static ArrayList<String> bEq;
    private static HashMap<String, l<byte[]>> bEr;
    private static HashMap<String, l<String>> bEs;

    static {
        bEp.put("tb.pb_mark", 50);
        bEp.put("tb.pb_history", 300);
        bEp.put("tb.pb_normal", 1);
        bEp.put("tb.pb_editor", 50);
        bEp.put("tb.live_hotlist", 20);
        bEp.put("tb.live_hotlist", 20);
        bEp.put("tb.my_pages", 5);
        bEp.put("tb.my_forums", 3);
        bEp.put("tb.my_bookmarks", 3);
        bEp.put("tb.my_posts", 3);
        bEp.put("tb.im_frsgroup", 50);
        bEp.put("tb.im_hotgroup", 30);
        bEp.put("tb.im_groupinfo", 50);
        bEp.put("tb.im_groupactivity", 50);
        bEp.put("tb.im_entergroup", 10);
        bEp.put("tb.im_enterforum_groupinfo", 10);
        bEp.put("tb.im_group_setting", 3);
        bEp.put("tb.im_personal_chat_setting", 3);
        bEp.put("tb.im_official_chat_setting", 3);
        bEp.put("tb.im_group_search_history", 50);
        bEp.put("tb.im_official_history", 50);
        bEp.put("tb.im_recommend_detail", 10);
        bEp.put("tb.square", 1);
        bEp.put("tb.first_dir", 1);
        bEp.put("tb.forum_rank", 20);
        bEp.put("tb.pic_gif", 50);
        bEp.put("tb.official_bar_menu", 1000);
        bEp.put("tb.friend_feed", 20);
        bEp.put("net_err_record", 30);
        bEp.put("tb_face_package", 30);
        bEp.put("tb.recommend_friend", 10);
        bEp.put("tb.searchperson_history", 5);
        bEp.put("tb.game_center_home", 20);
        bEp.put("tb.game_center_list", 20);
        bEp.put("tb.person_wallet_new", 10);
        bEp.put("tb.frs_hottopic", 100);
        bEq = new ArrayList<>();
        bEq.add("tb.ala.gift_list");
        bEq.add("tb.square");
        bEq.add("tb.first_dir");
        bEq.add("tb.forum_rank");
        bEq.add("tb.im_group_setting");
        bEq.add("tb.im_personal_chat_setting");
        bEq.add("tb.im_official_chat_setting");
        bEq.add("net_err_record");
        bEq.add("tb_user_profile");
        bEq.add("tb_forum_recommend");
        bEq.add("tb.ad_killer_tags");
        bEq.add("tb.manga.settings");
        bEq.add("tb.share_add_experienced");
        bEq.add("tb.write_privacy_state_space");
        bEs = new HashMap<>();
        bEr = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a aaT() {
        if (bEo == null) {
            bEo = new a();
        }
        return bEo;
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
        l<byte[]> lVar = bEr.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = bEp.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bEq.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bEr.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bv(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bEs.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = bEp.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bEq.contains(str)) {
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
            l<String> lVar = bEs.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    bEs.remove(str);
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
        bEr.clear();
        bEs.clear();
    }
}
