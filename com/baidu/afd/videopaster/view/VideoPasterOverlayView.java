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
    private static final int Zj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Yg;
    private TextView Ze;
    private TextView Zf;
    private View Zg;
    private boolean Zh;
    private a Zi;
    private boolean Zk;
    private int Zl;
    private int Zm;
    private boolean Zn;
    private com.baidu.afd.videopaster.data.a Zo;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes8.dex */
    public interface a {
        void qg();

        void qh();

        void qi();

        void qj();

        void qk();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.Zk = false;
        this.Zl = 0;
        this.Zm = 0;
        this.Zn = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.Zi != null) {
                        VideoPasterOverlayView.this.Zi.qj();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.Zi != null) {
                        VideoPasterOverlayView.this.Zi.qg();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.Zi != null) {
                        VideoPasterOverlayView.this.Zi.qi();
                        VideoPasterOverlayView.this.Zn = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.Zi != null) {
                        VideoPasterOverlayView.this.Zi.qh();
                        VideoPasterOverlayView.this.Zn = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.Zi != null) {
                    VideoPasterOverlayView.this.Zi.qk();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.Zg = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Ze = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.Zf = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.Zf.setOnClickListener(this.mOnClickListener);
        this.Ze.setOnClickListener(this.mOnClickListener);
        this.Zg.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Zo = aVar;
            this.Zh = z;
            this.Yg = z2;
            this.mTitle.setText(aVar.Ym);
            this.Zf.setText(aVar.qp());
            if (z && !z2) {
                qA();
            } else {
                qy();
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

    private void qy() {
        this.mBack.setVisibility(8);
        this.Ze.setPadding(0, 0, 0, 0);
        this.Zf.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.Zh && this.Yg && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        qz();
    }

    private void qz() {
        if (this.mContext != null && this.Zg != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zg.getLayoutParams();
            if (this.Zh) {
                if (this.Yg) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.Zg.setLayoutParams(layoutParams);
        }
    }

    private void qA() {
        this.mBack.setVisibility(0);
        this.Ze.setPadding(Zj, 0, 0, 0);
        this.Zf.setPadding(0, 0, Zj, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        qz();
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
        if (this.Ze != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Ze.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.Zi = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aQ(int i) {
    }

    public void c(int i, int i2, String str) {
        this.Zk = true;
        this.Zl = i;
        this.Zm = i2;
        this.mFrom = str;
        if (this.Zh) {
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
            } else if (this.Yg) {
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
        this.Zk = false;
        this.mFrom = "";
        this.Zl = 0;
        this.Zm = 0;
        this.Zn = false;
    }

    public void qd() {
        this.Zh = true;
        a(this.Zo, this.Zh, this.Yg);
        if (this.Zk) {
            c(this.Zl, this.Zm, this.mFrom);
        }
    }

    public void qe() {
        this.Zh = false;
        a(this.Zo, this.Zh, this.Yg);
        if (this.Zn && !this.Yg) {
            this.Zn = false;
        } else if (this.Zk) {
            c(this.Zl, this.Zm, this.mFrom);
        }
    }
}
