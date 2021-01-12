package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.dbcache.DBKVCacheManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    private static HashMap<String, l<byte[]>> byteCacheMap;
    private static ArrayList<String> noEvictList;
    private static HashMap<String, l<String>> stringCacheMap;
    public static a eSn = null;
    private static HashMap<String, Integer> cacheCountLimitMap = new HashMap<>();

    static {
        cacheCountLimitMap.put("tb.pb_mark", 50);
        cacheCountLimitMap.put("tb.pb_history", 300);
        cacheCountLimitMap.put("tb.pb_normal", 1);
        cacheCountLimitMap.put("tb.pb_editor", 50);
        cacheCountLimitMap.put("tb.live_hotlist", 20);
        cacheCountLimitMap.put("tb.live_hotlist", 20);
        cacheCountLimitMap.put("tb.my_pages", 5);
        cacheCountLimitMap.put("tb.my_forums", 3);
        cacheCountLimitMap.put("tb.my_bookmarks", 3);
        cacheCountLimitMap.put("tb.my_posts", 3);
        cacheCountLimitMap.put("tb.eva_posts", 50);
        cacheCountLimitMap.put("tb.im_frsgroup", 50);
        cacheCountLimitMap.put("tb.im_hotgroup", 30);
        cacheCountLimitMap.put("tb.im_groupinfo", 50);
        cacheCountLimitMap.put("tb.im_groupactivity", 50);
        cacheCountLimitMap.put("tb.im_entergroup", 10);
        cacheCountLimitMap.put("tb.im_enterforum_groupinfo", 10);
        cacheCountLimitMap.put("tb.im_group_setting", 3);
        cacheCountLimitMap.put("tb.im_personal_chat_setting", 3);
        cacheCountLimitMap.put("tb.im_official_chat_setting", 3);
        cacheCountLimitMap.put("tb.im_group_search_history", 50);
        cacheCountLimitMap.put("tb.im_official_history", 50);
        cacheCountLimitMap.put("tb.im_recommend_detail", 10);
        cacheCountLimitMap.put("tb.square", 1);
        cacheCountLimitMap.put("tb.first_dir", 1);
        cacheCountLimitMap.put("tb.forum_rank", 20);
        cacheCountLimitMap.put("tb.pic_gif", 50);
        cacheCountLimitMap.put("tb.official_bar_menu", 1000);
        cacheCountLimitMap.put("tb.friend_feed", 20);
        cacheCountLimitMap.put("net_err_record", 30);
        cacheCountLimitMap.put("tb_face_package", 30);
        cacheCountLimitMap.put("tb.recommend_friend", 10);
        cacheCountLimitMap.put("tb.searchperson_history", 5);
        cacheCountLimitMap.put("tb.game_center_home", 20);
        cacheCountLimitMap.put("tb.game_center_list", 20);
        cacheCountLimitMap.put("tb.person_wallet_new", 10);
        cacheCountLimitMap.put("tb.frs_hottopic", 100);
        noEvictList = new ArrayList<>();
        noEvictList.add(DBKVCacheManager.ALA_GIFT_LIST_CACHE_KEY);
        noEvictList.add("tb.square");
        noEvictList.add("tb.first_dir");
        noEvictList.add("tb.forum_rank");
        noEvictList.add("tb.im_group_setting");
        noEvictList.add("tb.im_personal_chat_setting");
        noEvictList.add("tb.im_official_chat_setting");
        noEvictList.add("net_err_record");
        noEvictList.add("tb_user_profile");
        noEvictList.add("tb_forum_recommend");
        noEvictList.add("tb.ad_killer_tags");
        noEvictList.add("tb.manga.settings");
        noEvictList.add("tb.share_add_experienced");
        noEvictList.add("tb.write_privacy_state_space");
        noEvictList.add("tb.concern_page_all");
        stringCacheMap = new HashMap<>();
        byteCacheMap = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static a bpZ() {
        if (eSn == null) {
            eSn = new a();
        }
        return eSn;
    }

    private a() {
        super(MessageConfig.DATABASE_CREATED);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public l<byte[]> Aa(String str) {
        return dK(str, null);
    }

    public l<String> Ab(String str) {
        return dL(str, null);
    }

    public l<byte[]> dK(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<byte[]> lVar = byteCacheMap.get(str3);
        if (lVar == null || !(lVar instanceof l)) {
            BdCacheService lx = BdCacheService.lx();
            Integer num = cacheCountLimitMap.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (noEvictList.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                lVar = lx.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            byteCacheMap.put(str3, lVar);
            return lVar;
        }
        return lVar;
    }

    public l<String> dL(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        l<String> lVar = stringCacheMap.get(str3);
        BdCacheService lx = BdCacheService.lx();
        Integer num = cacheCountLimitMap.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (noEvictList.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return lx.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return lVar;
        }
    }

    public void clearStringCacheWithSapce(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<String> lVar = stringCacheMap.get(str);
            if (lVar != null) {
                try {
                    BdCacheService.lx().a(lVar);
                    stringCacheMap.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void clearStringCacheWithSapce(String str) {
        clearStringCacheWithSapce(str, null);
    }

    public void clearByteCacheWithSapce(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            l<byte[]> lVar = byteCacheMap.get(str);
            if (lVar != null) {
                BdCacheService.lx().a(lVar);
                byteCacheMap.remove(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        byteCacheMap.clear();
        stringCacheMap.clear();
    }
}
