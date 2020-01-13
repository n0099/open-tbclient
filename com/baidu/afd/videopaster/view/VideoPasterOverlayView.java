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
/* loaded from: classes6.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int ED = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Dv;
    private boolean EA;
    private a EB;
    private boolean EE;
    private int EF;
    private int EG;
    private boolean EH;
    private com.baidu.afd.videopaster.data.a EI;
    private TextView Ew;
    private TextView Ex;
    private View Ey;
    private ImageView Ez;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes6.dex */
    public interface a {
        void kQ();

        void kR();

        void kS();

        void kT();

        void kU();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.EE = false;
        this.EF = 0;
        this.EG = 0;
        this.EH = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.EB != null) {
                        VideoPasterOverlayView.this.EB.kT();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.EB != null) {
                        VideoPasterOverlayView.this.EB.kQ();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.EB != null) {
                        VideoPasterOverlayView.this.EB.kS();
                        VideoPasterOverlayView.this.EH = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.EB != null) {
                        VideoPasterOverlayView.this.EB.kR();
                        VideoPasterOverlayView.this.EH = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.EB != null) {
                    VideoPasterOverlayView.this.EB.kU();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.Ey = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.Ew = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.Ex = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.Ez = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.Ex.setOnClickListener(this.mOnClickListener);
        this.Ew.setOnClickListener(this.mOnClickListener);
        this.Ey.setOnClickListener(this.mOnClickListener);
        this.Ez.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.EI = aVar;
            this.EA = z;
            this.Dv = z2;
            this.mTitle.setText(aVar.DC);
            this.Ex.setText(aVar.kZ());
            if (z && !z2) {
                lk();
            } else {
                li();
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

    private void li() {
        this.Ez.setVisibility(8);
        this.Ew.setPadding(0, 0, 0, 0);
        this.Ex.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.EA && this.Dv && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        lj();
    }

    private void lj() {
        if (this.mContext != null && this.Ey != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Ey.getLayoutParams();
            if (this.EA) {
                if (this.Dv) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.Ey.setLayoutParams(layoutParams);
        }
    }

    private void lk() {
        this.Ez.setVisibility(0);
        this.Ew.setPadding(ED, 0, 0, 0);
        this.Ex.setPadding(0, 0, ED, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        lj();
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
        if (this.Ew != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.Ew.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.EB = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void au(int i) {
    }

    public void c(int i, int i2, String str) {
        this.EE = true;
        this.EF = i;
        this.EG = i2;
        this.mFrom = str;
        if (this.EA) {
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
            } else if (this.Dv) {
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
        this.EE = false;
        this.mFrom = "";
        this.EF = 0;
        this.EG = 0;
        this.EH = false;
    }

    public void kN() {
        this.EA = true;
        a(this.EI, this.EA, this.Dv);
        if (this.EE) {
            c(this.EF, this.EG, this.mFrom);
        }
    }

    public void kO() {
        this.EA = false;
        a(this.EI, this.EA, this.Dv);
        if (this.EH && !this.Dv) {
            this.EH = false;
        } else if (this.EE) {
            c(this.EF, this.EG, this.mFrom);
        }
    }
}
