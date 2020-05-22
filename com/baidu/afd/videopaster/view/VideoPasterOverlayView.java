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
    private static final int YE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean XB;
    private TextView YA;
    private View YB;
    private boolean YC;
    private a YD;
    private boolean YF;
    private int YG;
    private int YH;
    private boolean YI;
    private com.baidu.afd.videopaster.data.a YJ;
    private TextView Yz;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes8.dex */
    public interface a {
        void pP();

        void pQ();

        void pR();

        void pS();

        void pT();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.YF = false;
        this.YG = 0;
        this.YH = 0;
        this.YI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.YD != null) {
                        VideoPasterOverlayView.this.YD.pS();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.YD != null) {
                        VideoPasterOverlayView.this.YD.pP();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.YD != null) {
                        VideoPasterOverlayView.this.YD.pR();
                        VideoPasterOverlayView.this.YI = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.YD != null) {
                        VideoPasterOverlayView.this.YD.pQ();
                        VideoPasterOverlayView.this.YI = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.YD != null) {
                    VideoPasterOverlayView.this.YD.pT();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.YB = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Yz = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.YA = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.YA.setOnClickListener(this.mOnClickListener);
        this.Yz.setOnClickListener(this.mOnClickListener);
        this.YB.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.YJ = aVar;
            this.YC = z;
            this.XB = z2;
            this.mTitle.setText(aVar.XH);
            this.YA.setText(aVar.pY());
            if (z && !z2) {
                qj();
            } else {
                qh();
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

    private void qh() {
        this.mBack.setVisibility(8);
        this.Yz.setPadding(0, 0, 0, 0);
        this.YA.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.YC && this.XB && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qi();
    }

    private void qi() {
        if (this.mContext != null && this.YB != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YB.getLayoutParams();
            if (this.YC) {
                if (this.XB) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.YB.setLayoutParams(layoutParams);
        }
    }

    private void qj() {
        this.mBack.setVisibility(0);
        this.Yz.setPadding(YE, 0, 0, 0);
        this.YA.setPadding(0, 0, YE, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        qi();
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
        if (this.Yz != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Yz.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.YD = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aK(int i) {
    }

    public void c(int i, int i2, String str) {
        this.YF = true;
        this.YG = i;
        this.YH = i2;
        this.mFrom = str;
        if (this.YC) {
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
            } else if (this.XB) {
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
        this.YF = false;
        this.mFrom = "";
        this.YG = 0;
        this.YH = 0;
        this.YI = false;
    }

    public void pM() {
        this.YC = true;
        a(this.YJ, this.YC, this.XB);
        if (this.YF) {
            c(this.YG, this.YH, this.mFrom);
        }
    }

    public void pN() {
        this.YC = false;
        a(this.YJ, this.YC, this.XB);
        if (this.YI && !this.XB) {
            this.YI = false;
        } else if (this.YF) {
            c(this.YG, this.YH, this.mFrom);
        }
    }
}
