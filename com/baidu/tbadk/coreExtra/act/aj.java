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
    final /* synthetic */ Login2Activity KT;
    ArrayList<BasicNameValuePair> KW;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;
    private String KX = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.KT = login2Activity;
        this.mUrl = null;
        this.KW = null;
        this.mUrl = str;
        this.KW = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.KT;
        InputMethodManager inputMethodManager = this.KT.mInputManager;
        editText = this.KT.Ks;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.KT;
        InputMethodManager inputMethodManager2 = this.KT.mInputManager;
        editText2 = this.KT.Kt;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.KT.Kz;
        progressBar.setVisibility(0);
        textView = this.KT.KJ;
        textView.setVisibility(4);
        textView2 = this.KT.KL;
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
            this.yV.h(this.KW);
            this.KX = this.yV.lA();
            if (!this.yV.mc().nb().jq() || this.KX == null) {
                return null;
            }
            jVar = new com.baidu.tbadk.core.data.j();
            try {
                jVar.parserJson(this.KX);
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
        progressBar = this.KT.Kz;
        progressBar.setVisibility(8);
        textView = this.KT.KL;
        textView.setText(com.baidu.tieba.y.account_login);
        this.KT.om();
        if (jVar != null) {
            this.KT.KQ = jVar;
            this.KT.oc();
        } else if (this.yV != null) {
            if ((!this.yV.mf() || this.yV.mg() != 5) && this.yV.mg() != 6) {
                textView2 = this.KT.KJ;
                textView2.setVisibility(0);
                textView3 = this.KT.KJ;
                textView3.setText(this.yV.getErrorString());
                textView4 = this.KT.KK;
                textView4.setVisibility(8);
                this.KT.oi();
            } else {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.parserJson(this.KX);
                if (fVar.getVcode_pic_url() == null) {
                    textView5 = this.KT.KJ;
                    textView5.setVisibility(0);
                    textView6 = this.KT.KJ;
                    textView6.setText(this.yV.getErrorString());
                    textView7 = this.KT.KK;
                    textView7.setVisibility(8);
                    this.KT.oi();
                } else {
                    this.KT.Km = fVar.getVcode_md5();
                    this.KT.mVcodeUrl = fVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.KT;
                    str = this.KT.mVcodeUrl;
                    login2Activity.cm(str);
                    this.KT.oj();
                    Login2Activity login2Activity2 = this.KT;
                    editText = this.KT.Ks;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.KT.KP = null;
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
        progressBar = this.KT.Kz;
        progressBar.setVisibility(8);
        textView = this.KT.KL;
        textView.setText(com.baidu.tieba.y.account_login);
        this.KT.om();
    }
}
