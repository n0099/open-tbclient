package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.gl0;
import com.baidu.tieba.gm0;
/* loaded from: classes3.dex */
public class RetainDialogActivity extends NadDialogActivity {
    public int C;

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean V1() {
        return true;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean W1() {
        return true;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1() {
        super.B1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1() {
        super.D1();
        if (gm0.c().a()) {
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void P1() {
        gm0.c().f();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void Q1() {
        gm0.c().g();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int R1() {
        return gl0.a().b();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String X1() {
        return getResources().getString(R.string.nad_download_pause);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String Y1() {
        return getResources().getString(R.string.nad_download_resume);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void U1() {
        Intent intent = this.B;
        if (intent != null) {
            this.C = intent.getIntExtra("percent", 50);
        }
        String string = getResources().getString(R.string.nad_download_retain_dialog_content_text);
        ((TextView) findViewById(R.id.nad_tv_retain_dialog_content)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
    }
}
