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
    private static final int Ym = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Xj;
    private TextView Yg;
    private TextView Yh;
    private View Yi;
    private ImageView Yj;
    private boolean Yk;
    private a Yl;
    private boolean Yn;
    private int Yo;
    private int Yp;
    private boolean Yq;
    private com.baidu.afd.videopaster.data.a Yr;
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
        this.Yn = false;
        this.Yo = 0;
        this.Yp = 0;
        this.Yq = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.Yl != null) {
                        VideoPasterOverlayView.this.Yl.pM();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.Yl != null) {
                        VideoPasterOverlayView.this.Yl.pJ();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.Yl != null) {
                        VideoPasterOverlayView.this.Yl.pL();
                        VideoPasterOverlayView.this.Yq = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.Yl != null) {
                        VideoPasterOverlayView.this.Yl.pK();
                        VideoPasterOverlayView.this.Yq = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.Yl != null) {
                    VideoPasterOverlayView.this.Yl.pN();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.Yi = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Yg = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.Yh = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.Yj = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.Yh.setOnClickListener(this.mOnClickListener);
        this.Yg.setOnClickListener(this.mOnClickListener);
        this.Yi.setOnClickListener(this.mOnClickListener);
        this.Yj.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Yr = aVar;
            this.Yk = z;
            this.Xj = z2;
            this.mTitle.setText(aVar.Xp);
            this.Yh.setText(aVar.pS());
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
        this.Yj.setVisibility(8);
        this.Yg.setPadding(0, 0, 0, 0);
        this.Yh.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.Yk && this.Xj && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qc();
    }

    private void qc() {
        if (this.mContext != null && this.Yi != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yi.getLayoutParams();
            if (this.Yk) {
                if (this.Xj) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.Yi.setLayoutParams(layoutParams);
        }
    }

    private void qd() {
        this.Yj.setVisibility(0);
        this.Yg.setPadding(Ym, 0, 0, 0);
        this.Yh.setPadding(0, 0, Ym, 0);
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
        if (this.Yg != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Yg.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.Yl = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aJ(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Yn = true;
        this.Yo = i;
        this.Yp = i2;
        this.mFrom = str;
        if (this.Yk) {
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
            } else if (this.Xj) {
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
        this.Yn = false;
        this.mFrom = "";
        this.Yo = 0;
        this.Yp = 0;
        this.Yq = false;
    }

    public void pG() {
        this.Yk = true;
        a(this.Yr, this.Yk, this.Xj);
        if (this.Yn) {
            c(this.Yo, this.Yp, this.mFrom);
        }
    }

    public void pH() {
        this.Yk = false;
        a(this.Yr, this.Yk, this.Xj);
        if (this.Yq && !this.Xj) {
            this.Yq = false;
        } else if (this.Yn) {
            c(this.Yo, this.Yp, this.mFrom);
        }
    }
}
