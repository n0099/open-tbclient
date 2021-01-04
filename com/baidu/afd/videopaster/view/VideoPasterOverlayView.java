package com.baidu.afd.videopaster.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int acc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean aaX;
    private TextView abX;
    private TextView abY;
    private View abZ;
    private boolean aca;
    private a acb;
    private int acd;
    private boolean ace;
    private int acf;
    private int acg;
    private boolean ach;
    private com.baidu.afd.videopaster.data.a aci;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes.dex */
    public interface a {
        void ro();

        void rp();

        void rq();

        void rr();

        void rs();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.acd = 0;
        this.ace = false;
        this.acf = 0;
        this.acg = 0;
        this.ach = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.acb != null) {
                        VideoPasterOverlayView.this.acb.rr();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.acb != null) {
                        VideoPasterOverlayView.this.acb.ro();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.acb != null) {
                        VideoPasterOverlayView.this.acb.rq();
                        VideoPasterOverlayView.this.ach = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.acb != null) {
                        VideoPasterOverlayView.this.acb.rp();
                        VideoPasterOverlayView.this.ach = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.acb != null) {
                    VideoPasterOverlayView.this.acb.rs();
                }
            }
        };
        this.mContext = context;
        this.acd = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.abZ = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.abX = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.abY = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.abY.setOnClickListener(this.mOnClickListener);
        this.abX.setOnClickListener(this.mOnClickListener);
        this.abZ.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.aci = aVar;
            this.aca = z;
            this.aaX = z2;
            this.mTitle.setText(aVar.abe);
            this.abY.setText(aVar.rx());
            if (z && !z2) {
                rI();
            } else {
                rG();
            }
        }
    }

    private boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
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

    private void rG() {
        this.mBack.setVisibility(8);
        this.abX.setPadding(0, 0, 0, 0);
        this.abY.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.aca && this.aaX && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.acd);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        rH();
    }

    private void rH() {
        if (this.mContext != null && this.abZ != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abZ.getLayoutParams();
            if (this.aca) {
                if (this.aaX) {
                    layoutParams.setMargins(0, 0, 0, this.acd);
                } else {
                    layoutParams.setMargins(this.acd, 0, this.acd, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.abZ.setLayoutParams(layoutParams);
        }
    }

    private void rI() {
        this.mBack.setVisibility(0);
        this.abX.setPadding(acc, 0, 0, 0);
        this.abY.setPadding(0, 0, acc, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        rH();
    }

    private int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public void setCountDownNum(int i) {
        String str;
        if (this.abX != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.abX.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.acb = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void be(int i) {
    }

    public void d(int i, int i2, String str) {
        this.ace = true;
        this.acf = i;
        this.acg = i2;
        this.mFrom = str;
        if (this.aca) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.mRootView.setLayoutParams(layoutParams);
            return;
        }
        e(i, i2, str);
    }

    private void e(int i, int i2, String str) {
        int i3;
        if (this.mContext != null && i != 0 && i2 != 0) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (TextUtils.equals(str, "NEWINDEX")) {
                int dimens = equipmentWidth - l.getDimens(this.mContext, R.dimen.tbds88);
                i3 = (int) (0.5625d * dimens);
                equipmentWidth = dimens;
            } else if (!TextUtils.equals(str, "VIDEO_LIST")) {
                i3 = 0;
                equipmentWidth = 0;
            } else if (this.aaX) {
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
        this.ace = false;
        this.mFrom = "";
        this.acf = 0;
        this.acg = 0;
        this.ach = false;
    }

    public void rl() {
        this.aca = true;
        a(this.aci, this.aca, this.aaX);
        if (this.ace) {
            d(this.acf, this.acg, this.mFrom);
        }
    }

    public void rm() {
        this.aca = false;
        a(this.aci, this.aca, this.aaX);
        if (this.ach && !this.aaX) {
            this.ach = false;
        } else if (this.ace) {
            d(this.acf, this.acg, this.mFrom);
        }
    }
}
