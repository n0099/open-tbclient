package com.baidu.swan.apps.component.container;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cMA = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cMB = new ArrayMap<>();
    @NonNull
    com.baidu.swan.apps.view.b.a cMz;

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cMz = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b ale = aVar.ale();
        String str = ale.cLp;
        String str2 = ale.cLq;
        String name = aVar.getName();
        SwanAppComponentContainerView alg = aVar.alg();
        if (alg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cMA.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (ale.cLu == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!ale.cLu.isValid()) {
                com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a invalid position: " + (ale.cLu == null ? "null" : ale.cLu));
                ale.cLu = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(ale)) {
                if (TextUtils.isEmpty(ale.cLs)) {
                    a2 = this.cMz.a(alg, ale.cLu);
                } else {
                    SwanAppComponentContainerView lP = lP(ale.cLs);
                    if (lP == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (lP.indexOfChild(alg) >= 0) {
                        com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " repeat insert view!");
                        lP.removeView(alg);
                    }
                    lP.addView(alg, ale.alk());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, ale, alg);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cMA.put(ale.cLq, aVar);
                if (aVar.gs(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cMB.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cMB.put(str, list);
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
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b ale = aVar.ale();
        String name = aVar.getName();
        SwanAppComponentContainerView alg = aVar.alg();
        if (alg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cMA.containsKey(ale.cLq)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.gw(7)) {
                boolean a2 = b.a(this, aVar, ale, alg, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.gw(8)) {
                b.b(this, aVar, ale, alg, bVar);
            }
        }
        if (bVar.gw(3) && !a(aVar, alg, ale)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.akX()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.akY()) {
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
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b ale = aVar.ale();
        String str = ale.cLp;
        String str2 = ale.cLq;
        String name = aVar.getName();
        SwanAppComponentContainerView alg = aVar.alg();
        if (alg == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(ale)) {
                if (TextUtils.isEmpty(ale.cLs)) {
                    c = this.cMz.removeView(alg);
                } else {
                    SwanAppComponentContainerView lP = lP(ale.cLs);
                    if (lP == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (lP == alg.getParent()) {
                        lP.removeView(alg);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, ale, alg);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.gs(1)) {
                this.cMA.remove(str2);
                if (aVar.gs(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cMB.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cMA.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cMA.clear();
        this.cMB.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cLu == null || !bVar.cLu.isValid()) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cLu == null ? "null" : bVar.cLu));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cLs;
        if (TextUtils.isEmpty(str)) {
            return this.cMz.b(swanAppComponentContainerView, bVar.cLu);
        }
        SwanAppComponentContainerView lP = lP(str);
        if (lP == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == lP) {
            lP.updateViewLayout(swanAppComponentContainerView, bVar.alk());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView lP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cMA.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.alg();
    }
}
