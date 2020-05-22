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
    com.baidu.swan.apps.view.b.a bQN;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bQO = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bQP = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bQN = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Vj = aVar.Vj();
        String str = Vj.bPE;
        String str2 = Vj.bPF;
        String name = aVar.getName();
        SwanAppComponentContainerView Vl = aVar.Vl();
        if (Vl == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bQO.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (Vj.bPJ == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!Vj.bPJ.isValid()) {
                com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert " + name + " with a invalid position: " + (Vj.bPJ == null ? "null" : Vj.bPJ));
                Vj.bPJ = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(Vj)) {
                if (TextUtils.isEmpty(Vj.bPH)) {
                    a = this.bQN.a(Vl, Vj.bPJ);
                } else {
                    SwanAppComponentContainerView iI = iI(Vj.bPH);
                    if (iI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (iI.indexOfChild(Vl) >= 0) {
                        com.baidu.swan.apps.component.e.a.aS("Component-Container", name + " repeat insert view!");
                        iI.removeView(Vl);
                    }
                    iI.addView(Vl, Vj.Vp());
                    a = true;
                }
            } else {
                a = b.a(this, Vj, Vl);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aS("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bQO.put(Vj.bPF, aVar);
                if (aVar.et(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bQP.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bQP.put(str, list);
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
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Vj = aVar.Vj();
        String name = aVar.getName();
        SwanAppComponentContainerView Vl = aVar.Vl();
        if (Vl == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bQO.containsKey(Vj.bPF)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.ex(7)) {
                boolean a = b.a(this, aVar, Vj, Vl, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aS("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.ex(8)) {
                b.b(this, aVar, Vj, Vl, bVar);
            }
        }
        if (bVar.ex(3) && !a(aVar, Vl, Vj)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Vc()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.Vd()) {
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
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Vj = aVar.Vj();
        String str = Vj.bPE;
        String str2 = Vj.bPF;
        String name = aVar.getName();
        SwanAppComponentContainerView Vl = aVar.Vl();
        if (Vl == null) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(Vj)) {
                if (TextUtils.isEmpty(Vj.bPH)) {
                    c = this.bQN.av(Vl);
                } else {
                    SwanAppComponentContainerView iI = iI(Vj.bPH);
                    if (iI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (iI == Vl.getParent()) {
                        iI.removeView(Vl);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aS("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, Vj, Vl);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aS("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.et(1)) {
                this.bQO.remove(str2);
                if (aVar.et(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bQP.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bQO.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bQO.clear();
        this.bQP.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bPJ == null || !bVar.bPJ.isValid()) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bPJ == null ? "null" : bVar.bPJ));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bPH;
        if (TextUtils.isEmpty(str)) {
            return this.bQN.b(swanAppComponentContainerView, bVar.bPJ);
        }
        SwanAppComponentContainerView iI = iI(str);
        if (iI == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == iI) {
            iI.updateViewLayout(swanAppComponentContainerView, bVar.Vp());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.aS("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView iI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bQO.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.Vl();
    }
}
