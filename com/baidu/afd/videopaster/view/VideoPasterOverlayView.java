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
    private static final int abV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds22);
    private boolean aaR;
    private TextView abQ;
    private TextView abR;
    private View abS;
    private boolean abT;
    private a abU;
    private int abW;
    private boolean abX;
    private int abY;
    private int abZ;
    private boolean aca;
    private com.baidu.afd.videopaster.data.a acb;
    private ImageView mBack;
    private Context mContext;
    private String mFrom;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private TextView mTitle;

    /* loaded from: classes.dex */
    public interface a {
        void rm();

        void rn();

        void ro();

        void rp();

        void rq();
    }

    public VideoPasterOverlayView(@NonNull Context context) {
        super(context);
        this.abW = 0;
        this.abX = false;
        this.abY = 0;
        this.abZ = 0;
        this.aca = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.afd.videopaster.view.VideoPasterOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.video_paster_overlay_time_and_close) {
                    if (VideoPasterOverlayView.this.abU != null) {
                        VideoPasterOverlayView.this.abU.rp();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_title) {
                    if (VideoPasterOverlayView.this.abU != null) {
                        VideoPasterOverlayView.this.abU.rm();
                    }
                } else if (view.getId() == R.id.video_paster_overlay_detail) {
                    if (VideoPasterOverlayView.this.abU != null) {
                        VideoPasterOverlayView.this.abU.ro();
                        VideoPasterOverlayView.this.aca = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_wrapper) {
                    if (VideoPasterOverlayView.this.abU != null) {
                        VideoPasterOverlayView.this.abU.rn();
                        VideoPasterOverlayView.this.aca = true;
                    }
                } else if (view.getId() == R.id.video_paster_mask_back && VideoPasterOverlayView.this.abU != null) {
                    VideoPasterOverlayView.this.abU.rq();
                }
            }
        };
        this.mContext = context;
        this.abW = getNavigationBarHeight(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.video_paster_overlay_layout, (ViewGroup) null);
        this.abS = this.mRootView.findViewById(R.id.video_paster_mask_wrapper);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_title);
        this.abQ = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_time_and_close);
        this.abR = (TextView) this.mRootView.findViewById(R.id.video_paster_overlay_detail);
        this.mBack = (ImageView) this.mRootView.findViewById(R.id.video_paster_mask_back);
        this.abR.setOnClickListener(this.mOnClickListener);
        this.abQ.setOnClickListener(this.mOnClickListener);
        this.abS.setOnClickListener(this.mOnClickListener);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTitle.setOnClickListener(this.mOnClickListener);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.mRootView;
    }

    public void a(com.baidu.afd.videopaster.data.a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            this.acb = aVar;
            this.abT = z;
            this.aaR = z2;
            this.mTitle.setText(aVar.aaX);
            this.abR.setText(aVar.rv());
            if (z && !z2) {
                rG();
            } else {
                rE();
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

    private void rE() {
        this.mBack.setVisibility(8);
        this.abQ.setPadding(0, 0, 0, 0);
        this.abR.setPadding(0, 0, 0, 0);
        boolean hasNavBar = hasNavBar(this.mContext);
        if (this.abT && this.aaR && hasNavBar) {
            this.mRootView.setPadding(0, 0, 0, this.abW);
        } else {
            this.mRootView.setPadding(0, 0, 0, 0);
        }
        rF();
    }

    private void rF() {
        if (this.mContext != null && this.abS != null && hasNavBar(this.mContext)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abS.getLayoutParams();
            if (this.abT) {
                if (this.aaR) {
                    layoutParams.setMargins(0, 0, 0, this.abW);
                } else {
                    layoutParams.setMargins(this.abW, 0, this.abW, 0);
                }
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            this.abS.setLayoutParams(layoutParams);
        }
    }

    private void rG() {
        this.mBack.setVisibility(0);
        this.abQ.setPadding(abV, 0, 0, 0);
        this.abR.setPadding(0, 0, abV, 0);
        this.mRootView.setPadding(0, 0, 0, 0);
        rF();
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
        if (this.abQ != null && i > 0) {
            if (i >= 10) {
                str = "" + i;
            } else {
                str = "0" + i;
            }
            this.abQ.setText(str + TbadkCoreApplication.getInst().getResources().getString(R.string.video_paster_close_ad));
        }
    }

    public void setOverlayViewCallback(a aVar) {
        this.abU = aVar;
    }

    public void resume() {
    }

    public void stop() {
    }

    public void be(int i) {
    }

    public void d(int i, int i2, String str) {
        this.abX = true;
        this.abY = i;
        this.abZ = i2;
        this.mFrom = str;
        if (this.abT) {
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
            } else if (this.aaR) {
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
        this.abX = false;
        this.mFrom = "";
        this.abY = 0;
        this.abZ = 0;
        this.aca = false;
    }

    public void rj() {
        this.abT = true;
        a(this.acb, this.abT, this.aaR);
        if (this.abX) {
            d(this.abY, this.abZ, this.mFrom);
        }
    }

    public void rk() {
        this.abT = false;
        a(this.acb, this.abT, this.aaR);
        if (this.aca && !this.aaR) {
            this.aca = false;
        } else if (this.abX) {
            d(this.abY, this.abZ, this.mFrom);
        }
    }
}
