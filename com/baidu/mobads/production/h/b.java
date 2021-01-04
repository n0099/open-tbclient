package com.baidu.mobads.production.h;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.video.XAdContext;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.production.v;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.mobads.production.b implements IXLinearAdSlot, IOAdEventDispatcher {
    private a w;
    private boolean x;

    public b(Context context, String str) {
        super(context);
        setId(str);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL;
        this.x = true;
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 8000;
    }

    @Override // com.baidu.mobads.production.b
    public void g() {
        this.s.i("XPrerollAdSlot", "afterAdContainerInit()");
        dispatchEvent(new com.baidu.mobads.openad.c.b(com.baidu.mobads.openad.c.b.COMPLETE));
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        int i;
        int i2;
        this.w = new a(getApplicationContext(), getActivity(), this.o, this);
        this.w.d(getId());
        HashMap<String, String> parameter = getParameter();
        String str = parameter.get(XAdContext.PARAMETER_KEY_OF_BASE_WIDTH);
        String str2 = parameter.get(XAdContext.PARAMETER_KEY_OF_BASE_HEIGHT);
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (str2 != null) {
            try {
                i2 = Integer.parseInt(str2);
            } catch (Exception e2) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        this.w.d(i);
        this.w.e(i2);
        super.a(this.w);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(c cVar, v vVar, int i) {
        String str = getParameter().get(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT);
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (Exception e) {
            }
        }
        vVar.a(cVar, i);
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == IXAdInstanceInfo.CreativeType.GIF) {
            com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.w.d();
            JSONObject attribute = bVar.getAttribute();
            JSONObject jSONObject = attribute == null ? new JSONObject() : attribute;
            try {
                jSONObject.put("supportTipView", this.x);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bVar.a(jSONObject);
            start();
        }
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getStartTrackers());
        a(hashSet);
    }

    private void a(Set<String> set) {
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        for (String str : set) {
            c cVar = new c(str, "");
            cVar.e = 1;
            aVar.a(cVar, (Boolean) true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.b
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.e(iXAdContainer, hashMap);
        this.l = IXAdConstants4PDK.SlotState.COMPLETED;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: q */
    public d getAdRequestInfo() {
        return this.w;
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.e = relativeLayout;
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setActivityState(IXAdConstants4PDK.ActivityState activityState) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setVideoState(IXAdConstants4PDK.VideoState videoState) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setParameter(String str, Object obj) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public Object getParameter(String str) {
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setContentVideoAssetCurrentTimePosition(double d) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void notifyVisitorAction(IXAdConstants4PDK.VisitorAction visitorAction) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setMaxDuration(int i) {
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setMaxAdNum(int i) {
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public int getDuration() {
        return this.h == null ? super.getDuration() : (int) this.h.getDuration();
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public int getPlayheadTime() {
        return this.h == null ? super.getPlayheadTime() : (int) this.h.getPlayheadTime();
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void load() {
        this.q.set(true);
        super.load();
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void start() {
        if (this.q.get()) {
            super.start();
        } else {
            load();
        }
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void stop() {
        this.s.i("XPrerollAdSlot", "stop()" + getSlotState().getValue());
        super.stop();
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void pause() {
        this.s.i("XPrerollAdSlot", "pause()" + getSlotState().getValue());
        if (getSlotState() == IXAdConstants4PDK.SlotState.PLAYING) {
            super.pause();
        }
    }

    @Override // com.baidu.mobads.production.b, com.baidu.mobads.interfaces.IXAdProd
    public void resume() {
        this.s.i("XPrerollAdSlot", "resume()" + getSlotState().getValue());
        if (getSlotState() == IXAdConstants4PDK.SlotState.PAUSED) {
            super.resume();
        }
    }

    @Override // com.baidu.mobads.interfaces.IXLinearAdSlot
    public void setSupportTipView(boolean z) {
        this.x = z;
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.b
    public boolean d() {
        return true;
    }
}
