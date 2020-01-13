package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class B extends HttpHandlerWrap {
    final /* synthetic */ FillUsernameCallback a;
    final /* synthetic */ FillUsernameResult b;
    final /* synthetic */ SapiDataEncryptor c;
    final /* synthetic */ G d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(G g, Looper looper, FillUsernameCallback fillUsernameCallback, FillUsernameResult fillUsernameResult, SapiDataEncryptor sapiDataEncryptor) {
        super(looper);
        this.d = g;
        this.a = fillUsernameCallback;
        this.b = fillUsernameResult;
        this.c = sapiDataEncryptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
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
        int b = this.d.b(str);
        this.b.setResultCode(b);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
            JSONObject jSONObject2 = new JSONObject(this.c.decrypt(jSONObject.optString(TableDefine.DB_TABLE_USERINFO)));
            if (b == 0 || b == 110000) {
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.bduss = jSONObject2.optString("bduss");
                sapiAccount.ptoken = jSONObject2.optString("ptoken");
                sapiAccount.stoken = jSONObject2.optString("stoken");
                sapiAccount.displayname = jSONObject2.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccount.username = jSONObject2.optString(BdStatsConstant.StatsKey.UNAME);
                sapiAccount.uid = jSONObject2.optString("uid");
                sapiConfiguration = this.d.c;
                sapiAccount.app = SapiUtils.getAppName(sapiConfiguration.context);
                sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).tplStokenMap);
                sapiConfiguration2 = this.d.c;
                sapiAccount.putExtra("tpl", sapiConfiguration2.tpl);
                SapiShareClient.getInstance().validate(sapiAccount);
                this.b.session = sapiAccount;
                this.a.onSuccess(this.b);
                new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.f);
            } else if (b == 160103) {
                this.a.onBdussExpired(this.b);
            } else if (b != 160104) {
                this.a.onFailure(this.b);
            } else {
                this.a.onUserHaveUsername(this.b);
            }
        } catch (Throwable th) {
            this.a.onFailure(this.b);
            Log.e(th);
        }
    }
}
