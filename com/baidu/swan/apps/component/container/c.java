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
    com.baidu.swan.apps.view.b.a bjt;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bju = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bjv = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bjt = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KG = aVar.KG();
        String str = KG.bij;
        String str2 = KG.bik;
        String name = aVar.getName();
        SwanAppComponentContainerView KI = aVar.KI();
        if (KI == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bju.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (KG.bip == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!KG.bip.isValid()) {
                com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a invalid position: " + (KG.bip == null ? "null" : KG.bip));
                KG.bip = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(KG)) {
                if (TextUtils.isEmpty(KG.bim)) {
                    a = this.bjt.a(KI, KG.bip);
                } else {
                    SwanAppComponentContainerView gw = gw(KG.bim);
                    if (gw == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (gw.indexOfChild(KI) >= 0) {
                        com.baidu.swan.apps.component.e.a.au("Component-Container", name + " repeat insert view!");
                        gw.removeView(KI);
                    }
                    gw.addView(KI, KG.KM());
                    a = true;
                }
            } else {
                a = b.a(this, KG, KI);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bju.put(KG.bik, aVar);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjv.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bjv.put(str, list);
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
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KG = aVar.KG();
        String name = aVar.getName();
        SwanAppComponentContainerView KI = aVar.KI();
        if (KI == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bju.containsKey(KG.bik)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.ej(7)) {
                boolean a = b.a(this, aVar, KG, KI, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.ej(8)) {
                b.b(this, aVar, KG, KI, bVar);
            }
        }
        if (bVar.ej(3) && !a(aVar, KI, KG)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Kz()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.KA()) {
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
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KG = aVar.KG();
        String str = KG.bij;
        String str2 = KG.bik;
        String name = aVar.getName();
        SwanAppComponentContainerView KI = aVar.KI();
        if (KI == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(KG)) {
                if (TextUtils.isEmpty(KG.bim)) {
                    c = this.bjt.au(KI);
                } else {
                    SwanAppComponentContainerView gw = gw(KG.bim);
                    if (gw == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (gw == KI.getParent()) {
                        gw.removeView(KI);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, KG, KI);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ef(1)) {
                this.bju.remove(str2);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjv.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bju.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bju.clear();
        this.bjv.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bip == null || !bVar.bip.isValid()) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bip == null ? "null" : bVar.bip));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bim;
        if (TextUtils.isEmpty(str)) {
            return this.bjt.b(swanAppComponentContainerView, bVar.bip);
        }
        SwanAppComponentContainerView gw = gw(str);
        if (gw == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == gw) {
            gw.updateViewLayout(swanAppComponentContainerView, bVar.KM());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView gw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bju.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.KI();
    }
}
