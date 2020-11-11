package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
class b {
    private boolean djy;
    private boolean dke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.djy = false;
        aEn();
        aEm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.djy = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cd(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ce(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cf(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cg(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aEk;
        if (!this.djy && (aEk = aEk()) != null) {
            TextView textView = (TextView) aEk.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(long j, long j2) {
        ViewGroup aEk;
        if (!this.djy && (aEk = aEk()) != null) {
            ((TextView) aEk.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aEk() {
        ViewGroup viewGroup;
        if (e.aHv() != null && e.aHv().aHo() != null && (viewGroup = (ViewGroup) e.aHv().aHo().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aHv().aHo()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dke = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aEl() {
        e aHv = e.aHv();
        if (aHv != null && aHv.aHo() != null) {
            ViewGroup viewGroup = (ViewGroup) aHv.aHo().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dke = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEm() {
        if (!this.dke) {
            aEk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEn() {
        if (this.dke) {
            aEl();
        }
    }
}
