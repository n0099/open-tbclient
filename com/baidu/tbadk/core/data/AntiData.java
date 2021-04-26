package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.BlockPopInfo;
import tbclient.DeleteThreadInfo;
/* loaded from: classes3.dex */
public class AntiData implements Serializable {
    public static final long serialVersionUID = 2355009973517935888L;
    public String block_forum_id;
    public String block_forum_name;
    public int block_stat;
    public List<DeleteThreadInfo> delThreadInfoList;
    public int forbid_flag;
    public String forbid_info;
    public int hide_stat;
    public int ifpost;
    public int ifposta;
    public boolean isSexyForum;
    public BlockPopInfoData mFrsForbidenDialogInfo;
    public int need_vcode;
    public int pollLevel;
    public String poll_message;
    public String tbs;
    public String teenModeInterval;
    public String user_id;
    public String user_name;
    public String vcode_md5;
    public String vcode_pic_url;
    public int vcode_stat;
    public String video_message;
    public String voice_message;
    public boolean has_chance = true;
    public int days_tofree = 0;
    public int ifvoice = 1;
    public int ifaddition = 0;
    public int replyPrivateFlag = 1;
    public boolean canGoods = false;

    public String getBlock_forum_id() {
        return this.block_forum_id;
    }

    public String getBlock_forum_name() {
        return this.block_forum_name;
    }

    public int getBlock_stat() {
        return this.block_stat;
    }

    public boolean getCanGoods() {
        return this.canGoods;
    }

    public int getDays_tofree() {
        return this.days_tofree;
    }

    public List<DeleteThreadInfo> getDelThreadInfoList() {
        return this.delThreadInfoList;
    }

    public int getForbid_flag() {
        return this.forbid_flag;
    }

    public String getForbid_info() {
        return this.forbid_info;
    }

    public int getHide_stat() {
        return this.hide_stat;
    }

    public int getIfpost() {
        return this.ifpost;
    }

    public int getIfposta() {
        return this.ifposta;
    }

    public int getNeed_vcode() {
        return this.need_vcode;
    }

    public int getPollLevel() {
        return this.pollLevel;
    }

    public String getPollMessage() {
        return this.poll_message;
    }

    public String getTbs() {
        return this.tbs;
    }

    public String getTeenModeInterval() {
        return this.teenModeInterval;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getVcode_md5() {
        return this.vcode_md5;
    }

    public String getVcode_pic_url() {
        return this.vcode_pic_url;
    }

    public int getVcode_stat() {
        return this.vcode_stat;
    }

    public String getVideo_message() {
        return this.video_message;
    }

    public String getVoice_message() {
        return this.voice_message;
    }

    public boolean isHas_chance() {
        return this.has_chance;
    }

    public boolean isIfAddition() {
        return this.ifaddition == 1;
    }

    public boolean isIfvoice() {
        return this.ifvoice == 1;
    }

    public boolean isSexyForum() {
        return this.isSexyForum;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtobuf(Anti anti) {
        String str;
        if (anti == null) {
            return;
        }
        this.ifpost = anti.ifpost.intValue();
        this.ifposta = anti.ifposta.intValue();
        this.forbid_flag = anti.forbid_flag.intValue();
        this.tbs = anti.tbs;
        if (TbadkCoreApplication.getInst() != null && (str = this.tbs) != null && str.length() > 0) {
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
        for (int i2 = 0; i2 < anti.del_thread_text.size(); i2++) {
            DeleteThreadInfo deleteThreadInfo = new DeleteThreadInfo();
            deleteThreadInfo.text_id = anti.del_thread_text.get(i2).text_id.intValue();
            deleteThreadInfo.text_info = anti.del_thread_text.get(i2).text_info;
            this.delThreadInfoList.add(deleteThreadInfo);
        }
        this.poll_message = anti.poll_message;
        this.video_message = anti.video_message;
        if (anti.block_pop_info != null) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.mFrsForbidenDialogInfo = blockPopInfoData;
            BlockPopInfo blockPopInfo = anti.block_pop_info;
            blockPopInfoData.ahead_info = blockPopInfo.ahead_info;
            blockPopInfoData.ahead_url = blockPopInfo.ahead_url;
            blockPopInfoData.ok_info = blockPopInfo.ok_info;
            blockPopInfoData.can_post = blockPopInfo.can_post;
            blockPopInfoData.block_info = blockPopInfo.block_info;
            blockPopInfoData.sub_block_info = blockPopInfo.sub_block_info;
            blockPopInfoData.ahead_type = blockPopInfo.ahead_type;
        }
        this.replyPrivateFlag = anti.reply_private_flag.intValue();
        this.pollLevel = anti.poll_level.intValue();
        this.isSexyForum = anti.is_sexyforum.booleanValue();
        this.teenModeInterval = anti.teenmode_interval;
        this.canGoods = anti.can_goods.intValue() == 1;
    }

    public void setBlock_forum_id(String str) {
        this.block_forum_id = str;
    }

    public void setBlock_forum_name(String str) {
        this.block_forum_name = str;
    }

    public void setForbid_flag(int i2) {
        this.forbid_flag = i2;
    }

    public void setForbid_info(String str) {
        this.forbid_info = str;
    }

    public void setIfVoice(boolean z) {
        this.ifvoice = z ? 1 : 0;
    }

    public void setIfpost(int i2) {
        this.ifpost = i2;
    }

    public void setIfposta(int i2) {
        this.ifposta = i2;
    }

    public void setNeed_vcode(int i2) {
        this.need_vcode = i2;
    }

    public void setPollLevel(int i2) {
        this.pollLevel = i2;
    }

    public void setTbs(String str) {
        this.tbs = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public void setVcode_md5(String str) {
        this.vcode_md5 = str;
    }

    public void setVcode_pic_url(String str) {
        this.vcode_pic_url = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ifpost", this.ifpost);
            jSONObject.put("ifposta", this.ifposta);
            jSONObject.put("forbid_flag", this.forbid_flag);
            jSONObject.put(HttpRequest.TBS, this.tbs);
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
                jSONObject2.put("sub_block_info", this.mFrsForbidenDialogInfo.sub_block_info);
                jSONObject2.put("ahead_type", this.mFrsForbidenDialogInfo.ahead_type);
                jSONObject.put("block_pop_info", jSONObject2);
            }
            jSONObject.put("reply_private_flag", this.replyPrivateFlag);
            jSONObject.put("poll_level", this.pollLevel);
            jSONObject.put("is_sexyforum", this.isSexyForum);
            jSONObject.put("teenmode_interval", this.teenModeInterval);
            return jSONObject.toString();
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.ifpost = jSONObject.optInt("ifpost", 0);
            this.ifposta = jSONObject.optInt("ifposta", 0);
            this.forbid_flag = jSONObject.optInt("forbid_flag", 0);
            this.tbs = jSONObject.optString(HttpRequest.TBS);
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
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                this.mFrsForbidenDialogInfo = blockPopInfoData;
                blockPopInfoData.ahead_info = optJSONObject.optString("ahead_info");
                this.mFrsForbidenDialogInfo.ahead_url = optJSONObject.optString("ahead_url");
                this.mFrsForbidenDialogInfo.ok_info = optJSONObject.optString("ok_info");
                this.mFrsForbidenDialogInfo.can_post = Integer.valueOf(optJSONObject.optInt("can_post"));
                this.mFrsForbidenDialogInfo.block_info = optJSONObject.optString("block_info");
                this.mFrsForbidenDialogInfo.sub_block_info = optJSONObject.optString("sub_block_info");
                this.mFrsForbidenDialogInfo.ahead_type = Integer.valueOf(optJSONObject.optInt("ahead_type"));
            }
            this.replyPrivateFlag = jSONObject.optInt("reply_private_flag", 1);
            this.pollLevel = jSONObject.optInt("poll_level", 0);
            this.isSexyForum = jSONObject.optBoolean("is_sexyforum", false);
            this.teenModeInterval = jSONObject.optString("teenmode_interval", "");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
