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
    public static a bEj = null;
    private static HashMap<String, Integer> bEk = new HashMap<>();
    private static ArrayList<String> bEl;
    private static HashMap<String, l<byte[]>> bEm;
    private static HashMap<String, l<String>> bEn;

    static {
        bEk.put("tb.pb_mark", 50);
        bEk.put("tb.pb_history", 300);
        bEk.put("tb.pb_normal", 1);
        bEk.put("tb.pb_editor", 50);
        bEk.put("tb.live_hotlist", 20);
        bEk.put("tb.live_hotlist", 20);
        bEk.put("tb.my_pages", 5);
        bEk.put("tb.my_forums", 3);
        bEk.put("tb.my_bookmarks", 3);
        bEk.put("tb.my_posts", 3);
        bEk.put("tb.im_frsgroup", 50);
        bEk.put("tb.im_hotgroup", 30);
        bEk.put("tb.im_groupinfo", 50);
        bEk.put("tb.im_groupactivity", 50);
        bEk.put("tb.im_entergroup", 10);
        bEk.put("tb.im_enterforum_groupinfo", 10);
        bEk.put("tb.im_group_setting", 3);
        bEk.put("tb.im_personal_chat_setting", 3);
        bEk.put("tb.im_official_chat_setting", 3);
        bEk.put("tb.im_group_search_history", 50);
        bEk.put("tb.im_official_history", 50);
        bEk.put("tb.im_recommend_detail", 10);
        bEk.put("tb.square", 1);
        bEk.put("tb.first_dir", 1);
        bEk.put("tb.forum_rank", 20);
        bEk.put("tb.pic_gif", 50);
        bEk.put("tb.official_bar_menu", 1000);
        bEk.put("tb.friend_feed", 20);
        bEk.put("net_err_record", 30);
        bEk.put("tb_face_package", 30);
        bEk.put("tb.recommend_friend", 10);
        bEk.put("tb.searchperson_history", 5);
        bEk.put("tb.game_center_home", 20);
        bEk.put("tb.game_center_list", 20);
        bEk.put("tb.person_wallet_new", 10);
        bEk.put("tb.frs_hottopic", 100);
        bEl = new ArrayList<>();
        bEl.add("tb.ala.gift_list");
        bEl.add("tb.square");
        bEl.add("tb.first_dir");
        bEl.add("tb.forum_rank");
        bEl.add("tb.im_group_setting");
        bEl.add("tb.im_personal_chat_setting");
        bEl.add("tb.im_official_chat_setting");
        bEl.add("net_err_record");
        bEl.add("tb_user_profile");
        bEl.add("tb_forum_recommend");
        bEl.add("tb.ad_killer_tags");
        bEl.add("tb.manga.settings");
        bEl.add("tb.share_add_experienced");
        bEl.add("tb.write_privacy_state_space");
        bEn = new HashMap<>();
        bEm = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a aaW() {
        if (bEj == null) {
            bEj = new a();
        }
        return bEj;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> lu(String str) {
        return bu(str, null);
    }

    public l<String> lv(String str) {
        return bv(str, null);
    }

    public l<byte[]> bu(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = bEm.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = bEk.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bEl.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bEm.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bv(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bEn.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = bEk.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bEl.contains(str)) {
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
            l<String> lVar = bEn.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    bEn.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void lw(String str) {
        bw(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bEm.clear();
        bEn.clear();
    }
}
