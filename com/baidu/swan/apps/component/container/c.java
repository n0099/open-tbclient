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
    com.baidu.swan.apps.view.b.a cqx;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cqy = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cqz = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cqx = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b agw = aVar.agw();
        String str = agw.cpo;
        String str2 = agw.cpp;
        String name = aVar.getName();
        SwanAppComponentContainerView agy = aVar.agy();
        if (agy == null) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cqy.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (agw.cpt == null) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!agw.cpt.isValid()) {
                com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert " + name + " with a invalid position: " + (agw.cpt == null ? "null" : agw.cpt));
                agw.cpt = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(agw)) {
                if (TextUtils.isEmpty(agw.cpr)) {
                    a2 = this.cqx.a(agy, agw.cpt);
                } else {
                    SwanAppComponentContainerView lG = lG(agw.cpr);
                    if (lG == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (lG.indexOfChild(agy) >= 0) {
                        com.baidu.swan.apps.component.e.a.bf("Component-Container", name + " repeat insert view!");
                        lG.removeView(agy);
                    }
                    lG.addView(agy, agw.agC());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, agw, agy);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bf("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cqy.put(agw.cpp, aVar);
                if (aVar.hm(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cqz.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cqz.put(str, list);
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
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b agw = aVar.agw();
        String name = aVar.getName();
        SwanAppComponentContainerView agy = aVar.agy();
        if (agy == null) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cqy.containsKey(agw.cpp)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.hq(7)) {
                boolean a2 = b.a(this, aVar, agw, agy, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bf("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.hq(8)) {
                b.b(this, aVar, agw, agy, bVar);
            }
        }
        if (bVar.hq(3) && !a(aVar, agy, agw)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.agp()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.agq()) {
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
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b agw = aVar.agw();
        String str = agw.cpo;
        String str2 = agw.cpp;
        String name = aVar.getName();
        SwanAppComponentContainerView agy = aVar.agy();
        if (agy == null) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(agw)) {
                if (TextUtils.isEmpty(agw.cpr)) {
                    c = this.cqx.removeView(agy);
                } else {
                    SwanAppComponentContainerView lG = lG(agw.cpr);
                    if (lG == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (lG == agy.getParent()) {
                        lG.removeView(agy);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bf("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, agw, agy);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bf("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.hm(1)) {
                this.cqy.remove(str2);
                if (aVar.hm(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cqz.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cqy.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cqy.clear();
        this.cqz.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cpt == null || !bVar.cpt.isValid()) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cpt == null ? "null" : bVar.cpt));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cpr;
        if (TextUtils.isEmpty(str)) {
            return this.cqx.b(swanAppComponentContainerView, bVar.cpt);
        }
        SwanAppComponentContainerView lG = lG(str);
        if (lG == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == lG) {
            lG.updateViewLayout(swanAppComponentContainerView, bVar.agC());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bf("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView lG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cqy.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.agy();
    }
}
