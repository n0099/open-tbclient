package com.baidu.tbadk.BdToken;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FloatStrategy;
/* loaded from: classes.dex */
public class n {
    private boolean bRP;
    private boolean bRQ;
    private boolean bRR;

    /* loaded from: classes.dex */
    public static class a {
        public String browsetimepage;
        public Integer duration;
        public Integer show_num;
        public Long show_time_begin;
        public Long show_time_end;
        public String toast;
        public Integer un_do_mission;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final n bRS = new n();
    }

    public static n aew() {
        return b.bRS;
    }

    private n() {
        this.bRP = false;
        this.bRQ = true;
        this.bRR = false;
    }

    public void b(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
        a aVar2;
        if (aVar != null && aVar.aeM() != null && aVar.aeM().size() > 0) {
            ArrayList<FloatStrategy> aeM = aVar.aeM();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<FloatStrategy> it = aeM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                FloatStrategy next = it.next();
                if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                    a aVar3 = new a();
                    aVar3.browsetimepage = next.browsetimepage;
                    aVar3.duration = next.duration;
                    aVar3.show_num = next.show_num;
                    aVar3.show_time_begin = next.show_time_begin;
                    aVar3.show_time_end = next.show_time_end;
                    aVar3.toast = next.toast;
                    aVar3.un_do_mission = next.un_do_mission;
                    aVar2 = aVar3;
                    break;
                }
            }
            if (aVar2 == null) {
                lW("");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("un_do_mission", aVar2.un_do_mission.intValue());
                jSONObject.put("browsetimepage", aVar2.browsetimepage);
                jSONObject.put("duration", aVar2.duration.intValue());
                jSONObject.put("show_time_begin", aVar2.show_time_begin.longValue());
                jSONObject.put("show_time_end", aVar2.show_time_end.longValue());
                jSONObject.put("show_num", aVar2.show_num.intValue());
                jSONObject.put("toast", aVar2.toast);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    lW("");
                    return;
                }
                if (!jSONObject2.equals(com.baidu.tbadk.core.sharedPref.b.alP().getString("pref_key_strategy_json", null))) {
                    lW(jSONObject2);
                }
                a(aVar2, true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void dM(boolean z) {
        this.bRP = z;
        if (this.bRP && this.bRQ) {
            this.bRQ = false;
            if (!this.bRR && c.adX().adZ()) {
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("pref_key_strategy_json", null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        a aVar = new a();
                        aVar.un_do_mission = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        aVar.browsetimepage = jSONObject.optString("browsetimepage", "");
                        aVar.duration = Integer.valueOf(jSONObject.optInt("duration", 0));
                        aVar.show_time_begin = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        aVar.show_time_end = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        aVar.show_num = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        aVar.toast = jSONObject.optString("toast", null);
                        a(aVar, false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void lW(String str) {
        com.baidu.tbadk.core.sharedPref.b.alP().putString("pref_key_strategy_json", str);
        com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_float_tip_num", 0);
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            try {
                if (this.bRP) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("pref_key_task_first_open", true);
                    int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("pref_key_float_tip_num", 0);
                    long j = com.baidu.tbadk.core.sharedPref.b.alP().getLong("pref_key_new_task_complete_time", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (z2) {
                        if (a(aVar)) {
                            this.bRR = true;
                            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("pref_key_task_first_open", false);
                        }
                    } else if (a(aVar, currentTimeMillis / 1000, j / 1000)) {
                        if (z) {
                            if (a(aVar)) {
                                this.bRR = true;
                                com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_float_tip_num", 0);
                            }
                        } else if (i < aVar.show_num.intValue() && a(aVar)) {
                            this.bRR = true;
                            com.baidu.tbadk.core.sharedPref.b.alP().putInt("pref_key_float_tip_num", i + 1);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private boolean a(a aVar) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921409, aVar), Boolean.class);
        if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Boolean)) {
            return false;
        }
        return ((Boolean) runTask.getData()).booleanValue();
    }

    private boolean a(a aVar, long j, long j2) {
        boolean z;
        if (aVar != null && j2 > 0 && !TextUtils.isEmpty(aVar.browsetimepage) && aVar.show_time_begin.longValue() < aVar.show_time_end.longValue() && j >= aVar.show_time_begin.longValue() && j <= aVar.show_time_end.longValue() && aVar.show_num.intValue() > 0 && aVar.un_do_mission.intValue() >= 0 && j > j2) {
            String[] split = aVar.browsetimepage.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length > 0) {
                for (String str : split) {
                    if ("3".equals(str)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                long intValue = aVar.un_do_mission.intValue() * 86400;
                long j3 = j - j2;
                return j3 > intValue && j3 < 86400 + intValue;
            }
            return false;
        }
        return false;
    }

    public void o(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null && p(bVar)) {
            com.baidu.tbadk.core.sharedPref.b.alP().putLong("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void aex() {
        com.baidu.tbadk.core.sharedPref.b.alP().putLong("pref_key_new_task_complete_time", System.currentTimeMillis());
    }

    private boolean p(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        switch (bVar.getTaskType()) {
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }
}
