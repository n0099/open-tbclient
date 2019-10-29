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
/* loaded from: classes5.dex */
public class b extends com.baidu.platform.comapi.walknavi.a implements com.baidu.platform.comapi.wnplatform.c.a, com.baidu.platform.comapi.wnplatform.h.a, com.baidu.platform.comapi.wnplatform.h.b, IVibrateListener {
    private Activity c;
    private IWRouteGuidanceListener a = null;
    private IBRouteGuidanceListener b = null;
    private int d = -1;

    public b(Activity activity) {
        this.c = activity;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        this.a = null;
        this.b = null;
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
        if (this.b != null) {
            this.b.onGetRouteDetailInfo(a.a(bundle));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (this.c != null) {
            if (this.b != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.b.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_display_3_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.abc_text_select_handle_left_mtrl_dark));
                } else {
                    this.b.onGpsStatusChange(this.c.getResources().getString(R.string.abc_font_family_display_3_material), this.c.getResources().getDrawable(R.drawable.abc_text_select_handle_left_mtrl_dark));
                }
            } else if (this.a != null && message.arg1 == 0) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.a.onGpsStatusChange(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_display_3_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.abc_text_select_handle_left_mtrl_dark));
                } else {
                    this.a.onGpsStatusChange(this.c.getResources().getString(R.string.abc_font_family_display_3_material), this.c.getResources().getDrawable(R.drawable.abc_text_select_handle_left_mtrl_dark));
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i;
        if (this.c != null) {
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide mIBRouteGuidanceListener:" + this.b);
            int i2 = bundle.getInt("simpleUpdateType");
            com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide updateType:" + i2 + "  data:" + bundle);
            if (i2 != e.a.a && i2 != e.a.d) {
                if (bundle.containsKey("enGuideType") && (i = bundle.getInt("enGuideType")) < RouteGuideKind.values().length) {
                    if (this.b != null) {
                        this.b.onRouteGuideKind(RouteGuideKind.values()[i]);
                    } else if (this.a != null) {
                        this.a.onRouteGuideKind(RouteGuideKind.values()[i]);
                    }
                }
                com.baidu.platform.comapi.walknavi.g.a.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
                if (bundle.containsKey("enGuideType")) {
                    int a = com.baidu.platform.comapi.bikenavi.c.a.a(c.b(RouteGuideKind.values()[bundle.getInt("enGuideType")]));
                    if (this.d != a) {
                        if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                            if (this.b != null) {
                                this.b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a));
                            } else if (this.a != null) {
                                this.a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a));
                            }
                        } else if (this.b != null) {
                            this.b.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a));
                        } else if (this.a != null) {
                            this.a.onRouteGuideIconUpdate(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, a));
                        }
                        this.d = a;
                        com.baidu.platform.comapi.wnplatform.d.a.a("OuterWalkGuideInfo", "OutWalkGuide getResources ID:" + a);
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
                        if (this.b != null) {
                            this.b.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
                        } else if (this.a != null) {
                            this.a.onRoadGuideTextUpdate(sb.toString(), sb2.toString());
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
        if (this.b != null) {
            this.b.onRemainDistanceUpdate(stringBuffer.toString());
            this.b.onRemainTimeUpdate(f.a(i2, 2));
        } else if (this.a != null) {
            this.a.onRemainDistanceUpdate(stringBuffer.toString());
            this.a.onRemainTimeUpdate(f.a(i2, 2));
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
            if (this.b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.b.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_display_1_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.abc_tab_indicator_material));
                    return;
                }
                this.b.onRouteFarAway(this.c.getResources().getString(R.string.abc_font_family_display_1_material), this.c.getResources().getDrawable(R.drawable.abc_tab_indicator_material));
            } else if (this.a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.a.onRouteFarAway(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_display_1_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.abc_tab_indicator_material));
                    return;
                }
                this.a.onRouteFarAway(this.c.getResources().getString(R.string.abc_font_family_display_1_material), this.c.getResources().getDrawable(R.drawable.abc_tab_indicator_material));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
        if (this.c != null) {
            if (this.b != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.b.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_body_1_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.account_active_account_check));
                    return;
                }
                this.b.onRoutePlanYawing(this.c.getResources().getString(R.string.abc_font_family_body_1_material), this.c.getResources().getDrawable(R.drawable.account_active_account_check));
            } else if (this.a != null) {
                if (com.baidu.platform.comapi.bikenavi.a.a.a) {
                    this.a.onRoutePlanYawing(com.baidu.platform.comapi.wnplatform.o.a.a.b().getString(R.string.abc_font_family_body_1_material), com.baidu.platform.comapi.wnplatform.o.a.a.a(this.c, (int) R.drawable.account_active_account_check));
                    return;
                }
                this.a.onRoutePlanYawing(this.c.getResources().getString(R.string.abc_font_family_body_1_material), this.c.getResources().getDrawable(R.drawable.account_active_account_check));
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        if (this.b != null) {
            this.b.onReRouteComplete();
        } else if (this.a != null) {
            this.a.onReRouteComplete();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        if (this.b != null) {
            this.b.onArriveDest();
        } else if (this.a != null) {
            this.a.onArriveDest();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comjni.jninative.vibrate.IVibrateListener
    public void onVibrate() {
        if (this.b != null) {
            this.b.onVibrate();
        } else if (this.a != null) {
            this.a.onVibrate();
        }
    }

    public void a(IWRouteGuidanceListener iWRouteGuidanceListener) {
        this.a = iWRouteGuidanceListener;
        if (this.a != null) {
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
        this.b = iBRouteGuidanceListener;
        if (this.b != null) {
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
