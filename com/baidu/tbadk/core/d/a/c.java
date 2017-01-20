package com.baidu.tbadk.core.d.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.d.n;
import com.baidu.tbadk.core.d.p;
import com.baidu.tbadk.core.d.q;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class c extends p {
    private n Xj;

    public c(n nVar) {
        super(nVar);
        this.Xj = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String nN() {
        return "TBHY_COMMON_Image";
    }

    @q(tE = false, value = "scanBigImages")
    private void sanBigImages(JSONObject jSONObject) throws JSONException {
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
            sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.Xj.getContext()).createConfig(arrayList, optInt, "", "", "", true, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true)));
        }
    }

    @q("selectPhotos")
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
        writeImagesInfo.setMaxImagesAllowed(10);
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getContext(), writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 5);
        albumActivityConfig.setRequestCode(12015);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }
}
