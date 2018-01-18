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
    private static HashMap<String, l<byte[]>> aPA;
    private static HashMap<String, l<String>> aPB;
    public static a aPx = null;
    private static HashMap<String, Integer> aPy = new HashMap<>();
    private static ArrayList<String> aPz;

    static {
        aPy.put("tb.pb_mark", 50);
        aPy.put("tb.pb_history", 300);
        aPy.put("tb.pb_normal", 1);
        aPy.put("tb.pb_editor", 50);
        aPy.put("tb.live_hotlist", 20);
        aPy.put("tb.live_hotlist", 20);
        aPy.put("tb.my_pages", 5);
        aPy.put("tb.my_forums", 3);
        aPy.put("tb.my_bookmarks", 3);
        aPy.put("tb.my_posts", 3);
        aPy.put("tb.im_frsgroup", 50);
        aPy.put("tb.im_hotgroup", 30);
        aPy.put("tb.im_groupinfo", 50);
        aPy.put("tb.im_groupactivity", 50);
        aPy.put("tb.im_entergroup", 10);
        aPy.put("tb.im_enterforum_groupinfo", 10);
        aPy.put("tb.im_group_setting", 3);
        aPy.put("tb.im_personal_chat_setting", 3);
        aPy.put("tb.im_official_chat_setting", 3);
        aPy.put("tb.im_group_search_history", 50);
        aPy.put("tb.im_official_history", 50);
        aPy.put("tb.im_recommend_detail", 10);
        aPy.put("tb.square", 1);
        aPy.put("tb.first_dir", 1);
        aPy.put("tb.forum_rank", 20);
        aPy.put("tb.pic_gif", 50);
        aPy.put("tb.official_bar_menu", 1000);
        aPy.put("tb.friend_feed", 20);
        aPy.put("net_err_record", 30);
        aPy.put("tb_face_package", 30);
        aPy.put("tb.recommend_friend", 10);
        aPy.put("tb.searchperson_history", 5);
        aPy.put("tb.game_center_home", 20);
        aPy.put("tb.game_center_list", 20);
        aPy.put("tb.person_wallet_new", 10);
        aPz = new ArrayList<>();
        aPz.add("tb.ala.gift_list");
        aPz.add("tb.square");
        aPz.add("tb.first_dir");
        aPz.add("tb.forum_rank");
        aPz.add("tb.im_group_setting");
        aPz.add("tb.im_personal_chat_setting");
        aPz.add("tb.im_official_chat_setting");
        aPz.add("net_err_record");
        aPz.add("tb_user_profile");
        aPz.add("tb_forum_recommend");
        aPz.add("tb.ad_killer_tags");
        aPz.add("tb.manga.settings");
        aPz.add("tb.share_add_experienced");
        aPz.add("tb.write_privacy_state_space");
        aPB = new HashMap<>();
        aPA = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a Aw() {
        if (aPx == null) {
            aPx = new a();
        }
        return aPx;
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
        l<byte[]> lVar = aPA.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mi = BdCacheService.mi();
            Integer num = aPy.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aPz.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mi.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aPA.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aPB.get(str3);
        BdCacheService mi = BdCacheService.mi();
        Integer num = aPy.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aPz.contains(str)) {
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
            l<String> lVar = aPB.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mi().a(lVar);
                    aPB.remove(str);
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
        aPA.clear();
        aPB.clear();
    }
}
