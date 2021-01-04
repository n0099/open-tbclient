package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.c;
import com.baidu.ar.arrender.l;
import com.baidu.ar.d.g;
import com.baidu.ar.d.j;
import com.baidu.ar.d.k;
import com.baidu.ar.imu.i;
import com.baidu.ar.lua.LuaMsgListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class c implements c.a {
    private com.baidu.ar.filter.a B;
    private a C;
    private String L;
    private JSONObject M;
    private HashMap<String, com.baidu.ar.d.e> N;
    private c.b R;
    protected int S;
    private com.baidu.ar.mdl.b e;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private g h;
    private com.baidu.ar.imu.c i;
    private Context mContext;
    private Handler mHandler;
    protected int mInputHeight;
    protected int mInputWidth;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private List<k> O = new ArrayList();
    private boolean P = false;
    private List<String> Q = new CopyOnWriteArrayList();
    protected boolean T = true;
    protected boolean mIsFrontCamera = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        boolean a(String str, com.baidu.ar.d.e eVar);

        boolean a(String str, com.baidu.ar.d.e eVar, HashMap<String, Object> hashMap);
    }

    private boolean v() {
        if (this.g == null || this.g.bt() == null) {
            return false;
        }
        return this.g.bt().isSyncInputContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.C = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar, com.baidu.ar.arrender.c cVar, com.baidu.ar.filter.a aVar) {
        this.h = gVar;
        this.g = cVar;
        this.B = aVar;
        this.mInputWidth = cVar.bt().getInputWidth();
        this.mInputHeight = cVar.bt().getInputHeight();
        this.mOutputWidth = cVar.bu().getOutputWidth();
        this.mOutputHeight = cVar.bu().getOutputHeight();
        this.S = cVar.bt().getInputDegree();
        this.T = cVar.bt().isCameraInput();
        this.mIsFrontCamera = cVar.bt().isFrontCamera();
        this.R = new c.b() { // from class: com.baidu.ar.c.1
            @Override // com.baidu.ar.arrender.c.b
            public void a(int i, int i2) {
                c.this.mOutputWidth = i;
                c.this.mOutputHeight = i2;
            }
        };
        cVar.a(this.R);
        cVar.a(this);
        if (v()) {
            this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.h.b.b("AbstractAR", "removeDetector error!!! detector is null!!!");
            return;
        }
        if ((kVar instanceof j) && this.g != null) {
            j jVar = (j) kVar;
            this.g.destroyPixelReader(jVar.di(), jVar);
        }
        if (this.h != null) {
            this.h.a(kVar);
        }
        if (this.O != null) {
            this.O.remove(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(k kVar, com.baidu.ar.d.e eVar) {
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
            if (!this.T || !di.getIsPortrait()) {
                if (!this.T) {
                    switch (this.S) {
                        case 0:
                            di.setPixelRotate(PixelRotation.FlipVertical);
                            break;
                        case 90:
                            di.setPixelRotate(PixelRotation.RotateRightFlipVertical);
                            break;
                        case 180:
                            di.setPixelRotate(PixelRotation.FlipHorizontal);
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            di.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
                            break;
                    }
                }
            } else if (this.mIsFrontCamera) {
                di.setPixelRotate(PixelRotation.RotateRightFlipHorizontal);
            } else {
                di.setPixelRotate(PixelRotation.RotateRight);
            }
            this.g.createPixelReader(di, jVar);
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
        if (this.f == null || this.f.fk() == null) {
            return;
        }
        this.f.fk().addLuaMsgListener(luaMsgListener);
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
        this.M = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.mIsFrontCamera = z;
        for (k kVar : this.O) {
            if ((kVar instanceof j) && this.g != null) {
                PixelReadParams di = ((j) kVar).di();
                if (this.T && di.getIsPortrait()) {
                    PixelRotation pixelRotation = z ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                    di.setPixelRotate(pixelRotation);
                    this.g.updatePixelReader(di, pixelRotation);
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
    public final boolean a(String str, com.baidu.ar.d.e eVar) {
        if (this.C == null || TextUtils.isEmpty(str) || eVar == null) {
            return false;
        }
        if (this.N != null) {
            this.N.remove(str);
        }
        return this.C.a(str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        boolean z = v() ? true : "sync".equals(str) ? true : "async".equals(str) ? false : false;
        if (z != this.P) {
            this.P = z;
            for (k kVar : this.O) {
                if (kVar != null && (kVar instanceof j)) {
                    ((j) kVar).b(this.P);
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
        if (this.f == null || this.f.fk() == null) {
            return;
        }
        this.f.fk().removeLuaMsgListener(luaMsgListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(com.baidu.ar.lua.c cVar) {
        if (this.f != null) {
            this.f.d(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        if (v()) {
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
                if (this.h != null) {
                    this.h.a((j) kVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        return this.L;
    }

    public SparseArray<com.baidu.ar.mdl.a> getMdlConfigs() {
        if (this.e == null) {
            com.baidu.ar.h.b.b("AbstractAR", "mMdlConfigParams is null.");
            return new SparseArray<>();
        }
        return this.e.fm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        if (this.Q == null || this.Q.contains(str)) {
            return;
        }
        this.Q.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
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

    @Override // com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i, int i2) {
        if (this.g == null) {
            return;
        }
        this.mInputWidth = this.g.bt().getInputWidth();
        this.mInputHeight = this.g.bt().getInputHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        if (this.Q == null || this.Q.size() <= 0) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> q() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final l r() {
        return this.g;
    }

    public void release() {
        if (this.N != null) {
            for (Map.Entry<String, com.baidu.ar.d.e> entry : this.N.entrySet()) {
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

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (!TextUtils.isEmpty(str) && "sync".equals(str)) {
            this.P = true;
        }
        if (v()) {
            this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject t() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        return (this.g == null || this.g.bt() == null || this.g.bt().getInputTexture() == null) ? false : true;
    }
}
