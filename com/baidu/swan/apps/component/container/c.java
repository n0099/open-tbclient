package com.baidu.swan.apps.component.container;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a bep;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> beq = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> ber = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bep = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b HV = aVar.HV();
        String str = HV.bdg;
        String str2 = HV.bdh;
        String name = aVar.getName();
        SwanAppComponentContainerView HX = aVar.HX();
        if (HX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.beq.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (HV.bdl == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!HV.bdl.isValid()) {
                com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert " + name + " with a invalid position: " + (HV.bdl == null ? "null" : HV.bdl));
                HV.bdl = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(HV)) {
                if (TextUtils.isEmpty(HV.bdj)) {
                    a = this.bep.a(HX, HV.bdl);
                } else {
                    SwanAppComponentContainerView gd = gd(HV.bdj);
                    if (gd == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (gd.indexOfChild(HX) >= 0) {
                        com.baidu.swan.apps.component.e.a.aj("Component-Container", name + " repeat insert view!");
                        gd.removeView(HX);
                    }
                    gd.addView(HX, HV.Ib());
                    a = true;
                }
            } else {
                a = b.a(this, HV, HX);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aj("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.beq.put(HV.bdh, aVar);
                if (aVar.dO(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.ber.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.ber.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return a;
        }
    }

    @UiThread
    public boolean a(com.baidu.swan.apps.component.b.a aVar, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b HV = aVar.HV();
        String name = aVar.getName();
        SwanAppComponentContainerView HX = aVar.HX();
        if (HX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.beq.containsKey(HV.bdh)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.dS(7)) {
                boolean a = b.a(this, aVar, HV, HX, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aj("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.dS(8)) {
                b.b(this, aVar, HV, HX, bVar);
            }
        }
        if (bVar.dS(3) && !a(aVar, HX, HV)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.HO()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.HP()) {
                    com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update with animation fail");
                    return false;
                }
            }
        }
        return true;
    }

    @UiThread
    public boolean f(com.baidu.swan.apps.component.b.a aVar) {
        boolean c;
        boolean z = false;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b HV = aVar.HV();
        String str = HV.bdg;
        String str2 = HV.bdh;
        String name = aVar.getName();
        SwanAppComponentContainerView HX = aVar.HX();
        if (HX == null) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(HV)) {
                if (TextUtils.isEmpty(HV.bdj)) {
                    c = this.bep.aq(HX);
                } else {
                    SwanAppComponentContainerView gd = gd(HV.bdj);
                    if (gd == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (gd == HX.getParent()) {
                        gd.removeView(HX);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aj("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, HV, HX);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aj("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.dO(1)) {
                this.beq.remove(str2);
                if (aVar.dO(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.ber.get(str);
                    if (list != null) {
                        list.remove(aVar);
                    }
                }
            }
            return c;
        }
    }

    public void onDestroy() {
        com.baidu.swan.apps.component.b.a value;
        if (DEBUG) {
            Log.d("Component-Container", "container destroy");
        }
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.beq.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.beq.clear();
        this.ber.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bdl == null || !bVar.bdl.isValid()) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bdl == null ? "null" : bVar.bdl));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bdj;
        if (TextUtils.isEmpty(str)) {
            return this.bep.b(swanAppComponentContainerView, bVar.bdl);
        }
        SwanAppComponentContainerView gd = gd(str);
        if (gd == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == gd) {
            gd.updateViewLayout(swanAppComponentContainerView, bVar.Ib());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.aj("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView gd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.beq.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.HX();
    }
}
