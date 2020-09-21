package com.baidu.searchbox.ugc.upload;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.services.vod.model.ProcessMediaRequest;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class PriorityProcessMediaRequest extends ProcessMediaRequest {
    private int priority = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.vod.model.ProcessMediaRequest
    public PriorityProcessMediaRequest withMediaId(String str) {
        super.setMediaId(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.vod.model.ProcessMediaRequest
    public PriorityProcessMediaRequest withTitle(String str) {
        super.setTitle(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.vod.model.ProcessMediaRequest
    public PriorityProcessMediaRequest withTranscodingPresetGroupName(String str) {
        super.setTranscodingPresetGroupName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.vod.model.ProcessMediaRequest
    public PriorityProcessMediaRequest withDescription(String str) {
        super.setDescription(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.vod.model.ProcessMediaRequest
    public PriorityProcessMediaRequest withSourceExtension(String str) {
        super.setSourceExtension(str);
        return this;
    }

    @Override // com.baidubce.services.vod.model.ProcessMediaRequest, com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public PriorityProcessMediaRequest withPriority(int i) {
        this.priority = i;
        return this;
    }

    @Override // com.baidubce.services.vod.model.ProcessMediaRequest, com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        JSONObject jSONObject;
        Exception e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(super.toJsonString());
        } catch (Exception e2) {
            jSONObject = jSONObject2;
            e = e2;
        }
        try {
            jSONObject.put("priority", this.priority);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }
}
