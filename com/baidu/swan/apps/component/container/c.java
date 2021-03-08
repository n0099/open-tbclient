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
    com.baidu.swan.apps.view.b.a cNZ;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cOa = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cOb = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cNZ = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b alh = aVar.alh();
        String str = alh.cMP;
        String str2 = alh.cMQ;
        String name = aVar.getName();
        SwanAppComponentContainerView alj = aVar.alj();
        if (alj == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cOa.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (alh.cMU == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!alh.cMU.isValid()) {
                com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a invalid position: " + (alh.cMU == null ? "null" : alh.cMU));
                alh.cMU = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(alh)) {
                if (TextUtils.isEmpty(alh.cMS)) {
                    a2 = this.cNZ.a(alj, alh.cMU);
                } else {
                    SwanAppComponentContainerView lW = lW(alh.cMS);
                    if (lW == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (lW.indexOfChild(alj) >= 0) {
                        com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " repeat insert view!");
                        lW.removeView(alj);
                    }
                    lW.addView(alj, alh.aln());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, alh, alj);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cOa.put(alh.cMQ, aVar);
                if (aVar.gt(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cOb.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cOb.put(str, list);
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
        com.baidu.swan.apps.component.b.b alh = aVar.alh();
        String name = aVar.getName();
        SwanAppComponentContainerView alj = aVar.alj();
        if (alj == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cOa.containsKey(alh.cMQ)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.gx(7)) {
                boolean a2 = b.a(this, aVar, alh, alj, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.gx(8)) {
                b.b(this, aVar, alh, alj, bVar);
            }
        }
        if (bVar.gx(3) && !a(aVar, alj, alh)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.ala()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.alb()) {
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
        com.baidu.swan.apps.component.b.b alh = aVar.alh();
        String str = alh.cMP;
        String str2 = alh.cMQ;
        String name = aVar.getName();
        SwanAppComponentContainerView alj = aVar.alj();
        if (alj == null) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(alh)) {
                if (TextUtils.isEmpty(alh.cMS)) {
                    c = this.cNZ.removeView(alj);
                } else {
                    SwanAppComponentContainerView lW = lW(alh.cMS);
                    if (lW == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (lW == alj.getParent()) {
                        lW.removeView(alj);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bk("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, alh, alj);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.gt(1)) {
                this.cOa.remove(str2);
                if (aVar.gt(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cOb.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cOa.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cOa.clear();
        this.cOb.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cMU == null || !bVar.cMU.isValid()) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cMU == null ? "null" : bVar.cMU));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cMS;
        if (TextUtils.isEmpty(str)) {
            return this.cNZ.b(swanAppComponentContainerView, bVar.cMU);
        }
        SwanAppComponentContainerView lW = lW(str);
        if (lW == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == lW) {
            lW.updateViewLayout(swanAppComponentContainerView, bVar.aln());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bk("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView lW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cOa.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.alj();
    }
}
