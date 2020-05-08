package com.baidu.prologue.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements Cloneable {
    public static final String UNITED_SCHEME = c.getSchemeHead() + "://";
    g btP;
    private HashMap<String, String> mParams;
    private String[] mPaths;
    private String mReferUrl;
    private String mSource;
    private Uri mUri;
    public JSONObject result;
    private int mPathLevel = -1;
    private boolean mOnlyVerify = false;
    public boolean callbackInvoked = false;

    public g(Uri uri, String str) {
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mSource = str;
        this.mUri = uri;
        this.mPaths = j.getPaths(this.mUri);
        this.mParams = j.getParams(uri.toString());
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.mSource = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.mUri = uri;
        this.mSource = str;
        this.mPaths = strArr;
        this.mParams = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Mu */
    public g clone() {
        g gVar = new g(this.mUri, this.mSource, j.getPaths(this.mUri), (HashMap) this.mParams.clone());
        gVar.btP = this;
        gVar.callbackInvoked = this.callbackInvoked;
        gVar.mReferUrl = this.mReferUrl;
        return gVar;
    }

    public void setOnlyVerify(boolean z) {
        this.mOnlyVerify = z;
    }

    public boolean isOnlyVerify() {
        return this.mOnlyVerify;
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

    public String getAllPath() {
        String path;
        if (this.mUri != null) {
            if (j.hasVersion(this.mUri) && (path = this.mUri.getPath()) != null && path.length() > 1) {
                return this.mUri.getPath().substring(1);
            }
            return this.mUri.getHost() + this.mUri.getPath();
        }
        return "";
    }

    public void replaceAllPath(String str, String str2) {
        if (this.mUri != null && str != null && str2 != null) {
            this.mUri = Uri.parse(this.mUri.toString().replace(str, str2));
            this.mPaths = j.getPaths(this.mUri);
        }
    }

    public HashMap<String, String> getParams() {
        return this.mParams;
    }
}
