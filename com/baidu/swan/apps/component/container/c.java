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
/* loaded from: classes3.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a ceh;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cei = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cej = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.ceh = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b adL = aVar.adL();
        String str = adL.ccY;
        String str2 = adL.ccZ;
        String name = aVar.getName();
        SwanAppComponentContainerView adN = aVar.adN();
        if (adN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cei.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (adL.cdd == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!adL.cdd.isValid()) {
                com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a invalid position: " + (adL.cdd == null ? "null" : adL.cdd));
                adL.cdd = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(adL)) {
                if (TextUtils.isEmpty(adL.cdb)) {
                    a = this.ceh.a(adN, adL.cdd);
                } else {
                    SwanAppComponentContainerView kU = kU(adL.cdb);
                    if (kU == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (kU.indexOfChild(adN) >= 0) {
                        com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " repeat insert view!");
                        kU.removeView(adN);
                    }
                    kU.addView(adN, adL.adR());
                    a = true;
                }
            } else {
                a = b.a(this, adL, adN);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.cei.put(adL.ccZ, aVar);
                if (aVar.gP(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cej.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cej.put(str, list);
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
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b adL = aVar.adL();
        String name = aVar.getName();
        SwanAppComponentContainerView adN = aVar.adN();
        if (adN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cei.containsKey(adL.ccZ)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.gT(7)) {
                boolean a = b.a(this, aVar, adL, adN, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.gT(8)) {
                b.b(this, aVar, adL, adN, bVar);
            }
        }
        if (bVar.gT(3) && !a(aVar, adN, adL)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.adE()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.adF()) {
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
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b adL = aVar.adL();
        String str = adL.ccY;
        String str2 = adL.ccZ;
        String name = aVar.getName();
        SwanAppComponentContainerView adN = aVar.adN();
        if (adN == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(adL)) {
                if (TextUtils.isEmpty(adL.cdb)) {
                    c = this.ceh.removeView(adN);
                } else {
                    SwanAppComponentContainerView kU = kU(adL.cdb);
                    if (kU == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (kU == adN.getParent()) {
                        kU.removeView(adN);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, adL, adN);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.gP(1)) {
                this.cei.remove(str2);
                if (aVar.gP(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cej.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cei.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cei.clear();
        this.cej.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cdd == null || !bVar.cdd.isValid()) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cdd == null ? "null" : bVar.cdd));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cdb;
        if (TextUtils.isEmpty(str)) {
            return this.ceh.b(swanAppComponentContainerView, bVar.cdd);
        }
        SwanAppComponentContainerView kU = kU(str);
        if (kU == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == kU) {
            kU.updateViewLayout(swanAppComponentContainerView, bVar.adR());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView kU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cei.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.adN();
    }
}
