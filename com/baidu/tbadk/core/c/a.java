package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a aac = null;
    private static HashMap<String, Integer> aad = new HashMap<>();
    private static ArrayList<String> aae;
    private static HashMap<String, o<byte[]>> aaf;
    private static HashMap<String, o<String>> aag;

    static {
        aad.put("tb.pb_mark", 50);
        aad.put("tb.pb_history", 300);
        aad.put("tb.pb_normal", 1);
        aad.put("tb.pb_editor", 50);
        aad.put("tb.live_hotlist", 20);
        aad.put("tb.live_hotlist", 20);
        aad.put("tb.my_pages", 5);
        aad.put("tb.my_forums", 3);
        aad.put("tb.my_bookmarks", 3);
        aad.put("tb.my_posts", 3);
        aad.put("tb.im_frsgroup", 50);
        aad.put("tb.im_hotgroup", 30);
        aad.put("tb.im_groupinfo", 50);
        aad.put("tb.im_groupactivity", 50);
        aad.put("tb.im_entergroup", 10);
        aad.put("tb.im_enterforum_groupinfo", 10);
        aad.put("tb.im_group_setting", 3);
        aad.put("tb.im_personal_chat_setting", 3);
        aad.put("tb.im_official_chat_setting", 3);
        aad.put("tb.im_group_search_history", 50);
        aad.put("tb.im_official_history", 50);
        aad.put("tb.im_recommend_detail", 10);
        aad.put("tb.square", 1);
        aad.put("tb.first_dir", 1);
        aad.put("tb.forum_rank", 20);
        aad.put("tb.pic_gif", 50);
        aad.put("tb.official_bar_menu", 1000);
        aad.put("tb.friend_feed", 20);
        aad.put("net_err_record", 30);
        aad.put("tb_face_package", 30);
        aad.put("tb.recommend_friend", 10);
        aad.put("tb.searchperson_history", 5);
        aad.put("tb.game_center_home", 20);
        aad.put("tb.game_center_list", 20);
        aad.put("tb.person_wallet_new", 10);
        aae = new ArrayList<>();
        aae.add("tb.ala.gift_list");
        aae.add("tb.square");
        aae.add("tb.first_dir");
        aae.add("tb.forum_rank");
        aae.add("tb.im_group_setting");
        aae.add("tb.im_personal_chat_setting");
        aae.add("tb.im_official_chat_setting");
        aae.add("net_err_record");
        aae.add("tb_user_profile");
        aae.add("tb_forum_recommend");
        aae.add("tb.ad_killer_tags");
        aae.add("tb.manga.settings");
        aag = new HashMap<>();
        aaf = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a tM() {
        if (aac == null) {
            aac = new a();
        }
        return aac;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cA(String str) {
        return L(str, null);
    }

    public o<String> cB(String str) {
        return M(str, null);
    }

    public o<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = aaf.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService eI = BdCacheService.eI();
            Integer num = aad.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aae.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = eI.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aaf.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = aag.get(str3);
        BdCacheService eI = BdCacheService.eI();
        Integer num = aad.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aae.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eI.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void N(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = aag.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.eI().a(oVar);
                    aag.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cC(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aaf.clear();
        aag.clear();
    }
}
