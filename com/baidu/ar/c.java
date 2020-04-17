package com.baidu.ar;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arrender.c;
import com.baidu.ar.c.g;
import com.baidu.ar.c.j;
import com.baidu.ar.c.k;
import com.baidu.ar.imu.i;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c {
    private a A;
    private String L;
    private JSONObject M;
    private HashMap<String, com.baidu.ar.c.e> N;
    private c.a R;
    protected int S;
    protected int T;
    protected int U;
    private com.baidu.ar.mdl.b d;
    private com.baidu.ar.lua.b e;
    private com.baidu.ar.arrender.c f;
    private g g;
    private com.baidu.ar.imu.c h;
    private Context mContext;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private com.baidu.ar.filter.a w;
    private List<k> O = new ArrayList();
    private boolean P = false;
    private List<String> Q = new CopyOnWriteArrayList();
    protected boolean V = true;
    protected boolean mIsFrontCamera = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, com.baidu.ar.c.e eVar);

        boolean a(String str, com.baidu.ar.c.e eVar, HashMap<String, Object> hashMap);
    }

    private boolean u() {
        if (this.f == null || this.f.ba() == null || !(this.f.ba() instanceof DuMixInput2)) {
            return false;
        }
        return ((DuMixInput2) this.f.ba()).isSyncInputContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, g gVar, com.baidu.ar.arrender.c cVar, com.baidu.ar.filter.a aVar) {
        this.mContext = context;
        this.g = gVar;
        this.f = cVar;
        this.w = aVar;
        this.S = cVar.ba().getInputWidth();
        this.T = cVar.ba().getInputHeight();
        this.mOutputWidth = cVar.bb().getOutputWidth();
        this.mOutputHeight = cVar.bb().getOutputHeight();
        this.U = cVar.ba().getInputDegree();
        this.V = cVar.ba().isCameraInput();
        this.mIsFrontCamera = cVar.ba().isFrontCamera();
        this.R = new c.a() { // from class: com.baidu.ar.c.1
            @Override // com.baidu.ar.arrender.c.a
            public void a(int i, int i2) {
                c.this.mOutputWidth = i;
                c.this.mOutputHeight = i2;
            }
        };
        cVar.a(this.R);
        if (u()) {
            this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.A = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("AbstractAR", "removeDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.f != null) {
            j jVar = (j) kVar;
            this.f.a(jVar.ct(), jVar);
        }
        if (this.g != null) {
            this.g.a(kVar);
        }
        if (this.O != null) {
            this.O.remove(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar, com.baidu.ar.c.e eVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("AbstractAR", "addDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.f != null) {
            this.O.add(kVar);
            j jVar = (j) kVar;
            jVar.b(this.P);
            PixelReadParams ct = jVar.ct();
            if (!this.V || !ct.getIsPortrait()) {
                if (!this.V) {
                    switch (this.U) {
                        case 0:
                            ct.setPixelRotate(PixelRotation.FlipVertical);
                            break;
                        case 90:
                            ct.setPixelRotate(PixelRotation.RotateRightFlipVertical);
                            break;
                        case 180:
                            ct.setPixelRotate(PixelRotation.FlipHorizontal);
                            break;
                        case 270:
                            ct.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                            break;
                    }
                }
            } else if (this.mIsFrontCamera) {
                ct.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
            } else {
                ct.setPixelRotate(PixelRotation.RotateRight);
            }
            this.f.createPixelReader(ct, jVar);
        }
        if (this.g != null) {
            this.g.a(kVar, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.imu.c cVar) {
        this.h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.ar.imu.g gVar) {
        if (this.h != null) {
            this.h.stop(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LuaMsgListener luaMsgListener) {
        if (this.e == null || this.e.dJ() == null) {
            return;
        }
        this.e.dJ().addLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.lua.b bVar) {
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.ar.lua.c cVar) {
        if (this.e != null) {
            this.e.c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.M = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.mIsFrontCamera = z;
        for (k kVar : this.O) {
            if ((kVar instanceof j) && this.f != null) {
                PixelReadParams ct = ((j) kVar).ct();
                if (ct.getIsPortrait()) {
                    PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                    ct.setPixelRotate(pixelRotation);
                    this.f.a(ct, pixelRotation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(i iVar, com.baidu.ar.imu.g gVar) {
        if (this.h != null) {
            return this.h.start(iVar, gVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, com.baidu.ar.c.e eVar) {
        if (this.A == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.N != null) {
            this.N.remove(str);
        }
        return this.A.a(str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, com.baidu.ar.c.e eVar, HashMap<String, Object> hashMap) {
        if (this.A == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.N == null) {
            this.N = new HashMap<>();
        }
        this.N.put(str, eVar);
        return this.A.a(str, eVar, hashMap);
    }

    public void adjust(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = u() ? true : "sync".equals(str) ? true : "async".equals(str) ? false : false;
        if (z != this.P) {
            this.P = z;
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
                }
                if (this.g != null) {
                    this.g.a((j) kVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i, HashMap<String, Object> hashMap) {
        if (this.e != null) {
            this.e.b(i, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LuaMsgListener luaMsgListener) {
        if (this.e == null || this.e.dJ() == null) {
            return;
        }
        this.e.dJ().removeLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(com.baidu.ar.lua.c cVar) {
        if (this.e != null) {
            this.e.d(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, com.baidu.ar.c.e eVar) {
        if (this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.c.a)) {
                ((com.baidu.ar.c.a) kVar).b(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (this.Q != null && !this.Q.contains(str)) {
                this.Q.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(boolean z) {
        if (u()) {
            z = true;
        }
        if (z != this.P) {
            this.P = z;
            if (this.O == null) {
                return;
            }
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
                }
                if (this.g != null) {
                    this.g.a((j) kVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, com.baidu.ar.c.e eVar) {
        if (this.O == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.O) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.c.a)) {
                ((com.baidu.ar.c.a) kVar).c(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(HashMap<String, Object> hashMap) {
        if (this.e != null) {
            this.e.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.mContext;
    }

    public String getFaceModelPath() {
        return this.L;
    }

    public SparseArray<com.baidu.ar.mdl.a> getMdlConfigs() {
        if (this.d == null) {
            com.baidu.ar.f.b.b("AbstractAR", "mMdlConfigParams is null.");
            return new SparseArray<>();
        }
        return this.d.dL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        if (this.Q != null) {
            this.Q.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.Q != null) {
            this.Q.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCaseCreate(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCaseDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        if (this.Q == null || this.Q.size() <= 0) {
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof com.baidu.ar.c.a) && ((com.baidu.ar.c.a) kVar).ck()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void pause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> q() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.baidu.ar.arrender.j r() {
        return this.f;
    }

    public void release() {
        if (this.N != null) {
            for (Map.Entry<String, com.baidu.ar.c.e> entry : this.N.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            this.N.clear();
            this.N = null;
        }
        k[] kVarArr = new k[this.O.size()];
        this.O.toArray(kVarArr);
        for (k kVar : kVarArr) {
            a(kVar);
        }
        this.O.clear();
        this.O = null;
        this.g = null;
        this.h = null;
        this.f = null;
        this.w = null;
        this.e = null;
        this.M = null;
        this.mContext = null;
    }

    public void resume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.baidu.ar.filter.a s() {
        return this.w;
    }

    public void setFaceModelPath(String str) {
        this.L = str;
    }

    public void setMdlConfigParams(com.baidu.ar.mdl.b bVar) {
        this.d = bVar;
    }

    public void setup(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (!TextUtils.isEmpty(str) && "sync".equals(str)) {
            this.P = true;
        }
        if (u()) {
            this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject t() {
        return this.M;
    }
}
