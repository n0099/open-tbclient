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
/* loaded from: classes8.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a cKl;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cKm = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cKn = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cKl = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b akG = aVar.akG();
        String str = akG.cJb;
        String str2 = akG.cJc;
        String name = aVar.getName();
        SwanAppComponentContainerView akI = aVar.akI();
        if (akI == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cKm.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (akG.cJg == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!akG.cJg.isValid()) {
                com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert " + name + " with a invalid position: " + (akG.cJg == null ? "null" : akG.cJg));
                akG.cJg = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(akG)) {
                if (TextUtils.isEmpty(akG.cJe)) {
                    a2 = this.cKl.a(akI, akG.cJg);
                } else {
                    SwanAppComponentContainerView lx = lx(akG.cJe);
                    if (lx == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (lx.indexOfChild(akI) >= 0) {
                        com.baidu.swan.apps.component.e.a.bq("Component-Container", name + " repeat insert view!");
                        lx.removeView(akI);
                    }
                    lx.addView(akI, akG.akM());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, akG, akI);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bq("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cKm.put(akG.cJc, aVar);
                if (aVar.gp(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cKn.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cKn.put(str, list);
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
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b akG = aVar.akG();
        String name = aVar.getName();
        SwanAppComponentContainerView akI = aVar.akI();
        if (akI == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cKm.containsKey(akG.cJc)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.gt(7)) {
                boolean a2 = b.a(this, aVar, akG, akI, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bq("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.gt(8)) {
                b.b(this, aVar, akG, akI, bVar);
            }
        }
        if (bVar.gt(3) && !a(aVar, akI, akG)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.akz()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.akA()) {
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
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b akG = aVar.akG();
        String str = akG.cJb;
        String str2 = akG.cJc;
        String name = aVar.getName();
        SwanAppComponentContainerView akI = aVar.akI();
        if (akI == null) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(akG)) {
                if (TextUtils.isEmpty(akG.cJe)) {
                    c = this.cKl.removeView(akI);
                } else {
                    SwanAppComponentContainerView lx = lx(akG.cJe);
                    if (lx == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (lx == akI.getParent()) {
                        lx.removeView(akI);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bq("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, akG, akI);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bq("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.gp(1)) {
                this.cKm.remove(str2);
                if (aVar.gp(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cKn.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cKm.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cKm.clear();
        this.cKn.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cJg == null || !bVar.cJg.isValid()) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cJg == null ? "null" : bVar.cJg));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cJe;
        if (TextUtils.isEmpty(str)) {
            return this.cKl.b(swanAppComponentContainerView, bVar.cJg);
        }
        SwanAppComponentContainerView lx = lx(str);
        if (lx == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == lx) {
            lx.updateViewLayout(swanAppComponentContainerView, bVar.akM());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bq("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView lx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cKm.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.akI();
    }
}
