package com.baidu.swan.impl.map.location.b;

import android.annotation.TargetApi;
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
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.aa;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.c.d;
import com.baidu.tieba.R;
import com.facebook.common.b.i;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends c implements IWNaviStatusListener, IWTTSPlayer {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private FrameLayout ajf;
    private WalkNavigateHelper eoN;
    private BaseNpcModel eoO;
    private boolean eoP;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.impl.map.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0540a {
        void t(Bitmap bitmap);
    }

    public static a ac(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            aVar.setArguments(bundle);
        }
        return aVar;
    }

    public void bax() {
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            afz.mk("navigateTo").ai(f.cQm, f.cQo).f(this).apk();
        }
    }

    private void bba() {
        SDKInitializer.setCoordType(CoordType.BD09LL);
        try {
            this.eoN = WalkNavigateHelper.getInstance();
            View onCreate = this.eoN.onCreate(com.baidu.swan.apps.v.f.azN().azx());
            if (onCreate != null) {
                this.ajf.addView(onCreate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WalkNaviDisplayOption walkNaviDisplayOption = new WalkNaviDisplayOption();
        walkNaviDisplayOption.runInFragment(true);
        this.eoN.setWalkNaviDisplayOption(walkNaviDisplayOption);
        final Bundle arguments = getArguments();
        String str = "";
        if (arguments != null) {
            str = arguments.getString("guideIcon");
        }
        if (DEBUG) {
            Log.e("WalkARNavFragment", "guideIconPath = " + str);
        }
        final Context context = getContext();
        a(context, str, new InterfaceC0540a() { // from class: com.baidu.swan.impl.map.location.b.a.1
            @Override // com.baidu.swan.impl.map.location.b.a.InterfaceC0540a
            public void t(Bitmap bitmap) {
                String str2 = "";
                if (arguments != null) {
                    str2 = arguments.getString("guideKey");
                }
                if (!TextUtils.isEmpty(str2)) {
                    BaseNpcModel baseNpcModel = new BaseNpcModel();
                    baseNpcModel.setDownLoadKey(str2);
                    if (bitmap != null) {
                        bitmap = a.this.e(bitmap, ah.dip2px(context, 44.0f), ah.dip2px(context, 44.0f));
                    }
                    Bitmap decodeResource = BitmapFactory.decodeResource(a.this.getResources(), R.drawable.aiapps_wsdk_npc_drawer_default);
                    if (bitmap == null) {
                        bitmap = decodeResource;
                    }
                    baseNpcModel.setIcon(bitmap);
                    ArrayList<BaseNpcModel> arrayList = new ArrayList<>();
                    arrayList.add(baseNpcModel);
                    a.this.eoO = baseNpcModel;
                    a.this.eoN.addMoreNPCModelOnClickListener(new IWMoreNPCModelOnClickListener() { // from class: com.baidu.swan.impl.map.location.b.a.1.1
                        @Override // com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener
                        public void onMoreNPCModelOnClick(View view) {
                            if (a.DEBUG) {
                                Log.e("WalkARNavFragment", "npc model onMoreNPCModelOnClick");
                            }
                            ArrayList<BaseNpcModel> walkNpcModelInfoList = a.this.eoN.getWalkNpcModelInfoList();
                            if (walkNpcModelInfoList != null && walkNpcModelInfoList.size() > 0) {
                                if (a.DEBUG) {
                                    Log.e("WalkARNavFragment", "models size :" + walkNpcModelInfoList.size());
                                }
                                a.this.eoN.switchNPCModel(walkNpcModelInfoList.get(walkNpcModelInfoList.size() - 1));
                            }
                        }
                    });
                    a.this.eoN.setWalkNpcModelInfoList(arrayList);
                }
                a.this.eoN.setWalkNaviStatusListener(a.this);
                a.this.eoN.setTTsPlayer(a.this);
                a.this.eoN.startWalkNavi(com.baidu.swan.apps.v.f.azN().azx());
            }
        });
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0076 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void a(Context context, String str, final InterfaceC0540a interfaceC0540a) {
        FileInputStream fileInputStream;
        if (context == null || TextUtils.isEmpty(str)) {
            interfaceC0540a.t(null);
        } else if (com.baidu.swan.apps.storage.b.sL(str) == PathType.NETWORK) {
            com.facebook.drawee.a.a.c.eqX().e(ImageRequestBuilder.ag(ak.tC(str)).exQ(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.d.b() { // from class: com.baidu.swan.impl.map.location.b.a.2
                @Override // com.facebook.imagepipeline.d.b
                protected void f(@Nullable Bitmap bitmap) {
                    if (a.DEBUG) {
                        Log.e("WalkARNavFragment", "onNewResultImpl");
                    }
                    interfaceC0540a.t(bitmap.copy(bitmap.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap.getConfig(), true));
                }

                @Override // com.facebook.datasource.a
                protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar) {
                    if (a.DEBUG) {
                        Log.e("WalkARNavFragment", "onFailureImpl");
                    }
                    interfaceC0540a.t(null);
                }
            }, i.eqd());
        } else {
            File file = new File(str);
            if (file.exists()) {
                ?? isFile = file.isFile();
                try {
                    if (isFile != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                interfaceC0540a.t(BitmapFactory.decodeStream(fileInputStream));
                                d.closeSafely(fileInputStream);
                                return;
                            } catch (FileNotFoundException e) {
                                e = e;
                                interfaceC0540a.t(null);
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                d.closeSafely(fileInputStream);
                                return;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            isFile = 0;
                            d.closeSafely(isFile);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            interfaceC0540a.t(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e(Bitmap bitmap, int i, int i2) {
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
        com.baidu.swan.impl.map.a.aZZ();
        View inflate = layoutInflater.inflate(R.layout.walk_arnav_fragment, viewGroup, false);
        this.ajf = (FrameLayout) inflate;
        bba();
        if (aok()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eoN != null) {
            bbb();
            this.eoN.quit();
        }
        SDKInitializer.setCoordType(CoordType.GCJ02);
        abandonAudioFocus();
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx != null && azx.getWindow() != null) {
            azx.getWindow().clearFlags(128);
        }
        com.baidu.swan.apps.v.f.azN().azo();
    }

    @TargetApi(19)
    private void bbb() {
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                Field declaredField = WalkNavigateHelper.class.getDeclaredField("a");
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

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eoN != null) {
            this.eoN.resume();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eoN != null) {
            this.eoN.pause();
        }
        com.baidu.swan.apps.v.f.azN().azn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return false;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.eoN.switchWalkNaviMode(com.baidu.swan.apps.v.f.azN().azx(), i, walkNaviModeSwitchListener);
        if (i == 2 && !this.eoP && this.eoN != null && this.eoO != null && !aa.getBoolean("switch_npc_mode", false)) {
            this.eoN.switchNPCModel(this.eoO);
            this.eoP = true;
            aa.setBoolean("switch_npc_mode", true);
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onNaviExit() {
        if (DEBUG) {
            Log.e("WalkARNavFragment", "nav exit,exit fragment");
        }
        if (bdH() != null) {
            bdH().onBackPressed();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWTTSPlayer
    public int playTTSText(String str, boolean z) {
        return 0;
    }
}
