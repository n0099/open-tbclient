package com.baidu.tbadk.core.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a XB = null;
    private static HashMap<String, Integer> XC = new HashMap<>();
    private static ArrayList<String> XD;
    private static HashMap<String, o<byte[]>> XE;
    private static HashMap<String, o<String>> XF;

    static {
        XC.put("tb.pb_mark", 50);
        XC.put("tb.pb_history", 300);
        XC.put("tb.pb_normal", 1);
        XC.put("tb.pb_editor", 50);
        XC.put("tb.live_hotlist", 20);
        XC.put("tb.live_hotlist", 20);
        XC.put("tb.my_pages", 5);
        XC.put("tb.my_forums", 3);
        XC.put("tb.my_bookmarks", 3);
        XC.put("tb.my_posts", 3);
        XC.put("tb.im_frsgroup", 50);
        XC.put("tb.im_hotgroup", 30);
        XC.put("tb.im_groupinfo", 50);
        XC.put("tb.im_groupactivity", 50);
        XC.put("tb.im_entergroup", 10);
        XC.put("tb.im_enterforum_groupinfo", 10);
        XC.put("tb.im_group_setting", 3);
        XC.put("tb.im_personal_chat_setting", 3);
        XC.put("tb.im_official_chat_setting", 3);
        XC.put("tb.im_group_search_history", 50);
        XC.put("tb.im_official_history", 50);
        XC.put("tb.im_recommend_detail", 10);
        XC.put("tb.square", 1);
        XC.put("tb.first_dir", 1);
        XC.put("tb.forum_rank", 20);
        XC.put("tb.pic_gif", 50);
        XC.put("tb.official_bar_menu", 1000);
        XC.put("tb.friend_feed", 20);
        XC.put("net_err_record", 30);
        XC.put("tb_face_package", 30);
        XC.put("tb.recommend_friend", 10);
        XC.put("tb.searchperson_history", 5);
        XC.put("tb.game_center_home", 20);
        XC.put("tb.game_center_list", 20);
        XD = new ArrayList<>();
        XD.add("tb.square");
        XD.add("tb.first_dir");
        XD.add("tb.forum_rank");
        XD.add("tb.im_group_setting");
        XD.add("tb.im_personal_chat_setting");
        XD.add("tb.im_official_chat_setting");
        XD.add("net_err_record");
        XD.add("tb_user_profile");
        XD.add("tb_forum_recommend");
        XF = new HashMap<>();
        XE = new HashMap<>();
    }

    public static a tc() {
        if (XB == null) {
            XB = new a();
        }
        return XB;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cB(String str) {
        return P(str, null);
    }

    public o<String> cC(String str) {
        return Q(str, null);
    }

    public o<byte[]> P(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = XE.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gk = BdCacheService.gk();
            Integer num = XC.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (XD.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gk.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            XE.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> Q(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = XF.get(str3);
        BdCacheService gk = BdCacheService.gk();
        Integer num = XC.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (XD.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gk.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void R(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = XF.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gk().a(oVar);
                    XF.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cD(String str) {
        R(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        XE.clear();
        XF.clear();
    }
}
