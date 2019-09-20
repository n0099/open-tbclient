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
    private static final int SZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean RQ;
    private TextView ST;
    private TextView SU;
    private View SV;
    private ImageView SW;
    private boolean SX;
    private a SY;
    private boolean Ta;
    private int Tb;
    private int Tc;
    private boolean Td;
    private com.baidu.afd.videopaster.data.a Te;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void pD();

        void pE();

        void pF();

        void pG();

        void pH();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.Ta = false;
        this.Tb = 0;
        this.Tc = 0;
        this.Td = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.SY != null) {
                        VideoPasterOverlayView.this.SY.pG();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.SY != null) {
                        VideoPasterOverlayView.this.SY.pD();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.SY != null) {
                        VideoPasterOverlayView.this.SY.pF();
                        VideoPasterOverlayView.this.Td = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.SY != null) {
                        VideoPasterOverlayView.this.SY.pE();
                        VideoPasterOverlayView.this.Td = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.SY != null) {
                    VideoPasterOverlayView.this.SY.pH();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.SV = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.ST = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.SU = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.SW = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.SU.setOnClickListener(this.mOnClickListener);
        this.ST.setOnClickListener(this.mOnClickListener);
        this.SV.setOnClickListener(this.mOnClickListener);
        this.SW.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Te = aVar;
            this.SX = z;
            this.RQ = z2;
            this.mTitle.setText(aVar.RY);
            this.SU.setText(aVar.pM());
            if (z && !z2) {
                pY();
            } else {
                pW();
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

    private void pW() {
        this.SW.setVisibility(8);
        this.ST.setPadding(0, 0, 0, 0);
        this.SU.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.SX && this.RQ && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        pX();
    }

    private void pX() {
        if (this.mContext != null && this.SV != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SV.getLayoutParams();
            if (this.SX) {
                if (this.RQ) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.SV.setLayoutParams(layoutParams);
        }
    }

    private void pY() {
        this.SW.setVisibility(0);
        this.ST.setPadding(SZ, 0, 0, 0);
        this.SU.setPadding(0, 0, SZ, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        pX();
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
        if (this.ST != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.ST.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.SY = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bc(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Ta = true;
        this.Tb = i;
        this.Tc = i2;
        this.mFrom = str;
        if (this.SX) {
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
            } else if (this.RQ) {
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
        this.Ta = false;
        this.mFrom = "";
        this.Tb = 0;
        this.Tc = 0;
        this.Td = false;
    }

    public void pA() {
        this.SX = true;
        a(this.Te, this.SX, this.RQ);
        if (this.Ta) {
            c(this.Tb, this.Tc, this.mFrom);
        }
    }

    public void pB() {
        this.SX = false;
        a(this.Te, this.SX, this.RQ);
        if (this.Td && !this.RQ) {
            this.Td = false;
        } else if (this.Ta) {
            c(this.Tb, this.Tc, this.mFrom);
        }
    }
}
