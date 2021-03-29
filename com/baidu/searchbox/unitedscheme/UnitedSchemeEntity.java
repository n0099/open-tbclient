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
    public boolean mOnlyVerify;
    public String mPageUrl;
    public HashMap<String, String> mParams;
    public int mPathLevel;
    public String[] mPaths;
    public String mReferUrl;
    public String mSource;
    public Uri mUri;
    public UnitedSchemeEntity originEntity;
    public JSONObject result;

    public UnitedSchemeEntity(Uri uri) {
        this(uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public String getAllPath() {
        String path;
        Uri uri = this.mUri;
        if (uri != null) {
            if (UnitedSchemeUtility.hasVersion(uri) && (path = this.mUri.getPath()) != null && path.length() > 1) {
                return this.mUri.getPath().substring(1);
            }
            return this.mUri.getHost() + this.mUri.getPath();
        }
        return "";
    }

    public String getFirstPath() {
        String[] strArr = this.mPaths;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    public String getPageUrl() {
        return this.mPageUrl;
    }

    public String getParam(String str) {
        HashMap<String, String> hashMap;
        if (str == null || (hashMap = this.mParams) == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public HashMap<String, String> getParams() {
        return this.mParams;
    }

    public String getPath(boolean z) {
        if (this.mPaths != null) {
            if (z) {
                this.mPathLevel++;
            }
            int i = this.mPathLevel;
            String[] strArr = this.mPaths;
            if (i < strArr.length) {
                return strArr[i];
            }
            return null;
        }
        return null;
    }

    public String getReferUrl() {
        return this.mReferUrl;
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isAction() {
        return this.mPathLevel == this.mPaths.length - 1;
    }

    public boolean isCallbackInvoked() {
        return this.callbackInvoked;
    }

    public boolean isOnlyVerify() {
        return this.mOnlyVerify;
    }

    public void markCallbackInvoked() {
        this.callbackInvoked = true;
        for (UnitedSchemeEntity unitedSchemeEntity = this.originEntity; unitedSchemeEntity != null; unitedSchemeEntity = unitedSchemeEntity.originEntity) {
            unitedSchemeEntity.callbackInvoked = true;
        }
    }

    public void putParams(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new HashMap<>();
        }
        this.mParams.put(str, str2);
    }

    public String removeParam(String str) {
        HashMap<String, String> hashMap;
        if (str == null || (hashMap = this.mParams) == null) {
            return null;
        }
        return hashMap.remove(str);
    }

    public void replaceAllPath(String str, String str2) {
        Uri uri = this.mUri;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.mUri = parse;
        this.mPaths = UnitedSchemeUtility.getPaths(parse);
    }

    public void resetUriAndPath(Uri uri) {
        this.mUri = uri;
        this.mPaths = UnitedSchemeUtility.getPaths(uri);
    }

    public void setOnlyVerify(boolean z) {
        this.mOnlyVerify = z;
    }

    public void setPageUrl(String str) {
        this.mPageUrl = str;
    }

    public void setReferUrl(String str) {
        this.mReferUrl = str;
    }

    public UnitedSchemeEntity(Uri uri, String str) {
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mPathLevel = -1;
        this.mOnlyVerify = false;
        this.callbackInvoked = false;
        this.mSource = str;
        this.mUri = uri;
        this.mPaths = UnitedSchemeUtility.getPaths(uri);
        this.mParams = UnitedSchemeUtility.getParams(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public UnitedSchemeEntity m14clone() {
        Uri uri = this.mUri;
        UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(uri, this.mSource, UnitedSchemeUtility.getPaths(uri), (HashMap) this.mParams.clone());
        unitedSchemeEntity.originEntity = this;
        unitedSchemeEntity.callbackInvoked = this.callbackInvoked;
        unitedSchemeEntity.mReferUrl = this.mReferUrl;
        return unitedSchemeEntity;
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
}
