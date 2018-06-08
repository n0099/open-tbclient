package com.baidu.ar.bean;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.FileUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ARResource {
    public static final int DOWNLOAD_STATUS_DOWNLOADED = -2;
    public static final int DOWNLOAD_STATUS_FAILED = -3;
    public static final int DOWNLOAD_STATUS_NONE = -1;
    public static final int DOWNLOAD_STATUS_WAIT = -4;
    private String b;
    private String c;
    private String d;
    private String[] e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String o;
    private boolean p;
    private String q;
    private String r;
    private List<ARResource> s;
    private String t;
    private ValueAnimator v;
    private Map<FunctionType, Boolean> w;
    private int a = Integer.MIN_VALUE;
    private boolean m = false;
    private boolean n = true;
    private int u = -1;

    public static boolean isDownloading(int i) {
        return i >= 0 && i <= 100;
    }

    public void createAnimator() {
        this.v = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.v.setDuration(200L);
        this.v.setInterpolator(new LinearInterpolator());
        this.v.addListener(new Animator.AnimatorListener() { // from class: com.baidu.ar.bean.ARResource.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ARResource.this.v = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ARResource.this.v = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.v.start();
    }

    public String getAcId() {
        return this.o;
    }

    public ValueAnimator getAnimator() {
        return this.v;
    }

    public String getCaseConfigJsonInfo() {
        return this.t;
    }

    public String getCodeDownloadUrl() {
        return this.q;
    }

    public int getDownloadStatus() {
        if (this.u == -2 && !FileUtils.existsFile(this.j)) {
            this.u = -1;
        }
        return this.u;
    }

    public int getErrCode() {
        return this.a;
    }

    public String getErrMsg() {
        return this.b;
    }

    public Map<FunctionType, Boolean> getFunctionMap() {
        return this.w;
    }

    public String getKey() {
        return this.c;
    }

    public String[] getMultiResourceUrl() {
        return this.e;
    }

    public String getRedirectUrl() {
        return this.f;
    }

    public List<ARResource> getRelativeList() {
        return this.s;
    }

    public String getResFilePath() {
        return this.k;
    }

    public String getResourceUrl() {
        return this.d;
    }

    public int getSize() {
        return this.l;
    }

    public String getThumbnailUrl() {
        return this.r;
    }

    public int getType() {
        return this.h;
    }

    public String getVersionCode() {
        return this.g;
    }

    public String getZipFilePath() {
        return this.j;
    }

    public String getZipMD5() {
        return this.i;
    }

    public boolean isHardwareSatisfied() {
        return this.n;
    }

    public boolean isRefused() {
        return this.m;
    }

    public boolean isShowAudioDialog() {
        return this.p;
    }

    public void setAcId(String str) {
        this.o = str;
    }

    public void setCaseConfigJsonInfo(String str) {
        this.t = str;
    }

    public void setCodeDownloadUrl(String str) {
        this.q = str;
    }

    public void setDownloadStatus(int i) {
        this.u = i;
    }

    public void setErrCode(int i) {
        this.a = i;
    }

    public void setErrMsg(String str) {
        this.b = str;
    }

    public void setFunctionMap(Map<FunctionType, Boolean> map) {
        this.w = map;
        if (Constants.DEBUG) {
            for (FunctionType functionType : map.keySet()) {
                ARLog.e("bdar: function = " + functionType.getValue() + ", value = " + map.get(functionType));
            }
        }
    }

    public void setHardwareSatisfied(boolean z) {
        this.n = z;
    }

    public void setKey(String str) {
        this.c = str;
    }

    public void setMultiResourceUrl(String[] strArr) {
        this.e = strArr;
    }

    public void setRedirectUrl(String str) {
        this.f = str;
    }

    public void setRefused(boolean z) {
        this.m = z;
    }

    public void setRelativeList(List<ARResource> list) {
        this.s = list;
    }

    public void setResFilePath(String str) {
        this.k = str;
    }

    public void setResourceUrl(String str) {
        this.d = str;
    }

    public void setShowAudioDialog(boolean z) {
        this.p = z;
    }

    public void setSize(int i) {
        this.l = i;
    }

    public void setThumbnailUrl(String str) {
        this.r = str;
    }

    public void setType(int i) {
        this.h = i;
    }

    public void setVersionCode(String str) {
        this.g = str;
    }

    public void setZipFilePath(String str) {
        this.j = str;
    }

    public void setZipMD5(String str) {
        this.i = str;
    }
}
