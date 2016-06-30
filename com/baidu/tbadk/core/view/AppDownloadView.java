package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class AppDownloadView extends LinearLayout {
    private DownloadData aaf;
    public ProgressBar aag;
    public ImageView aah;
    public TextView aai;
    private CustomMessageListener downloadListener;

    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.downloadListener = null;
        init(context);
    }

    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downloadListener = null;
        init(context);
    }

    public AppDownloadView(Context context) {
        super(context);
        this.downloadListener = null;
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(16);
        View inflate = LayoutInflater.from(context).inflate(u.h.app_download_layout, (ViewGroup) this, true);
        this.aag = (ProgressBar) inflate.findViewById(u.g.frs_app_push_progress);
        this.aah = (ImageView) inflate.findViewById(u.g.frs_app_push_control);
        this.aai = (TextView) inflate.findViewById(u.g.frs_app_push_percent);
    }

    public void a(BdUniqueId bdUniqueId, DownloadData downloadData) {
        if (downloadData != null) {
            this.aaf = (DownloadData) downloadData.clone();
            if (this.aaf != null) {
                setTag(this.aaf);
                a(downloadData);
            }
        }
    }

    private void a(DownloadData downloadData) {
        if (downloadData != null) {
            switch (downloadData.getStatus()) {
                case 1:
                    setVisibility(0);
                    av.c(this.aah, u.f.icon_download_play);
                    break;
                case 3:
                    setVisibility(8);
                    break;
                case 5:
                    setVisibility(0);
                    break;
                case 6:
                    setVisibility(8);
                    break;
                case 7:
                    setVisibility(0);
                    av.c(this.aah, u.f.icon_download_pause);
                    break;
            }
            int ak = com.baidu.tbadk.download.b.Ba().ak(downloadData.getId(), downloadData.getName());
            if (ak >= 0) {
                cG(ak);
            } else {
                cG(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i) {
        int max = Math.max(0, i);
        this.aag.setProgress(max);
        this.aai.setText(String.valueOf(max) + "%");
    }

    public static int b(DownloadData downloadData) {
        if (com.baidu.tbadk.download.b.Ba().fj(downloadData.getId())) {
            return 3;
        }
        if (com.baidu.tbadk.download.b.Ba().fh(downloadData.getId())) {
            return 5;
        }
        if (com.baidu.tbadk.download.b.Ba().fg(downloadData.getId())) {
            return 1;
        }
        if (!com.baidu.tbadk.download.b.Ba().al(downloadData.getId(), downloadData.getName())) {
            return 6;
        }
        return 7;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uN();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uM();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            uM();
        } else {
            uN();
        }
    }

    private void uM() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().registerListener(this.downloadListener);
        }
    }

    private void uN() {
        if (this.downloadListener != null) {
            MessageManager.getInstance().unRegisterListener(this.downloadListener);
        }
    }

    public void uO() {
        if (this.downloadListener == null) {
            this.downloadListener = new com.baidu.tbadk.core.view.a(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a implements View.OnClickListener {
        protected AppDownloadView aak;

        public void b(AppDownloadView appDownloadView) {
            this.aak = appDownloadView;
        }
    }
}
