package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.vg0;
import com.baidu.tieba.vh0;
/* loaded from: classes3.dex */
public class RetainDialogActivity extends NadDialogActivity {
    public int C;

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean Q1() {
        return true;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean R1() {
        return true;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void J1() {
        vh0.c().f();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void K1() {
        vh0.c().g();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int M1() {
        return vg0.a().b();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String S1() {
        return getResources().getString(R.string.nad_download_pause);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String W1() {
        return getResources().getString(R.string.nad_download_resume);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void u1() {
        super.u1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void w1() {
        super.w1();
        if (vh0.c().a()) {
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void P1() {
        Intent intent = this.B;
        if (intent != null) {
            this.C = intent.getIntExtra("percent", 50);
        }
        String string = getResources().getString(R.string.nad_download_retain_dialog_content_text);
        ((TextView) findViewById(R.id.nad_tv_retain_dialog_content)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
    }
}
