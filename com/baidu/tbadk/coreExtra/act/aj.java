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
    final /* synthetic */ Login2Activity QG;
    ArrayList<BasicNameValuePair> QJ;
    private String mUrl;
    private com.baidu.tbadk.core.util.ad CX = null;
    private String QK = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.QG = login2Activity;
        this.mUrl = null;
        this.QJ = null;
        this.mUrl = str;
        this.QJ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.QG;
        InputMethodManager inputMethodManager = this.QG.mInputManager;
        editText = this.QG.Qe;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.QG;
        InputMethodManager inputMethodManager2 = this.QG.mInputManager;
        editText2 = this.QG.Qf;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.QG.Ql;
        progressBar.setVisibility(0);
        textView = this.QG.Qv;
        textView.setVisibility(4);
        textView2 = this.QG.Qx;
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
            this.CX = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CX.r(this.QJ);
            this.QK = this.CX.oy();
            if (!this.CX.oZ().qh().ma() || this.QK == null) {
                return null;
            }
            nVar = new com.baidu.tbadk.core.data.n();
            try {
                nVar.parserJson(this.QK);
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
        progressBar = this.QG.Ql;
        progressBar.setVisibility(8);
        textView = this.QG.Qx;
        textView.setText(com.baidu.tieba.z.account_login);
        this.QG.ry();
        if (nVar != null) {
            this.QG.QD = nVar;
            this.QG.ro();
        } else if (this.CX != null) {
            if ((!this.CX.pc() || this.CX.pd() != 5) && this.CX.pd() != 6) {
                textView2 = this.QG.Qv;
                textView2.setVisibility(0);
                textView3 = this.QG.Qv;
                textView3.setText(this.CX.getErrorString());
                textView4 = this.QG.Qw;
                textView4.setVisibility(8);
                this.QG.ru();
            } else {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(this.QK);
                if (jVar.getVcode_pic_url() == null) {
                    textView5 = this.QG.Qv;
                    textView5.setVisibility(0);
                    textView6 = this.QG.Qv;
                    textView6.setText(this.CX.getErrorString());
                    textView7 = this.QG.Qw;
                    textView7.setVisibility(8);
                    this.QG.ru();
                } else {
                    this.QG.PY = jVar.getVcode_md5();
                    this.QG.mVcodeUrl = jVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.QG;
                    str = this.QG.mVcodeUrl;
                    login2Activity.de(str);
                    this.QG.rv();
                    Login2Activity login2Activity2 = this.QG;
                    editText = this.QG.Qe;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.QG.QC = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        progressBar = this.QG.Ql;
        progressBar.setVisibility(8);
        textView = this.QG.Qx;
        textView.setText(com.baidu.tieba.z.account_login);
        this.QG.ry();
    }
}
