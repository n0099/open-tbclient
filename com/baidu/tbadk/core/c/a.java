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
    public static a akn = null;
    private static HashMap<String, Integer> ako = new HashMap<>();
    private static ArrayList<String> akp;
    private static HashMap<String, l<byte[]>> akq;
    private static HashMap<String, l<String>> akr;

    static {
        ako.put("tb.pb_mark", 50);
        ako.put("tb.pb_history", 300);
        ako.put("tb.pb_normal", 1);
        ako.put("tb.pb_editor", 50);
        ako.put("tb.live_hotlist", 20);
        ako.put("tb.live_hotlist", 20);
        ako.put("tb.my_pages", 5);
        ako.put("tb.my_forums", 3);
        ako.put("tb.my_bookmarks", 3);
        ako.put("tb.my_posts", 3);
        ako.put("tb.im_frsgroup", 50);
        ako.put("tb.im_hotgroup", 30);
        ako.put("tb.im_groupinfo", 50);
        ako.put("tb.im_groupactivity", 50);
        ako.put("tb.im_entergroup", 10);
        ako.put("tb.im_enterforum_groupinfo", 10);
        ako.put("tb.im_group_setting", 3);
        ako.put("tb.im_personal_chat_setting", 3);
        ako.put("tb.im_official_chat_setting", 3);
        ako.put("tb.im_group_search_history", 50);
        ako.put("tb.im_official_history", 50);
        ako.put("tb.im_recommend_detail", 10);
        ako.put("tb.square", 1);
        ako.put("tb.first_dir", 1);
        ako.put("tb.forum_rank", 20);
        ako.put("tb.pic_gif", 50);
        ako.put("tb.official_bar_menu", 1000);
        ako.put("tb.friend_feed", 20);
        ako.put("net_err_record", 30);
        ako.put("tb_face_package", 30);
        ako.put("tb.recommend_friend", 10);
        ako.put("tb.searchperson_history", 5);
        ako.put("tb.game_center_home", 20);
        ako.put("tb.game_center_list", 20);
        ako.put("tb.person_wallet_new", 10);
        ako.put("tb.frs_hottopic", 100);
        akp = new ArrayList<>();
        akp.add("tb.ala.gift_list");
        akp.add("tb.square");
        akp.add("tb.first_dir");
        akp.add("tb.forum_rank");
        akp.add("tb.im_group_setting");
        akp.add("tb.im_personal_chat_setting");
        akp.add("tb.im_official_chat_setting");
        akp.add("net_err_record");
        akp.add("tb_user_profile");
        akp.add("tb_forum_recommend");
        akp.add("tb.ad_killer_tags");
        akp.add("tb.manga.settings");
        akp.add("tb.share_add_experienced");
        akp.add("tb.write_privacy_state_space");
        akr = new HashMap<>();
        akq = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001012));
    }

    public static a xa() {
        if (akn == null) {
            akn = new a();
        }
        return akn;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> dx(String str) {
        return P(str, null);
    }

    public l<String> dy(String str) {
        return Q(str, null);
    }

    public l<byte[]> P(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = akq.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService hd = BdCacheService.hd();
            Integer num = ako.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (akp.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = hd.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            akq.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = akr.get(str3);
        BdCacheService hd = BdCacheService.hd();
        Integer num = ako.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (akp.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return hd.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void R(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = akr.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.hd().a(lVar);
                    akr.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void dz(String str) {
        R(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        akq.clear();
        akr.clear();
    }
}
