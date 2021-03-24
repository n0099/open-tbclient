package com.baidu.platform.comapi.wnplatform.f;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.wnplatform.h.c;
import com.baidu.platform.comapi.wnplatform.h.e;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.platform.comjni.jninative.vibrate.IVibrateListener;
import com.baidu.platform.comjni.jninative.vibrate.VibrateHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.h.a, com.baidu.platform.comapi.wnplatform.h.b, IVibrateListener {

    /* renamed from: c  reason: collision with root package name */
    public Activity f10262c;

    /* renamed from: a  reason: collision with root package name */
    public IWRouteGuidanceListener f10260a = null;

    /* renamed from: b  reason: collision with root package name */
    public IBRouteGuidanceListener f10261b = null;

    /* renamed from: d  reason: collision with root package name */
    public int f10263d = -1;

    public b(Activity activity) {
        this.f10262c = activity;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onGetRouteDetailInfo(a.a(bundle));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i;
        if (this.f10262c == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide mIBRouteGuidanceListener:" + this.f10261b);
        int i2 = bundle.getInt("simpleUpdateType");
        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide updateType:" + i2 + "  data:" + bundle);
        if (i2 == e.a.f10275a || i2 == e.a.f10278d) {
            return;
        }
        if (bundle.containsKey("enGuideType") && (i = bundle.getInt("enGuideType")) < RouteGuideKind.values().length) {
            IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
            if (iBRouteGuidanceListener != null) {
                iBRouteGuidanceListener.onRouteGuideKind(RouteGuideKind.values()[i]);
            } else {
                IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
                if (iWRouteGuidanceListener != null) {
                    iWRouteGuidanceListener.onRouteGuideKind(RouteGuideKind.values()[i]);
                }
            }
        }
        com.baidu.platform.comapi.walknavi.g.a.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
        if (bundle.containsKey("enGuideType")) {
            int a2 = com.baidu.platform.comapi.bikenavi.c.a.a(c.b(RouteGuideKind.values()[bundle.getInt("enGuideType")]));
            if (this.f10263d == a2) {
                return;
            }
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                IBRouteGuidanceListener iBRouteGuidanceListener2 = this.f10261b;
                if (iBRouteGuidanceListener2 != null) {
                    iBRouteGuidanceListener2.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, a2));
                } else {
                    IWRouteGuidanceListener iWRouteGuidanceListener2 = this.f10260a;
                    if (iWRouteGuidanceListener2 != null) {
                        iWRouteGuidanceListener2.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, a2));
                    }
                }
            } else {
                IBRouteGuidanceListener iBRouteGuidanceListener3 = this.f10261b;
                if (iBRouteGuidanceListener3 != null) {
                    iBRouteGuidanceListener3.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, a2));
                } else {
                    IWRouteGuidanceListener iWRouteGuidanceListener3 = this.f10260a;
                    if (iWRouteGuidanceListener3 != null) {
                        iWRouteGuidanceListener3.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, a2));
                    }
                }
            }
            this.f10263d = a2;
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide getResources ID:" + a2);
        }
        if (bundle.containsKey("nRemainDist")) {
            String string = bundle.getString("usGuideText");
            int[] intArray = bundle.getIntArray("unIdx");
            bundle.getIntArray("unWordCnt");
            int[] intArray2 = bundle.getIntArray("unLineNo");
            bundle.getBooleanArray("bHighLight");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (string.contains("@")) {
                string = string.replace("@", StringHelper.STRING_MORE);
            }
            if (intArray.length == 0) {
                return;
            }
            int i3 = intArray2[0];
            int i4 = 0;
            while (true) {
                if (i4 >= intArray.length) {
                    break;
                } else if (intArray2[i4] != i3) {
                    i3 = i4;
                    break;
                } else {
                    i3 = intArray2[i4];
                    i4++;
                }
            }
            sb.append((CharSequence) string, 0, intArray[i3]);
            sb2.append((CharSequence) string, intArray[i3], string.length());
            sb2.append("");
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide onRoadGuideTextUpdate:" + sb.toString());
            IBRouteGuidanceListener iBRouteGuidanceListener4 = this.f10261b;
            if (iBRouteGuidanceListener4 != null) {
                iBRouteGuidanceListener4.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                return;
            }
            IWRouteGuidanceListener iWRouteGuidanceListener4 = this.f10260a;
            if (iWRouteGuidanceListener4 != null) {
                iWRouteGuidanceListener4.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        int i = bundle.getInt("totaldist");
        int i2 = bundle.getInt("totaltime");
        StringBuffer stringBuffer = new StringBuffer();
        f.a(i, f.a.ZH, stringBuffer);
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onRemainDistanceUpdate(stringBuffer.toString());
            this.f10261b.onRemainTimeUpdate(f.a(i2, 2));
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onRemainDistanceUpdate(stringBuffer.toString());
            this.f10260a.onRemainTimeUpdate(f.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onReRouteComplete();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onReRouteComplete();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onArriveDest();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onArriveDest();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comjni.jninative.vibrate.IVibrateListener
    public void onVibrate() {
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null) {
            iBRouteGuidanceListener.onVibrate();
            return;
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
        if (iWRouteGuidanceListener != null) {
            iWRouteGuidanceListener.onVibrate();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f10260a = null;
        this.f10261b = null;
        if (this.f10262c != null) {
            this.f10262c = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        Activity activity = this.f10262c;
        if (activity == null) {
            return;
        }
        IBRouteGuidanceListener iBRouteGuidanceListener = this.f10261b;
        if (iBRouteGuidanceListener != null && message.arg1 == 0) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                iBRouteGuidanceListener.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837575));
                return;
            } else {
                iBRouteGuidanceListener.onGpsStatusChange(activity.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.f10262c.getResources().getDrawable(2130837575));
                return;
            }
        }
        IWRouteGuidanceListener iWRouteGuidanceListener = this.f10260a;
        if (iWRouteGuidanceListener == null || message.arg1 != 0) {
            return;
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
            iWRouteGuidanceListener.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837575));
        } else {
            iWRouteGuidanceListener.onGpsStatusChange(this.f10262c.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.f10262c.getResources().getDrawable(2130837575));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
        Activity activity = this.f10262c;
        if (activity == null) {
            return;
        }
        if (this.f10261b != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                this.f10261b.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837587));
                return;
            }
            this.f10261b.onRoutePlanYawing(activity.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.f10262c.getResources().getDrawable(2130837587));
        } else if (this.f10260a != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                this.f10260a.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837587));
                return;
            }
            this.f10260a.onRoutePlanYawing(activity.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.f10262c.getResources().getDrawable(2130837587));
        }
    }

    public void a(IWRouteGuidanceListener iWRouteGuidanceListener) {
        this.f10260a = iWRouteGuidanceListener;
        if (iWRouteGuidanceListener != null) {
            com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.a) this);
            com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.b) this);
            com.baidu.platform.comapi.walknavi.b.a().P().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.a) this);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.b) this);
        com.baidu.platform.comapi.walknavi.b.a().P().b(this);
        VibrateHelper.removeVibrateListener(this);
    }

    public void a(IBRouteGuidanceListener iBRouteGuidanceListener) {
        this.f10261b = iBRouteGuidanceListener;
        if (iBRouteGuidanceListener != null) {
            com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.a) this);
            com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.b) this);
            com.baidu.platform.comapi.walknavi.b.a().P().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.a) this);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.b) this);
        com.baidu.platform.comapi.walknavi.b.a().P().b(this);
        VibrateHelper.removeVibrateListener(this);
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void b(Message message) {
        Activity activity = this.f10262c;
        if (activity == null) {
            return;
        }
        if (this.f10261b != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                this.f10261b.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837572));
                return;
            }
            this.f10261b.onRouteFarAway(activity.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.f10262c.getResources().getDrawable(2130837572));
        } else if (this.f10260a != null) {
            if (com.baidu.platform.comapi.bikenavi.a.a.f9824a) {
                this.f10260a.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f10262c, 2130837572));
                return;
            }
            this.f10260a.onRouteFarAway(activity.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.f10262c.getResources().getDrawable(2130837572));
        }
    }
}
