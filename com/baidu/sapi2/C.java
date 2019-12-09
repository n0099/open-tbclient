package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.utils.Log;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class C extends HttpHandlerWrap {
    final /* synthetic */ GetTplStokenCallback a;
    final /* synthetic */ GetTplStokenResult b;
    final /* synthetic */ SapiAccount c;
    final /* synthetic */ List d;
    final /* synthetic */ boolean e;
    final /* synthetic */ String f;
    final /* synthetic */ G g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(G g, Looper looper, GetTplStokenCallback getTplStokenCallback, GetTplStokenResult getTplStokenResult, SapiAccount sapiAccount, List list, boolean z, String str) {
        super(looper);
        this.g = g;
        this.a = getTplStokenCallback;
        this.b = getTplStokenResult;
        this.c = sapiAccount;
        this.d = list;
        this.e = z;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        this.b.setResultCode(i);
        this.a.onFailure(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFinish() {
        this.a.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onStart() {
        this.a.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        SapiConfiguration sapiConfiguration;
        SapiConfiguration sapiConfiguration2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.b.setResultCode(parseInt);
            if (parseInt == 0) {
                Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                this.b.tplStokenMap = tplStokenMap;
                SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                if (!TextUtils.isEmpty(this.c.extra)) {
                    extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(this.c.extra));
                }
                extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                this.c.extra = extraProperty.toJSONObject().toString();
                if (this.d.size() == tplStokenMap.size()) {
                    if (!this.e) {
                        sapiConfiguration = this.g.c;
                        SapiContext.getInstance(sapiConfiguration.context).setCurrentAccount(this.c);
                        SapiAccountManager.getInstance().preFetchStoken(this.c, false);
                        sapiConfiguration2 = this.g.c;
                        SapiContext.getInstance(sapiConfiguration2.context).addLoginAccount(this.c);
                        new com.baidu.sapi2.share.m().a(false);
                    } else {
                        SapiShareClient.getInstance().validate(this.c);
                    }
                    this.a.onSuccess(this.b);
                    return;
                }
                this.b.setResultCode(-306);
                this.a.onFailure(this.b);
            } else if (parseInt != 8) {
                if (!TextUtils.isEmpty(this.f)) {
                    this.b.setResultMsg(jSONObject.optString("errmsg"));
                    this.a.onFailure(this.b);
                }
            } else if (!TextUtils.isEmpty(this.f)) {
                String optString = jSONObject.optString("ssnerror");
                if (TextUtils.isEmpty(optString)) {
                    optString = "0";
                }
                int parseInt2 = Integer.parseInt(optString);
                if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                    this.b.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                    this.b.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                }
                this.b.setResultMsg(jSONObject.optString("errmsg"));
                this.a.onFailure(this.b);
            }
        } catch (Exception e) {
            Log.e(e);
            if (!TextUtils.isEmpty(this.f)) {
                this.b.setResultCode(-205);
                this.a.onFailure(this.b);
            }
        }
    }
}
