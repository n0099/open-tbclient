package com.baidu.searchbox.unitedscheme;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UnitedSchemeEntity implements Cloneable {
    public static final String UNITED_SCHEME = SchemeConfig.getSchemeHead() + "://";
    public boolean callbackInvoked;
    private boolean mOnlyVerify;
    public String mPageUrl;
    private HashMap<String, String> mParams;
    private int mPathLevel;
    private String[] mPaths;
    private String mReferUrl;
    private String mSource;
    private Uri mUri;
    UnitedSchemeEntity originEntity;
    public JSONObject result;

    public UnitedSchemeEntity(Uri uri) {
        this(uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public UnitedSchemeEntity(Uri uri, String str) {
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mPathLevel = -1;
        this.mOnlyVerify = false;
        this.callbackInvoked = false;
        this.mSource = str;
        this.mUri = uri;
        this.mPaths = UnitedSchemeUtility.getPaths(this.mUri);
        this.mParams = UnitedSchemeUtility.getParams(uri.toString());
    }

    public UnitedSchemeEntity(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mPathLevel = -1;
        this.mOnlyVerify = false;
        this.callbackInvoked = false;
        this.mUri = uri;
        this.mSource = str;
        this.mPaths = strArr;
        this.mParams = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public UnitedSchemeEntity m16clone() {
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(this.mUri, this.mSource, UnitedSchemeUtility.getPaths(this.mUri), (HashMap) this.mParams.clone());
        unitedSchemeEntity.originEntity = this;
        unitedSchemeEntity.callbackInvoked = this.callbackInvoked;
        unitedSchemeEntity.mReferUrl = this.mReferUrl;
        return unitedSchemeEntity;
    }

    public void markCallbackInvoked() {
        this.callbackInvoked = true;
        for (UnitedSchemeEntity unitedSchemeEntity = this.originEntity; unitedSchemeEntity != null; unitedSchemeEntity = unitedSchemeEntity.originEntity) {
            unitedSchemeEntity.callbackInvoked = true;
        }
    }

    public boolean isCallbackInvoked() {
        return this.callbackInvoked;
    }

    public void setOnlyVerify(boolean z) {
        this.mOnlyVerify = z;
    }

    public boolean isOnlyVerify() {
        return this.mOnlyVerify;
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getPath(boolean z) {
        if (this.mPaths != null) {
            if (z) {
                this.mPathLevel++;
            }
            if (this.mPathLevel < this.mPaths.length) {
                return this.mPaths[this.mPathLevel];
            }
        }
        return null;
    }

    public boolean isAction() {
        return this.mPathLevel == this.mPaths.length + (-1);
    }

    public String removeParam(String str) {
        if (str == null || this.mParams == null) {
            return null;
        }
        return this.mParams.remove(str);
    }

    public String getParam(String str) {
        if (str == null || this.mParams == null) {
            return null;
        }
        return this.mParams.get(str);
    }

    public HashMap<String, String> getParams() {
        return this.mParams;
    }

    public String getFirstPath() {
        if (this.mPaths == null || this.mPaths.length <= 0) {
            return null;
        }
        return this.mPaths[0];
    }

    public void setReferUrl(String str) {
        this.mReferUrl = str;
    }

    public String getReferUrl() {
        return this.mReferUrl;
    }

    public void setPageUrl(String str) {
        this.mPageUrl = str;
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    public void putParams(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new HashMap<>();
        }
        this.mParams.put(str, str2);
    }
}
