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
/* loaded from: classes21.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int abt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean aao;
    private TextView abn;
    private TextView abo;
    private View abp;
    private boolean abq;
    private a abr;
    private boolean abu;
    private int abv;
    private int abw;
    private boolean abx;
    private com.baidu.afd.videopaster.data.a aby;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes21.dex */
    public interface a {
        void rN();

        void rO();

        void rP();

        void rQ();

        void rR();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.abu = false;
        this.abv = 0;
        this.abw = 0;
        this.abx = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.abr != null) {
                        VideoPasterOverlayView.this.abr.rQ();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.abr != null) {
                        VideoPasterOverlayView.this.abr.rN();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.abr != null) {
                        VideoPasterOverlayView.this.abr.rP();
                        VideoPasterOverlayView.this.abx = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.abr != null) {
                        VideoPasterOverlayView.this.abr.rO();
                        VideoPasterOverlayView.this.abx = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.abr != null) {
                    VideoPasterOverlayView.this.abr.rR();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.abp = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.abn = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.abo = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.abo.setOnClickListener(this.mOnClickListener);
        this.abn.setOnClickListener(this.mOnClickListener);
        this.abp.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.aby = aVar;
            this.abq = z;
            this.aao = z2;
            this.mTitle.setText(aVar.aau);
            this.abo.setText(aVar.rW());
            if (z && !z2) {
                sh();
            } else {
                sf();
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

    private void sf() {
        this.mBack.setVisibility(8);
        this.abn.setPadding(0, 0, 0, 0);
        this.abo.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.abq && this.aao && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        sg();
    }

    private void sg() {
        if (this.mContext != null && this.abp != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abp.getLayoutParams();
            if (this.abq) {
                if (this.aao) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.abp.setLayoutParams(layoutParams);
        }
    }

    private void sh() {
        this.mBack.setVisibility(0);
        this.abn.setPadding(abt, 0, 0, 0);
        this.abo.setPadding(0, 0, abt, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        sg();
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
        if (this.abn != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.abn.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.abr = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void bd(int i) {
    }

    public void d(int i, int i2, String str) {
        this.abu = true;
        this.abv = i;
        this.abw = i2;
        this.mFrom = str;
        if (this.abq) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.mRootView.setLayoutParams(layoutParams);
            return;
        }
        e(i, i2, str);
    }

    private void e(int i, int i2, String str) {
        int i3 = 0;
        if (this.mContext != null && i != 0 && i2 != 0) {
            int equipmentWidth = l.getEquipmentWidth(this.mContext);
            if (TextUtils.equals(str, "NEWINDEX")) {
                equipmentWidth -= l.getDimens(this.mContext, R.dimen.tbds88);
                i3 = (int) (0.5625d * equipmentWidth);
            } else if (!TextUtils.equals(str, "VIDEO_LIST")) {
                equipmentWidth = 0;
            } else if (this.aao) {
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
        this.abu = false;
        this.mFrom = "";
        this.abv = 0;
        this.abw = 0;
        this.abx = false;
    }

    public void rK() {
        this.abq = true;
        a(this.aby, this.abq, this.aao);
        if (this.abu) {
            d(this.abv, this.abw, this.mFrom);
        }
    }

    public void rL() {
        this.abq = false;
        a(this.aby, this.abq, this.aao);
        if (this.abx && !this.aao) {
            this.abx = false;
        } else if (this.abu) {
            d(this.abv, this.abw, this.mFrom);
        }
    }
}
