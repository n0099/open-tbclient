package com.baidu.live.data;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaWheatInfoDataWrapper implements Serializable, Cloneable {
    private int activity_stage;
    private List<AlaWheatInfoData> anchorWheatBackupLists;
    private List<AlaWheatInfoData> anchorWheatLists;
    private List<AlaWheatInfoData> hostWheatLists;
    public boolean isEnterLiveData;
    private int is_applying;
    private int room_mode;
    private List<AlaWheatInfoData> xiangqinLists;
    private int xqcount;

    public AlaWheatInfoDataWrapper(String str) {
        try {
            this.isEnterLiveData = false;
            if (this.hostWheatLists == null) {
                this.hostWheatLists = new ArrayList();
            }
            if (this.anchorWheatLists == null) {
                this.anchorWheatLists = new ArrayList();
            }
            if (this.anchorWheatBackupLists == null) {
                this.anchorWheatBackupLists = new ArrayList();
            }
            if (this.xiangqinLists == null) {
                this.xiangqinLists = new ArrayList();
            }
            this.hostWheatLists.clear();
            this.anchorWheatLists.clear();
            this.anchorWheatBackupLists.clear();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.xqcount = jSONObject.optInt("xqcount", 0);
                this.room_mode = jSONObject.optInt("room_mode", 0);
                this.is_applying = jSONObject.optInt("is_applying", 0);
                this.activity_stage = jSONObject.optInt("activity_stage", 0);
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("host");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                            AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
                            if (jSONObject2 != null) {
                                alaWheatInfoData.parseJson(jSONObject2);
                            }
                            if (!TextUtils.isEmpty(alaWheatInfoData.uk)) {
                                this.hostWheatLists.add(alaWheatInfoData);
                            } else {
                                this.hostWheatLists.add(null);
                            }
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("anchor");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                            AlaWheatInfoData alaWheatInfoData2 = new AlaWheatInfoData();
                            if (jSONObject3 != null) {
                                alaWheatInfoData2.parseJson(jSONObject3);
                            }
                            if (!TextUtils.isEmpty(alaWheatInfoData2.uk)) {
                                this.anchorWheatLists.add(alaWheatInfoData2);
                            } else {
                                this.anchorWheatLists.add(null);
                            }
                            if (this.activity_stage != 4) {
                                this.anchorWheatBackupLists.add(alaWheatInfoData2);
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("xiangqin");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            JSONObject jSONObject4 = (JSONObject) optJSONArray3.opt(i3);
                            AlaWheatInfoData alaWheatInfoData3 = new AlaWheatInfoData();
                            if (jSONObject4 != null) {
                                alaWheatInfoData3.parseJson(jSONObject4);
                            }
                            if (!TextUtils.isEmpty(alaWheatInfoData3.uk)) {
                                this.xiangqinLists.add(alaWheatInfoData3);
                            } else {
                                this.xiangqinLists.add(null);
                            }
                            if (this.activity_stage == 4) {
                                this.anchorWheatBackupLists.add(alaWheatInfoData3);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parseJson(String str) throws Exception {
    }

    public List<AlaWheatInfoData> getHostWheatLists() {
        return this.hostWheatLists;
    }

    public List<AlaWheatInfoData> getAnchorWheatLists() {
        return this.anchorWheatLists;
    }

    public List<AlaWheatInfoData> getXiangqinLists() {
        return this.xiangqinLists;
    }

    public int getRoomMode() {
        return this.room_mode;
    }

    public int getActivityStage() {
        return this.activity_stage;
    }

    public int getXqCount() {
        return this.xqcount;
    }

    public boolean isChoiceStage() {
        return this.activity_stage == 2;
    }

    public boolean isResultsStage() {
        return this.activity_stage == 3;
    }

    public boolean isSweetStage() {
        return this.activity_stage == 4;
    }

    public List<AlaWheatInfoData> getAnchorWheatBackupLists() {
        return this.anchorWheatBackupLists;
    }

    public boolean isApplying() {
        return this.is_applying == 1;
    }
}
