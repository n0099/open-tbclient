package com.baidu.ar;

import android.content.Context;
import android.os.Looper;
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
    private com.baidu.ar.filter.a A;
    private a B;
    private String K;
    private JSONObject L;
    private HashMap<String, com.baidu.ar.c.e> M;
    private c.a Q;
    protected int R;
    protected int S;
    protected int T;
    private Looper b;
    private com.baidu.ar.mdl.b e;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private g h;
    private com.baidu.ar.imu.c i;
    private Context mContext;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private List<k> N = new ArrayList();
    private boolean O = false;
    private List<String> P = new CopyOnWriteArrayList();
    protected boolean U = true;
    protected boolean mIsFrontCamera = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, com.baidu.ar.c.e eVar);

        boolean a(String str, com.baidu.ar.c.e eVar, HashMap<String, Object> hashMap);
    }

    private boolean v() {
        if (this.g == null || this.g.bo() == null || !(this.g.bo() instanceof DuMixInput2)) {
            return false;
        }
        return ((DuMixInput2) this.g.bo()).isSyncInputContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, Looper looper) {
        this.mContext = context;
        this.b = looper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.B = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar, com.baidu.ar.arrender.c cVar, com.baidu.ar.filter.a aVar) {
        this.h = gVar;
        this.g = cVar;
        this.A = aVar;
        this.R = cVar.bo().getInputWidth();
        this.S = cVar.bo().getInputHeight();
        this.mOutputWidth = cVar.bp().getOutputWidth();
        this.mOutputHeight = cVar.bp().getOutputHeight();
        this.T = cVar.bo().getInputDegree();
        this.U = cVar.bo().isCameraInput();
        this.mIsFrontCamera = cVar.bo().isFrontCamera();
        this.Q = new c.a() { // from class: com.baidu.ar.c.1
            @Override // com.baidu.ar.arrender.c.a
            public void a(int i, int i2) {
                c.this.mOutputWidth = i;
                c.this.mOutputHeight = i2;
            }
        };
        cVar.a(this.Q);
        if (v()) {
            this.O = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("AbstractAR", "removeDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.g != null) {
            j jVar = (j) kVar;
            this.g.a(jVar.cJ(), jVar);
        }
        if (this.h != null) {
            this.h.a(kVar);
        }
        if (this.N != null) {
            this.N.remove(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar, com.baidu.ar.c.e eVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("AbstractAR", "addDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.g != null) {
            this.N.add(kVar);
            j jVar = (j) kVar;
            jVar.a(this.b);
            jVar.b(this.O);
            PixelReadParams cJ = jVar.cJ();
            if (!this.U || !cJ.getIsPortrait()) {
                if (!this.U) {
                    switch (this.T) {
                        case 0:
                            cJ.setPixelRotate(PixelRotation.FlipVertical);
                            break;
                        case 90:
                            cJ.setPixelRotate(PixelRotation.RotateRightFlipVertical);
                            break;
                        case 180:
                            cJ.setPixelRotate(PixelRotation.FlipHorizontal);
                            break;
                        case 270:
                            cJ.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                            break;
                    }
                }
            } else if (this.mIsFrontCamera) {
                cJ.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
            } else {
                cJ.setPixelRotate(PixelRotation.RotateRight);
            }
            this.g.createPixelReader(cJ, jVar);
        }
        if (this.h != null) {
            this.h.a(kVar, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.imu.c cVar) {
        this.i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.ar.imu.g gVar) {
        if (this.i != null) {
            this.i.stop(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.dZ() == null) {
            return;
        }
        this.f.dZ().addLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.ar.lua.b bVar) {
        this.f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.ar.lua.c cVar) {
        if (this.f != null) {
            this.f.c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.L = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.mIsFrontCamera = z;
        for (k kVar : this.N) {
            if ((kVar instanceof j) && this.g != null) {
                PixelReadParams cJ = ((j) kVar).cJ();
                if (this.U && cJ.getIsPortrait()) {
                    PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                    cJ.setPixelRotate(pixelRotation);
                    this.g.a(cJ, pixelRotation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(i iVar, com.baidu.ar.imu.g gVar) {
        if (this.i != null) {
            return this.i.start(iVar, gVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, com.baidu.ar.c.e eVar) {
        if (this.B == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.M != null) {
            this.M.remove(str);
        }
        return this.B.a(str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, com.baidu.ar.c.e eVar, HashMap<String, Object> hashMap) {
        if (this.B == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.M == null) {
            this.M = new HashMap<>();
        }
        this.M.put(str, eVar);
        return this.B.a(str, eVar, hashMap);
    }

    public void adjust(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = v() ? true : "sync".equals(str) ? true : "async".equals(str) ? false : false;
        if (z != this.O) {
            this.O = z;
            for (k kVar : this.N) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.O);
                }
                if (this.h != null) {
                    this.h.a((j) kVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i, HashMap<String, Object> hashMap) {
        if (this.f != null) {
            this.f.b(i, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.dZ() == null) {
            return;
        }
        this.f.dZ().removeLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(com.baidu.ar.lua.c cVar) {
        if (this.f != null) {
            this.f.d(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, com.baidu.ar.c.e eVar) {
        if (this.N == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.N) {
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
            if (this.P != null && !this.P.contains(str)) {
                this.P.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(boolean z) {
        if (v()) {
            z = true;
        }
        if (z != this.O) {
            this.O = z;
            if (this.N == null) {
                return;
            }
            for (k kVar : this.N) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.O);
                }
                if (this.h != null) {
                    this.h.a((j) kVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, com.baidu.ar.c.e eVar) {
        if (this.N == null || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        for (k kVar : this.N) {
            if (kVar != null && str.equals(kVar.getName()) && (kVar instanceof com.baidu.ar.c.a)) {
                ((com.baidu.ar.c.a) kVar).c(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(HashMap<String, Object> hashMap) {
        if (this.f != null) {
            this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.mContext;
    }

    public String getFaceModelPath() {
        return this.K;
    }

    public SparseArray<com.baidu.ar.mdl.a> getMdlConfigs() {
        if (this.e == null) {
            com.baidu.ar.f.b.b("AbstractAR", "mMdlConfigParams is null.");
            return new SparseArray<>();
        }
        return this.e.eb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        if (this.P != null) {
            this.P.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.P != null) {
            this.P.clear();
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
        if (this.P == null || this.P.size() <= 0) {
            for (k kVar : this.N) {
                if (kVar != null && (kVar instanceof com.baidu.ar.c.a) && ((com.baidu.ar.c.a) kVar).cC()) {
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
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.baidu.ar.arrender.j r() {
        return this.g;
    }

    public void release() {
        if (this.M != null) {
            for (Map.Entry<String, com.baidu.ar.c.e> entry : this.M.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            this.M.clear();
            this.M = null;
        }
        k[] kVarArr = new k[this.N.size()];
        this.N.toArray(kVarArr);
        for (k kVar : kVarArr) {
            a(kVar);
        }
        this.N.clear();
        this.N = null;
        this.h = null;
        this.i = null;
        this.g = null;
        this.A = null;
        this.f = null;
        this.L = null;
        this.b = null;
        this.mContext = null;
    }

    public void resume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.baidu.ar.filter.a s() {
        return this.A;
    }

    public void setFaceModelPath(String str) {
        this.K = str;
    }

    public void setMdlConfigParams(com.baidu.ar.mdl.b bVar) {
        this.e = bVar;
    }

    public void setup(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String str = (String) hashMap.get("detect_sync");
        if (!TextUtils.isEmpty(str) && "sync".equals(str)) {
            this.O = true;
        }
        if (v()) {
            this.O = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject t() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        return (this.g == null || this.g.bo() == null || !(this.g.bo() instanceof DuMixInput2)) ? false : true;
    }
}
