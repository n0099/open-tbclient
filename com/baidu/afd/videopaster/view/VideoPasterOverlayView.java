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
    private static final int UV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds22);
    private boolean TO;
    private TextView UO;
    private TextView UQ;
    private View UR;
    private ImageView US;
    private boolean UT;
    private a UU;
    private boolean UW;
    private int UX;
    private int UY;
    private boolean UZ;
    private com.baidu.afd.videopaster.data.a Va;
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
        this.UW = false;
        this.UX = 0;
        this.UY = 0;
        this.UZ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.UU != null) {
                        VideoPasterOverlayView.this.UU.qp();
                    }
                } else if (view.getId() == d.g.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.UU != null) {
                        VideoPasterOverlayView.this.UU.qm();
                    }
                } else if (view.getId() == d.g.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.UU != null) {
                        VideoPasterOverlayView.this.UU.qo();
                        VideoPasterOverlayView.this.UZ = true;
                    }
                } else if (view.getId() == d.g.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.UU != null) {
                        VideoPasterOverlayView.this.UU.qn();
                        VideoPasterOverlayView.this.UZ = true;
                    }
                } else if (view.getId() == d.g.video_paster_mask_back && VideoPasterOverlayView.this.UU != null) {
                    VideoPasterOverlayView.this.UU.qq();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(d.h.video_paster_overlay_layout, (ViewGroup) null);
        this.UR = this.mRootView.findViewById(d.g.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_title);
        this.UO = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_time_and_close);
        this.UQ = (TextView) this.mRootView.findViewById(d.g.video_paster_overlay_detail);
        this.US = (ImageView) this.mRootView.findViewById(d.g.video_paster_mask_back);
        this.UQ.setOnClickListener(this.mOnClickListener);
        this.UO.setOnClickListener(this.mOnClickListener);
        this.UR.setOnClickListener(this.mOnClickListener);
        this.US.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Va = aVar;
            this.UT = z;
            this.TO = z2;
            this.mTitle.setText(aVar.TV);
            this.UQ.setText(aVar.qv());
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
        this.US.setVisibility(8);
        this.UO.setPadding(0, 0, 0, 0);
        this.UQ.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.UT && this.TO && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qG();
    }

    private void qG() {
        if (this.mContext != null && this.UR != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.UR.getLayoutParams();
            if (this.UT) {
                if (this.TO) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.UR.setLayoutParams(layoutParams);
        }
    }

    private void qH() {
        this.US.setVisibility(0);
        this.UO.setPadding(UV, 0, 0, 0);
        this.UQ.setPadding(0, 0, UV, 0);
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
        if (this.UO != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.UO.setText(str + TbadkCoreApplication.getInst().getResources().getString(d.j.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.UU = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bk(int i) {
    }

    public void b(int i, int i2, String str) {
        this.UW = true;
        this.UX = i;
        this.UY = i2;
        this.mFrom = str;
        if (this.UT) {
            this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
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
            } else if (this.TO) {
                i3 = (int) (0.875f * aO);
            } else {
                i3 = (int) (0.5625f * aO);
            }
            if (i3 != 0) {
                if (i / i2 > aO / i3) {
                    i3 = (i2 * aO) / i;
                }
                if (i3 > 0) {
                    this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, i3));
                }
            }
        }
    }

    public void reset() {
        this.UW = false;
        this.mFrom = "";
        this.UX = 0;
        this.UY = 0;
        this.UZ = false;
    }

    public void qj() {
        this.UT = true;
        a(this.Va, this.UT, this.TO);
    }

    public void qk() {
        this.UT = false;
        a(this.Va, this.UT, this.TO);
        if (this.UZ && !this.TO) {
            this.UZ = false;
        } else if (this.UW) {
            b(this.UX, this.UY, this.mFrom);
        }
    }
}
