package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    private String aIr;
    private String aIs;
    private a aIt = new a();
    private List<b> aIu = new ArrayList();
    private List<c> aIv = new ArrayList();
    private int userType;

    public boolean BB() {
        return this.userType == 2;
    }

    public boolean BC() {
        return (this.userType == 1 || this.userType == 2) ? false : true;
    }

    public a BD() {
        return this.aIt;
    }

    public String BE() {
        return this.aIr;
    }

    public String BF() {
        return this.aIs;
    }

    public List<b> BG() {
        return this.aIu;
    }

    public List<c> BH() {
        return this.aIv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.userType = jSONObject.optInt("user_type");
                this.aIr = jSONObject.optString("h5_url");
                this.aIs = jSONObject.optString("screen");
                this.aIt.parseJson(jSONObject.optJSONObject("result"));
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            c cVar = new c();
                            cVar.parseJson((JSONObject) optJSONArray.get(i));
                            this.aIv.add(cVar);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("team");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        try {
                            b bVar = new b();
                            bVar.parseJson((JSONObject) optJSONArray2.get(i2));
                            this.aIu.add(bVar);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        private int aIA;
        private String aIB;
        private String aIC;
        private int aID;
        private int aIE;
        private int aIF;
        private int aIG;
        private String aIH;
        private double aIw;
        private double aIx;
        private double aIy;
        private int aIz;
        private int answer;

        public a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.aIw = jSONObject.optDouble("average_amount");
            this.aIx = jSONObject.optDouble("my_amount");
            this.aIy = jSONObject.optDouble("right_scale");
            this.aIz = jSONObject.optInt("total_amount");
            this.aIA = jSONObject.optInt("currect_number");
            this.aID = jSONObject.optInt("ques_id");
            this.aIB = jSONObject.optString("ques_name");
            this.answer = jSONObject.optInt("answer");
            this.aIC = jSONObject.optString("answer_option");
            this.aIE = jSONObject.optInt("is_right");
            this.aIF = jSONObject.optInt("team_multiple");
            this.aIG = jSONObject.optInt("single_multiple");
            this.aIH = jSONObject.optString("answer_content");
        }

        public double BI() {
            return this.aIw;
        }

        public double BJ() {
            return this.aIx;
        }

        public double BK() {
            return this.aIy;
        }

        public int BL() {
            return this.aIz;
        }

        public String BM() {
            return this.aIH;
        }

        public int BN() {
            return this.aIA;
        }

        public int getAnswer() {
            return this.answer;
        }

        public String BO() {
            return this.aIC;
        }

        public int BP() {
            return this.aIE;
        }

        public int BQ() {
            return this.aIF;
        }

        public boolean BR() {
            return this.aIG == 2;
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        private String aIJ;
        private int aIK;
        private int aIL;
        private String aIM;
        private int aIN;
        private String aIO;
        private String avatar;
        private String nickname;
        private String user_id;

        public b() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.nickname = jSONObject.optString("nickname");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.user_id = jSONObject.optString("user_id");
            this.aIJ = jSONObject.optString("is_answer");
            this.aIK = jSONObject.optInt("user_answer");
            this.aIL = jSONObject.optInt("is_double");
            this.aIM = jSONObject.optString("team_id");
            this.aIN = jSONObject.optInt("is_leader");
            this.aIO = jSONObject.optString("subject_id");
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int BS() {
            return this.aIK;
        }

        public int BT() {
            return this.aIL;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        private double aIP;
        private String icon;
        private String tips;

        public String getTips() {
            return this.tips;
        }

        public String getIcon() {
            return this.icon;
        }

        public double BU() {
            return this.aIP;
        }

        public void parseJson(JSONObject jSONObject) {
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aIP = jSONObject.optDouble(LogConfig.LOG_AMOUNT);
        }
    }
}
