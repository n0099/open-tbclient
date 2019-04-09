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
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int UW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds22);
    private boolean TP;
    private TextView UQ;
    private TextView UR;
    private View US;
    private ImageView UT;
    private boolean UU;
    private a UV;
    private boolean UX;
    private int UY;
    private int UZ;
    private boolean Va;
    private com.baidu.afd.videopaster.data.a Vb;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void qm();

        void qn();

        void qo();

        void qp();

        void qq();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.UX = false;
        this.UY = 0;
        this.UZ = 0;
        this.Va = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.UV != null) {
                        VideoPasterOverlayView.this.UV.qp();
                    }
                } else if (view.getId() == d.g.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.UV != null) {
                        VideoPasterOverlayView.this.UV.qm();
                    }
                } else if (view.getId() == d.g.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.UV != null) {
                        VideoPasterOverlayView.this.UV.qo();
                        VideoPasterOverlayView.this.Va = true;
                    }
                } else if (view.getId() == d.g.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.UV != null) {
                        VideoPasterOverlayView.this.UV.qn();
                        VideoPasterOverlayView.this.Va = true;
                    }
                } else if (view.getId() == d.g.video_paster_mask_back && VideoPasterOverlayView.this.UV != null) {
                    VideoPasterOverlayView.this.UV.qq();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(d.h.video_paster_overlay_layout, (ViewGroup) null);
        this.US = this.mRootView.findViewById(d.g.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_title);
        this.UQ = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_time_and_close);
        this.UR = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_detail);
        this.UT = (ImageView) this.mRootView.findViewById(d.g.video_paster_mask_back);
        this.UR.setOnClickListener(this.mOnClickListener);
        this.UQ.setOnClickListener(this.mOnClickListener);
        this.US.setOnClickListener(this.mOnClickListener);
        this.UT.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Vb = aVar;
            this.UU = z;
            this.TP = z2;
            this.mTitle.setText(aVar.TW);
            this.UR.setText(aVar.qv());
            if (z && !z2) {
                qH();
            } else {
                qF();
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
            Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    private void qF() {
        this.UT.setVisibility(8);
        this.UQ.setPadding(0, 0, 0, 0);
        this.UR.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.UU && this.TP && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qG();
    }

    private void qG() {
        if (this.mContext != null && this.US != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.US.getLayoutParams();
            if (this.UU) {
                if (this.TP) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.US.setLayoutParams(layoutParams);
        }
    }

    private void qH() {
        this.UT.setVisibility(0);
        this.UQ.setPadding(UW, 0, 0, 0);
        this.UR.setPadding(0, 0, UW, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        qG();
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
        if (this.UQ != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.UQ.setText(str + TbadkCoreApplication.getInst().getResources().getString(d.j.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.UV = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bj(int i) {
    }

    public void b(int i, int i2, String str) {
        this.UX = true;
        this.UY = i;
        this.UZ = i2;
        this.mFrom = str;
        if (this.UU) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.mRootView.setLayoutParams(layoutParams);
            return;
        }
        c(i, i2, str);
    }

    private void c(int i, int i2, String str) {
        int i3 = 0;
        if (this.mContext != null && i != 0 && i2 != 0) {
            int aO = l.aO(this.mContext);
            if (TextUtils.equals(str, "NEWINDEX")) {
                aO -= l.h(this.mContext, d.e.tbds88);
                i3 = (int) (0.5625d * aO);
            } else if (!TextUtils.equals(str, "VIDEO_LIST")) {
                aO = 0;
            } else if (this.TP) {
                i3 = (int) (0.875f * aO);
            } else {
                i3 = (int) (0.5625f * aO);
            }
            if (i3 != 0) {
                int i4 = ((float) i) / ((float) i2) > ((float) aO) / ((float) i3) ? (i2 * aO) / i : i3;
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
        this.UX = false;
        this.mFrom = "";
        this.UY = 0;
        this.UZ = 0;
        this.Va = false;
    }

    public void qj() {
        this.UU = true;
        a(this.Vb, this.UU, this.TP);
        if (this.UX) {
            b(this.UY, this.UZ, this.mFrom);
        }
    }

    public void qk() {
        this.UU = false;
        a(this.Vb, this.UU, this.TP);
        if (this.Va && !this.TP) {
            this.Va = false;
        } else if (this.UX) {
            b(this.UY, this.UZ, this.mFrom);
        }
    }
}
