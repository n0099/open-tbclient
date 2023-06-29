package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.dm0;
/* loaded from: classes3.dex */
public class NadEnhanceButtonDownloadView extends NadMiniVideoDownloadView {
    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public int getLayoutId() {
        return R.layout.nad_max_download_view;
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public NadEnhanceButtonDownloadView(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    @DrawableRes
    public int f(@NonNull dm0 dm0Var) {
        int i = a.a[dm0Var.c.ordinal()];
        if (i == 1 || i == 5 || i == 6) {
            return R.drawable.nad_ebtn_icon;
        }
        return -1;
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public void setImageViewLayout(FrameLayout.LayoutParams layoutParams) {
        super.setImageViewLayout(layoutParams);
        setRoundProgressBarVisible(false);
    }

    @Override // com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView
    public void setProgress(int i) {
        super.setProgress(i);
        setRoundProgressBarVisible(false);
    }

    public NadEnhanceButtonDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NadEnhanceButtonDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
