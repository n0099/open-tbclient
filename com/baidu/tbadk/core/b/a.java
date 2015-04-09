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
    public static a QX = null;
    private static HashMap<String, Integer> QY = new HashMap<>();
    private static ArrayList<String> QZ;
    private static HashMap<String, t<byte[]>> Ra;
    private static HashMap<String, t<String>> Rb;

    static {
        QY.put("tb.pb_mark", 50);
        QY.put("tb.pb_history", 300);
        QY.put("tb.pb_normal", 1);
        QY.put("tb.pb_editor", 50);
        QY.put("tb.live_hotlist", 20);
        QY.put("tb.live_hotlist", 20);
        QY.put("tb.my_pages", 5);
        QY.put("tb.my_forums", 3);
        QY.put("tb.my_bookmarks", 3);
        QY.put("tb.my_posts", 3);
        QY.put("tb.im_frsgroup", 50);
        QY.put("tb.im_hotgroup", 30);
        QY.put("tb.im_groupinfo", 50);
        QY.put("tb.im_groupactivity", 50);
        QY.put("tb.im_entergroup", 10);
        QY.put("tb.im_enterforum_groupinfo", 10);
        QY.put("tb.im_group_setting", 3);
        QY.put("tb.im_personal_chat_setting", 3);
        QY.put("tb.im_official_chat_setting", 3);
        QY.put("tb.im_group_search_history", 50);
        QY.put("tb.im_official_history", 50);
        QY.put("tb.im_recommend_detail", 10);
        QY.put("tb.square", 1);
        QY.put("tb.first_dir", 1);
        QY.put("tb.forum_rank", 20);
        QY.put("tb.pic_gif", 50);
        QY.put("tb.official_bar_menu", 1000);
        QY.put("tb.friend_feed", 20);
        QY.put("net_err_record", 30);
        QY.put("tb_face_package", 30);
        QY.put("tb.recommend_friend", 10);
        QY.put("tb.searchperson_history", 5);
        QY.put("tb.game_center_home", 20);
        QY.put("tb.game_center_list", 20);
        QZ = new ArrayList<>();
        QZ.add("tb.square");
        QZ.add("tb.first_dir");
        QZ.add("tb.forum_rank");
        QZ.add("tb.im_group_setting");
        QZ.add("tb.im_personal_chat_setting");
        QZ.add("tb.im_official_chat_setting");
        QZ.add("net_err_record");
        QZ.add("tb_user_profile");
        QZ.add("tb_forum_recommend");
        Rb = new HashMap<>();
        Ra = new HashMap<>();
    }

    public static void fR() {
        QX = null;
    }

    public static a rc() {
        if (QX == null) {
            QX = new a();
        }
        return QX;
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
        t<byte[]> tVar = Ra.get(str3);
        if (tVar == null || !(tVar instanceof t)) {
            BdCacheService gp = BdCacheService.gp();
            Integer num = QY.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (QZ.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                tVar = gp.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Ra.put(str3, tVar);
            return tVar;
        }
        return tVar;
    }

    public t<String> S(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        t<String> tVar = Rb.get(str3);
        BdCacheService gp = BdCacheService.gp();
        Integer num = QY.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (QZ.contains(str)) {
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
            t<String> tVar = Rb.get(str);
            if (tVar != null) {
                try {
                    BdCacheService.gp().a(tVar);
                    Rb.remove(str);
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
        Ra.clear();
        Rb.clear();
    }
}
