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
    public static a awb = null;
    private static HashMap<String, Integer> awc = new HashMap<>();
    private static ArrayList<String> awd;
    private static HashMap<String, l<byte[]>> awe;
    private static HashMap<String, l<String>> awf;

    static {
        awc.put("tb.pb_mark", 50);
        awc.put("tb.pb_history", 300);
        awc.put("tb.pb_normal", 1);
        awc.put("tb.pb_editor", 50);
        awc.put("tb.live_hotlist", 20);
        awc.put("tb.live_hotlist", 20);
        awc.put("tb.my_pages", 5);
        awc.put("tb.my_forums", 3);
        awc.put("tb.my_bookmarks", 3);
        awc.put("tb.my_posts", 3);
        awc.put("tb.im_frsgroup", 50);
        awc.put("tb.im_hotgroup", 30);
        awc.put("tb.im_groupinfo", 50);
        awc.put("tb.im_groupactivity", 50);
        awc.put("tb.im_entergroup", 10);
        awc.put("tb.im_enterforum_groupinfo", 10);
        awc.put("tb.im_group_setting", 3);
        awc.put("tb.im_personal_chat_setting", 3);
        awc.put("tb.im_official_chat_setting", 3);
        awc.put("tb.im_group_search_history", 50);
        awc.put("tb.im_official_history", 50);
        awc.put("tb.im_recommend_detail", 10);
        awc.put("tb.square", 1);
        awc.put("tb.first_dir", 1);
        awc.put("tb.forum_rank", 20);
        awc.put("tb.pic_gif", 50);
        awc.put("tb.official_bar_menu", 1000);
        awc.put("tb.friend_feed", 20);
        awc.put("net_err_record", 30);
        awc.put("tb_face_package", 30);
        awc.put("tb.recommend_friend", 10);
        awc.put("tb.searchperson_history", 5);
        awc.put("tb.game_center_home", 20);
        awc.put("tb.game_center_list", 20);
        awc.put("tb.person_wallet_new", 10);
        awc.put("tb.frs_hottopic", 100);
        awd = new ArrayList<>();
        awd.add("tb.ala.gift_list");
        awd.add("tb.square");
        awd.add("tb.first_dir");
        awd.add("tb.forum_rank");
        awd.add("tb.im_group_setting");
        awd.add("tb.im_personal_chat_setting");
        awd.add("tb.im_official_chat_setting");
        awd.add("net_err_record");
        awd.add("tb_user_profile");
        awd.add("tb_forum_recommend");
        awd.add("tb.ad_killer_tags");
        awd.add("tb.manga.settings");
        awd.add("tb.share_add_experienced");
        awd.add("tb.write_privacy_state_space");
        awf = new HashMap<>();
        awe = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a BB() {
        if (awb == null) {
            awb = new a();
        }
        return awb;
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
        l<byte[]> lVar = awe.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = awc.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (awd.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            awe.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> an(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = awf.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = awc.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (awd.contains(str)) {
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
            l<String> lVar = awf.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    awf.remove(str);
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
        awe.clear();
        awf.clear();
    }
}
