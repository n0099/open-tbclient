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
/* loaded from: classes10.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a cyY;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cyZ = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cza = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cyY = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aiq = aVar.aiq();
        String str = aiq.cxQ;
        String str2 = aiq.cxR;
        String name = aVar.getName();
        SwanAppComponentContainerView ais = aVar.ais();
        if (ais == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cyZ.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (aiq.cxV == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!aiq.cxV.isValid()) {
                com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a invalid position: " + (aiq.cxV == null ? "null" : aiq.cxV));
                aiq.cxV = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(aiq)) {
                if (TextUtils.isEmpty(aiq.cxT)) {
                    a2 = this.cyY.a(ais, aiq.cxV);
                } else {
                    SwanAppComponentContainerView lZ = lZ(aiq.cxT);
                    if (lZ == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (lZ.indexOfChild(ais) >= 0) {
                        com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " repeat insert view!");
                        lZ.removeView(ais);
                    }
                    lZ.addView(ais, aiq.aiw());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, aiq, ais);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cyZ.put(aiq.cxR, aVar);
                if (aVar.hx(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cza.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cza.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return a2;
        }
    }

    @UiThread
    public boolean a(com.baidu.swan.apps.component.b.a aVar, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aiq = aVar.aiq();
        String name = aVar.getName();
        SwanAppComponentContainerView ais = aVar.ais();
        if (ais == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cyZ.containsKey(aiq.cxR)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.hB(7)) {
                boolean a2 = b.a(this, aVar, aiq, ais, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.hB(8)) {
                b.b(this, aVar, aiq, ais, bVar);
            }
        }
        if (bVar.hB(3) && !a(aVar, ais, aiq)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.aij()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.aik()) {
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
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aiq = aVar.aiq();
        String str = aiq.cxQ;
        String str2 = aiq.cxR;
        String name = aVar.getName();
        SwanAppComponentContainerView ais = aVar.ais();
        if (ais == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(aiq)) {
                if (TextUtils.isEmpty(aiq.cxT)) {
                    c = this.cyY.removeView(ais);
                } else {
                    SwanAppComponentContainerView lZ = lZ(aiq.cxT);
                    if (lZ == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (lZ == ais.getParent()) {
                        lZ.removeView(ais);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, aiq, ais);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.hx(1)) {
                this.cyZ.remove(str2);
                if (aVar.hx(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cza.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cyZ.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cyZ.clear();
        this.cza.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cxV == null || !bVar.cxV.isValid()) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cxV == null ? "null" : bVar.cxV));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cxT;
        if (TextUtils.isEmpty(str)) {
            return this.cyY.b(swanAppComponentContainerView, bVar.cxV);
        }
        SwanAppComponentContainerView lZ = lZ(str);
        if (lZ == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == lZ) {
            lZ.updateViewLayout(swanAppComponentContainerView, bVar.aiw());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView lZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cyZ.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.ais();
    }
}
