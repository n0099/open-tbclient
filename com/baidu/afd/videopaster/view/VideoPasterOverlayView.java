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
    private static final int BR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean AM;
    private TextView BL;
    private TextView BM;
    private View BN;
    private ImageView BO;
    private boolean BP;
    private a BQ;
    private boolean BS;
    private int BT;
    private int BU;
    private boolean BV;
    private com.baidu.afd.videopaster.data.a BW;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void kA();

        void kB();

        void kC();

        void ky();

        void kz();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.BS = false;
        this.BT = 0;
        this.BU = 0;
        this.BV = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.BQ != null) {
                        VideoPasterOverlayView.this.BQ.kB();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.BQ != null) {
                        VideoPasterOverlayView.this.BQ.ky();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.BQ != null) {
                        VideoPasterOverlayView.this.BQ.kA();
                        VideoPasterOverlayView.this.BV = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.BQ != null) {
                        VideoPasterOverlayView.this.BQ.kz();
                        VideoPasterOverlayView.this.BV = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.BQ != null) {
                    VideoPasterOverlayView.this.BQ.kC();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.BN = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.BL = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.BM = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.BO = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.BM.setOnClickListener(this.mOnClickListener);
        this.BL.setOnClickListener(this.mOnClickListener);
        this.BN.setOnClickListener(this.mOnClickListener);
        this.BO.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.BW = aVar;
            this.BP = z;
            this.AM = z2;
            this.mTitle.setText(aVar.AT);
            this.BM.setText(aVar.kH());
            if (z && !z2) {
                kS();
            } else {
                kQ();
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

    private void kQ() {
        this.BO.setVisibility(8);
        this.BL.setPadding(0, 0, 0, 0);
        this.BM.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.BP && this.AM && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        kR();
    }

    private void kR() {
        if (this.mContext != null && this.BN != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.BN.getLayoutParams();
            if (this.BP) {
                if (this.AM) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.BN.setLayoutParams(layoutParams);
        }
    }

    private void kS() {
        this.BO.setVisibility(0);
        this.BL.setPadding(BR, 0, 0, 0);
        this.BM.setPadding(0, 0, BR, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        kR();
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
        if (this.BL != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.BL.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.BQ = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void ar(int i) {
    }

    public void c(int i, int i2, String str) {
        this.BS = true;
        this.BT = i;
        this.BU = i2;
        this.mFrom = str;
        if (this.BP) {
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
            } else if (this.AM) {
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
        this.BS = false;
        this.mFrom = "";
        this.BT = 0;
        this.BU = 0;
        this.BV = false;
    }

    public void kv() {
        this.BP = true;
        a(this.BW, this.BP, this.AM);
        if (this.BS) {
            c(this.BT, this.BU, this.mFrom);
        }
    }

    public void kw() {
        this.BP = false;
        a(this.BW, this.BP, this.AM);
        if (this.BV && !this.AM) {
            this.BV = false;
        } else if (this.BS) {
            c(this.BT, this.BU, this.mFrom);
        }
    }
}
