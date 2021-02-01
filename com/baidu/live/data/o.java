package com.baidu.live.data;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o {
    private String aGR;
    private String aGS;
    private a aGT = new a();
    private List<b> aGU = new ArrayList();
    private List<c> aGV = new ArrayList();
    private int userType;

    public boolean By() {
        return this.userType == 2;
    }

    public boolean Bz() {
        return (this.userType == 1 || this.userType == 2) ? false : true;
    }

    public a BA() {
        return this.aGT;
    }

    public String BB() {
        return this.aGR;
    }

    public String BC() {
        return this.aGS;
    }

    public List<b> BD() {
        return this.aGU;
    }

    public List<c> BE() {
        return this.aGV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.userType = jSONObject.optInt("user_type");
                this.aGR = jSONObject.optString("h5_url");
                this.aGS = jSONObject.optString("screen");
                this.aGT.parseJson(jSONObject.optJSONObject("result"));
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            c cVar = new c();
                            cVar.parseJson((JSONObject) optJSONArray.get(i));
                            this.aGV.add(cVar);
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
                            this.aGU.add(bVar);
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

    /* loaded from: classes11.dex */
    public class a {
        private double aGW;
        private double aGX;
        private double aGY;
        private int aGZ;
        private int aHa;
        private String aHb;
        private String aHc;
        private int aHd;
        private int aHe;
        private int aHf;
        private int aHg;
        private String aHh;
        private int answer;

        public a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.aGW = jSONObject.optDouble("average_amount");
            this.aGX = jSONObject.optDouble("my_amount");
            this.aGY = jSONObject.optDouble("right_scale");
            this.aGZ = jSONObject.optInt("total_amount");
            this.aHa = jSONObject.optInt("currect_number");
            this.aHd = jSONObject.optInt("ques_id");
            this.aHb = jSONObject.optString("ques_name");
            this.answer = jSONObject.optInt("answer");
            this.aHc = jSONObject.optString("answer_option");
            this.aHe = jSONObject.optInt("is_right");
            this.aHf = jSONObject.optInt("team_multiple");
            this.aHg = jSONObject.optInt("single_multiple");
            this.aHh = jSONObject.optString("answer_content");
        }

        public double BF() {
            return this.aGW;
        }

        public double BG() {
            return this.aGX;
        }

        public double BH() {
            return this.aGY;
        }

        public int BI() {
            return this.aGZ;
        }

        public String BJ() {
            return this.aHh;
        }

        public int BK() {
            return this.aHa;
        }

        public int getAnswer() {
            return this.answer;
        }

        public String BL() {
            return this.aHc;
        }

        public int BM() {
            return this.aHe;
        }

        public int BN() {
            return this.aHf;
        }

        public boolean BO() {
            return this.aHg == 2;
        }
    }

    /* loaded from: classes11.dex */
    public class b {
        private String aHj;
        private int aHk;
        private int aHl;
        private String aHm;
        private int aHn;
        private String aHo;
        private String avatar;
        private String nickname;
        private String user_id;

        public b() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.nickname = jSONObject.optString("nickname");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.user_id = jSONObject.optString("user_id");
            this.aHj = jSONObject.optString("is_answer");
            this.aHk = jSONObject.optInt("user_answer");
            this.aHl = jSONObject.optInt("is_double");
            this.aHm = jSONObject.optString("team_id");
            this.aHn = jSONObject.optInt("is_leader");
            this.aHo = jSONObject.optString("subject_id");
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int BP() {
            return this.aHk;
        }

        public int BQ() {
            return this.aHl;
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        private double aHp;
        private String icon;
        private String tips;

        public String getTips() {
            return this.tips;
        }

        public String getIcon() {
            return this.icon;
        }

        public double BR() {
            return this.aHp;
        }

        public void parseJson(JSONObject jSONObject) {
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.aHp = jSONObject.optDouble(LogConfig.LOG_AMOUNT);
        }
    }
}
