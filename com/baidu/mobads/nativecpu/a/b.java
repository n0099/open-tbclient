package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements IBasicCPUData {

    /* renamed from: a  reason: collision with root package name */
    public Object f8383a;

    /* renamed from: b  reason: collision with root package name */
    public c f8384b;

    /* renamed from: c  reason: collision with root package name */
    public NativeCPUManager f8385c;

    public b(Context context, Object obj, NativeCPUManager nativeCPUManager) {
        this.f8383a = obj;
        this.f8385c = nativeCPUManager;
        this.f8384b = c.a(context, "com.baidu.mobads.container.nativecpu.interfaces.ICPUAdInstance");
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getActionType() {
        return ((Integer) this.f8384b.b(this.f8383a, "getActionType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdHeight() {
        return ((Integer) this.f8384b.b(this.f8383a, "getAdHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAdLogoUrl() {
        return (String) this.f8384b.b(this.f8383a, "getAdLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getAdWidth() {
        return ((Integer) this.f8384b.b(this.f8383a, "getAdWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPackageName() {
        return (String) this.f8384b.b(this.f8383a, "getPackageName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPermissionUrl() {
        return this.f8384b.c(this.f8383a, "getAppPermissionUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPrivacyUrl() {
        return this.f8384b.c(this.f8383a, "getAppPrivacyUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppPublisher() {
        return this.f8384b.c(this.f8383a, "getAppPublisher", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAppVersion() {
        return this.f8384b.c(this.f8383a, "getAppVersion", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getAuthor() {
        return (String) this.f8384b.b(this.f8383a, "getAuthor", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBaiduLogoUrl() {
        return (String) this.f8384b.b(this.f8383a, "getBaiduLogoUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getBrandName() {
        Object b2 = this.f8384b.b(this.f8383a, "getBrandName", new Object[0]);
        if (b2 instanceof String) {
            return (String) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelId() {
        return (String) this.f8384b.b(this.f8383a, "getCatId", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getChannelName() {
        return (String) this.f8384b.b(this.f8383a, "getCatName", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getCommentCounts() {
        return ((Integer) this.f8384b.b(this.f8383a, "getCommentCounts", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getContentClickUrl() {
        Object b2 = this.f8384b.b(this.f8383a, "getContentClickUrl", new Object[0]);
        if (b2 instanceof String) {
            return (String) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getDesc() {
        return (String) this.f8384b.b(this.f8383a, "getContent", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONArray getDislikeReasons() {
        return (JSONArray) this.f8384b.b(this.f8383a, "getDislikeReasons", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDownloadStatus() {
        return ((Integer) this.f8384b.b(this.f8383a, "getDownloadStatus", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getDuration() {
        return ((Integer) this.f8384b.b(this.f8383a, "getDuration", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public JSONObject getExtra() {
        return (JSONObject) this.f8384b.b(this.f8383a, "getExtra", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getIconUrl() {
        return (String) this.f8384b.b(this.f8383a, "getAvatar", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getImageUrls() {
        Object b2 = this.f8384b.b(this.f8383a, "getImageList", new Object[0]);
        if (b2 instanceof List) {
            return (List) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPlayCounts() {
        Object b2 = this.f8384b.b(this.f8383a, "getPlayCounts", new Object[0]);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return 0;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getPresentationType() {
        return ((Integer) this.f8384b.b(this.f8383a, "getPresentationType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public List<String> getSmallImageUrls() {
        Object b2 = this.f8384b.b(this.f8383a, "getSmallImageList", new Object[0]);
        if (b2 instanceof List) {
            return (List) b2;
        }
        return null;
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getStyleType() {
        return ((Integer) this.f8384b.b(this.f8383a, "getStyleType", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbHeight() {
        return ((Integer) this.f8384b.b(this.f8383a, "getThumbHeight", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getThumbUrl() {
        return (String) this.f8384b.b(this.f8383a, "getThumbUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public int getThumbWidth() {
        return ((Integer) this.f8384b.b(this.f8383a, "getThumbWidth", new Object[0])).intValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getTitle() {
        return (String) this.f8384b.b(this.f8383a, "getTitle", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getType() {
        return (String) this.f8384b.b(this.f8383a, "getType", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getUpdateTime() {
        return (String) this.f8384b.b(this.f8383a, "getUpdateTime", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public String getVUrl() {
        return (String) this.f8384b.b(this.f8383a, "getVUrl", new Object[0]);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void handleClick(View view) {
        NativeCPUManager nativeCPUManager = this.f8385c;
        if (nativeCPUManager != null && nativeCPUManager.getLpStyleParams() != null) {
            this.f8384b.a(this.f8383a, "setLpStyleParams", this.f8385c.getLpStyleParams());
        }
        this.f8384b.a(this.f8383a, "handleClick", view);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isDownloadApp() {
        return ((Boolean) this.f8384b.b(this.f8383a, "isDownloadApp", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public boolean isTop() {
        return ((Boolean) this.f8384b.b(this.f8383a, "isTop", new Object[0])).booleanValue();
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void markDislike(String[] strArr) {
        this.f8384b.a(this.f8383a, "markDislike", strArr);
    }

    @Override // com.baidu.mobads.nativecpu.IBasicCPUData
    public void onImpression(View view) {
        this.f8384b.a(this.f8383a, "onImpression", view);
    }
}
