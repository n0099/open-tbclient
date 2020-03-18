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
    com.baidu.swan.apps.view.b.a bjI;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bjJ = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bjK = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bjI = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KL = aVar.KL();
        String str = KL.biz;
        String str2 = KL.biA;
        String name = aVar.getName();
        SwanAppComponentContainerView KN = aVar.KN();
        if (KN == null) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bjJ.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (KL.biE == null) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!KL.biE.isValid()) {
                com.baidu.swan.apps.component.e.a.at("Component-Container", "insert " + name + " with a invalid position: " + (KL.biE == null ? "null" : KL.biE));
                KL.biE = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(KL)) {
                if (TextUtils.isEmpty(KL.biC)) {
                    a = this.bjI.a(KN, KL.biE);
                } else {
                    SwanAppComponentContainerView gv = gv(KL.biC);
                    if (gv == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (gv.indexOfChild(KN) >= 0) {
                        com.baidu.swan.apps.component.e.a.at("Component-Container", name + " repeat insert view!");
                        gv.removeView(KN);
                    }
                    gv.addView(KN, KL.KR());
                    a = true;
                }
            } else {
                a = b.a(this, KL, KN);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.at("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bjJ.put(KL.biA, aVar);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjK.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bjK.put(str, list);
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
            com.baidu.swan.apps.component.e.a.at("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KL = aVar.KL();
        String name = aVar.getName();
        SwanAppComponentContainerView KN = aVar.KN();
        if (KN == null) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bjJ.containsKey(KL.biA)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.ej(7)) {
                boolean a = b.a(this, aVar, KL, KN, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.at("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.ej(8)) {
                b.b(this, aVar, KL, KN, bVar);
            }
        }
        if (bVar.ej(3) && !a(aVar, KN, KL)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.KE()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.KF()) {
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
            com.baidu.swan.apps.component.e.a.at("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KL = aVar.KL();
        String str = KL.biz;
        String str2 = KL.biA;
        String name = aVar.getName();
        SwanAppComponentContainerView KN = aVar.KN();
        if (KN == null) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(KL)) {
                if (TextUtils.isEmpty(KL.biC)) {
                    c = this.bjI.au(KN);
                } else {
                    SwanAppComponentContainerView gv = gv(KL.biC);
                    if (gv == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (gv == KN.getParent()) {
                        gv.removeView(KN);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.at("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, KL, KN);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.at("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ef(1)) {
                this.bjJ.remove(str2);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjK.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bjJ.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bjJ.clear();
        this.bjK.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.biE == null || !bVar.biE.isValid()) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "insert " + name + " with a invalid position: " + (bVar.biE == null ? "null" : bVar.biE));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.at("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.biC;
        if (TextUtils.isEmpty(str)) {
            return this.bjI.b(swanAppComponentContainerView, bVar.biE);
        }
        SwanAppComponentContainerView gv = gv(str);
        if (gv == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == gv) {
            gv.updateViewLayout(swanAppComponentContainerView, bVar.KR());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.at("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView gv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bjJ.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.KN();
    }
}
