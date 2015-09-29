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
    public static a Wi = null;
    private static HashMap<String, Integer> Wj = new HashMap<>();
    private static ArrayList<String> Wk;
    private static HashMap<String, o<byte[]>> Wl;
    private static HashMap<String, o<String>> Wm;

    static {
        Wj.put("tb.pb_mark", 50);
        Wj.put("tb.pb_history", 300);
        Wj.put("tb.pb_normal", 1);
        Wj.put("tb.pb_editor", 50);
        Wj.put("tb.live_hotlist", 20);
        Wj.put("tb.live_hotlist", 20);
        Wj.put("tb.my_pages", 5);
        Wj.put("tb.my_forums", 3);
        Wj.put("tb.my_bookmarks", 3);
        Wj.put("tb.my_posts", 3);
        Wj.put("tb.im_frsgroup", 50);
        Wj.put("tb.im_hotgroup", 30);
        Wj.put("tb.im_groupinfo", 50);
        Wj.put("tb.im_groupactivity", 50);
        Wj.put("tb.im_entergroup", 10);
        Wj.put("tb.im_enterforum_groupinfo", 10);
        Wj.put("tb.im_group_setting", 3);
        Wj.put("tb.im_personal_chat_setting", 3);
        Wj.put("tb.im_official_chat_setting", 3);
        Wj.put("tb.im_group_search_history", 50);
        Wj.put("tb.im_official_history", 50);
        Wj.put("tb.im_recommend_detail", 10);
        Wj.put("tb.square", 1);
        Wj.put("tb.first_dir", 1);
        Wj.put("tb.forum_rank", 20);
        Wj.put("tb.pic_gif", 50);
        Wj.put("tb.official_bar_menu", 1000);
        Wj.put("tb.friend_feed", 20);
        Wj.put("net_err_record", 30);
        Wj.put("tb_face_package", 30);
        Wj.put("tb.recommend_friend", 10);
        Wj.put("tb.searchperson_history", 5);
        Wj.put("tb.game_center_home", 20);
        Wj.put("tb.game_center_list", 20);
        Wk = new ArrayList<>();
        Wk.add("tb.square");
        Wk.add("tb.first_dir");
        Wk.add("tb.forum_rank");
        Wk.add("tb.im_group_setting");
        Wk.add("tb.im_personal_chat_setting");
        Wk.add("tb.im_official_chat_setting");
        Wk.add("net_err_record");
        Wk.add("tb_user_profile");
        Wk.add("tb_forum_recommend");
        Wm = new HashMap<>();
        Wl = new HashMap<>();
    }

    public static a sO() {
        if (Wi == null) {
            Wi = new a();
        }
        return Wi;
    }

    private a() {
        super(2000998);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public o<byte[]> cp(String str) {
        return T(str, null);
    }

    public o<String> cq(String str) {
        return U(str, null);
    }

    public o<byte[]> T(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<byte[]> oVar = Wl.get(str3);
        if (oVar == null || !(oVar instanceof o)) {
            BdCacheService gl = BdCacheService.gl();
            Integer num = Wj.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (Wk.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                oVar = gl.b(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            Wl.put(str3, oVar);
            return oVar;
        }
        return oVar;
    }

    public o<String> U(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? String.valueOf(str) + str2 : str;
        o<String> oVar = Wm.get(str3);
        BdCacheService gl = BdCacheService.gl();
        Integer num = Wj.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (Wk.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return gl.a(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return oVar;
        }
    }

    public void V(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = String.valueOf(str) + str2;
            }
            o<String> oVar = Wm.get(str);
            if (oVar != null) {
                try {
                    BdCacheService.gl().a(oVar);
                    Wm.remove(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }

    public void cr(String str) {
        V(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Wl.clear();
        Wm.clear();
    }
}
