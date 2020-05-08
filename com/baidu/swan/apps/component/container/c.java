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
/* loaded from: classes11.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a bHV;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bHW = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bHX = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bHV = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Sy = aVar.Sy();
        String str = Sy.bGM;
        String str2 = Sy.bGN;
        String name = aVar.getName();
        SwanAppComponentContainerView SA = aVar.SA();
        if (SA == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bHW.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (Sy.bGR == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!Sy.bGR.isValid()) {
                com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a invalid position: " + (Sy.bGR == null ? "null" : Sy.bGR));
                Sy.bGR = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(Sy)) {
                if (TextUtils.isEmpty(Sy.bGP)) {
                    a = this.bHV.a(SA, Sy.bGR);
                } else {
                    SwanAppComponentContainerView hI = hI(Sy.bGP);
                    if (hI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (hI.indexOfChild(SA) >= 0) {
                        com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " repeat insert view!");
                        hI.removeView(SA);
                    }
                    hI.addView(SA, Sy.SE());
                    a = true;
                }
            } else {
                a = b.a(this, Sy, SA);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bHW.put(Sy.bGN, aVar);
                if (aVar.ek(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bHX.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bHX.put(str, list);
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
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Sy = aVar.Sy();
        String name = aVar.getName();
        SwanAppComponentContainerView SA = aVar.SA();
        if (SA == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bHW.containsKey(Sy.bGN)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.eo(7)) {
                boolean a = b.a(this, aVar, Sy, SA, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.eo(8)) {
                b.b(this, aVar, Sy, SA, bVar);
            }
        }
        if (bVar.eo(3) && !a(aVar, SA, Sy)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Sr()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.Ss()) {
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
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Sy = aVar.Sy();
        String str = Sy.bGM;
        String str2 = Sy.bGN;
        String name = aVar.getName();
        SwanAppComponentContainerView SA = aVar.SA();
        if (SA == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(Sy)) {
                if (TextUtils.isEmpty(Sy.bGP)) {
                    c = this.bHV.av(SA);
                } else {
                    SwanAppComponentContainerView hI = hI(Sy.bGP);
                    if (hI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (hI == SA.getParent()) {
                        hI.removeView(SA);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, Sy, SA);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ek(1)) {
                this.bHW.remove(str2);
                if (aVar.ek(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bHX.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bHW.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bHW.clear();
        this.bHX.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bGR == null || !bVar.bGR.isValid()) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bGR == null ? "null" : bVar.bGR));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bGP;
        if (TextUtils.isEmpty(str)) {
            return this.bHV.b(swanAppComponentContainerView, bVar.bGR);
        }
        SwanAppComponentContainerView hI = hI(str);
        if (hI == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == hI) {
            hI.updateViewLayout(swanAppComponentContainerView, bVar.SE());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView hI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bHW.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.SA();
    }
}
