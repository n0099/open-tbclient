package com.baidu.ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.c.d;
import com.baidu.ar.draw.ARRenderCallback;
import com.baidu.ar.external.ARCallback;
import com.baidu.ar.recommend.f;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.c;
import com.baidu.ar.ui.e;
import com.baidu.ar.ui.j;
import com.baidu.ar.ui.m;
import com.baidu.ar.ui.n;
import com.baidu.ar.ui.q;
import com.baidu.ar.ui.s;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.SystemInfoUtil;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b implements OrientationManager.OrientationListener {
    private ARFragment b;
    private Context c;
    private ViewGroup d;
    private ViewGroup e;
    private ViewGroup f;
    private c g;
    private ARCallback h;
    private ARController j;
    private DuMixSource k;
    private DuMixTarget l;
    private n n;
    private a o;
    boolean a = false;
    private f i = new f(this);
    private com.baidu.ar.c.a m = new com.baidu.ar.c.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends OrientationEventListener {
        private WeakReference<b> a;

        public a(Context context, b bVar) {
            super(context);
            this.a = new WeakReference<>(bVar);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (this.a.get() == null || this.a.get().j == null) {
                return;
            }
            this.a.get().j.orientationChange(i);
        }
    }

    public b(ARFragment aRFragment) {
        this.b = aRFragment;
        this.c = aRFragment.getActivity().getApplicationContext();
        this.j = new ARController(this.b.getActivity(), false);
        this.o = new a(this.c, this);
        this.n = new n(this.b);
        this.m.a(this.n);
        this.m.a(new d() { // from class: com.baidu.ar.b.1
            @Override // com.baidu.ar.c.d
            public void a(ARResource aRResource) {
                if (aRResource != null) {
                    if (b.this.g != null) {
                        b.this.g.m();
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.DESTROY_AR_CASE);
                    }
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_AR);
                    b.this.g = b.this.c(aRResource);
                    if (TextUtils.isEmpty(aRResource.getKey())) {
                        return;
                    }
                    b.this.i.a(aRResource, b.this.e);
                }
            }
        });
        this.m.a(new com.baidu.ar.c.b() { // from class: com.baidu.ar.b.2
            @Override // com.baidu.ar.c.b
            public void a(ARResource aRResource) {
                b.this.a(aRResource);
            }

            @Override // com.baidu.ar.c.b
            public void b(ARResource aRResource) {
                b.this.b(aRResource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c c(ARResource aRResource) {
        c cVar = null;
        if (aRResource != null) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.AR_UI_CREATE_START);
            switch (aRResource.getType()) {
                case 0:
                    cVar = new s(this.d, this, aRResource);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                case 5:
                    cVar = new q(this.d, this, aRResource);
                    break;
                case 6:
                    cVar = new m(this.d, this, aRResource);
                    break;
                case 7:
                    cVar = new e(this.d, this, aRResource);
                    break;
                case 8:
                    cVar = new j(this.d, this, aRResource);
                    break;
                default:
                    cVar = new s(this.d, this, aRResource);
                    break;
            }
            if (cVar != null) {
                this.m.a(cVar.h());
            }
            if (cVar != null) {
                cVar.k();
            }
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.AR_UI_CREATE_COMPLETE);
        }
        return cVar;
    }

    public View a(ViewGroup viewGroup) {
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.AR_UI_CREATE_START);
        View inflate = Res.inflate("bdar_layout_uicontroller");
        viewGroup.addView(inflate);
        this.d = (ViewGroup) inflate.findViewById(Res.id("bdar_ar_content"));
        this.e = (ViewGroup) inflate.findViewById(Res.id("bdar_recommend_content"));
        this.f = (ViewGroup) inflate.findViewById(Res.id("bdar_gui_share_content"));
        this.b.getHostUI().getARRenderer().setARRenderCallback(new ARRenderCallback() { // from class: com.baidu.ar.b.3
            @Override // com.baidu.ar.draw.ARRenderCallback
            public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (b.this.j != null) {
                    if (SystemInfoUtil.isScreenOrientationLandscape(b.this.c)) {
                        b.this.j.reSetup(surfaceTexture, i2, i);
                    } else {
                        b.this.j.reSetup(surfaceTexture, i, i2);
                    }
                }
            }

            @Override // com.baidu.ar.draw.ARRenderCallback
            public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2) {
                if (SystemInfoUtil.isScreenOrientationLandscape(b.this.c)) {
                    b.this.l = new DuMixTarget(surfaceTexture, onFrameAvailableListener, i2, i, true);
                } else {
                    b.this.l = new DuMixTarget(surfaceTexture, onFrameAvailableListener, i, i2, true);
                }
                if (b.this.k != null) {
                    b.this.k.setCameraSource(null);
                }
                if (b.this.j != null) {
                    b.this.j.setup(b.this.k, b.this.l, b.this.m);
                } else {
                    ARLog.e("onCreateView mARController is NULLLLLL!!!");
                }
            }

            @Override // com.baidu.ar.draw.ARRenderCallback
            public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
                b.this.k = new DuMixSource(ARConfig.getARKey(), surfaceTexture, i, i2);
                b.this.k.setArType(ARConfig.getARType());
            }
        });
        this.b.getHostUI().getGLSurfaceView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.b.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.j != null) {
                    return b.this.j.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.b.getARCameraManager().setPreviewCallback(new PreviewCallback() { // from class: com.baidu.ar.b.5
            @Override // com.baidu.ar.PreviewCallback
            public void onPreviewFrame(byte[] bArr, int i, int i2) {
                if (b.this.j != null) {
                    b.this.j.onCameraPreviewFrame(bArr, i, i2);
                }
            }
        });
        this.b.getOrientationManager().addOrientationListener(this);
        return viewGroup;
    }

    public ARCallback a() {
        return this.h;
    }

    public void a(ARResource aRResource) {
        this.i.a(aRResource);
    }

    public void a(ARCallback aRCallback) {
        this.h = aRCallback;
    }

    public n b() {
        return this.n;
    }

    public void b(ARResource aRResource) {
        this.i.b(aRResource);
    }

    public ViewGroup c() {
        return this.d;
    }

    public void d() {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            if (this.o != null) {
                this.o.enable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.g != null) {
            this.g.k();
        }
        if (this.j != null) {
            this.j.onResume();
        }
    }

    public void e() {
        this.a = false;
        if (this.o != null) {
            this.o.disable();
        }
        if (this.j != null) {
            this.j.onPause();
        }
        if (this.g != null) {
            this.g.l();
        }
    }

    public void f() {
        if (this.j != null) {
            this.j.release();
            this.j.onDestroy();
            this.j = null;
        }
        if (this.g != null) {
            this.g.n();
            this.g = null;
        }
        this.h = null;
        this.m = null;
        this.b.getARCameraManager().setPreviewCallback(null);
        this.i.a();
        this.n.d();
        if (this.o != null) {
            this.o.disable();
            this.o = null;
        }
    }

    public boolean g() {
        return this.g != null && this.g.t();
    }

    public ARFragment h() {
        return this.b;
    }

    public ARController i() {
        return this.j;
    }

    public com.baidu.ar.c.a j() {
        return this.m;
    }

    public ViewGroup k() {
        return this.f;
    }

    public f l() {
        return this.i;
    }

    @Override // com.baidu.ar.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        this.i.a(orientation);
        if (this.g != null) {
            this.g.onRotateOrientation(orientation);
        }
    }
}
