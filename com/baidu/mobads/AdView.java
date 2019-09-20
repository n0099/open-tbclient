package com.baidu.mobads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public final class AdView extends RelativeLayout {
    private AtomicBoolean agH;
    IOAdEventListener agI;
    private com.baidu.mobads.production.a.a agJ;
    private a agK;

    public AdView(Context context) {
        super(context);
        this.agH = new AtomicBoolean(false);
        this.agI = new g(this);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int i;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams", Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f));
        if (i2 <= 0) {
            i2 = Math.min(i4, i5);
        } else if (i2 > 0 && i2 < 200.0f * f) {
            i2 = (int) (200.0f * f);
        }
        if (i3 <= 0) {
            i = (int) (Math.min(i4, i5) * 0.15f);
        } else {
            i = (i3 <= 0 || ((float) i3) >= 30.0f * f) ? i3 : (int) (30.0f * f);
        }
        layoutParams.width = i2;
        layoutParams.height = i;
        if (this.agJ != null && this.agJ.getAdRequestInfo() != null) {
            this.agJ.getAdRequestInfo().d(layoutParams.width);
            this.agJ.getAdRequestInfo().e(layoutParams.height);
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(a aVar) {
        this.agK = aVar;
    }

    @Override // android.view.View
    @Deprecated
    public void setAlpha(float f) {
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundColor(int i) {
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }
}
