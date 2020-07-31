package com.baidu.swan.apps.performance.d;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a {
    private boolean czq;
    private boolean czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.czq = false;
        aoy();
        aox();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void done() {
        this.czq = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bn(long j) {
        a(a.f.ftp, j, "#80ff0000", "FTP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bo(long j) {
        a(a.f.fip, j, "#80ff0000", "FIP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bp(long j) {
        a(a.f.fcp, j, "#80ff0000", "FCP");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bq(long j) {
        a(a.f.fmp, j, "#8000ff00", "FMP");
    }

    private void a(int i, long j, String str, String str2) {
        ViewGroup aov;
        if (!this.czq && (aov = aov()) != null) {
            TextView textView = (TextView) aov.findViewById(i);
            textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
            textView.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(long j, long j2) {
        ViewGroup aov;
        if (!this.czq && (aov = aov()) != null) {
            ((TextView) aov.findViewById(a.f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
        }
    }

    private ViewGroup aov() {
        ViewGroup viewGroup;
        if (e.arw() != null && e.arw().arp() != null && (viewGroup = (ViewGroup) e.arw().arp().findViewById(16908290)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(a.f.start_up_root_container);
            if (viewGroup2 == null) {
                ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.arw().arp()).inflate(a.g.swan_app_startup_window, viewGroup);
                this.czr = true;
                return viewGroup3;
            }
            return viewGroup2;
        }
        return null;
    }

    private void aow() {
        e arw = e.arw();
        if (arw != null && arw.arp() != null) {
            ViewGroup viewGroup = (ViewGroup) arw.arp().findViewById(a.f.start_up_root_container);
            if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            }
            this.czr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aox() {
        if (!this.czr) {
            aov();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aoy() {
        if (this.czr) {
            aow();
        }
    }
}
