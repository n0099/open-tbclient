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
/* loaded from: classes8.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int Yp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Xm;
    private TextView Yj;
    private TextView Yk;
    private View Yl;
    private ImageView Ym;
    private boolean Yn;
    private a Yo;
    private boolean Yq;
    private int Yr;
    private int Ys;
    private boolean Yt;
    private com.baidu.afd.videopaster.data.a Yu;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes8.dex */
    public interface a {
        void pJ();

        void pK();

        void pL();

        void pM();

        void pN();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.Yq = false;
        this.Yr = 0;
        this.Ys = 0;
        this.Yt = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.Yo != null) {
                        VideoPasterOverlayView.this.Yo.pM();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.Yo != null) {
                        VideoPasterOverlayView.this.Yo.pJ();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.Yo != null) {
                        VideoPasterOverlayView.this.Yo.pL();
                        VideoPasterOverlayView.this.Yt = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.Yo != null) {
                        VideoPasterOverlayView.this.Yo.pK();
                        VideoPasterOverlayView.this.Yt = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.Yo != null) {
                    VideoPasterOverlayView.this.Yo.pN();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.Yl = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Yj = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.Yk = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.Ym = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.Yk.setOnClickListener(this.mOnClickListener);
        this.Yj.setOnClickListener(this.mOnClickListener);
        this.Yl.setOnClickListener(this.mOnClickListener);
        this.Ym.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Yu = aVar;
            this.Yn = z;
            this.Xm = z2;
            this.mTitle.setText(aVar.Xs);
            this.Yk.setText(aVar.pS());
            if (z && !z2) {
                qd();
            } else {
                qb();
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

    private void qb() {
        this.Ym.setVisibility(8);
        this.Yj.setPadding(0, 0, 0, 0);
        this.Yk.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.Yn && this.Xm && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qc();
    }

    private void qc() {
        if (this.mContext != null && this.Yl != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yl.getLayoutParams();
            if (this.Yn) {
                if (this.Xm) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.Yl.setLayoutParams(layoutParams);
        }
    }

    private void qd() {
        this.Ym.setVisibility(0);
        this.Yj.setPadding(Yp, 0, 0, 0);
        this.Yk.setPadding(0, 0, Yp, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        qc();
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
        if (this.Yj != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Yj.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.Yo = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aJ(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Yq = true;
        this.Yr = i;
        this.Ys = i2;
        this.mFrom = str;
        if (this.Yn) {
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
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (TextUtils.equals(str, "NEWINDEX")) {
                equipmentWidth -= l.getDimens(this.mContext, R.dimen.tbds88);
                i3 = (int) (0.5625d * equipmentWidth);
            } else if (!TextUtils.equals(str, "VIDEO_LIST")) {
                equipmentWidth = 0;
            } else if (this.Xm) {
                i3 = (int) (0.875f * equipmentWidth);
            } else {
                i3 = (int) (0.5625f * equipmentWidth);
            }
            if (i3 != 0) {
                int i4 = ((float) i) / ((float) i2) > ((float) equipmentWidth) / ((float) i3) ? (i2 * equipmentWidth) / i : i3;
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
        this.Yq = false;
        this.mFrom = "";
        this.Yr = 0;
        this.Ys = 0;
        this.Yt = false;
    }

    public void pG() {
        this.Yn = true;
        a(this.Yu, this.Yn, this.Xm);
        if (this.Yq) {
            c(this.Yr, this.Ys, this.mFrom);
        }
    }

    public void pH() {
        this.Yn = false;
        a(this.Yu, this.Yn, this.Xm);
        if (this.Yt && !this.Xm) {
            this.Yt = false;
        } else if (this.Yq) {
            c(this.Yr, this.Ys, this.mFrom);
        }
    }
}
