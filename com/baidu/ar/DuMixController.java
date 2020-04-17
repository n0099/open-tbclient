package com.baidu.ar;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.f.l;
import com.baidu.ar.f.n;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DuMixController implements IDuMix, IFilter, IPhoto, IRecord {
    private com.baidu.ar.lua.e aM;
    private e aN;
    private OrientationManager aO;
    private com.baidu.ar.record.a aP;
    private IContentPlatform aQ;
    private DuMixInput aa;
    private DuMixOutput ab;
    protected DuMixCallback ac;
    private b af;
    private DefaultParams c;
    private com.baidu.ar.lua.b e;
    private com.baidu.ar.arrender.c f;
    private Context mContext;
    private com.baidu.ar.a.b u;
    private com.baidu.ar.filter.a w;

    public DuMixController(Context context, DefaultParams defaultParams) {
        if (context == null) {
            com.baidu.ar.f.b.b("DuMixController", "DuMixController() context must be set!!!");
            return;
        }
        if (defaultParams != null) {
            this.c = defaultParams;
        } else {
            this.c = new DefaultParams();
        }
        this.mContext = context;
        com.baidu.ar.f.b.U(this.c.isLogEnable());
        com.baidu.ar.f.a.setPackageName(context.getPackageName());
        this.aO = new OrientationManager(context);
        this.aO.setScreenOrientationLandscape(n.w(context));
        this.aN = new e(context, defaultParams);
        this.aN.a(this);
        StatisticApi.init(context);
        this.u = new com.baidu.ar.a.b(this.mContext);
        this.w = new com.baidu.ar.filter.a(this.c);
        this.af = new b(context, this.c, this.u, this.w);
        this.e = new com.baidu.ar.lua.b(this.mContext);
        if (this.c.isUseTextureIO()) {
            this.f = new com.baidu.ar.arrender.d(this.mContext, this.e, this.c.getShareContext());
        } else {
            this.f = new com.baidu.ar.arrender.c(this.mContext, this.e);
        }
        this.aN.a(this.f, this.af, this.w, this.e);
    }

    public static String getSoDownLoadDir(Context context) {
        return e.getSoDownLoadDir(context);
    }

    public static int getVersionCode() {
        return com.baidu.ar.f.c.getVersionCode();
    }

    public static String getVersionName() {
        return com.baidu.ar.f.c.getVersionName();
    }

    public boolean addAbility(String str, String str2) {
        return addAbility(str, str2, null);
    }

    public boolean addAbility(String str, String str2, String str3) {
        if (this.af != null) {
            return this.af.a(str, Arrays.asList(str2), str3);
        }
        return false;
    }

    public boolean addAbility(String str, List<String> list) {
        if (this.af != null) {
            return this.af.a(str, list, (String) null);
        }
        return false;
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.e == null || this.e.dJ() == null) {
            return false;
        }
        return this.e.dJ().addLuaMsgListener(luaMsgListener);
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.af == null || abilityType == null) {
            return false;
        }
        return this.af.adjustAbility(abilityType.getTypeValue(), hashMap);
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.af == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.af.adjustAbility(str, hashMap);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutput(DuMixOutput duMixOutput) {
        if (duMixOutput == null) {
            return;
        }
        this.ab = duMixOutput;
        if (this.f != null) {
            this.f.changeOutput(this.ab);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputSize(int i, int i2) {
        if (this.f != null) {
            this.f.changeOutputSize(i, i2);
        }
    }

    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        return com.baidu.ar.auth.a.checkAuth(this.mContext, bArr, iCallbackWith, iCallbackWith2);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void clearAllFilter() {
        if (this.w != null) {
            this.w.clearAllFilter();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void clearCase() {
        if (this.aN != null) {
            this.aN.clearCase();
        }
    }

    public ARProxyManager getARProxyManager() {
        if (this.af != null) {
            return this.af.getARProxyManager();
        }
        return null;
    }

    public List<String> getActiveAbilities() {
        if (this.af != null) {
            return this.af.getActiveAbilities();
        }
        return null;
    }

    public IContentPlatform getContentPlatform() {
        if (this.aQ == null) {
            this.aQ = (IContentPlatform) l.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.mContext});
        }
        return this.aQ;
    }

    public IGLRenderer getGLRenderer() {
        if (this.f == null || !(this.f instanceof IGLRenderer)) {
            return null;
        }
        return (IGLRenderer) this.f;
    }

    public IStepLoading getStepLoading() {
        if (this.f != null) {
            return this.f.bj();
        }
        return null;
    }

    public List<String> getSupportedAbilities() {
        if (this.af != null) {
            return this.af.getSupportedAbilities();
        }
        return null;
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        if (this.af == null || abilityType == null) {
            return false;
        }
        return this.af.isAbilityActive(abilityType.getTypeValue());
    }

    public boolean isAbilityActive(String str) {
        if (this.af == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.af.isAbilityActive(str);
    }

    public boolean isAbilitySupported(String str) {
        if (this.af != null) {
            return this.af.isAbilitySupported(str);
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.aN != null) {
            this.aN.loadCase(aRType, str, str2);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f != null) {
            return this.f.onTouch(view, motionEvent);
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        if (this.af != null) {
            this.af.pause();
        }
        if (this.f != null) {
            this.f.pause();
        }
        if (this.aO != null) {
            this.aO.disable();
        }
        StatisticApi.pause();
        if (this.aN != null) {
            this.aN.j("pause");
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (this.aP != null) {
            this.aP.pauseRecord();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void pauseScene() {
        if (this.f != null) {
            this.f.pauseScene();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        e.ah = true;
        this.aQ = null;
        if (this.aN != null) {
            this.aN.v();
        }
        if (this.aM != null) {
            this.aM.release();
            this.aM = null;
        }
        if (this.w != null) {
            this.w.clearAllFilter();
            this.w.release();
            this.w = null;
        }
        if (this.af != null) {
            this.af.release();
            this.af = null;
        }
        if (this.f != null) {
            this.f.release();
            this.f = null;
        }
        if (this.aO != null) {
            this.aO.destroy();
            this.aO = null;
        }
        if (this.u != null) {
            this.u.release();
            this.u = null;
        }
        com.baidu.ar.libloader.b.release();
        com.baidu.ar.auth.a.release();
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
        StatisticApi.release();
        if (this.e != null) {
            this.e.destroy();
            this.e = null;
        }
        if (this.aN != null) {
            this.aN.release();
            this.aN = null;
        }
        this.aa = null;
        this.ab = null;
        this.ac = null;
        this.c = null;
        this.mContext = null;
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.e == null || this.e.dJ() == null) {
            return false;
        }
        return this.e.dJ().removeLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        if (this.aN != null) {
            this.aN.j("resume");
        }
        StatisticApi.resume();
        if (this.aO != null) {
            this.aO.enable();
        }
        if (this.f != null) {
            this.f.resume();
        }
        if (this.af != null) {
            this.af.resume();
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.aP != null) {
            this.aP.resumeRecord();
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void resumeScene() {
        if (this.f != null) {
            this.f.resumeScene();
        }
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        if (this.e != null) {
            this.e.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
            return true;
        }
        return false;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        if (this.aM == null) {
            this.aM = new com.baidu.ar.lua.e(this.e);
        }
        this.aM.setDefinedLuaListener(definedLuaListener);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void setFilterStateListener(FilterStateListener filterStateListener) {
        if (this.w != null) {
            this.w.setFilterStateListener(filterStateListener);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.f != null) {
            this.f.setGLWebViewUseable(context, viewGroup);
        }
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        com.baidu.ar.libloader.b.setLibLoadPlugin(iLibLoaderPlugin);
    }

    public void setMdlModelPath(String str) {
        if (this.af != null) {
            this.af.setMdlModelPath(str);
        }
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.f != null) {
            this.f.setNativeWebViewUseable(context, viewGroup);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        if (duMixInput == null || duMixOutput == null || e.ag || e.ah) {
            com.baidu.ar.f.b.b("DuMixController", "setup error!!! params maybe null!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
            }
        } else if (this.aa != null || this.ab != null) {
            com.baidu.ar.f.b.b("DuMixController", "Dumix has setup,do not setup again!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
            }
        } else {
            e.ag = true;
            this.aa = duMixInput;
            this.ab = duMixOutput;
            this.ac = duMixCallback;
            if (this.aN != null) {
                this.aN.setup(duMixInput, duMixOutput, duMixCallback);
                this.aN.C();
                this.aN.B();
            }
            StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.aa.isCameraInput() ? PixelReadParams.DEFAULT_FILTER_ID : "video");
            StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
            this.aO.addOrientationListener(this.f);
            this.aO.enable();
            if (this.w != null) {
                this.w.a(this.f);
            }
            if (this.u != null) {
                JSONObject P = this.u.P();
                if (P != null) {
                    this.f.a(P);
                } else {
                    this.f.setLocalDeviceGrade(this.u.Q());
                }
            }
            if (this.af != null) {
                this.af.a(this.e, this.f);
            }
            this.f.a(this.aa, this.ab);
            if (this.aN != null) {
                this.aN.a(this.u);
                this.aN.D();
            }
        }
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.af == null || abilityType == null) {
            return false;
        }
        return this.af.startAbility(abilityType.getTypeValue(), hashMap);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (this.af == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.af.startAbility(str, hashMap);
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        if (this.aP == null && this.f != null) {
            this.aP = new com.baidu.ar.record.a(this.mContext, this.f);
        }
        if (this.aN != null) {
            this.aN.i("start");
        }
        if (this.aP != null) {
            this.aP.startRecord(str, j, recordCallback);
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        if (this.af == null || abilityType == null) {
            return false;
        }
        return this.af.stopAbility(abilityType.getTypeValue());
    }

    public boolean stopAbility(String str) {
        if (this.af == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.af.stopAbility(str);
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        if (this.aP != null) {
            this.aP.stopRecord();
            this.aP = null;
        }
        if (this.aN != null) {
            this.aN.i("stop");
        }
    }

    @Override // com.baidu.ar.photo.IPhoto
    public void takePicture(String str, PhotoCallback photoCallback) {
        new com.baidu.ar.photo.a().a(this.f, str, photoCallback);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float f) {
        if (this.w != null) {
            this.w.a(filterParam, Float.valueOf(f));
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, int i) {
        if (this.w != null) {
            this.w.a(filterParam, Integer.valueOf(i));
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, String str) {
        if (this.w != null) {
            this.w.a(filterParam, str);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, List<Point> list) {
        if (list != null) {
            float[] fArr = new float[list.size() * 2];
            for (int i = 0; i < list.size(); i++) {
                fArr[i * 2] = list.get(i).x;
                fArr[(i * 2) + 1] = list.get(i).y;
            }
            if (this.w != null) {
                this.w.a(filterParam, Integer.valueOf(list.size()), "_count", false);
                this.w.a(filterParam, fArr);
            }
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float[] fArr) {
        if (this.w != null) {
            this.w.a(filterParam, fArr);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public String updateFilterCase(String str) {
        if (this.w != null) {
            return this.w.updateFilterCase(str);
        }
        return null;
    }
}
