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
public class aj extends BdAsyncTask<Object, Integer, com.baidu.tbadk.core.data.i> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ Login2Activity b;
    private String d;
    private com.baidu.tbadk.core.util.al c = null;
    private String e = null;

    public aj(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = login2Activity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.b;
        InputMethodManager inputMethodManager = this.b.b;
        editText = this.b.o;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.b;
        editText2 = this.b.p;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.b.w;
        progressBar.setVisibility(0);
        textView = this.b.G;
        textView.setVisibility(4);
        textView2 = this.b.I;
        textView2.setText(com.baidu.tieba.u.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tbadk.core.data.i doInBackground(Object... objArr) {
        com.baidu.tbadk.core.data.i iVar;
        Exception e;
        try {
            this.c = new com.baidu.tbadk.core.util.al(this.d);
            this.c.a(this.a);
            this.e = this.c.i();
            if (this.e != null) {
                BdLog.i("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.a().b().b() || this.e == null) {
                return null;
            }
            iVar = new com.baidu.tbadk.core.data.i();
            try {
                iVar.a(this.e);
                return iVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return iVar;
            }
        } catch (Exception e3) {
            iVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.core.data.i iVar) {
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
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(com.baidu.tieba.u.account_login);
        this.b.m();
        if (iVar != null) {
            this.b.N = iVar;
            this.b.h();
        } else if (this.c != null) {
            if ((!this.c.c() || this.c.d() != 5) && this.c.d() != 6) {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.f());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                this.b.i();
            } else {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.a(this.e);
                if (fVar.b() == null) {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.f());
                    textView7 = this.b.H;
                    textView7.setVisibility(8);
                    this.b.i();
                } else {
                    this.b.h = fVar.a();
                    this.b.i = fVar.b();
                    Login2Activity login2Activity = this.b;
                    str = this.b.i;
                    login2Activity.a(str);
                    this.b.j();
                    Login2Activity login2Activity2 = this.b;
                    editText = this.b.o;
                    login2Activity2.f = editText.getText().toString();
                }
            }
        }
        this.b.M = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(com.baidu.tieba.u.account_login);
        this.b.m();
    }
}
