package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import java.io.Serializable;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class UploadVideoModel implements IBeanResponse, Serializable {
    public String callbackkey;
    public String need_confirm;
    public String video;

    /* loaded from: classes7.dex */
    public static class ConfirmBean implements NoProguard, Serializable {
        public String cancel_msg;
        public String confirm_msg;
        public String tip_msg;
        public int tips_sec;
        public String title_tips;
    }

    public ConfirmBean getConfirmBean() {
        try {
            return (ConfirmBean) JsonUtils.fromJson(this.need_confirm, ConfirmBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
