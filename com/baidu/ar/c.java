package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.c;
import com.baidu.ar.arrender.l;
import com.baidu.ar.d.g;
import com.baidu.ar.d.j;
import com.baidu.ar.d.k;
import com.baidu.ar.imu.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.searchbox.crius.constants.NativeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c implements c.a {
    public com.baidu.ar.filter.a B;
    public a C;
    public String L;
    public JSONObject M;
    public HashMap<String, com.baidu.ar.d.e> N;
    public c.b R;
    public int S;
    public com.baidu.ar.mdl.b e;
    public com.baidu.ar.lua.b f;
    public com.baidu.ar.arrender.c g;
    public g h;
    public com.baidu.ar.imu.c i;
    public Context mContext;
    public Handler mHandler;
    public int mInputHeight;
    public int mInputWidth;
    public int mOutputHeight;
    public int mOutputWidth;
    public List<k> O = new ArrayList();
    public boolean P = false;
    public List<String> Q = new CopyOnWriteArrayList();

    /* renamed from: T  reason: collision with root package name */
    public boolean f1034T = true;
    public boolean mIsFrontCamera = true;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(String str, com.baidu.ar.d.e eVar);

        boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap);
    }

    private boolean v() {
        com.baidu.ar.arrender.c cVar = this.g;
        if (cVar == null || cVar.bt() == null) {
            return false;
        }
        return this.g.bt().isSyncInputContent();
    }

    public void a(long j) {
    }

    public void a(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper);
    }

    public void a(a aVar) {
        this.C = aVar;
    }

    public void a(g gVar, com.baidu.ar.arrender.c cVar, com.baidu.ar.filter.a aVar) {
        this.h = gVar;
        this.g = cVar;
        this.B = aVar;
        this.mInputWidth = cVar.bt().getInputWidth();
        this.mInputHeight = cVar.bt().getInputHeight();
        this.mOutputWidth = cVar.bu().getOutputWidth();
        this.mOutputHeight = cVar.bu().getOutputHeight();
        this.S = cVar.bt().getInputDegree();
        this.f1034T = cVar.bt().isCameraInput();
        this.mIsFrontCamera = cVar.bt().isFrontCamera();
        c.b bVar = new c.b() { // from class: com.baidu.ar.c.1
            @Override // com.baidu.ar.arrender.c.b
            public void a(int i, int i2) {
                c cVar2 = c.this;
                cVar2.mOutputWidth = i;
                cVar2.mOutputHeight = i2;
            }
        };
        this.R = bVar;
        cVar.a(bVar);
        cVar.a(this);
        if (v()) {
            this.P = true;
        }
    }

    public final void a(k kVar) {
        com.baidu.ar.arrender.c cVar;
        if (kVar == null) {
            com.baidu.ar.h.b.b("AbstractAR", "removeDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && (cVar = this.g) != null) {
            j jVar = (j) kVar;
            cVar.destroyPixelReader(jVar.di(), jVar);
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(kVar);
        }
        List<k> list = this.O;
        if (list != null) {
            list.remove(kVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r2 != 270) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(k kVar, com.baidu.ar.d.e eVar) {
        PixelRotation pixelRotation;
        if (kVar == null) {
            com.baidu.ar.h.b.b("AbstractAR", "addDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.g != null) {
            this.O.add(kVar);
            j jVar = (j) kVar;
            jVar.a(this.mHandler);
            jVar.b(this.P);
            PixelReadParams di = jVar.di();
            if (this.f1034T && di.getIsPortrait()) {
                if (!this.mIsFrontCamera) {
                    pixelRotation = PixelRotation.RotateRight;
                    di.setPixelRotate(pixelRotation);
                    this.g.createPixelReader(di, jVar);
                }
                pixelRotation = PixelRotation.RotateRightFlipHorizontal;
                di.setPixelRotate(pixelRotation);
                this.g.createPixelReader(di, jVar);
            } else {
                if (!this.f1034T) {
                    int i = this.S;
                    if (i == 0) {
                        pixelRotation = PixelRotation.FlipVertical;
                    } else if (i == 90) {
                        pixelRotation = PixelRotation.RotateRightFlipVertical;
                    } else if (i == 180) {
                        pixelRotation = PixelRotation.FlipHorizontal;
                    }
                    di.setPixelRotate(pixelRotation);
                }
                this.g.createPixelReader(di, jVar);
            }
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(kVar, eVar);
        }
    }

    public void a(com.baidu.ar.imu.c cVar) {
        this.i = cVar;
    }

    public final void a(com.baidu.ar.imu.g gVar) {
        com.baidu.ar.imu.c cVar = this.i;
        if (cVar != null) {
            cVar.stop(gVar);
        }
    }

    public final void a(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar == null || bVar.fk() == null) {
            return;
        }
        this.f.fk().addLuaMsgListener(luaMsgListener);
    }

    public void a(com.baidu.ar.lua.b bVar) {
        this.f = bVar;
    }

    public final void a(com.baidu.ar.lua.c cVar) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.c(cVar);
        }
    }

    public void a(JSONObject jSONObject) {
        this.M = jSONObject;
    }

    public void a(boolean z) {
        this.mIsFrontCamera = z;
        for (k kVar : this.O) {
            if ((kVar instanceof j) && this.g != null) {
                PixelReadParams di = ((j) kVar).di();
                if (this.f1034T && di.getIsPortrait()) {
                    PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                    di.setPixelRotate(pixelRotation);
                    this.g.updatePixelReader(di, pixelRotation);
                }
            }
        }
    }

    public final boolean a(i iVar, com.baidu.ar.imu.g gVar) {
        com.baidu.ar.imu.c cVar = this.i;
        if (cVar != null) {
            return cVar.start(iVar, gVar);
        }
        return false;
    }

    public final boolean a(String str, com.baidu.ar.d.e eVar) {
        if (this.C == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        HashMap<String, com.baidu.ar.d.e> hashMap = this.N;
        if (hashMap != null) {
            hashMap.remove(str);
        }
        return this.C.a(str, eVar);
    }

    public final boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap) {
        if (this.C == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.N == null) {
            this.N = new HashMap<>();
        }
        this.N.put(str, eVar);
        return this.C.a(str, eVar, hashMap);
    }

    public void adjust(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (NativeConstants.COMPONENT_SYNC_TEXT_VIEW.equals(str)) {
            z = true;
        } else {
            "async".equals(str);
        }
        boolean z2 = v() ? true : z;
        if (z2 != this.P) {
            this.P = z2;
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
                }
                g gVar = this.h;
                if (gVar != null) {
                    gVar.a((j) kVar);
                }
            }
        }
    }

    public final void b(int i, HashMap<String, Object> hashMap) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.b(i, hashMap);
        }
    }

    public final void b(LuaMsgListener luaMsgListener) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar == null || bVar.fk() == null) {
            return;
        }
        this.f.fk().removeLuaMsgListener(luaMsgListener);
    }

    public final void b(com.baidu.ar.lua.c cVar) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.d(cVar);
        }
    }

    public void b(String str, com.baidu.ar.d.e eVar) {
        if (this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.d.a)) {
                ((com.baidu.ar.d.a) kVar).b(eVar);
            }
        }
    }

    public void b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            List<String> list2 = this.Q;
            if (list2 != null && !list2.contains(str)) {
                this.Q.add(str);
            }
        }
    }

    public final void b(boolean z) {
        if (v()) {
            z = true;
        }
        if (z != this.P) {
            this.P = z;
            List<k> list = this.O;
            if (list == null) {
                return;
            }
            for (k kVar : list) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
                }
                g gVar = this.h;
                if (gVar != null) {
                    gVar.a((j) kVar);
                }
            }
        }
    }

    public void c(String str, com.baidu.ar.d.e eVar) {
        if (this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.d.a)) {
                ((com.baidu.ar.d.a) kVar).c(eVar);
            }
        }
    }

    public final void d(HashMap<String, Object> hashMap) {
        com.baidu.ar.lua.b bVar = this.f;
        if (bVar != null) {
            bVar.b(1902, hashMap);
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getFaceModelPath() {
        return this.L;
    }

    public SparseArray<com.baidu.ar.mdl.a> getMdlConfigs() {
        com.baidu.ar.mdl.b bVar = this.e;
        if (bVar == null) {
            com.baidu.ar.h.b.b("AbstractAR", "mMdlConfigParams is null.");
            return new SparseArray<>();
        }
        return bVar.fm();
    }

    public void i(String str) {
        List<String> list = this.Q;
        if (list == null || list.contains(str)) {
            return;
        }
        this.Q.add(str);
    }

    public void j(String str) {
        List<String> list = this.Q;
        if (list != null) {
            list.remove(str);
        }
    }

    public void o() {
        List<String> list = this.Q;
        if (list != null) {
            list.clear();
        }
    }

    public void onCaseCreate(String str) {
    }

    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i, int i2) {
        com.baidu.ar.arrender.c cVar = this.g;
        if (cVar == null) {
            return;
        }
        this.mInputWidth = cVar.bt().getInputWidth();
        this.mInputHeight = this.g.bt().getInputHeight();
    }

    public boolean p() {
        List<String> list = this.Q;
        if (list == null || list.size() <= 0) {
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof com.baidu.ar.d.a) && ((com.baidu.ar.d.a) kVar).db()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void pause() {
    }

    public final List<String> q() {
        return this.Q;
    }

    public final l r() {
        return this.g;
    }

    public void release() {
        HashMap<String, com.baidu.ar.d.e> hashMap = this.N;
        if (hashMap != null) {
            for (Map.Entry<String, com.baidu.ar.d.e> entry : hashMap.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            this.N.clear();
            this.N = null;
        }
        int size = this.O.size();
        k[] kVarArr = new k[size];
        this.O.toArray(kVarArr);
        for (int i = 0; i < size; i++) {
            a(kVarArr[i]);
        }
        this.O.clear();
        this.O = null;
        this.h = null;
        this.i = null;
        this.g = null;
        this.B = null;
        this.f = null;
        this.M = null;
        this.mHandler = null;
        this.mContext = null;
    }

    public void resume() {
    }

    public final com.baidu.ar.filter.a s() {
        return this.B;
    }

    public void setFaceModelPath(String str) {
        this.L = str;
    }

    public void setMdlConfigParams(com.baidu.ar.mdl.b bVar) {
        this.e = bVar;
    }

    public void setup(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (!TextUtils.isEmpty(str) && NativeConstants.COMPONENT_SYNC_TEXT_VIEW.equals(str)) {
            this.P = true;
        }
        if (v()) {
            this.P = true;
        }
    }

    public JSONObject t() {
        return this.M;
    }

    public boolean u() {
        com.baidu.ar.arrender.c cVar = this.g;
        return (cVar == null || cVar.bt() == null || this.g.bt().getInputTexture() == null) ? false : true;
    }
}
