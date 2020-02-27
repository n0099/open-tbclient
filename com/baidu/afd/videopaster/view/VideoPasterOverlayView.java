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
/* loaded from: classes8.dex */
public class VideoPasterOverlayView extends FrameLayout {
    private static final int EX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean DS;
    private TextView ER;
    private TextView ES;
    private View ET;
    private ImageView EU;
    private boolean EV;
    private a EW;
    private boolean EY;
    private int EZ;
    private int Fa;
    private boolean Fb;
    private com.baidu.afd.videopaster.data.a Fc;
    private Context mContext;
    private String mFrom;
    private int mNavigationBarHeight;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes8.dex */
    public interface a {
        void lf();

        void lg();

        void lh();

        void li();

        void lj();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.mNavigationBarHeight = 0;
        this.EY = false;
        this.EZ = 0;
        this.Fa = 0;
        this.Fb = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.EW != null) {
                        VideoPasterOverlayView.this.EW.li();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.EW != null) {
                        VideoPasterOverlayView.this.EW.lf();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.EW != null) {
                        VideoPasterOverlayView.this.EW.lh();
                        VideoPasterOverlayView.this.Fb = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.EW != null) {
                        VideoPasterOverlayView.this.EW.lg();
                        VideoPasterOverlayView.this.Fb = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.EW != null) {
                    VideoPasterOverlayView.this.EW.lj();
                }
            }
        };
        this.mContext = context;
        this.mNavigationBarHeight = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.ET = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.ER = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.ES = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.EU = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.ES.setOnClickListener(this.mOnClickListener);
        this.ER.setOnClickListener(this.mOnClickListener);
        this.ET.setOnClickListener(this.mOnClickListener);
        this.EU.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.Fc = aVar;
            this.EV = z;
            this.DS = z2;
            this.mTitle.setText(aVar.DY);
            this.ES.setText(aVar.lo());
            if (z && !z2) {
                lz();
            } else {
                lx();
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

    private void lx() {
        this.EU.setVisibility(8);
        this.ER.setPadding(0, 0, 0, 0);
        this.ES.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.EV && this.DS && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.mNavigationBarHeight);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        ly();
    }

    private void ly() {
        if (this.mContext != null && this.ET != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ET.getLayoutParams();
            if (this.EV) {
                if (this.DS) {
                    layoutParams.setMargins(0, 0, 0, this.mNavigationBarHeight);
                } else {
                    layoutParams.setMargins(this.mNavigationBarHeight, 0, this.mNavigationBarHeight, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.ET.setLayoutParams(layoutParams);
        }
    }

    private void lz() {
        this.EU.setVisibility(0);
        this.ER.setPadding(EX, 0, 0, 0);
        this.ES.setPadding(0, 0, EX, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        ly();
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
        if (this.ER != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.ER.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.EW = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void ax(int i) {
    }

    public void c(int i, int i2, String str) {
        this.EY = true;
        this.EZ = i;
        this.Fa = i2;
        this.mFrom = str;
        if (this.EV) {
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
            } else if (this.DS) {
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
        this.EY = false;
        this.mFrom = "";
        this.EZ = 0;
        this.Fa = 0;
        this.Fb = false;
    }

    public void lc() {
        this.EV = true;
        a(this.Fc, this.EV, this.DS);
        if (this.EY) {
            c(this.EZ, this.Fa, this.mFrom);
        }
    }

    public void ld() {
        this.EV = false;
        a(this.Fc, this.EV, this.DS);
        if (this.Fb && !this.DS) {
            this.Fb = false;
        } else if (this.EY) {
            c(this.EZ, this.Fa, this.mFrom);
        }
    }
}
