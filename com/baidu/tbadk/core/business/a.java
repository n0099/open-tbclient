package com.baidu.tbadk.core.business;

import android.text.format.DateUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a exV;
    private ArrayList<com.baidu.tbadk.BdToken.completeTask.a> exW = new ArrayList<>();

    public static a bjT() {
        if (exV == null) {
            synchronized (a.class) {
                if (exV == null) {
                    exV = new a();
                }
            }
        }
        return exV;
    }

    public void N(JSONArray jSONArray) {
        if (jSONArray != null) {
            O(jSONArray);
        }
    }

    private void O(JSONArray jSONArray) {
        JSONObject jSONObject;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount) && jSONArray != null) {
            this.exW.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject = jSONArray.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                com.baidu.tbadk.BdToken.completeTask.a aVar = new com.baidu.tbadk.BdToken.completeTask.a();
                aVar.activityId = jSONObject.optInt("active_id");
                aVar.missionId = jSONObject.optInt("mission_id");
                aVar.showType = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE);
                long j = getLong("business_update_time" + currentAccount + aVar.activityId);
                if (isContains("business_count_hint" + currentAccount + aVar.activityId) && DateUtils.isToday(j)) {
                    aVar.showNum = getInt("business_count_hint" + currentAccount + aVar.activityId);
                } else {
                    aVar.showNum = jSONObject.optInt("show_num");
                    clear();
                    putInt("business_count_hint" + currentAccount + aVar.activityId, aVar.showNum);
                    putLong("business_update_time" + currentAccount + aVar.activityId, System.currentTimeMillis());
                }
                aVar.etw = jSONObject.optInt("show_time_begin");
                aVar.etx = jSONObject.optInt("show_time_end");
                JSONArray optJSONArray = jSONObject.optJSONArray("forumIds");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        aVar.etz.add((String) optJSONArray.get(i2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("show_page");
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    try {
                        aVar.ety.add((String) optJSONArray2.get(i3));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                this.exW.add(aVar);
            }
        }
    }

    public void putInt(String str, int i) {
        EditorHelper.putInt(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, i);
    }

    public void putLong(String str, long j) {
        EditorHelper.putLong(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, j);
    }

    public int getInt(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getInt(str, 0);
    }

    public long getLong(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getLong(str, 0L);
    }

    public boolean isContains(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).contains(str);
    }

    public void clear() {
        TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).edit().clear();
    }

    private ArrayList<com.baidu.tbadk.BdToken.completeTask.a> bjU() {
        return this.exW;
    }

    public void dF(String str, String str2) {
        ArrayList<com.baidu.tbadk.BdToken.completeTask.a> bjU = bjU();
        if (bjU != null && j.isNetWorkAvailable()) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < bjU.size()) {
                        int i3 = bjU.get(i2).activityId;
                        int i4 = bjU.get(i2).missionId;
                        int i5 = bjU.get(i2).showType;
                        int i6 = getInt("business_count_hint" + currentAccount + i3);
                        long j = bjU.get(i2).etw;
                        long j2 = bjU.get(i2).etx;
                        ArrayList<String> arrayList = bjU.get(i2).ety;
                        ArrayList<String> arrayList2 = bjU.get(i2).etz;
                        if (i6 != 0 && System.currentTimeMillis() / 1000 > j && System.currentTimeMillis() / 1000 < j2) {
                            int i7 = 0;
                            boolean z = false;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= arrayList.size()) {
                                    break;
                                }
                                if (arrayList.get(i8).equals(str)) {
                                    z = true;
                                }
                                i7 = i8 + 1;
                            }
                            if (z) {
                                if (str.equals("2")) {
                                    int i9 = 0;
                                    boolean z2 = false;
                                    while (true) {
                                        int i10 = i9;
                                        if (i10 >= arrayList2.size()) {
                                            break;
                                        }
                                        if (arrayList2.get(i10).equals(str2)) {
                                            z2 = true;
                                        }
                                        i9 = i10 + 1;
                                    }
                                    if (!z2) {
                                    }
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(String.valueOf(i3), String.valueOf(i4));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                sendCompleteTask(jSONObject.toString());
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void sendCompleteTask(String str) {
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
        completeTaskReqMsg.completeId = str;
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }
}
