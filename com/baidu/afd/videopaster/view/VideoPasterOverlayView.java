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
/* loaded from: classes15.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int YZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean XV;
    private TextView YU;
    private TextView YV;
    private View YW;
    private boolean YX;
    private a YY;
    private boolean Za;
    private int Zb;
    private int Zc;
    private boolean Ze;
    private com.baidu.afd.videopaster.data.a Zf;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes15.dex */
    public interface a {
        void qh();

        void qi();

        void qj();

        void qk();

        void ql();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.Za = false;
        this.Zb = 0;
        this.Zc = 0;
        this.Ze = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.YY != null) {
                        VideoPasterOverlayView.this.YY.qk();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.YY != null) {
                        VideoPasterOverlayView.this.YY.qh();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.YY != null) {
                        VideoPasterOverlayView.this.YY.qj();
                        VideoPasterOverlayView.this.Ze = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.YY != null) {
                        VideoPasterOverlayView.this.YY.qi();
                        VideoPasterOverlayView.this.Ze = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.YY != null) {
                    VideoPasterOverlayView.this.YY.ql();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.YW = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.YU = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.YV = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.YV.setOnClickListener(this.mOnClickListener);
        this.YU.setOnClickListener(this.mOnClickListener);
        this.YW.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Zf = aVar;
            this.YX = z;
            this.XV = z2;
            this.mTitle.setText(aVar.Yb);
            this.YV.setText(aVar.qq());
            if (z && !z2) {
                qB();
            } else {
                qz();
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

    private void qz() {
        this.mBack.setVisibility(8);
        this.YU.setPadding(0, 0, 0, 0);
        this.YV.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.YX && this.XV && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qA();
    }

    private void qA() {
        if (this.mContext != null && this.YW != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YW.getLayoutParams();
            if (this.YX) {
                if (this.XV) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.YW.setLayoutParams(layoutParams);
        }
    }

    private void qB() {
        this.mBack.setVisibility(0);
        this.YU.setPadding(YZ, 0, 0, 0);
        this.YV.setPadding(0, 0, YZ, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        qA();
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
        if (this.YU != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.YU.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.YY = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aS(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Za = true;
        this.Zb = i;
        this.Zc = i2;
        this.mFrom = str;
        if (this.YX) {
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
            } else if (this.XV) {
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
        this.Za = false;
        this.mFrom = "";
        this.Zb = 0;
        this.Zc = 0;
        this.Ze = false;
    }

    public void qe() {
        this.YX = true;
        a(this.Zf, this.YX, this.XV);
        if (this.Za) {
            c(this.Zb, this.Zc, this.mFrom);
        }
    }

    public void qf() {
        this.YX = false;
        a(this.Zf, this.YX, this.XV);
        if (this.Ze && !this.XV) {
            this.Ze = false;
        } else if (this.Za) {
            c(this.Zb, this.Zc, this.mFrom);
        }
    }
}
