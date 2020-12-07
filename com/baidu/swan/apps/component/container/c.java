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
/* loaded from: classes25.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a cKc;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> cKd = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> cKe = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.cKc = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a2;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b anq = aVar.anq();
        String str = anq.cIU;
        String str2 = anq.cIV;
        String name = aVar.getName();
        SwanAppComponentContainerView ans = aVar.ans();
        if (ans == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.cKd.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (anq.cIZ == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!anq.cIZ.isValid()) {
                com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert " + name + " with a invalid position: " + (anq.cIZ == null ? "null" : anq.cIZ));
                anq.cIZ = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(anq)) {
                if (TextUtils.isEmpty(anq.cIX)) {
                    a2 = this.cKc.a(ans, anq.cIZ);
                } else {
                    SwanAppComponentContainerView mP = mP(anq.cIX);
                    if (mP == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (mP.indexOfChild(ans) >= 0) {
                        com.baidu.swan.apps.component.e.a.bs("Component-Container", name + " repeat insert view!");
                        mP.removeView(ans);
                    }
                    mP.addView(ans, anq.anw());
                    a2 = true;
                }
            } else {
                a2 = b.a(this, anq, ans);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bs("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a2) {
                this.cKd.put(anq.cIV, aVar);
                if (aVar.ib(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cKe.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.cKe.put(str, list);
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
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b anq = aVar.anq();
        String name = aVar.getName();
        SwanAppComponentContainerView ans = aVar.ans();
        if (ans == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.cKd.containsKey(anq.cIV)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.m32if(7)) {
                boolean a2 = b.a(this, aVar, anq, ans, bVar);
                if (!a2) {
                    com.baidu.swan.apps.component.e.a.bs("Component-Container", name + " perform scroll type update fail");
                    return a2;
                }
                return a2;
            } else if (bVar.m32if(8)) {
                b.b(this, aVar, anq, ans, bVar);
            }
        }
        if (bVar.m32if(3) && !a(aVar, ans, anq)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.anj()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.ank()) {
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
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b anq = aVar.anq();
        String str = anq.cIU;
        String str2 = anq.cIV;
        String name = aVar.getName();
        SwanAppComponentContainerView ans = aVar.ans();
        if (ans == null) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(anq)) {
                if (TextUtils.isEmpty(anq.cIX)) {
                    c = this.cKc.removeView(ans);
                } else {
                    SwanAppComponentContainerView mP = mP(anq.cIX);
                    if (mP == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (mP == ans.getParent()) {
                        mP.removeView(ans);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.bs("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, anq, ans);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.bs("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ib(1)) {
                this.cKd.remove(str2);
                if (aVar.ib(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.cKe.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.cKd.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.cKd.clear();
        this.cKe.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.cIZ == null || !bVar.cIZ.isValid()) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "insert " + name + " with a invalid position: " + (bVar.cIZ == null ? "null" : bVar.cIZ));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.cIX;
        if (TextUtils.isEmpty(str)) {
            return this.cKc.b(swanAppComponentContainerView, bVar.cIZ);
        }
        SwanAppComponentContainerView mP = mP(str);
        if (mP == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == mP) {
            mP.updateViewLayout(swanAppComponentContainerView, bVar.anw());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.bs("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView mP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.cKd.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.ans();
    }
}
