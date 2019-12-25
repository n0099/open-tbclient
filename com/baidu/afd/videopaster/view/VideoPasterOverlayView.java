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
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int Ex = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Dq;
    private int EA;
    private boolean EB;
    private com.baidu.afd.videopaster.data.a ED;
    private TextView Er;
    private TextView Es;
    private View Et;
    private ImageView Eu;
    private boolean Ev;
    private a Ew;
    private boolean Ey;
    private int Ez;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes5.dex */
    public interface a {
        void kP();

        void kQ();

        void kR();

        void kS();

        void kT();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.Ey = false;
        this.Ez = 0;
        this.EA = 0;
        this.EB = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.Ew != null) {
                        VideoPasterOverlayView.this.Ew.kS();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.Ew != null) {
                        VideoPasterOverlayView.this.Ew.kP();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.Ew != null) {
                        VideoPasterOverlayView.this.Ew.kR();
                        VideoPasterOverlayView.this.EB = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.Ew != null) {
                        VideoPasterOverlayView.this.Ew.kQ();
                        VideoPasterOverlayView.this.EB = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.Ew != null) {
                    VideoPasterOverlayView.this.Ew.kT();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.Et = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Er = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.Es = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.Eu = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.Es.setOnClickListener(this.mOnClickListener);
        this.Er.setOnClickListener(this.mOnClickListener);
        this.Et.setOnClickListener(this.mOnClickListener);
        this.Eu.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.ED = aVar;
            this.Ev = z;
            this.Dq = z2;
            this.mTitle.setText(aVar.Dw);
            this.Es.setText(aVar.kY());
            if (z && !z2) {
                lj();
            } else {
                lh();
            }
        }
    }

    private boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", PraiseDataPassUtil.KEY_FROM_OS);
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

    private void lh() {
        this.Eu.setVisibility(8);
        this.Er.setPadding(0, 0, 0, 0);
        this.Es.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.Ev && this.Dq && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        li();
    }

    private void li() {
        if (this.mContext != null && this.Et != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Et.getLayoutParams();
            if (this.Ev) {
                if (this.Dq) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.Et.setLayoutParams(layoutParams);
        }
    }

    private void lj() {
        this.Eu.setVisibility(0);
        this.Er.setPadding(Ex, 0, 0, 0);
        this.Es.setPadding(0, 0, Ex, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        li();
    }

    private int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public void setCountDownNum(int i) {
        String str;
        if (this.Er != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Er.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.Ew = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void au(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Ey = true;
        this.Ez = i;
        this.EA = i2;
        this.mFrom = str;
        if (this.Ev) {
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
            } else if (this.Dq) {
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
        this.Ey = false;
        this.mFrom = "";
        this.Ez = 0;
        this.EA = 0;
        this.EB = false;
    }

    public void kM() {
        this.Ev = true;
        a(this.ED, this.Ev, this.Dq);
        if (this.Ey) {
            c(this.Ez, this.EA, this.mFrom);
        }
    }

    public void kN() {
        this.Ev = false;
        a(this.ED, this.Ev, this.Dq);
        if (this.EB && !this.Dq) {
            this.EB = false;
        } else if (this.Ey) {
            c(this.Ez, this.EA, this.mFrom);
        }
    }
}
