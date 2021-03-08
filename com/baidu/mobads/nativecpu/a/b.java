package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements IBasicCPUData {

    /* renamed from: a  reason: collision with root package name */
    public Object f2429a;
    public c b;
    private NativeCPUManager c;

    public b(Context context, Object obj, NativeCPUManager nativeCPUManager) {
        this.f2429a = obj;
        this.c = nativeCPUManager;
        this.b = c.a(context, "com.baidu.mobads.container.nativecpu.interfaces.ICPUAdInstance");
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getType() {
        return (String) this.b.b(this.f2429a, "getType", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAuthor() {
        return (String) this.b.b(this.f2429a, "getAuthor", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getIconUrl() {
        return (String) this.b.b(this.f2429a, "getAvatar", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getUpdateTime() {
        return (String) this.b.b(this.f2429a, "getUpdateTime", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getTitle() {
        return (String) this.b.b(this.f2429a, "getTitle", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getDesc() {
        return (String) this.b.b(this.f2429a, "getContent", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isTop() {
        return ((Boolean) this.b.b(this.f2429a, "isTop", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelId() {
        return (String) this.b.b(this.f2429a, "getCatId", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelName() {
        return (String) this.b.b(this.f2429a, "getCatName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getCommentCounts() {
        return ((Integer) this.b.b(this.f2429a, "getCommentCounts", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getStyleType() {
        return ((Integer) this.b.b(this.f2429a, "getStyleType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b = this.b.b(this.f2429a, "getSmallImageList", new Object[0]);
        if (b instanceof List) {
            return (List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getImageUrls() {
        Object b = this.b.b(this.f2429a, "getImageList", new Object[0]);
        if (b instanceof List) {
            return (List) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.b.b(this.f2429a, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdWidth() {
        return ((Integer) this.b.b(this.f2429a, "getAdWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdHeight() {
        return ((Integer) this.b.b(this.f2429a, "getAdHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAdLogoUrl() {
        return (String) this.b.b(this.f2429a, "getAdLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBaiduLogoUrl() {
        return (String) this.b.b(this.f2429a, "getBaiduLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getThumbUrl() {
        return (String) this.b.b(this.f2429a, "getThumbUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbWidth() {
        return ((Integer) this.b.b(this.f2429a, "getThumbWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbHeight() {
        return ((Integer) this.b.b(this.f2429a, "getThumbHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPlayCounts() {
        Object b = this.b.b(this.f2429a, "getPlayCounts", new Object[0]);
        if (b instanceof Integer) {
            return ((Integer) b).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getVUrl() {
        return (String) this.b.b(this.f2429a, "getVUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDuration() {
        return ((Integer) this.b.b(this.f2429a, "getDuration", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPresentationType() {
        return ((Integer) this.b.b(this.f2429a, "getPresentationType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.b.b(this.f2429a, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getActionType() {
        return ((Integer) this.b.b(this.f2429a, "getActionType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPackageName() {
        return (String) this.b.b(this.f2429a, "getPackageName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBrandName() {
        Object b = this.b.b(this.f2429a, "getBrandName", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getContentClickUrl() {
        Object b = this.b.b(this.f2429a, "getContentClickUrl", new Object[0]);
        if (b instanceof String) {
            return (String) b;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDownloadStatus() {
        return ((Integer) this.b.b(this.f2429a, "getDownloadStatus", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isDownloadApp() {
        return ((Boolean) this.b.b(this.f2429a, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void onImpression(View view) {
        this.b.a(this.f2429a, "onImpression", view);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void handleClick(View view) {
        if (this.c != null && this.c.getLpStyleParams() != null) {
            this.b.a(this.f2429a, "setLpStyleParams", this.c.getLpStyleParams());
        }
        this.b.a(this.f2429a, "handleClick", view);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.b.a(this.f2429a, "markDislike", strArr);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPublisher() {
        return this.b.c(this.f2429a, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppVersion() {
        return this.b.c(this.f2429a, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.b.c(this.f2429a, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.b.c(this.f2429a, "getAppPermissionUrl", new Object[0]);
    }
}
