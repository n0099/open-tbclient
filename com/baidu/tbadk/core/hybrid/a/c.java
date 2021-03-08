package com.baidu.tbadk.core.hybrid.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends n {
    private l eZN;

    public c(l lVar) {
        super(lVar);
        this.eZN = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String bkw() {
        return "TBHY_COMMON_Image";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @o(brC = false, value = "scanBigImages")
    public void sanBigImages(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("imageUrls");
            int optInt = jSONObject.optInt("clickIndex");
            int length = optJSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String string = jSONObject2.getString("bigImageUrl");
                    String string2 = jSONObject2.getString("originImageUrl");
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                        if (!TextUtils.isEmpty(string2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = string;
                            imageUrlData.originalUrl = string2;
                            concurrentHashMap.put(string, imageUrlData);
                        }
                    }
                }
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mR(optInt).jg(true).zT(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true);
            sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eO(this.eZN.getContext())));
        }
    }

    @o("selectPhotos")
    protected void selectPhotos(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("selectPhotos")) != null && optJSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(((JSONObject) optJSONArray.get(i2)).optString("filePath"));
                linkedList.add(imageFileInfo);
                i = i2 + 1;
            }
        }
        writeImagesInfo.setChosedFiles(linkedList);
        writeImagesInfo.setMaxImagesAllowed(9);
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getContext(), writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("camera_request_from", 5);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_WEBVIEW);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }
}
