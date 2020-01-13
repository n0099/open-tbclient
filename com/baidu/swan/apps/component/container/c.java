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
    com.baidu.swan.apps.view.b.a bff;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bfg = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bfh = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bff = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Ir = aVar.Ir();
        String str = Ir.bdU;
        String str2 = Ir.bdV;
        String name = aVar.getName();
        SwanAppComponentContainerView It = aVar.It();
        if (It == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bfg.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (Ir.bdZ == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!Ir.bdZ.isValid()) {
                com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert " + name + " with a invalid position: " + (Ir.bdZ == null ? "null" : Ir.bdZ));
                Ir.bdZ = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(Ir)) {
                if (TextUtils.isEmpty(Ir.bdX)) {
                    a = this.bff.a(It, Ir.bdZ);
                } else {
                    SwanAppComponentContainerView gg = gg(Ir.bdX);
                    if (gg == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (gg.indexOfChild(It) >= 0) {
                        com.baidu.swan.apps.component.e.a.ak("Component-Container", name + " repeat insert view!");
                        gg.removeView(It);
                    }
                    gg.addView(It, Ir.Ix());
                    a = true;
                }
            } else {
                a = b.a(this, Ir, It);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ak("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bfg.put(Ir.bdV, aVar);
                if (aVar.dP(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bfh.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bfh.put(str, list);
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
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Ir = aVar.Ir();
        String name = aVar.getName();
        SwanAppComponentContainerView It = aVar.It();
        if (It == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bfg.containsKey(Ir.bdV)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.dT(7)) {
                boolean a = b.a(this, aVar, Ir, It, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.ak("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.dT(8)) {
                b.b(this, aVar, Ir, It, bVar);
            }
        }
        if (bVar.dT(3) && !a(aVar, It, Ir)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Ik()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.Il()) {
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
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Ir = aVar.Ir();
        String str = Ir.bdU;
        String str2 = Ir.bdV;
        String name = aVar.getName();
        SwanAppComponentContainerView It = aVar.It();
        if (It == null) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(Ir)) {
                if (TextUtils.isEmpty(Ir.bdX)) {
                    c = this.bff.au(It);
                } else {
                    SwanAppComponentContainerView gg = gg(Ir.bdX);
                    if (gg == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (gg == It.getParent()) {
                        gg.removeView(It);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.ak("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, Ir, It);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.ak("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.dP(1)) {
                this.bfg.remove(str2);
                if (aVar.dP(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bfh.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bfg.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bfg.clear();
        this.bfh.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bdZ == null || !bVar.bdZ.isValid()) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bdZ == null ? "null" : bVar.bdZ));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bdX;
        if (TextUtils.isEmpty(str)) {
            return this.bff.b(swanAppComponentContainerView, bVar.bdZ);
        }
        SwanAppComponentContainerView gg = gg(str);
        if (gg == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == gg) {
            gg.updateViewLayout(swanAppComponentContainerView, bVar.Ix());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.ak("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView gg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bfg.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.It();
    }
}
