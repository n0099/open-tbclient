package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class PublishRequestModel {
    public JSONObject data;
    public JSONObject extObject;
    public List<PublishModels.ImageData> imageUrlList;
    public String inputStr;
    public JSONObject locationObject;
    public String postUrl;
    public String publishType;
    public JSONObject questionAsk;
    public JSONObject questionReply;
    public int serverTopicsRule;
    public String sourceFrom;
    public String sourceKey;
    public int sourceType;
    public int sourceid;
    public JSONObject swanObject;
    public String title;
    public JSONObject topic;
    public HttpRequestPublishModule.VideoUploadModel videoInfo;
}
