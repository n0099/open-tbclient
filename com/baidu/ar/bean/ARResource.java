package com.baidu.ar.bean;

import com.baidu.ar.util.Constants;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes3.dex */
public class ARResource implements Serializable {
    private static final long serialVersionUID = -5654044082929692592L;
    private String mARKey;
    private int mARType;
    private String mAcId;
    private String mCodeDownloadUrl;
    private String mErrMsg;
    private Map<FunctionType, Boolean> mFunctionMap;
    private String[] mMultiResourceUrl;
    private String mRedirectUrl;
    private String mResFilePath;
    private String mResourceUrl;
    private boolean mShowAudioDialog;
    private int mSize;
    private String mVersionCode;
    private String mZipFilePath;
    private String mZipMd5;
    private int mErrCode = Integer.MIN_VALUE;
    private boolean mRefused = false;
    private boolean mHardwareSatisfied = true;

    public int a() {
        return this.mErrCode;
    }

    public void a(int i) {
        this.mErrCode = i;
    }

    public void a(String str) {
        this.mErrMsg = str;
    }

    public void a(Map<FunctionType, Boolean> map) {
        this.mFunctionMap = map;
        if (Constants.DEBUG) {
            for (FunctionType functionType : map.keySet()) {
                com.baidu.ar.util.b.d("bdar: function = " + functionType.a() + ", value = " + map.get(functionType));
            }
        }
    }

    public void a(boolean z) {
        this.mRefused = z;
    }

    public void a(String[] strArr) {
        this.mMultiResourceUrl = strArr;
    }

    public String b() {
        return this.mErrMsg;
    }

    public void b(int i) {
        this.mARType = i;
    }

    public void b(String str) {
        this.mARKey = str;
    }

    public void b(boolean z) {
        this.mHardwareSatisfied = z;
    }

    public void c(String str) {
        this.mResourceUrl = str;
    }

    public void c(boolean z) {
        this.mShowAudioDialog = z;
    }

    public String[] c() {
        return this.mMultiResourceUrl;
    }

    public String d() {
        return this.mRedirectUrl;
    }

    public void d(String str) {
        this.mRedirectUrl = str;
    }

    public int e() {
        return this.mARType;
    }

    public void e(String str) {
        this.mVersionCode = str;
    }

    public void f(String str) {
        this.mZipMd5 = str;
    }

    public boolean f() {
        return this.mRefused;
    }

    public void g(String str) {
        this.mAcId = str;
    }

    public boolean g() {
        return this.mHardwareSatisfied;
    }

    public void h(String str) {
        this.mCodeDownloadUrl = str;
    }

    public boolean h() {
        return this.mShowAudioDialog;
    }

    public String i() {
        return this.mCodeDownloadUrl;
    }

    public Map<FunctionType, Boolean> j() {
        return this.mFunctionMap;
    }

    public String toString() {
        return "ARResource [ err_code = " + this.mErrCode + ", " + Constants.HTTP_ERR_MSG + " = " + this.mErrMsg + ", , " + Constants.HTTP_VERSION_CODE + " = " + this.mVersionCode + ", " + Constants.HTTP_AR_RESOURCE + " = " + this.mResourceUrl + " ]";
    }
}
