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
import com.baidu.tieba.b41;
import com.baidu.tieba.rk0;
import com.baidu.tieba.yj0;
/* loaded from: classes2.dex */
public class NadMiniVideoDownloadView extends RoundCornerFrameLayout implements rk0<NadMiniVideoDownloadView> {
    public AdProgressButton g;
    public NadRoundProgressBar h;
    public AdImageView i;
    public TextView j;
    public int k;
    public float l;
    public String m;
    public AdDownloadStatus n;
    public Boolean o;

    public int getLayoutId() {
        return R.layout.nad_mini_video_download_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rk0
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

    /* loaded from: classes2.dex */
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

    public NadMiniVideoDownloadView(@NonNull Context context) {
        super(context);
        this.k = -1;
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    @Override // com.baidu.tieba.rk0
    public void b(@NonNull ViewGroup viewGroup) {
        if (!(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
    }

    @DrawableRes
    public int f(@NonNull yj0 yj0Var) {
        int i = a.a[yj0Var.c.ordinal()];
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
        this.i.o(str);
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
        super(context, attributeSet);
        this.k = -1;
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    public NadMiniVideoDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = -1;
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        this.h = (NadRoundProgressBar) findViewById(R.id.mini_video_ad_pop_state_progress_bar);
        this.i = (AdImageView) findViewById(R.id.mini_video_ad_pop_state_icon);
        this.j = (TextView) findViewById(R.id.mini_video_ad_pop_state_text);
        this.g = (AdProgressButton) findViewById(R.id.mini_video_ad_pop_progress_btn);
        h();
    }

    @NonNull
    public AdDownloadStatus getDownloadStatus() {
        return this.n;
    }

    public int getMax() {
        return this.h.getMax();
    }

    public void h() {
        this.h.setMax(100);
        this.g.setMax(100);
        this.g.setText("");
        int i = this.k;
        if (i >= 0) {
            this.g.setForeground(i);
        } else {
            this.g.setForeground(getResources().getColor(R.color.nad_mini_video_download_progress_color));
        }
        this.h.setRoundWidth(b41.c.a(getContext(), 1.0f));
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

    @Override // com.baidu.tieba.rk0
    public void update(String str, @NonNull yj0 yj0Var) {
        this.m = str;
        AdDownloadStatus adDownloadStatus = yj0Var.c;
        this.n = adDownloadStatus;
        if (adDownloadStatus == AdDownloadStatus.DOWNLOADING) {
            this.m = "已下载 : " + this.m;
            setProgress((int) (yj0Var.i * 100.0f));
        } else if (adDownloadStatus == AdDownloadStatus.COMPLETED) {
            setProgress(100);
        } else {
            setStateImageRes(f(yj0Var));
        }
        setText(this.m);
        postInvalidate();
    }
}
