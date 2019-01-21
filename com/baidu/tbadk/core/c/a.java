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
    public static a awF = null;
    private static HashMap<String, Integer> awG = new HashMap<>();
    private static ArrayList<String> awH;
    private static HashMap<String, l<byte[]>> awI;
    private static HashMap<String, l<String>> awJ;

    static {
        awG.put("tb.pb_mark", 50);
        awG.put("tb.pb_history", 300);
        awG.put("tb.pb_normal", 1);
        awG.put("tb.pb_editor", 50);
        awG.put("tb.live_hotlist", 20);
        awG.put("tb.live_hotlist", 20);
        awG.put("tb.my_pages", 5);
        awG.put("tb.my_forums", 3);
        awG.put("tb.my_bookmarks", 3);
        awG.put("tb.my_posts", 3);
        awG.put("tb.im_frsgroup", 50);
        awG.put("tb.im_hotgroup", 30);
        awG.put("tb.im_groupinfo", 50);
        awG.put("tb.im_groupactivity", 50);
        awG.put("tb.im_entergroup", 10);
        awG.put("tb.im_enterforum_groupinfo", 10);
        awG.put("tb.im_group_setting", 3);
        awG.put("tb.im_personal_chat_setting", 3);
        awG.put("tb.im_official_chat_setting", 3);
        awG.put("tb.im_group_search_history", 50);
        awG.put("tb.im_official_history", 50);
        awG.put("tb.im_recommend_detail", 10);
        awG.put("tb.square", 1);
        awG.put("tb.first_dir", 1);
        awG.put("tb.forum_rank", 20);
        awG.put("tb.pic_gif", 50);
        awG.put("tb.official_bar_menu", 1000);
        awG.put("tb.friend_feed", 20);
        awG.put("net_err_record", 30);
        awG.put("tb_face_package", 30);
        awG.put("tb.recommend_friend", 10);
        awG.put("tb.searchperson_history", 5);
        awG.put("tb.game_center_home", 20);
        awG.put("tb.game_center_list", 20);
        awG.put("tb.person_wallet_new", 10);
        awG.put("tb.frs_hottopic", 100);
        awH = new ArrayList<>();
        awH.add("tb.ala.gift_list");
        awH.add("tb.square");
        awH.add("tb.first_dir");
        awH.add("tb.forum_rank");
        awH.add("tb.im_group_setting");
        awH.add("tb.im_personal_chat_setting");
        awH.add("tb.im_official_chat_setting");
        awH.add("net_err_record");
        awH.add("tb_user_profile");
        awH.add("tb_forum_recommend");
        awH.add("tb.ad_killer_tags");
        awH.add("tb.manga.settings");
        awH.add("tb.share_add_experienced");
        awH.add("tb.write_privacy_state_space");
        awJ = new HashMap<>();
        awI = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a BO() {
        if (awF == null) {
            awF = new a();
        }
        return awF;
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
        l<byte[]> lVar = awI.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService iy = BdCacheService.iy();
            Integer num = awG.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (awH.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = iy.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            awI.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> ao(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = awJ.get(str3);
        BdCacheService iy = BdCacheService.iy();
        Integer num = awG.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (awH.contains(str)) {
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
            l<String> lVar = awJ.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.iy().a(lVar);
                    awJ.remove(str);
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
        awI.clear();
        awJ.clear();
    }
}
