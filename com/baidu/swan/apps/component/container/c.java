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
    com.baidu.swan.apps.view.b.a bHQ;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bHR = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bHS = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bHQ = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Sz = aVar.Sz();
        String str = Sz.bGH;
        String str2 = Sz.bGI;
        String name = aVar.getName();
        SwanAppComponentContainerView SB = aVar.SB();
        if (SB == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bHR.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (Sz.bGM == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!Sz.bGM.isValid()) {
                com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a invalid position: " + (Sz.bGM == null ? "null" : Sz.bGM));
                Sz.bGM = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(Sz)) {
                if (TextUtils.isEmpty(Sz.bGK)) {
                    a = this.bHQ.a(SB, Sz.bGM);
                } else {
                    SwanAppComponentContainerView hI = hI(Sz.bGK);
                    if (hI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (hI.indexOfChild(SB) >= 0) {
                        com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " repeat insert view!");
                        hI.removeView(SB);
                    }
                    hI.addView(SB, Sz.SF());
                    a = true;
                }
            } else {
                a = b.a(this, Sz, SB);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bHR.put(Sz.bGI, aVar);
                if (aVar.ek(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bHS.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bHS.put(str, list);
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
        com.baidu.swan.apps.component.b.b Sz = aVar.Sz();
        String name = aVar.getName();
        SwanAppComponentContainerView SB = aVar.SB();
        if (SB == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bHR.containsKey(Sz.bGI)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.eo(7)) {
                boolean a = b.a(this, aVar, Sz, SB, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.eo(8)) {
                b.b(this, aVar, Sz, SB, bVar);
            }
        }
        if (bVar.eo(3) && !a(aVar, SB, Sz)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Ss()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.St()) {
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
        com.baidu.swan.apps.component.b.b Sz = aVar.Sz();
        String str = Sz.bGH;
        String str2 = Sz.bGI;
        String name = aVar.getName();
        SwanAppComponentContainerView SB = aVar.SB();
        if (SB == null) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(Sz)) {
                if (TextUtils.isEmpty(Sz.bGK)) {
                    c = this.bHQ.av(SB);
                } else {
                    SwanAppComponentContainerView hI = hI(Sz.bGK);
                    if (hI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (hI == SB.getParent()) {
                        hI.removeView(SB);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aC("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, Sz, SB);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ek(1)) {
                this.bHR.remove(str2);
                if (aVar.ek(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bHS.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bHR.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bHR.clear();
        this.bHS.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bGM == null || !bVar.bGM.isValid()) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bGM == null ? "null" : bVar.bGM));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aC("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bGK;
        if (TextUtils.isEmpty(str)) {
            return this.bHQ.b(swanAppComponentContainerView, bVar.bGM);
        }
        SwanAppComponentContainerView hI = hI(str);
        if (hI == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == hI) {
            hI.updateViewLayout(swanAppComponentContainerView, bVar.SF());
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
        com.baidu.swan.apps.component.b.a aVar = this.bHR.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.SB();
    }
}
