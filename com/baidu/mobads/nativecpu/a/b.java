package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements IBasicCPUData {

    /* renamed from: a  reason: collision with root package name */
    public Object f3407a;

    /* renamed from: b  reason: collision with root package name */
    public c f3408b;
    private NativeCPUManager c;

    public b(Context context, Object obj, NativeCPUManager nativeCPUManager) {
        this.f3407a = obj;
        this.c = nativeCPUManager;
        this.f3408b = c.a(context, "com.baidu.mobads.container.nativecpu.interfaces.ICPUAdInstance");
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getType() {
        return (String) this.f3408b.b(this.f3407a, "getType", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAuthor() {
        return (String) this.f3408b.b(this.f3407a, "getAuthor", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getIconUrl() {
        return (String) this.f3408b.b(this.f3407a, "getAvatar", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getUpdateTime() {
        return (String) this.f3408b.b(this.f3407a, "getUpdateTime", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getTitle() {
        return (String) this.f3408b.b(this.f3407a, "getTitle", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getDesc() {
        return (String) this.f3408b.b(this.f3407a, "getContent", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isTop() {
        return ((Boolean) this.f3408b.b(this.f3407a, "isTop", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelId() {
        return (String) this.f3408b.b(this.f3407a, "getCatId", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelName() {
        return (String) this.f3408b.b(this.f3407a, "getCatName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getCommentCounts() {
        return ((Integer) this.f3408b.b(this.f3407a, "getCommentCounts", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getStyleType() {
        return ((Integer) this.f3408b.b(this.f3407a, "getStyleType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b2 = this.f3408b.b(this.f3407a, "getSmallImageList", new Object[0]);
        if (b2 instanceof List) {
            return (List) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getImageUrls() {
        Object b2 = this.f3408b.b(this.f3407a, "getImageList", new Object[0]);
        if (b2 instanceof List) {
            return (List) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.f3408b.b(this.f3407a, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdWidth() {
        return ((Integer) this.f3408b.b(this.f3407a, "getAdWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdHeight() {
        return ((Integer) this.f3408b.b(this.f3407a, "getAdHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAdLogoUrl() {
        return (String) this.f3408b.b(this.f3407a, "getAdLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBaiduLogoUrl() {
        return (String) this.f3408b.b(this.f3407a, "getBaiduLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getThumbUrl() {
        return (String) this.f3408b.b(this.f3407a, "getThumbUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbWidth() {
        return ((Integer) this.f3408b.b(this.f3407a, "getThumbWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbHeight() {
        return ((Integer) this.f3408b.b(this.f3407a, "getThumbHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPlayCounts() {
        Object b2 = this.f3408b.b(this.f3407a, "getPlayCounts", new Object[0]);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getVUrl() {
        return (String) this.f3408b.b(this.f3407a, "getVUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDuration() {
        return ((Integer) this.f3408b.b(this.f3407a, "getDuration", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPresentationType() {
        return ((Integer) this.f3408b.b(this.f3407a, "getPresentationType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.f3408b.b(this.f3407a, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getActionType() {
        return ((Integer) this.f3408b.b(this.f3407a, "getActionType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPackageName() {
        return (String) this.f3408b.b(this.f3407a, "getPackageName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBrandName() {
        Object b2 = this.f3408b.b(this.f3407a, "getBrandName", new Object[0]);
        if (b2 instanceof String) {
            return (String) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getContentClickUrl() {
        Object b2 = this.f3408b.b(this.f3407a, "getContentClickUrl", new Object[0]);
        if (b2 instanceof String) {
            return (String) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDownloadStatus() {
        return ((Integer) this.f3408b.b(this.f3407a, "getDownloadStatus", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isDownloadApp() {
        return ((Boolean) this.f3408b.b(this.f3407a, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void onImpression(View view) {
        this.f3408b.a(this.f3407a, "onImpression", view);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void handleClick(View view) {
        if (this.c != null && this.c.getLpStyleParams() != null) {
            this.f3408b.a(this.f3407a, "setLpStyleParams", this.c.getLpStyleParams());
        }
        this.f3408b.a(this.f3407a, "handleClick", view);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.f3408b.a(this.f3407a, "markDislike", strArr);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPublisher() {
        return this.f3408b.c(this.f3407a, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppVersion() {
        return this.f3408b.c(this.f3407a, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.f3408b.c(this.f3407a, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.f3408b.c(this.f3407a, "getAppPermissionUrl", new Object[0]);
    }
}
