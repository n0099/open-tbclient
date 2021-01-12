package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes8.dex */
class b {
    private boolean doZ;
    private boolean dpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.doZ = false;
        aEn();
        aEm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.doZ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cD(long j) {
        b(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cE(long j) {
        b(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cF(long j) {
        b(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cG(long j) {
        b(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void b(int i, long j, String str, String str2) {
        ViewGroup aEk;
        if (!this.doZ && (aEk = aEk()) != null) {
            TextView textView = (TextView) aEk.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(long j, long j2) {
        ViewGroup aEk;
        if (!this.doZ && (aEk = aEk()) != null) {
            ((TextView) aEk.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aEk() {
        ViewGroup viewGroup;
        if (e.aIs() != null && e.aIs().aIl() != null && (viewGroup = (ViewGroup) e.aIs().aIl().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aIs().aIl()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dpG = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aEl() {
        e aIs = e.aIs();
        if (aIs != null && aIs.aIl() != null) {
            ViewGroup viewGroup = (ViewGroup) aIs.aIl().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dpG = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEm() {
        if (!this.dpG) {
            aEk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEn() {
        if (this.dpG) {
            aEl();
        }
    }
}
