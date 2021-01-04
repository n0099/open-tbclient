package com.baidu.platform.comapi.wnplatform.g;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.wnplatform.i.c;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.platform.comjni.jninative.vibrate.IVibrateListener;
import com.baidu.platform.comjni.jninative.vibrate.VibrateHelper;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class b extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.i.a, com.baidu.platform.comapi.wnplatform.i.b, IVibrateListener {
    private Activity c;

    /* renamed from: a  reason: collision with root package name */
    private IWRouteGuidanceListener f4634a = null;

    /* renamed from: b  reason: collision with root package name */
    private IBRouteGuidanceListener f4635b = null;
    private int d = -1;

    public b(Activity activity) {
        this.c = activity;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.f4634a = null;
        this.f4635b = null;
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

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        if (this.f4635b != null) {
            this.f4635b.onGetRouteDetailInfo(a.a(bundle));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (this.c != null) {
            if (this.f4635b != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4635b.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837581));
                } else {
                    this.f4635b.onGpsStatusChange(this.c.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.c.getResources().getDrawable(2130837581));
                }
            } else if (this.f4634a != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4634a.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837581));
                } else {
                    this.f4634a.onGpsStatusChange(this.c.getResources().getString(R.drawable.res_0x7f08001c_ic_icon_mask_guide_tech_svg__0), this.c.getResources().getDrawable(2130837581));
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        int c;
        int i;
        if (this.c != null) {
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide mIBRouteGuidanceListener:" + this.f4635b);
            int i2 = bundle.getInt("simpleUpdateType");
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide updateType:" + i2 + "  data:" + bundle);
            if (i2 != e.a.f4641a && i2 != e.a.d) {
                if (bundle.containsKey("enGuideType") && (i = bundle.getInt("enGuideType")) < RouteGuideKind.values().length) {
                    if (this.f4635b != null) {
                        this.f4635b.onRouteGuideKind(RouteGuideKind.values()[i]);
                    } else if (this.f4634a != null) {
                        this.f4634a.onRouteGuideKind(RouteGuideKind.values()[i]);
                    }
                }
                com.baidu.platform.comapi.walknavi.g.b.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
                if (bundle.containsKey("enGuideType")) {
                    int i3 = bundle.getInt("enGuideType");
                    String str = "";
                    if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                        str = c.b(RouteGuideKind.values()[i3]);
                    } else if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                        str = c.a(RouteGuideKind.values()[i3]);
                    }
                    if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                        c = com.baidu.platform.comapi.bikenavi.c.a.a(str);
                    } else {
                        c = com.baidu.platform.comapi.wnplatform.a.a().f() ? com.baidu.platform.comapi.walknavi.g.b.c.c(str) : 0;
                    }
                    if (this.d != c) {
                        if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                            if (this.f4635b != null) {
                                this.f4635b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, c));
                            } else if (this.f4634a != null) {
                                this.f4634a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, c));
                            }
                        } else if (this.f4635b != null) {
                            this.f4635b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, c));
                        } else if (this.f4634a != null) {
                            this.f4634a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, c));
                        }
                        this.d = c;
                        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide getResources ID:" + c);
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
                        int i4 = intArray2[0];
                        int i5 = 0;
                        while (true) {
                            if (i5 >= intArray.length) {
                                i5 = i4;
                                break;
                            } else if (intArray2[i5] != i4) {
                                break;
                            } else {
                                i4 = intArray2[i5];
                                i5++;
                            }
                        }
                        sb.append((CharSequence) string, 0, intArray[i5]);
                        sb2.append((CharSequence) string, intArray[i5], string.length());
                        sb2.append("");
                        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide onRoadGuideTextUpdate:" + sb.toString());
                        if (this.f4635b != null) {
                            this.f4635b.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                        } else if (this.f4634a != null) {
                            this.f4634a.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        int i = bundle.getInt("totaldist");
        int i2 = bundle.getInt("totaltime");
        StringBuffer stringBuffer = new StringBuffer();
        g.a(i, g.b.ZH, stringBuffer);
        if (this.f4635b != null) {
            this.f4635b.onRemainDistanceUpdate(stringBuffer.toString());
            this.f4635b.onRemainTimeUpdate(g.a(i2, 2));
        } else if (this.f4634a != null) {
            this.f4634a.onRemainDistanceUpdate(stringBuffer.toString());
            this.f4634a.onRemainTimeUpdate(g.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        if (this.c != null) {
            if (this.f4635b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4635b.onRouteFarAway(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837578));
                    return;
                }
                this.f4635b.onRouteFarAway(this.c.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.c.getResources().getDrawable(2130837578));
            } else if (this.f4634a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4634a.onRouteFarAway(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837578));
                    return;
                }
                this.f4634a.onRouteFarAway(this.c.getResources().getString(R.drawable.res_0x7f08001a_ic_icon_mask_guide_sport_svg__0), this.c.getResources().getDrawable(2130837578));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
        if (this.c != null) {
            if (this.f4635b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4635b.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837606));
                    return;
                }
                this.f4635b.onRoutePlanYawing(this.c.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.c.getResources().getDrawable(2130837606));
            } else if (this.f4634a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.f4194a) {
                    this.f4634a.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.p.a.a.b().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), com.baidu.platform.comapi.wnplatform.p.a.a.a(this.c, 2130837606));
                    return;
                }
                this.f4634a.onRoutePlanYawing(this.c.getResources().getString(R.drawable.res_0x7f080016_ic_icon_mask_guide_leaf_svg__0), this.c.getResources().getDrawable(2130837606));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        if (this.f4635b != null) {
            this.f4635b.onReRouteComplete();
        } else if (this.f4634a != null) {
            this.f4634a.onReRouteComplete();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        if (this.f4635b != null) {
            this.f4635b.onArriveDest();
        } else if (this.f4634a != null) {
            this.f4634a.onArriveDest();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
        if (this.f4634a != null) {
            this.f4634a.onIndoorEnd(message);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
        if (this.f4635b != null) {
            this.f4635b.onArriveDest();
        } else if (this.f4634a != null) {
            this.f4634a.onFinalEnd(message);
        }
    }

    @Override // com.baidu.platform.comjni.jninative.vibrate.IVibrateListener
    public void onVibrate() {
        if (this.f4635b != null) {
            this.f4635b.onVibrate();
        } else if (this.f4634a != null) {
            this.f4634a.onVibrate();
        }
    }

    public void a(IWRouteGuidanceListener iWRouteGuidanceListener) {
        this.f4634a = iWRouteGuidanceListener;
        if (this.f4634a != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.a) this);
            com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.b) this);
            com.baidu.platform.comapi.walknavi.b.a().S().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().S().b(this);
        VibrateHelper.removeVibrateListener(this);
    }

    public void a(IBRouteGuidanceListener iBRouteGuidanceListener) {
        this.f4635b = iBRouteGuidanceListener;
        if (this.f4635b != null) {
            com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.a) this);
            com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.b) this);
            com.baidu.platform.comapi.walknavi.b.a().S().a(this);
            VibrateHelper.addVibrateListener(this);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().S().b(this);
        VibrateHelper.removeVibrateListener(this);
    }
}
