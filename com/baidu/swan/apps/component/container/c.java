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
/* loaded from: classes7.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a bWs;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bWt = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bWu = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bWs = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b WW = aVar.WW();
        String str = WW.bVk;
        String str2 = WW.bVl;
        String name = aVar.getName();
        SwanAppComponentContainerView WY = aVar.WY();
        if (WY == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bWt.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (WW.bVp == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!WW.bVp.isValid()) {
                com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert " + name + " with a invalid position: " + (WW.bVp == null ? "null" : WW.bVp));
                WW.bVp = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(WW)) {
                if (TextUtils.isEmpty(WW.bVn)) {
                    a = this.bWs.a(WY, WW.bVp);
                } else {
                    SwanAppComponentContainerView ja = ja(WW.bVn);
                    if (ja == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (ja.indexOfChild(WY) >= 0) {
                        com.baidu.swan.apps.component.e.a.aV("Component-Container", name + " repeat insert view!");
                        ja.removeView(WY);
                    }
                    ja.addView(WY, WW.Xc());
                    a = true;
                }
            } else {
                a = b.a(this, WW, WY);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aV("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bWt.put(WW.bVl, aVar);
                if (aVar.eI(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bWu.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bWu.put(str, list);
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
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b WW = aVar.WW();
        String name = aVar.getName();
        SwanAppComponentContainerView WY = aVar.WY();
        if (WY == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bWt.containsKey(WW.bVl)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.eM(7)) {
                boolean a = b.a(this, aVar, WW, WY, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aV("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.eM(8)) {
                b.b(this, aVar, WW, WY, bVar);
            }
        }
        if (bVar.eM(3) && !a(aVar, WY, WW)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.WP()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.WQ()) {
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
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b WW = aVar.WW();
        String str = WW.bVk;
        String str2 = WW.bVl;
        String name = aVar.getName();
        SwanAppComponentContainerView WY = aVar.WY();
        if (WY == null) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(WW)) {
                if (TextUtils.isEmpty(WW.bVn)) {
                    c = this.bWs.ay(WY);
                } else {
                    SwanAppComponentContainerView ja = ja(WW.bVn);
                    if (ja == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (ja == WY.getParent()) {
                        ja.removeView(WY);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aV("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, WW, WY);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aV("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.eI(1)) {
                this.bWt.remove(str2);
                if (aVar.eI(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bWu.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bWt.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bWt.clear();
        this.bWu.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bVp == null || !bVar.bVp.isValid()) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bVp == null ? "null" : bVar.bVp));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bVn;
        if (TextUtils.isEmpty(str)) {
            return this.bWs.b(swanAppComponentContainerView, bVar.bVp);
        }
        SwanAppComponentContainerView ja = ja(str);
        if (ja == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == ja) {
            ja.updateViewLayout(swanAppComponentContainerView, bVar.Xc());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.aV("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView ja(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bWt.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.WY();
    }
}
