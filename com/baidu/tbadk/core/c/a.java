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
    public static a aab = null;
    private static HashMap<String, Integer> aac = new HashMap<>();
    private static ArrayList<String> aad;
    private static HashMap<String, o<byte[]>> aae;
    private static HashMap<String, o<String>> aaf;

    static {
        aac.put("tb.pb_mark", 50);
        aac.put("tb.pb_history", 300);
        aac.put("tb.pb_normal", 1);
        aac.put("tb.pb_editor", 50);
        aac.put("tb.live_hotlist", 20);
        aac.put("tb.live_hotlist", 20);
        aac.put("tb.my_pages", 5);
        aac.put("tb.my_forums", 3);
        aac.put("tb.my_bookmarks", 3);
        aac.put("tb.my_posts", 3);
        aac.put("tb.im_frsgroup", 50);
        aac.put("tb.im_hotgroup", 30);
        aac.put("tb.im_groupinfo", 50);
        aac.put("tb.im_groupactivity", 50);
        aac.put("tb.im_entergroup", 10);
        aac.put("tb.im_enterforum_groupinfo", 10);
        aac.put("tb.im_group_setting", 3);
        aac.put("tb.im_personal_chat_setting", 3);
        aac.put("tb.im_official_chat_setting", 3);
        aac.put("tb.im_group_search_history", 50);
        aac.put("tb.im_official_history", 50);
        aac.put("tb.im_recommend_detail", 10);
        aac.put("tb.square", 1);
        aac.put("tb.first_dir", 1);
        aac.put("tb.forum_rank", 20);
        aac.put("tb.pic_gif", 50);
        aac.put("tb.official_bar_menu", 1000);
        aac.put("tb.friend_feed", 20);
        aac.put("net_err_record", 30);
        aac.put("tb_face_package", 30);
        aac.put("tb.recommend_friend", 10);
        aac.put("tb.searchperson_history", 5);
        aac.put("tb.game_center_home", 20);
        aac.put("tb.game_center_list", 20);
        aac.put("tb.person_wallet_new", 10);
        aad = new ArrayList<>();
        aad.add("tb.ala.gift_list");
        aad.add("tb.square");
        aad.add("tb.first_dir");
        aad.add("tb.forum_rank");
        aad.add("tb.im_group_setting");
        aad.add("tb.im_personal_chat_setting");
        aad.add("tb.im_official_chat_setting");
        aad.add("net_err_record");
        aad.add("tb_user_profile");
        aad.add("tb_forum_recommend");
        aad.add("tb.ad_killer_tags");
        aad.add("tb.manga.settings");
        aaf = new HashMap<>();
        aae = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a tM() {
        if (aab == null) {
            aab = new a();
        }
        return aab;
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
        o<byte[]> oVar = aae.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService eH = BdCacheService.eH();
            Integer num = aac.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (aad.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = eH.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aae.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = aaf.get(str3);
        BdCacheService eH = BdCacheService.eH();
        Integer num = aac.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (aad.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eH.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            o<String> oVar = aaf.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.eH().a(oVar);
                    aaf.remove(str);
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
        aae.clear();
        aaf.clear();
    }
}
