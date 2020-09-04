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
    private static final int ZH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean YD;
    private TextView ZC;
    private TextView ZD;
    private View ZE;
    private boolean ZF;
    private a ZG;
    private boolean ZI;
    private int ZJ;
    private int ZK;
    private boolean ZL;
    private com.baidu.afd.videopaster.data.a ZM;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes15.dex */
    public interface a {
        void rG();

        void rH();

        void rI();

        void rJ();

        void rK();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.ZI = false;
        this.ZJ = 0;
        this.ZK = 0;
        this.ZL = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.ZG != null) {
                        VideoPasterOverlayView.this.ZG.rJ();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.ZG != null) {
                        VideoPasterOverlayView.this.ZG.rG();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.ZG != null) {
                        VideoPasterOverlayView.this.ZG.rI();
                        VideoPasterOverlayView.this.ZL = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.ZG != null) {
                        VideoPasterOverlayView.this.ZG.rH();
                        VideoPasterOverlayView.this.ZL = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.ZG != null) {
                    VideoPasterOverlayView.this.ZG.rK();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.ZE = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.ZC = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.ZD = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.ZD.setOnClickListener(this.mOnClickListener);
        this.ZC.setOnClickListener(this.mOnClickListener);
        this.ZE.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.ZM = aVar;
            this.ZF = z;
            this.YD = z2;
            this.mTitle.setText(aVar.YJ);
            this.ZD.setText(aVar.rP());
            if (z && !z2) {
                sa();
            } else {
                rY();
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

    private void rY() {
        this.mBack.setVisibility(8);
        this.ZC.setPadding(0, 0, 0, 0);
        this.ZD.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.ZF && this.YD && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        rZ();
    }

    private void rZ() {
        if (this.mContext != null && this.ZE != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZE.getLayoutParams();
            if (this.ZF) {
                if (this.YD) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.ZE.setLayoutParams(layoutParams);
        }
    }

    private void sa() {
        this.mBack.setVisibility(0);
        this.ZC.setPadding(ZH, 0, 0, 0);
        this.ZD.setPadding(0, 0, ZH, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        rZ();
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
        if (this.ZC != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.ZC.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.ZG = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aV(int i) {
    }

    public void c(int i, int i2, String str) {
        this.ZI = true;
        this.ZJ = i;
        this.ZK = i2;
        this.mFrom = str;
        if (this.ZF) {
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
            } else if (this.YD) {
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
        this.ZI = false;
        this.mFrom = "";
        this.ZJ = 0;
        this.ZK = 0;
        this.ZL = false;
    }

    public void rD() {
        this.ZF = true;
        a(this.ZM, this.ZF, this.YD);
        if (this.ZI) {
            c(this.ZJ, this.ZK, this.mFrom);
        }
    }

    public void rE() {
        this.ZF = false;
        a(this.ZM, this.ZF, this.YD);
        if (this.ZL && !this.YD) {
            this.ZL = false;
        } else if (this.ZI) {
            c(this.ZJ, this.ZK, this.mFrom);
        }
    }
}
