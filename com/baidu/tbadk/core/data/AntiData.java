package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.BlockPopInfo;
/* loaded from: classes9.dex */
public class AntiData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2355009973517935888L;
    public transient /* synthetic */ FieldHolder $fh;
    public String block_forum_id;
    public String block_forum_name;
    public int block_stat;
    public boolean canGoods;
    public int days_tofree;
    public List<DeleteThreadInfo> delThreadInfoList;
    public int forbid_flag;
    public String forbid_info;
    public boolean has_chance;
    public int hide_stat;
    public int ifaddition;
    public int ifpost;
    public int ifposta;
    public int ifvoice;
    public boolean isSexyForum;
    public BlockPopInfoData mFrsForbidenDialogInfo;
    public int need_vcode;
    public int pollLevel;
    public String poll_message;
    public int replyPrivateFlag;
    public String tbs;
    public String teenModeInterval;
    public String user_id;
    public String user_name;
    public String vcode_md5;
    public String vcode_pic_url;
    public int vcode_stat;
    public String video_message;
    public String voice_message;

    public AntiData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.has_chance = true;
        this.days_tofree = 0;
        this.ifvoice = 1;
        this.ifaddition = 0;
        this.replyPrivateFlag = 1;
        this.canGoods = false;
    }

    public String getBlock_forum_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.block_forum_id : (String) invokeV.objValue;
    }

    public String getBlock_forum_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.block_forum_name : (String) invokeV.objValue;
    }

    public int getBlock_stat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.block_stat : invokeV.intValue;
    }

    public boolean getCanGoods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.canGoods : invokeV.booleanValue;
    }

    public int getDays_tofree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.days_tofree : invokeV.intValue;
    }

    public List<DeleteThreadInfo> getDelThreadInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delThreadInfoList : (List) invokeV.objValue;
    }

    public int getForbid_flag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.forbid_flag : invokeV.intValue;
    }

    public String getForbid_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.forbid_info : (String) invokeV.objValue;
    }

    public int getHide_stat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.hide_stat : invokeV.intValue;
    }

    public int getIfpost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.ifpost : invokeV.intValue;
    }

    public int getIfposta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.ifposta : invokeV.intValue;
    }

    public int getNeed_vcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.need_vcode : invokeV.intValue;
    }

    public int getPollLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.pollLevel : invokeV.intValue;
    }

    public String getPollMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.poll_message : (String) invokeV.objValue;
    }

    public String getTbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.tbs : (String) invokeV.objValue;
    }

    public String getTeenModeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.teenModeInterval : (String) invokeV.objValue;
    }

    public String getUser_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.user_id : (String) invokeV.objValue;
    }

    public String getUser_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.user_name : (String) invokeV.objValue;
    }

    public String getVcode_md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.vcode_md5 : (String) invokeV.objValue;
    }

    public String getVcode_pic_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.vcode_pic_url : (String) invokeV.objValue;
    }

    public int getVcode_stat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.vcode_stat : invokeV.intValue;
    }

    public String getVideo_message() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.video_message : (String) invokeV.objValue;
    }

    public String getVoice_message() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.voice_message : (String) invokeV.objValue;
    }

    public boolean isHas_chance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.has_chance : invokeV.booleanValue;
    }

    public boolean isIfAddition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.ifaddition == 1 : invokeV.booleanValue;
    }

    public boolean isIfvoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.ifvoice == 1 : invokeV.booleanValue;
    }

    public boolean isSexyForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.isSexyForum : invokeV.booleanValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void parserProtobuf(Anti anti) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, anti) == null) || anti == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.block_forum_id = str;
        }
    }

    public void setBlock_forum_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.block_forum_name = str;
        }
    }

    public void setForbid_flag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.forbid_flag = i2;
        }
    }

    public void setForbid_info(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.forbid_info = str;
        }
    }

    public void setIfVoice(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.ifvoice = z ? 1 : 0;
        }
    }

    public void setIfpost(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.ifpost = i2;
        }
    }

    public void setIfposta(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.ifposta = i2;
        }
    }

    public void setNeed_vcode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.need_vcode = i2;
        }
    }

    public void setPollLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.pollLevel = i2;
        }
    }

    public void setTbs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.tbs = str;
        }
    }

    public void setUser_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.user_id = str;
        }
    }

    public void setUser_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.user_name = str;
        }
    }

    public void setVcode_md5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.vcode_md5 = str;
        }
    }

    public void setVcode_pic_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.vcode_pic_url = str;
        }
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, jSONObject) == null) || jSONObject == null) {
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
