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
    public static a abd = null;
    private static HashMap<String, Integer> abe = new HashMap<>();
    private static ArrayList<String> abf;
    private static HashMap<String, l<byte[]>> abg;
    private static HashMap<String, l<String>> abh;

    static {
        abe.put("tb.pb_mark", 50);
        abe.put("tb.pb_history", 300);
        abe.put("tb.pb_normal", 1);
        abe.put("tb.pb_editor", 50);
        abe.put("tb.live_hotlist", 20);
        abe.put("tb.live_hotlist", 20);
        abe.put("tb.my_pages", 5);
        abe.put("tb.my_forums", 3);
        abe.put("tb.my_bookmarks", 3);
        abe.put("tb.my_posts", 3);
        abe.put("tb.im_frsgroup", 50);
        abe.put("tb.im_hotgroup", 30);
        abe.put("tb.im_groupinfo", 50);
        abe.put("tb.im_groupactivity", 50);
        abe.put("tb.im_entergroup", 10);
        abe.put("tb.im_enterforum_groupinfo", 10);
        abe.put("tb.im_group_setting", 3);
        abe.put("tb.im_personal_chat_setting", 3);
        abe.put("tb.im_official_chat_setting", 3);
        abe.put("tb.im_group_search_history", 50);
        abe.put("tb.im_official_history", 50);
        abe.put("tb.im_recommend_detail", 10);
        abe.put("tb.square", 1);
        abe.put("tb.first_dir", 1);
        abe.put("tb.forum_rank", 20);
        abe.put("tb.pic_gif", 50);
        abe.put("tb.official_bar_menu", 1000);
        abe.put("tb.friend_feed", 20);
        abe.put("net_err_record", 30);
        abe.put("tb_face_package", 30);
        abe.put("tb.recommend_friend", 10);
        abe.put("tb.searchperson_history", 5);
        abe.put("tb.game_center_home", 20);
        abe.put("tb.game_center_list", 20);
        abe.put("tb.person_wallet_new", 10);
        abe.put("bottom_write_story", 1);
        abf = new ArrayList<>();
        abf.add("tb.ala.gift_list");
        abf.add("tb.square");
        abf.add("tb.first_dir");
        abf.add("tb.forum_rank");
        abf.add("tb.im_group_setting");
        abf.add("tb.im_personal_chat_setting");
        abf.add("tb.im_official_chat_setting");
        abf.add("net_err_record");
        abf.add("tb_user_profile");
        abf.add("tb_forum_recommend");
        abf.add("tb.ad_killer_tags");
        abf.add("tb.manga.settings");
        abf.add("tb.share_add_experienced");
        abf.add("tb.write_privacy_state_space");
        abh = new HashMap<>();
        abg = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a td() {
        if (abd == null) {
            abd = new a();
        }
        return abd;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cO(String str) {
        return M(str, null);
    }

    public l<String> cP(String str) {
        return N(str, null);
    }

    public l<byte[]> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = abg.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eE = BdCacheService.eE();
            Integer num = abe.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (abf.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eE.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            abg.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> N(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = abh.get(str3);
        BdCacheService eE = BdCacheService.eE();
        Integer num = abe.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (abf.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eE.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void O(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = abh.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eE().a(lVar);
                    abh.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cQ(String str) {
        O(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        abg.clear();
        abh.clear();
    }
}
