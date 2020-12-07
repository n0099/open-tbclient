package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes25.dex */
class b {
    private boolean doQ;
    private boolean dpw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.doQ = false;
        aGN();
        aGM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.doQ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cD(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cE(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cF(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aGK;
        if (!this.doQ && (aGK = aGK()) != null) {
            TextView textView = (TextView) aGK.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(long j, long j2) {
        ViewGroup aGK;
        if (!this.doQ && (aGK = aGK()) != null) {
            ((TextView) aGK.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aGK() {
        ViewGroup viewGroup;
        if (e.aJV() != null && e.aJV().aJO() != null && (viewGroup = (ViewGroup) e.aJV().aJO().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.aJV().aJO()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.dpw = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aGL() {
        e aJV = e.aJV();
        if (aJV != null && aJV.aJO() != null) {
            ViewGroup viewGroup = (ViewGroup) aJV.aJO().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.dpw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGM() {
        if (!this.dpw) {
            aGK();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGN() {
        if (this.dpw) {
            aGL();
        }
    }
}
