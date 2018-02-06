package com.baidu.ar.i.a;

import android.os.AsyncTask;
import com.baidu.ar.util.o;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends AsyncTask<String, Integer, Boolean> {
    InterfaceC0041a a;

    /* renamed from: com.baidu.ar.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0041a {
        void a();

        void b();
    }

    public a(InterfaceC0041a interfaceC0041a) {
        this.a = interfaceC0041a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(o.a(new File(strArr[0]), new File(strArr[1]), new Boolean(true)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            if (this.a != null) {
                this.a.a();
            } else {
                this.a.b();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
