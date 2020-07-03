package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.DeleteThreadInfo;
/* loaded from: classes.dex */
public class AntiData implements Serializable {
    private static final long serialVersionUID = 2355009973517935888L;
    private String block_forum_id;
    private String block_forum_name;
    private int block_stat;
    private List<DeleteThreadInfo> delThreadInfoList;
    private int forbid_flag;
    private String forbid_info;
    private int hide_stat;
    private int ifpost;
    private int ifposta;
    public BlockPopInfoData mFrsForbidenDialogInfo;
    private int need_vcode;
    private int pollLevel;
    private String poll_message;
    private String tbs;
    private String user_id;
    private String user_name;
    private String vcode_md5;
    private String vcode_pic_url;
    private int vcode_stat;
    private String video_message;
    public String voice_message;
    private boolean has_chance = true;
    private int days_tofree = 0;
    private int ifvoice = 1;
    private int ifaddition = 0;
    public int replyPrivateFlag = 1;

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

    public String getVideo_message() {
        return this.video_message;
    }

    public void parserProtobuf(Anti anti) {
        if (anti != null) {
            this.ifpost = anti.ifpost.intValue();
            this.ifposta = anti.ifposta.intValue();
            this.forbid_flag = anti.forbid_flag.intValue();
            this.tbs = anti.tbs;
            if (TbadkCoreApplication.getInst() != null && this.tbs != null && this.tbs.length() > 0) {
                TbadkCoreApplication.getInst().setTbs(this.tbs);
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
            this.delThreadInfoList = new ArrayList();
            for (int i = 0; i < anti.del_thread_text.size(); i++) {
                DeleteThreadInfo deleteThreadInfo = new DeleteThreadInfo();
                deleteThreadInfo.text_id = anti.del_thread_text.get(i).text_id.intValue();
                deleteThreadInfo.text_info = anti.del_thread_text.get(i).text_info;
                this.delThreadInfoList.add(deleteThreadInfo);
            }
            this.poll_message = anti.poll_message;
            this.video_message = anti.video_message;
            if (anti.block_pop_info != null) {
                this.mFrsForbidenDialogInfo = new BlockPopInfoData();
                this.mFrsForbidenDialogInfo.ahead_info = anti.block_pop_info.ahead_info;
                this.mFrsForbidenDialogInfo.ahead_url = anti.block_pop_info.ahead_url;
                this.mFrsForbidenDialogInfo.ok_info = anti.block_pop_info.ok_info;
                this.mFrsForbidenDialogInfo.can_post = anti.block_pop_info.can_post;
                this.mFrsForbidenDialogInfo.block_info = anti.block_pop_info.block_info;
                this.mFrsForbidenDialogInfo.ahead_type = anti.block_pop_info.ahead_type;
            }
            this.replyPrivateFlag = anti.reply_private_flag.intValue();
            this.pollLevel = anti.poll_level.intValue();
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ifpost = jSONObject.optInt("ifpost", 0);
                this.ifposta = jSONObject.optInt("ifposta", 0);
                this.forbid_flag = jSONObject.optInt("forbid_flag", 0);
                this.tbs = jSONObject.optString("tbs");
                if (TbadkCoreApplication.getInst() != null && this.tbs != null && this.tbs.length() > 0) {
                    TbadkCoreApplication.getInst().setTbs(this.tbs);
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
                this.poll_message = jSONObject.optString("poll_message");
                this.video_message = jSONObject.optString("video_message");
                JSONObject optJSONObject = jSONObject.optJSONObject("block_pop_info");
                if (optJSONObject != null) {
                    this.mFrsForbidenDialogInfo = new BlockPopInfoData();
                    this.mFrsForbidenDialogInfo.ahead_info = optJSONObject.optString("ahead_info");
                    this.mFrsForbidenDialogInfo.ahead_url = optJSONObject.optString("ahead_url");
                    this.mFrsForbidenDialogInfo.ok_info = optJSONObject.optString("ok_info");
                    this.mFrsForbidenDialogInfo.can_post = Integer.valueOf(optJSONObject.optInt("can_post"));
                    this.mFrsForbidenDialogInfo.block_info = optJSONObject.optString("block_info");
                    this.mFrsForbidenDialogInfo.ahead_type = Integer.valueOf(optJSONObject.optInt("ahead_type"));
                }
                this.replyPrivateFlag = jSONObject.optInt("reply_private_flag", 1);
                this.pollLevel = jSONObject.optInt("poll_level", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ifpost", this.ifpost);
            jSONObject.put("ifposta", this.ifposta);
            jSONObject.put("forbid_flag", this.forbid_flag);
            jSONObject.put("tbs", this.tbs);
            jSONObject.put("need_vcode", this.need_vcode);
            jSONObject.put("vcode_md5", this.vcode_md5);
            jSONObject.put("vcode_pic_url", this.vcode_pic_url);
            jSONObject.put("forbid_info", this.forbid_info);
            jSONObject.put("ifvoice", this.ifvoice);
            jSONObject.put("voice_message", this.voice_message);
            jSONObject.put("block_stat", this.block_stat);
            jSONObject.put("hide_stat", this.hide_stat);
            jSONObject.put("vcode_stat", this.vcode_stat);
            jSONObject.put("days_tofree", this.days_tofree);
            jSONObject.put("has_chance", this.has_chance ? 1 : 0);
            jSONObject.put("ifaddition", this.ifaddition);
            jSONObject.put("poll_message", this.poll_message);
            jSONObject.put("video_message", this.video_message);
            if (this.mFrsForbidenDialogInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ahead_info", this.mFrsForbidenDialogInfo.ahead_info);
                jSONObject2.put("ahead_url", this.mFrsForbidenDialogInfo.ahead_url);
                jSONObject2.put("ok_info", this.mFrsForbidenDialogInfo.ok_info);
                jSONObject2.put("can_post", this.mFrsForbidenDialogInfo.can_post);
                jSONObject2.put("block_info", this.mFrsForbidenDialogInfo.block_info);
                jSONObject2.put("ahead_type", this.mFrsForbidenDialogInfo.ahead_type);
                jSONObject.put("block_pop_info", jSONObject2);
            }
            jSONObject.put("reply_private_flag", this.replyPrivateFlag);
            jSONObject.put("poll_level", this.pollLevel);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
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

    public String getPollMessage() {
        return this.poll_message;
    }

    public List<DeleteThreadInfo> getDelThreadInfoList() {
        return this.delThreadInfoList;
    }

    public int getPollLevel() {
        return this.pollLevel;
    }

    public void setPollLevel(int i) {
        this.pollLevel = i;
    }
}
