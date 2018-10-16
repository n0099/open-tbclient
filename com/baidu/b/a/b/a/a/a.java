package com.baidu.b.a.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.b.a.c.b.b;
import com.baidu.b.a.f.d.e;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a implements com.baidu.b.a.b.a.a<com.baidu.b.a.c.a.a> {
    protected String mChannelId;
    protected String mChannelName;
    protected List<com.baidu.b.a.c.a.a> mDownloadFiles;
    protected String mPackageName;

    protected abstract Context getContext();

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelId should not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelName should not be null");
        }
        this.mChannelId = str;
        this.mChannelName = str2;
        this.mPackageName = str3;
        this.mDownloadFiles = new ArrayList();
    }

    @Override // com.baidu.b.a.b.a.a
    public String getChannelName() {
        return this.mChannelName;
    }

    @Override // com.baidu.b.a.b.a.a
    public String getChannelId() {
        return this.mChannelId;
    }

    @Override // com.baidu.b.a.b.a.a
    public String getPackageName() {
        return this.mPackageName;
    }

    public List<com.baidu.b.a.c.a.a> getUploadItems() {
        ArrayList arrayList = new ArrayList();
        Map<String, com.baidu.b.a.c.a.a> ab = b.ab(this.mChannelId, null);
        if (ab != null && ab.size() > 0) {
            for (Map.Entry<String, com.baidu.b.a.c.a.a> entry : ab.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(entry.getValue());
                }
            }
        }
        return arrayList;
    }

    public List<com.baidu.b.a.c.a.a> getUploadItems(String str) {
        com.baidu.b.a.c.a.a aVar;
        ArrayList arrayList = new ArrayList();
        Map<String, com.baidu.b.a.c.a.a> ab = b.ab(this.mChannelId, str);
        if (ab != null && ab.size() > 0 && (aVar = ab.get(str)) != null) {
            arrayList.add(aVar);
        }
        if (arrayList.size() == 0) {
            com.baidu.b.a.c.a.a aVar2 = new com.baidu.b.a.c.a.a();
            aVar2.packageName = str;
            aVar2.Zo = -1L;
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    @Override // com.baidu.b.a.b.a.a
    public JSONArray getUploadParam() {
        JSONArray jSONArray = new JSONArray();
        try {
            List<com.baidu.b.a.c.a.a> uploadItems = TextUtils.isEmpty(this.mPackageName) ? getUploadItems() : getUploadItems(this.mPackageName);
            if (uploadItems != null) {
                for (com.baidu.b.a.c.a.a aVar : uploadItems) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ETAG.KEY_PACKAGE_NAME, aVar.packageName);
                    jSONObject.put("update_v", aVar.Zo + "");
                    jSONArray.put(jSONObject);
                }
            }
        } catch (JSONException e) {
            Log.e("lib-dynamic", "DefaultDynamicCallback|getUploadParam|exception=" + e.toString());
        }
        return jSONArray;
    }

    @Override // com.baidu.b.a.b.a.a
    public void onReceiveItems(JSONArray jSONArray, JSONArray jSONArray2) {
        List<com.baidu.b.a.c.a.a> parseItems = parseItems(jSONArray);
        if (parseItems != null) {
            for (com.baidu.b.a.c.a.a aVar : parseItems) {
                aVar.channelId = this.mChannelId;
                aVar.channelName = this.mChannelName;
            }
            Map<String, com.baidu.b.a.c.a.a> ab = b.ab(this.mChannelId, null);
            for (com.baidu.b.a.c.a.a aVar2 : parseItems) {
                if (!ab.containsKey(aVar2.packageName)) {
                    this.mDownloadFiles.add(aVar2);
                    e.h(aVar2);
                    onNewItemAdded(aVar2);
                } else {
                    com.baidu.b.a.c.a.a aVar3 = ab.get(aVar2.packageName);
                    if (aVar3.a(aVar2)) {
                        this.mDownloadFiles.add(aVar2);
                        e.h(aVar2);
                        onUpdate(aVar2);
                    } else {
                        aVar2.b(aVar3);
                        e.i(aVar3);
                        onConfigurationChanged(aVar2);
                    }
                }
            }
            for (com.baidu.b.a.c.a.a aVar4 : parseFilteredItems(jSONArray2)) {
                onItemFiltered(aVar4);
            }
        }
    }

    public List<com.baidu.b.a.c.a.a> parseItems(JSONArray jSONArray) {
        return com.baidu.b.a.c.c.b.f(jSONArray);
    }

    public List<com.baidu.b.a.c.a.a> parseFilteredItems(JSONArray jSONArray) {
        return com.baidu.b.a.c.c.b.g(jSONArray);
    }

    @Override // com.baidu.b.a.b.a.a
    public List<com.baidu.b.a.c.a.a> getDownloadItems() {
        return this.mDownloadFiles;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, Integer> getOptions() {
        HashMap hashMap = new HashMap();
        hashMap.put("download_ret_type", 0);
        return hashMap;
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileProgress(String str, long j, long j2) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFilePause(com.baidu.b.a.b.b.a aVar) {
    }

    public void onFileResume(com.baidu.b.a.b.b.a aVar, long j, long j2) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileCancel(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list, List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3) {
        Log.d("dynamic", "DefaultDynamicCallback|onBulkDownloaded|success=" + list.size() + ",error:" + list2.size() + ",cancel:" + list3.size() + ",mChannelId:" + this.mChannelId + ",mPackageName:" + this.mPackageName);
    }
}
