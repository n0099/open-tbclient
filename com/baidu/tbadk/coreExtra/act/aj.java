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
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ Login2Activity b;
    private String d;
    private com.baidu.tbadk.core.util.ae c = null;
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
        textView2.setText(com.baidu.tieba.x.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tbadk.core.data.j doInBackground(Object... objArr) {
        com.baidu.tbadk.core.data.j jVar;
        Exception e;
        try {
            this.c = new com.baidu.tbadk.core.util.ae(this.d);
            this.c.a(this.a);
            this.e = this.c.h();
            if (!this.c.a().b().b() || this.e == null) {
                return null;
            }
            jVar = new com.baidu.tbadk.core.data.j();
            try {
                jVar.a(this.e);
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
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(com.baidu.tieba.x.account_login);
        this.b.m();
        if (jVar != null) {
            this.b.N = jVar;
            this.b.h();
        } else if (this.c != null) {
            if ((!this.c.b() || this.c.c() != 5) && this.c.c() != 6) {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.e());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                this.b.i();
            } else {
                com.baidu.tbadk.coreExtra.data.e eVar = new com.baidu.tbadk.coreExtra.data.e();
                eVar.a(this.e);
                if (eVar.b() == null) {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.e());
                    textView7 = this.b.H;
                    textView7.setVisibility(8);
                    this.b.i();
                } else {
                    this.b.h = eVar.a();
                    this.b.i = eVar.b();
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
            this.c.f();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(com.baidu.tieba.x.account_login);
        this.b.m();
    }
}
