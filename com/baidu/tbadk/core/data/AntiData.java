package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Anti;
/* loaded from: classes.dex */
public class AntiData implements Serializable {
    private static final long serialVersionUID = 2355009973517935888L;
    private String block_forum_id;
    private String block_forum_name;
    private int block_stat;
    private int forbid_flag;
    private String forbid_info;
    private int hide_stat;
    private int ifpost;
    private int ifposta;
    private int need_vcode;
    private String tbs;
    private String user_id;
    private String user_name;
    private String vcode_md5;
    private String vcode_pic_url;
    private int vcode_stat;
    private String voice_message;
    private boolean has_chance = true;
    private int days_tofree = 0;
    private int ifvoice = 1;
    private int ifaddition = 0;

    public boolean isIfvoice() {
        return this.ifvoice == 1;
    }

    public void setIfVoice(boolean z) {
        this.ifvoice = z ? 1 : 0;
    }

    public String getVoice_message() {
        return this.voice_message;
    }

    public int getIfpost() {
        return this.ifpost;
    }

    public void setIfpost(int i) {
        this.ifpost = i;
    }

    public int getIfposta() {
        return this.ifposta;
    }

    public void setIfposta(int i) {
        this.ifposta = i;
    }

    public int getForbid_flag() {
        return this.forbid_flag;
    }

    public void setForbid_flag(int i) {
        this.forbid_flag = i;
    }

    public String getTbs() {
        return this.tbs;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }

    public int getNeed_vcode() {
        return this.need_vcode;
    }

    public void setNeed_vcode(int i) {
        this.need_vcode = i;
    }

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public void setVcode_md5(String str) {
        this.vcode_md5 = str;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public void setVcode_pic_url(String str) {
        this.vcode_pic_url = str;
    }

    public int getVcode_stat() {
        return this.vcode_stat;
    }

    public int getHide_stat() {
        return this.hide_stat;
    }

    public int getBlock_stat() {
        return this.block_stat;
    }

    public boolean isHas_chance() {
        return this.has_chance;
    }

    public int getDays_tofree() {
        return this.days_tofree;
    }

    public String getBlock_forum_name() {
        return this.block_forum_name;
    }

    public String getBlock_forum_id() {
        return this.block_forum_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public void setBlock_forum_id(String str) {
        this.block_forum_id = str;
    }

    public void setBlock_forum_name(String str) {
        this.block_forum_name = str;
    }

    public void parserProtobuf(Anti anti) {
        if (anti != null) {
            this.ifpost = anti.ifpost.intValue();
            this.ifposta = anti.ifposta.intValue();
            this.forbid_flag = anti.forbid_flag.intValue();
            this.tbs = anti.tbs;
            if (TbadkApplication.m252getInst() != null && this.tbs != null && this.tbs.length() > 0) {
                TbadkApplication.m252getInst().setTbs(this.tbs);
            }
            this.need_vcode = anti.need_vcode.intValue();
            this.vcode_md5 = anti.vcode_md5;
            this.vcode_pic_url = anti.vcode_pic_url;
            this.forbid_info = anti.forbid_info;
            this.ifvoice = anti.ifvoice.intValue();
            this.voice_message = anti.voice_message;
            this.block_stat = anti.block_stat.intValue();
            this.hide_stat = anti.hide_stat.intValue();
            this.vcode_stat = anti.vcode_stat.intValue();
            this.days_tofree = anti.days_tofree.intValue();
            this.has_chance = anti.has_chance.intValue() == 1;
            this.ifaddition = anti.ifaddition.intValue();
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e("AntiData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ifpost = jSONObject.optInt("ifpost", 0);
                this.ifposta = jSONObject.optInt("ifposta", 0);
                this.forbid_flag = jSONObject.optInt("forbid_flag", 0);
                this.tbs = jSONObject.optString("tbs");
                if (TbadkApplication.m252getInst() != null && this.tbs != null && this.tbs.length() > 0) {
                    TbadkApplication.m252getInst().setTbs(this.tbs);
                }
                this.need_vcode = jSONObject.optInt("need_vcode", 0);
                this.vcode_md5 = jSONObject.optString("vcode_md5");
                this.vcode_pic_url = jSONObject.optString("vcode_pic_url");
                this.forbid_info = jSONObject.optString("forbid_info");
                this.ifvoice = jSONObject.optInt("ifvoice", 1);
                this.voice_message = jSONObject.optString("voice_message");
                this.block_stat = jSONObject.optInt("block_stat", 0);
                this.hide_stat = jSONObject.optInt("hide_stat", 0);
                this.vcode_stat = jSONObject.optInt("vcode_stat", 0);
                this.days_tofree = jSONObject.optInt("days_tofree", 1);
                this.has_chance = jSONObject.optInt("has_chance", 1) == 1;
                this.ifaddition = jSONObject.optInt("ifaddition", 0);
            } catch (Exception e) {
                BdLog.e("AntiData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        BdLog.v("AntiData", "logPrint", "ifpost = " + String.valueOf(this.ifpost));
        BdLog.v("AntiData", "logPrint", "ifposta = " + String.valueOf(this.ifposta));
        BdLog.v("AntiData", "logPrint", "forbid_flag = " + String.valueOf(this.forbid_flag));
        BdLog.v("AntiData", "logPrint", "tbs = " + this.tbs);
        BdLog.v("AntiData", "logPrint", "need_vcode = " + String.valueOf(this.need_vcode));
        BdLog.v("AntiData", "logPrint", "vcode_md5 = " + this.vcode_md5);
    }

    public void setForbid_info(String str) {
        this.forbid_info = str;
    }

    public String getForbid_info() {
        return this.forbid_info;
    }

    public boolean isIfAddition() {
        return this.ifaddition == 1;
    }
}
