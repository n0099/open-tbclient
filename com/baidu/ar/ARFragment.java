package com.baidu.ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ar.ARPermissionManager;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.camera.ARCameraManager;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.external.ARCallback;
import com.baidu.ar.external.BaseFragment;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.util.AssetsUtil;
import com.baidu.ar.util.Debug;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
/* loaded from: classes3.dex */
public class ARFragment extends BaseFragment {
    private static ARFragment n = null;
    private HostUI b;
    private ARCameraManager c;
    private ARPermissionManager d;
    private FrameLayout i;
    private FrameLayout j;
    private b k;
    private a l;
    private FrameLayout o;
    private OrientationManager e = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean m = false;

    private void a(final ARCallback.ARAction aRAction) {
        if (this.c != null) {
            this.c.stopCamera(new com.baidu.ar.camera.a() { // from class: com.baidu.ar.ARFragment.2
                @Override // com.baidu.ar.camera.a
                public void a(final boolean z) {
                    try {
                        ARFragment.this.getARCallback().setPreviewBitmap(ARFragment.this.c.getLastPreview());
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ARFragment.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Debug.print("stopCamera result:" + z);
                                if (z) {
                                    ARFragment.this.callbackQuitAR(aRAction);
                                    ARFragment.this.a();
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, false);
        }
    }

    private static void b() {
        if (n != null) {
            n.a();
            n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.o = (FrameLayout) Res.inflate("bdar_layout_arui");
        this.b = new HostUI(this, this.o);
        if (this.e != null) {
            this.e.addOrientationListener(new OrientationManager.OrientationListener() { // from class: com.baidu.ar.ARFragment.4
                @Override // com.baidu.ar.rotate.OrientationManager.OrientationListener
                public void onRotateOrientation(Orientation orientation) {
                    if (ARFragment.this.b != null) {
                        ARFragment.this.b.rotateOrientation(orientation);
                    }
                }
            });
        }
        ((FrameLayout) this.o.findViewById(Res.id("bdar_id_plugin_container"))).addView(this.j);
        this.i.addView(this.o);
    }

    private void d() {
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.OPEN_CAMERA);
        this.c.startCamera(this.b.getARRenderer().getCameraTexture(), new com.baidu.ar.camera.b() { // from class: com.baidu.ar.ARFragment.5
            @Override // com.baidu.ar.camera.b
            public void a(boolean z, SurfaceTexture surfaceTexture, int i, int i2) {
                if (z) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.OPEN_CAMERA_SUCCESS);
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ARFragment.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARFragment.this.k == null) {
                                ARFragment.this.e();
                            }
                        }
                    });
                    return;
                }
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.OPEN_CAMERA_FAILURE);
                if (ARFragment.this.d != null) {
                    ARFragment.this.d.handleOpenCameraFailed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getActivity().isFinishing()) {
            return;
        }
        this.l = new a(getActivity().getApplicationContext());
        ARConfig.setToken(this.l);
        this.k = new b(this);
        this.k.a(getARCallback());
        this.k.a(this.j);
        if (this.m) {
            this.k.d();
        }
    }

    private static void g(ARFragment aRFragment) {
        n = aRFragment;
    }

    public static void releaseFragmentOnQuit(ARFragment aRFragment) {
        if (n == aRFragment) {
            b();
        }
    }

    @Override // com.baidu.ar.external.BaseFragment
    protected void a() {
        if (this.h) {
            return;
        }
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.END_AR);
        super.a();
        this.h = true;
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
        if (this.k != null) {
            this.k.f();
        }
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
        UiThreadUtil.removeCallbacksAndMessages();
        Res.clearDelay(String.valueOf(hashCode()), getActivity());
        StatisticHelper.getInstance().release();
        releaseFragmentOnQuit(this);
    }

    public void closeCamera() {
        this.c.stopCamera(new com.baidu.ar.camera.a() { // from class: com.baidu.ar.ARFragment.3
            @Override // com.baidu.ar.camera.a
            public void a(boolean z) {
                ARFragment.this.getARCallback().setPreviewBitmap(ARFragment.this.c.getLastPreview());
                ARFragment.this.getARCallback().rescan(ARFragment.this);
            }
        }, true);
    }

    public ARCameraManager getARCameraManager() {
        return this.c;
    }

    public ARPermissionManager getARPermissionManager() {
        return this.d;
    }

    public HostUI getHostUI() {
        return this.b;
    }

    public OrientationManager getOrientationManager() {
        return this.e;
    }

    public boolean isScreenOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    @Override // com.baidu.ar.external.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        b();
        g(this);
        Res.setFragmentHashCode(String.valueOf(hashCode()));
        super.onCreate(bundle);
        Debug.print("[ARFragment] onCreate :" + hashCode());
        this.i = new FrameLayout(getActivity());
        this.j = new FrameLayout(getActivity());
        this.g = true;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ARConfigKey.AR_VALUE);
            if (!TextUtils.isEmpty(string)) {
                ARConfig.initARConfig(string);
            }
        }
        this.e = new OrientationManager(getActivity().getApplicationContext());
        this.e.setScreenOrientationLandscape(isScreenOrientationLandscape(getActivity().getApplicationContext()));
        this.d = new ARPermissionManager(this);
        this.d.setArCallBack(getARCallback());
        this.c = new ARCameraManager();
        if (getActivity().getApplicationContext().getPackageName().toLowerCase().contains("searchbox")) {
            DuMixARConfig.setAppId("2");
            DuMixARConfig.setAPIKey("076dd2b8e9b783f95ae568be218e7c98");
        } else {
            if (TextUtils.isEmpty(AssetsUtil.getFromAssets(getActivity().getApplicationContext(), "aip.license"))) {
                ARConfig.setIsAipAuth(false);
            } else {
                ARConfig.setIsAipAuth(true);
            }
            Res.addResource(getActivity().getApplicationContext());
        }
        StatisticHelper.getInstance().initStatistic(getActivity().getApplicationContext());
        this.d.requestSDCardAndCameraPermissionForBaidu(new ARPermissionManager.b() { // from class: com.baidu.ar.ARFragment.1
            @Override // com.baidu.ar.ARPermissionManager.b
            public void a(boolean z) {
                if (z) {
                    ARFragment.this.c();
                }
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.k != null) {
            this.k.a(this.j);
        }
        return this.i;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Debug.print("[ARFragment] onDestroy :" + hashCode() + ", mIsReleased:" + this.h);
        releaseFragmentOnQuit(this);
    }

    public boolean onFragmentBackPressed() {
        boolean g = this.k != null ? this.k.g() : false;
        Debug.print("[ARFragmentPluginImp]onFragmentBackPressed mUIController result:" + g);
        if (!g) {
            if (this.l != null) {
                this.l.a();
            }
            quit();
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.m = false;
        if (this.e != null) {
            this.e.disable();
        }
        Debug.print("[ARFragment] onPause :" + hashCode() + ", mIsReleased:" + this.h);
        if (this.h) {
            return;
        }
        if (this.b != null) {
            this.b.onPause();
        }
        if (this.k != null) {
            this.k.e();
        }
        if (this.d != null) {
            this.d.onPause();
        }
        this.c.stopCamera(null, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.d != null) {
            this.d.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Debug.print("[ARFragment] onResume :" + hashCode() + ", mIsReleased:" + this.h);
        if (this.h) {
            return;
        }
        this.m = true;
        if (this.b != null) {
            this.b.onResume();
        }
        if (this.k != null) {
            this.k.d();
        }
        try {
            this.e.enable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (this.d != null) {
            this.d.onResume();
            if (this.d.hasNecessaryPermission()) {
                d();
            }
        }
    }

    public void quit() {
        a(ARCallback.ARAction.BACK);
    }

    public void release() {
        if (this.g && !this.f) {
            a();
        }
    }

    public void setNightMode(boolean z) {
        FrameLayout frameLayout;
        if (this.o == null || (frameLayout = (FrameLayout) this.o.findViewById(Res.id("bdar_id_night_mode_cover"))) == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
    }

    public void setWillQuitAR() {
        this.f = true;
    }

    public void switchToBarcode() {
        a(ARCallback.ARAction.SWITCHTOBARCODE);
    }
}
