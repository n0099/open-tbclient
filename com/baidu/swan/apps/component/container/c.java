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
    com.baidu.swan.apps.view.b.a cOX;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cOY = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cOZ = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cOX = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aoA = aVar.aoA();
        String str = aoA.cNN;
        String str2 = aoA.cNO;
        String name = aVar.getName();
        SwanAppComponentContainerView aoC = aVar.aoC();
        if (aoC == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cOY.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (aoA.cNS == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!aoA.cNS.isValid()) {
                com.baidu.swan.apps.component.e.a.br("Component-Container", "insert " + name + " with a invalid position: " + (aoA.cNS == null ? "null" : aoA.cNS));
                aoA.cNS = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(aoA)) {
                if (TextUtils.isEmpty(aoA.cNQ)) {
                    a2 = this.cOX.a(aoC, aoA.cNS);
                } else {
                    SwanAppComponentContainerView mI = mI(aoA.cNQ);
                    if (mI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (mI.indexOfChild(aoC) >= 0) {
                        com.baidu.swan.apps.component.e.a.br("Component-Container", name + " repeat insert view!");
                        mI.removeView(aoC);
                    }
                    mI.addView(aoC, aoA.aoG());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, aoA, aoC);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.br("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cOY.put(aoA.cNO, aVar);
                if (aVar.hV(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cOZ.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cOZ.put(str, list);
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
            com.baidu.swan.apps.component.e.a.br("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aoA = aVar.aoA();
        String name = aVar.getName();
        SwanAppComponentContainerView aoC = aVar.aoC();
        if (aoC == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cOY.containsKey(aoA.cNO)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.hZ(7)) {
                boolean a2 = b.a(this, aVar, aoA, aoC, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.br("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.hZ(8)) {
                b.b(this, aVar, aoA, aoC, bVar);
            }
        }
        if (bVar.hZ(3) && !a(aVar, aoC, aoA)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.aot()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.aou()) {
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
            com.baidu.swan.apps.component.e.a.br("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b aoA = aVar.aoA();
        String str = aoA.cNN;
        String str2 = aoA.cNO;
        String name = aVar.getName();
        SwanAppComponentContainerView aoC = aVar.aoC();
        if (aoC == null) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(aoA)) {
                if (TextUtils.isEmpty(aoA.cNQ)) {
                    c = this.cOX.removeView(aoC);
                } else {
                    SwanAppComponentContainerView mI = mI(aoA.cNQ);
                    if (mI == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (mI == aoC.getParent()) {
                        mI.removeView(aoC);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.br("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, aoA, aoC);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.br("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.hV(1)) {
                this.cOY.remove(str2);
                if (aVar.hV(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cOZ.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cOY.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cOY.clear();
        this.cOZ.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cNS == null || !bVar.cNS.isValid()) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cNS == null ? "null" : bVar.cNS));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.br("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cNQ;
        if (TextUtils.isEmpty(str)) {
            return this.cOX.b(swanAppComponentContainerView, bVar.cNS);
        }
        SwanAppComponentContainerView mI = mI(str);
        if (mI == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == mI) {
            mI.updateViewLayout(swanAppComponentContainerView, bVar.aoG());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.br("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView mI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cOY.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.aoC();
    }
}
