package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ug0;
import com.baidu.tieba.uh0;
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

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void P1() {
        uh0.c().f();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void Q1() {
        uh0.c().g();
        finish();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int S1() {
        return ug0.a().b();
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String Y1() {
        return getResources().getString(R.string.nad_download_pause);
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String a2() {
        return getResources().getString(R.string.nad_download_resume);
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void w1() {
        super.w1();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void y1() {
        super.y1();
        if (uh0.c().a()) {
            finish();
        }
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
