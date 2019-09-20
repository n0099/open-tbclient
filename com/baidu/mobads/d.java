package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.component.XAdView;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
public class d {
    public static String agY = "pattern";
    public static String agZ = "btn_pos";
    private com.baidu.mobads.production.g.a a;
    private e aha;
    private int b = 4;
    private volatile String c = "init";
    private IOAdEventListener ahb = new j(this);

    public d(Context context, ViewGroup viewGroup, e eVar, String str, boolean z) {
        this.aha = new i(this);
        try {
            com.baidu.mobads.a.a.l = System.currentTimeMillis();
            com.baidu.mobads.a.a.m = 0L;
            com.baidu.mobads.a.a.n = 0L;
            com.baidu.mobads.a.a.o = 0L;
            com.baidu.mobads.a.a.p = 0L;
            com.baidu.mobads.a.a.q = 0L;
            com.baidu.mobads.a.a.r = 0L;
            if (!AppActivity.uv()) {
                a(viewGroup, context);
            }
            if (eVar != null) {
                this.aha = eVar;
            }
            if (TextUtils.isEmpty(str)) {
                this.aha.cO("请您输入正确的广告位ID");
                return;
            }
            XAdView xAdView = new XAdView(context);
            xAdView.setListener(new l(this, context, xAdView, str, z));
            xAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(xAdView);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            com.baidu.mobads.c.a.a().a("splash ad create failed: " + e.toString());
        }
    }

    private void a(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
    }
}
