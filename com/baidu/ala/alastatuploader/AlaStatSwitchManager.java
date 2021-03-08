package com.baidu.ala.alastatuploader;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.d;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaStatSwitchManager {
    private static volatile AlaStatSwitchManager inst = null;
    private boolean isInit = false;
    private Map<String, Map<String, Boolean>> switchMap = new HashMap();
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.ala.alastatuploader.AlaStatSwitchManager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((AlaSyncHttpResponseMessage) httpResponsedMessage).Ow() != null) {
                    AlaStatSwitchManager.this.isInit = false;
                    synchronized (AlaStatSwitchManager.class) {
                        AlaStatSwitchManager.this.initSwitch();
                    }
                }
            }
        }
    };

    public static AlaStatSwitchManager getInstance() {
        if (inst == null) {
            synchronized (AlaStatSwitchManager.class) {
                if (inst == null) {
                    inst = new AlaStatSwitchManager();
                }
            }
        }
        return inst;
    }

    private AlaStatSwitchManager() {
        this.syncListener.setSelfListener(false);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSwitch() {
        JSONObject jSONObject;
        if (!this.isInit) {
            String string = d.xf().getString("key_stat_switch", null);
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("max_wait_length", -1);
                    if (optInt > 0) {
                        AlaStatUploaderManager.MAX_LENGTH_WAIT_LIST = optInt;
                    }
                    int optInt2 = jSONObject.optInt("upload_length", -1);
                    if (optInt2 > 0) {
                        AlaStatUploaderManager.MAX_UPLOAD_LENGTH_WAIT_LIST = optInt2;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("switch");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    boolean z = optJSONObject2.optInt(next2, -1) == 1;
                                    Map<String, Boolean> map = this.switchMap.get(next);
                                    if (map == null) {
                                        map = new HashMap<>();
                                        this.switchMap.put(next, map);
                                    }
                                    map.put(next2, Boolean.valueOf(z));
                                }
                            }
                        }
                    }
                }
            }
            this.isInit = true;
        }
    }

    public boolean isSwithcOpen(String str, String str2) {
        Boolean bool;
        synchronized (AlaStatSwitchManager.class) {
            initSwitch();
        }
        Map<String, Boolean> map = this.switchMap.get(str);
        if (map != null && (bool = map.get(str2)) != null && (bool instanceof Boolean)) {
            return bool.booleanValue();
        }
        return false;
    }
}
