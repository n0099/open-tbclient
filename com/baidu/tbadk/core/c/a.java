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
    public static a aPA = null;
    private static HashMap<String, Integer> aPB = new HashMap<>();
    private static ArrayList<String> aPC;
    private static HashMap<String, l<byte[]>> aPD;
    private static HashMap<String, l<String>> aPE;

    static {
        aPB.put("tb.pb_mark", 50);
        aPB.put("tb.pb_history", 300);
        aPB.put("tb.pb_normal", 1);
        aPB.put("tb.pb_editor", 50);
        aPB.put("tb.live_hotlist", 20);
        aPB.put("tb.live_hotlist", 20);
        aPB.put("tb.my_pages", 5);
        aPB.put("tb.my_forums", 3);
        aPB.put("tb.my_bookmarks", 3);
        aPB.put("tb.my_posts", 3);
        aPB.put("tb.im_frsgroup", 50);
        aPB.put("tb.im_hotgroup", 30);
        aPB.put("tb.im_groupinfo", 50);
        aPB.put("tb.im_groupactivity", 50);
        aPB.put("tb.im_entergroup", 10);
        aPB.put("tb.im_enterforum_groupinfo", 10);
        aPB.put("tb.im_group_setting", 3);
        aPB.put("tb.im_personal_chat_setting", 3);
        aPB.put("tb.im_official_chat_setting", 3);
        aPB.put("tb.im_group_search_history", 50);
        aPB.put("tb.im_official_history", 50);
        aPB.put("tb.im_recommend_detail", 10);
        aPB.put("tb.square", 1);
        aPB.put("tb.first_dir", 1);
        aPB.put("tb.forum_rank", 20);
        aPB.put("tb.pic_gif", 50);
        aPB.put("tb.official_bar_menu", 1000);
        aPB.put("tb.friend_feed", 20);
        aPB.put("net_err_record", 30);
        aPB.put("tb_face_package", 30);
        aPB.put("tb.recommend_friend", 10);
        aPB.put("tb.searchperson_history", 5);
        aPB.put("tb.game_center_home", 20);
        aPB.put("tb.game_center_list", 20);
        aPB.put("tb.person_wallet_new", 10);
        aPC = new ArrayList<>();
        aPC.add("tb.ala.gift_list");
        aPC.add("tb.square");
        aPC.add("tb.first_dir");
        aPC.add("tb.forum_rank");
        aPC.add("tb.im_group_setting");
        aPC.add("tb.im_personal_chat_setting");
        aPC.add("tb.im_official_chat_setting");
        aPC.add("net_err_record");
        aPC.add("tb_user_profile");
        aPC.add("tb_forum_recommend");
        aPC.add("tb.ad_killer_tags");
        aPC.add("tb.manga.settings");
        aPC.add("tb.share_add_experienced");
        aPC.add("tb.write_privacy_state_space");
        aPE = new HashMap<>();
        aPD = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a Ax() {
        if (aPA == null) {
            aPA = new a();
        }
        return aPA;
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
        l<byte[]> lVar = aPD.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService mj = BdCacheService.mj();
            Integer num = aPB.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aPC.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = mj.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aPD.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = aPE.get(str3);
        BdCacheService mj = BdCacheService.mj();
        Integer num = aPB.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aPC.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return mj.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            l<String> lVar = aPE.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.mj().a(lVar);
                    aPE.remove(str);
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
        aPD.clear();
        aPE.clear();
    }
}
