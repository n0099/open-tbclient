package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xk0;
/* loaded from: classes2.dex */
public class RetainDialogActivity extends NadDialogActivity {
    public int C;

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean f2() {
        return true;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean g2() {
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void C1() {
        super.C1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void F1() {
        super.F1();
        if (xk0.c().a()) {
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void a2() {
        xk0.c().f();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void b2() {
        xk0.c().g();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int c2() {
        return xj0.a().b();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String h2() {
        return getResources().getString(R.string.nad_download_pause);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String i2() {
        return getResources().getString(R.string.nad_download_resume);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void e2() {
        Intent intent = this.B;
        if (intent != null) {
            this.C = intent.getIntExtra("percent", 50);
        }
        String string = getResources().getString(R.string.nad_download_retain_dialog_content_text);
        ((TextView) findViewById(R.id.nad_tv_retain_dialog_content)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
    }
}
