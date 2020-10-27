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
    private static final int aar = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean Zn;
    private TextView aam;
    private TextView aan;
    private View aao;
    private boolean aap;
    private a aaq;
    private boolean aas;
    private int aat;
    private int aau;
    private boolean aav;
    private com.baidu.afd.videopaster.data.a aaw;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes21.dex */
    public interface a {
        void rL();

        void rM();

        void rN();

        void rO();

        void rP();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.aas = false;
        this.aat = 0;
        this.aau = 0;
        this.aav = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.aaq != null) {
                        VideoPasterOverlayView.this.aaq.rO();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.aaq != null) {
                        VideoPasterOverlayView.this.aaq.rL();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.aaq != null) {
                        VideoPasterOverlayView.this.aaq.rN();
                        VideoPasterOverlayView.this.aav = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.aaq != null) {
                        VideoPasterOverlayView.this.aaq.rM();
                        VideoPasterOverlayView.this.aav = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.aaq != null) {
                    VideoPasterOverlayView.this.aaq.rP();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.aao = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.aam = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.aan = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.aan.setOnClickListener(this.mOnClickListener);
        this.aam.setOnClickListener(this.mOnClickListener);
        this.aao.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.aaw = aVar;
            this.aap = z;
            this.Zn = z2;
            this.mTitle.setText(aVar.Zt);
            this.aan.setText(aVar.rU());
            if (z && !z2) {
                sf();
            } else {
                sd();
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

    private void sd() {
        this.mBack.setVisibility(8);
        this.aam.setPadding(0, 0, 0, 0);
        this.aan.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.aap && this.Zn && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        se();
    }

    private void se() {
        if (this.mContext != null && this.aao != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aao.getLayoutParams();
            if (this.aap) {
                if (this.Zn) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.aao.setLayoutParams(layoutParams);
        }
    }

    private void sf() {
        this.mBack.setVisibility(0);
        this.aam.setPadding(aar, 0, 0, 0);
        this.aan.setPadding(0, 0, aar, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        se();
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
        if (this.aam != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.aam.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.aaq = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void aZ(int i) {
    }

    public void d(int i, int i2, String str) {
        this.aas = true;
        this.aat = i;
        this.aau = i2;
        this.mFrom = str;
        if (this.aap) {
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
            } else if (this.Zn) {
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
        this.aas = false;
        this.mFrom = "";
        this.aat = 0;
        this.aau = 0;
        this.aav = false;
    }

    public void rI() {
        this.aap = true;
        a(this.aaw, this.aap, this.Zn);
        if (this.aas) {
            d(this.aat, this.aau, this.mFrom);
        }
    }

    public void rJ() {
        this.aap = false;
        a(this.aaw, this.aap, this.Zn);
        if (this.aav && !this.Zn) {
            this.aav = false;
        } else if (this.aas) {
            d(this.aat, this.aau, this.mFrom);
        }
    }
}
