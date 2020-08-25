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
/* loaded from: classes8.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a cca;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> ccb = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> ccc = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cca = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b adc = aVar.adc();
        String str = adc.caS;
        String str2 = adc.caT;
        String name = aVar.getName();
        SwanAppComponentContainerView ade = aVar.ade();
        if (ade == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.ccb.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (adc.caX == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!adc.caX.isValid()) {
                com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a invalid position: " + (adc.caX == null ? "null" : adc.caX));
                adc.caX = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(adc)) {
                if (TextUtils.isEmpty(adc.caV)) {
                    a = this.cca.a(ade, adc.caX);
                } else {
                    SwanAppComponentContainerView kA = kA(adc.caV);
                    if (kA == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (kA.indexOfChild(ade) >= 0) {
                        com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " repeat insert view!");
                        kA.removeView(ade);
                    }
                    kA.addView(ade, adc.adi());
                    a = true;
                }
            } else {
                a = b.a(this, adc, ade);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.ccb.put(adc.caT, aVar);
                if (aVar.gG(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.ccc.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.ccc.put(str, list);
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
        com.baidu.swan.apps.component.b.b adc = aVar.adc();
        String name = aVar.getName();
        SwanAppComponentContainerView ade = aVar.ade();
        if (ade == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.ccb.containsKey(adc.caT)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.gK(7)) {
                boolean a = b.a(this, aVar, adc, ade, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.gK(8)) {
                b.b(this, aVar, adc, ade, bVar);
            }
        }
        if (bVar.gK(3) && !a(aVar, ade, adc)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.acV()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.acW()) {
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
        com.baidu.swan.apps.component.b.b adc = aVar.adc();
        String str = adc.caS;
        String str2 = adc.caT;
        String name = aVar.getName();
        SwanAppComponentContainerView ade = aVar.ade();
        if (ade == null) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(adc)) {
                if (TextUtils.isEmpty(adc.caV)) {
                    c = this.cca.removeView(ade);
                } else {
                    SwanAppComponentContainerView kA = kA(adc.caV);
                    if (kA == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (kA == ade.getParent()) {
                        kA.removeView(ade);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.ba("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, adc, ade);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.gG(1)) {
                this.ccb.remove(str2);
                if (aVar.gG(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.ccc.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.ccb.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.ccb.clear();
        this.ccc.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.caX == null || !bVar.caX.isValid()) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "insert " + name + " with a invalid position: " + (bVar.caX == null ? "null" : bVar.caX));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.caV;
        if (TextUtils.isEmpty(str)) {
            return this.cca.b(swanAppComponentContainerView, bVar.caX);
        }
        SwanAppComponentContainerView kA = kA(str);
        if (kA == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == kA) {
            kA.updateViewLayout(swanAppComponentContainerView, bVar.adi());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.ba("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView kA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.ccb.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.ade();
    }
}
