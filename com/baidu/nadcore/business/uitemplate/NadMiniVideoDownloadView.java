package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.AdProgressButton;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadRoundProgressBar;
import com.baidu.nadcore.widget.RoundCornerFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ph0;
import com.baidu.tieba.uc0;
import com.baidu.tieba.w11;
import com.baidu.tieba.wg0;
/* loaded from: classes3.dex */
public class NadMiniVideoDownloadView extends RoundCornerFrameLayout implements ph0<NadMiniVideoDownloadView> {
    public AdProgressButton g;
    public NadRoundProgressBar h;
    public AdImageView i;
    public TextView j;
    public int k;
    public float l;
    public String m;
    public AdDownloadStatus n;
    public Boolean o;
    public float p;

    public int getLayoutId() {
        return R.layout.nad_mini_video_download_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ph0
    @Nullable
    public NadMiniVideoDownloadView getRealView() {
        return this;
    }

    public void setStrokeColor(int i) {
    }

    public void setStrokeWidth(float f) {
    }

    public void setTextColor(int i) {
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ AdDownloadStatus b;
        public final /* synthetic */ float c;
        public final /* synthetic */ int d;

        public a(String str, AdDownloadStatus adDownloadStatus, float f, int i) {
            this.a = str;
            this.b = adDownloadStatus;
            this.c = f;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NadMiniVideoDownloadView nadMiniVideoDownloadView = NadMiniVideoDownloadView.this;
            nadMiniVideoDownloadView.m = this.a;
            AdDownloadStatus adDownloadStatus = this.b;
            if (adDownloadStatus == AdDownloadStatus.DOWNLOADING) {
                nadMiniVideoDownloadView.m = "已下载 : " + NadMiniVideoDownloadView.this.m;
                NadMiniVideoDownloadView.this.setProgress((int) (this.c * 100.0f));
            } else if (adDownloadStatus == AdDownloadStatus.COMPLETED) {
                nadMiniVideoDownloadView.setProgress(100);
            } else if (adDownloadStatus == AdDownloadStatus.NONE) {
                nadMiniVideoDownloadView.setProgress(0);
            }
            NadMiniVideoDownloadView.this.setStateImageRes(this.d);
            NadMiniVideoDownloadView nadMiniVideoDownloadView2 = NadMiniVideoDownloadView.this;
            nadMiniVideoDownloadView2.setText(nadMiniVideoDownloadView2.m);
            NadMiniVideoDownloadView.this.postInvalidate();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
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

    public NadMiniVideoDownloadView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.ph0
    public void c(@NonNull ViewGroup viewGroup) {
        if (!(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
    }

    @DrawableRes
    public int g(@NonNull wg0 wg0Var) {
        int i = b.a[wg0Var.c.ordinal()];
        if (i == 1) {
            return R.drawable.nad_mini_video_ad_pop_download_begin;
        }
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    if (i == 6) {
                        return R.drawable.nad_mini_video_ad_pop_download_begin;
                    }
                    return -1;
                }
                return R.drawable.nad_mini_video_ad_pop_download_open;
            }
            return R.drawable.nad_mini_video_ad_pop_download_complete;
        }
        return R.drawable.nad_mini_video_ad_pop_download_pause;
    }

    public final void j(@Nullable AttributeSet attributeSet) {
        this.p = getContext().obtainStyledAttributes(attributeSet, uc0.NadMiniVideoDownloadView).getDimension(0, w11.c.a(getContext(), 11.0f));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.l);
        setBackground(gradientDrawable);
    }

    public void setBorderRadius(float f) {
        this.l = f;
        AdProgressButton adProgressButton = this.g;
        if (adProgressButton != null) {
            adProgressButton.setRadius((int) f);
        }
    }

    public void setIconArrowSwitch(boolean z) {
        this.o = Boolean.valueOf(z);
    }

    public void setImageViewLayout(FrameLayout.LayoutParams layoutParams) {
        AdImageView adImageView = this.i;
        if (adImageView != null && this.h != null) {
            adImageView.setLayoutParams(layoutParams);
            this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void setMax(int i) {
        this.h.setMax(i);
        this.g.setMax(i);
    }

    public void setProgress(int i) {
        if (this.o.booleanValue()) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
        }
        this.i.setVisibility(8);
        this.h.setProgress(i);
        this.g.setProgressNoText(i);
    }

    public void setProgressColor(int i) {
        this.k = i;
        AdProgressButton adProgressButton = this.g;
        if (adProgressButton != null) {
            adProgressButton.setForeground(i);
        }
    }

    public void setRoundProgressBarVisible(boolean z) {
        int i;
        NadRoundProgressBar nadRoundProgressBar = this.h;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        nadRoundProgressBar.setVisibility(i);
    }

    public void setStateImageIcon(String str) {
        if (this.o.booleanValue()) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.i.B(str, !this.o.booleanValue());
        this.h.setVisibility(8);
    }

    public void setStateImageIconVisible(boolean z) {
        int i;
        AdImageView adImageView = this.i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        adImageView.setVisibility(i);
    }

    public void setText(String str) {
        this.j.setText(str);
    }

    public void setTextSize(float f) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextSize(1, f);
        }
    }

    public NadMiniVideoDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b(String str, @NonNull wg0 wg0Var) {
        AdDownloadStatus adDownloadStatus = wg0Var.c;
        float f = wg0Var.i;
        int g = g(wg0Var);
        this.n = adDownloadStatus;
        post(new a(str, adDownloadStatus, f, g));
    }

    public NadMiniVideoDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = -1;
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        j(attributeSet);
        h();
    }

    @NonNull
    public AdDownloadStatus getDownloadStatus() {
        return this.n;
    }

    public int getMax() {
        return this.h.getMax();
    }

    public final void h() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        this.h = (NadRoundProgressBar) findViewById(R.id.mini_video_ad_pop_state_progress_bar);
        this.i = (AdImageView) findViewById(R.id.mini_video_ad_pop_state_icon);
        this.j = (TextView) findViewById(R.id.mini_video_ad_pop_state_text);
        this.g = (AdProgressButton) findViewById(R.id.mini_video_ad_pop_progress_btn);
        i();
        setTextSize(w11.c.m(getContext(), this.p));
    }

    public void i() {
        this.h.setMax(100);
        this.g.setMax(100);
        this.g.setText("");
        int i = this.k;
        if (i >= 0) {
            this.g.setForeground(i);
        } else {
            this.g.setForeground(getResources().getColor(R.color.nad_mini_video_download_progress_color));
        }
        this.h.setRoundWidth(w11.c.a(getContext(), 1.0f));
        this.h.setCircleColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
        this.h.setCircleProgressColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
        this.j.setTextColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
        this.g.setBackgroundDrawable(null);
    }

    public void setStateImageRes(@DrawableRes int i) {
        if (i == -1) {
            this.i.setVisibility(4);
            return;
        }
        if (this.o.booleanValue()) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.h.setVisibility(8);
        this.i.setImageDrawable(getResources().getDrawable(i));
    }
}
