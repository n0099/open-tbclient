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
    public static a abv = null;
    private static HashMap<String, Integer> abw = new HashMap<>();
    private static ArrayList<String> abx;
    private static HashMap<String, l<byte[]>> aby;
    private static HashMap<String, l<String>> abz;

    static {
        abw.put("tb.pb_mark", 50);
        abw.put("tb.pb_history", 300);
        abw.put("tb.pb_normal", 1);
        abw.put("tb.pb_editor", 50);
        abw.put("tb.live_hotlist", 20);
        abw.put("tb.live_hotlist", 20);
        abw.put("tb.my_pages", 5);
        abw.put("tb.my_forums", 3);
        abw.put("tb.my_bookmarks", 3);
        abw.put("tb.my_posts", 3);
        abw.put("tb.im_frsgroup", 50);
        abw.put("tb.im_hotgroup", 30);
        abw.put("tb.im_groupinfo", 50);
        abw.put("tb.im_groupactivity", 50);
        abw.put("tb.im_entergroup", 10);
        abw.put("tb.im_enterforum_groupinfo", 10);
        abw.put("tb.im_group_setting", 3);
        abw.put("tb.im_personal_chat_setting", 3);
        abw.put("tb.im_official_chat_setting", 3);
        abw.put("tb.im_group_search_history", 50);
        abw.put("tb.im_official_history", 50);
        abw.put("tb.im_recommend_detail", 10);
        abw.put("tb.square", 1);
        abw.put("tb.first_dir", 1);
        abw.put("tb.forum_rank", 20);
        abw.put("tb.pic_gif", 50);
        abw.put("tb.official_bar_menu", 1000);
        abw.put("tb.friend_feed", 20);
        abw.put("net_err_record", 30);
        abw.put("tb_face_package", 30);
        abw.put("tb.recommend_friend", 10);
        abw.put("tb.searchperson_history", 5);
        abw.put("tb.game_center_home", 20);
        abw.put("tb.game_center_list", 20);
        abw.put("tb.person_wallet_new", 10);
        abw.put("bottom_write_story", 1);
        abx = new ArrayList<>();
        abx.add("tb.ala.gift_list");
        abx.add("tb.square");
        abx.add("tb.first_dir");
        abx.add("tb.forum_rank");
        abx.add("tb.im_group_setting");
        abx.add("tb.im_personal_chat_setting");
        abx.add("tb.im_official_chat_setting");
        abx.add("net_err_record");
        abx.add("tb_user_profile");
        abx.add("tb_forum_recommend");
        abx.add("tb.ad_killer_tags");
        abx.add("tb.manga.settings");
        abx.add("tb.share_add_experienced");
        abz = new HashMap<>();
        aby = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a to() {
        if (abv == null) {
            abv = new a();
        }
        return abv;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> cS(String str) {
        return L(str, null);
    }

    public l<String> cT(String str) {
        return M(str, null);
    }

    public l<byte[]> L(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = aby.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService eQ = BdCacheService.eQ();
            Integer num = abw.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (abx.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = eQ.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            aby.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> M(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = abz.get(str3);
        BdCacheService eQ = BdCacheService.eQ();
        Integer num = abw.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (abx.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return eQ.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
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
            l<String> lVar = abz.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.eQ().a(lVar);
                    abz.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cU(String str) {
        N(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aby.clear();
        abz.clear();
    }
}
