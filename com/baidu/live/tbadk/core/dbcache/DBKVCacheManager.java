package com.baidu.live.tbadk.core.dbcache;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.cache.BdCacheService;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class DBKVCacheManager extends CustomMessageListener {
    public static final String ALA_GIFT_LIST_CACHE_KEY = "tb.ala.gift_list";
    private static final int DEF_CACHE_COUNT_LIMIT = 20;
    public static final int PB_HISROTY_MAX_COUNT = 300;
    private static HashMap<String, BdKVCache<byte[]>> byteCacheMap;
    private static HashMap<String, BdKVCache<String>> stringCacheMap;
    public static DBKVCacheManager mInstance = null;
    private static HashMap<String, Integer> cacheCountLimitMap = new HashMap<>();
    private static ArrayList<String> noEvictList = new ArrayList<>();

    static {
        noEvictList.add(ALA_GIFT_LIST_CACHE_KEY);
        stringCacheMap = new HashMap<>();
        byteCacheMap = new HashMap<>();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KV_CACHE_SUCC));
    }

    public static void clearInstance() {
        mInstance = null;
    }

    public static DBKVCacheManager getInstance() {
        if (mInstance == null) {
            mInstance = new DBKVCacheManager();
        }
        return mInstance;
    }

    private DBKVCacheManager() {
        super(MessageConfig.DATABASE_CREATED);
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public BdKVCache<byte[]> getByteCacheWithSapce(String str) {
        return getByteCacheWithSapce(str, null);
    }

    public BdKVCache<String> getStringCacheWithSapce(String str) {
        return getStringCacheWithSapce(str, null);
    }

    public BdKVCache<byte[]> getByteCacheWithSapce(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        BdKVCache<byte[]> bdKVCache = byteCacheMap.get(str3);
        if (bdKVCache == null || !(bdKVCache instanceof BdKVCache)) {
            BdCacheService sharedInstance = BdCacheService.sharedInstance();
            Integer num = cacheCountLimitMap.get(str);
            num = (num == null || num.intValue() == 0) ? 20 : 20;
            BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
            if (noEvictList.contains(str)) {
                cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
            }
            try {
                bdKVCache = sharedInstance.getAndStartBlobCache(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            byteCacheMap.put(str3, bdKVCache);
            return bdKVCache;
        }
        return bdKVCache;
    }

    public BdKVCache<String> getStringCacheWithSapce(String str, String str2) {
        if (str == null) {
            return null;
        }
        String str3 = str2 != null ? str + str2 : str;
        BdKVCache<String> bdKVCache = stringCacheMap.get(str3);
        BdCacheService sharedInstance = BdCacheService.sharedInstance();
        Integer num = cacheCountLimitMap.get(str);
        num = (num == null || num.intValue() == 0) ? 20 : 20;
        BdCacheService.CacheEvictPolicy cacheEvictPolicy = BdCacheService.CacheEvictPolicy.LRU_ON_INSERT;
        if (noEvictList.contains(str)) {
            cacheEvictPolicy = BdCacheService.CacheEvictPolicy.NO_EVICT;
        }
        try {
            return sharedInstance.getAndStartTextCache(str3, BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, cacheEvictPolicy, num.intValue());
        } catch (Exception e) {
            BdLog.detailException(e);
            return bdKVCache;
        }
    }

    public void clearStringCacheWithSapce(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            BdKVCache<String> bdKVCache = stringCacheMap.get(str);
            if (bdKVCache != null) {
                try {
                    BdCacheService.sharedInstance().returnAndClearCache(bdKVCache);
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

    public void clearByteCacheWithSapce(String str) {
        clearByteCacheWithSapce(str, null);
    }

    public void clearByteCacheWithSapce(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str + str2;
            }
            BdKVCache<byte[]> bdKVCache = byteCacheMap.get(str);
            if (bdKVCache != null) {
                BdCacheService.sharedInstance().returnAndClearCache(bdKVCache);
                byteCacheMap.remove(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        byteCacheMap.clear();
        stringCacheMap.clear();
    }
}
