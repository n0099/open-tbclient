package com.baidu.platform.comapi.wnplatform.f;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.wnplatform.h.c;
import com.baidu.platform.comapi.wnplatform.h.e;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.platform.comjni.jninative.vibrate.IVibrateListener;
import com.baidu.platform.comjni.jninative.vibrate.VibrateHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.h.a, com.baidu.platform.comapi.wnplatform.h.b, IVibrateListener {
    private Activity c;

    /* renamed from: a  reason: collision with root package name */
    private IWRouteGuidanceListener f4404a = null;

    /* renamed from: b  reason: collision with root package name */
    private IBRouteGuidanceListener f4405b = null;
    private int d = -1;

    public b(Activity activity) {
        this.c = activity;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4404a = null;
        this.f4405b = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        if (this.f4405b != null) {
            this.f4405b.onGetRouteDetailInfo(a.a(bundle));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (this.c != null) {
            if (this.f4405b != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4405b.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837575));
                } else {
                    this.f4405b.onGpsStatusChange(this.c.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.c.getResources().getDrawable(2130837575));
                }
            } else if (this.f4404a != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4404a.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837575));
                } else {
                    this.f4404a.onGpsStatusChange(this.c.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.c.getResources().getDrawable(2130837575));
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i;
        if (this.c != null) {
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide mIBRouteGuidanceListener:" + this.f4405b);
            int i2 = bundle.getInt("simpleUpdateType");
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide updateType:" + i2 + "  data:" + bundle);
            if (i2 != e.a.f4411a && i2 != e.a.d) {
                if (bundle.containsKey("enGuideType") && (i = bundle.getInt("enGuideType")) < RouteGuideKind.values().length) {
                    if (this.f4405b != null) {
                        this.f4405b.onRouteGuideKind(RouteGuideKind.values()[i]);
                    } else if (this.f4404a != null) {
                        this.f4404a.onRouteGuideKind(RouteGuideKind.values()[i]);
                    }
                }
                com.baidu.platform.comapi.walknavi.g.a.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
                if (bundle.containsKey("enGuideType")) {
                    int a2 = com.baidu.platform.comapi.bikenavi.c.a.a(c.b(RouteGuideKind.values()[bundle.getInt("enGuideType")]));
                    if (this.d != a2) {
                        if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                            if (this.f4405b != null) {
                                this.f4405b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a2));
                            } else if (this.f4404a != null) {
                                this.f4404a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a2));
                            }
                        } else if (this.f4405b != null) {
                            this.f4405b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a2));
                        } else if (this.f4404a != null) {
                            this.f4404a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a2));
                        }
                        this.d = a2;
                        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide getResources ID:" + a2);
                    } else {
                        return;
                    }
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
                    if (intArray.length != 0) {
                        int i3 = intArray2[0];
                        int i4 = 0;
                        while (true) {
                            if (i4 >= intArray.length) {
                                i4 = i3;
                                break;
                            } else if (intArray2[i4] != i3) {
                                break;
                            } else {
                                i3 = intArray2[i4];
                                i4++;
                            }
                        }
                        sb.append((CharSequence) string, 0, intArray[i4]);
                        sb2.append((CharSequence) string, intArray[i4], string.length());
                        sb2.append("");
                        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide onRoadGuideTextUpdate:" + sb.toString());
                        if (this.f4405b != null) {
                            this.f4405b.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                        } else if (this.f4404a != null) {
                            this.f4404a.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        int i = bundle.getInt("totaldist");
        int i2 = bundle.getInt("totaltime");
        StringBuffer stringBuffer = new StringBuffer();
        f.a(i, f.a.ZH, stringBuffer);
        if (this.f4405b != null) {
            this.f4405b.onRemainDistanceUpdate(stringBuffer.toString());
            this.f4405b.onRemainTimeUpdate(f.a(i2, 2));
        } else if (this.f4404a != null) {
            this.f4404a.onRemainDistanceUpdate(stringBuffer.toString());
            this.f4404a.onRemainTimeUpdate(f.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void b(Message message) {
        if (this.c != null) {
            if (this.f4405b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4405b.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837572));
                    return;
                }
                this.f4405b.onRouteFarAway(this.c.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.c.getResources().getDrawable(2130837572));
            } else if (this.f4404a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4404a.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837572));
                    return;
                }
                this.f4404a.onRouteFarAway(this.c.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.c.getResources().getDrawable(2130837572));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
        if (this.c != null) {
            if (this.f4405b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4405b.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837587));
                    return;
                }
                this.f4405b.onRoutePlanYawing(this.c.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.c.getResources().getDrawable(2130837587));
            } else if (this.f4404a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4143a) {
                    this.f4404a.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, 2130837587));
                    return;
                }
                this.f4404a.onRoutePlanYawing(this.c.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.c.getResources().getDrawable(2130837587));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        if (this.f4405b != null) {
            this.f4405b.onReRouteComplete();
        } else if (this.f4404a != null) {
            this.f4404a.onReRouteComplete();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        if (this.f4405b != null) {
            this.f4405b.onArriveDest();
        } else if (this.f4404a != null) {
            this.f4404a.onArriveDest();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comjni.jninative.vibrate.IVibrateListener
    public void onVibrate() {
        if (this.f4405b != null) {
            this.f4405b.onVibrate();
        } else if (this.f4404a != null) {
            this.f4404a.onVibrate();
        }
    }

    public void a(IWRouteGuidanceListener iWRouteGuidanceListener) {
        this.f4404a = iWRouteGuidanceListener;
        if (this.f4404a != null) {
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
        this.f4405b = iBRouteGuidanceListener;
        if (this.f4405b != null) {
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
}
