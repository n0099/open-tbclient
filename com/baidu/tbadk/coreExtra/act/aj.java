package com.baidu.tbadk.coreExtra.act;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends BdAsyncTask<Object, Integer, com.baidu.tbadk.core.data.j> {
    final /* synthetic */ Login2Activity KU;
    ArrayList<BasicNameValuePair> KX;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;
    private String KY = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.KU = login2Activity;
        this.mUrl = null;
        this.KX = null;
        this.mUrl = str;
        this.KX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.KU;
        InputMethodManager inputMethodManager = this.KU.mInputManager;
        editText = this.KU.Kt;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.KU;
        InputMethodManager inputMethodManager2 = this.KU.mInputManager;
        editText2 = this.KU.Ku;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.KU.KA;
        progressBar.setVisibility(0);
        textView = this.KU.KK;
        textView.setVisibility(4);
        textView2 = this.KU.KM;
        textView2.setText(com.baidu.tieba.y.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public com.baidu.tbadk.core.data.j doInBackground(Object... objArr) {
        com.baidu.tbadk.core.data.j jVar;
        Exception e;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            this.yV.h(this.KX);
            this.KY = this.yV.lA();
            if (!this.yV.mc().nb().jq() || this.KY == null) {
                return null;
            }
            jVar = new com.baidu.tbadk.core.data.j();
            try {
                jVar.parserJson(this.KY);
                return jVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return jVar;
            }
        } catch (Exception e3) {
            jVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.j jVar) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        String str;
        EditText editText;
        progressBar = this.KU.KA;
        progressBar.setVisibility(8);
        textView = this.KU.KM;
        textView.setText(com.baidu.tieba.y.account_login);
        this.KU.om();
        if (jVar != null) {
            this.KU.KR = jVar;
            this.KU.oc();
        } else if (this.yV != null) {
            if ((!this.yV.mf() || this.yV.mg() != 5) && this.yV.mg() != 6) {
                textView2 = this.KU.KK;
                textView2.setVisibility(0);
                textView3 = this.KU.KK;
                textView3.setText(this.yV.getErrorString());
                textView4 = this.KU.KL;
                textView4.setVisibility(8);
                this.KU.oi();
            } else {
                com.baidu.tbadk.coreExtra.data.g gVar = new com.baidu.tbadk.coreExtra.data.g();
                gVar.parserJson(this.KY);
                if (gVar.getVcode_pic_url() == null) {
                    textView5 = this.KU.KK;
                    textView5.setVisibility(0);
                    textView6 = this.KU.KK;
                    textView6.setText(this.yV.getErrorString());
                    textView7 = this.KU.KL;
                    textView7.setVisibility(8);
                    this.KU.oi();
                } else {
                    this.KU.Kn = gVar.getVcode_md5();
                    this.KU.mVcodeUrl = gVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.KU;
                    str = this.KU.mVcodeUrl;
                    login2Activity.cm(str);
                    this.KU.oj();
                    Login2Activity login2Activity2 = this.KU;
                    editText = this.KU.Kt;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.KU.KQ = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        progressBar = this.KU.KA;
        progressBar.setVisibility(8);
        textView = this.KU.KM;
        textView.setText(com.baidu.tieba.y.account_login);
        this.KU.om();
    }
}
