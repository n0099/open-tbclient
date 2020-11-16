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
    private static final int aaw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Zs;
    private boolean aaA;
    private com.baidu.afd.videopaster.data.a aaB;
    private TextView aar;
    private TextView aas;
    private View aat;
    private boolean aau;
    private a aav;
    private boolean aax;
    private int aay;
    private int aaz;
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
        this.aax = false;
        this.aay = 0;
        this.aaz = 0;
        this.aaA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.aav != null) {
                        VideoPasterOverlayView.this.aav.rO();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.aav != null) {
                        VideoPasterOverlayView.this.aav.rL();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.aav != null) {
                        VideoPasterOverlayView.this.aav.rN();
                        VideoPasterOverlayView.this.aaA = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.aav != null) {
                        VideoPasterOverlayView.this.aav.rM();
                        VideoPasterOverlayView.this.aaA = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.aav != null) {
                    VideoPasterOverlayView.this.aav.rP();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.aat = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.aar = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.aas = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.aas.setOnClickListener(this.mOnClickListener);
        this.aar.setOnClickListener(this.mOnClickListener);
        this.aat.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.aaB = aVar;
            this.aau = z;
            this.Zs = z2;
            this.mTitle.setText(aVar.Zy);
            this.aas.setText(aVar.rU());
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
        this.aar.setPadding(0, 0, 0, 0);
        this.aas.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.aau && this.Zs && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        se();
    }

    private void se() {
        if (this.mContext != null && this.aat != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aat.getLayoutParams();
            if (this.aau) {
                if (this.Zs) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.aat.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.mBack.setVisibility(0);
        this.aar.setPadding(aaw, 0, 0, 0);
        this.aas.setPadding(0, 0, aaw, 0);
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
        if (this.aar != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.aar.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.aav = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aZ(int i) {
    }

    public void c(int i, int i2, String str) {
        this.aax = true;
        this.aay = i;
        this.aaz = i2;
        this.mFrom = str;
        if (this.aau) {
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
            } else if (this.Zs) {
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
        this.aax = false;
        this.mFrom = "";
        this.aay = 0;
        this.aaz = 0;
        this.aaA = false;
    }

    public void rI() {
        this.aau = true;
        a(this.aaB, this.aau, this.Zs);
        if (this.aax) {
            c(this.aay, this.aaz, this.mFrom);
        }
    }

    public void rJ() {
        this.aau = false;
        a(this.aaB, this.aau, this.Zs);
        if (this.aaA && !this.Zs) {
            this.aaA = false;
        } else if (this.aax) {
            c(this.aay, this.aaz, this.mFrom);
        }
    }
}
