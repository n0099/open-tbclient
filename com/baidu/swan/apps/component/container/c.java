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
    com.baidu.swan.apps.view.b.a cER;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cES = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cET = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cER = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b akQ = aVar.akQ();
        String str = akQ.cDJ;
        String str2 = akQ.cDK;
        String name = aVar.getName();
        SwanAppComponentContainerView akS = aVar.akS();
        if (akS == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cES.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (akQ.cDO == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!akQ.cDO.isValid()) {
                com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a invalid position: " + (akQ.cDO == null ? "null" : akQ.cDO));
                akQ.cDO = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(akQ)) {
                if (TextUtils.isEmpty(akQ.cDM)) {
                    a2 = this.cER.a(akS, akQ.cDO);
                } else {
                    SwanAppComponentContainerView mo = mo(akQ.cDM);
                    if (mo == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (mo.indexOfChild(akS) >= 0) {
                        com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " repeat insert view!");
                        mo.removeView(akS);
                    }
                    mo.addView(akS, akQ.akW());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, akQ, akS);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cES.put(akQ.cDK, aVar);
                if (aVar.hH(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cET.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cET.put(str, list);
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
        com.baidu.swan.apps.component.b.b akQ = aVar.akQ();
        String name = aVar.getName();
        SwanAppComponentContainerView akS = aVar.akS();
        if (akS == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cES.containsKey(akQ.cDK)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.hL(7)) {
                boolean a2 = b.a(this, aVar, akQ, akS, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.hL(8)) {
                b.b(this, aVar, akQ, akS, bVar);
            }
        }
        if (bVar.hL(3) && !a(aVar, akS, akQ)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.akJ()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.akK()) {
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
        com.baidu.swan.apps.component.b.b akQ = aVar.akQ();
        String str = akQ.cDJ;
        String str2 = akQ.cDK;
        String name = aVar.getName();
        SwanAppComponentContainerView akS = aVar.akS();
        if (akS == null) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(akQ)) {
                if (TextUtils.isEmpty(akQ.cDM)) {
                    c = this.cER.removeView(akS);
                } else {
                    SwanAppComponentContainerView mo = mo(akQ.cDM);
                    if (mo == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (mo == akS.getParent()) {
                        mo.removeView(akS);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bm("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, akQ, akS);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.hH(1)) {
                this.cES.remove(str2);
                if (aVar.hH(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cET.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cES.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cES.clear();
        this.cET.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cDO == null || !bVar.cDO.isValid()) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cDO == null ? "null" : bVar.cDO));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cDM;
        if (TextUtils.isEmpty(str)) {
            return this.cER.b(swanAppComponentContainerView, bVar.cDO);
        }
        SwanAppComponentContainerView mo = mo(str);
        if (mo == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == mo) {
            mo.updateViewLayout(swanAppComponentContainerView, bVar.akW());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bm("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView mo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cES.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.akS();
    }
}
