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
/* loaded from: classes20.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int ZZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean YV;
    private TextView ZU;
    private TextView ZV;
    private View ZW;
    private boolean ZX;
    private a ZY;
    private boolean aaa;
    private int aab;
    private int aac;
    private boolean aae;
    private com.baidu.afd.videopaster.data.a aaf;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes20.dex */
    public interface a {
        void rL();

        void rM();

        void rN();

        void rO();

        void rP();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.aaa = false;
        this.aab = 0;
        this.aac = 0;
        this.aae = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.ZY != null) {
                        VideoPasterOverlayView.this.ZY.rO();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.ZY != null) {
                        VideoPasterOverlayView.this.ZY.rL();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.ZY != null) {
                        VideoPasterOverlayView.this.ZY.rN();
                        VideoPasterOverlayView.this.aae = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.ZY != null) {
                        VideoPasterOverlayView.this.ZY.rM();
                        VideoPasterOverlayView.this.aae = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.ZY != null) {
                    VideoPasterOverlayView.this.ZY.rP();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.ZW = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.ZU = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.ZV = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.ZV.setOnClickListener(this.mOnClickListener);
        this.ZU.setOnClickListener(this.mOnClickListener);
        this.ZW.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.aaf = aVar;
            this.ZX = z;
            this.YV = z2;
            this.mTitle.setText(aVar.Zb);
            this.ZV.setText(aVar.rU());
            if (z && !z2) {
                sf();
            } else {
                sd();
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

    private void sd() {
        this.mBack.setVisibility(8);
        this.ZU.setPadding(0, 0, 0, 0);
        this.ZV.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.ZX && this.YV && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        se();
    }

    private void se() {
        if (this.mContext != null && this.ZW != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZW.getLayoutParams();
            if (this.ZX) {
                if (this.YV) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.ZW.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.mBack.setVisibility(0);
        this.ZU.setPadding(ZZ, 0, 0, 0);
        this.ZV.setPadding(0, 0, ZZ, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        se();
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
        if (this.ZU != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.ZU.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.ZY = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aZ(int i) {
    }

    public void c(int i, int i2, String str) {
        this.aaa = true;
        this.aab = i;
        this.aac = i2;
        this.mFrom = str;
        if (this.ZX) {
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
            } else if (this.YV) {
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
        this.aaa = false;
        this.mFrom = "";
        this.aab = 0;
        this.aac = 0;
        this.aae = false;
    }

    public void rI() {
        this.ZX = true;
        a(this.aaf, this.ZX, this.YV);
        if (this.aaa) {
            c(this.aab, this.aac, this.mFrom);
        }
    }

    public void rJ() {
        this.ZX = false;
        a(this.aaf, this.ZX, this.YV);
        if (this.aae && !this.YV) {
            this.aae = false;
        } else if (this.aaa) {
            c(this.aab, this.aac, this.mFrom);
        }
    }
}
