package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    private static ArrayList<String> aPA;
    private static HashMap<String, l<byte[]>> aPB;
    private static HashMap<String, l<String>> aPC;
    public static a aPy = null;
    private static HashMap<String, Integer> aPz = new HashMap<>();

    static {
        aPz.put("tb.pb_mark", 50);
        aPz.put("tb.pb_history", 300);
        aPz.put("tb.pb_normal", 1);
        aPz.put("tb.pb_editor", 50);
        aPz.put("tb.live_hotlist", 20);
        aPz.put("tb.live_hotlist", 20);
        aPz.put("tb.my_pages", 5);
        aPz.put("tb.my_forums", 3);
        aPz.put("tb.my_bookmarks", 3);
        aPz.put("tb.my_posts", 3);
        aPz.put("tb.im_frsgroup", 50);
        aPz.put("tb.im_hotgroup", 30);
        aPz.put("tb.im_groupinfo", 50);
        aPz.put("tb.im_groupactivity", 50);
        aPz.put("tb.im_entergroup", 10);
        aPz.put("tb.im_enterforum_groupinfo", 10);
        aPz.put("tb.im_group_setting", 3);
        aPz.put("tb.im_personal_chat_setting", 3);
        aPz.put("tb.im_official_chat_setting", 3);
        aPz.put("tb.im_group_search_history", 50);
        aPz.put("tb.im_official_history", 50);
        aPz.put("tb.im_recommend_detail", 10);
        aPz.put("tb.square", 1);
        aPz.put("tb.first_dir", 1);
        aPz.put("tb.forum_rank", 20);
        aPz.put("tb.pic_gif", 50);
        aPz.put("tb.official_bar_menu", 1000);
        aPz.put("tb.friend_feed", 20);
        aPz.put("net_err_record", 30);
        aPz.put("tb_face_package", 30);
        aPz.put("tb.recommend_friend", 10);
        aPz.put("tb.searchperson_history", 5);
        aPz.put("tb.game_center_home", 20);
        aPz.put("tb.game_center_list", 20);
        aPz.put("tb.person_wallet_new", 10);
        aPA = new ArrayList<>();
        aPA.add("tb.ala.gift_list");
        aPA.add("tb.square");
        aPA.add("tb.first_dir");
        aPA.add("tb.forum_rank");
        aPA.add("tb.im_group_setting");
        aPA.add("tb.im_personal_chat_setting");
        aPA.add("tb.im_official_chat_setting");
        aPA.add("net_err_record");
        aPA.add("tb_user_profile");
        aPA.add("tb_forum_recommend");
        aPA.add("tb.ad_killer_tags");
        aPA.add("tb.manga.settings");
        aPA.add("tb.share_add_experienced");
        aPA.add("tb.write_privacy_state_space");
        aPC = new HashMap<>();
        aPB = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a AE() {
        if (aPy == null) {
            aPy = new a();
        }
        return aPy;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cV(String str) {
        return L(str, null);
    }

    public l<String> cW(String str) {
        return M(str, null);
    }

    public l<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aPB.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mi = BdCacheService.mi();
            Integer num = aPz.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aPA.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mi.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aPB.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aPC.get(str3);
        BdCacheService mi = BdCacheService.mi();
        Integer num = aPz.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aPA.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return mi.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void N(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = aPC.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mi().a(lVar);
                    aPC.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cX(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aPB.clear();
        aPC.clear();
    }
}
