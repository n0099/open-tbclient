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
    private static final int SF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Rx;
    private TextView SA;
    private View SB;
    private ImageView SC;
    private boolean SD;
    private a SE;
    private boolean SG;
    private int SH;
    private int SJ;
    private boolean SK;
    private com.baidu.afd.videopaster.data.a SL;
    private TextView Sz;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void ph();

        void pi();

        void pj();

        void pk();

        void pl();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.SG = false;
        this.SH = 0;
        this.SJ = 0;
        this.SK = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.SE != null) {
                        VideoPasterOverlayView.this.SE.pk();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.SE != null) {
                        VideoPasterOverlayView.this.SE.ph();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.SE != null) {
                        VideoPasterOverlayView.this.SE.pj();
                        VideoPasterOverlayView.this.SK = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.SE != null) {
                        VideoPasterOverlayView.this.SE.pi();
                        VideoPasterOverlayView.this.SK = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.SE != null) {
                    VideoPasterOverlayView.this.SE.pl();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.SB = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Sz = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.SA = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.SC = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.SA.setOnClickListener(this.mOnClickListener);
        this.Sz.setOnClickListener(this.mOnClickListener);
        this.SB.setOnClickListener(this.mOnClickListener);
        this.SC.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.SL = aVar;
            this.SD = z;
            this.Rx = z2;
            this.mTitle.setText(aVar.RE);
            this.SA.setText(aVar.pq());
            if (z && !z2) {
                pC();
            } else {
                pA();
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

    private void pA() {
        this.SC.setVisibility(8);
        this.Sz.setPadding(0, 0, 0, 0);
        this.SA.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.SD && this.Rx && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        pB();
    }

    private void pB() {
        if (this.mContext != null && this.SB != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.SB.getLayoutParams();
            if (this.SD) {
                if (this.Rx) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.SB.setLayoutParams(layoutParams);
        }
    }

    private void pC() {
        this.SC.setVisibility(0);
        this.Sz.setPadding(SF, 0, 0, 0);
        this.SA.setPadding(0, 0, SF, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        pB();
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
        if (this.Sz != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Sz.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.SE = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bc(int i) {
    }

    public void c(int i, int i2, String str) {
        this.SG = true;
        this.SH = i;
        this.SJ = i2;
        this.mFrom = str;
        if (this.SD) {
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
            } else if (this.Rx) {
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
        this.SG = false;
        this.mFrom = "";
        this.SH = 0;
        this.SJ = 0;
        this.SK = false;
    }

    public void pe() {
        this.SD = true;
        a(this.SL, this.SD, this.Rx);
        if (this.SG) {
            c(this.SH, this.SJ, this.mFrom);
        }
    }

    public void pf() {
        this.SD = false;
        a(this.SL, this.SD, this.Rx);
        if (this.SK && !this.Rx) {
            this.SK = false;
        } else if (this.SG) {
            c(this.SH, this.SJ, this.mFrom);
        }
    }
}
