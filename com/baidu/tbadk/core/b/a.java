package com.baidu.tbadk.core.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    public static a QV = null;
    private static HashMap<String, Integer> QW = new HashMap<>();
    private static ArrayList<String> QX;
    private static HashMap<String, t<byte[]>> QY;
    private static HashMap<String, t<String>> QZ;

    static {
        QW.put("tb.pb_mark", 50);
        QW.put("tb.pb_history", 300);
        QW.put("tb.pb_normal", 1);
        QW.put("tb.pb_editor", 50);
        QW.put("tb.live_hotlist", 20);
        QW.put("tb.live_hotlist", 20);
        QW.put("tb.my_pages", 5);
        QW.put("tb.my_forums", 3);
        QW.put("tb.my_bookmarks", 3);
        QW.put("tb.my_posts", 3);
        QW.put("tb.im_frsgroup", 50);
        QW.put("tb.im_hotgroup", 30);
        QW.put("tb.im_groupinfo", 50);
        QW.put("tb.im_groupactivity", 50);
        QW.put("tb.im_entergroup", 10);
        QW.put("tb.im_enterforum_groupinfo", 10);
        QW.put("tb.im_group_setting", 3);
        QW.put("tb.im_personal_chat_setting", 3);
        QW.put("tb.im_official_chat_setting", 3);
        QW.put("tb.im_group_search_history", 50);
        QW.put("tb.im_official_history", 50);
        QW.put("tb.im_recommend_detail", 10);
        QW.put("tb.square", 1);
        QW.put("tb.first_dir", 1);
        QW.put("tb.forum_rank", 20);
        QW.put("tb.pic_gif", 50);
        QW.put("tb.official_bar_menu", 1000);
        QW.put("tb.friend_feed", 20);
        QW.put("net_err_record", 30);
        QW.put("tb_face_package", 30);
        QW.put("tb.recommend_friend", 10);
        QW.put("tb.searchperson_history", 5);
        QW.put("tb.game_center_home", 20);
        QW.put("tb.game_center_list", 20);
        QX = new ArrayList<>();
        QX.add("tb.square");
        QX.add("tb.first_dir");
        QX.add("tb.forum_rank");
        QX.add("tb.im_group_setting");
        QX.add("tb.im_personal_chat_setting");
        QX.add("tb.im_official_chat_setting");
        QX.add("net_err_record");
        QX.add("tb_user_profile");
        QX.add("tb_forum_recommend");
        QZ = new HashMap<>();
        QY = new HashMap<>();
    }

    public static void fR() {
        QV = null;
    }

    public static a rc() {
        if (QV == null) {
            QV = new a();
        }
        return QV;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public t<byte[]> bW(String str) {
        return R(str, null);
    }

    public t<String> bX(String str) {
        return S(str, null);
    }

    public t<byte[]> R(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<byte[]> tVar = QY.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService gp = BdCacheService.gp();
            Integer num = QW.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (QX.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = gp.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            QY.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> S(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = QZ.get(str3);
        BdCacheService gp = BdCacheService.gp();
        Integer num = QW.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (QX.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gp.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return tVar;
        }
    }

    public void T(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            t<String> tVar = QZ.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.gp().a(tVar);
                    QZ.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void bY(String str) {
        T(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        QY.clear();
        QZ.clear();
    }
}
