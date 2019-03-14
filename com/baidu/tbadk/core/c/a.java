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
    public static a bEl = null;
    private static HashMap<String, Integer> bEm = new HashMap<>();
    private static ArrayList<String> bEn;
    private static HashMap<String, l<byte[]>> bEo;
    private static HashMap<String, l<String>> bEp;

    static {
        bEm.put("tb.pb_mark", 50);
        bEm.put("tb.pb_history", 300);
        bEm.put("tb.pb_normal", 1);
        bEm.put("tb.pb_editor", 50);
        bEm.put("tb.live_hotlist", 20);
        bEm.put("tb.live_hotlist", 20);
        bEm.put("tb.my_pages", 5);
        bEm.put("tb.my_forums", 3);
        bEm.put("tb.my_bookmarks", 3);
        bEm.put("tb.my_posts", 3);
        bEm.put("tb.im_frsgroup", 50);
        bEm.put("tb.im_hotgroup", 30);
        bEm.put("tb.im_groupinfo", 50);
        bEm.put("tb.im_groupactivity", 50);
        bEm.put("tb.im_entergroup", 10);
        bEm.put("tb.im_enterforum_groupinfo", 10);
        bEm.put("tb.im_group_setting", 3);
        bEm.put("tb.im_personal_chat_setting", 3);
        bEm.put("tb.im_official_chat_setting", 3);
        bEm.put("tb.im_group_search_history", 50);
        bEm.put("tb.im_official_history", 50);
        bEm.put("tb.im_recommend_detail", 10);
        bEm.put("tb.square", 1);
        bEm.put("tb.first_dir", 1);
        bEm.put("tb.forum_rank", 20);
        bEm.put("tb.pic_gif", 50);
        bEm.put("tb.official_bar_menu", 1000);
        bEm.put("tb.friend_feed", 20);
        bEm.put("net_err_record", 30);
        bEm.put("tb_face_package", 30);
        bEm.put("tb.recommend_friend", 10);
        bEm.put("tb.searchperson_history", 5);
        bEm.put("tb.game_center_home", 20);
        bEm.put("tb.game_center_list", 20);
        bEm.put("tb.person_wallet_new", 10);
        bEm.put("tb.frs_hottopic", 100);
        bEn = new ArrayList<>();
        bEn.add("tb.ala.gift_list");
        bEn.add("tb.square");
        bEn.add("tb.first_dir");
        bEn.add("tb.forum_rank");
        bEn.add("tb.im_group_setting");
        bEn.add("tb.im_personal_chat_setting");
        bEn.add("tb.im_official_chat_setting");
        bEn.add("net_err_record");
        bEn.add("tb_user_profile");
        bEn.add("tb_forum_recommend");
        bEn.add("tb.ad_killer_tags");
        bEn.add("tb.manga.settings");
        bEn.add("tb.share_add_experienced");
        bEn.add("tb.write_privacy_state_space");
        bEp = new HashMap<>();
        bEo = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a aaW() {
        if (bEl == null) {
            bEl = new a();
        }
        return bEl;
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
        l<byte[]> lVar = bEo.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = bEm.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (bEn.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            bEo.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> bv(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = bEp.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = bEm.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (bEn.contains(str)) {
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
            l<String> lVar = bEp.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    bEp.remove(str);
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
        bEo.clear();
        bEp.clear();
    }
}
