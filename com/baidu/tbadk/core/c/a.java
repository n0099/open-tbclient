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
    public static a awE = null;
    private static HashMap<String, Integer> awF = new HashMap<>();
    private static ArrayList<String> awG;
    private static HashMap<String, l<byte[]>> awH;
    private static HashMap<String, l<String>> awI;

    static {
        awF.put("tb.pb_mark", 50);
        awF.put("tb.pb_history", 300);
        awF.put("tb.pb_normal", 1);
        awF.put("tb.pb_editor", 50);
        awF.put("tb.live_hotlist", 20);
        awF.put("tb.live_hotlist", 20);
        awF.put("tb.my_pages", 5);
        awF.put("tb.my_forums", 3);
        awF.put("tb.my_bookmarks", 3);
        awF.put("tb.my_posts", 3);
        awF.put("tb.im_frsgroup", 50);
        awF.put("tb.im_hotgroup", 30);
        awF.put("tb.im_groupinfo", 50);
        awF.put("tb.im_groupactivity", 50);
        awF.put("tb.im_entergroup", 10);
        awF.put("tb.im_enterforum_groupinfo", 10);
        awF.put("tb.im_group_setting", 3);
        awF.put("tb.im_personal_chat_setting", 3);
        awF.put("tb.im_official_chat_setting", 3);
        awF.put("tb.im_group_search_history", 50);
        awF.put("tb.im_official_history", 50);
        awF.put("tb.im_recommend_detail", 10);
        awF.put("tb.square", 1);
        awF.put("tb.first_dir", 1);
        awF.put("tb.forum_rank", 20);
        awF.put("tb.pic_gif", 50);
        awF.put("tb.official_bar_menu", 1000);
        awF.put("tb.friend_feed", 20);
        awF.put("net_err_record", 30);
        awF.put("tb_face_package", 30);
        awF.put("tb.recommend_friend", 10);
        awF.put("tb.searchperson_history", 5);
        awF.put("tb.game_center_home", 20);
        awF.put("tb.game_center_list", 20);
        awF.put("tb.person_wallet_new", 10);
        awF.put("tb.frs_hottopic", 100);
        awG = new ArrayList<>();
        awG.add("tb.ala.gift_list");
        awG.add("tb.square");
        awG.add("tb.first_dir");
        awG.add("tb.forum_rank");
        awG.add("tb.im_group_setting");
        awG.add("tb.im_personal_chat_setting");
        awG.add("tb.im_official_chat_setting");
        awG.add("net_err_record");
        awG.add("tb_user_profile");
        awG.add("tb_forum_recommend");
        awG.add("tb.ad_killer_tags");
        awG.add("tb.manga.settings");
        awG.add("tb.share_add_experienced");
        awG.add("tb.write_privacy_state_space");
        awI = new HashMap<>();
        awH = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a BO() {
        if (awE == null) {
            awE = new a();
        }
        return awE;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> eG(String str) {
        return an(str, null);
    }

    public l<String> eH(String str) {
        return ao(str, null);
    }

    public l<byte[]> an(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = awH.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = awF.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (awG.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            awH.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> ao(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = awI.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = awF.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (awG.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return iy.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void ap(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = awI.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    awI.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void eI(String str) {
        ap(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        awH.clear();
        awI.clear();
    }
}
