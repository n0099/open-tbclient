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
public class aj extends BdAsyncTask<Object, Integer, com.baidu.tbadk.core.data.n> {
    final /* synthetic */ Login2Activity QD;
    ArrayList<BasicNameValuePair> QG;
    private String mUrl;
    private com.baidu.tbadk.core.util.ad CU = null;
    private String QH = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.QD = login2Activity;
        this.mUrl = null;
        this.QG = null;
        this.mUrl = str;
        this.QG = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.QD;
        InputMethodManager inputMethodManager = this.QD.mInputManager;
        editText = this.QD.Qb;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.QD;
        InputMethodManager inputMethodManager2 = this.QD.mInputManager;
        editText2 = this.QD.Qc;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.QD.Qi;
        progressBar.setVisibility(0);
        textView = this.QD.Qs;
        textView.setVisibility(4);
        textView2 = this.QD.Qu;
        textView2.setText(com.baidu.tieba.z.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public com.baidu.tbadk.core.data.n doInBackground(Object... objArr) {
        com.baidu.tbadk.core.data.n nVar;
        Exception e;
        try {
            this.CU = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CU.r(this.QG);
            this.QH = this.CU.or();
            if (!this.CU.oS().qa().lT() || this.QH == null) {
                return null;
            }
            nVar = new com.baidu.tbadk.core.data.n();
            try {
                nVar.parserJson(this.QH);
                return nVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return nVar;
            }
        } catch (Exception e3) {
            nVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.n nVar) {
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
        progressBar = this.QD.Qi;
        progressBar.setVisibility(8);
        textView = this.QD.Qu;
        textView.setText(com.baidu.tieba.z.account_login);
        this.QD.rs();
        if (nVar != null) {
            this.QD.Qz = nVar;
            this.QD.ri();
        } else if (this.CU != null) {
            if ((!this.CU.oV() || this.CU.oW() != 5) && this.CU.oW() != 6) {
                textView2 = this.QD.Qs;
                textView2.setVisibility(0);
                textView3 = this.QD.Qs;
                textView3.setText(this.CU.getErrorString());
                textView4 = this.QD.Qt;
                textView4.setVisibility(8);
                this.QD.ro();
            } else {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(this.QH);
                if (jVar.getVcode_pic_url() == null) {
                    textView5 = this.QD.Qs;
                    textView5.setVisibility(0);
                    textView6 = this.QD.Qs;
                    textView6.setText(this.CU.getErrorString());
                    textView7 = this.QD.Qt;
                    textView7.setVisibility(8);
                    this.QD.ro();
                } else {
                    this.QD.PV = jVar.getVcode_md5();
                    this.QD.mVcodeUrl = jVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.QD;
                    str = this.QD.mVcodeUrl;
                    login2Activity.db(str);
                    this.QD.rp();
                    Login2Activity login2Activity2 = this.QD;
                    editText = this.QD.Qb;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.QD.Qy = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.CU != null) {
            this.CU.dJ();
            this.CU = null;
        }
        progressBar = this.QD.Qi;
        progressBar.setVisibility(8);
        textView = this.QD.Qu;
        textView.setText(com.baidu.tieba.z.account_login);
        this.QD.rs();
    }
}
