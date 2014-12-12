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
public class aj extends BdAsyncTask<Object, Integer, com.baidu.tbadk.core.data.m> {
    final /* synthetic */ Login2Activity Qf;
    ArrayList<BasicNameValuePair> Qi;
    private String mUrl;
    private com.baidu.tbadk.core.util.ad CV = null;
    private String Qj = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.Qf = login2Activity;
        this.mUrl = null;
        this.Qi = null;
        this.mUrl = str;
        this.Qi = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.Qf;
        InputMethodManager inputMethodManager = this.Qf.mInputManager;
        editText = this.Qf.PC;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.Qf;
        InputMethodManager inputMethodManager2 = this.Qf.mInputManager;
        editText2 = this.Qf.PD;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.Qf.PK;
        progressBar.setVisibility(0);
        textView = this.Qf.PV;
        textView.setVisibility(4);
        textView2 = this.Qf.PX;
        textView2.setText(com.baidu.tieba.z.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public com.baidu.tbadk.core.data.m doInBackground(Object... objArr) {
        com.baidu.tbadk.core.data.m mVar;
        Exception e;
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CV.q(this.Qi);
            this.Qj = this.CV.ov();
            if (!this.CV.oW().pW().ma() || this.Qj == null) {
                return null;
            }
            mVar = new com.baidu.tbadk.core.data.m();
            try {
                mVar.parserJson(this.Qj);
                return mVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return mVar;
            }
        } catch (Exception e3) {
            mVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.m mVar) {
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
        progressBar = this.Qf.PK;
        progressBar.setVisibility(8);
        textView = this.Qf.PX;
        textView.setText(com.baidu.tieba.z.account_login);
        this.Qf.rn();
        if (mVar != null) {
            this.Qf.Qc = mVar;
            this.Qf.rd();
        } else if (this.CV != null) {
            if ((!this.CV.oZ() || this.CV.pa() != 5) && this.CV.pa() != 6) {
                textView2 = this.Qf.PV;
                textView2.setVisibility(0);
                textView3 = this.Qf.PV;
                textView3.setText(this.CV.getErrorString());
                textView4 = this.Qf.PW;
                textView4.setVisibility(8);
                this.Qf.rj();
            } else {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(this.Qj);
                if (jVar.getVcode_pic_url() == null) {
                    textView5 = this.Qf.PV;
                    textView5.setVisibility(0);
                    textView6 = this.Qf.PV;
                    textView6.setText(this.CV.getErrorString());
                    textView7 = this.Qf.PW;
                    textView7.setVisibility(8);
                    this.Qf.rj();
                } else {
                    this.Qf.Pv = jVar.getVcode_md5();
                    this.Qf.mVcodeUrl = jVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.Qf;
                    str = this.Qf.mVcodeUrl;
                    login2Activity.df(str);
                    this.Qf.rk();
                    Login2Activity login2Activity2 = this.Qf;
                    editText = this.Qf.PC;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.Qf.Qb = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        progressBar = this.Qf.PK;
        progressBar.setVisibility(8);
        textView = this.Qf.PX;
        textView.setText(com.baidu.tieba.z.account_login);
        this.Qf.rn();
    }
}
