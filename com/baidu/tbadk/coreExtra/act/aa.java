package com.baidu.tbadk.coreExtra.act;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends BdAsyncTask<Object, Integer, com.baidu.tbadk.core.data.h> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private ak c = null;
    private String e = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tbadk.core.data.h a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tbadk.core.data.h hVar) {
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
        com.baidu.tbadk.core.data.h hVar2 = hVar;
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(com.baidu.tbadk.l.account_login);
        LoginActivity.f(this.b);
        if (hVar2 != null) {
            this.b.N = hVar2;
            LoginActivity.k(this.b);
        } else if (this.c != null) {
            if ((this.c.c() && this.c.d() == 5) || this.c.d() == 6) {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.a(this.e);
                if (fVar.b() != null) {
                    this.b.h = fVar.a();
                    this.b.i = fVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.i;
                    loginActivity.a(str);
                    LoginActivity.h(this.b);
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.o;
                    loginActivity2.f = editText.getText().toString();
                } else {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.f());
                    textView7 = this.b.H;
                    textView7.setVisibility(8);
                    LoginActivity.j(this.b);
                }
            } else {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.f());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                LoginActivity.j(this.b);
            }
        }
        this.b.M = null;
    }

    public aa(LoginActivity loginActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        LoginActivity loginActivity = this.b;
        InputMethodManager inputMethodManager = this.b.b;
        editText = this.b.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.b;
        editText2 = this.b.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.b.w;
        progressBar.setVisibility(0);
        textView = this.b.G;
        textView.setVisibility(4);
        textView2 = this.b.I;
        textView2.setText(com.baidu.tbadk.l.account_login_loading);
    }

    private com.baidu.tbadk.core.data.h a() {
        com.baidu.tbadk.core.data.h hVar;
        Exception e;
        try {
            this.c = new ak(this.d);
            this.c.a(this.a);
            this.e = this.c.i();
            if (this.e != null) {
                com.baidu.adp.lib.util.f.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.a().b().b() || this.e == null) {
                return null;
            }
            hVar = new com.baidu.tbadk.core.data.h();
            try {
                hVar.a(this.e);
                this.b.P = com.baidu.tbadk.core.a.x.a(com.baidu.tbadk.core.a.a.a(hVar.a().getBDUSS()));
                return hVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return hVar;
            }
        } catch (Exception e3) {
            hVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
        textView.setText(com.baidu.tbadk.l.account_login);
        LoginActivity.f(this.b);
    }
}
