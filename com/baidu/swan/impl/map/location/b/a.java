package com.baidu.swan.impl.map.location.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.r;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.d;
import com.facebook.common.b.f;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.apps.core.c.b implements IWNaviStatusListener, IWTTSPlayer {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout bfG;
    private WalkNavigateHelper biY;
    private BaseNpcModel biZ;
    private boolean bja;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0210a {
        void k(Bitmap bitmap);
    }

    public static a C(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void Qi() {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz != null) {
            uz.dY("navigateTo").A(e.aqJ, e.aqL).b(this).za();
        }
    }

    private void QK() {
        SDKInitializer.setCoordType(CoordType.BD09LL);
        try {
            this.biY = WalkNavigateHelper.getInstance();
            View onCreate = this.biY.onCreate(com.baidu.swan.apps.w.e.Ec().DO());
            if (onCreate != null) {
                this.bfG.addView(onCreate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WalkNaviDisplayOption walkNaviDisplayOption = new WalkNaviDisplayOption();
        walkNaviDisplayOption.runInFragment(true);
        this.biY.setWalkNaviDisplayOption(walkNaviDisplayOption);
        final Bundle arguments = getArguments();
        String str = "";
        if (arguments != null) {
            str = arguments.getString("guideIcon");
        }
        if (DEBUG) {
            Log.e("WalkARNavFragment", "guideIconPath = " + str);
        }
        final Context context = getContext();
        a(context, str, new InterfaceC0210a() { // from class: com.baidu.swan.impl.map.location.b.a.1
            @Override // com.baidu.swan.impl.map.location.b.a.InterfaceC0210a
            public void k(Bitmap bitmap) {
                String str2 = "";
                if (arguments != null) {
                    str2 = arguments.getString("guideKey");
                }
                if (!TextUtils.isEmpty(str2)) {
                    BaseNpcModel baseNpcModel = new BaseNpcModel();
                    baseNpcModel.setDownLoadKey(str2);
                    if (bitmap != null) {
                        bitmap = a.this.d(bitmap, x.dip2px(context, 44.0f), x.dip2px(context, 44.0f));
                    }
                    Bitmap decodeResource = BitmapFactory.decodeResource(a.this.getResources(), d.f.aiapps_wsdk_npc_drawer_default);
                    if (bitmap == null) {
                        bitmap = decodeResource;
                    }
                    baseNpcModel.setIcon(bitmap);
                    ArrayList<BaseNpcModel> arrayList = new ArrayList<>();
                    arrayList.add(baseNpcModel);
                    a.this.biZ = baseNpcModel;
                    a.this.biY.addMoreNPCModelOnClickListener(new IWMoreNPCModelOnClickListener() { // from class: com.baidu.swan.impl.map.location.b.a.1.1
                        @Override // com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener
                        public void onMoreNPCModelOnClick(View view) {
                            if (a.DEBUG) {
                                Log.e("WalkARNavFragment", "npc model onMoreNPCModelOnClick");
                            }
                            ArrayList<BaseNpcModel> walkNpcModelInfoList = a.this.biY.getWalkNpcModelInfoList();
                            if (walkNpcModelInfoList != null && walkNpcModelInfoList.size() > 0) {
                                if (a.DEBUG) {
                                    Log.e("WalkARNavFragment", "models size :" + walkNpcModelInfoList.size());
                                }
                                a.this.biY.switchNPCModel(walkNpcModelInfoList.get(walkNpcModelInfoList.size() - 1));
                            }
                        }
                    });
                    a.this.biY.setWalkNpcModelInfoList(arrayList);
                }
                a.this.biY.setWalkNaviStatusListener(a.this);
                a.this.biY.setTTsPlayer(a.this);
                a.this.biY.startWalkNavi(com.baidu.swan.apps.w.e.Ec().DO());
            }
        });
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0076 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void a(Context context, String str, final InterfaceC0210a interfaceC0210a) {
        FileInputStream fileInputStream;
        if (context == null || TextUtils.isEmpty(str)) {
            interfaceC0210a.k(null);
        } else if (com.baidu.swan.apps.storage.b.gY(str) == PathType.NETWORK) {
            c.cuF().e(ImageRequestBuilder.O(aa.hL(str)).cAI(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.impl.map.location.b.a.2
                @Override // com.facebook.imagepipeline.e.b
                protected void f(@Nullable Bitmap bitmap) {
                    if (a.DEBUG) {
                        Log.e("WalkARNavFragment", "onNewResultImpl");
                    }
                    interfaceC0210a.k(bitmap.copy(bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig(), true));
                }

                @Override // com.facebook.datasource.a
                protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                    if (a.DEBUG) {
                        Log.e("WalkARNavFragment", "onFailureImpl");
                    }
                    interfaceC0210a.k(null);
                }
            }, f.ctJ());
        } else {
            File file = new File(str);
            if (file.exists()) {
                ?? isFile = file.isFile();
                try {
                    if (isFile != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                interfaceC0210a.k(BitmapFactory.decodeStream(fileInputStream));
                                com.baidu.swan.c.b.c(fileInputStream);
                                return;
                            } catch (FileNotFoundException e) {
                                e = e;
                                interfaceC0210a.k(null);
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                com.baidu.swan.c.b.c(fileInputStream);
                                return;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            isFile = 0;
                            com.baidu.swan.c.b.c(isFile);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            interfaceC0210a.k(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap d(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint(1);
        paint.setShader(bitmapShader);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap2).drawOval(new RectF(new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight())), paint);
        return createBitmap2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            return null;
        }
        com.baidu.swan.impl.map.a.PN();
        View inflate = layoutInflater.inflate(d.h.walk_arnav_fragment, viewGroup, false);
        this.bfG = (FrameLayout) inflate;
        QK();
        if (yj()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.biY != null) {
            QL();
            this.biY.quit();
        }
        SDKInitializer.setCoordType(CoordType.GCJ02);
        yp();
        SwanAppActivity DO = com.baidu.swan.apps.w.e.Ec().DO();
        if (DO != null && DO.getWindow() != null) {
            DO.getWindow().clearFlags(128);
        }
        com.baidu.swan.apps.w.e.Ec().DG();
    }

    private void QL() {
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                Field declaredField = WalkNavigateHelper.class.getDeclaredField(Config.APP_VERSION_CODE);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(WalkNavigateHelper.getInstance());
                Field declaredField2 = obj.getClass().getDeclaredField("c");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.biY != null) {
            this.biY.resume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.biY != null) {
            this.biY.pause();
        }
        com.baidu.swan.apps.w.e.Ec().DF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.biY.switchWalkNaviMode(com.baidu.swan.apps.w.e.Ec().DO(), i, walkNaviModeSwitchListener);
        if (i == 2 && !this.bja && this.biY != null && this.biZ != null && !r.getBoolean("switch_npc_mode", false)) {
            this.biY.switchNPCModel(this.biZ);
            this.bja = true;
            r.setBoolean("switch_npc_mode", true);
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onNaviExit() {
        if (DEBUG) {
            Log.e("WalkARNavFragment", "nav exit,exit fragment");
        }
        if (Sy() != null) {
            Sy().onBackPressed();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWTTSPlayer
    public int playTTSText(String str, boolean z) {
        return 0;
    }
}
