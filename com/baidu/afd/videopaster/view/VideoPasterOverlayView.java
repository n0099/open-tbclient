package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int SG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Ry;
    private TextView SA;
    private TextView SB;
    private View SC;
    private ImageView SD;
    private boolean SE;
    private a SF;
    private boolean SH;
    private int SJ;
    private int SK;
    private boolean SL;
    private com.baidu.afd.videopaster.data.a SM;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void ph();

        void pi();

        void pj();

        void pk();

        void pl();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.SH = false;
        this.SJ = 0;
        this.SK = 0;
        this.SL = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.SF != null) {
                        VideoPasterOverlayView.this.SF.pk();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.SF != null) {
                        VideoPasterOverlayView.this.SF.ph();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.SF != null) {
                        VideoPasterOverlayView.this.SF.pj();
                        VideoPasterOverlayView.this.SL = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.SF != null) {
                        VideoPasterOverlayView.this.SF.pi();
                        VideoPasterOverlayView.this.SL = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.SF != null) {
                    VideoPasterOverlayView.this.SF.pl();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.SC = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.SA = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.SB = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.SD = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.SB.setOnClickListener(this.mOnClickListener);
        this.SA.setOnClickListener(this.mOnClickListener);
        this.SC.setOnClickListener(this.mOnClickListener);
        this.SD.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.SM = aVar;
            this.SE = z;
            this.Ry = z2;
            this.mTitle.setText(aVar.RF);
            this.SB.setText(aVar.pq());
            if (z && !z2) {
                pC();
            } else {
                pA();
            }
        }
    }

    private boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    private void pA() {
        this.SD.setVisibility(8);
        this.SA.setPadding(0, 0, 0, 0);
        this.SB.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.SE && this.Ry && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        pB();
    }

    private void pB() {
        if (this.mContext != null && this.SC != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SC.getLayoutParams();
            if (this.SE) {
                if (this.Ry) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.SC.setLayoutParams(layoutParams);
        }
    }

    private void pC() {
        this.SD.setVisibility(0);
        this.SA.setPadding(SG, 0, 0, 0);
        this.SB.setPadding(0, 0, SG, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        pB();
    }

    private int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public void setCountDownNum(int i) {
        String str;
        if (this.SA != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.SA.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.SF = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bc(int i) {
    }

    public void c(int i, int i2, String str) {
        this.SH = true;
        this.SJ = i;
        this.SK = i2;
        this.mFrom = str;
        if (this.SE) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.mRootView.setLayoutParams(layoutParams);
            return;
        }
        d(i, i2, str);
    }

    private void d(int i, int i2, String str) {
        int i3 = 0;
        if (this.mContext != null && i != 0 && i2 != 0) {
            int af = l.af(this.mContext);
            if (TextUtils.equals(str, "NEWINDEX")) {
                af -= l.g(this.mContext, R.dimen.tbds88);
                i3 = (int) (0.5625d * af);
            } else if (!TextUtils.equals(str, "VIDEO_LIST")) {
                af = 0;
            } else if (this.Ry) {
                i3 = (int) (0.875f * af);
            } else {
                i3 = (int) (0.5625f * af);
            }
            if (i3 != 0) {
                int i4 = ((float) i) / ((float) i2) > ((float) af) / ((float) i3) ? (i2 * af) / i : i3;
                if (i4 > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = i4;
                    this.mRootView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void reset() {
        this.SH = false;
        this.mFrom = "";
        this.SJ = 0;
        this.SK = 0;
        this.SL = false;
    }

    public void pe() {
        this.SE = true;
        a(this.SM, this.SE, this.Ry);
        if (this.SH) {
            c(this.SJ, this.SK, this.mFrom);
        }
    }

    public void pf() {
        this.SE = false;
        a(this.SM, this.SE, this.Ry);
        if (this.SL && !this.Ry) {
            this.SL = false;
        } else if (this.SH) {
            c(this.SJ, this.SK, this.mFrom);
        }
    }
}
