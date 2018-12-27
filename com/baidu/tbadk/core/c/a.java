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
    public static a awc = null;
    private static HashMap<String, Integer> awd = new HashMap<>();
    private static ArrayList<String> awe;
    private static HashMap<String, l<byte[]>> awf;
    private static HashMap<String, l<String>> awg;

    static {
        awd.put("tb.pb_mark", 50);
        awd.put("tb.pb_history", 300);
        awd.put("tb.pb_normal", 1);
        awd.put("tb.pb_editor", 50);
        awd.put("tb.live_hotlist", 20);
        awd.put("tb.live_hotlist", 20);
        awd.put("tb.my_pages", 5);
        awd.put("tb.my_forums", 3);
        awd.put("tb.my_bookmarks", 3);
        awd.put("tb.my_posts", 3);
        awd.put("tb.im_frsgroup", 50);
        awd.put("tb.im_hotgroup", 30);
        awd.put("tb.im_groupinfo", 50);
        awd.put("tb.im_groupactivity", 50);
        awd.put("tb.im_entergroup", 10);
        awd.put("tb.im_enterforum_groupinfo", 10);
        awd.put("tb.im_group_setting", 3);
        awd.put("tb.im_personal_chat_setting", 3);
        awd.put("tb.im_official_chat_setting", 3);
        awd.put("tb.im_group_search_history", 50);
        awd.put("tb.im_official_history", 50);
        awd.put("tb.im_recommend_detail", 10);
        awd.put("tb.square", 1);
        awd.put("tb.first_dir", 1);
        awd.put("tb.forum_rank", 20);
        awd.put("tb.pic_gif", 50);
        awd.put("tb.official_bar_menu", 1000);
        awd.put("tb.friend_feed", 20);
        awd.put("net_err_record", 30);
        awd.put("tb_face_package", 30);
        awd.put("tb.recommend_friend", 10);
        awd.put("tb.searchperson_history", 5);
        awd.put("tb.game_center_home", 20);
        awd.put("tb.game_center_list", 20);
        awd.put("tb.person_wallet_new", 10);
        awd.put("tb.frs_hottopic", 100);
        awe = new ArrayList<>();
        awe.add("tb.ala.gift_list");
        awe.add("tb.square");
        awe.add("tb.first_dir");
        awe.add("tb.forum_rank");
        awe.add("tb.im_group_setting");
        awe.add("tb.im_personal_chat_setting");
        awe.add("tb.im_official_chat_setting");
        awe.add("net_err_record");
        awe.add("tb_user_profile");
        awe.add("tb_forum_recommend");
        awe.add("tb.ad_killer_tags");
        awe.add("tb.manga.settings");
        awe.add("tb.share_add_experienced");
        awe.add("tb.write_privacy_state_space");
        awg = new HashMap<>();
        awf = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a BB() {
        if (awc == null) {
            awc = new a();
        }
        return awc;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> ex(String str) {
        return am(str, null);
    }

    public l<String> ey(String str) {
        return an(str, null);
    }

    public l<byte[]> am(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = awf.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = awd.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (awe.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            awf.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> an(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = awg.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = awd.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (awe.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return iy.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void ao(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = awg.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    awg.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void ez(String str) {
        ao(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        awf.clear();
        awg.clear();
    }
}
